import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup,Validators} from "@angular/forms";
import {Router} from '@angular/router';
@Component({
  selector: 'app-create-driver',
  templateUrl: './create-driver.component.html',
  styleUrls: ['./create-driver.component.css']
})
export class CreateDriverComponent implements OnInit {
  submitted = false;
  registerForm: FormGroup;


  constructor( private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
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

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  // gotoList() {
  //   this.r.navigate(['/users']);
  // }

  onReset() {
    this.registerForm.reset();
    // this.gotoList();
  }

  save() {
    //stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }


  }
}
