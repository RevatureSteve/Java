/**
 *  SkangularJS
 */

angular.module('todoListApp',[])  //[] tells angular to create a project with the name passed in 
								  //not providing the [] will tell angular one already exists

	.controller('mainCtrl', function($scope, dataService){
		$scope.helloworld = function(){
			console.log("Hello from our mainctrl")
		}
		
		$scope.myVar = 123123;
		
		$scope.helloConsole = dataService.helloConsole;
		
//		$scope.todos = [{'name':'clean board'},{'name':'be awesome'},{'name':'Nevermind too Awesome Already'}]
		
		$scope.getTodos = dataService.getTodos(
							//Passed in the Callback Function
							function(response){
								console.log(response.data)
								$scope.todos = response.data;
							})	
							
							
		$scope.saveTodo = function(todo){
							console.log('About to save ' + todo.name)
							
							$scope.updateTask = dataService.saveTodo(todo);
						}
	})

	/*
	*	Services
	*
	*	-Services allow you to create a reusable set of functions and values that can be passed across
	*the application. 
	*	-Services are useful for getting data from a database, as well as firing save, edit, and delete operations
	*	-Services can share data between controllers
	*
	*/
	
	.service('dataService', function($http,$q){
		this.helloConsole = function(){
			console.log('this is the service function');
		}
		this.getTodos = function(callback){
			$http.get('resources/js/todos.json').then(callback) //callback is the function that take a Response
		}
		
		this.saveTodo = function(todo){
			var promise = $http.post('rest/save',todo).then(
					function(response){
						console.log(response + ' YAY!');
					},
					function(error){
						console.log( $q.reject(error) );
					}	
			)
		}
		
	})