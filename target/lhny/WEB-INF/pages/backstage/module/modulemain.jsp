<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<p>模块管理</p>
		<div id="term">
			<p><span id="add">新增 </span><span id="query"> 查询</span></p>
  			<p><span>查询条件:</span></p>
			<p><span>模块名称</span><input type="text" id="queryname" placeholder="请填写查询条件"/></p>
			<p>
				<span>父模块</span>
					<select id="queryfid">
						<c:forEach items="${fnamelist}" var="list">
							<option value="${list.fid}">${list.fname}</option>
						</c:forEach>
					</select>
			</p>
		</div>
	<div id="querycontent"></div>
	<script>
		$("#query").click(function(){
			var data =  {name:$("#queryname").val(),fid:$("#queryfid").val()};
			$("#querycontent").load("modulequery.do",data);
		});
		$("#add").click(function(){
            $("#term").hide();
			$("#querycontent").load("moduleadd.do");
		});
		
		function modulemodify(id,name,url,fid,fname) {
			$("#querycontent").load("moduleadd.do",function () {
				$("#id").val(id);
                $("#name").val(name);
                $("#url").val(url);
                $("#fid").val(fid);
                $("#fname").val(fname);
            });
        };
	</script>
</div>