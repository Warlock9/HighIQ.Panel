
/* getting particular row field from table and inserting to "Add contact" form */
/* getting particular row field from table and inserting to "Add contact" form */
function reloadPage(){
        location.reload(true);
    }
$(document).ready(function() {	
			$('.selectBotType').on('change', function() {
				$("form").keypress(function(e) {
					  //Enter key
					  if (e.which == 13) {
					    return false;
					  }
				});
				var botType =  $('select.selectBotType option[value="' + $(this).val() + '"]').data('value');
				var botId = $(this).children("option:selected").val();
				var action='onSelectBotId';
				$.post("botParameter.du", {botId : botId, botType : botType, action :action 
				}, function(res) {
					$('.authButton Button').remove();
					if(botType=="Accounts Payable"){
/*						$('.authButton').append("<button type='button' class='btn btn-info btn-sm col-sm-2 btnTestMailAuth'>Verify Mail Connectivity</button>");
*/					}
					$('.dynamicDiv span').empty();
					$('.dynamicDiv span').append(res);
					$('.hiddenBotType').val(botId);
				});
				
				/*append copyFrom drop down*/
				if(botId!=""){
					$.post("botParameterCopyFrom.du", {botId : botId, botType : botType,}, function(res) {
						$('.copyFromOtherParameter').remove();
						$('.dynamicSelect').append(res);
					});
				}else{
					$('.copyFromOtherParameter').remove();
				}
			});		
			
			/*when copy button clicked*/
			$('.dynamicSelect').on('click', '.copyFromButton', function() { 
					var botType =  $('select.copyFromselectBotType option[value="' + $('.copyFromselectBotType').val() + '"]').data('value');				
					var botId = $('.copyFromselectBotType').children("option:selected").val();
					var action='onSelectBotId';
					if(botId!=""){
						$.post("botParameter.du", {botId : botId, botType : botType, action :action 
						}, function(res) {
							$('.dynamicDiv span').empty();
							$('.dynamicDiv span').append(res);
							 $('#updateConfirmModal').modal();
						});
					}
			});
			
			/*Testing mail authentication on click on authentication button*/
			$('.dynamicDiv').on('click', '.btnTestMailAuth', function() { 
				var userMail = $('.vEmailDigitalEmp').val();
				var userPass = $('.vEmailPassword').val();
				var hostName = $('.vHostName').val();
				var portNum  = $('.vPortNumber').val();

				if(userMail!="" && userPass!="" && hostName!="" && portNum!=""){		
					showLoader();
					disableScreen();
					$.post("imapAuthentication.do",{userMail:userMail,userPass:userPass,hostName:hostName,portNum:portNum},function(res){
						disableLoader();
						enableScreen();
						$('#duplicateIdSpan').html(res);
						$('#duplicateConfirmModal').modal();
					});
				}else{
					$('#duplicateIdSpan').html("please supply values for parameters <b> vEmailDigitalEmp, vEmailPassword, vHostName, vPortNumber </b>");
					$('#duplicateConfirmModal').modal();
				}
			})
});

		//fetching last updated parameters
		function onChangeMethod(botId01){
			var botId02 = botId01.replace("%20", " ");
			var botType =  $('select.selectBotType option[value="' + botId02 + '"]').data('value');
			var botId = $('select').children("option:selected").val();
			var action='onSelectBotId';
			
			$.post("botParameter.du", {botId : botId, botType : botType, action :action 
			}, function(res) {
				$('.authButton Button').remove();
				if(botType=="Accounts Payable"){
/*					$('.authButton').append("<button type='button' class='btn btn-info btn-sm col-sm-2 btnTestMailAuth'>Verify Mail Connectivity</button>");
*/				}
				$('.dynamicDiv span').empty();
				$('.dynamicDiv span').append(res);
				$('.hiddenBotType').val(botId);
			})
			if(botId!=""){
				$.post("botParameterCopyFrom.du", {botId : botId, botType : botType,}, function(res) {
					$('.copyFromOtherParameter').remove();
					$('.dynamicSelect').append(res);
				});
			}else{
				$('.copyFromOtherParameter').remove();
			}
		}
		
		/*Loader */
		function showLoader() {
			  document.getElementById("loader").style.display = "block";
		      //document.getElementById("blockPage").style.display = "block";
			}
		function disableLoader() {
				 document.getElementById("loader").style.display = "none";
			}

		/*Disable Screen*/
		function disableScreen() {
		    // creates <div class="overlay"></div> and 
		    // adds it to the DOM
		    var div= document.createElement("div");
		    div.className += "overlay";
		    document.body.appendChild(div);
		}
		function enableScreen() {
			 $(".overlay").remove();
		}