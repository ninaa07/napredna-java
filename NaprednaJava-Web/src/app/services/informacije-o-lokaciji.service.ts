import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';
import { InformacijeOLokaciji } from '../models/informacije-o-lokaciji.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
    providedIn: 'root'
})

export class InformacijeOLokacijiService {

    url = 'https://localhost:44306/api/informacijeOLokaciji/';

    constructor(private http: HttpClient) { }

    getAll(): Observable<InformacijeOLokaciji[]> {
        return this.http.get<InformacijeOLokaciji[]>(this.url);
    }

    getById(id: number): Observable<InformacijeOLokaciji> {
        return this.http.get<InformacijeOLokaciji>(this.url + `${id}`);
    }

    add(informacijeOLokaciji: InformacijeOLokaciji): Observable<ServiceResult> {
        return this.http.post<ServiceResult>(this.url, informacijeOLokaciji, httpOptions);
    }

    update(informacijeOLokaciji: InformacijeOLokaciji, id: number): Observable<ServiceResult> {
        return this.http.put<ServiceResult>(this.url + `${id}`, informacijeOLokaciji, httpOptions);
    }

    delete(id: number): Observable<ServiceResult> {
        return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
    }
}
