import {Observable} from 'rxjs/Observable';
import {Message} from './message.model.ts';
var Firebase = require('firebase/lib/firebase-web');

export class MessageService {
  public db: Firebase;

  constructor() {
    this.db = new Firebase('https://project-6482519155032588754.firebaseio.com/messages');
  }

  create(name: string, email: string, message: string, date?: string) {
    console.log('#--CREATED--#', this.db);

    if (!date) {
      date = new Date().toDateString();
    }

    var that = this;
    return new Promise(function(resolve, reject) {
      that.db.push({
        name,
        email,
        message,
        date
      }, res => {
        resolve(res)
      });
    });

  }

  getAll(): Observable<Message> {
    return Observable.create(observer => {
      let listener = this.db.on('child_added', snapshot => {
        let data = snapshot.val();
        observer.next(new Message(
          data.name,
          data.email,
          data.message,
          data.date
        ));
      }, observer.error);

      return () => {
        this.db.off('child_added', listener);
      };
    });
  }
};