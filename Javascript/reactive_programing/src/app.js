import $ from 'jquery';
import Rx from 'rxjs/Rx';



const btn = $('#btn');
// create an obervable from a button's click event
const btnstream$ = Rx.Observable.fromEvent(btn,'click');
// subscribe to Observable
btnstream$.subscribe(
  (event) => console.log(event.target.innerHTML),
  (err) => console.log(err),
  () => console.log('completed')
);


const input = $('#input');
const inputstream$ = Rx.Observable.fromEvent(input,'keyup');
inputstream$.subscribe( console.log );


// you can create an observable from an array
const numbers = [33,11,22,44,55,66,77,88];
const numbers$ = Rx.Observable.from(numbers);
numbers$.subscribe(
  console.log,
  err => console.log(err),
  () => console.log('completed')
);


// from an array of objects
const posts = [
  {name:'john',msg:'hello'},
  {name:'jane',msg:'hii'},
  {name:'kate',msg:'hola'}
]
const posts$ = Rx.Observable.from(posts);
posts$.subscribe(console.log,console.log,()=>console.log('done'));
posts$.subscribe(
  post => {
    $("#ul").append(`<li><h3>${post.name} says ${post.msg}</h3></li>`)
  },
  console.log,
  () => {
    $("#ul").append('end of posts');
  }
)


// from a javascript collection -> set and map
const set = new Set(['hello',44,{key:'value'}]);
const set$ = Rx.Observable.from(set);
set$.subscribe(
  console.log,
  console.log,
  () => console.log('SET COMPLETE')
);

const map = new Map([[12,33],[{a:1},5],['txt',55],['a',[1,2,3]]]);
const map$ = Rx.Observable.from(map);
map$.subscribe(
  console.log,
  console.log,
  () => console.log('MAP COMPLETE')
);


// create a custom observable from a custom data source

const source$ = new Rx.Observable(observer => {
  console.log('created observable');

  observer.next('one');
  observer.next('two');


  setTimeout( () => {
    observer.next('delayed-three');
    observer.complete();
  },2000 );

  observer.error(new Error('Error: something went wrong'));


});

source$.
catch( err => Rx.Observable.of(err)).
subscribe(
  (number) => console.log(`Received from observable: ${number}`),
  console.log,
  () => console.log('complete')
);


// create an observable from a promise
const promise = new Promise((resolve,reject) => {
  console.log('Promise Created');
  setTimeout(() => {
    resolve('The promise has been resolved');
  },3000);
});

// To run this promise in the traditional way
promise.then(
  console.log, //resolve function
  console.log // reject function
);

const promise$ = Rx.Observable.fromPromise(promise);

promise$.subscribe(
  msg => console.log(`message from observable -> ${msg}`),
  console.log,
  () => console.log('complete')
);



// Lets make a basic app fetching data from github api
function getUser(username){
  return $.ajax({
    url:`https://api.github.com/users/${username}`,
    dataType: 'jsonp'
  }).promise();
};

const github$ = Rx.Observable.fromEvent($('#github-input'),'keyup')
github$.subscribe(
  (event) => {
    getUser(event.target.value).then((response) => {
      const { name,followers } = response.data;
      if (name == null){
        $("#github-data").text(`Username not found`);
      }else{
        $('#github-data').text(`My name is ${name} and I have ${followers} followers`);
      }
    });
  }
);