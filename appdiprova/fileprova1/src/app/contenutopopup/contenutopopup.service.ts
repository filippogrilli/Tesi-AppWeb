import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ScaledivalutazioneService {
    url = 'http://localhost:8080/scl_model';
  constructor(private httpClient: HttpClient) { }

  /*users() {
    return this.httpClient.get(this.url);
  }

  saveUser(data:any){
    return this.httpClient.post(this.url,data);
  }*/

  createScale(createResource: any){ //nel tutorial non usa :any

    const httpHeaders = new HttpHeaders();
    httpHeaders.append('content-type', 'application/json');
    return this.httpClient.post<number>('http://localhost:8080/scl_model', createResource, {headers: httpHeaders})
    //return this.httpClient.post('http://localhost:8080/scl_model', createResource)
  }
  
   createVersion(createResource: any, id: number){ //nel tutorial non usa :any

    const httpHeaders = new HttpHeaders();
    httpHeaders.append('content-type', 'application/json');
    return this.httpClient.post(`http://localhost:8080/scl_modelVersion/${id}`, createResource, {headers: httpHeaders}) 
    //return this.httpClient.post('http://localhost:8080/scl_model/', createResource)
  }
    
}