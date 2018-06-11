<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
    <span onclick="changetk(1)">1</span>
    <span onclick="changetk(2)">2</span>
        <div id="tksbcontent1">
            <p>
                <span>张三一号塘</span>
                <span>温度：</span>
                <span>20° </span>
                <span>溶氧：</span>
                <span>10mg/L </span>
            </p>
            <p>
                <span>设备：</span>
                <span>增氧机1 </span>
                <span>在线 </span>
                <span>无异常 </span>
            </p>
            <p>
                <span>设备：</span>
                <span>增氧机2 </span>
                <span>在线 </span>
                <span>有异常 </span>
            </p>
        </div>

    <div id="tksbcontent2">
        <p>
            <span>张三二号塘</span>
            <span>温度：</span>
            <span>20° </span>
            <span>溶氧：</span>
            <span>10mg/L </span>
        </p>
        <p>
            <span>设备：</span>
            <span>增氧机3 </span>
            <span>在线 </span>
            <span>无异常 </span>
        </p>
        <p>
            <span>设备：</span>
            <span>增氧机4 </span>
            <span>在线 </span>
            <span>有异常 </span>
        </p>
    </div>

<script>
    starttk();
    function changetk(num){
        if(num==1){
            $("#tksbcontent2").hide();
            $("#tksbcontent1").show();
        }else if(num==2){
            $("#tksbcontent2").show();
            $("#tksbcontent1").hide();
        }
    }

    function starttk(){
        $("#tksbcontent2").hide();
    }
</script>
</div>
