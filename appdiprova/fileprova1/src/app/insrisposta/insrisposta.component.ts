import { Component, OnInit, Inject } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import { MyErrorStateMatcher} from '../insgruppo/insgruppo.component';
import { HttpClient } from '@angular/common/http';
import { ScaledivalutazioneService2 } from './insrisposta.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DomandeService } from '../domande/domande.service';

@Component({
  selector: 'app-insrisposta',
  templateUrl: './insrisposta.component.html',
  styleUrls: ['./insrisposta.component.css']
})
export class InsrispostaComponent implements OnInit {

  emailFormControl = new FormControl('', [Validators.required]);
  emailFormControl2 = new FormControl('', [Validators.required]);
  matcher = new MyErrorStateMatcher();
  visibile = true;
  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public http: HttpClient, public service: ScaledivalutazioneService2, public router: Router, private dialogRef: MatDialog) { 
  }
  
  ngOnInit(): void {
    this.emailFormControl.valueChanges.subscribe((event:any)=>{
      this.visibile=this.emailFormControl.status == 'INVALID'
    })
  }

  addfunzioni(){//form: { value: { sm_description: any; }; }){
    //const newFormData = {sm_description: "provapost", sm_flag_enabled: '1'};
    //const newFormData1 = {version: '1', creationDate: "2021-10-20T09:16:52.329+00:00", scoringFormula: "SUM", scoringLabel: "SUM" }
    const text = this.emailFormControl.value;
    const score = this.emailFormControl2.value;
    const header = "ciao";
    //const date = new Date();
    const newFormData = {text: text, renderAnswers: '1', header: header, score: score};
    //const newFormData1 = {version: '1', creationDate: date, scoringFormula: "SUM", scoringLabel: "SUM" }
    
    /*openDialog(){
      this.dialogRef.open(InsgruppoComponent)
    }*/
    
    //Da aggiungere, per creare una domanda (commentato SOLO PER DEBUG)
    //console.log(this.data.sq_id);
    this.service.createRisposta(newFormData, this.data.sq_id).subscribe((data: any) => {   //any invece di number
      console.log(data);
      this.data.listadomande.loadRisposte(this.data.sq_id);
      this.dialogRef.open(InsrispostaComponent,  {
        data: this.data  //da verificare se è data o name2
      })
      
      //console.log(form.value)
      //this.router.navigate(["/risposta"], {queryParams: {name: data}})
    })
  }
  
}
