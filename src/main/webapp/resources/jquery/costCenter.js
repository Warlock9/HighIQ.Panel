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
	/*$(".myTable").on('click', '.btnSelect', function() {
		// get the current row
		var currentRow = $(this).closest("tr");
		var costCenterId = currentRow.find("td:eq(0)").text();//primary key
		var costCenterName = currentRow.find("td:eq(1)").text();
		var managerFirstName = currentRow.find("td:eq(2)").text();
		var managerLastName = currentRow.find("td:eq(3)").text();
		var managerMailId = currentRow.find("td:eq(4)").text();
		var isEnabled = currentRow.find("td:eq(5)").text();

		$("html, body").animate({
			scrollTop : 0
		}, "fast"); // scrolling action to top of page

		$(".costCenterId").val(costCenterId.trim());
		$(".costCenterName").val(costCenterName.trim());
		$(".managerFirstName").val(managerFirstName.trim());
		$(".managerLastName").val(managerLastName.trim());
		$(".managerMailId").val(managerMailId.trim());
		$(".isEnableDropDown").val(isEnabled);
		$(".card-title1").html("Edit Cost Center");
		$(".btn-submit").hide(); // disabling submit button
		$(".btn-update").show();//enabling the update button
		$(".costCenterId").css('pointer-events', 'none');
		$(".costCenterId").prop('readonly', true);
	});*/

	/*$('.btnAdd').mouseover(function(){
		var costCenterNum = $('.costCenterId').val();
		if(costCenterNum.length>0){
			$.post('costCenterNumValidation.do',{costCenterNum:costCenterNum},function(res){
				if(res==1){
					$('#duplicateIdSpan').html("Duplicate cost center number : "+costCenterNum);
					$('#duplicateConfirmModal').modal();
					$('.costCenterId').val("");
				}
			});
		}
	});	*/
});

