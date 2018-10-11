$(document).ready(function() {
	$('[data-toggle=offcanvas]').click(function() {
		$('.row-offcanvas').toggleClass('active');
	});
	$("select").select2();
});
function del(url, page) {
	var msg = "您真的确定要删除吗？\n\n请确认！";
	if (confirm(msg) == true) {
		var data = {
			page : page
		};
		$.ajax({
			type : 'post',
			url : url,
			data : data,
			success : function(json) {
				window.location.reload();
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, e) {
			}

		});
		// return true;
	} else {
		return false;
	}
}

function saveEdit(url, url2) {
	var b = document.forms["form"].reportValidity();
	if (b) {
		$.ajax({
			type : 'post',
			url : url,
			data : $('#form').serialize(),
			success : function(json) {
				window.location.href = url2 + json;
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, e) {
				alert(e)
			}

		});
	}
}

function saveEdit2(url, url2) {
	var b = document.forms["form"].reportValidity();
	if (b) {
		$.ajax({
			type : 'post',
			url : url,
			data : $('#form').serialize(),
			success : function(json) {
				window.location.href = url2;
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, e) {
				alert(e)
			}

		});
	}
}