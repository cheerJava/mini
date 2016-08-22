
(function($) {
	$.fn.serialize2Json = function() {
		var json = {};
		$(this.serializeArray()).each(function() {
			json[this.name] = this.value;
		});
		return json;
	};
})(jQuery);