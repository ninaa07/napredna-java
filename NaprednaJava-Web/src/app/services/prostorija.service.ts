import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';
import { Prostorija } from '../models/prostorija.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
    providedIn: 'root'
})

export class ProstorijaService {

    url = 'https://localhost:44306/api/prostorije/';

    constructor(private http: HttpClient) { }

    getAll(): Observable<Prostorija[]> {
        return this.http.get<Prostorija[]>(this.url);
    }

    getById(id: number): Observable<Prostorija> {
        return this.http.get<Prostorija>(this.url + `${id}`);
    }

    add(prostorija: Prostorija): Observable<ServiceResult> {
        return this.http.post<ServiceResult>(this.url, prostorija, httpOptions);
    }

    update(prostorija: Prostorija, id: number): Observable<ServiceResult> {
        return this.http.put<ServiceResult>(this.url + `${id}`, prostorija, httpOptions);
    }

    delete(id: number): Observable<ServiceResult> {
        return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
    }
}
