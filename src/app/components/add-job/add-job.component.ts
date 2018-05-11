import {Component, OnInit} from '@angular/core';
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrls: ['./add-job.component.css']
})
export class AddJobComponent implements OnInit {

  private description: string;
  private adress: string;
  private reporter: string;
  private jobType: string;
  private units: string[] = [""];

  constructor(private http: HttpClient, private router: Router) {
    console.log(this.http.get("http://localhost:8080/rest/getJobs").subscribe((data) => {
      console.log(data);
    }));
  }

  ngOnInit() {
    this.units = [];
  }

  addUnit(event: any) {
    var x = event.target.attributes['value'].value;
    if (event.target.checked) {
      this.units.push(x);
    } else {
      var index = this.units.indexOf(x);
      if (index > -1) {
        this.units.splice(index, 1);
      }
    }
  }

  submitForm() {
    var url = "http://localhost:8080/rest/addJob/description/" + this.description + "/createDate/2018-05-08/jobType/" + this.jobType + "/alarmedUnits/"
      + this.generateUnitString() + "/reporter/" + this.reporter + "/adress/" + this.adress;

    console.log("URL: " + url);
    this.http.post(url, {}).subscribe(response => console.log(response));
    this.router.navigateByUrl("/");

  }

  private generateUnitString(): string {
    let x: string = "";
    for (let i = 0; i < this.units.length; i++) {
      x += this.units[i] + ",";
    }
    return x.slice(0, -1);
  }
}
