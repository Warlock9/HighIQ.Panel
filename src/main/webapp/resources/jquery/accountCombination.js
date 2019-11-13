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
										/*$.post("dynamicSelect", {botId : $(this).closest('tr').find("td:eq(6)").text()}, function(res) {*/
											$('.dynamicForms').append(
													"<div class='form-group row dynamicDiv'>"
															
															+ "<div class='col-sm-6'>"
															+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(1)").text()+"' name='accountCombination[]' class='form-control accountCombination' id='fname' placeholder='Account Combination Here'  required readonly>"
															+ "</div>"
															+ "<div class='col-sm-6'>"
															+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(2)").text()+"' name='operatingUnit[]'  class='form-control operatingUnit' id='lname' placeholder='Operating Unit Here'>"
															+ "</div>");
															$("html, body").animate({scrollTop : 0}, "fast");
										/*});*/
									}).get();
								});

									
					/*adding new row on click of [+] button*/
					$(".addNewRow")
							.click(
									function() {
										/*$.post("dynamicSelect", {botId:''}, function(res) {*/
										$('.dynamicForms')
												.append(
														"<div class='form-group row dynamicDiv'>"
																
																
																+ "<div class='col-sm-6'>"
																+ "<input type='text' name='accountCombination[]'  class='form-control accountCombination' id='lname' placeholder='Account Combination Here' >"
																+ "</div>"
																+ "<div class='col-sm-6'>"
																+ "<input type='text' name='operatingunit[]' class='form-control operatingUnit' id='lname' placeholder='Operating Unit Here' required>"
																+ "</div>");
										/*});*/
									});

					/*removing last added row on click of [-] row*/
					$(".removeLastRow").click(function() {
						$('.dynamicDiv').last().remove();
					});
					
					
					
					
					$('.btnSave').mouseover(function(){
						  $(".dynamicDiv").each(function(){
							  	var currentRow = $(this).closest(".dynamicDiv");
							  	var accountCombination = currentRow.find('.accountCombination').val();
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
								$.post('checkIntergrityConstraints.do',{accountCombination:accountCombination.trim()},function(res){
									if(res>0){
										$('#duplicateIdSpan').html("Duplicate account combination : "+accountCombination);
											$('#duplicateConfirmModal').modal();
											currentRow.find('.accountCombination').val("");
									}
								})
						  });
						
						
						
						
					});	
					
				});	// end of document ready function		


// Fetching the bulk data

			