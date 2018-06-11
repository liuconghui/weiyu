<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<div style="width:29%;height:50%;float:left;border:1px solid #F00">
		<p>塘口设备反馈信息
			<span style="float: right" onclick="refurbish(1)">刷新</span>
		</p>
		<div id="tksb"></div>
	</div>
	<div style="width:69%;height:50%;float:left;border:1px solid #F00">
		<p>曲线图
			<span style="float: right" onclick="refurbish(2)">刷新</span>
		</p>
		<div id="qxt"></div>
	</div>
	<div style="width:24%;height:50%;float:left;border:1px solid #F00">
		<p>设备日志信息
			<span style="float: right" onclick="refurbish(3)">刷新</span>
		</p>
		<div id="sbrz"></div>
	</div>
	<div style="width:24%;height:50%;float:left;border:1px solid #F00">
		<p>告警日志信息
			<span style="float: right" onclick="refurbish(4)">刷新</span>
		</p>
		<div id="gjrz"></div>
	</div>
	<div style="width:25%;height:50%;float:left;border:1px solid #F00">
		<p>天气信息
			<span style="float: right" onclick="refurbish(5)">刷新</span>
		</p>
		<div id="tqxx"></div>
	</div>
	<div style="width:25%;height:50%;float:left;border:1px solid #F00">
		<p>客户设置配置
			<span style="float: right" onclick="refurbish(6)">刷新</span>
		</p>
		<div id="khpz"></div>
	</div>
	<script>
        loadingall();
		function loadingall() {
			$("#tksb").load("querytksb.do");
            $("#qxt").load("queryqxt.do");
            $("#sbrz").load("querysbrz.do");
            $("#gjrz").load("querygjrz.do");
            $("#tqxx").load("querytqxx.do");
            $("#khpz").load("querykhpz.do");
        }
		function refurbish(num){
		    if(num==1){
                $("#tksb").load("querytksb.do");
			}else if(num==2){
                $("#qxt").load("queryqxt.do");
			}else if(num==3){
                $("#sbrz").load("querysbrz.do");
            }else if(num==4){
                $("#gjrz").load("querygjrz.do");
            }else if(num==5){
                $("#tqxx").load("querytqxx.do");
            }else if(num==6){
                $("#khpz").load("querykhpz.do");
            }
		}
	</script>
</div>