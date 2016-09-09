/**
 *  Street Fighter js
 */



//Load Javascript
$(document).ready(function(){
	console.log("Document is ready");
	//show ryu-ready on mouseenter
	$('.ryu').mouseenter(function(){
		$('.ryu-standing').hide();
		$('.ryu-ready').show();
		
		//Hide ryu-ready on mouseleave
	}).mouseleave(function(){				//Chaining functions
		$('.ryu-standing').show();
		$('.ryu-ready').hide();
	}).mousedown(function(){
		playHoudoken();
		$('.ryu-standing').hide();
		$('.ryu-ready').hide();
		$('.ryu-throwing').show();
	}).mouseup(function(){
		$('.ryu-throwing').hide();
		$('.ryu-ready').show();
	})
})

	
	
	
	
	//Play hadouken-sound on mousedown
function playHoudoken(){
	$('#hadouken-sound')[0].volume = 0.2;
	$('#hadouken-sound')[0].play();
	
}

	//show throwing, hide ready
	//Animate hadouken gif 
	
	//mouseup - hide throwing, show ready 
	
//---
//document ready keydown 'x'
//playPose, show cool, hide still, hide ready
$(document).keydown(function(e){
	
	//x e keycode 
	if(e.keyCode == 88){
		playPose();
		$('.ryu-cool').show();
		$('.ryu-still').hide();
		$('.ryu-ready').hide();
	}
}).keyup(function(e){
	if(e.keyCode == 88){
		$('#survivor-sound')[0].pause();
		$('#survivor-sound').load(); //reload the audio file to reset sound
		$('.ryu-cool').hide();
	}
})

//Play hadouken fn - volume, load, play
//Play prose fn 
function playPose(){			//keyup 'x' pose-sound pause/load, hide cool
								//if hover show ready else show still
								//---
	$('#survivor-sound')[0].volume = 0.2;
	$('#survivor-sound')[0].play();
}
