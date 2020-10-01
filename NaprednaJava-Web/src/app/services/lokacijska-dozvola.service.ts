import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';
import { LokacijskaDozvola } from '../models/lokacijska-dozvola.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
    providedIn: 'root'
})

export class LokacijskaDozvolaService {

    url = 'http://localhost:8080/api/lokacijskeDozvole/';

    constructor(private http: HttpClient) { }

    getAll(): Observable<LokacijskaDozvola[]> {
        return this.http.get<LokacijskaDozvola[]>(this.url);
    }

    getById(id: number): Observable<ServiceResult> {
        return this.http.get<ServiceResult>(this.url + `${id}`);
    }

    add(lokacijskaDozvola: LokacijskaDozvola): Observable<ServiceResult> {
        return this.http.post<ServiceResult>(this.url, lokacijskaDozvola, httpOptions);
    }

    update(lokacijskaDozvola: LokacijskaDozvola, id: number): Observable<ServiceResult> {
        return this.http.put<ServiceResult>(this.url + `${id}`, lokacijskaDozvola, httpOptions);
    }

    delete(id: number): Observable<ServiceResult> {
        return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
    }
}
