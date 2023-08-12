import { Component, OnInit, Inject } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { HttpClient } from '@angular/common/http';
import { ScaledivalutazioneService2 } from './insgruppo.service';
import { Router } from '@angular/router';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';


export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null , form : FormGroupDirective | NgForm | null ): boolean {
    const isSubmitted = form && form.submitted;
   return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
 }
}

@Component({
  selector: 'app-insgruppo',
  templateUrl: './insgruppo.component.html',
  styleUrls: ['./insgruppo.component.css']
})
export class InsgruppoComponent implements OnInit {

  emailFormControl = new FormControl('', [Validators.required]);
  emailFormControl2 = new FormControl('', [Validators.required]);
  matcher = new MyErrorStateMatcher();
  visibile = true;
  scaleList: any;
  sm_id: any;
  
  // INject serve per prendere i dati passati dalla funzione open del dialog
  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public http: HttpClient, public service: ScaledivalutazioneService2, public router: Router) {
  
   }

  ngOnInit(): void {
    console.log(this.data);
    this.sm_id = this.data.sm_id;
    this.emailFormControl.valueChanges.subscribe((event:any)=>{
      this.visibile=this.emailFormControl.status == 'INVALID'
    })
    this.emailFormControl2.valueChanges.subscribe((event:any)=>{
      this.visibile=this.emailFormControl.status == 'INVALID'
    })
  }

  addNewGruppo(){//form: { value: { sm_description: any; }; }){
    //const newFormData = {sm_description: "provapost", sm_flag_enabled: '1'};
    //const newFormData1 = {version: '1', creationDate: "2021-10-20T09:16:52.329+00:00", scoringFormula: "SUM", scoringLabel: "SUM" }
    const header = this.emailFormControl.value;
    const description = this.emailFormControl2.value;
    //const date = new Date();
    const newFormData = { description: description, header: header, position: 1, showScoring: true, scoringLabel: null};
    console.log(newFormData);
    //const newFormData1 = {version: '1', creationDate: date, scoringFormula: "SUM", scoringLabel: "SUM" }

    this.service.createGruppo(newFormData, this.sm_id).subscribe((data: any) => {   //any invece di number
      console.log(this.data);
      //console.log(form.value)
      console.log(data);
      //console.log(sm_id);
      this.router.navigate(["/domande"], {queryParams: {name: this.data.sm_id, name2: data}}) //sm_id
    })

    
}

}
