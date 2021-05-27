import { Component, OnInit } from '@angular/core';
import { AuthService, Profile } from './service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  public profile: Profile | null = null;
  public isLoading = true;
  constructor(private readonly authService: AuthService) {
  }

  async ngOnInit() {
    await this.authService.loadProfile();
    this.profile = this.authService.profile;
    this.isLoading = false;
  }
  title = 'todofront';
}
