<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<div>
		<ul>
			<li id="a1">销售模块</li>
			<li id="a2">后台模块</li>
			<li id="a3">前端模块</li>
			<li id="a4">运营监控模块</li>
			<li id="a5">短信模块</li>
		</ul>
	</div>
	<div id="chan">
		
	</div>
	
	<script>
		$("#a1").click(function(){
			$("#chan").html("<ul><li><span onclick=\"changee('a11')\">设备类型信息管理</span></li>"+
			"<li><span onclick=\"changee('a12')\">设备信息管理</span></li>"+
			"<li><span onclick=\"changee('a13')\">库存信息管理</span></li></ul>");
		});
		
		$("#a2").click(function(){
			$("#chan").html("<ul><li><span onclick=\"changee('a21')\">模块管理</span></li>"+
			"<li><span onclick=\"changee('a22')\">角色管理</span></li>"+
			"<li><span onclick=\"changee('a23')\">员工管理</span></li>"+
			"<li><span onclick=\"changee('a24')\">知识库管理</span></li>"+
			"<li><span onclick=\"changee('a25')\">区域信息管理</span></li>"+
			"<li><span onclick=\"changee('a26')\">安装工单管理</span></li></ul>"
			);
		});
		
		$("#a3").click(function(){
			$("#chan").html("<ul><li><span onclick=\"changee('a31')\">塘口管理</span></li>"+
			"<li><span onclick=\"changee('a32')\">设备配置信息管理</span></li>"+
			"<li><span onclick=\"changee('a33')\">广告管理</span></li>"+
			"<li><span onclick=\"changee('a34')\">通知管理</span></li>"+
			"<li><span onclick=\"changee('a36')\">会员管理</span></li>"+
			"<li><span onclick=\"changee('a35')\">反馈信息管理</span></li></ul>"
			);
		});
		
		$("#a4").click(function(){
			$("#chan").html("<ul><li><span onclick=\"changee('a41')\">整体监控</span></li>"+
			"<li><span onclick=\"changee('a42')\">设备消息日志</span></li>"+
			"<li><span onclick=\"changee('a43')\">图形监控</span></li></ul>");
		});
		
		$("#a5").click(function(){
			$("#chan").html("<ul><li><span onclick=\"changee('a51')\">短信网关设置</span></li>"+
			"<li><span onclick=\"changee('a52')\">短信发送设置</span></li></ul>");
		});
	</script>
</div>