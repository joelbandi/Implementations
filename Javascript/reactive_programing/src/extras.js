// This does not go into the webpage at all
// This is a console application

const Rx = require('rxjs/Rx');

// Let's look at some operators provided to us in these reative extensions

// -<interval>-
// this interval basically fires a number starting from 0 every 500 ms. We are creating an obserable from it
// Take method specifies when to stop. It is optional if you want this to fire indefinitely 


const intervalsource$ = Rx.Observable.interval(500).take(5);
intervalsource$.subscribe(
  console.log,
  console.log,
  ()=>console.log('complete')
);


// -<timer>-
// timer allows to wait for 3000ms before firing a 
// sequence of numbers indefinitely or until take method is specified
// the sequence has a gap of 500ms between each number

const timersource$ = Rx.Observable.timer(3000,500).take(10);
timersource$.subscribe(
  console.log,
  console.log,
  () => console.log('complete')
);


// -<range>-
// prints 100 numbers from 25 including 25. i.e, 25 -> 124
const rangesource$ = Rx.Observable.range(25,100);
rangesource$.subscribe(
  console.log,
  console.log,
  () => console.log('complete')
);


// -<map function>-
// We can attach a map function towards thhe end of the observer so the the 
// output of the observer also passes through the map  
const mapsource$ = Rx.Observable.from(['John','Abe','Logan']).map(name => name.toUpperCase()).map(name => `I am ${name}`);
mapsource$.subscribe(console.log);