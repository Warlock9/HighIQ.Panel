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
		var distributionName = currentRow.find("td:eq(0)").text();//primary key
		var description = currentRow.find("td:eq(1)").text();
		var operatingUnit = currentRow.find("td:eq(2)").text();
		var isEnableDropDown = currentRow.find("td:eq(3)").text();
		
		
		$("html, body").animate({scrollTop : 0}, "fast"); // scrolling action to top of page
		$(".distributionName").val(distributionName);
		$(".description").val(description);
		$(".operatingUnit").val(operatingUnit);
		$(".isEnableDropDown").val(isEnableDropDown);		
		$(".card-title1").html("Edit Distribution Set");
		$(".distributionName").css('pointer-events', 'none');
		$(".distributionName").prop('readonly', true);
		$(".btn-submit").hide();
		$(".btn-update").show();
	});
	
	$('.btn-submit').mouseover(function(){
		
		var distributionSetName = $('.distributionName').val();

		$.post('manageDistributionSet.val',{distributionSetName:distributionSetName.trim()},function(res){
			if(res=="1"){
				$('#duplicateIdSpan').html("Duplicate Distribution Set Name : "+distributionSetName);
				$('#duplicateConfirmModal').modal();
				$(".distributionName").val("");
			}
		});
	});
	
/*	$('.btn-update').mouseover(function(){
		var userName = $('.distributionName').val();
		var userEmail = $('.userEmailId').val();
		$.post('manageDistributionSet.val',{userName:userName,userEmail:userEmail},function(res){
			 if(res == userEmail){
				 $('#duplicateIdSpan').html("Duplicate user email : "+userEmail);
				 $('#duplicateConfirmModal').modal();
				 $('.userEmailId').val("");
			}else{
				
			}
		})
	});*/
});


