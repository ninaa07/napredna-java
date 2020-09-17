import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';
import { Povrsina } from '../models/povrsina.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
    providedIn: 'root'
})

export class PovrsinaService {

    url = 'https://localhost:44306/api/povrsine/';

    constructor(private http: HttpClient) { }

    getAll(): Observable<Povrsina[]> {
        return this.http.get<Povrsina[]>(this.url);
    }

    getById(id: number): Observable<Povrsina> {
        return this.http.get<Povrsina>(this.url + `${id}`);
    }

    add(povrsina: Povrsina): Observable<ServiceResult> {
        return this.http.post<ServiceResult>(this.url, povrsina, httpOptions);
    }

    update(povrsina: Povrsina, id: number): Observable<ServiceResult> {
        return this.http.put<ServiceResult>(this.url + `${id}`, povrsina, httpOptions);
    }

    delete(id: number): Observable<ServiceResult> {
        return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
    }
}
