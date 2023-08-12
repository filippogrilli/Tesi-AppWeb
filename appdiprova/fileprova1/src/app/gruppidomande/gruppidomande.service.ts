import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { GruppidomandeComponent } from './gruppidomande.component';

@Injectable({
    providedIn: 'root'
})
export class DomandeService {
  constructor(private httpClient: HttpClient) { }

  getDomande(){
    return this.httpClient.get('http://localhost:8080/scl_modelVersion'); 
  }

  callingFromTemplate(){
    console.log('Calling From Template Directly');
  }

  deleteGruppo(id: number){ //nel tutorial non usa :any
    const httpHeaders = new HttpHeaders();
    httpHeaders.append('content-type', 'application/json');
    console.log(id);
    return this.httpClient.delete(`http://localhost:8080/scl_modelGrouping/${id}`) 
    
    //return this.httpClient.post('http://localhost:8080/scl_model/', createResource)
  }
}
