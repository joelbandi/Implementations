var co = require('co');
var fetch = require('node-fetch');

const url = 'https://jsonplaceholder.typicode.com/posts/1';

// fetch api demonstration
fetch(url).then(response => response.json()).then(data => console.log(`Title is : ${data.title}`))






// the generator function
function* gen() {
    const response = yield fetch(url);
    const data = yield response.json();
    const title = data.post;
    console.log(`Title is : ${data.title}`);
}
co(gen);




// simple generator example
function* generator(){
    for(var i = 1 ; i <=30 ; i++){
        if(i === 15){
            yield "----function paused at 15----";
            continue;
        }
        console.log(i);
    }
}
var iter = generator();
console.log(iter.next().value);
iter.next();




//lets implement our own CO like function library.
var harambe = function (generator) {
    if (generator && generator.constructor.name === 'GeneratorFunction') {

        var iter = generator();
        var promise = iter.next().value;
        promise.then(response => {
            var anotherpromise = iter.next(response).value;
            anotherpromise.then(data => iter.next(data));
        });

    } else {
        throw new Error('Argument should be a generator function');
    }
}
harambe(gen);



//generalized harambe function
var harambev2 = function (generator) {
    if (generator && generator.constructor.name === 'GeneratorFunction') {

       const iterator = generator();
       const iterate = function(iteration){
           if(iteration.done) return iteration.value;
           const promise = iteration.value;
           return promise.then(x => iterate(iterator.next(x)));
       }

       return iterate(iterator.next());


    } else {
        throw new Error('Argument should be a generator function');
    }
}
harambev2(gen)