import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './guard/auth.guard';
import { IndexComponent } from './pages/index/index.component';
import { MyprojectComponent } from './pages/myproject/myproject.component';
import { ProjectComponent } from './pages/project/project.component';

const routes: Routes = [
  { path: '', component: IndexComponent},
  { path: 'my_project', component: MyprojectComponent, canActivate: [AuthGuard] },
  { path: 'project/:projectId', component: ProjectComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
