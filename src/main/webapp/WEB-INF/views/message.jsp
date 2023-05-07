<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<c:if test="${isSuccess}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
            &#10004;
            <strong>${successMsg}</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<c:if test="${isWarning}">
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">&#11198; ${warningMsg}</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>