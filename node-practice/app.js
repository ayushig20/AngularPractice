//Global Objects
var MyMethods  = require('./app_utility');
console.log("Welcome ot Node JS WORLD");
setTimeout(function(){
    console.log('3 second passed away');
},3000);

console.log(__dirname);
console.log(__filename);


var time = 0;
var timer = setInterval(function(){
    time += 2;
    console.log(time + " second passed...");
    if(time > 5){
        clearInterval(timer);
        console.log("Interval Cleared");
    }
},2000);

console.log(MyMethods.counter(['as','ds','sd','we']));
console.log(MyMethods.counter1(5));
console.log(MyMethods.subtraction(8,5));
console.log(MyMethods.addition(8,5));