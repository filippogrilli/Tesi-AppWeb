import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { InsgruppoComponent } from '../insgruppo/insgruppo.component';
import { DomandeService } from './gruppidomande.service';


export interface Grouping {
  //description: String //inserisci campi che ti servono
  header: String
  id: number
}

export interface Version {
  modelGrouping: Array<Grouping>
  id: number
  modelVersion: number
}

@Component({
  selector: 'app-gruppidomande',
  templateUrl: './gruppidomande.component.html',
  styleUrls: ['./gruppidomande.component.css']
})

export class GruppidomandeComponent implements OnInit {

  constructor(public http: HttpClient, private route: ActivatedRoute, private dialogRef: MatDialog, private service: DomandeService) { 
    this.gruppidomandeList = Array();
  }
  gruppidomandeList: Array<Grouping>;
  scaledivalutazioneVersionList: any;
  name: any;
  sm_id: any;
  sg_id: any;
  version: any;

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => 
      {   
        //console.log(params);  
        this.name = params['name'];
        //console.log(this.name);
        //this.sg_id = this.loadVersion();  
        //this.loadGruppidomande();
        this.loadVersionGrouping();
      });
    
  }

  /*loadGruppidomande(): void {
    this.http.get<Version>(`http://localhost:8080/scl_modelGrouping/${this.name}`).subscribe(res => {
        console.log(res);


        for (let group of res["modelGrouping"]) {
          this.gruppidomandeList.push(group);
        }
        console.log(this.gruppidomandeList);  
    }, 
    err => {
      console.error(err.error.message);
    })
    
  }*/
  
  loadVersionGrouping(): void {
    //console.log(this.name);
    this.http.get<Version>(`http://localhost:8080/scl_modelVersion/${this.name}`).subscribe((res: Version) => {
      //console.log("res:", res);
      //console.log(this.scaledivalutazioneVersionList);
      this.scaledivalutazioneVersionList = res;      
      //console.log(res.id);
      //console.log(this.name);
      if(res == null)
      {
        return;
      }

      this.http.get<Array<Grouping>>(`http://localhost:8080/scl_modelGrouping/${res.id}`).subscribe((res2: Array<any>) => {
        //console.log(this.gruppidomandeList);  
        //this.gruppidomandeList.push();
        //console.log(res.id);
        for (let group of res2) {
          this.gruppidomandeList.push(group);
        }
      }, 
      err => {
        console.error(err.error.message);
      })
    }, 
    err => {
      console.error(err.error.message);
    })
  }

  openDialog(){
    // Qua devo passare i dati che voglio trovare in pop-up
    this.dialogRef.open(InsgruppoComponent,  {
      data:{ sm_id: this.name }
    })
  }   
  
  rimuovi(sg_id: any){
    // Qua devo passare i dati che voglio trovare in pop-up
    this.service.deleteGruppo(sg_id).subscribe((sg_id) => {
      console.log(sg_id);
    }
  )}

}
