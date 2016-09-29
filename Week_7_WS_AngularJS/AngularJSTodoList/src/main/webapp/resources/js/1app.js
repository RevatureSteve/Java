/**
 *  SkangularJS
 */

angular.module('todoListApp',[])  //[] tells angular to create a project with the name passed in 
								  //not providing the [] will tell angular one already exists

	.controller('mainCtrl', function($scope){
		$scope.helloworld = function(){
			console.log("Hello from our mainctrl")
		}
		
		$scope.myVar = 123123;
		
	})
	
	.controller('siblingCtrl', function($scope){
		$scope.sibOfMainCtrl = function(){
			console.log("Hello Sibling")
		};
	})
	
	.controller('childofMainCtrl', function($scope){
		$scope.flashSmile = function(){
			console.log(" : ) ")
		}
	})
