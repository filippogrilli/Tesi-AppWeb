/*import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ScaledivalutazioneService {
  constructor(private httpClient: HttpClient) { }

  getScale(){
    return this.httpClient.get('http://localhost:8080/scl_model'); 
  }

  callingFromTemplate(){
    console.log('Calling From Template Directly');
  }

  createScale(createResource: any){ //nel tutorial non usa :any
    return this.httpClient.post('http://localhost:8080/scl_model', createResource)
  }
}*/