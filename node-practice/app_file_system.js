var fs = require('fs');

/*var readFile = fs.readFileSync('readMe.txt');
console.log("Read Content :: "+readFile);
*/

//fs.writeFileSync('writeMe.txt',readFile + 'It is really awesome.');

fs.readFile('readMe.txt','utf8',function(err,data){
    //console.log("Read Content :: "+ data);
    fs.writeFile("writeMe1.txt",data,function(){
        console.log('Completed writing')
    });
});