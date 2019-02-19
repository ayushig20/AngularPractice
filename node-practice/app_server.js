var http = require('http');
var fs = require('fs');

var myReadStream = fs.createReadStream(__dirname + '/readMe.txt','utf8');

var server = http.createServer(function (req, res) {
    console.log('Request : ' + req.url);
    res.writeHead(200, {'Content-Type': 'text/plain'});
    myReadStream.pipe(res);
    //res.end('heyyyyyyyyyy from server...')
});

server.listen(3000,'127.0.0.1');
console.log('Now listening to 3000');

