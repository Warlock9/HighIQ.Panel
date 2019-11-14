

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
		
			
			
			/*this is function is add  a field Order VendorSite */		
			$('.btnAdd').click(function(){
				
				var line="<tr>"
				+"<td  contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td style='display: none' contenteditable='true'></td>"
				+"<td contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
				+"<td  contenteditable='true'></td>"
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
		     // var updatedDate= toDate($('.updatedDate').val());// common fields
		   //   alert(updatedDate);
		      var status=  $('.activeStatus').val();// common fields
		      var action='update'
		      var arrayContactSites = [];
		      
		    	
		        
			        	 $('.myTable1 tbody tr').each(function(row, tr) {
			        		    var className = $(this).attr('class');
			        		    var clientSiteId=$(this).find("td:eq(0) select").val();
						    	
						        var clientId=$(this).find("td:eq(1)").html();//primary Key
							    var siteName = $(this).find("td:eq(2)").html();//primary Key
							    var addressLine1 = $(this).find("td:eq(3) select").val();//primary Key 
							    
							    var addressLine2 = $(this).find("td:eq(4)").html();
							    var addressLine3 = $(this).find("td:eq(5)").html();
							    var addressLine4 = $(this).find("td:eq(6)").html();
							    var addressLine3 = $(this).find("td:eq(7)").html();
							    var addressLine4 = $(this).find("td:eq(8)").html();
							    var city = $(this).find("td:eq(9)").html();
                                var state = $(this).find("td:eq(10)").html();
							    var zipCode = $(this).find("td:eq(12)").html();
							    var country = $(this).find("td:eq(11)").html();
							    
							    var contactPerson = $(this).find("td:eq(13) select").val();//primary Key 
							   
							    var contactNumber = $(this).find("td:eq(14)").html();
							    var emailID = $(this).find("td:eq(15)").html();
							    var createdDate = $(this).find("td:eq(16)").html();
							   // var updatedDate = $(this).find("td:eq(17)").html();
							    var status = $(this).find("td:eq(18)").html();
							    
							   arrayContactSites.push({clientSiteId:clientSiteId,clientId:clientId,siteName:siteName, addressLine1:addressLine1, addressLine2:addressLine2, addressLine3:addressLine3, addressLine4:addressLine4, city:city, state:state, zipCode:zipCode, country:country,contactPerson:contactPerson,contactNumber:contactNumber,emailID:emailID,status:status});
						       
			        	 });
			        	 var temp=JSON.stringify(arrayContactSites);
			        	 
			        	 
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
					//	updatedDate:updatedDate,
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
	




		function toDate(dateStr) {
			var replaced =dateStr.replace(/[-,:\s]/g, ",")
		    var s=replaced.split(",");
		   var mailDateTime = s[2] + '-' + s[1] + '-' + s[0]+" "+s[3]+":"+s[4]+":"+s[5];
		  // alert(mailDateTime);
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

