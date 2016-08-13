var doWork = function(x){
    if(x === true) {
        return 15;
    }else if(x === false){
        return 10;
    }else{
        return 5;
    }
}


var asyncwork = new Promise(function(resolve,reject){
    var value = doWork(true);
    if(value > 10){
        resolve(value);
    }else if(value === 10 ){
        resolve(value)
    }else{
        reject(value);
    }
});

var asyncwork2 = new Promise(function(resolve,reject){
    var value = doWork(false);
    if(value > 10){
        resolve(value);
    }else if(value === 10 ){
        resolve(value)
    }else{
        reject(value);
    }
});

var asyncwork3 = new Promise(function(resolve,reject){
    var value = doWork();
    if(value > 10){
        resolve(value);
    }else if(value === 10 ){
        resolve(value)
    }else{
        reject(value);
    }
});

//this is one way of executing this stuff
asyncwork.then(function(v){
    console.log('asyncwork is resolved with a value of '+v); // this is the resolve
},function(v){
    console.log('asyncwork is rejected with a value of '+v); // this is the reject
});

asyncwork2.then(function(v){
    console.log('asyncwork is resolved with a value of '+v);
},function(v){
    console.log('asyncwork is rejected with a value of '+v);
});


asyncwork3.then(function(v){
    console.log('asyncwork is resolved with a value of '+v);
},function(v){
    console.log('asyncwork is rejected with a value of '+v);
});

// Another way of executing promises are
//RECOMMENDED WAY of writing it

asyncwork.then(function(v){
    console.log('NEW WAY: asyncwork resolved to '+v); // this is the resolve
}).catch(function(v){
    console.log('NEW WAY: asyncwork rejected to '+v); // this is the reject
});

asyncwork2.then(function(v){
    console.log('NEW WAY: asyncwork resolved to '+v);
}).catch(function(v){
    console.log('NEW WAY: asyncwork rejected to '+v);
});

asyncwork3.then(function(v){
    console.log('NEW WAY: asyncwork resolved to '+v);
}).catch(function(v){
    console.log('NEW WAY: asyncwork rejected to '+v);
});