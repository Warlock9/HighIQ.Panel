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
		var userName = currentRow.find("td:eq(0)").text();//primary key
		var password = currentRow.find("td:eq(1) span").text();
		var emailId = currentRow.find("td:eq(2)").text();
		var firstName = currentRow.find("td:eq(3)").text();
		var lasName = currentRow.find("td:eq(4)").text();
		var role = currentRow.find("td:eq(5)").text();
		var assignedBotId = currentRow.find("td:eq(6)").text();
		var windowsAuthentication = currentRow.find("td:eq(6)").text();

		

		$("html, body").animate({scrollTop : 0
		}, "fast"); // scrolling action to top of page
		$(".userName").val(userName);
		$(".password").val(password);
		$(".userEmailId").val(emailId);
		$(".userFirstName").val(firstName);
		$(".userLastName").val(lasName);
		$(".role").val(role);
		$(".assignedBotID").val(assignedBotId);
		$(".windowsAuthentication").val(windowsAuthentication);
		$(".card-title1").html("Edit User");
		$(".userName").css('pointer-events', 'none');
		$(".userName").prop('readonly', true);
		$(".btn-submit").hide();
		$(".btn-update").show();
	});
	
	$('.btn-submit').mouseover(function(){
		var userName = $('.userName').val();
		var userEmail = $('.userEmailId').val();
		$.post('validatingUserAndEmail',{userName:userName,userEmail:userEmail},function(res){
			if(res==userName){
				$('#duplicateIdSpan').html("Duplicate user name : "+userName);
				$('#duplicateConfirmModal').modal();
				$('.userName').val("");
			}else if(res == userEmail){
				$('#duplicateIdSpan').html("Duplicate user email : "+userEmail);
				$('#duplicateConfirmModal').modal();
				$('.userEmailId').val("");
			}
		})
	});
	$('.btn-update').mouseover(function(){
		var userName = $('.userName').val();
		var userEmail = $('.userEmailId').val();
		$.post('validateEmailOnUpdate',{userName:userName,userEmail:userEmail},function(res){
			 if(res == userEmail){
				 $('#duplicateIdSpan').html("Duplicate user email : "+userEmail);
				 $('#duplicateConfirmModal').modal();
				 $('.userEmailId').val("");
			}else{
				
			}
		})
	});
});


