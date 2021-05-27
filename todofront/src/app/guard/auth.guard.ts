import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { KeycloakAuthGuard, KeycloakService } from 'keycloak-angular';

export class User
{
  username: string;
  constructor() {
    this.username = "";
  }
}

@Injectable({
  providedIn: 'root'
})
export class AuthGuard extends KeycloakAuthGuard
{
  public user: User;
  constructor( protected readonly router: Router,
              protected readonly keycloak: KeycloakService)
  {
    super(router, keycloak);
    this.user = new User();
  }
  async isAccessAllowed(route: ActivatedRouteSnapshot,
                        state: RouterStateSnapshot): Promise<boolean | UrlTree>
  {
    if (!this.authenticated)
    {
      await this.keycloak.login(

        {
        redirectUri: window.location.origin + state.url,
        }
      );
    }

    return this.authenticated;
  }

}
