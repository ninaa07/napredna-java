import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';
import { ProjekatZaGradjevinskuDozvolu, StatusDokumenta } from '../models/projekat-za-gradjevinsku-dozvolu.model';
import { Povrsina, Status } from '../models/povrsina.model';
import { PovrsinaService } from './povrsina.service';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
    providedIn: 'root'
})

export class ProjekatZaGradjevinskuDozvoluService {

    url = 'https://localhost:44306/api/projektiZaGradjevinskuDozvolu/';

    constructor(
        private http: HttpClient,
        private povrsinaService: PovrsinaService,
    ) { }

    getAll(): Observable<ProjekatZaGradjevinskuDozvolu[]> {
        return this.http.get<ProjekatZaGradjevinskuDozvolu[]>(this.url);
    }

    getById(id: number): Observable<ProjekatZaGradjevinskuDozvolu> {
        return this.http.get<ProjekatZaGradjevinskuDozvolu>(this.url + `${id}`);
    }

    add(projekatZaGradjevinskuDozvolu: ProjekatZaGradjevinskuDozvolu): Observable<ServiceResult> {
        this.updatePovrsineList(projekatZaGradjevinskuDozvolu.povrsine);
        projekatZaGradjevinskuDozvolu.statusDokumenta = StatusDokumenta.Kreiran;
        return this.http.post<ServiceResult>(this.url, projekatZaGradjevinskuDozvolu, httpOptions);
    }

    update(projekatZaGradjevinskuDozvolu: ProjekatZaGradjevinskuDozvolu, id: number): Observable<ServiceResult> {
        this.updatePovrsineList(projekatZaGradjevinskuDozvolu.povrsine);
        projekatZaGradjevinskuDozvolu.statusDokumenta = StatusDokumenta.Obradjen;
        return this.http.put<ServiceResult>(this.url + `${id}`, projekatZaGradjevinskuDozvolu, httpOptions);
    }

    delete(id: number): Observable<ServiceResult> {
        return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
    }

    updatePovrsineList(povrsine: Povrsina[]) {
        povrsine.forEach(element => {
            if (element.status === Status.Insert) {
                this.povrsinaService.add(element);
            } else if (element.status === Status.Update) {
                this.povrsinaService.update(element, element.id);
            } else if (element.status === Status.Delete) {
                this.povrsinaService.delete(element.id);
            }
        });
    }
}
