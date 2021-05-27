import { Component, Input, OnInit } from '@angular/core';
import { AuthService, Profile } from 'src/app/service/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  @Input() public profile: Profile | null = null;
  constructor(private readonly authService: AuthService) {
  }

  async ngOnInit() {
  }
}
