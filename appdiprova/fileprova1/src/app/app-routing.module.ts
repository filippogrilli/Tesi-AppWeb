import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ScaledivalutazioneComponent } from './scaledivalutazione/scaledivalutazione.component';
import { DomandeComponent } from './domande/domande.component';
import { IndexComponent } from './index/index.component';
import { InserimentoComponent } from './inserimento/inserimento.component';
import { PopupComponent } from './popup/popup.component';
import { GruppidomandeComponent } from './gruppidomande/gruppidomande.component';
import { InsgruppoComponent } from './insgruppo/insgruppo.component';


const routes: Routes = [
  { path: 'scale', component: ScaledivalutazioneComponent },
  { path: 'domande', component: DomandeComponent },
  { path: 'index', component: IndexComponent },
  { path: 'inserimento', component: InserimentoComponent },
  { path: 'popup', component: PopupComponent },
  { path: 'gruppi', component: GruppidomandeComponent },
  { path: '',   redirectTo: '/index', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
