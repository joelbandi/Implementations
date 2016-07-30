// This script in an overview of how to handle functional gymnastics, prototypal inheritance
// and mimicing classical inheritance
var l = '\n=========================';



/*
1.Functions are objects in javascript and they all are constructed from a function called Function.
  You might as well do `new Function();`. Augment Function object to modify all functions.
2.Functions are first class members or citizens
3.The CODE property of a function is invocable
4.All functions inherit from Function object which means every functions gets all methods defined in
  Function.prototype object
*/

// ways to create funtions
console.log('ways to create funtions'+l);
//literal way
var chant = function(){
	console.log('Hala Madrid!!');
}
chant();

//anonymous function
(function(){
	console.log('Hala Madrid!!');
}());

// normal way
function chant1(){
	console.log('Madrid! Madrid!!');
}
chant1();
console.log(l);


console.log('Argument array'+l);
// argument array: When the number of arguments in knows at runtime only

/*
All Function objects have another property called arguments which is like an 
array but not really an array. (A bad design in the language!!)
It stores all the arguments given to a function in it
The arguments propert just has a length property within it.
*/
var concat = function(){
	var str = '';
	for(var i = 0 ; i<arguments.length ; i++){
		str += arguments[i];
	}
	console.log(str);
}
concat('a'+'b'+'c'+'d'+'e'+'f');
console.log(l);




//Invocation patterns!!
console.log('Invocation patterns!!'+l);
/*Invoking a function means executing the code stored in the CODE property of the function object.
when use attach the `()` to a function object that tells the js compiler that it should invoke the
function object.
Functions are objects with many properties like Code property (which is an invocable property)
It has methods like call, apply and bind, through which we do lots of powerul stuff and achieve
complete object oriented style inheritance
This is allows us to come up with very expressive patterns and constructs in javascript
*/



// Method invocation pattern
var thing = {
	who: "Tis' I, Tim.",
	greet: function(msg){
		var who = "Tis' I, Bartholomew";
		console.log(msg+' to you too sire.');
		console.log(this.who); //This points to the object that contains this function
		//This prints out `Tis' I, Tim.`
		//Its weird I know, This is a bug in the language.
	}
}
console.log(thing.who);//no need to invoke as it is not a function
console.log(thing.greet);//not invoked yet.
thing.greet('Good day'); //invoked!!


//function invocation pattern
//normal stuff
var greetme = function(){
	var who = 'joel';
	console.log('hello '+ this.who); //this still points to the global object here....
	console.log('hello '+ who);
}
greetme();
var greet = {
	where: 'other side'
}
greet.greetme = function(){
	var that = this;
	var where = 'underworld';
	var functiongreet = function(){
		console.log('Hello from the '+ that.where);
		console.log('Hello from the '+ where);
		//In functiongreet's function scope this points to the global for some fucked up reason
	}
	functiongreet();
}
greet.greetme();



//Constructor invocation pattern
//This is how we define classes 
var Pokemon = function(name,type,cp,lvl){ //here class names are capitalized for convention
	this.name = name;
	this.type = type;	//this is where you'd setup the member fields 
	this.cp = cp;
	this.lvl = lvl;
}

Pokemon.prototype.info = function(test,demo){
	console.log(this.name+' is a level '+this.lvl+', '+this.type+' type pokemon with '+this.cp+' attack power.');
	console.log(test+demo);
}


var pikachu = new Pokemon('Pikachu','electric',152,8);
pikachu.info();
//Pikachu is a level 8, electric type pokemon with 152 attack power.

/* new keyword does ->Creates a new empty object ,executes the Pokemon function we defined
 earlier and returns , sets the this variable to the empty object and returns the object */

// We can even namespace and package functionality
// by adding extra methods and vars to Pokemon.prototype and then
Pokemon.prototype.offence = {
	quickattack: function(){
		console.log('Opponent damaged!!');
		return this; // You can even chain methods to emulate attack chains!!
	},
	tackle: function(){
		console.log('dashes into opponent');
		return this;
	}
}
Pokemon.prototype.offence.claw = function(){
	console.log('opponent clawed');
	return this;
}
pikachu.offence.claw().tackle().quickattack(); //chainable methods

//Every Function object contains the bind(),call() and apply() methods so every
// function that you ever created has access to these. instead of invoking them we
// use the dot operator to invoke these functions

/*
bind() returns the function object with this pointer set to the object passed in the argument to call()
call() same as bind() except we can also pass arguments to functions and also calls
apply() same as call() except we can pass agruments in the form of an array
*/
var electabuzz = {
	type:"thunder",
	cp:"200",
	name:"electabuzz",
	lvl:"45"
}
pikachu.info.bind(electabuzz)();
pikachu.info.call(electabuzz,'one','two');	//Electabuzz doesnt even have this function!!
pikachu.info.apply(electabuzz,['one','two']); //This is also called function borrowing!!
pikachu.offence.thunder = function(){ //only pikachu gets this function and no other pokemon
	console.log(this.name+ '\'s thunder strikes opponent!!');
	return this;
}
pikachu.offence.thunder(); //wont work for pikachu as this is pointing to offence object in the prototype and not in pikcahu object 
pikachu.offence.thunder.apply(electabuzz);
console.log(l);





console.log('function currying'+l);
// an interesting way to modify functions similar to function templating or factory pattern
// You need to understand closures and scopes in javascript for this
var add = function(a,b){
	return function(val){
		return a+val;
	};
}

var increment = add(1);
// closure magic happening here!!!
console.log(increment(4)); //5
console.log(l);




