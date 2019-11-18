

/* split logic function invoice line Distribution */

var clientId="";

$(document)
		.ready(
				function() {
			
					
					clientId=	$('.clientId').val();
					
			 	 /*sorting in decending order of table */
					$('#zero_config1').dataTable( {
					order: [],
					columnDefs: [ { orderable: false, targets: [0] } ]
					});   // end of sorting in decending order of table 
					      
					
				});			
		
$(document)
.ready(
		function() {
			
			
			
		/* Delete Action  of invoice line details */
$(".myTable1").on('click', '.btnDelete', function() {
	// get the current row
	var conf = confirm("do you really want to delete ? ");
	if (conf == true) {
		var currentRow = $(this).closest("tr");
		var className =  $(currentRow).attr('class');
		var clientSiteId = currentRow.find("td:eq(0)").text();
		var clientId = currentRow.find("td:eq(1)").text();
		var action = 'delete';
		$.post("contactSiteDelete.do", {
			action : action,
			clientSiteId : clientSiteId,
			clientId : clientId
		}, function(res) {
			if (res == 1) {
				currentRow.remove();
			
				var x=0;
				$('.myTable1 tbody tr').each(function() { 
						x++;
						$(this).find("td:eq(0)").text(x);
						$(this).attr('class', 'dynamicRow'+x);
				});
				
			
			}
			
		});
	} else {
		return;
	}
		
			
});			

/**/
		
/*this is function is add  a field Order VendorSite */		
			$('.btnAdd1').click(function(){
				
				/*check client Id when new customer added bcoz clientid is mandatory*/
				
				  if(clientId==""){
				   $('#duplicateIdSpan').html("ClientID not found ! Please add customer details first");
					$('#duplicateConfirmModal').modal();
					 x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here
			   }
			    
				var line="<tr>"
					
				+"<td  style='display: none'></td>"
				+"<td style='display: none'>"+clientId+"</td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td></td>"
				+"<td></td>"
				+"<td  contenteditable='true'></td>"
				+"<td><button type='button'class='btn btn-danger btn-sm btnDelete'>Delete</button>"
                +"</td></tr>";  
 				
				
 				$('.myTable1').append(line);
		});
			
	
			
			
		 
			
	/* update and add operation of contacts Details*/
	$(".btn-update").click(function() {
		
			  /* getting value from contacts Header*/
			  var clientId=  $('.clientId').val();
		      var clientCompanyName=  $('.clientCompanyName').val();
		      var addressLine1=  $('.addressLine1').val();
		      var addressLine2=  $('.addressLine2').val();
		      var addressLine3=  $('.addressLine3').val();
		      var addressLine4=  $('.addressLine4').val();
		      var contactCompany=  $('.contactCompany').val();
		      var city=$('.city').val();
		      var state=  $('.state').val();
		      var zipCode=  $('.zipCode').val();// common fields
		      var country=  $('.country').val();// common fields
		      var contactPerson=  $('.contactPerson').val();// common fields
		      var contactNumber=  $('.contactNumber').val();// common fields
		      var emailID=  $('.emailID').val();// common fields
		     // var updatedDate= convert($('.updatedDate').val());// common fields
		    
		      var status=  $('.activeStatus').val();// common fields
		     
		      var action='update'
		      var arrayContactSites = [];
		      
		    	/*validation for customerDetails*/
		     
		        
			        	 $('.myTable1 tbody tr').each(function(row, tr) {
			        		    var className = $(this).attr('class');
			        		    var clientSiteId=$(this).find("td:eq(0)").html();
						    	
						        var clientId=$(this).find("td:eq(1)").html();//primary Key
						        
							    var siteName = $(this).find("td:eq(2)").html();//primary Key
							    var addressLine1 = $(this).find("td:eq(3)").html();//primary Key 
							    
							    var addressLine2 = $(this).find("td:eq(4)").html();
							    var addressLine3 = $(this).find("td:eq(5)").html();
							    var addressLine4 = $(this).find("td:eq(6)").html();
							    
							    var city = $(this).find("td:eq(7)").html();
                                var state = $(this).find("td:eq(8)").html();
							    var zipCode = $(this).find("td:eq(9)").html();
							    var country = $(this).find("td:eq(10)").html();
							    
							    var contactPerson = $(this).find("td:eq(11)").html();//imary Key 
							   
							    var contactNumber = $(this).find("td:eq(13)").html();
							    var emailID = $(this).find("td:eq(13)").html();
							    var createdDate = $(this).find("td:eq(14)").html();
							    var updatedDate = $(this).find("td:eq(15)").html();
							    var status = $(this).find("td:eq(16)").html();
							    
							
							    
							   arrayContactSites.push({clientSiteId:clientSiteId,clientId:clientId,siteName:siteName, addressLine1:addressLine1, addressLine2:addressLine2, addressLine3:addressLine3, addressLine4:addressLine4, city:city, state:state, zipCode:zipCode,createdDate:createdDate, updatedDate:updatedDate,country:country,contactPerson:contactPerson,contactNumber:contactNumber,emailID:emailID,status:status});
						       
			        	 });
			        	 
			        	 /*Validation for one */
			        	 var rowCount = $('.myTable1 tr').length;
			        	 if(rowCount<2){
			        		 $('#duplicateIdSpan').html("Add atleast one site details !");
								$('#duplicateConfirmModal').modal();
						    	return; 
			        	 }
			        	
			        	
			        	/*Customer Details validation */
			        	 
			        	 if(clientCompanyName == ""){
						    	$('#duplicateIdSpan').html("Fields cannot be empty ! check if client Company Name is not empty");
								$('#duplicateConfirmModal').modal();
						    	return;}
			        	 
			        	 if(city == ""){
						    	$('#duplicateIdSpan').html("Fields cannot be empty ! check if city is not empty");
								$('#duplicateConfirmModal').modal();
						    	return;}
			        	 
			        	 if(emailID == ""){
						    	$('#duplicateIdSpan').html("Fields cannot be empty ! check if email ID is not empty");
								$('#duplicateConfirmModal').modal();
						    	return;}
			        	 
			        	
					    	 //Checking a email address is valid or not
						       var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i
				        	 if (!pattern.test(emailID)) {
				        		
									$('#duplicateIdSpan').html(emailID + ' ' + ' = is not a valid mail address');
									$('#duplicateConfirmModal').modal();
									return;
								} 
						
					       
			        	// Calling Loader
	    				 showPage();
	    				 disableScreen();
	    				 
	    				
	     	            $.post("manageContactAction", {
					    action : action,
					    clientId : clientId,
					    clientCompanyName : clientCompanyName,
					    addressLine1 : addressLine1,
					    addressLine2 : addressLine2,
					    addressLine3:addressLine3,
					    addressLine4 : addressLine4,
					    contactCompany : contactCompany,
					    city : city,
						state : state,
						zipCode : zipCode,
						country:country,
						contactPerson:contactPerson,
						contactNumber:contactNumber,
						emailID:emailID,
					   // updatedDate:updatedDate,
						status:status,
						arrayContactSites:JSON.stringify(arrayContactSites)
						
	     	           	},function(res){
	     					
	     					if(res==1){
	     						$('#duplicateIdSpanUpdate').html("Data is updated !");
	     						$('#updateConfirmModaljquery').modal();
	     						disableLoader();
	     						enableScreen();
                               }
	     				 
	     				});
			        	
			        	 
	 	});// end of update function
	
});

	



function convert(str) {
	  var date = new Date(str),
	    mnth = ("0" + (date.getMonth() + 1)).slice(-2),
	    day = ("0" + date.getDate()).slice(-2);
	  return [date.getFullYear(), mnth, day].join("-");
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

