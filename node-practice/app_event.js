var events = require('events');
var util = require('util');

var myEmitter = new events.EventEmitter();

myEmitter.on('someEvent', function (msg) {
    console.log(msg)
});

myEmitter.emit('someEvent', 'the event was emitted!!!!!!!!!!');

var Person = function (name) {
    this.name = name
};

util.inherits(Person,events.EventEmitter);

var ashish = new Person('ashish');
var ayushi = new Person('ayushi');

var people = [ashish, ayushi];
people.forEach(function (person) {
    person.on('speak', function (msg) {
        console.log(person.name+ ' said: '+ msg);
    });
});

ashish.emit('speak','i love u');
ayushi.emit('speak','i love u too');