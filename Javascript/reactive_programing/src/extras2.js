// Merge and concat functions

const Rx = require('rxjs/Rx');

// This merges the two observables into a single observable
// console.log(`s1\ts2`);

// Rx.Observable.interval(500).take(10).map(x => `${x}\t--`)
//   .merge(Rx.Observable.interval(200).take(15).map(x => `--\t${x}`))
//   .subscribe(
//     console.log,
//     console.log,
//     () => console.log('completed')
//   );


/* results of merge
s1  s2
--	0
--	1
0	--
--	2
--	3
1	--
--	4
--	5
--	6
2	--
--	7
--	8
3	--
--	9
--	10
--	11
4	--
--	12
--	13
5	--
--	14
6	--
7	--
8	--
9	--
completed

*/





// This concats the two streams one after an another
console.log(`s1\ts2`);

Rx.Observable.interval(500).take(3).map(x => `${x}\t--`)
  .concat(Rx.Observable.interval(200).take(5).map(x => `--\t${x}`))
  .subscribe(
    console.log,
    console.log,
    () => console.log('completed')
  );

/*
results of concat
s1	s2
0	--
1	--
2	--
--	0
--	1
--	2
--	3
--	4
completed

*/