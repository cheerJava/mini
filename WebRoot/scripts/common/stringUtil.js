function cutString(originStr,targetLength,pointNumber)
{
	var targetStr = originStr+"";
	if(originStr.length>targetLength)
	{
		targetStr = targetStr.substr(0,targetLength);
		var pointStr = "";
		for(var i = 0;i<pointNumber;i++)
		{
			pointStr+=".";
		}
		targetStr+=pointStr;
	}
	return targetStr;
}