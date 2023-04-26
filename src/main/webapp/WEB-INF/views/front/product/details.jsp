<%--
  Created by IntelliJ IDEA.
  User: h8803
  Date: 2023/4/23
  Time: 下午 04:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Example</title>
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
    <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">

    <%--    自己加的--%>
    <!-- Bootstrap icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <%--axios--%>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <%--    自己加的--%>

</head>

<body>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/topbar.jsp"/>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/header.jsp"/>

<main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">

            <ol>
                <li><a href="index.html">Home</a></li>
                <li>Portfolio Details</li>
            </ol>
            <h2>Portfolio Details</h2>

        </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= Portfolio Details Section ======= -->
    <section id="portfolio-details" class="portfolio-details">
        <div class="container">

            <div class="row gy-4">

                <div class="col-lg-6">
                    <div class="portfolio-details-slider swiper">
                        <div class="swiper-wrapper align-items-center">

                            <div class="swiper-slide">
                                <img src="${contextRoot}/products/showImage/${product.productId}" alt="">
                            </div>

                            <div class="swiper-slide">
                                <img src="${contextRoot}/products/showImage/${product.productId}" alt="">
                            </div>

                            <div class="swiper-slide">
                                <img src="${contextRoot}/products/showImage/${product.productId}" alt="">
                            </div>

                        </div>
                        <div class="swiper-pagination"></div>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="portfolio-info">
                        <h3>產品資訊</h3>
                        <ul>
                            <li><strong>產品名稱</strong>: ${product.productName}</li>
                            <li><strong>類別</strong>: ASU Company</li>
                            <li><strong>Project date</strong>: 01 March, 2020</li>
                            <li><strong>價格</strong>: ${product.price}</li>
                            <li><strong>庫存量</strong>: ${product.inventory}</li>
                            <li>
                                <strong>購買數量</strong>:
                                <div class="input-group" style="width: 150px;">
                                    <button id="decrement" class="btn btn-outline-secondary" type="button">-</button>
                                    <%--                                    <input id="quantity" type="number" class="form-control text-center" min="1" value="1" max="${product.inventory}">--%>
                                    <input id="quantity" type="text" class="form-control text-center" value="1"
                                           data-max="${product.inventory}">
                                    <button id="increment" class="btn btn-outline-secondary" type="button">+</button>
                                </div>
                            </li>
                            <%--                            <li>--%>
                            <%--                                <strong>購買數量</strong>:--%>
                            <%--                                <button id="decrement" type="button">-</button>--%>
                            <%--                                <input id="quantity" type="number" min="1" value="1" max="${product.inventory}" style="width: 50px;">--%>
                            <%--                                <button id="increment" type="button">+</button>--%>
                            <%--                            </li>--%>
                            <li>
                                <form:form method="post" modelAttribute="sc"
                                           action="${contextRoot}/ShoppingCarts/create">
                                    <form:form method="post" modelAttribute="scd"
                                               action="${contextRoot}/ShoppingCarts/create">
                                        <button type="submit" class="btn btn-primary">加入購物車</button>
                                    </form:form>
                                </form:form>
                            </li>
                        </ul>
                    </div>
                    <div class="portfolio-description">
                        <h2>產品介紹</h2>
                        <p>
                            ${product.description}
                        </p>

                    </div>
                </div>

            </div>

        </div>
    </section><!-- End Portfolio Details Section -->

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
<script>
    // -----------爬蟲----------------
    window.addEventListener('load', () => {
        axios.get('/admin/crawler/${product.productId}')
            .then((response) => {
                // console.log(response.data);
                console.log('success');
            })
            .catch((error) => {
                console.log(error);
            });
    });
    // -----------爬蟲----------------
    // -------------- 購買數量 +1 -1 事件-----------
    document.getElementById("increment").addEventListener("click", () => {
        const quantityInput = document.getElementById("quantity");
        const max = parseInt(quantityInput.getAttribute('data-max'), 10);
        let value = parseInt(quantityInput.value, 10);
        console.log(`max=${max}  value=${value}`)
        if (value<max) {
        quantityInput.value = parseInt(quantityInput.value) + 1;
        }
    });

    document.getElementById("decrement").addEventListener("click", () => {
        const quantityInput = document.getElementById("quantity");
        const currentValue = parseInt(quantityInput.value);
        if (currentValue > 1) {
            quantityInput.value = currentValue - 1;
        }
    });
    // -------------- 購買數量 +1 -1 事件-----------
    //-------------------------------購買數量欄位數值檢查------------------
    document.getElementById('quantity').addEventListener('input', (event) => {
        const input = event.target;
        const max = parseInt(input.getAttribute('data-max'), 10);
        let value = parseInt(input.value, 10);

        // 如果輸入的值不是有效的整數，將值設為 1
        if (isNaN(value) || value < 1) {
            value = 1;
        }

        // 如果輸入的值大於最大庫存量，將值設為最大庫存量
        if (value > max) {
            value = max;
        }

        // 更新 input 的值
        input.value = value;
    });
    //-------------------------------購買數量欄位數值檢查------------------
</script>


</body>

</html>

