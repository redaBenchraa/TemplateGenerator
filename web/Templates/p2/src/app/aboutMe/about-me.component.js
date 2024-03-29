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
var browser_adapter_1 = require('@angular/platform-browser/src/browser/browser_adapter');
var router_deprecated_1 = require('@angular/router-deprecated');
var AboutMeComponent = (function () {
    function AboutMeComponent(router) {
        this.router = router;
        this.photo = "tech-angular";
        this.boolShowCover = false;
        this.dom = new browser_adapter_1.BrowserDomAdapter();
    }
    AboutMeComponent.prototype.ngOnInit = function () {
    };
    AboutMeComponent.prototype.toggleCover = function () {
        this.boolShowCover = !this.boolShowCover;
        this.handleLanding();
    };
    AboutMeComponent.prototype.handleLanding = function () {
        var landing = this.dom.query(".landing");
        if (this.boolShowCover) {
            console.log('#--ADD--#');
            this.dom.addClass(landing, 'landing--scrunch');
        }
        else {
            this.dom.removeClass(landing, 'landing--scrunch');
        }
    };
    AboutMeComponent = __decorate([
        core_1.Component({
            selector: 'about-me',
            template: require('./about-me.component.html'),
            directives: [router_deprecated_1.RouterLink]
        }), 
        __metadata('design:paramtypes', [router_deprecated_1.Router])
    ], AboutMeComponent);
    return AboutMeComponent;
}());
exports.AboutMeComponent = AboutMeComponent;
//# sourceMappingURL=about-me.component.js.map