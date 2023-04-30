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
    <link href="${contextRoot}/styles/front/assets/img/favicon.png" rel="icon">
    <link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${contextRoot}/styles/front/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="../layouts/topbar.jsp"/>

<jsp:include page="../layouts/header.jsp"/>

<main id="main" class="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">

            <ol>
                <li><a href="${contextRoot}/">首頁</a></li>
                <li>二手賣場</li>
            </ol>
            <h2>新增商品</h2>

        </div>
    </section><!-- End Breadcrumbs -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6 mx-auto">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-center fw-bold">新增二手商品</h5>

                        <!-- General Form Elements -->
                        <form:form modelAttribute="bidProductRequest" method="POST" action="${contextRoot}/bidProducts" enctype="multipart/form-data">
                            <!-- 印出錯誤訊息 -->
                            <c:if test="${isErrorExist}">
                                <c:forEach items="${errors}" var="error">
                                    <div class="alert alert-warning alert-dismissible fade show" role="alert">

                                        <code class="fw-bold fs-6">
                                            &#11198;
                                            <c:if test="${error.field.equals('name')}">
                                                <form:errors path="name"/>
                                            </c:if>
                                            <c:if test="${error.field.equals('basePrice')}">
                                                <form:errors path="basePrice"/>
                                            </c:if>
                                            <c:if test="${error.field.equals('categoryName')}">
                                                <form:errors path="categoryName"/>
                                            </c:if>
                                            <c:if test="${error.field.equals('description')}">
                                                <form:errors path="description"/>
                                            </c:if>
                                        </code>
                                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <!-- 印出錯誤訊息結束 -->
                            <div class="row mb-3">
                                <label for="name" class="col-sm-2 col-form-label fw-bold">名稱</label>
                                <div class="col-sm-10">
                                    <form:input path="name" id="name" type="text" class="form-control" minlength="1"
                                           maxlength="20" placeholder="輸入名稱" required="true"/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="basePrice" class="col-sm-2 col-form-label fw-bold">底價</label>
                                <div class="col-sm-10">
                                    <form:input path="basePrice" id="basePrice" type="number" class="form-control" min="1"
                                           placeholder="輸入底價" required="true"/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="categoryName" class="col-sm-2 col-form-label fw-bold">種類</label>
                                <div class="col-sm-10">
                                    <form:input path="categoryName" class="form-control" list="categoryList" id="categoryName"
                                           placeholder="搜尋或自訂種類"/>
                                    <datalist id="categoryList">
                                        <c:forEach items="${categories}" var="category">
                                            <option value="${category.name}">
                                        </c:forEach>
                                    </datalist>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="description" class="col-sm-2 col-form-label fw-bold">描述</label>
                                <div class="col-sm-10">
                                    <form:textarea path="description" id="description" class="form-control" cols="30" rows="10"></form:textarea>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="image" class="col-sm-2 col-form-label fw-bold">圖片</label>
                                <div class="col-sm-10 align-self-center">
                                    <form:input path="image" id="image" type="file" class="form-control"/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="endDate" class="col-sm-2 col-form-label fw-bold">截止時間</label>
                                <div class="col-sm-10">
                                    <form:input path="endDate" id="endDate" type="datetime-local" class="form-control"/>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">送出</button>
                            <a href="javascript:history.back()" class="btn btn-dark">上一頁</a>
                        </form:form><!-- End General Form Elements -->

                    </div>
                </div>

            </div>
        </div>
    </section>
</main>


<jsp:include page="../layouts/footer.jsp"/>

<!-- Vendor JS Files -->
<script src="${contextRoot}/styles/front/assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/waypoints/noframework.waypoints.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/php-email-form/validate.js"></script>
<!-- Template Main JS File -->
<script src="${contextRoot}/styles/front/assets/js/main.js"></script>
<%-- 自訂 js --%>
<script src="${contextRoot}/js/bid/fileSizeValidation.js"></script>
</body>
</html>
