/* getting particular row field from table and inserting to "Add contact" form */
function reloadPage(){
        location.reload(true);
    }
$(document).ready(function() {
	$("form").keypress(function(e) {
		  //Enter key
		  if (e.which == 13) {
		    return false;
		  }
	});
	$('.selectBotType').on('change', function() {
		var botType =  $('select.selectBotType option[value="' + $(this).val() + '"]').data('value');
		var botId = $(this).children("option:selected").val();
		var action='onSelectBotId';
		$.post("manageBotError.du", {botId : botId, botType : botType, action :action 
		}, function(res) {
			$('.dynamicDiv span').empty();
			$('.dynamicDiv span').append(res);
			$('.hiddenBotId').val(botId);
			$('.hiddenBotType').val(botType);
		})
	});	
});

//fetching last updated errors from the URL
function onChangeMethod(botId01,botType01){
	var botId = botId01.replace("%20", " ");
	var botType = botType01.replace("%20", " ");
	var action='onSelectBotId';
	$.post("manageBotError.du", {botId : botId, botType : botType, action :action 
	}, function(res) {
		$('.dynamicDiv span').empty();
		$('.dynamicDiv span').append(res);
		$('.hiddenBotId').val(botId);
		$('.hiddenBotType').val(botType);
	})
}









