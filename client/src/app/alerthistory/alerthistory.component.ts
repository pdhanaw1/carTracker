import { Component, OnInit } from '@angular/core';
import {GetVehicleListServicesService} from '../services/get-vehicle-list-services.service';
import { ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';


@Component({
  selector: 'app-alerthistory',
  templateUrl: './alerthistory.component.html',
  styleUrls: ['./alerthistory.component.css']
})
export class AlerthistoryComponent implements OnInit {
  private vin: string;
  public data ;

  public sortBy = "numberOfAlert";
  public sortOrder = "asc";
 constructor(private vehicleService:GetVehicleListServicesService,
              private router:Router,
              private http:Http,
              private route:ActivatedRoute
  ) {
  }



  ngOnInit() {
     this.vehicleService.getAllAlertCount().subscribe(
      res => {
        this.data=res.json();
        console.log(this.data)
      },
      error => {
        console.log(error);
      }
    );
  }



}
