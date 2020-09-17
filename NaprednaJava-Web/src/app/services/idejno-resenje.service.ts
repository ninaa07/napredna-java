import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';
import { IdejnoResenje } from '../models/idejno-resenje.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
    providedIn: 'root'
})

export class IdejnoResenjeService {

    url = 'https://localhost:44306/api/idejnaResenja/';

    constructor(private http: HttpClient) { }

    getAll(): Observable<IdejnoResenje[]> {
        return this.http.get<IdejnoResenje[]>(this.url);
    }

    getById(id: number): Observable<IdejnoResenje> {
        return this.http.get<IdejnoResenje>(this.url + `${id}`);
    }

    add(idejnoResenje: IdejnoResenje): Observable<ServiceResult> {
        return this.http.post<ServiceResult>(this.url, idejnoResenje, httpOptions);
    }

    update(idejnoResenje: IdejnoResenje, id: number): Observable<ServiceResult> {
        return this.http.put<ServiceResult>(this.url + `${id}`, idejnoResenje, httpOptions);
    }

    delete(id: number): Observable<ServiceResult> {
        return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
    }
}
