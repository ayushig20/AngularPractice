var express = require('express');
var app = express();

app.set('view engine','ejs');

app.get('/',function(req,res){
    //res.sendFile(__dirname+'/index.html');
    res.render('index');
});

app.get('/contact',function(req,res){
    //res.sendFile(__dirname+'/contact.html');
    res.render('contact');
});

app.get('/profile/:name',function(req,res){
    //res.send('You are viewing the profile of '+ req.params.name);
    var data = {age:27,job:'IT services',hobbies:['playing','cooking','eating']}
    res.render('profile',{person: req.params.name, data:data})
});

app.listen(3000);
console.log('listening on port 3000...')