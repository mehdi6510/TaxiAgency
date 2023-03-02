// import {Component, OnInit} from '@angular/core';
// import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
// import {DriverService} from "../../../services/driver/driver.service";
// import {ActivatedRoute, Router} from "@angular/router";
// import {Driver} from "../../../model/Driver";
//
// @Component({
//   selector: 'app-update-driver',
//   templateUrl: './update-driver.component.html',
//   styleUrls: ['./update-driver.component.css']
// })
// export class UpdateDriverComponent implements OnInit {
//   id: number;
//   submitted = false;
//   driver:Driver;
//   error: string = '';
//   updateForm: FormGroup;
//
//   constructor(private activatedRoute: ActivatedRoute, private router: Router, private driverService: DriverService, private formBuilder: FormBuilder) {
//   }
//
//   ngOnInit(): void {
//     this.id = this.activatedRoute.snapshot.params['id'];
//     this.loadDriver(this.id);
//
//     this.updateForm = this.formBuilder.group({
//       id: new FormControl(null),
//       firstName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
//       lastName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
//       plate: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
//       phone: new FormControl('', [Validators.pattern('09(1[0-9]|3[1-9]|2[1-9])-?[0-9]{3}-?[0-9]{4}')]),
//     });
//   }
//
//   get f() {
//     return this.updateForm.controls;
//   }
//
//   loadDriver(id: number): void {
//     this.driverService.getDriver(id).subscribe(data => {
//       console.log(data);
//       this.driver = data;
//       this.submitted = false;
//       this.changeDriverInfo(this.driver);
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
//     this.driverService.updateDriver(this.id, this.updateForm.value)
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
//   changeDriverInfo(driver: Driver) {
//     this.updateForm.controls['id'].setValue(driver.id);
//     this.updateForm.controls['firstName'].setValue(driver.firstName);
//     this.updateForm.controls['lastName'].setValue(driver.lastName);
//     this.updateForm.controls['phone'].setValue(driver.phone);
//     this.updateForm.controls['plate'].setValue(driver.plate);
//
//   }
//
//   onSubmit() {
//     this.submitted = true;
//     this.update();
//   }
//
//   gotoList() {
//     this.router.navigate(['/drivers']);
//   }
//
//   onReset() {
//     this.submitted = false;
//     this.router.navigate(['drivers']);
//   }
//
//
// }
//
//
//
//
//
