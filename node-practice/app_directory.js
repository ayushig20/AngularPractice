var fs = require('fs');

fs.mkdir('test',function(err){
    fs.readFile('readMe.txt','utf8',function(err,data){
        fs.writeFile('./test/writeMe.txt',data,function(){
            console.log('Directory created along with file');
        });
    });
});

fs.unlink('./test/writeMe.txt',function(err){
    fs.rmdir('test',function(err){
        console.log('directory deleted');
    });
});