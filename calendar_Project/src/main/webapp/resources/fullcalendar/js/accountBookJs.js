$(function() {
	$.ajax({
		type : 'post',
		url : '/calApp/accountbook/makeCalendar',
		data : {
			'year' : $('#year').val(),
			'month' : $('#month').val()
		},
		success : function(data) {
			//alert(JSON.stringify(data));
			
			$.each(data, function(index, items) {
				console.log(index+", "+items);
				let indexArr = '.date'+index;
				$('.date'+index).html(items);
			});
			
		},
		error : function(err) {
			console.log(err);
		}
	});
});