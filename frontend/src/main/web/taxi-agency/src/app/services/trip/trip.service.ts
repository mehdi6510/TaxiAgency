// import {Injectable} from '@angular/core';
// import {HttpClient, HttpHeaders} from '@angular/common/http';
// import {Observable} from 'rxjs';
//
//
// @Injectable({
//   providedIn: 'root'
// })
// export class TripService {
//
//   private baseUrl = 'http://localhost:8080/taxi-agency/api/trips';
//
//   constructor(private http: HttpClient) {
//   }
//   static getOptions(): any {
//     let headers = new HttpHeaders({
//       'Content-Type': 'application/json'
//     });
//     return {headers: headers};
//   }
//   getTrip(id: number): Observable<any> {
//     return this.http.get(`${this.baseUrl}/${id}`,TripService.getOptions());
//   }
//
//   getTripsList(): Observable<any> {
//     return this.http.get(`${this.baseUrl}`, TripService.getOptions());
//   }
//
//   createTrip(trip: object): Observable<object> {
//     return this.http.post(`${this.baseUrl}`, trip, TripService.getOptions());
//   }
//
//   updateTrip(id: number, value: any): Observable<object> {
//     return this.http.put(`${this.baseUrl}/${id}`, value, TripService.getOptions());
//   }
//
//   deleteTrip(id: number): Observable<any> {
//     return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
//   }
// }
