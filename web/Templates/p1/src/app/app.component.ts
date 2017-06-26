import { Component} from '@angular/core';
import {ViewEncapsulation} from '@angular/core';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from '@angular/router-deprecated';

import {LandingComponent} from "./landing/landing.component";
import {BlogComponent} from "./blog/blog.component";

import { SideNavComponent } from './sideNav';
import { HomeComponent } from './home';
import { BlogComponent } from './blog';
import { LifeComponent } from './life';
import { WorkComponent } from './work';

import '../styles/main.scss';

@Component({
    selector: 'app',
    template: require('./app.component.html'),
    styles: [require('./app.component.scss')],
    directives: [...ROUTER_DIRECTIVES, SideNavComponent, HomeComponent],
    providers: [ROUTER_PROVIDERS],
    encapsulation: ViewEncapsulation.None,
})
@RouteConfig([
    {
        path: '/blog',
        name: 'Blog',
        component: BlogComponent
    },
    {
        path: '/life',
        name: 'Life',
        component: LifeComponent
    },
    {
        path: '/work',
        name: 'Work',
        component: WorkComponent
    },
    {
        path: '/',
        name: 'Home',
        component: HomeComponent,
        useAsDefault: true
    }
])
export class AppComponent {

    constructor(){
    }

    ngOnInit () {
        // console.log('#--Init--#');
    }

    ngAfterContentInit(){
        // console.log('#--ngAfterContentInit--#');
    }
    ngAfterContentChecked(){
        // console.log('#--ngAfterContentChecked--#');
    }
    ngAfterViewInit(){
        // console.log('#--ngAfterViewInit--#');
    }
    ngAfterViewChecked(){
        // console.log('#--ngAfterViewChecked--#');
    }
    ngOnDestroy(){
        // console.log('#--ngOnDestroy--#');
    }


}
