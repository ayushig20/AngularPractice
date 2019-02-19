var fs = require('fs');

var myReadStream = fs.createReadStream(__dirname + '/readMe.txt', 'utf8');
var myWriteStream = fs.createWriteStream(__dirname + '/writeMe.txt');

/*myReadStream.on('data', function (chunk) {
    console.log("on data chunk :: ")
    myWriteStream.write(chunk);
});*/

myReadStream.pipe(myWriteStream);