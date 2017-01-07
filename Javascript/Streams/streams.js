/*

READ THIS : https://github.com/substack/stream-handbook
for more info


 Streams are just a standard interface in Node.js 
 IF you expose your API as a stream it will be compatible with a 
 whole lot of other software.
Streams are of three types -> read, write, duplex Streams
node.js event emiiter library itself implements a stream
Many of node. js internal core libraries implement streams
example; fs, process and etc.
*/



// Let's test an input stream or a read stream from fs library
var fs = require('fs');
var bears = fs.createReadStream('./bears');
// bears is a stream object now and we can assign events and callbacks to it
// upon data event it receives a buffer object 
bears.on('data',data => {
  console.log(data.toString());
});


/*
The best thing about streams is that they can be piped to another stream
a pipe is a connection between two streams
Think of a two streams as a two parallel highway, and a pipe as a small road that connects them.
*/



// process (an object available to every node process) has three objects called stdout,stdin and stderr for console output, input and error
// They are streams as well
bears.pipe(process.stdout);




// piping to another file stream
var bearsCopy = fs.createWriteStream('./bearscopy');
bears.pipe(bearsCopy);





// Lets now modify streams on the fly 
// Let's pull the transform object from stream library to create a duplex stream
var Transform = require('stream').Transform;
// or import { Transform } from 'stream';
var inherits = require('util').inherits;
function actualBearTransform () {
  Transform.call(this);
}
inherits(actualBearTransform,Transform);
// basic prototypal inheritance
actualBearTransform.prototype._transform = function(chunk,enc,done) {
  chunk = chunk.toString().split('\n').filter( (bear) =>  bear !== 'koala' ).join('\n');
  this.push(chunk)
  done();
}
var actualBears = fs.createWriteStream('./actualBears');
bears.pipe(new actualBearTransform()).pipe(actualBears);


/*
 Let's deep dive into Node Streams.
 A lot of interfaces in node depend on streams including the likes of http server response and request objects.

 Streams often look like these -> source.pipe(destination);
 where source can be a readable || duplex stream
 where destination can be a writable || duplex stream.

 A Bestiary of streams:
 -> Readable
 -> writable
 -> duplex
    ~>Tranform
  
  Here, tranform stream is a special kind of a duplex stream.
  It acts as a middle stream between two streams and it fits like these

  source.pipe(transform).pipe(destination);
  
  transforms are powerful -> they can do simple like convert streams to capital letters, filter stuff or even compression and video encoding 
 
  What makes streams so good and useful for performance and scalability?

  -> Writable streams mist send a signal back to readable streams that theyre ready for more data. This means that the readable streams reads data into memory only when its needed. SUPER!!!. It is configurable, which means you can decide when the writable buffer gets full so as to pause the readable stream from procuring data. This is called configurable water-mark (Think dams)
  -> Back pressure is the destination streams way to telling or signaling a source stream to stop sending data
 
 */