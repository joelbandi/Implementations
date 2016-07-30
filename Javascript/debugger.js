var list = [];
var add = function(thing){
    list.push(thing);
    debugger;
    console.log(list);
}

add(15);
add({
    thing: 'yes',
    yes: 'no',
    why: true
});
add('hello world yaam');


