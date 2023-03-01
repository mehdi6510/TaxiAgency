import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateDriverComponent } from './components/driver/create-driver/create-driver.component';
import { UpdateDriverComponent } from './components/driver/update-driver/update-driver.component';
import { DeleteDriverComponent } from './components/driver/delete-driver/delete-driver.component';
import { SearchDriverComponent } from './components/driver/search-driver/search-driver.component';
import { CreatePassengerComponent } from './components/passenger/create-passenger/create-passenger.component';
import { UpdatePassengerComponent } from './components/passenger/update-passenger/update-passenger.component';
import { DeletePassengerComponent } from './components/passenger/delete-passenger/delete-passenger.component';
import { SearchPassengerComponent } from './components/passenger/search-passenger/search-passenger.component';
import { CreateTripComponent } from './components/trip/create-trip/create-trip.component';
import { UpdateTripComponent } from './components/trip/update-trip/update-trip.component';
import { DeleteTripComponent } from './components/trip/delete-trip/delete-trip.component';
import { SearchTripComponent } from './components/trip/search-trip/search-trip.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateDriverComponent,
    UpdateDriverComponent,
    DeleteDriverComponent,
    SearchDriverComponent,
    CreatePassengerComponent,
    UpdatePassengerComponent,
    DeletePassengerComponent,
    SearchPassengerComponent,
    CreateTripComponent,
    UpdateTripComponent,
    DeleteTripComponent,
    SearchTripComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
