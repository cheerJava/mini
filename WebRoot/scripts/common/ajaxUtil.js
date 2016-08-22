	
function ajaxCommit(param)
{

	$.ajax({
			type :param.type,
			contentType : "application/json;charset=utf-8",
			url : param.url,
			dataType : "json",
			data : JSON.stringify(param.data),
			success :param.successFunction,
			error :param.errorFunction
		}
	);
}