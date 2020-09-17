import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';
import { Objekat } from '../models/objekat.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
    providedIn: 'root'
})

export class ObjekatService {

    url = 'https://localhost:44306/api/objekti/';

    constructor(private http: HttpClient) { }

    getAll(): Observable<Objekat[]> {
        return this.http.get<Objekat[]>(this.url);
    }

    getById(id: number): Observable<Objekat> {
        return this.http.get<Objekat>(this.url + `${id}`);
    }

    add(objekat: Objekat): Observable<ServiceResult> {
        return this.http.post<ServiceResult>(this.url, objekat, httpOptions);
    }

    update(objekat: Objekat, id: number): Observable<ServiceResult> {
        return this.http.put<ServiceResult>(this.url + `${id}`, objekat, httpOptions);
    }

    delete(id: number): Observable<ServiceResult> {
        return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
    }
}
