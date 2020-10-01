import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { PregledPage } from './pages/pregled/pregled.page';
import { ProstiPage } from './pages/prosti/prosti.page';
import { SlozeniPage } from './pages/slozeni/slozeni.page';

// const routes: Routes = [
//   { path: '', component: PregledPage },
//   { path: 'pregled', component: PregledPage },
//   { path: '**', redirectTo: '' }
// ];

const routes: Routes = [
  {
    path: '',
    component: PregledPage
  },
  {
    path: 'prosti',
    component: ProstiPage
  },
  {
    path: 'slozeni',
    component: SlozeniPage
  },
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
