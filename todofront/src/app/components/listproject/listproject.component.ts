import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Project } from 'src/app/DTO/Project';
import { DataService } from 'src/app/service/data.service';
import { AddProjectComponent } from '../dialog/add-project/add-project.component';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-listproject',
  templateUrl: './listproject.component.html',
  styleUrls: ['./listproject.component.scss']
})
export class ListprojectComponent implements OnInit {
  @Input() projects: Project[] = [];
  @Output() addProject = new EventEmitter<boolean>();
  constructor(public dialog: MatDialog, private dataService: DataService) { }

  ngOnInit(): void {
  }
  openAddDialog()
  {
    const dialogRef = this.dialog.open(AddProjectComponent, {
      width: '250px',
      data: new Project("", "")
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result)
      {
        let newProject = result;
        this.dataService.addProject(newProject).subscribe(() => this.addProject.emit(true));
      }
    });
  }

}
