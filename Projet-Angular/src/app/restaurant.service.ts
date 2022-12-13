import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurant } from './restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private httpC: HttpClient) { }
  private url = 'http://localhost:9099/SpringMVC/restaurant/';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  getAllRestaurant(): Observable<Restaurant[]>{
    return this.httpC.get<Restaurant[]>(this.url + 'retrieve-all-restaurants');
  }

  addRestaurant(Restaurant: Restaurant): Observable<Restaurant> {
    return this.httpC.post<Restaurant>(
      this.url+'add-restaurant',
      Restaurant,
      this.httpOptions
    );
  }

}
