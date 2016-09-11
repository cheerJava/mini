if (window.console) {
	console.log("extends loading...");
}
/*
 * function checkBoxselectALL(allElement,elements){ }
 */

$.extend({
	checkBoxEvent : function(tiger, monkeies) {
		console.log("call checkBoxEvent...");
		console.log("input Param>>>>>>>[tiger]:" + tiger);
		console.log("input Param>>>>>>>[monkeys]:" + monkeies);
		/*
		 * tiger.click(function() { var _checked = $(this).prop("checked");
		 * monkeies.each(function() { if (_checked) { $(this).prop("checked",
		 * _checked); } else { $(this).removeProp("checked"); } }) });
		 */

		tiger.click(function() {
			var check = $(this).prop("checked");
			if (check) {
				$(monkeies).each(function() {
					$(this).prop("checked", "checked");
				});
			} else {
				$(monkeies).each(function() {
					$(this).removeProp("checked");
				});
			}
		});
		monkeies.each(function() {
			$(this).click(function() {
				var length = monkeies.length;
				var _length = 0;
				monkeies.each(function() {
					var check = $(this).prop("checked");
					if (check) {
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

	disableFrom : function(form) {

	},
	submitFrom : function(form) {
		form.sumit();
		disableFrom(form)
	}

});