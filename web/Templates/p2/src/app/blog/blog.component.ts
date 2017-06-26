import { Component} from '@angular/core';
import { RouterLink } from '@angular/router-deprecated';

import { SideNavComponent } from '../sideNav'


@Component({
    selector: 'app',
    template: require('./blog.component.html'),
    // styles: [require('../styles/main.scss')],
    directives: [SideNavComponent, RouterLink],
})
export class BlogComponent {

    constructor(){
    }

    ngOnInit () {
        // console.log('#--Init--#');
    }
}