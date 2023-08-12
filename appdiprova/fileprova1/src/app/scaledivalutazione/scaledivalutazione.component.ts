import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
//import { ScaledivalutazioneService } from './scaledivalutazione.service';

export interface Version {
  sv_id:number
}

@Component({
  selector: 'app-scaledivalutazione',
  templateUrl: './scaledivalutazione.component.html',
  styleUrls: ['./scaledivalutazione.component.css']
})


export class ScaledivalutazioneComponent implements OnInit {

  //constructor(public scaledivalutazioneService: ScaledivalutazioneService) { }
  constructor(public http: HttpClient) { }
  sm_id: any;
  scaledivalutazioneList: any;
  ngOnInit(): void {
    /*this.scaledivalutazioneList = this.scaledivalutazioneService.getScale().subscribe(data => {
      this.scaledivalutazioneList = data;
    })*/
    this.loadScale()
  }

  loadScale(): void {
    this.http.get('http://localhost:8080/scl_model').subscribe(res => {
      console.log(res);
      this.scaledivalutazioneList = res;
    })
  }

  



  /*addScale(): void {
    this.scaledivalutazione.service
      .addScale(newScale)
      .subscribe()
  }*/

}
