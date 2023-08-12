import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ScaledivalutazioneService2 {
    url = 'http://localhost:8080/scl_modelAnswer';
  constructor(private httpClient: HttpClient) { }
  
   createRisposta(createResource: any, id: number){ //nel tutorial non usa :any

    const httpHeaders = new HttpHeaders();
    httpHeaders.append('content-type', 'application/json');
    return this.httpClient.post(`http://localhost:8080/scl_modelAnswer/${id}`, createResource, {headers: httpHeaders}) //non so come passare l'id
    //return this.httpClient.post('http://localhost:8080/scl_model/', createResource)
  }
    
}