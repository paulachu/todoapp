import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { KeycloakService } from "keycloak-angular";
import * as keycloak from "keycloak-js";
import { Observable } from "rxjs";
import {catchError} from 'rxjs/operators';

@Injectable()
export class KeycloakInterceptorService implements HttpInterceptor {
  constructor(private readonly keycloak: KeycloakService
  ) {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.keycloak.isLoggedIn())
    {
      this.keycloak.getToken().then((token) =>
        {
          if (token) {
            request = request.clone({
              setHeaders: {
                Authorization: `Bearer ${token}`
              }
            });
          }
          else
          {
            this.keycloak.login();
          }
        return next.handle(request);
      });
    }
    return next.handle(request).pipe(catchError((error: HttpErrorResponse) =>{
      console.log(error);
      if (error.status === 401)
      {
        this.keycloak.login();
      }
      throw error;
    }));
  }
}
