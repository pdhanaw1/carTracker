/**
 * Created by Prajakta on 6/10/2017.
 */

import {ModuleWithProviders} from '@angular/core';
import {Routes,RouterModule} from '@angular/router'
import {VehicleListComponent} from "./vehicle-list/vehicle-list.component";
import {VehicleComponent} from "./vehicle/vehicle.component";
import {AlerthistoryComponent} from "./alerthistory/alerthistory.component";

const appRoutes : Routes = [

  {
    path:'vehiclelist',
    component:VehicleListComponent
  },

  {
    path:'vehicledetail/:vin',
    component:VehicleComponent
  },
  {
    path:'allAlerts',
    component:AlerthistoryComponent
  }







];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
