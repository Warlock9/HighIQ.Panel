

/* split logic function invoice line Distribution */

var poUniqueIdLine="";
var botIdLine="";

$(document)
		.ready(
				function() {
					poUniqueIdLine=$('.poUniqueId').val();
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
			 	
			
			 	 /*sorting in decending order of table */
					$('#zero_config1').dataTable( {
					order: [],
					columnDefs: [ { orderable: false, targets: [0] } ]
					});   // end of sorting in decending order of table 
					      
					
					
				});
		
		/* Delete Action  of invoice line details */
		$(document).ready(function() {
		
			$(".myTable").on('click', '.btnDelete', function() {
				// get the current row
				var conf = confirm("do you really want to delete ? ");
				if (conf == true) {
					var currentRow = $(this).closest("tr");
					var className =  $(currentRow).attr('class');
					var poUniqueId = currentRow.find("td:eq(1)").text();
					var lineNumber = currentRow.find("td:eq(2)").text();
					var action = 'delete';
					$.post("poLine.do", {
						action : action,
						lineNumber : lineNumber,
						poUniqueId : poUniqueId
					}, function(res) {
						if (res == 1) {
							currentRow.remove();
							/*$('.myTable1 tbody tr').each(function() { 
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
							});*/
						}
						
					});
				} else {
					return;
				}
			});
			
			/*this is function is add  a field Order Line */		
			$('.btnAdd').click(function(){
				var botId;var poUniqueId;var lineNumber;
				$('.myTable tbody tr').each(function() {
					
					botId=$(this).find("td:eq(0)").text();   
					poUniqueId=$(this).find("td:eq(1)").text();
					lineNumber=$(this).find("td:eq(2)").text();
					lineNumber=parseInt(lineNumber)+1;
				 });
				 if(lineNumber==undefined && poUniqueId==undefined && botId==undefined){
					 lineNumber=1;
					 poUniqueId=poUniqueIdLine;
					 botId=botIdLine;
				 }

 				/*var line="<tr id ='dynamic' class='dynamicRow"+lineNumber+"' ><td style='display: none;'>"+botId+"</td>"
					+"<td style='display: none;'>"+invoiceUniqueId+"</td>"
					+"<td>"+lineNumber+"</td>"
					
					+"<td contenteditable='true'></td>"
					+"<td contenteditable='true'></td>"
					+"<td contenteditable='true'></td>"
					+"<td class='quantityNumber' contenteditable='true'></td>"
					+"<td class='unitPriceNumber' contenteditable='true'></td>"
					+"<td class='itemTotalNumber' contenteditable='true'></td>"
					+"<td class='uom' contenteditable='true'></td>"
					+"<td class='status' contenteditable='true'></td>"
                    +"<td><button type='button'class='btn btn-danger btn-sm btnDelete'>delete</button>"
                    +"</td></tr>";*/
 				
 				var line="<tr id ='dynamic' class='dynamicRow"+lineNumber+"' ><td style='display: none;'>"+botId+"</td>"
				+"<td style='display: none;'>"+poUniqueId+"</td>"
				+"<td>"+lineNumber+"</td>"
				
				+"<td contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td class='quantityNumber' contenteditable='true'></td>"
				+"<td class='internalNumber' contenteditable='true'></td>"
				+"<td class='unitPriceNumber' contenteditable='true'></td>"
				+"<td class='itemTotalNumber' contenteditable='true'></td>"
				+"<td class='uom' contenteditable='true'></td>"
				+"<td class='status' contenteditable='true'></td>"
				+"<td class='dataIssue' contenteditable='true'></td>"
                +"<td><button type='button'class='btn btn-danger btn-sm btnDelete'>delete</button>"
                +"</td></tr>";
 				
 				$('.myTable').append(line);
 				//addDistributionOnAddLine(lineNumber,invoiceUniqueId,botId);
			  });
			
			
	/*po Date capslock enable*/
			$(".poDate").keyup(function() {
				
				upperCaseText();
			});
		 
			
	/* update and add operation of invoice Details*/
	$(".btn-update").click(function() {
		
			   /* getting value from invoiceHeader*/
			  
			  
			   var poUniqueId= $('.poUniqueId').val();
			   var customerPoNumber= $('.customerPoNumber').val();
			   var poDate= $('.poDate').val();
			   var poAmount= $('.poAmount').val();
			   var poCurrency= $('.poCurrency').val();
			   var poType= $('.poType').val();
			   var customerName= $('.customerName').val();
			   var customerNumber= $('.customerNumber').val();
			   var customerContactName= $('.customerContactName').val();
			   var customerContactPhone= $('.customerContactPhone').val();
			   var customerContactEmail= $('.customerContactEmail').val();
			   
			   
			   
			   var poPaymentTerms= $('.poPaymentTerms').val();
			   var salesChannel= $('.salesChannel').val();
			   var frightTerms= $('.frightTerms').val();
			   var fob= $('.fob').val();
			   var popdfName= $('.popdfName').val();
			   var dataIssues= $('.dataIssues').val();
			   
			   
			   var shippingAddress= $('.shippingAddress').val();
			   var shipToLocationCode= $('.shipToLocationCode').val();
			   var shipToAddressLine1= $('.shipToAddressLine1').val();
			   var shipToCity= $('.shipToCity').val();
			   var shipToState= $('.shipToState').val();
			   var shipToPostalCode= $('.shipToPostalCode').val();
			   var shipToCountry= $('.shipToCountry').val();
			 
			   
			   var billingAddress= $('.billingAddress').val();
			   var billToLocationCode= $('.billToLocationCode').val();
			   var billToAddressLine1= $('.billToAddressLine1').val();
			   var billToCity= $('.billToCity').val();
			   var billToState= $('.billToState').val();
			   var billToPostalCode= $('.billToPostalCode').val();
			   var billToCountry= $('.billToCountry').val();

			   var mailDateTime=$('.mailDateTime').val();
			   var action='update'
				   
				   /* getting value from table using json array invoiceLine*/
				    var arrayPoLine = [];
				    $('.myTable tbody tr').each(function(row, tr) {
				    	var className = $(this).attr('class');
				    	var botId=$(this).find("td:eq(0)").html();
				    	var poUniqueId=$(this).find("td:eq(1)").html();//primary Key
					    var lineNumber = $(this).find("td:eq(2)").html();//primary Key
					    var poLineNumber = $(this).find("td:eq(3)").html();
					    var orderedItemCode = $(this).find("td:eq(4)").html();
					    var internalItemCode = $(this).find("td:eq(5)").html();
					    var itemDescription = $(this).find("td:eq(6)").html();
					    var quantity = $(this).find("td:eq(7)").html();
					    var unitPrice = $(this).find("td:eq(8)").html();

					    var lineTotal = $(this).find("td:eq(9)").html();
					    var uom = $(this).find("td:eq(10)").html();
					    var status = $(this).find("td:eq(11)").html();
					    var comments=$(this).find("td:eq(12)").html();
					    
					    arrayPoLine.push({botId:botId,poUniqueId:poUniqueId,lineNumber:lineNumber, poLineNumber:poLineNumber ,orderedItemCode:orderedItemCode, internalItemCode:internalItemCode,itemDescription:itemDescription, quantity:quantity,unitPrice:unitPrice,lineTotal:lineTotal,uom:uom,status:status,comments:comments});
					  
				    });
				    if (ValidateDate() == false) {
				    	 $('#duplicateIdSpan').html("Wrong Date Format !Mandatory dd-MMM-yyyy");
						  $('#duplicateConfirmModal').modal();
						  x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
					  } 
				    /*Calling Loader*/
	    				 showPage();
	    				 disableScreen();
	     	            $.post("poHeaderSave", {
	     	            action : action,
	     	            poUniqueId:poUniqueId,
	     			    customerPoNumber:customerPoNumber,
	     			    mailDateTime: new Date(mailDateTime),
	     			    poDate:poDate,
	     			    poAmount:poAmount,
	     			    poCurrency:poCurrency,
	     			    poType:poType,
	     			    customerName:customerName,
	     			    customerNumber:customerNumber,
	     			    customerContactName:customerContactName,
	     			    customerContactPhone:customerContactPhone,
    			        customerContactEmail:customerContactEmail,
	     			    poPaymentTerms:poPaymentTerms,
	     			    salesChannel:salesChannel,
	     			    frightTerms:frightTerms,
	     			    fob:fob,
	     			    popdfName:popdfName,
	     			    dataIssues:dataIssues,
	     			   
	     			   
	     			    shippingAddress:shippingAddress,
	     			    shipToLocationCode:shipToLocationCode,
	     			    shipToAddressLine1:shipToAddressLine1,
	     			    shipToCity:shipToCity,
	     			    shipToState:shipToState,
	     			    shipToPostalCode:shipToPostalCode,
	     			    shipToCountry:shipToCountry,
	     			 
	     			   
	     			    billingAddress:billingAddress,
	     			    billToLocationCode:billToLocationCode,
	     			    billToAddressLine1:billToAddressLine1,
	     			    billToCity:billToCity,
	     			    billToState:billToState,
	     			    billToPostalCode:billToPostalCode,
	     			    billToCountry:billToCountry,
	     			   arrayPoLine:JSON.stringify(arrayPoLine)
	     					
	     				}, function(res){
	     						
	     					if(res==1){
	     						$('#duplicateIdSpanUpdate').html("Data is updated !");
	     						$('#updateConfirmModaljquery').modal();
	     						disableLoader();
	     						enableScreen();
                               }
	     				 
	     				});
	               	 
	 	});// end of update function
	

	/*approved action*/

	$(".btn-approved").click(function() {
		
		   /* getting value from invoiceHeader*/
		   var poUniqueId= $('.poUniqueId').val();
		   var customerPoNumber= $('.customerPoNumber').val();
		   var poDate= $('.poDate').val();
		   var poStatus=$('.poStatus').val();
		   var poAmount= $('.poAmount').val();
		   var poCurrency= $('.poCurrency').val();
		   var poType= $('.poType').val();
		   var customerName= $('.customerName').val();
		   var customerNumber= $('.customerNumber').val();
		   var customerContactName= $('.customerContactName').val();
		   var customerContactPhone= $('.customerContactPhone').val();
		   var customerContactEmail= $('.customerContactEmail').val();
		   
		   
		   
		   var poPaymentTerms= $('.poPaymentTerms').val();
		   var salesChannel= $('.salesChannel').val();
		   var frightTerms= $('.frightTerms').val();
		   var fob= $('.fob').val();
		   var popdfName= $('.popdfName').val();
		   var dataIssues= $('.dataIssues').val();
		   
		   
		   var shippingAddress= $('.shippingAddress').val();
		   var shipToLocationCode= $('.shipToLocationCode').val();
		   var shipToAddressLine1= $('.shipToAddressLine1').val();
		   var shipToCity= $('.shipToCity').val();
		   var shipToState= $('.shipToState').val();
		   var shipToPostalCode= $('.shipToPostalCode').val();
		   var shipToCountry= $('.shipToCountry').val();
		 
		   
		   var billingAddress= $('.billingAddress').val();
		   var billToLocationCode= $('.billToLocationCode').val();
		   var billToAddressLine1= $('.billToAddressLine1').val();
		   var billToCity= $('.billToCity').val();
		   var billToState= $('.billToState').val();
		   var billToPostalCode= $('.billToPostalCode').val();
		   var billToCountry= $('.billToCountry').val();

		   var mailDateTime=$('.mailDateTime').val();
		   var action='approved'
			   
			   /* getting value from table using json array invoiceLine*/
			    var arrayPoLine = [];
			    $('.myTable tbody tr').each(function(row, tr) {
			    	var className = $(this).attr('class');
			    	var botId=$(this).find("td:eq(0)").html();
			    	var poUniqueId=$(this).find("td:eq(1)").html();//primary Key
				    var lineNumber = $(this).find("td:eq(2)").html();//primary Key
				    var poLineNumber = $(this).find("td:eq(3)").html();
				    var orderedItemCode = $(this).find("td:eq(4)").html();
				    var internalItemCode = $(this).find("td:eq(5)").html();
				    var itemDescription = $(this).find("td:eq(6)").html();
				    var quantity = $(this).find("td:eq(7)").html();
				    var unitPrice = $(this).find("td:eq(8)").html();

				    var lineTotal = $(this).find("td:eq(9)").html();
				    var uom = $(this).find("td:eq(10)").html();
				    var status = $(this).find("td:eq(11)").html();
				    var comments=$(this).find("td:eq(12)").html();
				    
				    arrayPoLine.push({botId:botId,poUniqueId:poUniqueId,lineNumber:lineNumber, poLineNumber:poLineNumber ,orderedItemCode:orderedItemCode, internalItemCode:internalItemCode,itemDescription:itemDescription, quantity:quantity,unitPrice:unitPrice,lineTotal:lineTotal,uom:uom,status:status,comments:comments});
				  
			    });
			    if (ValidateDate() == false) {
			    	 $('#duplicateIdSpan').html("Wrong Date Format !Mandatory dd-MMM-yyyy");
					  $('#duplicateConfirmModal').modal();
					  x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
				  } 
            		/*Calling Loader*/
 				 showPage();
 				 disableScreen();
  	            $.post("poHeaderSave", {
  	            action : action,
  	            poUniqueId:poUniqueId,
  			    customerPoNumber:customerPoNumber,
  			    mailDateTime: new Date(mailDateTime),
  			    poDate:poDate,
  			    poAmount:poAmount,
  			    poCurrency:poCurrency,
  			    poType:poType,
  			    poStatus:poStatus,
  			    customerName:customerName,
  			    customerNumber:customerNumber,
  			    customerContactName:customerContactName,
  			    customerContactPhone:customerContactPhone,
			    customerContactEmail:customerContactEmail,
  			    poPaymentTerms:poPaymentTerms,
  			    salesChannel:salesChannel,
  			    frightTerms:frightTerms,
  			    fob:fob,
  			    popdfName:popdfName,
  			    dataIssues:dataIssues,
  			   
  			   
  			    shippingAddress:shippingAddress,
  			    shipToLocationCode:shipToLocationCode,
  			    shipToAddressLine1:shipToAddressLine1,
  			    shipToCity:shipToCity,
  			    shipToState:shipToState,
  			    shipToPostalCode:shipToPostalCode,
  			    shipToCountry:shipToCountry,
  			 
  			   
  			    billingAddress:billingAddress,
  			    billToLocationCode:billToLocationCode,
  			    billToAddressLine1:billToAddressLine1,
  			    billToCity:billToCity,
  			    billToState:billToState,
  			    billToPostalCode:billToPostalCode,
  			    billToCountry:billToCountry,
  			    arrayPoLine:JSON.stringify(arrayPoLine)
  					
  				}, function(res){
  						
  					if(res==1){
  						$('#duplicateIdSpanApprove').html("Data is approved and mail has been sent !");
  						$('#approveConfirmModaljquery').modal();
  						disableLoader();
  						enableScreen();
                        }
  				 
  				});
            	 
	});// end of approve function

	

});	
	



function toDate(dateStr) {
	var replaced =dateStr.replace(/[-,:\s]/g, ",")
    var s=replaced.split(",");
   var mailDateTime = s[2] + '-' + s[1] + '-' + s[0]+" "+s[3]+":"+s[4]+":"+s[5];
  // alert(mailDateTime);
   var m=new Date(mailDateTime);
 
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

/*date validation for po Date*/
function ValidateDate() {
	
	  var dtValue = $('#date-mask1').val();
	  var dtRegex = new RegExp("^([0]?[1-9]|[1-2]\\d|3[0-1])-(JAN|FEB|MAR|APR|MAY|JUN|JULY|AUG|SEP|OCT|NOV|DEC)-[1-2]\\d{3}$", 'i');
	  return dtRegex.test(dtValue);
	}


function upperCaseText(){
	$('input[type=text]').val (function () {
	    return this.value.toUpperCase();
	})
}

