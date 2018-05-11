import {Component, OnInit} from '@angular/core';
import {Job} from "./models/job";
import {Http} from "@angular/http";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Alarmmonitor';


  constructor(private http: HttpClient) {

  }

  ngOnInit() {
  }
}
