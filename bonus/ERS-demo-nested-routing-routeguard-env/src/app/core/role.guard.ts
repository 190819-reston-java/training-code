import { Role } from './role';
import { AuthorizationService } from './authorization.service';
import { Injectable } from '@angular/core';
import { CanLoad, Route, UrlSegment, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanLoad {

constructor(private authorizationService: AuthorizationService) { }

  canLoad(route: Route, segments: UrlSegment[]): Observable<boolean> | Promise<boolean> | boolean {
    const accessRoles: Role[] = route.data.roles;
    const role: Role = this.authorizationService.getRole();
    return accessRoles.some((e) => e.title === role.title);
  }
}
