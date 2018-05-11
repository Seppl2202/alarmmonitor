import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/map';
import {HttpClient} from "@angular/common/http";
import {Job} from "../../models/job";
import {FlashMessagesService} from "angular2-flash-messages";

@Component({
  selector: 'app-listjobs',
  templateUrl: './listjobs.component.html',
  styleUrls: ['./listjobs.component.css']
})
export class ListjobsComponent implements OnInit {

  listOfJobs: Job[] = [];
  constructor(private http: HttpClient, private  messageService: FlashMessagesService) {
  }

  ngOnInit() {
    this.getJobs();
  }

  private getJobs() {
    this.http.get<Job[]>("http://localhost:8080/rest/getJobs").subscribe(data => {
      this.listOfJobs = data;
    }, err => {
      console.log(err);
    })
  }


  alarmUnits(job: Job) {
    job.running = true;
    this.http.patch("http://localhost:8080/rest/updateStatus/uuid/" + job.uuid + "/newStatus/true", {}).subscribe(response => {
      console.log(response);
    });
    this.messageService.show("Alarmierung wurde angelegt", {timeout: 2500});

  }
}
