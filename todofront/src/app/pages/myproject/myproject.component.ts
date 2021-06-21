import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/DTO/Project';
import { AuthService } from 'src/app/service/auth.service';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-myproject',
  templateUrl: './myproject.component.html',
  styleUrls: ['./myproject.component.scss']
})
export class MyprojectComponent implements OnInit {

  public projects: Project[] = [];
  constructor(private readonly dataService: DataService, private authService: AuthService)
  {}

  ngOnInit(): void {
    this.dataService.getProjects().subscribe(data => {
      this.projects = data
    });
  }
  reloadProjects(event: boolean)
  {
    if (event)
    {
      this.dataService.getProjects().subscribe(data => {
        this.projects = data
      });
    }
  }

}
