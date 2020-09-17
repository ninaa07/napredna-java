import { Component, OnInit, Input } from '@angular/core';
import { ProjekatZaGradjevinskuDozvolu } from 'src/app/models/projekat-za-gradjevinsku-dozvolu.model';
import { ProjekatZaGradjevinskuDozvoluService } from 'src/app/services/projekat-za-gradjevinsku-dozvolu.service';
import { MatDialog } from '@angular/material/dialog';
import { AlertService } from 'src/app/services/alert.service';
import { ConfirmDialog } from '../confirm/confirm.dialog';
import { ProjekatZaGradjevinskuDozvoluDialog } from './projekat-za-gradjevinsku-dozvolu-dialog/projekat-za-gradjevinsku-dozvolu.dialog';
import { IdejnoResenje } from 'src/app/models/idejno-resenje.model';
import { IdejnoResenjeService } from 'src/app/services/idejno-resenje.service';
import { VrstaPovrsineService } from 'src/app/services/vrsta-povrsine.service';
import { VrstaPovrsine } from 'src/app/models/vrsta-povrsine.model';

@Component({
  selector: 'projekat-za-gradjevinsku-dozvolu',
  templateUrl: './projekat-za-gradjevinsku-dozvolu.component.html',
  styleUrls: ['./projekat-za-gradjevinsku-dozvolu.component.scss']
})
export class ProjekatZaGradjevinskuDozvoluComponent implements OnInit {

  projektiZaGD: ProjekatZaGradjevinskuDozvolu[];
  idejnaResenja: IdejnoResenje[];
  vrstePovrsina: VrstaPovrsine[];

  constructor(
    private projekatZaGradjevinskuDozvoluService: ProjekatZaGradjevinskuDozvoluService,
    private dialog: MatDialog,
    private alert: AlertService,
    private idejnoResenjeService: IdejnoResenjeService,
    private vrstaPovrsineService: VrstaPovrsineService
  ) { }

  ngOnInit() {
    this.getAll();

    this.idejnoResenjeService.getAll().subscribe(result => {
      this.idejnaResenja = result;
    }, error => {
      this.alert.errorHandler(error);
    });

    this.vrstaPovrsineService.getAll().subscribe(result => {
      this.vrstePovrsina = result;
    }, error => {
      this.alert.errorHandler(error);
    });
  }

  getAll(): void {
    this.projekatZaGradjevinskuDozvoluService.getAll().subscribe(result => {
      if (result) {
        this.projektiZaGD = result;
      }
    }, error => {
      this.alert.errorHandler(error);
    });
  }

  open(id: number): void {
    this.projekatZaGradjevinskuDozvoluService.getById(id).subscribe(result => {

      const dialogRef = this.dialog.open(ProjekatZaGradjevinskuDozvoluDialog, {
        width: '900px',
        data: {
          projekatZaGD: result,
          vrstePovrsina: this.vrstePovrsina,
          action: 'view',
          title: 'Pregled projekta za građevinsku dozvolu',
          idejnaResenja: this.idejnaResenja
        },
        autoFocus: true,
        disableClose: true
      });

    }, error => {
      this.alert.errorHandler(error);
    });
  }

  add(): void {
    const dialogRef = this.dialog.open(ProjekatZaGradjevinskuDozvoluDialog, {
      width: '900px',
      data: {
        action: 'add',
        title: 'Unos površina i kreiranje projekta za građevinsku dozvolu',
        vrstePovrsina: this.vrstePovrsina,
        idejnaResenja: this.idejnaResenja
      },
      autoFocus: true,
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.projektiZaGD.push(result);
      }
    });
  }

  edit(pgd: ProjekatZaGradjevinskuDozvolu): void {

    const dialogRef = this.dialog.open(ProjekatZaGradjevinskuDozvoluDialog, {
      width: '900px',
      autoFocus: true,
      data: {
        projekatZaGD: pgd,
        vrstePovrsina: this.vrstePovrsina,
        idejnaResenja: this.idejnaResenja,
        action: 'edit',
        title: 'Izmena površina i projekta za građevinsku dozvolu'
      },
      disableClose: true
    });
  }

  delete(id: number): void {

    const confirmDialog = this.dialog.open(ConfirmDialog, {
      disableClose: true,
      autoFocus: true,
      data: { title: 'projekat za građevinsku dozvolu' }
    });

    confirmDialog.afterClosed().subscribe(response => {
      if (response) {
        this.projekatZaGradjevinskuDozvoluService.delete(id).subscribe(result => {
          if (result) {
            this.alert.showSuccess(result.message, 'Success');
            const item = this.projektiZaGD.find(x => x.id === result.resultObject.id);
            this.projektiZaGD.splice(this.projektiZaGD.indexOf(item), 1);
          }
        }, error => {
          this.alert.errorHandler(error);
        });
      }
    });
  }

}
