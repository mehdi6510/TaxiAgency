import {NgModule, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {Passenger} from "../../../model/Passenger";
import {PassengerService} from "../../../services/passenger/passenger.service";



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class SearchPassengerModule implements  OnInit{

  passengers: Observable<Passenger[]>;

  constructor(private passengerService: PassengerService, private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.passengers = this.passengerService.getPassengersList();
  }

  deleteDriver(id: number) {
    this.passengerService.deletePassenger(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

passengerDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updatePassenger(id: number) {
    this.router.navigate(['update', id]);
  }

}
