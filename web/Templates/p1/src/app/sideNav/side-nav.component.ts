import { Component} from '@angular/core';

import { Router, RouterLink } from '@angular/router-deprecated';
import { AboutMeComponent } from '../aboutMe';


@Component({
    selector: 'side-nav',
    template: require('./side-nav.component.html'),

    directives: [RouterLink, AboutMeComponent]
})
export class SideNavComponent {

    constructor(private router: Router) {}
    
    ngOnInit () {
        // console.log('#--Init--#');
    }

}
