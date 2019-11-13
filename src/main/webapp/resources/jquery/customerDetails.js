

/* split logic function invoice line Distribution */

var poUniqueIdLine="";
var botIdLine="";
var	getOperatingIDSelectBox="";
var	getBillToSideIDSelectBox=""; 
var contactCompanyNumber1="";
$(document)
		.ready(
				function() {
			
					
						contactCompanyNumber1=	$('.contactCompanyNumber').val();
					
					
			
			 	 /*sorting in decending order of table */
					$('#zero_config1').dataTable( {
					order: [],
					columnDefs: [ { orderable: false, targets: [0] } ]
					});   // end of sorting in decending order of table 
					      
					
					
				});
		
		/* Delete Action  of invoice line details */
		$(document).ready(function() {
		
			$(".myTable1,.myTable2").on('click', '.btnDelete', function() {
				// get the current row
				var conf = confirm("do you really want to delete ? ");
				if (conf == true) {
					var currentRow = $(this).closest("tr");
					var className =  $(currentRow).attr('class');
					var poUniqueId = currentRow.find("td:eq(1)").text();
					var lineNumber = currentRow.find("td:eq(2)").text();
					var action = 'delete';
					currentRow.remove();
					
				} else {
					return;
				}
			});
			  
		   
			/*this is function is add  a field Customer Line */	
			$('.btnAddCustomer').click(function(){
				
				var contactCompanynumber;
				contactCompanynumber=$('.contactCompanyNumber').val();
				
				$.post("getOperatingIDSelectBox",{},function(res){
					
				  $.post("getBillToSideIDSelectBox",{contactCompanynumber:contactCompanynumber},function(res1){
						
				var id = $('myTable1 tr:last').attr('id');
				var line="<tr>"
				+"<td>"													
					+"<select onchange='showBillToId()'>"
						+"<option value=''>SELECT</option>"
						+"<option value='BILL_TO'>BILL_TO</option>"
						+"<option value='SHIP_TO'>SHIP_TO</option>"
					+"</select>"																									
				+"</td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true' style='display: none;'>"+contactCompanynumber+"</td>"
				+"<td  contenteditable='true'>"+res1+"</td>"
				+"<td contenteditable='true'></td>"+
				+"<td contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'>"+res+"</td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
                +"<td><button type='button'class='btn btn-danger btn-sm btnDelete'>Delete</button>"
                +"</td></tr>";
 				
 				$('.myTable1').append(line);
					});
				});
			});
			
			
			/*this is function is add  a field Order VendorSite */		
			$('.btnAddVendor').click(function(){
				
				var contactCompanynumber;
				contactCompanynumber=$('.contactCompanyNumber').val();
				var contact_Id= document.getElementById("ContactID").value;
				
				$.post("getOperatingIDSelectBox",{},function(res1){
					
				var line="<tr>"
				+"<td  contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td style='display: none' contenteditable='true'>"+contactCompanynumber+"</td>"
				+"<td contenteditable='true'></td>"
				+"<td  contenteditable='true'>"+res1+"</td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
                +"<td><button type='button'class='btn btn-danger btn-sm btnDelete'>Delete</button>"
                +"</td></tr>";  
 				
 				$('.myTable2').append(line);
 				//addDistributionOnAddLine(lineNumber,invoiceUniqueId,botId);
				})  });
			
		/*	$('.btnAddList').click(function(){
				var line="<tr>"
				+"<td  contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
                +"</td></tr>";
 				
 				$('.myTable').append(line);
 				//addDistributionOnAddLine(lineNumber,invoiceUniqueId,botId);
			  });*/
			
			
		 
			
	/* update and add operation of contacts Details*/
	$(".btn-update").click(function() {
		
			   /* getting value from contacts Header*/
			  var contactType=  $('.contactType').val();
		      var contactId=  $('.contactId').val();
		      var contactFirstName=  $('.contactFirstName').val();
		      var contactMiddleName=  $('.contactMiddleName').val();
		      var contactlastName=  $('.contactlastName').val();
		      var contactCompanyNumber=  $('.contactCompanyNumber').val();
		      var contactEmailId=  $('.contactEmailId').val();
		      var contactCompany=$('.contactCompany').val();
		      var contactPhone=  $('.contactPhone').val();
		      var botId=  $('.botId').val();// common fields
		      var action='update'
		      var arrayContactSites = [];
		      
		    	 if(contactType=='Vendor'){
		    		 var bankAccount=  $('.bankAccount').val();
				      var bankAccountCode=  $('.bankAccountCode').val();
				      var bankaccountNumber=  $('.bankaccountNumber').val();
				      var vatRegno=  $('.vatRegno').val();
				      
				      /* getting value from table using json array invoiceLine*/
					   $('.myTable2 tbody tr').each(function(row, tr) {
							    	var className = $(this).attr('class');
							    	var siteType=$(this).find("td:eq(0)").html();
							        var siteUseId=$(this).find("td:eq(1)").html();//primary Key
								    var contactCompanyNumber = $(this).find("td:eq(2)").html();//primary Key
								    var locationId = $(this).find("td:eq(3)").html();
								    var operatingUnitID = $(this).find("td:eq(4) select").val();
								    if(operatingUnitID==undefined)
							    	{
							    	operatingUnitID ="";
							    	}
								    
								    var addressLine1 = $(this).find("td:eq(5)").html();
								    
								    var addressLine2 = $(this).find("td:eq(6)").html();
								    var addressLine3 = $(this).find("td:eq(7)").html();
								    var addressLine4 = $(this).find("td:eq(8)").html();
								    var addressCity = $(this).find("td:eq(9)").html();
                                    var addressState = $(this).find("td:eq(10)").html();
								    var addressPostalCode = $(this).find("td:eq(11)").html();
								    var addressCountry = $(this).find("td:eq(12)").html();
								   
								    arrayContactSites.push({siteType:siteType,siteUseId:siteUseId,contactCompanyNumber:contactCompanyNumber, locationId:locationId, addressLine1:addressLine1, addressLine2:addressLine2, addressLine3:addressLine3, addressLine4:addressLine4, addressCity:addressCity, addressState:addressState, addressPostalCode:addressPostalCode, addressCountry:addressCountry,operatingUnitID:operatingUnitID});
								     
							    });
				        	 /*Calling Loader*/
		    				 showPage();
		    				 disableScreen();
		     	            $.post("manageContactAction", {
						    action : action,
							contactType : contactType,
							contactId : contactId,
							contactFirstName : contactFirstName,
							contactMiddleName : contactMiddleName,
							contactCompany:contactCompany,
							contactlastName : contactlastName,
							contactCompanyNumber : contactCompanyNumber,
							contactEmailId : contactEmailId,
							contactPhone : contactPhone,
							botId : botId,
							bankAccount : bankAccount,
							bankAccountCode : bankAccountCode,
							bankaccountNumber : bankaccountNumber,
							vatRegno : vatRegno,
							arrayContactSites:JSON.stringify(arrayContactSites)
		     	           	
		     				},function(res){
		     					
		     					if(res==1){
		     						$('#duplicateIdSpanUpdate').html("Data is updated !");
		     						$('#updateConfirmModaljquery').modal();
		     						disableLoader();
		     						enableScreen();
	                               }
		     				 
		     				});
		    	  }
		           if(contactType=='Customer'){
		        	      var defaultFobPoint=  $('.defaultFobPoint').val();
					      var defaultPaymentTerms=  $('.defaultPaymentTerms').val();
					      var defaultTranscationType=  $('.defaultTranscationType').val();
					      var defaultWarehouse=  $('.defaultWarehouse').val();
					      var defaultPriceList=  $('.defaultPriceList').val();
			        	 $('.myTable1 tbody tr').each(function(row, tr) {
			        		    var className = $(this).attr('class');
			        		    var siteType=$(this).find("td:eq(0) select").val();
						    	
						        var siteUseId=$(this).find("td:eq(1)").html();//primary Key
							    var contactCompanyNumber = $(this).find("td:eq(2)").html();//primary Key
							    var billToSiteUseId = $(this).find("td:eq(3) select").val();//primary Key 
							    if(billToSiteUseId==undefined)
							    	{
							    	billToSiteUseId ="";
							    	}
							    
							    var locationId = $(this).find("td:eq(4)").html();
							    var addressLine1 = $(this).find("td:eq(5)").html();
							    var addressLine2 = $(this).find("td:eq(6)").html();
							    var addressLine3 = $(this).find("td:eq(7)").html();
							    var addressLine4 = $(this).find("td:eq(8)").html();
							    var addressCity = $(this).find("td:eq(9)").html();
                                var addressState = $(this).find("td:eq(10)").html();
							    var addressCountry = $(this).find("td:eq(12)").html();
							    var addressPostalCode = $(this).find("td:eq(11)").html();
							    
							    var operatingUnitID = $(this).find("td:eq(13) select").val();//primary Key 
							    if(operatingUnitID==undefined)
							    	{
							    	operatingUnitID ="";
							    	}
							    var defaultPaymentTerms = $(this).find("td:eq(14)").html();
							    var defaultTransactionType = $(this).find("td:eq(15)").html();
							    var defaultWareHouse = $(this).find("td:eq(16)").html();
							    var defaultPriceList = $(this).find("td:eq(17)").html();
							    var defaultFOBPoint = $(this).find("td:eq(18)").html();
							   arrayContactSites.push({siteType:siteType,siteUseId:siteUseId,contactCompanyNumber:contactCompanyNumber, billToSiteUseId:billToSiteUseId, locationId:locationId, addressLine1:addressLine1, addressLine2:addressLine2, addressLine3:addressLine3, addressLine4:addressLine4, addressCity:addressCity, addressState:addressState, addressCountry:addressCountry, addressPostalCode:addressPostalCode,defaultPaymentTerms:defaultPaymentTerms,defaultTransactionType:defaultTransactionType,defaultWareHouse:defaultWareHouse,defaultPriceList:defaultPriceList,defaultFOBPoint:defaultFOBPoint,operatingUnitID:operatingUnitID});
						       
			        	 });
			        	 var temp=JSON.stringify(arrayContactSites);
			        	 
			        	 
			        	// Calling Loader
	    				 showPage();
	    				 disableScreen();
	    				 
	    				
	     	            $.post("manageContactAction", {
					    action : action,
						contactType : contactType,
						contactId : contactId,
						contactFirstName : contactFirstName,
						contactMiddleName : contactMiddleName,
						contactCompany:contactCompany,
						contactlastName : contactlastName,
						contactCompanyNumber : contactCompanyNumber,
						contactEmailId : contactEmailId,
						contactPhone : contactPhone,
						botId : botId,
						defaultPaymentTerms:defaultPaymentTerms,
						defaultTransactionType:defaultTranscationType,
						defaultWareHouse:defaultWarehouse,
						defaultPriceList:defaultPriceList,
						defaultFobPoint:defaultFobPoint,
						arrayContactSites:temp
						
	     	           	},function(res){
	     					
	     					if(res==1){
	     						$('#duplicateIdSpanUpdate').html("Data is updated !");
	     						$('#updateConfirmModaljquery').modal();
	     						disableLoader();
	     						enableScreen();
                               }
	     				 
	     				});
			        	
			        }
			               	 
	 	});// end of update function
	
});	
	




		function toDate(dateStr) {
			var replaced =dateStr.replace(/[-,:\s]/g, ",")
		    var s=replaced.split(",");
		   var mailDateTime = s[2] + '-' + s[1] + '-' + s[0]+" "+s[3]+":"+s[4]+":"+s[5];
		  // alert(mailDateTime);
		   var m=new Date(mailDateTime);
		 
			}

		function showBillToId()
		{ 
			
			 $('.myTable1 tbody tr').each(function(row, tr) {
     		    var className = $(this).attr('class');
				    var billToSiteUseId = $(this).find("td:eq(0) select").val();//primary Key 
				  
				    
				    if(billToSiteUseId==undefined)
				    	{
				    	billToSiteUseId ="";
				    	}
				     if(billToSiteUseId == 'BILL_TO')
				    	{
				   // 		alert("jadhfkjashdfkjahs");
				   	       $(this).find("td:eq(3)").html(""); 
				   
				    	}  
				    else if(billToSiteUseId == 'SHIP_TO'){
				    	
				    
				    		 
				    	}
				    
			 });
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

