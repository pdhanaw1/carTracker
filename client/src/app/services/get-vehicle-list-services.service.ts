import { Injectable } from '@angular/core';
import {Http,Headers} from '@angular/http';

@Injectable()
export class GetVehicleListServicesService {

  constructor(private http:Http) { }

  getVehicleList(){
    let url = "http://localhost:8070/vehicledetail";
    let headers = new Headers({
        'Content-Type' : 'application/json',

    })

    return this.http.get(url,{headers:headers});
  }


  getVehicleDetail(vin:string) {
    let url = "http://localhost:8070/"+vin;

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
    });
    return this.http.get(url,{headers: tokenHeader});
  }


  getAlertCount(vin:string) {
    let url = "http://localhost:8070/"+vin;

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
    });
    return this.http.get(url,{headers: tokenHeader});
  }



  getAllAlertCount( ) {
    let url = "http://localhost:8070/alert";

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
    });
    return this.http.get(url,{headers: tokenHeader});
  }

}
