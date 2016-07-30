var Sequelize = require('sequelize');
var sequelize = new Sequelize(undefined,undefined,undefined,{
	'dialect': 'sqlite',
	'storage': 'basic-sqlite-database.sqlite'
});


var clone = sequelize.define('clone', {
	name: {
		type: Sequelize.STRING
	},
	age: {
		type: Sequelize.INTEGER
	},
	carrier: {
		type: Sequelize.BOOLEAN
	}
},
{
	freezeTableName: true,
	tableName: 'Clone Registry'
});

sequelize.sync().then(function(){
	console.log('everything is synced!!');
	clone.create({
		name: 'Joel Bandi',
		age: 22,
		carrier: true
	}).then(function(clone){
		console.log('created');
		console.log('====================');
		console.log(clone);
	});
});