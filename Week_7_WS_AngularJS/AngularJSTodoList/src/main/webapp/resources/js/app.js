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
		
		$scope.todos = [{'name':'clean board'},{'name':'be awesome'},{'name':'Nevermind too Awesome Already'}]
		
	})
