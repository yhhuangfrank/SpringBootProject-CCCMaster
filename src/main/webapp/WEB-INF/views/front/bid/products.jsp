<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create BidProduct</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

    <!-- Favicons -->
    <link href="${contextRoot}/styles/back/assets/img/favicon.png" rel="icon">
    <link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${contextRoot}/styles/back/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/back/assets/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="../layouts/topbar.jsp"/>

<jsp:include page="../layouts/header.jsp"/>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>所有商品</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/">首頁</a></li>
                <li class="breadcrumb-item">拍賣管理</li>
                <li class="breadcrumb-item active">所有商品</li>
            </ol>
        </nav>
    </div>
    <section class="section">
        <div class="row align-items-top">
            <div class="col-lg-8 mx-auto">
                <%-- 顯示訊息 --%>
                <jsp:include page="../../message.jsp"/>
                <%-- 顯示商品 --%>
                <c:forEach items="${bidProducts}" var="b">
                    <div class="card mb-3">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <c:choose>
                                    <c:when test="${ b.image.startsWith('http') }">
                                        <img src="${b.image}" class="img-fluid rounded-start"
                                             style="opacity: 0; transition: opacity 0.5s ease-in-out;"
                                             onload="this.style.opacity='1';"
                                             alt="BidProduct-image">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${contextRoot}/${b.image}" class="img-fluid rounded-start"
                                             style="opacity: 0; transition: opacity 0.5s ease-in-out;"
                                             onload="this.style.opacity='1';"
                                             alt="BidProduct-image">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title"><span
                                            class="badge fw-bold bg-success text-white">品名</span> ${b.name}</h5>
                                    <p class="card-text">${b.description}</p>
                                    <div>
                                        <a href="${contextRoot}/admin/bidProducts/${b.id}/edit" class="btn btn-outline-info">修改</a>
                                        <button class="btn btn-outline-danger" style="display: inline"
                                                data-bs-toggle="modal" data-bs-target="#modal-${b.id}">刪除
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <%-- 顯示商品結束 --%>
            </div>
        </div>
    </section>
</main>

<jsp:include page="../layouts/footer.jsp"/>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<%-- Modals --%>
<c:forEach items="${bidProducts}" var="b">
    <div class="modal fade" id="modal-${b.id}" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title fw-bold">刪除確認</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    確定刪除 <strong>${b.name}</strong> 嗎?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">返回</button>
                    <form:form action="${contextRoot}/admin/bidProducts/${b.id}" method="DELETE">
                        <button type="submit" class="btn btn-danger">刪除</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<!-- Vendor JS Files -->
<script src="${contextRoot}/styles/back/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/chart.js/chart.umd.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/echarts/echarts.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/quill/quill.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${contextRoot}/styles/back/assets/js/main.js"></script>
</body>
</html>
