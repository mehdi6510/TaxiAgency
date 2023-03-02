// import {Component, OnInit} from '@angular/core';
// import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
// import {Router} from "@angular/router";
// import {Trip} from "../../../model/Trip";
// import {TripService} from "../../../services/trip/trip.service";
// import {PassengerService} from "../../../services/passenger/passenger.service";
// import {DriverService} from "../../../services/driver/driver.service";
//
// @Component({
//   selector: 'app-update-trip',
//   templateUrl: './update-trip.component.html',
//   styleUrls: ['./update-trip.component.css']
// })
// export class UpdateTripComponent implements OnInit {
//   id: number | undefined;
//   submitted = false;
//   updateForm: FormGroup;
//   trip: Trip;
//   error: string = '';
//
//   constructor(private tripService: TripService,private passengerService:PassengerService,private driverService:DriverService,private router: Router, private formBuilder: FormBuilder) {
//   }
//
//   ngOnInit(): void {
//     // this.id = this.activatedRoute.snapshot.params['id'];
//     this.loadTrip(this.id);
//     this.updateForm = this.formBuilder.group({
//       id: new FormControl(null),
//       price: new FormControl(null),
//       startPoint: new FormControl('', [Validators.required, Validators.minLength(2)]),
//       destination: new FormControl('', [Validators.required, Validators.maxLength(100)]),
//       description: new FormControl('', [Validators.required, Validators.maxLength(100)]),
//       passengerId:new FormControl(),
//       driverId:new FormControl(),
//     });
//   }
//
//   get f() {
//     return this.updateForm.controls;
//   }
//
//   loadTrip(id: number): void {
//     this.tripService.getTrip(id).subscribe(data => {
//       console.log(data);
//       this.trip = data;
//       this.submitted = false;
//       this.changeTripInfo(this.trip);
//
//     }, excp => {
//       console.log(excp);
//       if (excp.error instanceof Array) {
//         for (let err of excp.error) {
//           this.error += `${err.message}.\n`;
//         }
//       } else {
//         this.error = `${excp.error.message}`;
//       }
//
//     });
//   }
//
//   update() {
//     //stop here if form is invalid
//     if (this.updateForm.invalid) {
//       return;
//     }
//
//     this.tripService.updateTrip(this.id, this.updateForm.value)
//       .subscribe(data => {
//         console.log(data);
//         this.gotoList();
//
//       }, excp => {
//         console.log(excp);
//         if (excp.error instanceof Array) {
//           for (let err of excp.error) {
//             this.error += `${err.message}.\n`;
//           }
//         } else {
//           this.error = `${excp.error.message}`;
//         }
//       });
//   }
//   changeTripInfo(trip: Trip) {
//     this.updateForm.controls['id'].setValue(trip.id);
//     this.updateForm.controls['price'].setValue(trip.price);
//     this.updateForm.controls['startPoint'].setValue(trip.startPoint);
//     this.updateForm.controls['destination'].setValue(trip.destination);
//     this.updateForm.controls['description'].setValue(trip.description);
//     // this.updateForm.controls['pasengerId'].
//   }
//
//   onSubmit() {
//     this.submitted = true;
//     this.update();
//   }
//
//   gotoList() {
//     this.router.navigate(['/passengers']);
//   }
//
//   onReset() {
//     this.submitted = false;
//     this.router.navigate(['passengers']);
//   }
//
// }
