var events = require('events');
var util = require('util');

var greetr = function(){
    this.name = '';
}

util.inherits(greetr,events);


greetr.prototype.greet = function(name){
    console.log("Greeting has been triggered");
    this.emit('grt',name);
}

var a  = new greetr();

a.on('grt',function(name){
    console.log("Hello "+ name);
});

a.greet('joel');