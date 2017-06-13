import { Component, OnInit } from '@angular/core';
import {GetVehicleListServicesService} from '../services/get-vehicle-list-services.service';
import {Params, ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {marker} from "./marker";
import {Alert} from "../models/Alert";


@Component({
  selector: 'app-vehicle',
  templateUrl:'vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {
  private vin: string;
  zoom: number = 8;
  public data ;

  public sortBy = "year";
  public sortOrder = "asc";

// initial center positio
// n for the map
 // latitude: number = 40.7282;
  //longitude: number = -74.0776;
  public markers:marker[];
  constructor(private vehicleService:GetVehicleListServicesService,
              private router:Router,
              private http:Http,
              private route:ActivatedRoute
  ) {
     }



  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.vin = (params['vin']);
    });

    this.vehicleService.getVehicleDetail(this.vin).subscribe(
      res => {
        this.markers=res.json();
        console.log(this.markers)
      },
      error => {
        console.log(error);
      }
    );


    this.vehicleService.getAlertCount(this.vin).subscribe(
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
