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
	$(".componentSelect").hide();
	$(".type").on('change', function(){
		
		var name = $(this).val();
		//alert(Bundle);
		if(name=='Bundle'){
			$.post("getAllComponents.do",{
				
				
			 }, function(res) {
				 $('.dynamic').append(res);
				 $(".componentSelect").show();
			     $(".componentHiding").remove();
			 })
			
		}
		else{
			$(".componentSelect").hide();
			$(".componentHiding").show();
		}
				
	});

	//update button is disabled on page loading 
	
	$(".btn-update").hide();
	// code to read selected table row cell data (values).
	$(".myTable").on('click', '.btnSelect', function() {
		// get the current row
		$(".componentSelect").remove();
		var currentRow = $(this).closest("tr");
		var skuCode = currentRow.find("td:eq(0)").text();
		
		var componentBundleName = currentRow.find("td:eq(1)").text();
		
		var type = currentRow.find("td:eq(2)").text();
		if(currentRow.find("td:eq(2)").text() == "Bundle")
			{
			
			$(".componentSelect").hide();
			getComponentSKUs(skuCode);
			
			//$(".componentSelect").show();
			$(".componentHiding").remove();
			}
		
		var status ;
		if(currentRow.find("td:eq(3)").text() == "Inactive")
			{
			status = "0";
			}
		else{
			status = "1";
		}
	
		var createdDate = currentRow.find("td:eq(4)").text();

		$("html, body").animate({
			scrollTop : 0
		}, "fast"); // scrolling action to top of page

		$(".componentBundleName").val(componentBundleName.trim());
		$(".type").val(type.trim());
		$(".skuCode").val(skuCode.trim());
		$(".status").val(status.trim());
		$(".cDate").val(createdDate.trim());
		$(".card-title1").html("Edit Component/Bundle");
		$(".btn-submit").hide(); // disabling submit button
		$(".btn-update").show();//enabling the update button
		$(".skuCode").css('pointer-events', 'none');
		$(".skuCode").prop('readonly', true);
	});

	$('.btnAdd').mouseover(function(){
		
		var skuCode = $('.skuCode').val();
		if(skuCode.length>0){
			$.post('skuCodeValidation.val',{skuCode:skuCode},function(res){
				if(res==1){
					$('#duplicateIdSpan').html("Duplicate skuCode number : "+skuCode);
					$('#duplicateConfirmModal').modal();
					$('.skuCode').val("");
				}
			});
		}
	});	
});

function getComponentSKUs(skuCode){
	$.post("getComponents.do",{
		skuCode:skuCode
		
	 }, function(res) {
		 $('.dynamic').append(res);
	 })
}