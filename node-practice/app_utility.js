var counter = function(arr){
return 'The lenght of array is '+ arr.length;
};

var counter1 = function(arg){
    return 'The square of' + arg +' is '+ (arg*arg);
};
//module.exports.counter1 = counter1;
//module.exports.counter = counter;

var addition = function(arg1,arg2) {
    return arg1+arg2;
};
var subtraction = function(arg1,arg2) {
    return arg1-arg2;
};
module.exports = {
    counter1 : counter1,
    counter : counter,
    addition: addition,
    subtraction: subtraction
};