

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
					$(".contactNumber").keypress(function(e) {
				 		  //Enter key
				 		  if (e.which == 13) {
				 		    return false;
				 		  }
				 		});  
					
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
		if(clientSiteId==""){
			currentRow.remove();
		}else{
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
		}
	} else {
		return;
	}
		
			
});			

/**/
	
/*this is function is add  a field Order VendorSite */		
			$('.btnAdd1').click(function(){
				
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
				+"<td style='display: none;'></td>"
				+"<td style='display: none;'></td>"
				+"<td  contenteditable='true'>"
				+"<select name='status' class='form-control custom-select activeStatus' required>"
				+"	<option value=''>Select</option>"
				+"<option value='1'>Active</option>"
				+"<option value='0'>Inactive</option>"
			     +"</select>"
				
				+"</td>"
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
		      
		      
		  	/*Customer Details validation */
	        	 
	        	 if(clientCompanyName == ""){
				    	$('#duplicateIdSpan').html("Fields cannot be empty ! client Company Name is mandatory");
						$('#duplicateConfirmModal').modal();
				    	return;}
	        	 
	        	 if(city == ""){
				    	$('#duplicateIdSpan').html("Fields cannot be empty ! city is mandatory");
						$('#duplicateConfirmModal').modal();
				    	return;}
	        	 
	        	 if(emailID == ""){
				    	$('#duplicateIdSpan').html("Fields cannot be empty ! email ID is mandatory");
						$('#duplicateConfirmModal').modal();
				    	return;}
	        	    if(status==""){
	        	    	$('#duplicateIdSpan').html("Fields cannot be empty ! status is mandatory ");
						$('#duplicateConfirmModal').modal();
				    	return;
	        	    }
			    	 //Checking a email address is valid or not
				       var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i
		        	 if (!pattern.test(emailID)) {
		        		
							$('#duplicateIdSpan').html(emailID + ' ' + ' = is not a valid mail address');
							$('#duplicateConfirmModal').modal();
							return;
						} 
				     
				       
		     
		        
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
							   
							    var contactNumber = $(this).find("td:eq(12)").html();
							    var emailID = $(this).find("td:eq(13)").html();
							    
							    var createdDate = $(this).find("td:eq(14)").html();
							    var updatedDate = $(this).find("td:eq(15)").html();
							    var status = $(this).find("td:eq(16) select").val();
							    
							
							     /*check mandatory field*/
							    if(siteName==""){
				        	    	$('#duplicateIdSpan').html("Fields cannot be empty ! site name is mandatory ");
									$('#duplicateConfirmModal').modal();
									 x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
				        	    }
							    if(city==""){
				        	    	$('#duplicateIdSpan').html("Fields cannot be empty ! city is mandatory ");
									$('#duplicateConfirmModal').modal();
									 x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
				        	    }
							     if(status==""){
					        	    	$('#duplicateIdSpan').html("Fields cannot be empty ! status is mandatory ");
										$('#duplicateConfirmModal').modal();
										 x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
					        	    }
							     
							     /*check mandatory field*/
							     if(emailID==""){
					        	    	$('#duplicateIdSpan').html("Fields cannot be empty ! email ID is mandatory ");
										$('#duplicateConfirmModal').modal();
										 x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
					        	    }

							     //Checking a email address is valid or not
								   
                                /* var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;

							     if (!pattern.test(emailID)) {
						        		
											$('#duplicateIdSpan').html(emailID + ' ' + ' = is not a valid mail address');
											$('#duplicateConfirmModal').modal();
										    x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 

										} */
							    
							     var NumberRegex = /^[0-9]*$/;
							     if(contactNumber.length <= 10){
							     if(NumberRegex.test(contactNumber)){
							     //do whatever you want to
							     }else{
							    		$('#duplicateIdSpan').html(contactNumber + ' ' + ' = is not a valid contact number');
										$('#duplicateConfirmModal').modal();
										 x += $("img:eq(" + i +")").width();// this line code is wrong to stop jquery return false is not working here 
							      }
							     }
							   arrayContactSites.push({clientSiteId:clientSiteId,clientId:clientId,siteName:siteName, addressLine1:addressLine1, addressLine2:addressLine2, addressLine3:addressLine3, addressLine4:addressLine4, city:city, state:state, zipCode:zipCode,createdDate:createdDate, updatedDate:updatedDate,country:country,contactPerson:contactPerson,contactNumber:contactNumber,emailID:emailID,status:status});
						       
			        	 });
			        	 
			        	 /*Validation for one */
			        	 var rowCount = $('.myTable1 tr').length;
			        	 if(rowCount<2){
			        		 $('#duplicateIdSpan').html("Add atleast one site details !");
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
	     						window.top.close();
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

		
		
