import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { GlavniProjektant } from '../models/glavni-projektant.model';
import { Observable } from 'rxjs';
import { ServiceResult } from '../models/service-result.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Response-Type': 'text' })
};

@Injectable({
  providedIn: 'root'
})

export class GlavniProjektantService {

  url = 'https://localhost:44306/api/glavniProjektanti/';

  constructor(private http: HttpClient) { }

  getAll(): Observable<GlavniProjektant[]> {
    return this.http.get<GlavniProjektant[]>(this.url);
  }

  getById(id: number): Observable<GlavniProjektant> {
    return this.http.get<GlavniProjektant>(this.url + `${id}`);
  }

  add(glavniProjektant: GlavniProjektant): Observable<ServiceResult> {
    return this.http.post<ServiceResult>(this.url, glavniProjektant, httpOptions);
  }

  update(glavniProjektant: GlavniProjektant, id: number): Observable<ServiceResult> {
    return this.http.put<ServiceResult>(this.url + `${id}`, glavniProjektant, httpOptions);
  }

  delete(id: number): Observable<ServiceResult> {
    return this.http.delete<ServiceResult>(this.url + `${id}`, httpOptions);
  }
}
