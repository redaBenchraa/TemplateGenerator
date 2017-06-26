"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var core_2 = require('@angular/core');
var router_deprecated_1 = require('@angular/router-deprecated');
<<<<<<< HEAD
var landing_component_1 = require("./landing/landing.component");
var blog_component_1 = require("./blog/blog.component");
=======
var side_nav_component_1 = require('./sideNav/side-nav.component');
var home_component_1 = require('./home/home.component');
var blog_component_1 = require('./blog/blog.component');
var work_component_1 = require('./work/work.component');
>>>>>>> develop3
var AppComponent = (function () {
    function AppComponent() {
    }
    AppComponent.prototype.ngOnInit = function () {
        // console.log('#--Init--#');
    };
    AppComponent.prototype.ngAfterContentInit = function () {
        // console.log('#--ngAfterContentInit--#');
    };
    AppComponent.prototype.ngAfterContentChecked = function () {
        // console.log('#--ngAfterContentChecked--#');
    };
    AppComponent.prototype.ngAfterViewInit = function () {
        // console.log('#--ngAfterViewInit--#');
    };
    AppComponent.prototype.ngAfterViewChecked = function () {
        // console.log('#--ngAfterViewChecked--#');
    };
    AppComponent.prototype.ngOnDestroy = function () {
        // console.log('#--ngOnDestroy--#');
    };
    AppComponent = __decorate([
        core_1.Component({
            selector: 'app',
            template: require('./app.component.html'),
            styles: [require('../styles/main.scss')],
<<<<<<< HEAD
            directives: [router_deprecated_1.ROUTER_DIRECTIVES],
=======
            directives: [router_deprecated_1.ROUTER_DIRECTIVES, side_nav_component_1.SideNavComponent, home_component_1.HomeComponent],
>>>>>>> develop3
            providers: [router_deprecated_1.ROUTER_PROVIDERS],
            encapsulation: core_2.ViewEncapsulation.None,
        }),
        router_deprecated_1.RouteConfig([
            {
<<<<<<< HEAD
                path: '/',
                name: 'Landing',
                component: landing_component_1.LandingComponent,
                useAsDefault: true
            },
            {
                path: '/blog',
                name: 'Blog',
                component: blog_component_1.BlogComponent
=======
                path: '/blog',
                name: 'Blog',
                component: blog_component_1.BlogComponent
            },
            {
                path: '/work',
                name: 'Work',
                component: work_component_1.WorkComponent
            },
            {
                path: '/',
                name: 'Home',
                component: home_component_1.HomeComponent,
                useAsDefault: true
>>>>>>> develop3
            }
        ]), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map