import { Component, Inject, OnInit } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import { MyErrorStateMatcher} from '../insgruppo/insgruppo.component';
import { HttpClient } from '@angular/common/http';
import { ScaledivalutazioneService2 } from './insdomanda.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { InsrispostaComponent } from '../insrisposta/insrisposta.component';
//import { MatDialog } from '@angular/material/dialog';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-insdomanda',
  templateUrl: './insdomanda.component.html',
  styleUrls: ['./insdomanda.component.css']
})
export class InsdomandaComponent implements OnInit {

  emailFormControl = new FormControl('', [Validators.required]);
  emailFormControl2 = new FormControl('', [Validators.required]);
  matcher = new MyErrorStateMatcher();
  visibile = true;

  
  constructor(public http: HttpClient, public service: ScaledivalutazioneService2, public route: ActivatedRoute, public router: Router, private dialogRef: MatDialog, @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    //formgroup
    this.emailFormControl.valueChanges.subscribe((event:any) =>{
      this.visibile=this.emailFormControl.status == 'INVALID' || this.emailFormControl2.status == 'INVALID';
    })
    this.emailFormControl2.valueChanges.subscribe((event:any) =>{
      this.visibile=this.emailFormControl.status == 'INVALID' || this.emailFormControl2.status == 'INVALID';
    })
  }

  
  openDialog(){//form: { value: { sm_description: any; }; }){
    
    //const newFormData = {sm_description: "provapost", sm_flag_enabled: '1'};
    //const newFormData1 = {version: '1', creationDate: "2021-10-20T09:16:52.329+00:00", scoringFormula: "SUM", scoringLabel: "SUM" }
    const header = this.emailFormControl.value;
    const text = this.emailFormControl2.value;
    //const date = new Date();
    const newFormData = {header:header, text: text, renderAnswers: '1'};
    //const newFormData1 = {version: '1', creationDate: date, scoringFormula: "SUM", scoringLabel: "SUM" }
    
    /*openDialog(){
      this.dialogRef.open(InsgruppoComponent)
    }*/

    //Da aggiungere, per creare una domanda (commentato SOLO PER DEBUG)
    this.service.createDomanda(newFormData, this.data.name2).subscribe((data: any) => {   //any invece di number
      console.log(data);
      //console.log(form.value)
      this.router.navigate(["/domande"], {queryParams: {name: this.data.name, name2: this.data.name2}}) //ERRORE QUA PROBABILMENTE
      this.dialogRef.open(InsrispostaComponent,  {
        data:{ sq_id: data }   //da verificare se è data o name2
      })
    })
  }

  
  
}
