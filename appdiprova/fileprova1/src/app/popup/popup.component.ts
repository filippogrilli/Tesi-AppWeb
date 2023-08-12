import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ContenutopopupComponent } from '../contenutopopup/contenutopopup.component';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent {
  title = 'angular-material';

  constructor(private dialogRef: MatDialog) { }

  openDialog(){
    this.dialogRef.open(ContenutopopupComponent)
  }

  ngOnInit(): void {
  }

}
