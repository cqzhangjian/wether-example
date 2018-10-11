"use strict";
//# sourceURL=report.js

// DOM 加载完再执行
$(function() {
	$("#selectCountyId").change(function(){
		var countyId=$("#selectCountyId").val();  //获取Select选择的Value
		var url = '/report/countyId/' + countyId;
		window.location.href= url;
	});
});