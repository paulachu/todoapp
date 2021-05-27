import { Component, Input, OnInit } from '@angular/core';
import { AuthService, Profile } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @Input() profile: Profile | null = null;
  constructor(private authService: AuthService) { }

  async ngOnInit(){

  }
  public login()
  {
    this.authService.login();
  }
  public logout()
  {
    this.authService.logout();
  }
}
