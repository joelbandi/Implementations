#!/usr/bin/env node

const cp = require('child_process');
const spawn = cp.spawn;
const exec = cp.exec;
const fs = require('fs');
const path =  require('path');

//random message for testing
// const chalk = require('chalk');
// const msg = `\n${chalk.green.bold(`Hello`)} ${chalk.yellow.bold(`world`)}\n`;

//there exists a global object called process in nodejs thats is populated with many 
//important objects that are necessary to manipulate the interaction between the script and 
// the runtime environment like stdout, stderr , stdin and arguments (argv) array object passed to the script
// a script can have only one process because node is synchronized and all node scripts run on a single process!!!
// console.log(process.argv);

// another way of console logging is 
//process.stdout is a stream btw
// process.stdout.write(`${msg}`);
// console.log(`${msg}`);
//execPath contains the binary that called this script in the first place which ofcourse is /usr/bin/nodejs
// console.log(process.execPath);


// Lets play with streams like file streams
// for example ==> stream1.pipe(stream2) where stream1 -> source and stream2 -> destination

//lets print this source file itself

// var readstream = fs.createReadStream('inq.js');
// var outputstream = process.stdout;
// readstream.pipe(outputstream);



// this is how we delay execution in node and browser
// setTimeout(() => {
//     console.log(`${msg}`)
// },1000);

//this is how we run code at every interval
// setInterval(() =>{
//     console.log(`${msg}`)
// },1000);
// commented because itll crowd your tty

// process.exit() sends a SIGTERM signal to out current script
// var count = 0;
// setInterval(() =>{
//     count ++;
//     console.log(`${msg}`);
//     if(count >= 5){
//         process.exit();
//     }
// },1000);


// how to run other system binaries from your node process or create a new node process??
// exec('ls -l',(err,stdout,stderr) => {
//     console.log('ls -l has been executed \n\n',stdout);
// });

//we can also use spawn
// spawn return the process object of the child process which is known as childProcess which is somewhat similar to 
//process object of the child
// var childProcessObject =  spawn('ls',['-l']);
//we can attach events to the stream (btw stream inherits from eventEmitter in nodejs)
// childProcessObject.stdout.on('data',(data) => {
//     console.log(data.toString()); //we must use data.toString() to convert from byte code into string format (defaults to utf8)
// });
//or we can directly pipe it to the current object
// childProcessObject.stdout.pipe(process.stdout);

// there is also another way we can tell the child process to inherit from the parent process all its std streams 
// var childProcess = spawn('ls',['-l'],{stdio:'inherit'});
// Now we have no need of any piping operations and the child originall yinherits from the parent objecta 
// and hence its stdout is its parent stdout

// PROCESSES DO NOT SHARE resources at all... including memory space. They are scoped to their own resource pool

//how does two processes communicate!!



// via pipes or sockets of course/ use the existing default pipes too
// var child = spawn(process.execPath,[path.join(__dirname,'/child.js'),'-p']);
// var anotherchild = spawn(process.execPath,[path.join(__dirname,'/child.js')]);

// child.stdout.on('data',(data) => {
//     console.log(data.toString());
// });
// anotherchild.stdout.on('data',(data) => {
//     process.stdout.write(data.toString());
// });



// stdio options here
/*
const child = child_process.spawn('ls', {
    stdio: [
      0, // Use parents stdin for child
      'pipe', // Pipe child's stdout to parent
      fs.openSync('err.out', 'w') // Direct child's stderr to a file
    ]
});
*/



// Another way to do the same thing using custom streams/pipe
// var child = spawn(process.execPath,[path.join(__dirname,'child.js'),'-x'],{
//     stdio:[null,null,null,'pipe']
// });
// child.stdio[3].on('data', (data) => {
//     console.log(data.toString());
// });


