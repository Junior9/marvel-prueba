import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class SincronizaService {

  private URL = "http://localhost:8080/";
  constructor(private http:HttpClient) { }

  getSincronizaciones(){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    //return this.http.get(this.URL+"marvel/characters",httpOptions);
    return this.http.get(this.URL+"history",httpOptions);
  }

  sincronizar(dato:any){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };

    return this.http.post(this.URL+"sincroniza",dato,httpOptions);
  }

  setDatosPrueba(){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(this.URL+"marvel/prueba",httpOptions);
  }

  agendar(){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(this.URL+"agenda",httpOptions);
  }
}
