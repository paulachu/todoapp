import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';


export class Profile
{
  public isLoggedIn = false;
  public userProfile: KeycloakProfile | null = null;
  public Roles: string[];
  constructor(roles: string[], userProfile: KeycloakProfile | null = null, isLoggedIn: boolean)
  {
    this.Roles = roles;
    this.userProfile = userProfile;;
    this.isLoggedIn = isLoggedIn;
  }
}
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public profile: Profile | null = null;
  constructor(private readonly keycloak: KeycloakService) {
  }

  async loadProfile()
  {
    let isLoggedIn = await this.keycloak.isLoggedIn();
    if (isLoggedIn) {
      let userProfile = await this.keycloak.loadUserProfile();
      let roles = await this.keycloak.getUserRoles(true);
      this.profile = new Profile(roles, userProfile, isLoggedIn);
    }
  }
  login()
  {
    this.keycloak.login();
  }
  logout()
  {
    this.keycloak.logout();
  }
}
