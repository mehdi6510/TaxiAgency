import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PassengerService {
  private baseUrl = 'http://localhost:8080/taxi-agency/api/passengers';

  constructor(private http: HttpClient) {
  }
  static getOptions(): any {
    let headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return {headers: headers};
  }

  getPassenger(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`,PassengerService.getOptions());
  }

  getPassengersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`, PassengerService.getOptions());
  }

  createPassenger(passenger: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`, passenger, PassengerService.getOptions());
  }

  updatePassenger(id: number, value: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/${id}`, value, PassengerService.getOptions());
  }

  deletePassenger(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }
}
