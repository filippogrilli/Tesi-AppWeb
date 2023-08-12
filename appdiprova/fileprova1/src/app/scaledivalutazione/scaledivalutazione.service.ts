import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ScaledivalutazioneComponent } from './scaledivalutazione.component';

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
}
