var agent = require('superagent');
//extract arguments
var url = process.argv[2];
agent
	.get(url)
	.end(function(err,res){
		if(!err && res.status===200){
			console.log("Headers:")
			console.log(res.headers);
			console.log("\nStatusCode:");
			console.log(res.statusCode);
		}
	});
