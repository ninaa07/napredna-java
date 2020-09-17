import { Component, OnInit, Inject, ChangeDetectorRef } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AlertService } from 'src/app/services/alert.service';
import { ProjekatZaGradjevinskuDozvoluService } from 'src/app/services/projekat-za-gradjevinsku-dozvolu.service';
import { ProjekatZaGradjevinskuDozvolu, STATUSIDOKUMENTA, StatusDokumenta } from 'src/app/models/projekat-za-gradjevinsku-dozvolu.model';
import { StatusDokumentaPipe } from 'src/app/pipes/status-dokumenta.pipe';
import { IdejnoResenje } from 'src/app/models/idejno-resenje.model';
import { GlavniProjektantService } from 'src/app/services/glavni-projektant.service';
import { MatTableDataSource } from '@angular/material/table';
import { Povrsina, Status } from 'src/app/models/povrsina.model';
import { VrstaPovrsine } from 'src/app/models/vrsta-povrsine.model';
import { Prostorija } from 'src/app/models/prostorija.model';

@Component({
  selector: 'projekat-za-gradjevinsku-dozvolu-dialog',
  templateUrl: './projekat-za-gradjevinsku-dozvolu.dialog.html',
  styleUrls: ['./projekat-za-gradjevinsku-dozvolu.dialog.scss']
})
export class ProjekatZaGradjevinskuDozvoluDialog implements OnInit {

  pgd: ProjekatZaGradjevinskuDozvolu;
  datumIzrade: Date;
  statusi = STATUSIDOKUMENTA;
  status = 'Status dokumenta';
  nazivProjektanta: string;
  idejnaResenja: IdejnoResenje[];
  vrstePovrsina: VrstaPovrsine[];
  selectedIr = 'Idejno resenje';
  disabledBtn = false;
  povrsinaRes: Povrsina;

  dataSource: MatTableDataSource<Povrsina>;
  displayedColumns: string[] = ['NazivPovrsine', 'Oznaka', 'VrstaPoda', 'VrstaPovrsine', 'Prostorija', 'Izmeni', 'Obrisi'];

  constructor(private projekatZaGradjevinskuDozvoluService: ProjekatZaGradjevinskuDozvoluService,
    private dialogRef: MatDialogRef<ProjekatZaGradjevinskuDozvoluDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private statusDokumentaPipe: StatusDokumentaPipe,
    private alert: AlertService,
    private glavniProjektantService: GlavniProjektantService
  ) {
    this.dataSource = new MatTableDataSource<Povrsina>();
  }

  ngOnInit(): void {
    this.pgd = this.data.projekatZaGD ? this.data.projekatZaGD : new ProjekatZaGradjevinskuDozvolu();
    this.idejnaResenja = this.data.idejnaResenja;
    this.vrstePovrsina = this.data.vrstePovrsina;

    if (this.data.action === 'view' || this.data.action === 'edit') {

      this.datumIzrade = this.pgd.datumIzrade;

      if (this.pgd.idejnoResenjeId) {
        const ir = this.idejnaResenja.find(x => x.id === this.pgd.idejnoResenjeId);
        this.selectedIr = ir.naziv;
        this.setNazivGlavnogProjektanta(ir);
      }

      this.pgd.povrsine.forEach(element => {
        element.status = Status.None;
        element.isEditable = false;

        if (!element.vrstaPovrsine) {
          const vp = this.vrstePovrsina.find(x => x.id === element.vrstaPovrsineId);
          element.vrstaPovrsine = vp;
        }
      });
    } else {
      this.pgd.povrsine = new Array();
      this.pgd.statusDokumenta = StatusDokumenta.Nov;
      this.datumIzrade = new Date();
    }
    this.dataSource.data = this.pgd.povrsine;
  }

  save() {
    if (!this.validate()) {
      return;
    }

    if (!this.pgd.id) {

      this.pgd.nazivIdejnogResenja = this.selectedIr;

      this.projekatZaGradjevinskuDozvoluService.add(this.pgd).subscribe(result => {
        if (result.success) {
          this.alert.showSuccess(result.message, 'Success');
          this.dialogRef.close(result.resultObject);
        }
      }, error => {
        this.alert.errorHandler(error);
      });
    } else {
      this.projekatZaGradjevinskuDozvoluService.update(this.pgd, this.pgd.id).subscribe(result => {
        if (result.success) {
          this.alert.showSuccess(result.message, 'Success');
          this.dialogRef.close(result.resultObject);
        }
      }, error => {
        this.alert.errorHandler(error);
      });
    }
  }

  setNazivGlavnogProjektanta(ir: IdejnoResenje) {
    this.glavniProjektantService.getById(ir.glavniProjektantId).subscribe(result => {
      if (result) {
        this.nazivProjektanta = result.imePrezime;
        this.selectedIr = ir.naziv;
      }
    });
  }

  changeSelection(id: number) {
    this.pgd.statusDokumenta = id;
    this.status = this.statusDokumentaPipe.transform(id);
  }

  changeSelectionIr(ir: IdejnoResenje) {
    this.pgd.idejnoResenjeId = ir.id;
    this.pgd.nazivIdejnogResenja = ir.naziv;
    this.selectedIr = ir.naziv;

    this.setNazivGlavnogProjektanta(ir);
  }

  changeSelectionVp(vp: VrstaPovrsine, p: Povrsina) {
    p.vrstaPovrsine = vp;
    p.vrstaPovrsineId = vp.id;
  }

  changeSelectionP(pr: Prostorija, p: Povrsina) {
    p.prostorijaNaziv = pr.naziv;
  }

  add() {
    const p = new Povrsina();
    this.disabledBtn = true;
    p.isEditable = true;
    this.pgd.povrsine.push(p);
    this.dataSource.data = this.pgd.povrsine;
  }

  edit(p: Povrsina) {
    this.disabledBtn = true;
    p.isEditable = true;
    this.povrsinaRes = p;
  }

  delete(p: Povrsina) {
    p.status = Status.Delete;
    this.pgd.povrsine.splice(this.pgd.povrsine.indexOf(p), 1);
    this.dataSource.data = this.pgd.povrsine;
  }

  saveElement(p: Povrsina) {

    if (!this.validateElement(p)) {
      return;
    }

    p.isEditable = false;
    this.disabledBtn = false;
    if (p.id === undefined) {
      p.status = Status.Insert;
    } else {
      p.status = Status.Update;
    }
  }

  resetFields(p: Povrsina) {
    if (!p.naziv && !p.oznaka && !p.vrstaPoda && !p.vrstaPovrsine && !p.prostorijaNaziv) {
      this.delete(p);
    }

    p.naziv = null;
    p.oznaka = null;
    p.vrstaPoda = null;
    p.vrstaPovrsine = null;
    p.prostorijaNaziv = null;
  }

  validate() {
    if (!this.pgd.naziv) {
      this.alert.showError('Neispravno uneti podaci', 'Error');
      return false;
    }

    return true;
  }

  validateElement(p: Povrsina) {
    if (!p.naziv || !p.oznaka || !p.vrstaPoda || !p.vrstaPovrsine) {
      this.alert.showError('Neispravno uneti podaci o površini', 'Error');
      return false;
    }

    return true;
  }

  close() {
    this.dialogRef.close(false);
  }
}