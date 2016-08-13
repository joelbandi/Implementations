var loadPage = function(){
    return {
        data:'<page>',
        status:200
    };
}

var loadAnotherPage = function(){
    return {
        data:'<page>',
        status:404
    };
}


new Promise(function(resolved,rejected){
    var page = loadPage();
    var data = page.data;
    var status = page.status;
    if(status === 200){
        resolved(data);
    }else{
        rejected(status);
    }
}).then(function(v){
    console.log('successfull with value '+v);
}).catch(function(v){
    console.log('Error with code '+v);
});


new Promise(function(resolved,rejected){
    var page = loadAnotherPage();
    var data = page.data;
    var status = page.status;
    if(status === 200){
        resolved(data);
    }else{
        rejected(status);
    }
}).then(function(v){
    console.log('successfull with value '+v);
}).catch(function(v){
    console.log('Error with code '+v);
});
