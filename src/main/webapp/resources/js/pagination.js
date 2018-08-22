(function($) {
	$.fn.paging = function(options) {
		
		// default value of options
		var defaults = {
			"rows" : "#rows",
			"pages" : "page",
			"pageSize" : 10,
			"currentPage" : 1,
			"totalPage" : 0,
			"btnPrevious" : "#goPrevios",
			"btnNext" : "#goNext",
			"txtCurrentPage" : "#currentPage"
		};
		var setting = jQuery.extend(defaults, options);
		// declare variable using in Plugin
		var rows=$(setting.rows);
		var pages = $(setting.pages);
		var btnPrevious = $(setting.btnPrevious);
		var btnNext = $(setting.btnNext);
		var txtCurrentPage = $(setting.txtCurrentPage)
		// Init needed function when using Plugin
		init();
		// init function
		function init() {
			// get total page
			console.log(222);
			$.ajax({
				url : '/PlayerManagement/person/getTotalPages',
				type : "GET",
				dataType : "json",
				data : {
					pageSize : setting.pageSize
				},
				success : function(response) {
					setting.totalPage = response;
					setting.currentPage = 1;
					// load page 1
					loadData(1);
					$('.pageInfo').html("Page 1 of "+setting.totalPage);
				}
			});
			
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
						loadData(currentPageValue);
						setting.currentPage = currentPageValue;
						$('.pageInfo').html("Page "+ currentPageValue+ " of "+setting.totalPage);
					}
				}
			})

		}
		// load previous page
		function goPrevious() {
			var currentPage = setting.currentPage - 1;
			if (currentPage > 0 && currentPage <= setting.totalPage) {
				loadData(currentPage);
				setting.currentPage = setting.currentPage - 1;
				$('.pageInfo').html("Page "+ setting.currentPage+ " of "+setting.totalPage);
			}

		}
		// load next page
		function goNext() {
			var currentPage = setting.currentPage + 1;
			if (currentPage > 0 && currentPage <= setting.totalPage) {
				loadData(currentPage);
				setting.currentPage = setting.currentPage + 1;
				$('.pageInfo').html("Page "+ setting.currentPage+ " of "+setting.totalPage);
			}
		}
		// load data for page
		function loadData(page) {
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
						           +'<td><a href="/PlayerManagement/person/view-detail/'+item.id+'">View Detail</a></td>'
						           +'<td><a href="/PlayerManagement/person/delete/'+item.id+'">Delete</a></td>'+
						      '</tr>';
						     rows.append(html);
					});
				}
			})
		}
	}
})(jQuery);
$(document).ready(function(e) {
	var obj = {
			"rows" : "#rows",
			"pages" : "page",
			"pageSize" : 2,
			"currentPage" : 1,
			"totalPage" : 0,
			"btnPrevious" : "#goPrevios",
			"btnNext" : "#goNext",
			"txtCurrentPage" : "#currentPage"
	};
	$("#paging-pages").paging(obj);
});