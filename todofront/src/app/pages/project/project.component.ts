import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router,
              private DataService: DataService) { }

  ngOnInit(): void {
    let routeParams = this.route.snapshot.paramMap;
    let projectId = Number(routeParams.get('projectId'));
    if (isNaN(projectId))
    {
      this.router.navigate(['my_project']);
    }
  }

}
