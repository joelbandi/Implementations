var option = process.argv;

if(option[2] === '-x'){
    const net = require('net');
    const customstream = new net.Socket({fd: 3}); //fd -> file descriptor as all resources are files in linux I think?
    customstream.write('This message comes from a custom stream')
}


if (option[2] === '-p'){
    process.stdout.write('this message is from the child\n');
    process.exit();   
}else{
    process.stdout.write('You did NOT give me an option -p\n');
    process.exit();
}

