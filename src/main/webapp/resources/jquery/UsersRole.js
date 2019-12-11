function reloadPage() {
	location.reload(true);
}

$(document).ready(function(){
	$("form").keypress(function(e) {
		  //Enter key
		
		  if (e.which == 13) {
		    return false;
		  }
		});
	
	

	$('.dynamicDiv').on('change', '.hidCheckBox', function() {
		
		
		 var checkBoxId=$(this).attr('id');		 
		 if($("input[id='"+checkBoxId+"']").is(':checked')){
			 $('form input[size="'+checkBoxId+'"]').prop("disabled", true);
			 $("input[id='"+checkBoxId+"']").attr('checked', true);
		 }else{
			 $('form input[size="'+checkBoxId+'"]').prop("disabled", false);
			 $("input[id='"+checkBoxId+"']").attr('checked', false);
		 }
	 });
	 
	
	 
	 $('.btn-success').hover(function(){
	     var role=$('.role').val();
		 if(role!=''){
			 $.post('userRoleValidate.do',{role:role},function(res){
					if(res==1){
						$('#duplicateIdSpan').html("User role already exist !");
						$('#duplicateConfirmModal').modal();
						$('.role').val("");
					}
				}); 
		 }
	 })
});
