import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';
import { VrstaPovrsine } from '../models/vrsta-povrsine.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
    providedIn: 'root'
})

export class VrstaPovrsineService {

    url = 'https://localhost:44306/api/vrstePovrsina/';

    constructor(private http: HttpClient) { }

    getAll(): Observable<VrstaPovrsine[]> {
        return this.http.get<VrstaPovrsine[]>(this.url);
    }

    getById(id: number): Observable<VrstaPovrsine> {
        return this.http.get<VrstaPovrsine>(this.url + `${id}`);
    }

    add(vrstaPovrsine: VrstaPovrsine): Observable<ServiceResult> {
        return this.http.post<ServiceResult>(this.url, vrstaPovrsine, httpOptions);
    }

    update(vrstaPovrsine: VrstaPovrsine, id: number): Observable<ServiceResult> {
        return this.http.put<ServiceResult>(this.url + `${id}`, vrstaPovrsine, httpOptions);
    }

    delete(id: number): Observable<ServiceResult> {
        return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
    }
}
