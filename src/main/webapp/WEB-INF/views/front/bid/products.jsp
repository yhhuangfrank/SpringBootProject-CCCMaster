<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>二手賣場</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

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
    <link href="${contextRoot}/styles/back/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">
</head>

<body>

<jsp:include page="../layouts/topbar.jsp"/>

<jsp:include page="../layouts/header.jsp"/>

<main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">

            <ol>
                <li><a href="${contextRoot}/">首頁</a></li>
                <li>二手賣場</li>
            </ol>
            <h2>二手賣場</h2>

        </div>
    </section><!-- End Breadcrumbs -->

    <section id="portfolio" class="portfolio">
        <div class="container">

            <div class="row">
                <div class="col-6 mx-auto">

                    <%-- message.jsp 顯示訊息 --%>
                    <jsp:include page="../../message.jsp"/>

                    <form class="row g-3">
                        <div class="col-12 input-group">
                            <input type="text" class="form-control" id="searchInput" placeholder="查詢商品">
                            <button type="button" class="btn btn-outline-light border-secondary" id="searchBtn"
                                    style="display: inline; background-color: #e96b56"><i class="bx bx-search-alt"></i>
                            </button>
                        </div>
                        <div class="col-md-6 align-self-center">
                            <select class="form-select" id="sortingSelect">
                                <option value="createdAt_desc">最新的在前</option>
                                <option value="basePrice_asc">底價由低到高</option>
                                <option value="basePrice_desc">底價由高到低</option>
                                <option value="viewCount_desc">最多點擊</option>
                            </select>
                        </div>
                        <div class="col-md-4 ms-auto" id="checkBox">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="nonClosedCheck">
                                <label class="form-check-label">
                                    不顯示已截止
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="startedCheck">
                                <label class="form-check-label">
                                    不顯示未開始拍賣
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="dueSoonCheck">
                                <label class="form-check-label">
                                    即將截止
                                </label>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-12 d-flex justify-content-center mt-2">
                    <ul id="portfolio-flters" class="categoryList">
                        <li class="filter-active category" data-category="all">全部</li>
                        <li class="category">手機</li>
                        <li class="category">電腦</li>
                        <li class="category">筆記型電腦</li>
                        <li class="category">滑鼠</li>
                        <li class="category">鍵盤</li>
                    </ul>
                </div>
            </div>

            <%--若查無資料顯示訊息--%>
            <div id="messageArea"></div>
            <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3" id="bidProductArea">
                <%--使用 api 替換此區資料--%>
            </div>

        </div>
        <%--  Pagination   --%>
        <nav aria-label="Page navigation example" class="mt-4">
            <ul class="pagination justify-content-center align-items-center my-0">
            </ul>
        </nav>
    </section>


</main><!-- End #main -->

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
<%-- axios 與自訂 JS --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.3.6/axios.min.js"></script>
<script src="${contextRoot}/js/bid/retrieveBidProducts.js"></script>
</body>

</html>
