$(function() {
	
	$(".calendar").datepicker({
		autoclose:true,
		language:"zh-CN",
		format:"yyyy-mm-dd"
	});

	var GLOBAL_PWD_MIN_LENGTH = 8;
	var GLOBAL_DEFINE_NUMBER = "0123456789";
	var GLOBAL_DEFINE_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	var GLOBAL_DEFINE_SPECIFY = "`~!@#$%^&*()_+-={}[]\"'|<>,.:;?/"

	$.validator.addMethod("setPwd",
			function(value) {
				console.log("Input Param [value] -> " + value);
				var length_flag = false;
				var char_flag = false;
				var specify_flag = false;
				var number_flag = false;
				if (value != null && value.length >= GLOBAL_PWD_MIN_LENGTH) {
					length_flag = true;
					for (var i = 0; i < value.length; i++) {
						var _char = value.charAt(i);
						console.log("Input Param [_char] -> " + _char);
						// var __char = _char+"";
						if (!number_flag
								&& GLOBAL_DEFINE_NUMBER.indexOf(_char) != -1) {
							number_flag = true
						}
						if (!char_flag
								&& GLOBAL_DEFINE_CHAR.indexOf(_char) != -1) {
							char_flag = true
						}
						if (!specify_flag
								&& GLOBAL_DEFINE_SPECIFY.indexOf(_char) != -1) {
							specify_flag = true
						}
						if (number_flag && char_flag && specify_flag) {
							break;
						}
					}
				}
				return length_flag && char_flag && specify_flag && number_flag;
			}, '密码太简单!');
});