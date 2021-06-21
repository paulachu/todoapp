import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Project } from '../DTO/Project';


const url = 'http://localhost:4000/';
@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) {}

  public getProjects()
  {
    return this.http.get<Project[]>(url + 'project', {responseType: 'json'});
  }
  public addProject(project: Project)
  {
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<Project>(url + 'project', JSON.stringify(project), {headers: headers});
  }
}
