var value = {
	rows : $("#rows"),
	sumbtn : $("#btnSum"),
	searchbtn : $("#btnSearch"),
	txtSelect : $('#mySelect'),
	sum:0.0
}
var financeController = {
	// set defaults value
	innit : function() {
		financeController.loadAll();
		financeController.regesterEvent();
	},
	regesterEvent:function(){
		$("#btnSearch").on("click", function(e) {
			var key=$('#mySelect').val();
			financeController.loadData(key)
			$('#val').empty();
		});
		$('#btnSum').click(function(e){
			$('#val').html('Sum is: '+value.sum);
		})
	},
	loadData : function(key) {
		$.ajax({
			url : "/PlayerManagement/finance/getFinances",
			type : "GET",
			data : {
				key : key
			},
			dataType : "json",
			success : function(response) {
				value.sum=0.0;
				var data = response;
				var html = "";
				$('#rows').empty();
				$.each(data, function(i, item) {
					html = '<tr>' + 
					           '<td>' + item.id_finance + '</td>' + 
					           '<td>' + item.typefinance + '</td>' +
 					           '<td>' + item.id_person + '</td>' + 
					           '<td>' + item.description + '</td>' +
					           '<td>' + item.money + '</td>' + 
					        '</tr>';
					$('#rows').append(html);
					value.sum=value.sum+item.money;
				})
			}
		})
	},
	loadAll : function() {
		$.ajax({
			url : "/PlayerManagement/finance/getAll",
			type : "GET",
			dataType : "json",
			success : function(response) {
				value.sum=0.0;
				var data = response;
				var html = "";
				$('#rows').empty();
				$.each(data, function(i, item) {
					html = '<tr>' + 
			                    '<td>' + item.id_finance + '</td>' + 
			                    '<td>' + item.typefinance + '</td>' +
			                    '<td>' + item.id_person + '</td>' + 
			                    '<td>' + item.description + '</td>' +
			                    '<td>' + item.money + '</td>' + 
			               '</tr>';
			       $('#rows').append(html);
			       value.sum+=item.money;
				})
			}
		})
	}
}
$(document).ready(function(e){
	financeController.innit();
});

