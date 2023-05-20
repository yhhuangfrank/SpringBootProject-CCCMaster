<%--
  Created by IntelliJ IDEA.
  User: h8803
  Date: 2023/4/22
  Time: 下午 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Example</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

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

    <%--    自己加的--%>
    <!-- Bootstrap icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <%--axios--%>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <%--    自己加的--%>

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">
    <style>
        .product-img {
            width: 100%;
            max-height: 400px; /* 將最大高度設置為 200px */
            height: auto; /* 讓高度根據原始比例自適應 */
        }



    </style>





</head>

<body>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/topbar.jsp"/>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/header.jsp"/>



<main id="main">



    <!-- ======= Breadcrumbs ======= -->

    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">

            <ol>
                <li><a href="${contextRoot}/">首頁</a></li>
                <li>產品列表</li>
            </ol>
            <h2>產品列表</h2>
            <h3 class="sidebar-title">Search</h3>
            <div class="sidebar-item search-form">
                <form action="${contextRoot}/front/product/search" method="get">
                    <input type="text" name="productName" id="productName">
                    <button id="searchBtn" type="submit"><i class="bi bi-search"></i></button>
                </form>
            </div><!-- End sidebar search formn-->


        </div>




    </section><!-- End Breadcrumbs -->



    <!-- ======= Portfolio Section ======= -->
    <section id="portfolio" class="portfolio">

        <div class="container">

            <div class="row">
                <div class="col-lg-12 d-flex justify-content-center">
                    <ul id="portfolio-flters">
                        <li data-filter="*" class="filter-active">All</li>
                        <li data-filter=".filter-app">App</li>
                        <li data-filter=".filter-card">Card</li>
                        <li data-filter=".filter-web">Web</li>
                    </ul>
                </div>
            </div>

            <div class="row portfolio-container ">
                <c:forEach var="product" items="${page.content}">
                    <div class="col-lg-4 col-md-6 portfolio-item filter-app">
                        <div class="portfolio-wrap">
                            <img src="${contextRoot}/products/showImage/${product.productId}"
                                 class="img-fluid product-img" alt="">
                            <div class="portfolio-info">
                                <h4>App 1</h4>
                                <p>App</p>
                                <div class="portfolio-links">
                                    <a href="assets/img/portfolio/portfolio-1.jpg" data-gallery="portfolioGallery"
                                       class="portfolio-lightbox" title="App 1"><i class="bx bx-plus"></i></a>
                                    <a href="${contextRoot}/front/product/details/${product.productId}"
                                       title="More Details"><i class="bx bx-link"></i></a>
                                </div>
                            </div>
                        </div>
                        <div style="display: flex;justify-content: space-between;">
                            <p>${product.productName}</p>
                            <p>售價:${product.price}</p>
                            <p>瀏覽人次:${product.productViews}</p>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
                <c:choose>
                    <c:when test="${page.number != pageNumber-1 }">
<%--                        <a href="${contextRoot}/front/product/search?keyword=${}&productName=${}">${pageNumber}</a>--%>
                        <a href="${contextRoot}/front/product/all/${pageNumber}">${pageNumber}</a>
                    </c:when>
                    <c:otherwise>
                        ${pageNumber}
                    </c:otherwise>

                </c:choose>

                <c:if test="${pageNumber != page.totalPages }">
                    -
                </c:if>


            </c:forEach>
        </div>
    </section><!-- End Portfolio Section -->

<%--    <!-- ======= Clients Section ======= -->--%>
<%--    <section id="clients" class="clients">--%>
<%--        <div class="container">--%>

<%--            <div class="section-title">--%>
<%--                <h2>Clients</h2>--%>
<%--                <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint--%>
<%--                    consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia--%>
<%--                    fugiat sit in iste officiis commodi quidem hic quas.</p>--%>
<%--            </div>--%>

<%--            <div class="clients-slider swiper">--%>
<%--                <div class="swiper-wrapper align-items-center">--%>
<%--                    <div class="swiper-slide"><img src="assets/img/clients/client-1.png" class="img-fluid" alt=""></div>--%>
<%--                    <div class="swiper-slide"><img src="assets/img/clients/client-2.png" class="img-fluid" alt=""></div>--%>
<%--                    <div class="swiper-slide"><img src="assets/img/clients/client-3.png" class="img-fluid" alt=""></div>--%>
<%--                    <div class="swiper-slide"><img src="assets/img/clients/client-4.png" class="img-fluid" alt=""></div>--%>
<%--                    <div class="swiper-slide"><img src="assets/img/clients/client-5.png" class="img-fluid" alt=""></div>--%>
<%--                    <div class="swiper-slide"><img src="assets/img/clients/client-6.png" class="img-fluid" alt=""></div>--%>
<%--                    <div class="swiper-slide"><img src="assets/img/clients/client-7.png" class="img-fluid" alt=""></div>--%>
<%--                    <div class="swiper-slide"><img src="assets/img/clients/client-8.png" class="img-fluid" alt=""></div>--%>
<%--                </div>--%>
<%--                <div class="swiper-pagination"></div>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </section><!-- End Clients Section -->--%>

</main><!-- End #main -->

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp"/>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

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
<%--Ajax--%>

<script>
    <%--const searchBtn = document.getElementById('searchBtn');--%>
    <%--const productNameInput = document.getElementById('productName');--%>
    <%--searchBtn.addEventListener('click', () => {--%>
    <%--    const productName = productNameInput.value;--%>
    <%--    axios.get(`/api/data?productName=${product.productName}`)--%>
    <%--        .then((response) => {--%>
    <%--            console.log(response.data);--%>
    <%--        })--%>
    <%--        .catch((error) => {--%>
    <%--            console.log(error);--%>
    <%--        });--%>
    <%--});--%>
</script>
</body>

</html>

