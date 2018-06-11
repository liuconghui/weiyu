var array = {"name":false,"phone":false};

//手机号验证
$(function(){
	$("#phone").blur(function(){
		array.phone = false;
		var phone = $("#phone").val();

		//非空检测
		if(phone == ""){
			$("#p_phone").html("手机号不能为空").css("color","red");;
			return;
		}

		//格式检测
		var regexp = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
		if(!regexp.test(phone)){
			$("#p_phone").html("手机格式不正确").css("color","red");;
			return;
		}
		array.phone=true;
	});
});
//姓名验证
$(function(){
	$("#name").blur(function(){
		array.name = false;
		var name = $("#name").val();

		//非空检测
		if(name == ""){
			$("#p_name").html("姓名不能为空").css("color","red");;
			return;
		}

		//格式检测
		var regexp = /^[\u4e00-\u9fa5]{2,6}$/;
		if(!regexp.test(name)){
			$("#p_name").html("姓名格式不正确").css("color","red");
			return;
		}else{
			$("#p_name").html("姓名格式正确").css("color","green");
			array.name = true;
		}
	});
});
$(function(){
	$.ajax({
		"url":"rolenamelist.do",
		"type":"post",
		"contentType" : 'application/json;charset=utf-8',
		"dataType":'json',
		"success":function(data){
			//alert(JSON.stringify(data));
			for(var i in data) {
				$.each(data[i], function (index, obj) {
					$("#single").append("<option>" + obj.rn + "</option>");
				});
			}
			//for(var i in data){
			//	for(var a in data[i]) {
			//		//alert(data[i][a])
			//		$("#single").append("<option>" + data[i][a].rn + "</option>");
			//	}
			//}
		},
		"error":function(){alert("系统繁忙!");}
	});
});
function putOn(){
	//检查表单项是否都通过验证
	if(array.name&&array.phone){
		document.forms[0].submit();
	}else{
		alert("请检查表单");
		return false;
	}
}


	






