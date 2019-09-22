import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './components/profile/profile.component';
import { HomeComponent } from './components/home/home.component';
import { OpeningComponent } from './components/opening/opening.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'open', component: OpeningComponent},
  {path: 'profiles', component: ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
