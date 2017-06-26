import { Component} from '@angular/core';
import {BrowserDomAdapter} from '@angular/platform-browser/src/browser/browser_adapter';

import { Router, RouterLink } from '@angular/router-deprecated';

import {Message} from '../services/message.model.ts';
import {MessageService} from '../services/message.service.ts';


@Component({
    selector: 'about-me',
    template: require('./about-me.component.html'),
    directives: [RouterLink],
    providers: [MessageService],
})
export class AboutMeComponent {
    boolShowCover: boolean;
    boolMessageSent: boolean;
    dom: BrowserDomAdapter;
    photo: string;
    private name: string;
    private email: string;
    private message: string;

    constructor(
        private router: Router,
        private messageService: MessageService
    ) {
        this.photo = "tech-angular";
        this.boolShowCover = false;
        this.boolMessageSent = false;
        this.dom = new BrowserDomAdapter();
    }

    ngOnInit () {
    }

    toggleCover() {
        this.boolShowCover = !this.boolShowCover;
        this.handleLanding();
    }
    
    handleLanding() {
        let landing = this.dom.query(".landing");

        if(this.boolShowCover) {
            console.log('#--ADD--#');
            this.dom.addClass(landing, 'landing--scrunch');
        } else {
            this.dom.removeClass(landing, 'landing--scrunch');
        }
    }
    
    sendMessage () {
        console.log('#--Send Message--#');

        this.messageService.create(this.name, this.email, this.message)
         .then(res => {
             this.boolMessageSent = true;
         })

    }

}
