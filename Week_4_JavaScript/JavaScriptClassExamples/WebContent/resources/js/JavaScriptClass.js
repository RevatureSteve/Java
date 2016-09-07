/**
 * JavaScript Week
 */

//Global Variables
var a, b, c, d, e, f, g, h, i;

a = 10;
b = "10";
c = true;
d = {};
e = null;
//f
g = (0/0);
h = [];
i = function(){};

//--------------------Strings are immutable
var myString = 'hello';
function changeString(myVar){
	console.log(myVar);
	myVar = "changed that string";
	console.log(myVar);
	return "did it change that string? check myString again"; //no it did not
}



//--------------------Type cocercion
//5 == 5
//5 === 5

//5 == "5"
//5 === "5"

//false == "false" --false
//false === "false" --false

//false == 0 --true
//false === 0 --false

//5 != "5"
//5 !== "5"

//------------------Operators
/*
 * var x = 5 + 6;
 * x = 5 + 6 + "hello";
 * x = "hello" + 6 + 5;
 * x = +"42";
 */

//----------------!! evaluate expression
/*
 * !!42
 * x = ""
 * !!x
 */

//2 Scopes in JavaScript Global and Function

//--------------Hoisting, bring declarations to the top of the scope
function incrementX(){
	x= 1;//implied global
	return x;
}

//--------------Semicolon injection, Javascript attempted to not require semicolons 
//										but you should defined your own
function incrementY(){
	var y;
	y= "1";
	return  //JS will inject a semicolon ; by the return statement, hard to debug
			y;
}



//---------------Return && Gaurd Operator
function guardOperator(myVar){
		return myVar && "2nd"; //first statement truthy? return the SECOND statement
}

//---------------Return || Default Operator
function defaultOperator(myVar){
	return myVar || "2nd"; //first statement truthy? return the FIRST statement
}




