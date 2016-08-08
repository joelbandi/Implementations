var obj = {
	key:'value',
	what:function(){
		console.log(this.key);
		this.key = 'another value';

		// this points to the object that this functions is contained ...what in the actual fuck
	}
}

