import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { ToastrModule } from 'ngx-toastr';

import { AppComponent } from './app.component';

import { NgbModule, NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule, DatePipe } from '@angular/common';
import { ThemeModule } from './theme/theme.module';
import { AppRoutingModule } from './app-routing.module';
import { MatDialogModule } from '@angular/material/dialog';
import { DashboardPage } from './pages/dashboard/dashboard.page';
import { PregledPage } from './pages/pregled/pregled.page';
import { ConfirmDialog } from './components/confirm/confirm.dialog';
import { LokacijskaDozvolaComponent } from './components/lokacijska-dozvola/lokacijska-dozvola.component';
import { LokacijskaDozvolaDialog } from './components/lokacijska-dozvola/lokacijska-dozvola-dialog/lokacijska-dozvola.dialog';
import { BrowserModule } from '@angular/platform-browser';
import { ProjekatZaGradjevinskuDozvoluComponent } from './components/projekat-za-gradjevinsku-dozvolu/projekat-za-gradjevinsku-dozvolu.component';
import { ProjekatZaGradjevinskuDozvoluDialog } from './components/projekat-za-gradjevinsku-dozvolu/projekat-za-gradjevinsku-dozvolu-dialog/projekat-za-gradjevinsku-dozvolu.dialog';
import { StatusDokumentaPipe } from './pipes/status-dokumenta.pipe';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { IzvestajOIzvrsenjuRadovaDialog } from './components/izvestaj-o-izvrsenju-radova/izvestaj-o-izvrsenju-radova-dialog/izvestaj-o-izvrsenju-radova.dialog';
import { IzvestajOIzvrsenjuRadovaComponent } from './components/izvestaj-o-izvrsenju-radova/izvestaj-o-izvrsenju-radova.component';
import { NalogZaUplatuDialog } from './components/nalog-za-uplatu/nalog-za-uplatu-dialog/nalog-za-uplatu.dialog';
import { NalogZaUplatuComponent } from './components/nalog-za-uplatu/nalog-za-uplatu.component';
import { SlozeniPage } from './pages/slozeni/slozeni.page';
import { ProstiPage } from './pages/prosti/prosti.page';

@NgModule({
  imports: [
    // MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    ThemeModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
    ToastrModule.forRoot(),
    MatDialogModule
  ],
  exports: [
    // MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule
  ],
  declarations: [
    AppComponent,
    DashboardPage,
    PregledPage,
    LokacijskaDozvolaComponent,
    ConfirmDialog,
    LokacijskaDozvolaDialog,
    ProjekatZaGradjevinskuDozvoluComponent,
    ProjekatZaGradjevinskuDozvoluDialog,
    NalogZaUplatuComponent,
    NalogZaUplatuDialog,
    IzvestajOIzvrsenjuRadovaComponent,
    IzvestajOIzvrsenjuRadovaDialog,
    StatusDokumentaPipe,
    ProstiPage,
    SlozeniPage
  ],
  providers: [DatePipe, NgbDropdownConfig, StatusDokumentaPipe],
  bootstrap: [AppComponent],
  entryComponents: [
    ConfirmDialog,
    LokacijskaDozvolaDialog,
    ProjekatZaGradjevinskuDozvoluDialog,
    NalogZaUplatuDialog,
    IzvestajOIzvrsenjuRadovaDialog
  ]
})
export class AppModule { }
