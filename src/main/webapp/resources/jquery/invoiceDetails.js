

/* split logic function invoice line Distribution */

var invoiceUniqueIdLine="";
var botIdLine="";

$(document)
		.ready(
				function() {
					invoiceUniqueIdLine=$('.invoiceUniqueId').val();
					botIdLine=$('.botId').val();
					$("#updateConfirmModaljquery,#approveConfirmModaljquery,#rejectConfirmModaljquery").modal({
					    	 show: false,
					        backdrop: 'static'
					    });
			   /*Header Message is hide*/
			 	$('.message').hide();
			 	$('.message1').hide();
			 	  /*Disable enter key*/
			 	$("form").keypress(function(e) {
			 		  //Enter key
			 		  if (e.which == 13) {
			 		    return false;
			 		  }
			 		});
			 	
			 /*remove odd even class from datatable in invoiceLine and invoiceLineDistribution table*/
			 	$(".myTable1 tr ,.myTable tr").removeClass( "odd even" );
			 	 /*sorting in decending order of table */
					$('#zero_config1').dataTable( {
					order: [],
					columnDefs: [ { orderable: false, targets: [0] } ]
					});   // end of sorting in decending order of table 
					      
					
					/* this function fetch item total from invoice line table and print on invoice line distribution table  in both condition page loading and also blur function*/
				
					$('.myTable tbody tr').each(function() { 
						var lineNumber=$(this).find("td:eq(2)").text();
						var itemTotal =$(this).find("td:eq(8)").text();
						
						$('.myTable1 tbody tr').each(function() {
							if($(this).find("td:eq(2)").text()==lineNumber){   
								$(this).find("td:eq(4)").text(itemTotal);
							}										
						});
						
					});// end of this function
					
					/*this is on blur function fetch item total from invoice line table and print on invoice line distribution table */
					  $('.myTable').on('blur', 'tr', function() {
						 
						   var currentRow  = $(this).closest("tr");
						   var className = $(currentRow).attr('class');
						   var lineNumber=$(this).find("td:eq(2)").text();
						   var itemTotal =$(this).find("td:eq(8)").text();
								
								$('.myTable1 tbody tr').each(function() {
									if($(this).find("td:eq(2)").text()==lineNumber){  
										
										$(this).find("td:eq(4)").text(itemTotal);
									}										
								});
									
							
								
								
							});
					
					/* hidiing function of po oreacle tab*/
					var poNumber=$('.poNumber').val();
					 if(poNumber==""){
						 
						 $('.PO_Oracle_Hide_If_PO_Available').hide();
						 $('.myTable3').hide();
						 $('.message1').show();// show message div if po number is exist
						 
					}
					 
					 $('.poNumber')
						.blur(function() {
							
							var poNumber=$('.poNumber').val();
							
							if(poNumber==""){
								
								 $('.PO_Oracle_Hide_If_PO_Available').hide();
								 $('.myTable3').hide();
								 $('.message1').show();// show message div if po number is exist
								  

							}else{
								 $('.PO_Oracle_Hide_If_PO_Available').show();
								 $('.myTable3').show();
								 $('.message1').hide();
							}	
						});// end 
					 
					
					/*for invoice distribution tab content disabled on distribution division if po number is not null on page load*/
					var poNumber=$('.poNumber').val();
					 if(poNumber!=""){
						 $('.myTable1 ').hide();
						 $('.message').show();// show message div if po number is exist
						 
					}
					 
				 /*content disabled on distribution division if po number is not null focus out */
					 $('.poNumber')
						.blur(function() {
							
							var poNumber=$('.poNumber').val();
							
							if(poNumber!=""){
								 $('.myTable1 ').hide();
								 $('.message').show();// show message div if po number is exist
								  

							}else{
								
								 $('.myTable1 ').show();
								 $('.message').hide();
							}	
						});// end of this function
			
			/* this is function is spit a fields  and remove the field of invoice line Distribution*/		
					
					   $('.myTable1').on('click', '.btnSplit', function() {
						        
										var currentRow  = $(this).closest("tr");
										
										var response="";
										var className = $(currentRow).attr('class');
										var lineNumber; var splitLineId; var totalAmount; var splitAmount; var botId; var invoiceUniqueId; var accountNumber;var accountAlias;
										
										
										$('.'+className+'').each(function() {
											
											botId=$(this).find("td:eq(0)").text();
											invoiceUniqueId=$(this).find("td:eq(1)").text();
											lineNumber = $(this).find("td:eq(2)").text();
											splitLineId = $(this).find("td:eq(3)").text();
											totalAmount = $(this).find("td:eq(4)").text();
											splitAmount = $(this).find("td:eq(5)").text();
											accountNumber=$(this).find("td:eq(6) select").val();
											accountAlias=$(this).find("td:eq(7) select").val();
											//distributaion = $(this).find("td:eq(8)").text();
											distributaion = $(this).find("td:eq(8) select").val();
										
											splitLineId = parseInt(splitLineId)+1;												
											
										});
									
										if(distributaion.length>0){
											$('#duplicateIdSpan').html("Can not be split ! distribution set applied");
											$('#duplicateConfirmModal').modal();
											return false;
										}
										
										/*for accountNumber*/
										$.post("accountNumber.do", {
											
										 }, function(accountNumber) {
											//for AccountAlias
											
											$.post("accountAlias.do", {
												
											}, function(accountAlias) {
												//for distributionset
												$.post("accountDistributionSet.do", {
													
												}, function(distributionSet) {
													
												$('.'+className+'').last().after("<tr  class='"+className+"'>" +
														  "<td style='display: none;'>"+botId+"</td>"
														+ "<td style='display: none;'>"+invoiceUniqueId+"</td>"
														+ "<td>"+lineNumber+"</td>"
														+ "<td>"+splitLineId+"</td>"
														+ "<td contenteditable='true'>"+totalAmount+"</td>"
														+ "<td contenteditable='true'></td>"
														
														+ "<td contenteditable='true'>"+accountNumber+"</td>"
														
													    + "<td contenteditable='true'>"+accountAlias+"</td>"
														+ "<td contenteditable='true'>"+distributionSet+"</td>"
														+ "<td>"
														+ "<button type='button' value='remove' class='btn btn-danger btn-sm btnRemove'>Remove</button></td></tr>");
												        $(".select2").select2();
											   })// accountAlias Post close
											 
											 
					                          })//for accountDistributionSet   
											
			                              })//accountNumber post Close			                               
	                             	});
									
								$('.myTable1').on('click', '.btnRemove', function() {
									
									var currentRow  = $(this).closest("tr");
									
									var className = $(currentRow).attr('class');
									currentRow.remove();
									var dynamicSplit =0;
                                    $('.'+className+'').each(function() {
										$(this).find("td:eq(3)").text(dynamicSplit);
										 dynamicSplit++;
										
										
									});
								});
				});
		
		/* Delete Action  of invoice line details */
		$(document).ready(function() {
		
			$(".myTable").on('click', '.btnDelete', function() {
				// get the current row
				var conf = confirm("do you really want to delete ? ");
				if (conf == true) {
					var currentRow = $(this).closest("tr");
					var className =  $(currentRow).attr('class');
					var invoiceUniqueId = currentRow.find("td:eq(1)").text();
					var lineNumber = currentRow.find("td:eq(2)").text();
					var action = 'delete';
					$.post("invoiceLine.do", {
						action : action,
						lineNumber : lineNumber,
						invoiceUniqueId : invoiceUniqueId
					}, function(res) {
						if (res == 1) {
							currentRow.remove();
							$('.myTable1 tbody tr').each(function() { 
								var distriCurrentRow = $(this).closest("tr");
								if($(distriCurrentRow).attr('class')==className){
									distriCurrentRow.remove();
								}
							});
						
							var x=0;
							$('.myTable tbody tr').each(function() { 
									x++;
									$(this).find("td:eq(2)").text(x);
									$(this).attr('class', 'dynamicRow'+x);
							});
							
							var y=0;
							$('.myTable1 tbody tr').each(function() { 
									if($(this).attr('id')!=undefined){
										y++
										$(this).find("td:eq(2)").text(y);
										$(this).attr('class', 'dynamicRow'+y);
									}
							});
						}
						
					});
				} else {
					return;
				}
			});
			
			/*this is function is add  a field invoiceLine */		
			$('.btnAdd').click(function(){

				var botId;var invoiceUniqueId;var lineNumber;
				$('.myTable tbody tr').each(function() {
					botId=$(this).find("td:eq(0)").text();   
					invoiceUniqueId=$(this).find("td:eq(1)").text();
					lineNumber=$(this).find("td:eq(2)").text();
					lineNumber=parseInt(lineNumber)+1;
				 });
				
				 if(lineNumber==undefined && invoiceUniqueId==undefined && botId==undefined){
					 lineNumber=1;
					 invoiceUniqueId=invoiceUniqueIdLine;
					 botId=botIdLine;
				 }

 				var line="<tr id ='dynamic' class='dynamicRow"+lineNumber+"' ><td style='display: none;'>"+botId+"</td>"
					+"<td style='display: none;'>"+invoiceUniqueId+"</td>"
					+"<td>"+lineNumber+"</td>"
					+"<td contenteditable='true'></td>"
					+"<td contenteditable='true'></td>"
					+"<td contenteditable='true'></td>"
					+"<td class='quantityNumber' contenteditable='true'></td>"
					+"<td class='unitPriceNumber' contenteditable='true'></td>"
					+"<td class='itemTotalNumber' contenteditable='true'></td>"
					+"<td class='pairingPOLineNo' contenteditable='true'></td>"
                    +"<td><button type='button'class='btn btn-danger btn-sm btnDelete'>delete</button>"
                    +"</td></tr>";
 				
 				$('.myTable').append(line);
 				addDistributionOnAddLine(lineNumber,invoiceUniqueId,botId);
			  });
			
			
		  /*Remove last line*/
	   		$('.myTable').on('click', '.btnRemoveLine', function() {
					
					var currentRow  = $(this).closest("tr");
					var className = $(currentRow).attr('class');
					var dynamicSplit = $('.'+className+'').find("td:eq(3)").text().charAt(0);
                
					currentRow.remove();
					
					$('.'+className+'').each(function() {
						 $(this).find("td:eq(3)").html(dynamicSplit);
						 dynamicSplit = parseInt(dynamicSplit)+1;
						
					});
				});
			
	/* update and add operation of invoice Details*/
	$(".btn-update").click(function() {
		
			   /* getting value from invoiceHeader*/
			  
			   var botId= $('.botId').val();
			   var invoiceUniqueId= $('.invoiceUniqueId').val();
			   var poNumber= $('.poNumber').val();
			 
			   var mailSubject=$('.mailSubject').val();
			   var invoiceCurrency= $('.invoiceCurrency').val();
			   var shipToLocationCode= $('.shipToLocationCode').val();
			   var shipToAddressLine1= $('.shipToAddressLine1').val();
			  
			   var shipToCity= $('.shipToCity').val();
			   var shipToState= $('.shipToState').val();
			   var shipToCountry= $('.shipToCountry').val();
			   var shipToPostalCode= $('.shipToPostalCode').val();
		  	   var shipToLocationCode=$('.shipToLocationCode').val();
			    		   	   
		  	   var billToLocationCode= $('.billToLocationCode').val();
			   var billToAddressLine1= $('.billToAddressLine1').val();
			 
			   var billToCity= $('.billToCity').val();
			   var billToState= $('.billToState').val();
			   var billToCountry= $('.billToCountry').val();
			   var billToPostalCode= $('.billToPostalCode').val();
			   var billingAddress= $('.billingAddress').val();
			  
			   var costCenter=$('.costCenter').val();
			   var costCenterManagerId= $('.costCenterManagerId').val();
			   var invoiceNumber= $('.invoiceNumber').val();
			   var invoiceDate= $('.invoiceDate').val();
			   var invoiceAmount= $('.invoiceAmount').val();
			   var vendorName= $('.vendorName').val();
			   var shippingAddress= $('.shippingAddress').val();
			   var vendorAddress= $('.vendorAddress').val();
			   var invoiceStatus=$('.invoiceStatus').val();
			   var mailFromId=$('.mailFromId').val();
			   /*convert String to date*/
			 
			   var mailDateTime=$('.mailDateTime').val();
			   var action='update'
				   alert(invoiceDate.length+">>>");
				   if(invoiceDate.length==0){
					   alert(invoiceDate.length+">>>"); 
				   }
				   
				/*Check InvoiceAmount is numeric or Not */ 
				  if(invoiceAmount!=""){
					  if(!(/^[-+]?\d*\.?\d*$/.test(invoiceAmount))) {
                  		$('#duplicateIdSpan').html("Invoice amount should be numeric !");
						$('#duplicateConfirmModal').modal();
                  		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                      }
				  }
				   
			   /* getting value from table using json array invoiceLine*/
			     var arrayInvoiceLine = [];
			    $('.myTable tbody tr').each(function(row, tr) {
			    	var className = $(this).attr('class');
			    	var botId=$(this).find("td:eq(0)").html();
			    	var invoiceUniqueId=$(this).find("td:eq(1)").html();//primary Key
				    var lineNumber = $(this).find("td:eq(2)").html();//primary Key
				    var poLineNumber = $(this).find("td:eq(3)").html();
				    var itemCode = $(this).find("td:eq(4)").html();
				    var itemdescription = $(this).find("td:eq(5)").html();
				    var quantity = $(this).find("td:eq(6)").html();
				    var unitPrice = $(this).find("td:eq(7)").html();
				    var itemTotal = $(this).find("td:eq(8)").html();
				    var pairingPOLineNo = $(this).find("td:eq(9)").html();
				    
				    
				   
               /*validation for invoiceLine table if any field is set null for non po and po type both*/
				    
				    /*for Po Type */
				    if(poNumber!=""){
				    	 if(poLineNumber=="" && itemCode=="" && itemdescription==""){
							   $('#duplicateIdSpan').html("Fields cannot be empty ! mandatory at least one from PO line number , item code ,item description");
							   $('#duplicateConfirmModal').modal();
							   x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
						       
				    	 }
				    	 if(quantity==""){
				    		 $('#duplicateIdSpan').html("Fields cannot be empty ! quantity is mandatory field");
							   $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
				    	 }
				    	 if(unitPrice==""){
				    		 $('#duplicateIdSpan').html("Fields cannot be empty ! unit price is mandatory field");
							   $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
				    	 }if(itemTotal==""){
				    		 $('#duplicateIdSpan').html("Fields cannot be empty ! item total is mandatory field");
							   $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
				    	 }
				    	 if(pairingPOLineNo==""){
				    		 $('#duplicateIdSpan').html("Fields cannot be empty ! paring po Line is mandatory field");
							   $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
				    	 }
					 }// end of po type validation
				    
				    /*for non po type*/
				    if(poNumber==""){
				    	if(itemTotal==""){
				    	
							   $('#duplicateIdSpan').html("Fields cannot be empty ! item total is mandatory field");
							   $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
						       
				    	 }
				    }
				    arrayInvoiceLine.push({botId:botId,invoiceUniqueId:invoiceUniqueId,lineNumber: lineNumber, poLineNumber: poLineNumber ,itemCode:itemCode, itemdescription:itemdescription, quantity:quantity,unitPrice:unitPrice,itemTotal:itemTotal,pairingPOLineNo:pairingPOLineNo});
				   });
			
			    
               /*Validation on invoiceLine if Quantity itemCode and unitPrice is numeric or not*/
			    
				$('.quantityNumber').each(function() {
					var quantityVal=$(this).text();
                    if(quantityVal!=""){
                    	
                    	if(!(/^[-+]?\d*\.?\d*$/.test(quantityVal))) {
                    		$('#duplicateIdSpan').html("Quantity should be numeric !");
							$('#duplicateConfirmModal').modal();
                    		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                        }

                    }
                });
				
				$('.unitPriceNumber').each(function() {
					var unitPriceVal=$(this).text();
                    if(unitPriceVal!=""){
                    	
                    	if(!(/^[-+]?\d*\.?\d*$/.test(unitPriceVal))) {
                    		$('#duplicateIdSpan').html("Unit price should be numeric !");
							$('#duplicateConfirmModal').modal();
                    		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                        }

                    }
                });
				
				
				$('.itemTotalNumber').each(function() {
					var itemTotalVal=$(this).text();
                    if(itemTotalVal!=""){
                    	if(!(/^[-+]?\d*\.?\d*$/.test(itemTotalVal))) {
                    		$('#duplicateIdSpan').html("Item total should be numeric !");
							$('#duplicateConfirmModal').modal();
                    		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                        }
                    }
                });
				$('.pairingPOLineNo').each(function() {
					var paringPoLineVal=$(this).text();
                    if(paringPoLineVal!=""){
                    	if(!(/^[-+]?\d*\.?\d*$/.test(paringPoLineVal))) {
                    		$('#duplicateIdSpan').html("Paring PoLine No should be numeric !");
							$('#duplicateConfirmModal').modal();
                    		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                        }
                    }
                });
				
				
				// end of Validation on invoiceLine if Quantity itemCode and unitPrice is numeric or not
	     	  
		   
			    /* getting value from table using json array invoiceLineDistribution*/
			    var arrayInvoiceDistribution = [];
			    var totalSplitAmount=0;
			    var totalAmount;var distributionSet;var splitLineId; var lineNumber;
			    
			    if(poNumber==""){
			    	 $('.myTable1 tbody tr').each(function(row, tr) {
					    	
					    	var currentRow = $(this).closest("tr");
							var className = $(this).attr('class');
							
							/*validation for split Amount is correct or not */
							/*var splitAmount=0;	var totalAmount=0; var lineNumber;
							$('.'+className+'').each(function() {
								lineNumber = $(this).find("td:eq(2)").text();
								totalAmount = $(this).find("td:eq(4)").text();
								splitAmount = parseInt($(this).find("td:eq(5)").text())+parseInt(splitAmount);
							});
							if(splitAmount!=totalAmount){
								alert("Total splited amount for Line Number : "+lineNumber+" is incorrect !");
								x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
							}*/
							
					    	var botId=$(this).find("td:eq(0)").html();
					    	var invoiceUniqueId=$(this).find("td:eq(1)").html();//primary Key
					    	var lineNumber = $(this).find("td:eq(2)").html()// primary key
					    	var splitLineId = $(this).find("td:eq(3)").html();//primary key
					    	var totalAmount = $(this).find("td:eq(4)").html();
					    	 var splitAmount = $(this).find("td:eq(5)").html().trim();
					    	
					    	/*var accountNumber = $(this).find("td:eq(6) select").val();
					    	*/
					    	var accountNumber = $(this).find("td:eq(6) select").val();
					    	var accountAlias = $(this).find("td:eq(7) select").val();
					        var distributionSet = $(this).find("td:eq(8) select").val();
					            if(splitAmount==""){
					            	splitAmount=0;
					            }
					         
					        /* validation for distribution set apply if user spit the amount and during update thie the distribution sert is apply then the validation works fine */
					       
					            $('.myTable1 .'+className).each(function() {
								  var splitlineId=$(this).find("td:eq(3)").text();
								  var distributionSet=$(this).find("td:eq(8) select").val()
								 
									if((splitlineId>1) && (distributionSet.length>0) ){
										$('#duplicateIdSpan').html("Can not be split ! distributaion set applied");
										$('#duplicateConfirmModal').modal();
							        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
									}
								});/*end of distribution validation */
								
								
								/*validation for invoice distribution table if any field is set null*/
								/*$('.'+className+'').each(function() {
									  var accountNumber=$(this).find("td:eq(7)").text();
									  var distributionSet=$(this).find("td:eq(8)").text()
									   var accountAlias=$(this).find("td:eq(6)").text()
									 
										if(accountNumber=="" && distributionSet=="" && accountAlias==""){
											 alert("Fields Cannot Be Empty ! Mandatory At Least One From Account Number , Distribution Set And Account Alias");
								        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
										}
									});*//*end of distribution validation */
					    	
		                   arrayInvoiceDistribution.push({botId:botId,invoiceUniqueId:invoiceUniqueId, lineNumber: lineNumber, splitLineId: splitLineId ,totalAmount:totalAmount, splitAmount:splitAmount, accountNumber:accountNumber,accountAlias:accountAlias,distributionSet:distributionSet});
		                  
		                   
		                 });
			    	 }
			
			    /* if any fields is empty through out the manage invoice page  */
			  
			   /*validation if po number is empty*/
			    else if (poNumber == "") {
			    	
			    	if(costCenter == ""){
			    	$('#duplicateIdSpan').html("Fields cannot be empty ! check if cost center is not empty");
					$('#duplicateConfirmModal').modal();
			    	return;}
					if(costCenterManagerId == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if costcentermanagerid is not empty");
					$('#duplicateConfirmModal').modal();
					return;}
			    	if(invoiceNumber == ""){
			    	$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice number is not empty");
					$('#duplicateConfirmModal').modal();
			    	return;}
					if(invoiceDate == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice date is not empty");
					$('#duplicateConfirmModal').modal();
					return;}
					if(invoiceAmount == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice amount is not empty");
					$('#duplicateConfirmModal').modal();
					return;}
				
					//Checking a email address is valid or not
				       var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i

					if (!pattern.test(costCenterManagerId)) {
						$('#duplicateIdSpan').html(costCenterManagerId + ' ' + ' = is not a valid mail address');
						$('#duplicateConfirmModal').modal();
						return;
					} 
				       
				      
				}
			    
	    /*validation if PO Oracle Data and Invoice data are matched or not */
			    
              if(poNumber!=""){
			    	
			    	if(vendorName!=$('.poOracle_vendorName').val()){
			    		$('#duplicateIdSpan').html("Invoice vendor name not matched with PO vendor name");
						$('#duplicateConfirmModal').modal();
			    		return;
			    	}
			    	
			    	 if(invoiceCurrency!=$('.poOracle_poCurrency').val()){
				    		$('#duplicateIdSpan').html("Invoice currency is not matching with po currency");
							$('#duplicateConfirmModal').modal();
				    		return;
				    	}
			    	 
			    	 if(billToLocationCode==""){
			    		 if(billToPostalCode!=$('.poOracle_billToPostalCode').val()){
			    			 $('#duplicateIdSpan').html("Invoice bill to postal code is not matching with PO bill to postal code");
								$('#duplicateConfirmModal').modal();
			    			 return;
			    		 }
			    	 }else{
			    		 if(billToLocationCode!=$('.poOracle_billToLocationCode').val()){
					    		$('#duplicateIdSpan').html("Invoice bill to location code is not matching with PO bill to location code");
								$('#duplicateConfirmModal').modal();
					    		return;
					    	}
			    	 }
                     
			      
			    }
			    
				
	               		/*Calling Loader*/
	    				 showPage();
	    				 disableScreen();
	     	            $.post("invoiceDetails", {
	     	            
	     	            	action : action,
	     	            	botId:botId,
	     					invoiceUniqueId : invoiceUniqueId,
	     					poNumber:poNumber,
	     					costCenter:costCenter,
	     					costCenterManagerId:costCenterManagerId,
	     					invoiceNumber:invoiceNumber,
	     					invoiceDate:invoiceDate,
	     					invoiceAmount:invoiceAmount,
	     					vendorName:vendorName,
	     					shippingAddress:shippingAddress,
	     					vendorAddress:vendorAddress,
	     					invoiceStatus:invoiceStatus,
	                        mailDateTime:new Date(mailDateTime),
	                         mailFromId:mailFromId,
	                         mailSubject: mailSubject,
	     					arrayInvoiceLine:JSON.stringify(arrayInvoiceLine),
	     					arrayInvoiceDistribution:JSON.stringify(arrayInvoiceDistribution),
	     					
	     					shipToLocationCode:shipToLocationCode,
	     					shipToAddressLine1:shipToAddressLine1,
	     					/*shipToAddressLine2:shipToAddressLine2,
	     					shipToAddressLine3:shipToAddressLine3,*/
	     					shipToCity:shipToCity,
	     					shipToState:shipToState,
	     					shipToPostalCode:shipToPostalCode,
	     					shipToCountry:shipToCountry,
	     					
	     					
	     					billToLocationCode:billToLocationCode,
	     					billToAddressLine1:billToAddressLine1,
	     					/*billToAddressLine2:billToAddressLine2,
	     					billToAddressLine3:billToAddressLine3,*/
	     					billToCity:billToCity,
	     					billToState:billToState,
	     					billToCountry:billToCountry,
	     					billToPostalCode:billToPostalCode,
	     					billingAddress:billingAddress,
	     					invoiceCurrency:invoiceCurrency
	     				}, function(res){
	     					
	     					if(res==1){
	     						$('#duplicateIdSpanUpdate').html("Data is updated and mail has been sent !");
	     						$('#updateConfirmModaljquery').modal();
	     						disableLoader();
	     						enableScreen();
                               }
	     				  if(res==0){
	     						$('#duplicateIdSpan').html("Unable to send mail ! make sure username and password is correct or  your less secure app access is on of gmail account!");
	     						$('#duplicateConfirmModal').modal();
	     					    window.open('https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web', '_newtab');
	     					}
	     				 /* if(res==2){
	     					  $('#duplicateIdSpan').html("Unable to send mail please check bot email id is not present!");
	     					  $('#duplicateConfirmModal').modal();
	     					  disableLoader();
	     					  enableScreen();
	     				  }*/
	     					
	     				});
	               	 
	 	});// end of update function
	
/* Approved of invoice Details*/
	
	$(".btn-approved").click(function() {

			  /* getting value from invoiceHeader*/
			   var botId= $('.botId').val();
			   var invoiceUniqueId= $('.invoiceUniqueId').val();
			   var poNumber= $('.poNumber').val();
			   var mailFromId=$('.mailFromId').val();
			   var mailSubject=$('.mailSubject').val();
			   var invoiceCurrency= $('.invoiceCurrency').val();
			   var shipToLocationCode= $('.shipToLocationCode').val();
			   var shipToAddressLine1= $('.shipToAddressLine1').val();
			   
			  
			   /*var shipToAddressLine2= $('.shipToAddressLine2').val();
			   var shipToAddressLine3= $('.shipToAddressLine3').val();*/
			   var shipToCity= $('.shipToCity').val();
			   var shipToState= $('.shipToState').val();
			   var shipToCountry= $('.shipToCountry').val();
			   var shipToPostalCode= $('.shipToPostalCode').val();
		  	   var shipToLocationCode=$('.shipToLocationCode').val();
			    		   	   
		  	   var billToLocationCode= $('.billToLocationCode').val();
			   var billToAddressLine1= $('.billToAddressLine1').val();
			  /* var billToAddressLine2= $('.billToAddressLine2').val();
			   var billToAddressLine3= $('.billToAddressLine3').val();*/
			   var billToCity= $('.billToCity').val();
			   var billToState= $('.billToState').val();
			   var billToCountry= $('.billToCountry').val();
			   var billToPostalCode= $('.billToPostalCode').val();
			   var billingAddress= $('.billingAddress').val();
			   
			   var costCenter=$('.costCenter').val();
			   var costCenterManagerId= $('.costCenterManagerId').val();
			   var invoiceNumber= $('.invoiceNumber').val();
			   var invoiceDate= $('.invoiceDate').val();
			   var invoiceAmount= $('.invoiceAmount').val();
			   var vendorName= $('.vendorName').val();
			   var shippingAddress= $('.shippingAddress').val();
			   var vendorAddress= $('.vendorAddress').val();
			   var invoiceStatus=$('.invoiceStatus').val();
			   var mailFromId=$('.mailFromId').val();
			   var mailDateTime1=$('.mailDateTime').val();
			  
			   var action='apporve'
				   
				   /*Check InvoiceAmount is numeric or Not */ 
					  if(invoiceAmount!=""){
						  if(!(/^[-+]?\d*\.?\d*$/.test(invoiceAmount))) {
	                  		$('#duplicateIdSpan').html("Invoice amount should be numeric !");
	  					  $('#duplicateConfirmModal').modal();
	                  		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
	                      }
					  }
				   /* getting value from table using json array invoiceLine*/
			     var arrayInvoiceLine = [];
			    $('.myTable tbody tr').each(function(row, tr) {
			    	var className = $(this).attr('class');
			    	var botId=$(this).find("td:eq(0)").html();//primary Key
			    	var invoiceUniqueId=$(this).find("td:eq(1)").html();//primary Key
				    var lineNumber = $(this).find("td:eq(2)").html();//primary Key
				    var poLineNumber = $(this).find("td:eq(3)").html();
				    var itemCode = $(this).find("td:eq(4)").html();
				    var itemdescription = $(this).find("td:eq(5)").html();
				    var quantity = $(this).find("td:eq(6)").html();
				    var unitPrice = $(this).find("td:eq(7)").html();
				    var itemTotal = $(this).find("td:eq(8)").html();
				    var pairingPOLineNo=$(this).find("td:eq(9)").html();
				    
				   
               /*validation for invoiceLine table if any field is set null for non po and po type both*/
				    
				    /*for Po Type */
				    if(poNumber!=""){
				    	 if(poLineNumber=="" && itemCode=="" && itemdescription==""){
							   $('#duplicateIdSpan').html("Fields cannot be empty ! mandatory at least one from PO line number , item code ,item description");
			  					  $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
						       
				    	 }
				    	 if(quantity==""){
				    		 $('#duplicateIdSpan').html("Fields cannot be empty ! quantity is mandatory field");
		  					  $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
				    	 }
				    	 if(unitPrice==""){
				    		 $('#duplicateIdSpan').html("Fields cannot be empty ! unit price is mandatory field");
		  					  $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
				    	 }if(itemTotal==""){
				    		 $('#duplicateIdSpan').html("Fields cannot be empty ! item total is mandatory field");
		  					  $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
				    	 }if(pairingPOLineNo==""){
				    		 $('#duplicateIdSpan').html("Fields cannot be empty ! Pairing POLine No is mandatory field");
		  					  $('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
				    	 }
					 }// end of po type validation
				    
				    /*for non po type*/
				    if(poNumber==""){
				    	if(itemTotal==""){
							   $('#duplicateIdSpan').html("Fields cannot be empty ! item total is mandatory field");
			  					$('#duplicateConfirmModal').modal();
					        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
						       
				    	 }
				    }
				    arrayInvoiceLine.push({botId:botId,invoiceUniqueId:invoiceUniqueId,lineNumber: lineNumber, poLineNumber: poLineNumber ,itemCode:itemCode, itemdescription:itemdescription, quantity:quantity,unitPrice:unitPrice,itemTotal:itemTotal,pairingPOLineNo:pairingPOLineNo});
				   });
			

			    /*Validation on invoiceLine if Quantity itemCode and unitPrice is numeric or not*/
		     
			    $('.quantityNumber').each(function() {
					var quantityVal=$(this).text();
                    if(quantityVal!=""){
                    	
                    	if(!(/^[-+]?\d*\.?\d*$/.test(quantityVal))) {
                    		$('#duplicateIdSpan').html("Quantity should be numeric !");
		  					$('#duplicateConfirmModal').modal();
                    		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                        }

                    }
                });
				
				$('.unitPriceNumber').each(function() {
					var unitPriceVal=$(this).text();
                    if(unitPriceVal!=""){
                    	
                    	if(!(/^[-+]?\d*\.?\d*$/.test(unitPriceVal))) {
                    		$('#duplicateIdSpan').html("Unit price should be numeric !");
		  					$('#duplicateConfirmModal').modal();
                    		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                        }

                    }
                });
				
				$('.itemTotalNumber').each(function() {
					var itemTotalVal=$(this).text();
                    if(itemTotalVal!=""){
                    	
                    	if(!(/^[-+]?\d*\.?\d*$/.test(itemTotalVal))) {
                    		$('#duplicateIdSpan').html("Item total should be numeric !");
		  					$('#duplicateConfirmModal').modal();
                    		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                        }

                    }
                });
				
				$('.pairingPOLineNo').each(function() {
					var itemTotalVal=$(this).text();
                    if(itemTotalVal!=""){
                    	
                    	if(!(/^[-+]?\d*\.?\d*$/.test(itemTotalVal))) {
                    		$('#duplicateIdSpan').html("Pairing POLine No should be numeric !");
		  					$('#duplicateConfirmModal').modal();
                    		x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here	
                        }

                    }
                })
				
				
				// end of Validation on invoiceLine if Quantity itemCode and unitPrice is numeric or not
			    
			    /* getting value from table using json array invoiceLineDistribution*/
			    var arrayInvoiceDistribution = [];
			    var totalSplitAmount=0;
			    var totalAmount;var distributionSet;var splitLineId; var lineNumber;
			    
			    if(poNumber==""){
			    	$('.myTable1 tbody tr').each(function(row, tr) {
				    	
				    	var currentRow = $(this).closest("tr");
						var className = $(this).attr('class');
						
						/*validation for */
						var splitAmount=0;	var totalAmount=0; var lineNumber;
						$('.myTable1 .'+className).each(function() {
							lineNumber = $(this).find("td:eq(2)").text();
							totalAmount = parseInt($(this).find("td:eq(4)").text());
							splitAmount = parseInt($(this).find("td:eq(5)").text())+parseInt(splitAmount);
						});
						
						if(splitAmount!=totalAmount){
							
							$('#duplicateIdSpan').html("Total splited amount for line number : "+lineNumber+" is incorrect !");
		  					$('#duplicateConfirmModal').modal();
							x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
						}
						 		
				    	var botId=$(this).find("td:eq(0)").html();
				    	var invoiceUniqueId=$(this).find("td:eq(1)").html();//primary Key
				    	lineNumber = $(this).find("td:eq(2)").html()// primary key
				    	splitLineId = $(this).find("td:eq(3)").html();//primary key
				    	totalAmount = $(this).find("td:eq(4)").html();
				    	var splitAmount = $(this).find("td:eq(5)").html().trim();
				    	var accountNumber = $(this).find("td:eq(6) select").val();
				    	var accountAlias = $(this).find("td:eq(7) select").val();
				    	
				    	/*var accountNumber = $(this).find("td:eq(6) select").val();*/
				        distributionSet = $(this).find("td:eq(8) select").val();
				        
				        /* validation for distribution set apply if user spit the amount and during update thie the distribution sert is apply then the validation works fine */
				       
				        $('.myTable1 .'+className).each(function() {
							  var splitlineId=$(this).find("td:eq(3)").text();
							  var distributionSet=$(this).find("td:eq(8) select").val();
							 
								if((splitlineId>1) && (distributionSet.length>0) ){
									 
									$('#duplicateIdSpan').html("Can not be split ! distribution set applied");
				  					$('#duplicateConfirmModal').modal();
						        	x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
								}
							});/*end of distribution validation */
							
							
							/*validation for invoice distribution table if any field is set null*/
				        $('.myTable1 .'+className).each(function() {
				        	
								 // var accountNumber=$(this).find("td:eq(7) select").val();
								var accountNumber=$(this).find("td:eq(6) select").val();
								  var distributionSet=$(this).find("td:eq(8) select").val()
								   var accountAlias=$(this).find("td:eq(7) select").val()					  
								      
									if(accountNumber=="" && distributionSet=="" &&  accountAlias==""){
										
			                                $('#duplicateIdSpan').html("Fields cannot be empty ! mandatory at least one from account number, distribution set and account alias");
						  					$('#duplicateConfirmModal').modal();
										    x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
									
									}else if(accountNumber!="" && distributionSet!=""  &&  accountAlias==""){
										
										$('#duplicateIdSpan').html("Fields cannot be empty ! mandatory only one from account number, distribution set and account alias");
					  					$('#duplicateConfirmModal').modal();
									    x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
									
									}else if(accountNumber=="" && distributionSet!=""  &&  accountAlias!=""){
									
										$('#duplicateIdSpan').html("Fields cannot be empty ! mandatory only one from account number, distribution set and account alias");
					  					$('#duplicateConfirmModal').modal();
									    x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
									
									}else if(accountNumber!="" && distributionSet==""  &&  accountAlias!=""){
										
										$('#duplicateIdSpan').html("Fields cannot be empty ! mandatory only one from account number, distribution set and account alias");
					  					$('#duplicateConfirmModal').modal();
									    x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
									}else if(accountNumber!="" && distributionSet!=""  &&  accountAlias!=""){
										
										$('#duplicateIdSpan').html("Fields cannot be empty ! mandatory only one from account number, distribution set and account alias");
					  					$('#duplicateConfirmModal').modal();
									    x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
									}
								});/*end of distribution validation */
				    	
	                   arrayInvoiceDistribution.push({botId:botId,invoiceUniqueId:invoiceUniqueId, lineNumber: lineNumber, splitLineId: splitLineId ,totalAmount:totalAmount, splitAmount:splitAmount, accountNumber:accountNumber,accountAlias:accountAlias,distributionSet:distributionSet});
					    
					 });
			    }
			    
			    /* if any fields is empty through out the manage invoice page  */
			  
			    /*validation if po number is not empty*/
			    if (poNumber != "") {
					if(invoiceNumber == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice number is not empty");
  					$('#duplicateConfirmModal').modal();
					return;}
					if(invoiceDate == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice date is not empty");
  					$('#duplicateConfirmModal').modal();
					return;}
					if(invoiceAmount == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice amount is not empty");
  					$('#duplicateConfirmModal').modal();
					return;}
				}
			    /*validation if po number is empty*/
			    else if (poNumber == "") {
			    	if(costCenter == ""){
			    	$('#duplicateIdSpan').html("Fields cannot be empty ! check if cost center is not empty");
  					$('#duplicateConfirmModal').modal();
			    	return;}
					if(costCenterManagerId == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if cost center manager id is not empty");
  					$('#duplicateConfirmModal').modal();
					return;}
			    	if(invoiceNumber == ""){
			    	$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice number is not empty");
  					$('#duplicateConfirmModal').modal();
			    	return;}
					if(invoiceDate == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice date is not empty");
  					$('#duplicateConfirmModal').modal();
					return;}
					if(invoiceAmount == ""){
					$('#duplicateIdSpan').html("Fields cannot be empty ! check if invoice amount is not empty");
  					$('#duplicateConfirmModal').modal();
					return;}
				    /*Checking a email address is valid or not*/
				       var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i

					if (!pattern.test(costCenterManagerId)) {
						$('#duplicateIdSpan').html(costCenterManagerId + " = is not a valid mail address");
	  					$('#duplicateConfirmModal').modal();
						return;
					} 
				}
			    
    /*validation if PO Oracle Data and Invoice data are matched or not */
			    
			    if(poNumber!=""){
			    	
			    	if(vendorName!=$('.poOracle_vendorName').val()){
			    		$('#duplicateIdSpan').html("Invoice vendor name not matched with PO vendor name");
	  					$('#duplicateConfirmModal').modal();
			    		return;
			    	}
			    	
			    	 if(invoiceCurrency!=$('.poOracle_poCurrency').val()){
				    		$('#duplicateIdSpan').html("Invoice currency is not matching with PO currency");
		  					$('#duplicateConfirmModal').modal();
				    		return;
				    	}
			    	 
			    	 if(billToLocationCode==""){
			    		 if(billToPostalCode!=$('.poOracle_billToPostalCode').val()){
			    			 $('#duplicateIdSpan').html("Invoice bill to postal code is not matching with PO bill to postal code");
			  					$('#duplicateConfirmModal').modal();
			    			 return;
			    		 }
			    	 }else{
			    		 if(billToLocationCode!=$('.poOracle_billToLocationCode').val()){
					    		 $('#duplicateIdSpan').html("Invoice bill to location code is not matching with PO bill to location code");
				  					$('#duplicateConfirmModal').modal();
					    		return;
					    	}
			    	 }
                     
			      
			    }
			        /*Calling Loader*/
       				 showPage();
       				 disableScreen();
       	            $.post("invoiceDetails", {
       	            	action : action,
       	            	botId:botId,
       					invoiceUniqueId : invoiceUniqueId,
       					poNumber:poNumber,
       					costCenter:costCenter,
       					costCenterManagerId:costCenterManagerId,
       					invoiceNumber:invoiceNumber,
       					mailFromId:mailFromId,
       				    mailSubject: mailSubject,
       					invoiceDate:invoiceDate,
       					invoiceAmount:invoiceAmount,
       					vendorName:vendorName,
       					shippingAddress:shippingAddress,
       					vendorAddress:vendorAddress,
       					invoiceStatus:invoiceStatus,
       					arrayInvoiceLine:JSON.stringify(arrayInvoiceLine),
       					arrayInvoiceDistribution:JSON.stringify(arrayInvoiceDistribution),
       					shipToLocationCode:shipToLocationCode,
       					shipToAddressLine1:shipToAddressLine1,
       					/*shipToAddressLine2:shipToAddressLine2,
       					shipToAddressLine3:shipToAddressLine3,*/
       					shipToCity:shipToCity,
       					shipToState:shipToState,
       					shipToPostalCode:shipToPostalCode,
       					shipToCountry:shipToCountry,
       					billToLocationCode:billToLocationCode,
       					billToAddressLine1:billToAddressLine1,
       					/*billToAddressLine2:billToAddressLine2,
       					billToAddressLine3:billToAddressLine3,*/
       					billToCity:billToCity,
       					billToState:billToState,
       					billToCountry:billToCountry,
       					billToPostalCode:billToPostalCode,
       					billingAddress:billingAddress,
       					invoiceCurrency:invoiceCurrency
       				}, function(res){
       					if(res==1){
       						
       						/*and mail has been sent*/ 
       						$('#duplicateIdSpanApprove').html("Data is approved !");
       						//$('#duplicateIdSpanApprove').html("Data is approved !");
       	  					$('#approveConfirmModaljquery').modal();
       	  					disableLoader();
       	  					enableScreen();
       	  				
       					}
       				 /* if(res==0){
       						$('#duplicateIdSpan').html("Unable to send mail ! make sure username and password is correct or  your less secure app access is on of gmail account!");
       	  					$('#duplicateConfirmModal').modal();
       					      window.open('https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web', '_newtab');
       					}
       				  if(res==2){
       					  $('#duplicateIdSpan').html("Unable to send mail please check bot email id is not present!");
       	  				  $('#duplicateConfirmModal').modal();
       	  				  disableLoader();
       	  				enableScreen();
       				  }
       					*/
       				});
               	
			    	
			 
});// end of approve function  
	
	
	
/*Reject Event Pass*/
	$(".btnReject").click(function() {
       	var reason = $('#reason').val();
		if(reason=="" && reason==null){
			return false;
		}
		if (reason!="" && reason!=null) {
			  
			 /* getting value from invoiceHeader*/
			   var invoiceUniqueId= $('.invoiceUniqueId').val();
			   var botId=$('.botId').val();
			   var invoiceNumber=$('.invoiceNumber').val();
			   var mailFromId=$('.mailFromId').val();
			   var mailDate=$('.mailDateTime').val();
			   var action='reject'
					/*Calling Loader*/
					 showPage();
					 disableScreen();
				   $.post("reject.do", {
	            	action : action,
	            	botId:botId,
	            	invoiceNumber:invoiceNumber,
	            	invoiceUniqueId : invoiceUniqueId,
	            	mailFromId:mailFromId,
	            	mailDate:mailDate,
	            	comments:reason
				}, function(res){
					
					if(res==1){
						$('#duplicateIdSpanReject').html("Invoice is rejected and mail has been sent !");
		  				$('#rejectConfirmModaljquery').modal();
		  				disableLoader();
		  				enableScreen();
		  				
					}
				  if(res==0){
						$('#duplicateIdSpan').html("Unable to send mail ! make sure username and password is correct or  your less secure app access is on of gmail account!");
	  					$('#duplicateConfirmModal').modal();
					      window.open('https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web', '_newtab');
					}
					
				});
			
			
		}else{return;}
		  

		});
});	
	
	
/*function for fetching costcentermanagerId with respect to costcenterId*/
$(document).ready(function() {
   
	$('.costCenter').change(function(){
		
		var costCenter=$('.costCenter').find(":selected").text();
		  $.post("costCenterManagerId.do", {
			  costCenter:costCenter
           }, function(res){
					$('.costCenterManagerId').val(res);
				
	});
	
	
	});	
	
	
});


function toDate(dateStr) {
	var replaced =dateStr.replace(/[-,:\s]/g, ",")
    var s=replaced.split(",");
   var mailDateTime = s[2] + '-' + s[1] + '-' + s[0]+" "+s[3]+":"+s[4]+":"+s[5];
    
   var m=new Date(mailDateTime);
        alert(m);
	}

/*Loader */
function showPage() {
	  document.getElementById("loader").style.display = "block";
      //document.getElementById("blockPage").style.display = "block";
	}
function disableLoader() {
		 document.getElementById("loader").style.display = "none";
	}

/*Disable Screen*/
function disableScreen() {
    // creates <div class="overlay"></div> and 
    // adds it to the DOM
    var div= document.createElement("div");
    div.className += "overlay";
    document.body.appendChild(div);
}
function enableScreen() {
	 $(".overlay").remove();
}

function addDistributionOnAddLine(lineNumber,invoiceUniqueId,botId){	
	var response="";
	var i=1;
	$('.myTable1 tbody tr').each(function() { 
		i++;
	});
	var className = "dynamicRow"+i;
	var lineNumber; var splitLineId; var totalAmount; var splitAmount; var botId; var invoiceUniqueId; var accountNumber;var accountAlias;
	/*for accountNumber*/
	$.post("accountNumber.do", {
		
	 }, function(accountNumber) {
		//for AccountAlias
		
		$.post("accountAlias.do", {
			
		}, function(accountAlias) {
			//for distributionset
			$.post("accountDistributionSet.do", {
			
			}, function(distributionSet) {
				
				var line=  "<tr id ='dynamic' class='"+className+"'>" +
				  "<td style='display: none;'>"+botId+"</td>"
					+ "<td style='display: none;'>"+invoiceUniqueId+"</td>"
					+ "<td>"+lineNumber+"</td>"
					+ "<td>"+1+"</td>"
					+ "<td contenteditable='true'></td>"
					+ "<td contenteditable='true'></td>"
					+ "<td contenteditable='true'>"+accountNumber+"</td>"
					+ "<td contenteditable='true'>"+accountAlias+"</td>"
					+ "<td contenteditable='true'>"+distributionSet+"</td>"
					+"<td>"
					+"<button type='button' class='btn btn-danger btn-sm btnSplit'>Split</button></td>";
				
				$('.myTable1').append(line);
				
			     
			        $(".select2").select2();
		   })// accountAlias Post close
		 
          })//for accountDistributionSet   
      })//accountNumber post Close			                               	
}

