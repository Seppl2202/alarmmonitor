import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AddJobComponent } from './components/add-job/add-job.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Router, Routes} from "@angular/router";
import { ListjobsComponent } from './components/listjobs/listjobs.component';
import { FlashMessagesModule } from 'angular2-flash-messages';
import { MonitorComponent } from './components/monitor/monitor.component'


const appRoutes: Routes = [
  {path:'new', component: AddJobComponent},
  {path: 'monitor', component: MonitorComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AddJobComponent,
    ListjobsComponent,
    MonitorComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FlashMessagesModule.forRoot(),
    FormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
