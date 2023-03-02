// import {Component, OnInit} from '@angular/core';
// import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
// import {Router} from '@angular/router';
// import {Passenger} from "../../../model/Passenger";
// import {PassengerService} from "../../../services/passenger/passenger.service";
//
// @Component({
//   selector: 'app-update-passenger',
//   templateUrl: './update-passenger.component.html',
//   styleUrls: ['./update-passenger.component.css']
// })
// export class UpdatePassengerComponent implements OnInit {
//   id: number | undefined;
//   submitted = false;
//   updateForm: FormGroup | undefined;
//   passenger: Passenger | undefined;
//   error: string = '';
//
//   constructor(private  passengerService :PassengerService,private router: Router, private formBuilder: FormBuilder) {
//   }
//
//   ngOnInit(): void {
//     // this.id = this.activatedRoute.snapshot.params['id'];
//     this.loadPassenger(this.id);
//     this.updateForm = this.formBuilder.group({
//       id: new FormControl(null),
//       firstName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
//       lastName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
//       phone: new FormControl('', [Validators.pattern('09(1[0-9]|3[1-9]|2[1-9])-?[0-9]{3}-?[0-9]{4}')]),
//       address: new FormControl(),
//     });
//   }
//
//   get f() {
//     return this.updateForm.controls;
//   }
//
//   loadPassenger(id: number): void {
//     this.passengerService.getPassenger(id).subscribe(data => {
//       console.log(data);
//       this.passenger = data;
//       this.submitted = false;
//       this.changePassengerInfo(this.passenger);
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
//     this.passengerService.updatePassenger(this.id, this.updateForm.value)
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
//
//   changePassengerInfo(passenger: Passenger | undefined) {
//     this.updateForm.controls['id'].setValue(passenger.id);
//     this.updateForm.controls['firstName'].setValue(passenger.firstName);
//     this.updateForm.controls['lastName'].setValue(passenger.lastName);
//     this.updateForm.controls['phone'].setValue(passenger.phone);
//     this.updateForm.controls['address'].setValue(passenger.address);
//     }
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
