(function($) {
	$.fn.search = function(options) {
		var defaults = {
			"txtText" : "#txtText",
			"btnSearch" : "#btnSearch",
			"rows" : "#rows",
			"pages" : "page",
			"pageSize" : 10,
			"currentPage" : 1,
			"totalPage" : 0,
			"btnPrevious" : "#goPrevios",
			"btnNext" : "#goNext",
			"txtCurrentPage" : "#currentPage"
		}
		var setting = $.extend(defaults, options);
		var txtText = $(setting.txtText);
		var btnSearch = $(setting.btnSearch);
		var rows=$(setting.rows);
		var pages = $(setting.pages);
		var btnPrevious = $(setting.btnPrevious);
		var btnNext = $(setting.btnNext);
		var txtCurrentPage = $(setting.txtCurrentPage)
		init();
		function init(){
			rows.empty();
			// get total page
			$.ajax({
				url : '/PlayerManagement/person/getTotalPages',
				type : "GET",
				dataType : "json",
				data : {
					pageSize:setting.pageSize
				},
				success : function(response) {
					setting.totalPage = response;
					setting.currentPage = 1;
					// load page 1
					loadData1(1);
					$('.pageInfo').html("Page 1 of "+setting.totalPage);
				}
			});
			//when user click search
			btnSearch.on("click",function(){
				loadData(txtText.val(),1);
				setting.currentPage=1;
				$('.pageInfo').html("Page 1 of "+setting.totalPage);
			})
			// set event for btnPrevious,btnNext and txtCurrentPage
			btnPrevious.click(function(e) {
				goPrevious();
			});
			btnNext.click(function(e) {
				goNext();
			});
			txtCurrentPage.keyup(function(e) {
				// if get key code of Enter
				if (e.keyCode == 13) {
					// get value of text box
					var currentPageValue = parseInt($(this).val());
					if (isNaN(currentPageValue) || currentPageValue < 1
							|| currentPageValue > setting.totalPage) {
						alert("Please enter a valid number");
					} else {
						loadData(txtText.val(),currentPageValue);
						setting.currentPage = currentPageValue;
						$('.pageInfo').html("Page "+ setting.currentPage+ " of "+setting.totalPage);
					}
				}
			})
			
		}
		function loadData(txtText,page) {
			$.ajax({
				url:"/PlayerManagement/person/search",
				data:{
					key:txtText,
					page:page,
					pageSize:setting.pageSize
				},
				dataType:"json",
				success:function(response){
					var data=response.data;
					setting.totalPage=response.totalPage;
					console.log(setting.totalPage);
					$('.pageInfo').html("Page "+ setting.currentPage+ " of "+setting.totalPage);
					var html="";
					var totalRow;
					rows.empty();
					$.each(data,function(i,item){
						html='<tr>'+'<td>'+item.id+'</td>'
				                   +'<td>'+item.name+'</td>'
				                   +'<td>'+item.age+'</td>'
				                   +'<td>'+item.sex+'</td>'
				                   +'<td>'+item.typecode+'</td>'
				                   +'<td><a href="/PlayerManagement/person/view-detail/'+item.id+'">View Detail</a></td>'+
				      '</tr>';
				     rows.append(html);
					})
				}
			})
		}
		function loadData1(page) {
			$.ajax({
				url : "/PlayerManagement/person/getData",
				type : "GET",
				data : {
					page : page,
					pageSize : setting.pageSize
				},
				dataType : "json",
				success : function(response) {
					var data = response;
					rows.empty();
					var html = "";
					$.each(data, function(i, item) {
						html='<tr>'+'<td>'+item.id+'</td>'
						           +'<td>'+item.name+'</td>'
						           +'<td>'+item.age+'</td>'
						           +'<td>'+item.sex+'</td>'
						           +'<td>'+item.typecode+'</td>'
						           +'<td><a href="/PlayerManagement/person/view-detail/'+item.id+'">View Detail</a></td>'+
						      '</tr>';
						     rows.append(html);
					});
				}
			})
		}
		// load previous page
		function goPrevious() {
			var currentPage = setting.currentPage - 1;
			if (currentPage > 0 && currentPage <= setting.totalPage) {
				loadData(txtText.val(),currentPage);
				setting.currentPage = setting.currentPage - 1;
				$('.pageInfo').html("Page "+ setting.currentPage+ " of "+setting.totalPage);
			}

		}
		// load next page
		function goNext() {
			var currentPage = setting.currentPage + 1;
			if (currentPage > 0 && currentPage <= setting.totalPage) {
				loadData(txtText.val(),currentPage);
				setting.currentPage = setting.currentPage + 1;
				$('.pageInfo').html("Page "+ setting.currentPage+ " of "+setting.totalPage);
			}
		}
	}

})(jQuery);
$(document).ready(function(e) {
	var obt ={
			"txtText" : "#txtText",
			"btnSearch" : "#btnSearch",
			"rows" : "#rows",
			"pages" : "page",
			"pageSize" : 2,
			"currentPage" : 1,
			"totalPage" : 0,
			"btnPrevious" : "#goPrevios",
			"btnNext" : "#goNext",
			"txtCurrentPage" : "#currentPage"
	};
	$("#pages").search(obt);
});