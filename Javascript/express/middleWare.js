var middleWare = {
	first: function (request, response, next) {
		console.log('first');
		console.log("request: " + request.method + "->  '" + request.originalUrl + "' at (" + new Date().toString() + ")");
		next();
	},
	second: function (request, response, next) {
		console.log('second');
		console.log("request: " + request.method + "->  '" + request.originalUrl + "' at (" + new Date().toString() + ")");
		next();
	},
	third: function (request, response, next) {
		console.log('third');
		console.log("request: " + request.method + "->  '" + request.originalUrl + "' at (" + new Date().toString() + ")");
		next();
	},
	fourth: function (request, respone, next) {
		console.log('fourth');
	}
}


module.exports = middleWare;