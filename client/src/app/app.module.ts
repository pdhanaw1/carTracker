import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';
import { DataTableModule } from 'angular2-datatable';
import { MdDataTableModule } from 'ng2-md-datatable';
import 'hammerjs';
import { AgmCoreModule } from '@agm/core';
import {DataFilterPipe} from './vehicle-list/data-filter.pipe'
import { AppComponent } from './app.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MdButtonModule,MdCardModule,MdMenuModule,MdToolbarModule,MdIconModule} from '@angular/material';

import {GetVehicleListServicesService} from './services/get-vehicle-list-services.service'
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { AlerthistoryComponent } from './alerthistory/alerthistory.component';

@NgModule({
  declarations: [
    AppComponent,
    VehicleComponent,
    NavBarComponent,
    VehicleListComponent,
    DataFilterPipe,
    AlerthistoryComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MdDataTableModule,
    DataTableModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBE65mPIaGbBUs9atfrOpcY7bZCfszzXlk'

    }),
    BrowserAnimationsModule,
    routing,
    MdButtonModule,
    MdCardModule,
    MdMenuModule,
    MdToolbarModule,MdIconModule
  ],
  providers: [GetVehicleListServicesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
