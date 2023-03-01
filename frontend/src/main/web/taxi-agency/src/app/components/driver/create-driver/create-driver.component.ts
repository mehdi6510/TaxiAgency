import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from '@angular/router';
import {DriverService} from "../../../services/driver/driver.service";

@Component({
  selector: 'app-create-driver',
  templateUrl: './create-driver.component.html',
  styleUrls: ['./create-driver.component.css']
})
export class CreateDriverComponent implements OnInit {
  submitted = false;
  registerForm: FormGroup;
  error: string = '';

  constructor(private  driverService:DriverService,private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.newDriver();
    this.registerForm = this.formBuilder.group({
      firstName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      plate: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      phone: new FormControl('', [Validators.pattern('09(1[0-9]|3[1-9]|2[1-9])-?[0-9]{3}-?[0-9]{4}')]),

    });
  }

  get f() {
    return this.registerForm.controls;
  }
  newDriver():void{
    this.submitted=false;
  }
    save() {
    //stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

      this.driverService.createDriver(this.registerForm.value)
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
      this.router.navigate(['/drivers']);
    }

    onReset() {
      this.registerForm.reset();
      this.gotoList();
    }



}
