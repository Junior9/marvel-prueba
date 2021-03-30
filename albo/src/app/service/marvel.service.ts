import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MarvelService {

  private URL = "https://gateway.marvel.com:443/v1/public/";
  constructor(private http:HttpClient) { }

  getCharacters(){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(this.URL+"characters?limit=99&ts=1&apikey=7c16b76e14c2042d518fbcc34b032139&hash=b3d0b25a391058bd6ebdc71b206c2fab",httpOptions);
  }

  getComics(){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(this.URL+"comics?limit=99&ts=1&apikey=7c16b76e14c2042d518fbcc34b032139&hash=b3d0b25a391058bd6ebdc71b206c2fab",httpOptions);
  }

  getCreators(){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(this.URL+"creators?limit=99&ts=1&apikey=7c16b76e14c2042d518fbcc34b032139&hash=b3d0b25a391058bd6ebdc71b206c2fab",httpOptions);
  }


  getCharactersById(id:string){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(this.URL+"characters/"+ id +"?ts=1&apikey=7c16b76e14c2042d518fbcc34b032139&hash=b3d0b25a391058bd6ebdc71b206c2fab",httpOptions);
  }

  getComicsByCharacterId(id:string){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(this.URL+"characters/"+ id +"/comics?ts=1&apikey=7c16b76e14c2042d518fbcc34b032139&hash=b3d0b25a391058bd6ebdc71b206c2fab",httpOptions);

  }

  getComicById(id){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(this.URL+"comics/"+ id +"?ts=1&apikey=7c16b76e14c2042d518fbcc34b032139&hash=b3d0b25a391058bd6ebdc71b206c2fab",httpOptions);

  }

  getCreatorByLink(url:string){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get(url +"?ts=1&apikey=7c16b76e14c2042d518fbcc34b032139&hash=b3d0b25a391058bd6ebdc71b206c2fab",httpOptions);

  }


  getColaboaratorsByCharacterName(name:string){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get("http://localhost:8080/marvel/colaborators/"+name,httpOptions);
  }

  getCharacteresInteractionByCharacterName(name:string){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get("http://localhost:8080/marvel/characters/"+name,httpOptions);
  }

  getCharacterByDataBase(){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'  
      })
    };
    return this.http.get("http://localhost:8080//marvel/characters",httpOptions);
  }




}