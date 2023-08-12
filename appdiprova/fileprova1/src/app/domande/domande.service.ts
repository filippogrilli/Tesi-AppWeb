import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { DomandeComponent } from './domande.component';

@Injectable({
    providedIn: 'root'
})
export class DomandeService {
  constructor(private httpClient: HttpClient) { }

  getDomande(){
    return this.httpClient.get('http://localhost:8080/scl_modelVersion');   //DUBBIO che sia version o che venga usato
  }

  callingFromTemplate(){
    console.log('Calling From Template Directly');
  }

  deleteDomanda(id: number){ //nel tutorial non usa :any
    const httpHeaders = new HttpHeaders();
    httpHeaders.append('content-type', 'application/json');
    console.log(id);
    return this.httpClient.delete(`http://localhost:8080/scl_modelQuestion/${id}`) //richiesta effettuata nel modo errato
    
    //return this.httpClient.post('http://localhost:8080/scl_model/', createResource)
  }

  deleteRisposta(id: number){ //nel tutorial non usa :any
    const httpHeaders = new HttpHeaders();
    httpHeaders.append('content-type', 'application/json');
    console.log(id);
    return this.httpClient.delete(`http://localhost:8080/scl_modelAnswer/${id}`) //richiesta effettuata nel modo errato
    
    //return this.httpClient.post('http://localhost:8080/scl_model/', createResource)
  }
}
