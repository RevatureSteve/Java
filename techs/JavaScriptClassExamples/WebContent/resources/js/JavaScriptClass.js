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



//--------------------Type coercion
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

//-----------------Objects
var book = {
		title: "Harry Potter",
		year: 2001,
		author: {
			name: "JK",
			dob: 1965
		}
		
};

//-------------No Function Overloading
function sumNum(x,y,z){
	console.log(x+y+z);
}

function sumNum(x,y){
	console.log(x+y + " in x,y");
}

//--------Implicit arguments object
function sumNum(){
	console.log("nothing");
	console.log(arguments[0]+ arguments[1] + arguments[2]);
}




var count = 0;

//var birdCounter = 0;
//var carCounter = 0;
//

//function countBird(){
//	birdCounter++;
//	return birdCounter + " birds";
//}
//
//function countCar(){
//	carCounter++;
//	return carCounter + " Cars";
//}

//CLOSURE!!!!!!! 
//JavaScript's Form of encapsulation
function makeBirdCounter(){
	var birdCounter = 0;
	
	function countBird(){
		birdCounter++;
		return birdCounter + " birds";
	}
	
	return countBird;
}

function makeCarCounter(){
	var carCounter = 0;
	
	return 	function (){
		carCounter++;
		return carCounter + " cars ";
	}
}

function makeCounter(myTypeOfCounter){
	var count = 0;
	return function(){
		count++;
		return count +" " + myTypeOfCounter +"s";
	}
	
}


var idx = 0;
function handler(event){
	
	console.log("%s--%s", idx++, this, event);
	
	event.stopPropagation();
}

window.onload = function(){
	document.getElementById("outer").addEventListener("click", handler, false);
	document.getElementById("inner").addEventListener("click", handler, false);
	document.getElementById("innerMost").addEventListener("click", handler, false);
	
}




























