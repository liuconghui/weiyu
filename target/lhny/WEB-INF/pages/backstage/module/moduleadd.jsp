<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
<p>
	<span>模块名称:</span>
	<input type="text" placeholder="请填写模块名称" id="name" />
</p><input type="hidden" id="id" />
<p>
	<span>模块url:</span>
	<input type="text" placeholder="请填写模块url" id="url" />
</p>
<p>
	<span>父模块</span>
	<select id="fid">
		<c:forEach items="${modulename}" var="list">
			<option value="${list.id}">${list.name}</option>
		</c:forEach>
	</select>
</p>
<p>
	<span id="refer"> 提交 </span>
	<span id="back"> 返回 </span>
</p>
<script>
	$("#refer").click(function(){
	var id = $("#id").val();
	var name =  $("#name").val();
	var url =  $("#url").val();
	var fid = $("#fid").val();
	var fname = $("#fname").val();
	if(id==null||id.trim()==""){
        $.ajax({
            type: "POST",
            url: "addmodule.do",
            data: "&name=" + name + "&url=" + url + "&fid=" + fid + "&fname=" + fname,
            success: function (data) {
                var data = {name: $("#queryname").val(), fid: $("#queryfid").val()};
                $("#querycontent").load("modulequery.do", data, function () {
                    $("#term").show();
                });
            }
        });
	}else {
			$.ajax({
				type: "POST",
				url: "modifymodule.do",
				data: "id=" + id + "&name=" + name + "&url=" + url + "&fid=" + fid + "&fname=" + fname,
				success: function (data) {
					var data = {name: $("#queryname").val(), fid: $("#queryfid").val()};
					$("#querycontent").load("modulequery.do", data, function () {
						$("#term").show();
					});
				}
			});
    	}
	});
</script>
</div>