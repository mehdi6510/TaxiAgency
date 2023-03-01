import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {DriverService} from "../../../services/driver/driver.service";
import {Driver} from "../../../model/Driver";

@Component({
  selector: 'app-search-driver',
  templateUrl: './search-driver.component.html',
  styleUrls: ['./search-driver.component.css']
})
export class SearchDriverComponent implements  OnInit{

 drivers: Observable<Driver[]>;

  constructor(private driverService: DriverService, private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.drivers = this.driverService.getDriversList();
  }

  deleteDriver(id: number) {
    this.driverService.deleteDriver(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  driverDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateDriver(id: number) {
    this.router.navigate(['update', id]);
  }

}
