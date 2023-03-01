import { Component } from '@angular/core';

@Component({
  selector: 'app-search-driver',
  templateUrl: './search-driver.component.html',
  styleUrls: ['./search-driver.component.css']
})
export class SearchDriverComponent {

  onReset() {
    // this.registerForm.reset();
    // this.gotoList();
  }
  onSearch() {
    console.log("hi search")
  }
}
