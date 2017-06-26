import { Component, Input} from '@angular/core';

@Component({
    selector: 'client-card',
    template: require('./client-card.component.html'),
    directives: [],
})
export class ClientCardComponent {
    @Input() client: {};

    constructor() {}

    ngOnInit () {
    }

}
