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
var browser_adapter_1 = require('@angular/platform-browser/src/browser/browser_adapter');
var side_nav_component_1 = require('../sideNav/side-nav.component');
var client_card_component_1 = require('../common/clientCard/client-card.component');
var Client = (function () {
    function Client() {
    }
    return Client;
}());
var WorkComponent = (function () {
    function WorkComponent(renderer, elem) {
        this.renderer = renderer;
        this.clients = [];
        this.elem = elem;
        this.dom = new browser_adapter_1.BrowserDomAdapter();
    }
    WorkComponent.prototype.onScroll = function (e) {
        var pageContent = this.dom.query(".pageContent");
        var nav = this.dom.query(".nav");
        if (pageContent.getBoundingClientRect().top <= 40) {
            this.dom.addClass(nav, 'nav--fixed');
        }
        else {
            this.dom.removeClass(nav, 'nav--fixed');
        }
    };
    WorkComponent.prototype.ngAfterViewInit = function () {
        var _this = this;
        this.renderer.listenGlobal('window', 'scroll', function (e) {
            _this.onScroll(e);
        });
    };
    WorkComponent.prototype.ngOnInit = function () {
        console.log('*--INIT--*', this);
        this.clients = [
            {
                'name': 'client success',
                'image': 'clientSuccess',
                'tech': [
                    'angular', 'jquery', 'css', 'html'
                ],
            },
            {
                'name': 'every name',
                'image': 'everyName',
                'tech': [
                    'angular', 'webpack', 'django', 'sass', 'jsdata'
                ],
            },
            {
                'name': 'simple citizen',
                'image': 'simplecitizen',
                'tech': [
                    'angular', 'gulp', 'django', 'python'
                ],
            },
        ];
    };
    WorkComponent = __decorate([
        core_1.Component({
            selector: 'app',
            template: require('./work.component.html'),
            // styles: [require('../styles/main.scss')],
            directives: [side_nav_component_1.SideNavComponent, client_card_component_1.ClientCardComponent, router_deprecated_1.RouterLink],
        }), 
        __metadata('design:paramtypes', [core_1.Renderer, core_1.ElementRef])
    ], WorkComponent);
    return WorkComponent;
}());
exports.WorkComponent = WorkComponent;
//# sourceMappingURL=work.component.js.map