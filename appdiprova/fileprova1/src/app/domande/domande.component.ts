import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { InsdomandaComponent } from '../insdomanda/insdomanda.component';
import { InsrispostaComponent } from '../insrisposta/insrisposta.component';
import { MatDialog } from '@angular/material/dialog';
//import {Component, ViewChild} from '@angular/core';
import {MatAccordion} from '@angular/material/expansion';
import { DomandeService } from './domande.service';

export interface Version {
  modelGrouping: Array<Grouping>,
}

export interface Grouping {
  modelQuestions: Array<modelQuestion>,
}
export interface Question {
  modelAnswer: Array<modelAnswer>,
}

export interface modelQuestion {
  text: String,
  header: String,
  id: Number   
}

export interface modelAnswer{
  text: String //non so se ci va text  o solo text
  id: Number
}


@Component({
  selector: 'app-domande',
  templateUrl: './domande.component.html',
  styleUrls: ['./domande.component.css']
})


export class DomandeComponent implements OnInit {

  constructor(public http: HttpClient, private route: ActivatedRoute, private dialogRef: MatDialog, private service: DomandeService, private router: Router) { 
    this.domandeList = Array();
    this.risposteList = Array();
  }
  //@ViewChild(MatAccordion)
  //accordion: MatAccordion = new MatAccordion;
  panelOpenState = false;
  domandeList: Array<modelQuestion>;
  risposteList: Array<modelAnswer>;
  name2: any;
  name: any;
  sm_id: any;
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => 
      {   
        //console.log(params);  
        this.name2 = params['name2'];
        this.name = params['name'];
          
        this.loadDomande();
      });
  }

  rimuovidomanda(id: any): void {
    //this.panelOpenState = false;  //capire come non far aprire la pagina premendo l'icona (che andrebbe sostituita alla freccetta)
    console.log("delete")
    this.service.deleteDomanda(id).subscribe((id2) => {
      console.log(id);
      /*const domandadarimuovere = this.domandeList.find(domanda => {
        return domanda.id == id;
      });
      this.domandeList.splice(this.domandeList.indexOf(domandadarimuovere!), 1);*/
      this.router.navigate(["/gruppi"], {queryParams: {name: this.name}})
    })
  }

  rimuovirisposta(id: any): void {
    //this.panelOpenState = false;  //capire come non far aprire la pagina premendo l'icona (che andrebbe sostituita alla freccetta)
    console.log("delete")
    this.service.deleteRisposta(id).subscribe((id) => {
      console.log(id);
      /*const rispostadarimuovere = this.risposteList.find(risposta => {
        return risposta.id == id;
      });
      this.risposteList.splice(this.risposteList.indexOf(rispostadarimuovere!), 1);*/
      this.router.navigate(["/gruppi"], {queryParams: {name: this.name}})
      //this.ngOnInit();
      //this.router.navigate(["/domande"], {queryParams: {name: this.name, name2: this.name2}})
      //this.loadRisposte(this.name2);
    })
    //this.ngOnInit();
    
  }

  loadDomande(): void {
    this.http.get<Array<modelQuestion>>(`http://localhost:8080/scl_modelQuestion/${this.name2}`).subscribe((res: Array<any>) => {
      console.log("res:", res);

      this.domandeList = [];
      for (let question of res) {         
          this.domandeList.push(question);
      }
      //this.domandeList = res["modelGrouping"][0]["modelQuestions"][0]["modelAnswers"];
      //console.log(this.domandeList);
      //for group in res
    }, 
    err => {
      console.error(err.error.message);
    })
  }

  loadRisposte(sq_id: any): void {
    this.http.get<Array<modelAnswer>>(`http://localhost:8080/scl_modelAnswer/${sq_id}`).subscribe((res: Array<any>) => {   
      console.log("res:", res);
      console.log(sq_id);

      
      this.risposteList = [];
      for (let answer of res) {         
          this.risposteList.push(answer);
      }
      //this.domandeList = res["modelGrouping"][0]["modelQuestions"][0]["modelAnswers"];
      //console.log(this.domandeList);
      //for group in res
    }, 
    err => {
      console.error(err.error.message);
    })
  }

  openDialoginsdomande(){
    this.dialogRef.open(InsdomandaComponent, {
      data: {
      name2: this.name2,
    },});
  }

  openDialoginsrisposte(sq_id: any){
    this.dialogRef.open(InsrispostaComponent, {
      data: {
      sq_id, listadomande: this
    },});
  }

}
