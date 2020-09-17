import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { DashboardPage } from './pages/dashboard/dashboard.page';
import { PregledPage } from './pages/pregled/pregled.page';

const routes: Routes = [
  // { path: '', component: DashboardPage },
  // { path: 'pregled', component: PregledPage },
  // { path: '**', redirectTo: '' }
  { path: '', component: PregledPage },
  { path: 'pregled', component: PregledPage },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
