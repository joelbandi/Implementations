// Testing the *defaults* arguments features 
var greet = function(name = 'World!'){
	console.log('hello '+ name);
};

greet();
greet('joel');
greet('ronaldo');


// Testing the template-strings features
console.log('============');
function fun(name = 'I'){
	console.log(name+' is fun');
	//template string
	console.log(`${name} is super fun yo !`);
	console.log(`${7*7}`);
}

console.log(`Hi,
	
 My name is Cristiano ronaldo! I play left wigner for RMA
	
 Siiiiiii,
 Ronaldo`);

fun('ronaldo');
fun();

// testing the const festure 
console.log('============');
const PORT = 5000; //cannot change the value now.
console.log(PORT);
	
const person = {
	"name": "joel",
	"age": "22"
}
console.log(person);
person.name = "joe!!!"; //const object entries can be modified 
						//but the object itself cannot be 
console.log(person);


// Testing the let variable decalaratin
console.log('============');
var x = 'what';
var y = 'who';
if(1){
	var x = 'something';
	let y = 'someone';
	console.log(x);
	console.log(y);
}
console.log(x);
console.log(y);

for(let i = 0 ; i< 4 ; i++){//i only accessible in for loop
	console.log(`value of i is ${i}`);//scope cleanup
};


// Testing the spread and rest features
console.log('spread rest============');

var a = [1,2,3,4,5];
var b = [78,9,10];
var unified = ['a','b',...a,'joel',...b]; //spread
console.log(unified);

function welcome(gen,sgt,...other){
	console.log(`welcome general ${gen}`);
	console.log(`welcome seargent ${sgt}`);
	for (var i = other.length - 1; i >= 0; i--) {
		console.log(`welcome soldier ${other[i]}`);
	}
}

welcome('davies','andrew','kingston','dornian','rainer','matty','sanchez');



console.log("=========\n\n\n");


var places = new Array();
places.push('sahara');
places.push('himalayas');
places.push('rock');


places.forEach((place) => console.log(`this is ${place}`));

for(let p of places){
	console.log(`welcome to the ${p}`);
}
console.log("=========\n\n\n");


//objects new features

var map = new Map();

map.set('A key','Some value');

map.set('pika','CHHCHUUUHUCHCHUUUUU');
map.set(1,2);
var thing = {question: "Can i do this?",cool: "Beans"}; //this is important as we h
map.set(thing,"yes you can even put in objects");
var arr = [1,2,3,4,function(){console.log('I is function')}];
map.set(arr,'no way this is possible');

console.log(map.get('A key'));

console.log(map.get('pika'));
console.log(map.has('pika'));

console.log(map.size);

console.log(map.get('test'));
console.log(map.get(thing));
console.log(map.get({question: "Can i do this?",cool: "Beans"})); //This will be undefined as 
//thing is not equal to the new object that we passed into the get function above
//theyre same value wise but not reference wise
console.log(map.get(1));
map.delete(1);
console.log(map.get(1));

map.clear();
console.log(map.size);


console.log("=========\n\n\n");
var galacticos = new Set();

galacticos.add('C.Ronaldo');
galacticos.add('G.Bale');
galacticos.add('D.Beckham');
galacticos.add('Z.Zidane');
galacticos.add('L.Figo');
galacticos.add('N.Ronaldo');

var si = galacticos.has('C.Ronaldo');
console.log(si);
console.log(galacticos.size);
galacticos.delete('G.Bale');
console.log(galacticos.size);
galacticos.add('G.Bale');

console.log("=========\n\n\n");

//New object features!!!!

var age = 31;
var kick = function(){
	console.log('Golazzzoooo!!!');
}
var celebrate = 'siiiiii';

var player = {
	name: "C.Ronaldo",
	age,
	kick,
	celebrate,
	["Ballondor"+(2000+16)]: "IS HERE!!!",
	stepover(n){
		console.log('Steps over the ball '+n+' times.');
	}
}

console.log(player.celebrate);
player.kick();
console.log(player.Ballondor2016);
player.stepover(5);


console.log("=========\n\n\n");
//Destructuring

var arr = ['one','two','three','four'];
var [a,b,c,z] = arr;
console.log(a+b+'-->'+c+z);
var [q,,e,r] = arr;
console.log(q+'-->'+e+r);

var event = {
	where: 'the park',
	when: 'tomorrow'
}


var {when} = event;
var {where} = event;

console.log('event happens at '+where+' '+when);

var pokemon = {
	name: 'Wartortle',
	age: 5,
	attack (){
		console.log('Uses water gun!!!');
	},
	retreat (){
		console.log('Runs away!');
	},
	pokeball (){
		console.log('Get back into pokeball');
	},
	evolution: 'Blastoise'
}


var{age,name,attack} = pokemon;
console.log(age + ' ' + name);
attack();


var{age:old,pokeball,evolution:next} = pokemon; //use ':' to give an alternate name (after :)
// to the property before ':' 
console.log(old+ ' ' + next);
pokeball();

 
function onlyEven(n){
	if(n%2 === 0){
		return ['You have impressed me!'];
	}else{
		return [undefined,{message:"you have given me an odd number :/"}]
	}
}



var [res,err] = onlyEven(3);
if(err){
	console.log(err.message);
}

var [r,e] = onlyEven(2);
if(!e){
	console.log(r);
}

// This is a very common pattern in programming!!!!