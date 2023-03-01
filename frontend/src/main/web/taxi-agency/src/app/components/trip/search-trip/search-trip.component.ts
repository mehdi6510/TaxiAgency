import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {TripService} from "../../../services/trip/trip.service";
import {Trip} from "../../../model/Trip";
import {PassengerService} from "../../../services/passenger/passenger.service";
import {DriverService} from "../../../services/driver/driver.service";

@Component({
  selector: 'app-search-trip',
  templateUrl: './search-trip.component.html',
  styleUrls: ['./search-trip.component.css']
})
export class SearchTripComponent  implements  OnInit{

  trips: Observable<Trip[]>;

  constructor(private tripService : TripService,private  passengerService:PassengerService,private driverService:DriverService,private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.trips = this.tripService.getTripsList();
  }

  deleteTrip(id: number) {
    this.tripService.deleteTrip(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  tripDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateTrip(id: number) {
    this.router.navigate(['update', id]);
  }

}
