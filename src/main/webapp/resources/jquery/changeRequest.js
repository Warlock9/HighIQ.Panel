$(document)
		.ready(
				function() {
					
					/*this is function is add  a field invoiceLine */		
					$('.btnAdd').click(function(){
                           alert ("hello");
						var line="<tr id='dynamic' ><td></td>"
							+"<td></td>"
							+"<td></td>"
							+"<td contenteditable='true'></td>"
							+"<td contenteditable='true'></td>"
							+"<td contenteditable='true'></td>"
							+"<td  contenteditable='true'></td>"
							+"<td  contenteditable='true'></td>"
							+"</tr>";
		 				
		 				$('.myTable').append(line);
		 				addDistributionOnAddLine(lineNumber,invoiceUniqueId,botId);
					  });
				});