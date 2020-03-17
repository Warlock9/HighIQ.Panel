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
	
	$(".btn-license").hide(); // disabling submit button	
	//update button is disabled on page loading 
	$(".btn-update").hide();
	// code to read selected table row cell data (values).
	$(".myTable").on('click', '.btnSelect', function() {
		// get the current row
		var currentRow = $(this).closest("tr");
		var salesId = currentRow.find("td:eq(0)").text();//primary key
		
		var clientSiteId = currentRow.find("td:eq(1)").text();
		var sku = currentRow.find("td:eq(4)").text();
		
		var noOfRunners = currentRow.find("td:eq(5)").text();
		var licenseIssueDate = currentRow.find("td:eq(6)").text();
		var licenseEndDate = currentRow.find("td:eq(7)").text();
		var paymentStatus = currentRow.find("td:eq(8)").text();
		var licenseKey = currentRow.find("td:eq(9)").text();
		var licenseStatus = currentRow.find("td:eq(10)").text();
		var clientIpAddress = currentRow.find("td:eq(11)").text();
		var createdDate = currentRow.find("td:eq(12)").text();
	

		$("html, body").animate({
			scrollTop : 0
		}, "fast"); // scrolling action to top of page

		$(".salesId").val(salesId.trim());
		
		
		
		
		$(".clientSiteId").val(clientSiteId.trim());
		$(".sku").val(sku.trim());
		$(".noOfRunners").val(noOfRunners.trim());
		$(".licenseIssueDate").val(licenseIssueDate.trim());
		$(".licenseEndDate").val(licenseEndDate.trim());
		$(".paymentStatus").val(paymentStatus.trim());
		$(".licenseKey").val(licenseKey.trim());
		$(".licenseStatus").val(licenseStatus.trim());
		$(".clientIpAddress").val(clientIpAddress.trim());
		$(".createdDate").val(createdDate.trim());
		
		
	//$(".card-title1").html("Edit Component/Bundle");
		$(".btn-submit").hide(); // disabling submit button
		$(".btn-update").show();//enabling the update button
		if(paymentStatus=="Yes" && salesId!="0" ){
			$(".btn-license").show(); // enabling license button  
		}
	});
/*enabling license button on payment status change*/
	$('.paymentStatus').change(function(){
	    var paymentStatus=	$(".paymentStatus").val();
	    var salesId=  $(".salesId").val();
	    if(paymentStatus=="Yes" && salesId!="0" ){
	    	
			$(".btn-license").show(); // enabling license button  
		}
		
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

