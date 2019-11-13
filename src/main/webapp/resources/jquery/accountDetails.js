/* getting particular row field from table and inserting to "Add contact" form */
function reloadPage(){
        location.reload(true);
    }
$(document)
		.ready(
				function() {
					$("form").keypress(function(e) {
						  //Enter key
						  if (e.which == 13) {
						    return false;
						  }
					});
					$(".btn-update").hide();
					$(".btnDelete").prop('disabled', true);
					
					$('.dataTable').on('change', '.listCheckbox', function() {
					  //$('.listCheckbox').change(function() {
						  if(this.checked) {
							  $(".btnDelete").prop('disabled', false);
					        }else{
					        	 $(".btnDelete").prop('disabled', true);
					        	  var tableControl = document.getElementById('mytable');
								  $('input:checkbox:checked', tableControl).each(function() {
									  $(".btnDelete").prop('disabled', false);
							       }).get();
					        }
					    });
					
					  					  
					  /*on click of edit button all checked row will fill in the form*/
						$('.btnEdit').click(function() {
									var tableControl = document.getElementById('mytable');
									        $('input:checkbox:checked', tableControl).each(function() {
									        	$('.dynamicDiv').remove();
									        	$("#btn-success").hide();
												$(".btn-update").show();
												$(".card-title1").html("Edit Contacts");
									        	return false;
									        }).get();   
									$('input:checkbox:checked', tableControl).each(function(){											
										var currentRow = this;
							       	
										$.post("dynamicSelectAccountAlias", {isEnabled : $(this).closest('tr').find("td:eq(5)").text()}, function(res) {
											$.post("dynamicSelectOperatingUnit", {operatingUnit : $(currentRow).closest('tr').find("td:eq(4)").text()}, function(res1) {
											$('.dynamicForms').append(
													"<div class='form-group row dynamicDiv'>"
															+ "<div class='col-sm-2'>"
															+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(1)").text()+"' class='form-control accountAlias' id='lname' name='accountAlias[]' placeholder='Account Alias Here' readonly>"
															+ "</div>"	
															+ "<div class='col-sm-3'>"
															+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(2)").text()+"' class='form-control accountDescription' id='lname' name='accountDescription[]' placeholder='Account Description' required>"
															+ "</div>"
															+ "<div class='col-sm-3'>"
															+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(3)").text()+"' class='form-control accountCombination' id='fname' name='accountCombination[]' onkeypress='return AvoidSpace(event)' placeholder='Account Combination Here' required>"
															+ "</div>"
															+ "<div class='col-sm-2'>"
															+res1
															+ "</div>"
															+ "<div class='col-sm-2'>"
															+res
															+ "</div>"
															+ "</div>");
															$("html, body").animate({scrollTop : 0}, "fast");
										});	});
									}).get();
								});

					/*adding new row on click of [+] button*/
					$(".addNewRow")
							.click(
									function() {
										
										$('.dynamicForms')
												.append(
														"<div class='form-group row dynamicDiv'>"
																+ "<div class='col-sm-2'>"
																+ "<input type='text' class='form-control accountAlias' id='lname' name='accountAlias[]' placeholder='Account Alias Here'>"
																+ "</div>"
																+ "<div class='col-sm-3'>"
																+ "<input type='text' class='form-control accountDescription' id='lname' name='accountDescription[]' placeholder='Account Description' required>"
																+ "</div>"
																+ "<div class='col-sm-3'>"
																+ "<input type='text' class='form-control accountCombination' id='fname' name='accountCombination[]' onkeypress='return AvoidSpace(event)' placeholder='Account Combination Here' required>"
																+ "</div>"
																+ "<div class='col-sm-2'>"
																+ "<input type='text' class='form-control operatingUnit' name='operatingUnit[]' placeholder='Operating Unit'>"
																+ "</div>"
																+ "<div class='col-sm-2'>"
																+ "<select name='isEnabled[]' class='select1 form-control custom-select'required>"
												                	+"<option value=''>Select</option>"
													                +"<option data-value='' value='Y'>Yes</option>"
														            +"<option data-value='' value='N'>No</option>"
											                    +"</select>"
																+ "</div>");
										});
									
					/*removing last added row on click of [-] row*/
					$(".removeLastRow").click(function() {
						$('.dynamicDiv').last().remove();
					});
					
					
					/*mouse hover on save/update button, validate duplicate Email respect of botTaggedTo*/
					$('.btnSave').mouseover(function(){
						  $(".dynamicDiv").each(function(){
							  	var currentRow = $(this).closest(".dynamicDiv");
							  	var accountCombination = currentRow.find('.accountCombination').val();
							  	var accountAlias = currentRow.find('.accountAlias').val();
							  	if(accountCombination!=""){
									  $(".custom-select").each(function(){
										  	var currentRowDiv = $(this).closest(".dynamicDiv");
										  	if(currentRow.is(currentRowDiv)){

										  	}else{
										  		var accountCombinationDiv = currentRowDiv.find('.accountCombination').val();
												if(accountCombination==accountCombinationDiv){
													$('#duplicateIdSpan').html("Duplicate account combination : "+accountCombinationDiv);
													$('#duplicateConfirmModal').modal();
													currentRowDiv.find('.accountCombination').val("");
												}
										  	}
									  });
							  	}
								if(accountAlias!=""){
									  $(".custom-select").each(function(){
										  	var currentRowDiv = $(this).closest(".dynamicDiv");
										  	if(currentRow.is(currentRowDiv)){
										  		
										  	}else{
										  		var accountAliasDiv = currentRowDiv.find('.accountAlias').val();
												if(accountAlias==accountAliasDiv){
													$('#duplicateIdSpan').html("Duplicate account alias : "+accountAliasDiv);
													$('#duplicateConfirmModal').modal();
													currentRowDiv.find('.accountAlias').val("");
												}
										  	}
									  });
							  	}
								$.post('validatingAccountCombination.do',{accountCombination:accountCombination.trim()},function(res){
									if(res>0){
											$('#duplicateIdSpan').html("Duplicate account combination : "+accountCombination);
											$('#duplicateConfirmModal').modal();
											currentRow.find('.accountCombination').val("");
									}
								})
								$.post('validatingAccountAlias.do',{accountAlias:accountAlias.trim()},function(res){
									if(res>0){
											$('#duplicateIdSpan').html("Duplicate account alias : "+accountAlias);
											$('#duplicateConfirmModal').modal();
											currentRow.find('.accountAlias').val("");
									}
								})
						  });
					});
					
					$('.btn-update').mouseover(function(){
						$(".dynamicDiv").each(function(){
							var currentRow = $(this).closest(".dynamicDiv");
							var accountCombination = currentRow.find('.accountCombination').val();
							var accountAlias = currentRow.find('.accountAlias').val();
							
							if(accountCombination!=""){
								  $(".custom-select").each(function(){
									  	var currentRowDiv = $(this).closest(".dynamicDiv");
									  	if(currentRow.is(currentRowDiv)){
									  		
									  	}else{
									  		var accountCombinationDiv = currentRowDiv.find('.accountCombination').val();
											if(accountCombination==accountCombinationDiv){
												
												alert(accountCombination+" "+accountCombinationDiv);
												$('#duplicateIdSpan').html("Duplicate account combination : "+accountCombinationDiv);
												$('#duplicateConfirmModal').modal();
												currentRowDiv.find('.accountCombination').val("");
											}
									  	}
								  });
						  	}
							
							$.post('validatingAccountCombinationOnUpdate.do',{accountCombination:accountCombination.trim()},function(res){
									if(accountAlias.trim()!=res.trim()){
										alert(res.trim()+" >>>>>>>>>>>1111111111");
										$('#duplicateIdSpan').html("Duplicate account combination : "+accountCombination);
										$('#duplicateConfirmModal').modal();
										currentRow.find('.accountCombination').val("");
									}
							});
							
						});
					});
});

function AvoidSpace(event) {
	var k = event ? event.which : window.event.keyCode;
	if (k == 32)
		return false;
}