import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { HttpClient } from '@angular/common/http'; 
import { ScaledivalutazioneService } from './contenutopopup.service';
import { Router } from '@angular/router';


/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null , form : FormGroupDirective | NgForm | null ): boolean {
    const isSubmitted = form && form.submitted;
   return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
 }
}

@Component({
  selector: 'app-contenutopopup',
  templateUrl: './contenutopopup.component.html',
  styleUrls: ['./contenutopopup.component.css']
})
export class ContenutopopupComponent implements OnInit {

  emailFormControl = new FormControl('', [Validators.required]);
  matcher = new MyErrorStateMatcher();
  visibile = true;
  scaleList: any;
  constructor(public http: HttpClient, public service: ScaledivalutazioneService, public router: Router) { }

  ngOnInit(): void {
    this.emailFormControl.valueChanges.subscribe((event:any)=>{
      this.visibile=this.emailFormControl.status == 'INVALID'
    })
  }

  rimuoviPop(){
    //nulla
  }

  addNewScala(){//form: { value: { sm_description: any; }; }){
      //const newFormData = {sm_description: "provapost", sm_flag_enabled: '1'};
      //const newFormData1 = {version: '1', creationDate: "2021-10-20T09:16:52.329+00:00", scoringFormula: "SUM", scoringLabel: "SUM" }
      const description = this.emailFormControl.value;
      const date = new Date();
      const newFormData = {sm_description: description, sm_flag_enabled: '1'};
      const newFormData1 = {version: '1', creationDate: date, scoringFormula: "SUM", scoringLabel: "SUM" }

      this.service.createScale(newFormData).subscribe((data: number) => {   //any invece di number
        console.log(data);
        //console.log(form.value)
        this.service.createVersion(newFormData1, data).subscribe(data2 => {
          console.log(data2);
          this.router.navigate(["/gruppi"], {queryParams: {name: data}})
          //console.log(form.value)
        })
      })

      
  }
  
}