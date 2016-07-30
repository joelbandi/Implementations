function one(success) {
    return new Promise(function(resolve,reject){
    	if(success === true){
    		resolve('resolved!');
    	}else{
    		reject('rejected');
    	}
    });
}
one(false).then(function(data){
	console.log(data);
},function(data){
	console.log(data)
});

console.log('===========');

one(true).then(function(data){
	console.log(data);
	return one(true);
}).then(function(data){
	console.log(data);
	return one(false);
}).then(function(data){
	console.log(data);
});


//promises are just plain weird...

