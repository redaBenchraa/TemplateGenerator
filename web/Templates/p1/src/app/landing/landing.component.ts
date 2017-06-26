import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router-deprecated';
import {SideNavComponent} from "../sideNav/side-nav.component";

@Component({
    template: require('./landing.component.html'),
    directives: [RouterLink],
})
export class LandingComponent {

    constructor(private router: Router) {}

    ngOnInit () {
        console.log('#--Init--#');
    }

}
