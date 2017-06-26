import { Component} from '@angular/core';
import { RouterLink } from '@angular/router-deprecated';

import { SideNavComponent } from '../sideNav'


@Component({
    selector: 'app',
    template: require('./life.component.html'),
    // styles: [require('../styles/main.scss')],
    directives: [SideNavComponent, RouterLink],
})
export class LifeComponent {

    constructor(){
    }

    ngOnInit () {
        // console.log('#--Init--#');
    }



}
