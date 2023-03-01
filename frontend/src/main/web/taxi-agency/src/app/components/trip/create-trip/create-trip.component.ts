import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {TripService} from "../../../services/trip/trip.service";

@Component({
  selector: 'app-create-trip',
  templateUrl: './create-trip.component.html',
  styleUrls: ['./create-trip.component.css']
})
export class CreateTripComponent implements OnInit {
  submitted = false;
  registerForm: FormGroup;
  error: string = '';


  constructor(private tripService: TripService, private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.newTrip();
    this.registerForm = this.formBuilder.group({
      price: new FormControl(null),
      time:new FormControl(''),
      startPoint: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      destination:new FormControl('',[Validators.required ,Validators.maxLength(100)]),
      description:new FormControl('',[Validators.required ,Validators.maxLength(100)]),
      deriverId:new FormControl(),
      passengerId:new FormControl,
    });
  }

  get f() {
    return this.registerForm.controls;
  }

  newTrip(): void {
    this.submitted = false;
  }

  save() {
    //stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    this.tripService.createTrip(this.registerForm.value)
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
    this.router.navigate(['/trips']);
  }

  onReset() {
    this.registerForm.reset();
    this.gotoList();
  }


}
