var Emitter = require('./Emitter.js');
var io = new Emitter();

io.on('beacon',function(){
    console.log('Beacons are Lit!!!! Alert the Rohan!');
});

io.emit('beacon',function(){
    console.log('test cb');
})