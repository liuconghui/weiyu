<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<div>
	<p>总体监控</p>
	</div>
	<div id="querycontent"></div>
	<script>
        query();
		function query() {
			$("#querycontent").load("monitorquerymember.do");
        }
		
	</script>
</div>