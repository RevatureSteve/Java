/**
 * 
 */

angular.module('todoListApp')
				//The directive is camel case then it turns into an HTML element separated by a -
				//HTML is case sensitive and by convention we use lower case tags
				//can also be used a div attribute
	.directive('helloWorld', function(){
		return {
			template: "Hello world directive! - My first",
			restrict: "A"	
		};
		
	})
	
	
		
		
		
		