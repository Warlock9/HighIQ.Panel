/* getting particular row field from table and inserting to "Add contact" form */
function reloadPage() {
	location.reload(true);
}
function AvoidSpace(event) {
	var k = event ? event.which : window.event.keyCode;
	if (k == 32)
		return false;
}
$(document).ready(function() {

	$("form").keypress(function(e) {
		  //Enter key
		  if (e.which == 13) {
		    return false;
		  }
	});
	
	//update button is disabled on page loading 
	$(".btn-update").hide();
	// code to read selected table row cell data (values).
	$(".myTable").on('click', '.btnSelect', function() {
		// get the current row
		var currentRow = $(this).closest("tr");
		var botId = currentRow.find("td:eq(0)").text();
		var botType = currentRow.find("td:eq(1)").text();
		var botName = currentRow.find("td:eq(2)").text();
		var botEmailId = currentRow.find("td:eq(3)").text();
		var botManagerFirstName = currentRow.find("td:eq(4)").text();
		var botManagerLastName = currentRow.find("td:eq(5)").text();
		var botManagerMailId = currentRow.find("td:eq(6)").text();

		$("html, body").animate({
			scrollTop : 0
		}, "fast"); // scrolling action to top of page

		$(".botId").val(botId.trim());
		$(".botId01").val(botId.trim());
		$(".botType").val(botType.trim());
		$(".botName").val(botName.trim());
		$(".botEmailId").val(botEmailId.trim());
		$(".botManagerFirstName").val(botManagerFirstName.trim());
		$(".botManagerLastName").val(botManagerLastName.trim());
		$(".botManagerMailId").val(botManagerMailId.trim());
		$(".btn-submit").hide(); // disabling submit button
		$(".btn-update").show();//enabling the update button
		$(".card-title1").html("Edit Bots");
		$(".botId").css('pointer-events', 'none');
		$(".botId").prop('readonly', true);
	});
});

$(document).ready(function() {
	$(".btn-submit").mouseover(function() {
		var inputBotId = $(".botId").val();
		$.post('validateBotId',{botId:inputBotId},function(res){
			if(res=="1"){
				$('#duplicateIdSpan').html("Duplicate bot id : "+inputBotId);
				$('#duplicateConfirmModal').modal();
				$('.botId').val("");
			}
		});
		
		var botType=$(".botType").val();
		var botEmail = $(".botEmailId").val();

		$.post('validateBotMailId',{botType:botType,botEmail:botEmail},function(res){
			if(res!=""){
				$('#duplicateIdSpan').html("Duplicate bot email id : "+botEmail);
				$('#duplicateConfirmModal').modal();
				$('.botEmailId').val("");
				$('.botType').val("");
			}
		});
		
	});
	
	$(".btn-update").mouseover(function() { 
		var botType=$(".botType").val();
		var botEmail = $(".botEmailId").val();
		var botId = $(".botId").val();
		$.post('validateBotMailId',{botType:botType,botEmail:botEmail},function(res){

			if(res==botId){

			}else if(res==""){
				
			}else{
				$('#duplicateIdSpan').html("Duplicate bot email id : "+botEmail);
				$('#duplicateConfirmModal').modal();
				$('.botEmailId').val("");
				$('.botType').val("");
			}
		});
	});
	
	$(".btnDelete").click(function() { 
		var botId = $(this).val();
		$.post('botDetails.del',{botId:botId},function(res){
			if(res=="0"){
				$('#duplicateIdSpan').html("Bot Id : "+botId+" can not be deleted.");
				$('#duplicateConfirmModal').modal();
				$('.botEmailId').val("");
				$('.botType').val("");
			}else{
				location.reload(true);
			}
		});
	});
});
