if (window.console) {
	console.log("Extends loading...");
}

/*******************************************************************************
 * function checkBoxSelectAll(allElement, elemens){ }
 */

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
	
	disableForm : function(form){
		console.log("call disableForm");
		console.log("Input Param >>>>> [form] :" + form);
		
		
	},
	submitForm : function(form){
		form.submit();
		$.disableForm(form);
	}
	
	
	
});
