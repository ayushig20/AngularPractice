var http = require('http');
var fs = require('fs');

//var myReadStream = fs.createReadStream(__dirname + '/readMe.txt','utf8');

var server = http.createServer(function (req, res) {
    console.log('Request : ' + req.url);
    if(req.url === '/home' || req.url === '/'){
        res.writeHead(200, {'Content-Type': 'text/html'});
        fs.createReadStream(__dirname+'/index.html').pipe(res);
    }
    else if(req.url === '/contact'){
        res.writeHead(200, {'Content-Type': 'text/html'});
        fs.createReadStream(__dirname+'/contact.html').pipe(res);
    }
    else if(req.url === '/api/ninjas'){
        var ninjas = [{name:'ashish',age:30},{name:'ayushi',age:27},{name:'chikku',age: 9}];
        res.writeHead(200, {'Content-Type': 'application/json'});
        res.end(JSON.stringify(ninjas));
    }else{
        res.writeHead(404, {'Content-Type': 'text/html'});
        fs.createReadStream(__dirname+'/404.html').pipe(res);
    }
     
    //res.end('heyyyyyyyyyy from server...')
});

server.listen(3000,'127.0.0.1');
console.log('Now listening to 3000');

