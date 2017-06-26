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
var router_deprecated_1 = require('@angular/router-deprecated');
<<<<<<< HEAD
=======
var side_nav_component_1 = require('../sideNav/side-nav.component');
>>>>>>> develop3
var BlogComponent = (function () {
    function BlogComponent(router) {
        this.router = router;
    }
    BlogComponent.prototype.ngOnInit = function () {
<<<<<<< HEAD
        console.log('#--Init--#');
    };
    BlogComponent = __decorate([
        core_1.Component({
            template: require('./blog.component.html'),
            directives: [router_deprecated_1.RouterLink],
=======
        // console.log('#--Init--#');
    };
    BlogComponent = __decorate([
        core_1.Component({
            selector: 'app',
            template: require('./blog.component.html'),
            // styles: [require('../styles/main.scss')],
            directives: [side_nav_component_1.SideNavComponent, router_deprecated_1.RouterLink],
>>>>>>> develop3
        }), 
        __metadata('design:paramtypes', [router_deprecated_1.Router])
    ], BlogComponent);
    return BlogComponent;
}());
exports.BlogComponent = BlogComponent;
//# sourceMappingURL=blog.component.js.map