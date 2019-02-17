//Global Objects

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

