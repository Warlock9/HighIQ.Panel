$(document)
  .ready(
    function() {
      // === Prepare the chart data ===/
      var sin = [],
        cos = [];
      for (var i = 0; i < 14; i += 0.5) {
        sin.push([i, Math.sin(i)]);
        cos.push([i, Math.cos(i)]);
      }
      // === Prepare the chart data ===/
      var sin = [],
        cos = [];
      for (var i = 0; i < 14; i += 0.5) {
        sin.push([i, Math.sin(i)]);
        cos.push([i, Math.cos(i)]);
      }

      // === Make chart === //
      var plot = $.plot($(".chart"), [{
          data: sin,
          label: "sin(x)",
          color: "#ee7951"
        },
        {
          data: cos,
          label: "cos(x)",
          color: "#4fb9f0"
        }
      ], {
        series: {
          lines: {
            show: true
          },
          points: {
            show: true
          }
        },
        grid: {
          hoverable: true,
          clickable: true
        },
        yaxis: {
          min: -1.6,
          max: 1.6
        }
      });

      // === Point hover in chart === //
      var previousPoint = null;
      $(".chart")
        .bind(
          "plothover",
          function(event, pos, item) {
            if (item) {
              if (previousPoint != item.dataIndex) {
                previousPoint = item.dataIndex;

                $('#tooltip').fadeOut(200,
                  function() {
                    $(this).remove();
                  });
                var x = item.datapoint[0]
                  .toFixed(2),
                  y = item.datapoint[1]
                  .toFixed(2);

                maruti.flot_tooltip(item.pageX,
                  item.pageY,
                  item.series.label +
                  " of " + x +
                  " = " + y);
              }

            }
            else {
              $('#tooltip').fadeOut(200,
                function() {
                  $(this).remove();
                });
              previousPoint = null;
            }
          });
     /* getting default valid,invalid,rejected etc. counts*/
      $.post('getDefaultCount.val', {},function(res) {
            var obj = $.parseJSON(res);
            var data = [];
            data[0] = {label: "Processed",data: obj[0].processedCount}
            data[1] = {label: "Ready",data: obj[0].readyCount}
            data[2] = {label: "Awaiting Approval",data: obj[0].validCount}
            data[3] = {label: "Awaiting Data Correction",data: obj[0].invalidCount}
            data[4] = {label: "Rejected",data: obj[0].rejectedCount }
            $('.dateStatusFrom').val(obj[0].fromDate);
            $('.dateStatusTo').val(obj[0].toDate);
            
            var pie = $.plot(
                $(".statusPie"),
                data, {
                  series: {
                    pie: {
                      show: true,
                      radius: 3 / 4,
                      label: {
                        show: true,  
                        radius: 3 / 4,
                        formatter: function(
                          label,
                          series) {
                        	var result=JSON.stringify(series.data);
                        	var myString = result.substr(result.indexOf(",") + 1);
                        	var count=myString.replace(/[\])}[{(]/g, '');
                        	return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+label+'<br/>'+Math.round(series.percent)+'%('+count+')</div>';
                        },
                        background: {
                          opacity: 0.5,
                          color: '#000'
                        }
                      },
                      innerRadius: 0.2
                    },
                    legend: {
                      show: false
                    }
                  }
                });
          });
      
      /* getting date wise valid,invalid,rejected etc. counts*/
      $('.dateStatusFrom,.dateStatusTo').change(function() {
        var fromDate = $('.dateStatusFrom').val();
        var toDate = $('.dateStatusTo').val();
        if (fromDate != "" && toDate != "") {
			$.post('getDateWiseCount.val', {fromDate: fromDate,toDate: toDate},function(res) {
				var obj = $.parseJSON(res);
            	var data = [];
                data[0] = {label: "Processed",data: obj[0].processedCount}
                data[1] = {label: "Ready",data: obj[0].readyCount}
                data[2] = {label: "Awaiting Approval",data: obj[0].validCount}
                data[3] = {label: "Awaiting Data Correction",data: obj[0].invalidCount}
                data[4] = {label: "Rejected",data: obj[0].rejectedCount }

	            var pie = $
              .plot(
                $(".statusPie"),
                data, {
                  series: {
                    pie: {
                      show: true,
                      radius: 3 / 4,
                      label: {
                        show: true,
                        radius: 3 / 4,
                        formatter: function(
                          label,
                          series) {
                        	var result=JSON.stringify(series.data);
		                    var myString = result.substr(result.indexOf(",") + 1);
		                    var count=myString.replace(/[\])}[{(]/g, '');
		                    return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+label+'<br/>'+ Math.round(series.percent)+'%('+count+')</div>';
                        },
                        background: {
                          opacity: 0.5,
                          color: '#000'
                        }
                      },
                      innerRadius: 0.2
                    },
                    legend: {
                      show: false
                    }
                  }
                });
			});
        }
      });


      /* getting default Po and Non Po counts*/
  	$.post("PoNonPoPie.do",{},function(res) {
  		  var obj = $.parseJSON(res);
  		var data1 = [];
  		    data1[0] = { label: "PO", data: obj[0].poCount }
  			data1[1] = { label: "Non PO", data: obj[0].nonPoCount }
            $('.datepickerFromPoPie').val(obj[0].fromDate);
            $('.datepickerToPoPie').val(obj[0].toDate);
           
  			    var pie = $.plot($(".PoNonPoPie"), data1,{
  			        series: {
  			            pie: {
  			                show: true,
  			                radius: 3/4,
  			                label: {
  			                    show: true,
  			                    radius: 3/4,
  			                    formatter: function(label, series){
  			                    	var result=JSON.stringify(series.data);
  				                    var myString = result.substr(result.indexOf(",") + 1);
  				                    var count=myString.replace(/[\])}[{(]/g, '');
  				                    return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+label+'<br/>'+ Math.round(series.percent)+'%('+count+')</div>';
  			                    },
  			                    background: {
  			                        opacity: 0.5,
  			                        color: '#000'
  			                    }
  			                },
  			                innerRadius: 0.2
  			            },
  						legend: {
  							show: false
  						}
  					}
  				});
  	 });
  	
  	
  	 /* getting date Wise Po and Non Po counts*/
  	$(".datepickerToPoPie,.datepickerFromPoPie").change(function() {
  		var data1 = [];
  		var dateFrom =$(".datepickerFromPoPie").val();
  		var dateTo=$(".datepickerToPoPie").val(); 

  		if(dateFrom!="" && dateTo!=""){
  			$.post("PoNonPoPieByDate.do",{dateFrom:dateFrom,dateTo:dateTo},function(res) {
  				var obj = $.parseJSON(res);
  				  data1[0] = { label: "PO", data: obj[0].poCount }
  					data1[1] = { label: "Non PO", data: obj[0].nonPoCount }
  					    var pie = $.plot($(".PoNonPoPie"), data1,{
  					        series: {
  					            pie: {
  					                show: true,
  					                radius: 3/4,
  					                label: {
  					                    show: true,
  					                    radius: 3/4,
  					                    formatter: function(label, series){
  					                    	var result=JSON.stringify(series.data);
  						                    var myString = result.substr(result.indexOf(",") + 1);
  						                    var count=myString.replace(/[\])}[{(]/g, '');
  						                    return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+label+'<br/>'+ Math.round(series.percent)+'%('+count+')</div>';
  					                    },
  					                    background: {
  					                        opacity: 0.5,
  					                        color: '#000'
  					                    }
  					                },
  					                innerRadius: 0.2
  					            },
  								legend: {
  									show: false
  								}
  							}
  						});
  			 });
  		}
  	})
      

      var d1 = [];
      for (var i = 0; i <= 10; i += 1)
        d1.push([i, parseInt(Math.random() * 30)]);

      var data = new Array();
      data.push({
        data: d1,
        bars: {
          show: true,
          barWidth: 0.4,
          order: 1,
        }
      });

      //Display graph
      var bar = $.plot($(".bars"), data, {
        legend: true,
        color: "#2b2b2b"
      });

    });

maruti = {
  // === Tooltip for flot charts === //
  flot_tooltip: function(x, y, contents) {

    $('<div id="tooltip">' + contents + '</div>').css({
      top: y + 5,
      left: x + 5
    }).appendTo("body").fadeIn(200);
  }
}



/*getting default top 5 vendors */
$(document)
.ready(
  function() {
	  $.post("defaultTopFiveVendor.do",{},function(res){
		  var obj = $.parseJSON(res);
          $('.dateVendorFrom').val(obj[0].fromDate);
          $('.dateVendorTo').val(obj[0].toDate);
  		  var ctx = document.getElementById("myChart").getContext('2d');
		  var myChart = new Chart(ctx, {
			  type: 'bar',
			  data: {
				  labels: [obj[0].VendorName0,obj[0].VendorName1, obj[0].VendorName2,obj[0].VendorName3, obj[0].VendorName4],
				  datasets: [{
			            label: "Received",
			            backgroundColor: "rgba(210, 214, 222, 1)",
			            data: [obj[0].ReceivedCount0, obj[0].ReceivedCount1, obj[0].ReceivedCount2, obj[0].ReceivedCount3, obj[0].ReceivedCount4]
			        },
			        {
			            label: "Processed",
			            backgroundColor: "#28b779",
			            data: [obj[0].ProcessedCount0,obj[0].ProcessedCount1, obj[0].ProcessedCount2, obj[0].ProcessedCount3, obj[0].ProcessedCount4]
			        }]
			  },
			  options: {
				  scales: {
					  yAxes: [{
						  ticks: {
							  beginAtZero:true
						  }
					  }]
				  }
			  },plugins: [{
			   beforeInit: function(chart) {
				  chart.data.labels.forEach(function(e, i, a) {
					 if (/\n/.test(e)) {
						a[i] = e.split(/\n/);
					 }
				  });
			   }
		}]
	  });
	  });
	  
	  /*getting top 5 vendors date wise*/
	  $('.myCharts').on('change', '.dateVendorFrom,.dateVendorTo', function() {
		  checkboxes.style.display = "none";
	  var fromDate = $('.dateVendorFrom').val();
      var toDate = $('.dateVendorTo').val();
      if (fromDate != "" && toDate != "") {
    	  $.post("dateWiseTopFiveVendor.do",{fromDate: fromDate,toDate: toDate},function(res){
    		  $('#myChart').remove();
    		  $('.myCharts').append("<canvas id='myChart'> </canvas>");
    		  var obj = $.parseJSON(res);
    	  	  var ctx = document.getElementById("myChart").getContext('2d');
    			  var myChart = new Chart(ctx, {
    				  type: 'bar',
    				  data: {
    					  labels: [obj[0].VendorName0,obj[0].VendorName1, obj[0].VendorName2,obj[0].VendorName3, obj[0].VendorName4],
    					  datasets: [{
    				            label: "Received",
    				            backgroundColor: "rgba(210, 214, 222, 1)",
    				            data: [obj[0].ReceivedCount0, obj[0].ReceivedCount1, obj[0].ReceivedCount2, obj[0].ReceivedCount3, obj[0].ReceivedCount4]
    				        },
    				        {
    				            label: "Processed",
    				            backgroundColor: "#28b779",
    				            data: [obj[0].ProcessedCount0,obj[0].ProcessedCount1, obj[0].ProcessedCount2, obj[0].ProcessedCount3, obj[0].ProcessedCount4]
    				        }]
    				  },
    				  options: {
    					  scales: {
    						  yAxes: [{
    							  ticks: {
    								  beginAtZero:true
    							  }
    						  }]
    					  }
    				  },plugins: [{
    			   beforeInit: function(chart) {
    				  chart.data.labels.forEach(function(e, i, a) {
    					 if (/\n/.test(e)) {
    						a[i] = e.split(/\n/);
    					 }
    				  });
    			   }
    			}]
    		  });
    	  });
      }
     });
	  
	  
	  /*getting default top 5 Errors*/
	  $.post("defaultTopFiveErros.do",{},function(res){
		  var obj = $.parseJSON(res);
          $('.dateErrorFrom').val(obj[0].fromDate);
          $('.dateErrorTo').val(obj[0].toDate);
  		  var ctx = document.getElementById("myChartError").getContext('2d');
		  var myChart = new Chart(ctx, {
			  type: 'bar',
			  data: {
				  labels: [obj[0].ErrorName0,obj[0].ErrorName1, obj[0].ErrorName2,obj[0].ErrorName3, obj[0].ErrorName4],
				  datasets: [{
			            label: "Errors",
			            backgroundColor: "rgb(27,85,192)",
			            data: [obj[0].ErrorCount0, obj[0].ErrorCount1, obj[0].ErrorCount2, obj[0].ErrorCount3, obj[0].ErrorCount4],
			        }]
			  },
			  options: {
				  scales: {
					  yAxes: [{
						  ticks: {
							  beginAtZero:true
						  }
					  }]
				  }
			  },plugins: [{
			   beforeInit: function(chart) {
				  chart.data.labels.forEach(function(e, i, a) {
					 if (/\n/.test(e)) {
						a[i] = e.split(/\n/);
					 }
				  });
			   }
			}]
	  });
	});
	  	  
	  $('.myErrorCharts').on('change click','.dateErrorFrom,.dateErrorTo,.btn-submit', function(e) {
		     clearAll();
	     });
	  
	  
});

function clearAll(){
	 var fromDate = $('.dateErrorFrom').val();
     var toDate = $('.dateErrorTo').val();
     var divControl = document.getElementById('checkboxes');
     var vendorNames="";
     var checkboxes = document.getElementById("checkboxes");
     checkboxes.style.display = "none";
    
		$('input:checkbox:checked', divControl).each(function(){
			vendorNames = vendorNames+"'"+$(this).val()+"',";
			
		});
		//to remove last comma from string
		vendorNames = vendorNames.substring(0,vendorNames.length - 1);
     if (fromDate != "" && toDate != "") {
   	  $.post("dateAndVendorWiseTopFiveErros.do",{vendorNames : vendorNames,fromDate: fromDate,toDate: toDate},function(res){
   		  $('#myChartError').remove();
   		  $('.myErrorCharts').append("<canvas id='myChartError'> </canvas>");
   		  var obj = $.parseJSON(res);
    	  	  var ctx = document.getElementById("myChartError").getContext('2d');
   			  var myChart = new Chart(ctx, {
   				  type: 'bar',
   				  data: {
   					  labels: [obj[0].ErrorName0,obj[0].ErrorName1, obj[0].ErrorName2,obj[0].ErrorName3, obj[0].ErrorName4],
   					  datasets: [{
   				            label: "Errors",
   				            backgroundColor: "rgb(27,85,192)",
   				            data: [obj[0].ErrorCount0, obj[0].ErrorCount1, obj[0].ErrorCount2, obj[0].ErrorCount3, obj[0].ErrorCount4],
   				        }]
   				  },
   				  options: {
   					  scales: {
   						  yAxes: [{
   							  ticks: {
   								  beginAtZero:true
   							  }
   						  }]
   					  }
   				  },plugins: [{
   			   beforeInit: function(chart) {
   				  chart.data.labels.forEach(function(e, i, a) {
   					 if (/\n/.test(e)) {
   						a[i] = e.split(/\n/);
   					 }
   				  });
   			   }
   			}]
   		  });
   	  });
     }
}