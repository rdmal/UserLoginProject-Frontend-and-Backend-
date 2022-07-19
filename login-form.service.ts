import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";

const baseURL="http://localhost:8080/Users";
@Injectable({
  providedIn: 'root'
})
export class LoginFormService {
  httpClient: any;

  constructor() { }
  readAll():
  Observable<any> {
  console.log("readAll():");
  let users = this.httpClient.get(`${baseURL}/`)
  console.log("users:" + JSON.stringify(users));
  return users;
}
read(id: any): Observable<any> {
  return this.httpClient.get(`${baseURL}/${id}`);
}
create(data: any): Observable<any> {
  return this.httpClient.post(`${baseURL}/`, data);
}
update(id: any, data: any): Observable<any> {
  return this.httpClient.put(`${baseURL}/${id}`, data);
}
delete(id: any): Observable<any> {
  return this.httpClient.delete(`${baseURL}/${id}`);
}
deleteAll(): Observable<any> {
  return this.httpClient.delete(baseURL);
}

}
