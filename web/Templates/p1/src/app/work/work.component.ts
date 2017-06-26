import { Component, ElementRef, Renderer} from '@angular/core';
import { RouterLink } from '@angular/router-deprecated';
import {BrowserDomAdapter} from '@angular/platform-browser/src/browser/browser_adapter';

import { SideNavComponent } from '../sideNav';
import { ClientCardComponent } from '../common/clientCard/';

class Client {
    name: string;
    link: string;
    image: string;
    tech: any;
    examples: any;
    tall: boolean;
}

@Component({
    selector: 'app',
    template: require('./work.component.html'),
    // styles: [require('../styles/main.scss')],
    directives: [SideNavComponent, ClientCardComponent, RouterLink],
})
export class WorkComponent {
    clients: Client[] = [];
    elem : ElementRef;
    dom: BrowserDomAdapter;

    constructor(private renderer : Renderer, elem: ElementRef){
        this.elem = elem;
        this.dom = new BrowserDomAdapter();
    }

    onScroll(e : any) {
        let pageContent = this.dom.query(".pageContent");
        let nav = this.dom.query(".nav");
        if(pageContent.getBoundingClientRect().top <= 40) {
            this.dom.addClass(nav, 'nav--fixed');
        } else {
            this.dom.removeClass(nav, 'nav--fixed');
        }
    }

    ngAfterViewInit () {
        this.renderer.listenGlobal( 'window' , 'scroll' , (e : any) => {
            this.onScroll(e);
        });
    }

    ngOnInit () {
        console.log('*--INIT--*', this);

       this.clients = [
            {
                'name': 'client success',
                'link': 'https://www.clientsuccess.com/',
                'image': 'clientSuccess',
                'tech': [
                    'angular', 'jquery', 'css', 'html'
                ],
                'examples': [
                    {
                        'img': 'clientSuccess-1',
                        'desc': 'High performing-interactive grid to track client interactions'
                    }
                ],
                'tall': false
            },
            {
                'name': 'every name',
                'link': 'https://www.everyname.com/',
                'image': 'everyName',
                'tech': [
                    'angular', 'webpack', 'django', 'sass', 'jsdata'
                ],
                'examples': [
                    {
                        'img': 'everyName-1',
                        'desc': 'Custom forms to track orders and accounts'
                    }
                ],
                'tall': false
            },
            {
                'name': 'simple citizen',
                'link': 'https://www.simplecitizen.com/',
                'image': 'simplecitizen',
                'tech': [
                    'angular', 'gulp', 'django', 'python'
                ],
                'examples': [
                    {
                        'img': 'simpleCitizen-1',
                        'desc': 'Turbo Tax like application for government forms'
                    },
                    // {
                    //     'img': 'simpleCitizen-2',
                    //     'desc': 'Option to send secure link to third party'
                    // },
                    // {
                    //     'img': 'simpleCitizen-3',
                    //     'desc': 'Pin auth for secure access'
                    // },
                ],
                'tall': true
            },
            {
                'name': 'this site',
                'link': 'https://www.dustinbelliston.com/',
                'image': 'thisSite',
                'tech': [
                    'angular2', 'webpack', 'firebase', 'sketch', 'typescript'
                ],
                'examples': [
                    {
                        'img': 'thisSite',
                        'desc': 'First dive into Angular 2'
                    }
                ],
                'tall': false
            },
        ]
    }



}
