var loadAnotherPage = function(){
    return {
        data:'<page>',
        status:404
    };
}

new Promise(function(resolved,rejected){
    var page = loadAnotherPage(); //this will return an obj
    var data = page.data;
    var status = page.status; // its 404
    if(status === 200){
        resolved(data);
    }else{
        rejected(status); //it is settled here with a reject
    }
}).catch(function(v){ //The first catch encountered will be executed and its this in this case
    console.log('ORDER :first catch : Error with code '+v); //this is printed
    return new Promise(function(res,rej){ // and to show that this error is succesfully handled  we shoot another promise
        res('404'); // the next then it sees will be executed
        // or
        rej('404'); // the next catch it sees will be executed
    })
}).then(function(v){ //this will be executed in this case because the previous promise is calling res() first and once its settled no more settlements take place and rej() will be ignored
    console.log('ORDER :successfull with value '+v); //therefore this will be printed
}).catch(function(v){
    console.log('ORDER :Error with code '+v);
})
// ^^ output: 
// ORDER :first catch : Error with code 404
// ORDER :successfull with value 404
