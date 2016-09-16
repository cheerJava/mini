if (window.console) {
	console.log("Extends loading...");
}

$.extend({
	checkBoxEvent : function(tiger, monkeies) {
		console.log("call checkBoxEvent");
		console.log("Input Param >>>>> [tiger] :" + tiger);
		console.log("Input Param >>>>> [monkeies] :" + monkeies);
		
		tiger.click(function() {
			var check = $(this).prop("checked");
			if (check) {
				monkeies.each(function() {
					$(this).prop("checked", "checked");
				});
			} else {
				monkeies.each(function() {
					$(this).removeProp("checked");
				});
			}
		});
		monkeies.each(function() {
			$(this).click(function() {
				var length = monkeies.length;
				var _length = 0;
				monkeies.each(function() {
					var _check = $(this).prop("checked");
					if (_check) {
						_length++;
					}
				});
				if (length == _length) {
					tiger.prop("checked", "checked");
					tiger.prop("indeterminate", false);
				} else {
					if (_length > 0) {
						tiger.prop("indeterminate", true);
					} else {
						tiger.prop("indeterminate", false);
					}
					tiger.removeAttr("checked");
				}
			});
		});
	},
	
	submitForm : function(form){
		form.submit();
		$.disableForm(form);
	},
	disableForm : function(form){
		console.log("call disableForm");
		console.log("Input Param >>>>> [form] :" + form);		
		$('input[type!=hidden]',form).each(function (){
			$(this).attr("disabled","disabled");
		});
		$('textarea',form).each(function (){
			$(this).attr("disabled","disabled");
		});
		$('a',form).each(function (){
			$(this).attr("herf","#");
			$(this).attr("onclick",function(){return false;});
		});
	},
	msg:function(message,level,targetElement){
		var _level = null;
		if(level == null){
			_level = "warning"
		}else{
			_level = level;
		}
		var closeButton = "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">"+
			"<span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>";
		var msgDiv = "<div class=\"alert alert-"+_level+" alert-dismissible\" role=\"alert\"></div>";
		var content = "<strong>"+app_alert_level[_level]+"</strong>" +message;
		var _msgDiv = $(msgDiv);
		var _closeButton = $(closeButton);
		_msgDiv.prepend(_closeButton);
		_msgDiv.prepend(content);
		if(targetElement == null){
			$("#alertMsgDiv").prepend(_msgDiv);
		}else{
			$(targetElement).prepend(_msgDiv);
		}
	}
});