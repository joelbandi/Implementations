var Emitter = require('./Emitter.js');
var io = new Emitter();

io.on('beacon',function(){
    console.log('Beacons are Lit!!!! Alert the Rohan!');
});


io.on('beacon',function(){
    console.log('nother beacon!!');
});


io.on('switch',function(){
    console.log('switch event reegistered');
});

io.emit('beacon',function(){
    console.log('test cb');
})

io.emit('switch');