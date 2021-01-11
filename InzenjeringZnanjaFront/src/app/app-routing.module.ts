import { ZdravstveniKartonComponent } from './components/zdravstveni-karton/zdravstveni-karton.component';
import { PacijentiComponent } from './components/pacijenti/pacijenti.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'pacijent'},
  {path: 'pacijent', component: PacijentiComponent},
  {path: 'karton/:id', component: ZdravstveniKartonComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
