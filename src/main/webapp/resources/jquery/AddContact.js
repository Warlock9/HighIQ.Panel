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
												$.post("dynamicSelect", {botId : $(this).closest('tr').find("td:eq(5)").text()}, function(res) {
													$('.dynamicForms').append(
															"<div class='form-group row_01 dynamicDiv'>"
																	+ "<input type='hidden' class='hidId' value="+$(currentRow).closest('tr').find("input").val()+" name='id[]'>"
																	+ "<div class='col-sm-2'>"
																	+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(1)").text()+"' name='firstName[]' class='form-control firstName' id='fname' placeholder='First Name Here' pattern='^[A-Za-z ]+$' title='symbol or numbers not allowed' required>"
																	+ "</div>"
																	+ "<div class='col-sm-2'>"
																	+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(2)").text()+"' name='middleName[]'  class='form-control lastName' id='lname' placeholder='Middle Name Here' pattern='^[A-Za-z ]+$' title='symbol or numbers not allowed'>"
																	+ "</div>"
																	+ "<div class='col-sm-2'>"
																	+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(3)").text()+"' name='lastName[]'  class='form-control lastName' id='lname' placeholder='Last Name Here' pattern='^[A-Za-z ]+$' title='symbol or numbers not allowed'>"
																	+ "</div>"	
																	+ "<div class='col-sm-2'>"
																	+ "<input type='email' value='"+$(currentRow).closest('tr').find("td:eq(4)").text()+"' name='contactMailId[]' class='form-control contactEmailId' id='lname' placeholder='Contact Email Here'  required>"
																	+ "</div>"
																	+ "<div class='col-sm-2'>"
																	+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(5)").text()+"' name='contactDomainName[]' class='form-control contactDomainName' id='lname' placeholder='Contact Domain Name Here'  required>"
																	+ "</div>"
																	+ "<div class='col-sm-2'>"
																	+ "<input type='number' value='"+$(currentRow).closest('tr').find("td:eq(6)").text()+"' name='contactNumber[]' class='form-control contactNumber' id='lname' placeholder='Contact Number Here'>"
																	+ "</div>"
																	+ "<div class='col-sm-2'>"
																	+ res
																	+ "</div>"
																	+ "<div class='col-sm-2'>"
																	+ "<input type='text' value='"+$(currentRow).closest('tr').find("td:eq(8)").text()+"' name='companyName[]' class='form-control companyName' id='lname' placeholder='Company Name Here' required>"
																	+ "</div>"
																	/*+"<div class=\"col-sm-2\">" 
																	+ "<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(7)").text()+"' class=\"form-control \" id=\"lname\" name=\"vendorType[]\" placeholder=\"Vendor Type Here\">" 
																	+ "</div>" */
																	+ "<div class=\"col-sm-2\">" 
																	+ "	<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(9)").text()+"' class=\"form-control \" id=\"lname\" name=\"vendorId[]\" placeholder=\"Customer ID Here\">" 
																	+ "</div>" 
																	+ "<div class=\"col-sm-2\" style='display: none;'>" 
																	+ "	<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(10)").text()+"' class=\"form-control \" id=\"lname\" name=\"internalVendorId[]\" placeholder=\"Internal Customer ID Here\">" 
																	+ "</div>" 
																	/*+ "<div class=\"col-sm-2\">" 
																	+ "	<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(10)").text()+"' class=\"form-control \" id=\"lname\" name=\"vendorSiteId[]\" placeholder=\"Vendor Site ID Here\">" 
																	+ "</div>" */
																	+ "<div class=\"col-sm-2\" style='display: none;'>" 
																	+ "	<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(11)").text()+"' class=\"form-control \" id=\"lname\" name=\"bankAccount[]\" placeholder=\"Bank Account Here\">" 
																	+ "</div>" 
																	+ "<div class=\"col-sm-2\" style='display: none;'>" 
																	+ "	<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(12)").text()+"' class=\"form-control \" id=\"lname\" name=\"bankAccountCode[]\" placeholder=\"Bank Account Code Here\">" 
																	+ "</div>" 
																	+ "<div class=\"col-sm-2\" style='display: none;'>"   
																	+ "	<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(13)").text()+"' class=\"form-control \" id=\"lname\" name=\"accountNumber[]\" placeholder=\"Account Number Here\">" 
																	+ "</div>" 
																	/*+ "<div class=\"col-sm-2\">" 
																	+ "	<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(14)").text()+"' class=\"form-control \" id=\"lname\" name=\"vendorVATRegNo[]\" placeholder=\"Vendor VAT RegNo Here\">" 
																	+ "</div>"*/
																	+ "<div class=\"col-sm-2\">" 
																	+ "	<input type=\"text\" value='"+$(currentRow).closest('tr').find("td:eq(14)").text()+"' class=\"form-control \" id=\"lname\" name=\"defaultPaymentTerms[]\" placeholder=\"Default Payment Terms Here\">" 
																	+ "</div>"
																	+ "</div>");  
																	$("html, body").animate({scrollTop : 0}, "fast");
												});
											}).get();		
									        $(".addNewRow").prop('disabled', true);
									});
									
					/*adding new row on click of [+] button*/
					$(".addNewRow")
							.click( 
									function() {
										$(".dynamicDiv:first").clone().appendTo(".dynamicForms").find("input").val("");  
						});

					/*removing last added row on click of [-] row*/
					$(".removeLastRow").click(function() {
						if(($('.dynamicDiv').length)>1)
							$('.dynamicDiv').last().remove();
					});
										
					/*on change of drop down validate duplicate Email respect of botTaggedTo*/
					$('.dynamicForms').on('change', '.custom-select', function() {
						var currentRow = $(this).closest(".dynamicDiv");
						var botId = $(this).val();
						var botType =  $('select.custom-select option[value="' + $(this).val() + '"]').data('value');
						var emailId = currentRow.find("input[type='email']").val();
						var id = currentRow.find("input[type='hidden']").val();
						if(emailId!=""){
						  $(".custom-select").each(function(){
							  	var currentRowDiv = $(this).closest(".dynamicDiv");
							  	if(currentRow.is(currentRowDiv)){
							  		
							  	}else{
									var emailIdDiv = $(currentRowDiv).find("input[type=email]").val();
									var botIdDiv= $(currentRowDiv).find("select").val();
									var botTypeDiv = $(currentRowDiv).find('select.custom-select option[value="' + botIdDiv + '"]').data('value');
									var idDiv =  $(currentRowDiv).find("input[type=hidden]").val();
									if(emailId==emailIdDiv && botType==botTypeDiv){
										$('#duplicateIdSpan').html("Duplicate email id : "+emailId);
										$('#duplicateConfirmModal').modal();
										currentRow.find("input[type='email']").val("");
										currentRow.find("select").val("");
									}
							  	}

						  });
						}
						
						$.post('emailIdValidation.do',{id:id,botType:botType,botId:botId,emailId:emailId},function(res){
							if(res>0){
								if(res==id){
									
								}else{
									$('#duplicateIdSpan').html("Duplicate email id : "+emailId);
									$('#duplicateConfirmModal').modal();
									currentRow.find("input[type='email']").val("");
									currentRow.find("select").val("");
								}
							}
						})
					});
										
					/*mouse hover on save/update button, validate duplicate Email respect of botTaggedTo*/
					$('.btn-update,.btnSave').mouseover(function(){
						  $(".dynamicDiv").each(function(){
							  	var currentRow = $(this).closest(".dynamicDiv");
								var emailId = $(this).find("input[type=email]").val();
								var botId= $(this).find("select").val();
								var botType = $(this).find('select.custom-select option[value="' + botId + '"]').data('value');
								var id =  $(this).find("input[type=hidden]").val();
								if(emailId!=""){
									  $(".custom-select").each(function(){
										  	var currentRowDiv = $(this).closest(".dynamicDiv");
										  	if(currentRow.is(currentRowDiv)){
										  		
										  	}else{
												var emailIdDiv = $(currentRowDiv).find("input[type=email]").val();
												var botIdDiv= $(currentRowDiv).find("select").val();
												var botTypeDiv = $(currentRowDiv).find('select.custom-select option[value="' + botIdDiv + '"]').data('value');
												var idDiv =  $(currentRowDiv).find("input[type=hidden]").val();
												if(emailId==emailIdDiv && botType==botTypeDiv){
													$('#duplicateIdSpan').html("Duplicate email id : "+emailIdDiv);
													$('#duplicateConfirmModal').modal();
													currentRowDiv.find("input[type='email']").val("");
													currentRowDiv.find("select").val("");
												}
										  	}

									  });
								}
								$.post('emailIdValidation.do',{id:id,botType:botType,botId:botId,emailId:emailId},function(res){
									if(res>0){
										if(res==id){
											
										}else{
											$('#duplicateIdSpan').html("Duplicate email id : "+emailId);
											$('#duplicateConfirmModal').modal();
											$(currentRow).find("input[type=email]").val("");
											$(currentRow).find("select").val("");
										}
									}
								})
						  });
					});
					$('.uploadSheetBtn').click(function(){
						alert("fdhksajhk");
						$('#excelfile').click();
					});
					/*download templat excel sheet*/
					$('.downloadSheet').click(function(e) {
					    e.preventDefault();  //stop the browser from following
					    location.reload(true);
					    window.location.href = 'resources/jquery/ContactTemplate.xlsx';
					});
					
					$("body").on("change", "#excelfile", function () {
						//Reference the FileUpload element.
				        var fileUpload = $("#excelfile")[0];
				 
				        //Validate whether File is valid Excel file.
				        var regex = /^([a-zA-Z0-9\s_\\.\-:\(\)])+(.xlsx|.xls)$/;
				        if (regex.test(fileUpload.value.toLowerCase())) {
				            if (typeof (FileReader) != "undefined") {
				                var reader = new FileReader();
				 
				                //For Browsers other than IE.
				                if (reader.readAsBinaryString) {
				                    reader.onload = function (e) {
				                        ProcessExcel(e.target.result);
				                    };
				                    reader.readAsBinaryString(fileUpload.files[0]);
				                } else {
				                    //For IE Browser.
				                    reader.onload = function (e) {
				                        var data = "";
				                        var bytes = new Uint8Array(e.target.result);
				                        for (var i = 0; i < bytes.byteLength; i++) {
				                            data += String.fromCharCode(bytes[i]);
				                        }
				                        ProcessExcel(data);
				                    };  
				                    reader.readAsArrayBuffer(fileUpload.files[0]);
				                }
				            } else {
				                $('#duplicateIdSpan').html("Sorry! Your browser does not support HTML5!");
				    			$('#duplicateConfirmModal').modal(); 
				            }
				        } else {
				        	 $('#duplicateIdSpan').html("Please upload a valid Excel file!");
				     		 $('#duplicateConfirmModal').modal(); 
				        }
					});
				});


function ProcessExcel(data) {
    //Read the Excel File data.
    var workbook = XLSX.read(data, {
        type: 'binary'
    });

    //Fetch the name of First Sheet.
    var firstSheet = workbook.SheetNames[0];

    //Read all rows from First Sheet into an JSON array.
    var excelRows = XLSX.utils.sheet_to_row_object_array(workbook.Sheets[firstSheet]);
	var excelHeaders = XLSX.utils.sheet_to_json(workbook.Sheets[firstSheet],{range:-1});
	var i=1;
   
	$.each(excelHeaders[0], function( index, value ) {	
		switch(i) {
                case 1:
                	if(value=='First_Name'){}else{validExcelFormat();stopExecution;}
                break;
                
                case 2:
                	if(value=='Middle_Name'){}else{validExcelFormat();stopExecution;}
                  break;
                
                case 3:
                	if(value=='Last_Name'){}else{validExcelFormat();stopExecution;}
                  break;
                                      
                case 4:
                	if(value=='Contact_Mail_ID'){}else{validExcelFormat();stopExecution;}
                    break;
                    
                case 5:
                	if(value=='Contact_Domain_Name'){}else{validExcelFormat();stopExecution;}
                    break;
                    
                case 6:
                	if(value=='Contact_Number'){}else{validExcelFormat();stopExecution;}
                    break;
                  
                case 7:
                	if(value=='Company_Name'){}else{validExcelFormat();stopExecution;}
                    break;
                  
                /*case 6:
                	if(value=='Vendor_Type'){}else{validExcelFormat();stopExecution;}
                break;*/
                  
                case 8:
                	if(value=='Customer_ID'){}else{validExcelFormat();stopExecution;}
                  break;
                                      
                /*case 8:
                	if(value=='Internal_Customer_ID'){}else{validExcelFormat();stopExecution;}
                    break;*/
                    
                /*case 9:
                	if(value=='Vendor_Site_ID'){}else{validExcelFormat();stopExecution;}
                    break;*/
                  
             /*   case 9:
                	if(value=='Bank_Account'){}else{validExcelFormat();stopExecution;}
                    break;    

                case 10:
                	if(value=='Bank_Account_Code'){}else{validExcelFormat();stopExecution;}
                    break;    
 
                case 11:
                	if(value=='Account_Number'){}else{validExcelFormat();stopExecution;}
                    break;   */ 
 
                /*case 13:
                	if(value=='Vendor_VAT_RegNo'){}else{validExcelFormat();stopExecution;}
                    break;*/    
 
                case 9:
                	if(value=='Default_Payment_Terms'){}else{validExcelFormat();stopExecution;}
                    break;
                    
                default:
                	validExcelFormat();stopExecution;
              }
		i++;
	});
	var row$="";
    //Add the data rows from Excel file.
    for (var i = 0; i < excelRows.length; i++) {
		
        row$ =row$+"<div class='form-group row_01 dynamicDiv'>";  
        row$ = row$+"<input class='hidId' type='hidden' value='' name='id[]'>";
        var fName = excelRows[i].First_Name==null ? '' : excelRows[i].First_Name;
        row$ = row$+"<div class='col-sm-2'><input type='text' value='"+fName+"' class='form-control' name='firstName[]' placeholder='First Name Here' required></div>";
          
        var mName = excelRows[i].Middle_Name==null ? '' : excelRows[i].Middle_Name;    
        row$ = row$+"<div class='col-sm-2'><input type='text' value='"+mName+"' class='form-control' name='middleName[]' placeholder='Middle Name Here'></div>";
        
        var lName = excelRows[i].Last_Name==null ? '' : excelRows[i].Last_Name;
        row$ = row$+"<div class='col-sm-2'><input type='text' value='"+lName+"' class='form-control' name='lastName[]' placeholder='Last Name Here'></div>";
                
        var mailId= excelRows[i].Contact_Mail_ID==null ? '' : excelRows[i].Contact_Mail_ID;
        row$ = row$+"<div class='col-sm-2'><input type='email' value='"+mailId+"' class='form-control' name='contactMailId[]' placeholder='Contact Email Here'></div>";
        
        var cDName= excelRows[i].Contact_Domain_Name==null ? '' : excelRows[i].Contact_Domain_Name;
        row$ = row$+"<div class='col-sm-2'><input type='email' value='"+cDName+"' class='form-control' name='contactDomainName[]' placeholder='Contact Domain Name Here'></div>";
        
        var cNum= excelRows[i].Contact_Number==null ? '' : excelRows[i].Contact_Number;	
        row$ = row$+"<div class='col-sm-2'><input type='number' value='"+cNum+"' class='form-control' name='contactNumber[]' placeholder='Contact Number Here'></div>"; 
        
        row$ = row$+"<div class='col-sm-2' id='selectId"+i+"'></div>";
        
        var cName = excelRows[i].Company_Name==null ? '' : excelRows[i].Company_Name;
        row$ = row$+"<div class='col-sm-2'><input type='text' value='"+cName+"' class='form-control' name='companyName[]' placeholder='Company Name Here'></div>";

        /*var vType= excelRows[i].Vendor_Type==null ? '' : excelRows[i].Vendor_Type;
        row$ = row$+"<div class='col-sm-2'><input type='text' value='"+vType+"' class='form-control' name='vendorType[]' placeholder='Vendor Type Here'></div>";*/  

        var vId= excelRows[i].Customer_ID==null ? '' : excelRows[i].Customer_ID;
        row$ = row$+"<div class='col-sm-2' ><input type='text' value='"+vId+"' class='form-control' name='vendorId[]' placeholder='Customer ID Here'></div>";  

     //   var IntVendId= excelRows[i].Internal_Customer_ID==null ? '' : excelRows[i].Internal_Customer_ID;
        row$ = row$+"<div class='col-sm-2' style='display: none;'><input type='text' value='' class='form-control' name='internalVendorId[]' placeholder='Internal Customer ID Here'></div>";  

        /*var vSiteId= excelRows[i].Vendor_Site_ID==null ? '' : excelRows[i].Vendor_Site_ID;
        row$ = row$+"<div class='col-sm-2'><input type='text' value='"+vSiteId+"' class='form-control' name='vendorSiteId[]' placeholder='Vendor Site ID Here'></div>";*/  

   //     var bAccount= excelRows[i].Bank_Account==null ? '' : excelRows[i].Bank_Account;
        row$ = row$+"<div class='col-sm-2' style='display: none;'><input type='text' value='' class='form-control' name='bankAccount[]' placeholder='Bank Account Here'></div>";  

  //      var bAccCode= excelRows[i].Bank_Account_Code==null ? '' : excelRows[i].Bank_Account_Code;
        row$ = row$+"<div class='col-sm-2' style='display: none;'><input type='text' value=' ' class='form-control' name='bankAccountCode[]' placeholder='Bank Account Code Here'></div>";  

   //     var ANum= excelRows[i].Account_Number==null ? '' : excelRows[i].Account_Number;
        row$ = row$+"<div class='col-sm-2' style='display: none;'><input type='text' value='' class='form-control' name='accountNumber[]' placeholder='Account Number Here'></div>";  

        /*var venVatReg= excelRows[i].Vendor_VAT_RegNo==null ? '' : excelRows[i].Vendor_VAT_RegNo;
        row$ = row$+"<div class='col-sm-2'><input type='text' value='"+venVatReg+"' class='form-control' name='vendorVATRegNo[]' placeholder='Vendor VAT RegNo Here'></div></div>";*/
        
        var dePayTer= excelRows[i].Default_Payment_Terms==null ? '' : excelRows[i].Default_Payment_Terms;
        row$ = row$+"<div class='col-sm-2'><input type='text' value='"+dePayTer+"' class='form-control' name='defaultPaymentTerms[]' placeholder='Default Payment Termss Here'></div></div>";
      
        gettingDropDownForBotTaggedTo(i);
 
    }
  
    $('.dynamicDiv').remove();
 
    $('.dynamicForms').append(row$);
};

function gettingDropDownForBotTaggedTo(i){
	$.post("dynamicSelect", {botId:''}, function(res) {
		$('#selectId'+i).html(res);
	}); 
}

function validExcelFormat(){
	$('#duplicateIdSpan').html("invalid Excel format !");
	$('#duplicateConfirmModal').modal(); 
}