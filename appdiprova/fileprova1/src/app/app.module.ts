import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ScaledivalutazioneComponent } from './scaledivalutazione/scaledivalutazione.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { DomandeComponent } from './domande/domande.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatIconModule} from '@angular/material/icon';
import { IndexComponent } from './index/index.component';
import { InserimentoComponent } from './inserimento/inserimento.component';
import {MatDialogModule} from '@angular/material/dialog';
import { PopupComponent } from './popup/popup.component';
import { ContenutopopupComponent } from './contenutopopup/contenutopopup.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatTableModule} from '@angular/material/table';
import { GruppidomandeComponent } from './gruppidomande/gruppidomande.component';
import { InsgruppoComponent } from './insgruppo/insgruppo.component';
import { InsdomandaComponent } from './insdomanda/insdomanda.component';
import { InsrispostaComponent } from './insrisposta/insrisposta.component';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    ScaledivalutazioneComponent,
    DomandeComponent,
    IndexComponent,
    InserimentoComponent,
    PopupComponent,
    ContenutopopupComponent,
    GruppidomandeComponent,
    InsgruppoComponent,
    InsdomandaComponent,
    InsrispostaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatDividerModule,
    MatListModule,
    MatGridListModule,
    MatIconModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatExpansionModule,
    MatToolbarModule,
    MatButtonModule
  ],
  providers: [],
  schemas:[
    CUSTOM_ELEMENTS_SCHEMA
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
