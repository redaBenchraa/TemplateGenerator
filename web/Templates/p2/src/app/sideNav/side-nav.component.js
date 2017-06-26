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
<<<<<<< HEAD
// import {ViewEncapsulation} from '@angular/core';
var router_deprecated_1 = require('@angular/router-deprecated');
=======
var router_deprecated_1 = require('@angular/router-deprecated');
var about_me_component_1 = require('../aboutMe/about-me.component');
>>>>>>> develop3
var SideNavComponent = (function () {
    function SideNavComponent(router) {
        this.router = router;
    }
    SideNavComponent.prototype.ngOnInit = function () {
<<<<<<< HEAD
        console.log('#--Init--#');
=======
        // console.log('#--Init--#');
>>>>>>> develop3
    };
    SideNavComponent = __decorate([
        core_1.Component({
            selector: 'side-nav',
            template: require('./side-nav.component.html'),
<<<<<<< HEAD
            directives: [router_deprecated_1.RouterLink]
=======
            directives: [router_deprecated_1.RouterLink, about_me_component_1.AboutMeComponent]
>>>>>>> develop3
        }), 
        __metadata('design:paramtypes', [router_deprecated_1.Router])
    ], SideNavComponent);
    return SideNavComponent;
}());
exports.SideNavComponent = SideNavComponent;
//# sourceMappingURL=side-nav.component.js.map