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
		var operatingUnitId = currentRow.find("td:eq(0)").text();//primary key
		var operatingUnit = currentRow.find("td:eq(1)").text();
	//	var region = currentRow.find("td:eq(2)").text();
		var addressLine1 = currentRow.find("td:eq(2)").text();
		var addressLine2 = currentRow.find("td:eq(3)").text();
		var addressLine3 = currentRow.find("td:eq(4)").text();
		var addressLine4 = currentRow.find("td:eq(5)").text();
		var city = currentRow.find("td:eq(6)").text();
		var state = currentRow.find("td:eq(7)").text();
		var zip = currentRow.find("td:eq(8)").text();
		var country = currentRow.find("td:eq(9)").text();
		/*var balancingSegmentCode = currentRow.find("td:eq(4)").text();
		var oracleResponsiblityName = currentRow.find("td:eq(5)").text();
		var functionalCurrency = currentRow.find("td:eq(6)").text();
		var emailbox = currentRow.find("td:eq(7)").text();*/
		
		
		$("html, body").animate({scrollTop : 0}, "fast"); // scrolling action to top of page
		$(".operatingUnitId").val(operatingUnitId.trim());
		$(".operatingUnit").val(operatingUnit.trim());
	//	$(".region").val(region.trim());
		$(".addressLine1").val(addressLine1.trim());
		$(".addressLine2").val(addressLine2.trim());
		$(".addressLine3").val(addressLine3.trim());
		$(".addressLine4").val(addressLine4.trim());
		$(".city").val(city.trim());
		$(".state").val(state.trim());
		$(".zip").val(zip.trim());
		$(".country").val(country.trim());
		/*$(".balancingSegmentCode").val(balancingSegmentCode.trim());
		$(".oracleResponsiblityName").val(oracleResponsiblityName.trim());
		$(".functionalCurrency").val(functionalCurrency.trim());
		$(".emailbox").val(emailbox.trim());*/
		
		$(".card-title1").html("Edit Region Set");
		$(".operatingUnitId").css('pointer-events', 'none');
		$(".operatingUnitId").prop('readonly', true);
		$(".btn-submit").hide();
		$(".btn-update").show();
	});
	
	$('.btn-submit').mouseover(function(){
		
		var operatingUnitId = $('.operatingUnitId').val();
		$.post('manageRegion.val',{operatingUnitId:operatingUnitId.trim()},function(res){
			if(res=="1"){
				$('#duplicateIdSpan').html("Duplicate Operating Unit ID  : "+operatingUnitId);
				$('#duplicateConfirmModal').modal();
				$(".operatingUnitId").val("");
			}
		});
	});
	
$('.btn-submit').mouseover(function(){
	
		var operatingUnit = $('.operatingUnit').val();
		
		$.post('manageRegionOperatingUnit.val',{operatingUnit:operatingUnit},function(res){
			 if(res == 1){
				 $('#duplicateIdSpan').html("Duplicate Operating Unit : "+operatingUnit);
				 $('#duplicateConfirmModal').modal();
				 $('.operatingUnit').val("");
			}else{
				
			}
		})
	});
});


