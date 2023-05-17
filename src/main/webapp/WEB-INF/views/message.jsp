<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!-- 【綠色】成功訊息框 -->
<c:if test="${isSuccess}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
            &#10004;
            <strong>${successMsg}</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<!-- 【黃色】警告訊息框 -->
<c:if test="${isWarning}">
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">&#11198; ${warningMsg}</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<!-- 【紅色】失敗訊息框 -->
<c:if test="${isFailed}">
	<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  <strong>${failedMsg}</strong>
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>

<!-- 【綠色】成功訊息框-浮動 -->
<c:if test="${isSuccess_float}">
	<div id="success-msg-float" class="alert alert-success position-fixed top-50 start-50 translate-middle d-none" role="alert">
 		${successMsg_float}
	</div>
 	<script>
		// 顯示成功訊息框-浮動
		document.querySelector('#success-msg-float').classList.remove('d-none');
		// 設定 2 秒後淡出消失
		setTimeout(function() {
		document.querySelector('#success-msg-float').classList.add('fade');
		}, 2000);
	</script>
</c:if>

<!-- 【紅色】失敗訊息框-浮動 -->
<c:if test="${isFailed_float}">
	<div id="failed-msg-float" class="alert alert-danger position-fixed top-50 start-50 translate-middle d-none" role="alert">
 		${failedMsg_float}
	</div>
 	<script>
		// 顯示成功訊息框-浮動
		document.querySelector('#failed-msg-float').classList.remove('d-none');
		// 設定 2 秒後淡出消失
		setTimeout(function() {
		document.querySelector('#failed-msg-float').classList.add('fade');
		}, 2000);
	</script>
</c:if>