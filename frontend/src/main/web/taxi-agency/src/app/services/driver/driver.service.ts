// import {Injectable} from '@angular/core';
// import {HttpClient, HttpHeaders} from '@angular/common/http';
// import {Observable} from 'rxjs';
// @Injectable({
//   providedIn: 'root'
// })
// export class DriverService {
//
//   private baseUrl = 'http://localhost:8080/taxi-agency/api/drivers';
//
//   constructor(private http: HttpClient) {
//   }
//   static getOptions(): any {
//     let headers = new HttpHeaders({
//       'Content-Type': 'application/json'
//     });
//     return {headers: headers};
//   }
//
//   getDriver(id: number): Observable<any> {
//     return this.http.get(`${this.baseUrl}/${id}`,DriverService.getOptions());
//   }
//
//   getDriversList(): Observable<any> {
//     return this.http.get(`${this.baseUrl}`, DriverService.getOptions());
//   }
//
//   createDriver(driver: object): Observable<object> {
//     return this.http.post(`${this.baseUrl}`, driver, DriverService.getOptions());
//   }
//
//   updateDriver(id: number, value: any): Observable<object> {
//     return this.http.put(`${this.baseUrl}/${id}`, value, DriverService.getOptions());
//   }
//
//   deletePassenger(id: number): Observable<any> {
//     return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
//   }
// }
