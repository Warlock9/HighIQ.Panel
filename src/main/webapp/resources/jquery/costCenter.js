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
		var id = currentRow.find("td:eq(0)").text();//primary key
		var componentBundleName = currentRow.find("td:eq(1)").text();
		var type = currentRow.find("td:eq(2)").text();
		var skuCode = currentRow.find("td:eq(3)").text();
		var status = currentRow.find("td:eq(4)").text();
		var createdDate = currentRow.find("td:eq(5)").text();

		$("html, body").animate({
			scrollTop : 0
		}, "fast"); // scrolling action to top of page

		$(".id1").val(id.trim());
		$(".componentBundleName").val(componentBundleName.trim());
		$(".type").val(type.trim());
		$(".skuCode").val(skuCode.trim());
		$(".status").val(status.trim());
		$(".cDate").val(createdDate.trim());
		$(".card-title1").html("Edit Component/Bundle");
		$(".btn-submit").hide(); // disabling submit button
		$(".btn-update").show();//enabling the update button
		//$(".id").css('pointer-events', 'none');
		//$(".id").prop('readonly', true);
	});

	/*$('.btnAdd').mouseover(function(){
		var costCenterNum = $('.id').val();
		if(costCenterNum.length>0){
			$.post('componentBundle.val',{costCenterNum:costCenterNum},function(res){
				if(res==1){
					$('#duplicateIdSpan').html("Duplicate cost center number : "+costCenterNum);
					$('#duplicateConfirmModal').modal();
					$('.costCenterId').val("");
				}
			});
		}
	});	*/
});

