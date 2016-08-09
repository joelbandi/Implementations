var Emitter = function () {
    this.events = {}
}

Emitter.prototype.on = function (type, listener) {
    if (typeof type === 'string' && listener.constructor === Function) {
        if (!(this.events[type])) {
            this.events[type] = [];
            this.events[type].push(listener);
        } else {
            this.events[type].push(listener);
        }
    }
}



Emitter.prototype.emit = function (type, cb) {
    if (typeof type === 'string') {
        if (this.events[type]) {
            this.events[type].forEach(function (fn) {
                fn();
            });
        }
        if (cb && cb.constructor === Function) {
            cb();
        } else {
            console.log('callback should be a function');
        }
    }
}


module.exports = Emitter;