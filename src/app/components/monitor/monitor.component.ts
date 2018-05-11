import { Component, OnInit } from '@angular/core';
import {Job} from "../../models/job";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-monitor',
  templateUrl: './monitor.component.html',
  styleUrls: ['./monitor.component.css']
})
export class MonitorComponent implements OnInit {

  listOfAlarmedJobs: Job[] = [];
  availableUnits: String[] = [];
  actualJob: Job;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getAlarmedJobs();
    this.availableUnits.push("LF1612", "LF16TS", "MTW", "RW");
    this.actualJob = this.listOfAlarmedJobs[0];
  }

  getAlarmedJobs() {
    this.http.get<Job[]>("http://localhost:8080/rest/getJob/getAllAlarmed").subscribe(data => {
      this.listOfAlarmedJobs = data;
    }, err => {
      console.log(err);
    })
  }

  getColorForUnit(c: string) {

    if(this.actualJob) {
      for (let i = 0; i < this.actualJob.alarmedUnits.length; i++) {
        if (this.actualJob.alarmedUnits[i] === c) {
          return "green";
        }
      }
    }
    return "red";
  }

  updateAlarmedUnits(j: Job) {
    this.actualJob = j;
  }
}
