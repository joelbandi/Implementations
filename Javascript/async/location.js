var request = require('request');
var requestobj = {
	url: 'http://ipinfo.io',
	json: true
};


module.exports = function (callback) {

	request(requestobj, function (error, response, body) {
		if (error) {
			callback('Error while fetching location ' + error);
		} else {
			callback('Your location is ' + body.city + ', ' + body.region + '.');
		}
	});
}