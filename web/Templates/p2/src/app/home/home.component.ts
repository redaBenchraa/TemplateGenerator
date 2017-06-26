import { Component} from '@angular/core';
import { RouterLink } from '@angular/router-deprecated';
import { SideNavComponent } from '../sideNav/side-nav.component';

@Component({
    selector: 'app',
    template: require('./home.component.html'),
    // styles: [require('../styles/main.scss')],
    directives: [SideNavComponent, RouterLink],
})
export class HomeComponent {

    constructor(){
    }

    ngOnInit () {
        // console.log('#--Init--#');
    }

    ngAfterContentInit () {
    }



}
