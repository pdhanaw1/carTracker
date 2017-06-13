import { Component, OnInit } from '@angular/core';
import {GetVehicleListServicesService} from '../services/get-vehicle-list-services.service';
import {Vehicle} from "../models/Vehicle";
import {ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';


@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {
  public data;
  public sortBy = "year";
  public sortOrder = "asc";
  private selectedVehicle: Vehicle;

  constructor(
          private getVehicleListServicesService : GetVehicleListServicesService,
          private router : Router,
          private http:Http,
          private route:ActivatedRoute


  ) { }



  onSelect(vehicle: Vehicle) {
    this.selectedVehicle = vehicle;
    this.router.navigate(['/vehicledetail', this.selectedVehicle.vin]);
  }


  ngOnInit() {

    this.getVehicleListServicesService.getVehicleList().subscribe(
      res => {
          console.log(res.json());
          this.data = res.json();
      },
      err => {
          console.log(err);
      }
    );
  }
  public toInt(num: string) {
    return +num;
  }
}
