<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>二手賣場-商品詳情</title>
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
            <h2>商品詳情</h2>

        </div>
    </section><!-- End Breadcrumbs -->

    <section id="portfolio-details" class="portfolio-details">
        <div class="container">

            <div class="row gy-4">

                <div class="col-lg-8">
                    <div class="portfolio-details-slider swiper">
                        <div class="swiper-wrapper align-items-center">

                            <div class="swiper-slide">
                                <img src="${contextRoot}/${bidProduct.image}" class="card-img-top"
                                     style="opacity: 0; transition: opacity 0.5s ease-in-out; height: 50rem; width: 50rem"
                                     onload="this.style.opacity='1';"
                                     alt="BidProduct-image">
                            </div>

                        </div>
                        <div class="swiper-pagination"></div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="portfolio-info">
                        <h3>商品詳情</h3>
                        <ul>
                            <li>
                                <strong class="fs-6 badge bg-secondary text-white">種類</strong>
                                <span class="fs-6 ms-2">${bidProduct.category.name}</span>
                            </li>
                            <li>
                                <strong class="fs-6 badge bg-secondary text-white">名稱</strong>
                                <span class="fs-6 ms-2">${bidProduct.name}</span>
                            </li>
                            <li>
                                <strong class="fs-6 badge bg-secondary text-white">起始時間</strong>
                                <span class="fs-6 ms-2" id="createdAt">${bidProduct.createdAt}</span>
                            </li>
                            <li>
                                <strong class="fs-6 badge bg-secondary text-white">結束時間</strong>
                                <c:choose>
                                    <c:when test="${bidProduct.expiredAt != null}">
                                        <span class="fs-6 ms-2" id="expiredAt">${bidProduct.expiredAt}</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="fs-6 ms-2">目前暫無</span>
                                    </c:otherwise>
                                </c:choose>
                            </li>
                            <li>
                                <strong class="fs-6 badge bg-secondary text-white">底價</strong>
                                <span class="fs-6 ms-2" id="basePrice">${bidProduct.basePrice}</span>
                                <span class="fs-6">  元</span>
                            </li>
                            <li>
                                <strong class="fs-6 badge bg-secondary text-white">目前價格</strong>
                                <span class="fs-6 ms-2" id="currentBidPrice">${bidProduct.bidPrice}</span>
                                <span class="fs-6">  元</span>
                            </li>
                        </ul>
                        <input name="bidPrice" id="bidPrice" type="number" class="form-control" min="1"
                               placeholder="輸入欲購買價格" required/>
                        <button class="btn mt-2 text-white" style="background-color: #e96b56"
                                data-bs-toggle="modal" data-bs-target="#modal-${bidProduct.id}">點我出價
                        </button>
                        <%--          顯示訊息              --%>
                        <div id="messageArea"></div>
                    </div>
                    <div class="portfolio-description">
                        <h2 class="text-center">距離截止還有</h2>
                        <div class="container text-center">
                            <div id="countDownArea" class="badge bg-dark text-white fs-6">
                                <span class="day">天</span>
                                <span class="hour">時</span>
                                <span class="minute">分</span>
                                <span class="second">秒</span>
                            </div>
                        </div>
                        <div class="card mt-3">
                            <div class="card-header fw-bold">賣家: 某某某</div>
                            <div class="card-body">
                                <h5 class="card-title">關於此商品</h5>
                                <c:choose>
                                    <c:when test="${bidProduct.description != null}}">
                                        ${bidProduct.description}
                                    </c:when>
                                    <c:otherwise>
                                        暫無說明。。。
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </section><!-- End Portfolio Details Section -->

</main>

<jsp:include page="../layouts/footer.jsp"/>

<%-- Modal --%>
<div class="modal fade" id="modal-${bidProduct.id}" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title fw-bold">送出確認</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>確定要出價 <strong>${bidProduct.name}</strong> 嗎?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">返回</button>
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="updateBidPriceBtn"
                        data-id="${bidProduct.id}" style="background-color: #e96b56">送出
                </button>
            </div>
        </div>
    </div>
</div>

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
<script src="${contextRoot}/js/bid/updateBidPrice.js"></script>
<script src="${contextRoot}/js/bid/showDateCountDown.js"></script>
</body>

</html>
