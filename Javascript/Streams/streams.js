/*
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