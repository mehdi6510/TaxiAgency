import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {PassengerService} from "../../../services/passenger/passenger.service";

@Component({
  selector: 'app-create-passenger',
  templateUrl: './create-passenger.component.html',
  styleUrls: ['./create-passenger.component.css']
})
export class CreatePassengerComponent implements OnInit {
  submitted = false;
  registerForm: FormGroup;
  error: string = '';

  constructor(private passengerService: PassengerService, private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.newPassenger();
    this.registerForm = this.formBuilder.group({
      firstName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      phone: new FormControl('', [Validators.pattern('09(1[0-9]|3[1-9]|2[1-9])-?[0-9]{3}-?[0-9]{4}')]),
      address:new FormControl('',[Validators.required ,Validators.maxLength(100)]),
    });
  }

  get f() {
    return this.registerForm.controls;
  }

  newPassenger(): void {
    this.submitted = false;
  }

  save() {
    //stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    this.passengerService.createPassenger(this.registerForm.value)
      .subscribe(data => {
        console.log(data);
        this.gotoList();

      }, excp => {
        console.log(excp);
        if (excp.error instanceof Array) {
          for (let err of excp.error) {
            this.error += `${err.message}.\n`;
          }
        } else {
          this.error = `${excp.error.message}`;
        }
      });
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/passengers']);
  }

  onReset() {
    this.registerForm.reset();
    this.gotoList();
  }


}
