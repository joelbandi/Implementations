'use strict';
const chalk = require('chalk');
const logUpdate = require('log-update');
const ora = require('ora');
// const logSymbols = require('log-symbols');
// const argv_mini = require('minimist')(process.argv.slice(2));
// const argv_yargs = require('yargs').demand(['a','b']).usage('Usage: $0 -a [num] -b [num]').alias('a','almonds').argv
// const meow = require('meow');
// const co = require('co');
// const cofs = require('co-fs');
// const commander = require('commander');



//log update
// const frames = ['4', '2', '0'];
// var i = 0;

// setInterval(() => {
//     const frame = chalk.green(frames[i = ++i % frames.length]);

//     logUpdate(
// `
//    ${frame} ${chalk.red.bold('yolo')} ${frame}
// `
//     );
// }, 500);

// another logupdate example
// let i = 0
// setInterval(() => {
//     i++
//     logUpdate(i)
// },1000);

//logupdate exmaple with ora
// const spinner = ora({
//     color:'red'
// })

// var im = setInterval(() => {
//     logUpdate(`

//     ${spinner.frame()} spinning
    
//     `);
// },50);

// setTimeout(() => {
//     spinner.color = 'green';
//     logUpdate(`

//     ${chalk.green.bold('complete!!')}
    
//     `);
//     clearInterval(im);
// },5000);

// const spinner = ora({
//     color:'cyan',
//     text:'something',
//     spinner:'dots4'
// }).start();

// setTimeout(() => {
//     spinner.color = 'green';
//     spinner.text = 'Loading two';
// }, 1000);

// setTimeout(() => {
// 	spinner.succeed();
// }, 2500);


// console.log(logSymbols.success);

//This is for minimist
// console.log(argv_mini);

// node index.js -xyz --save -a beep -b boop wooompf 


// This is for yargs
// console.log(argv_yargs);



//This is meow
// const cli = meow(`
//     Usage
//       $ foo <input>

//     Options
//       --rainbow, -r  Include a rainbow


//     Examples
//       $ foo unicorns --rainbow
//       🌈 unicorns 🌈
// `, {
//     alias: {
//         r: 'rainbow'
//     }
// });
// console.log(cli);


// how to use co fs library 
// co(function*(){
//     var json = yield cofs.readFile('package.json', 'utf8');
//     console.log(json);
// });


//this is the commander sequence...
// var program = require('commander');

// program
//   .version('0.0.1')
//   .option('-p,--pew','How many pews?')
//   .parse(process.argv);


// if(program.pew){
//     console.log(`pew`);
// }else{
//     console.log(`no pew`);
// }