var express = require('express');
var app = express();

var middleware = require('./middleWare.js');

app.set('view engine', 'ejs');
app.use('/', express.static(__dirname + "/public"));

// localhost:3100/person/joel
app.get('/person/:name', function (request, response) {
	response.render('person', { name: request.params.name }); //hello joel.
});

// localhost:3100/human?name=joel
app.get('/human', function (request, response) {
	response.render('person', { name: request.query.name }); //hello joel.
});

app.get('/about', function (request, response) {
	response.send('About Us');
});

app.listen(3100, function () {
	console.log('Server running on port number 3100');
});
