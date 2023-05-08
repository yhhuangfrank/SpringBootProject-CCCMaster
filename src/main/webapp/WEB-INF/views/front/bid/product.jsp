<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>二手賣場-商品詳情</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <c:set var="currentCustomerId" value="${sessionScope.customerId}"/>

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

            <jsp:include page="../../message.jsp"/>

            <div class="row gy-4">

                <div class="col-lg-8">
                    <div class="portfolio-details-slider swiper">
                        <div class="swiper-wrapper align-items-center">

                            <div class="swiper-slide">
                                <c:choose>
                                    <c:when test="${bidProduct.image.contains('http')}">
                                        <img src="${bidProduct.image}" class="card-img-top"
                                             style="opacity: 0; transition: opacity 0.5s ease-in-out; height: 50rem; width: 50rem"
                                             onload="this.style.opacity='1';"
                                             alt="BidProduct-image">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${contextRoot}/${bidProduct.image}" class="card-img-top"
                                             style="opacity: 0; transition: opacity 0.5s ease-in-out; height: 50rem; width: 50rem"
                                             onload="this.style.opacity='1';"
                                             alt="BidProduct-image">
                                    </c:otherwise>
                                </c:choose>
                            </div>

                        </div>
                        <div class="swiper-pagination"></div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="portfolio-info">
                        <%-- 只有登入的賣家能編輯自己的商品 --%>
                        <h3>商品詳情
                            <c:if test="${currentCustomerId == bidProduct.customer.customerId}">
                                <a href="${contextRoot}/bidProducts/${bidProduct.id}/edit"
                                   class="btn btn-outline-info">修改</a>
                            </c:if>
                        </h3>
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
                                <span class="fs-6 ms-2" id="createdAt"><fmt:formatDate value="${bidProduct.createdAt}"
                                                                                       pattern="yyyy-MM-dd HH:mm"/></span>
                            </li>
                            <li>
                                <strong class="fs-6 badge bg-secondary text-white">結束時間</strong>
                                <c:choose>
                                    <c:when test="${bidProduct.expiredAt != null}">
                                        <span class="fs-6 ms-2" id="expiredAt"><fmt:formatDate
                                                value="${bidProduct.expiredAt}" pattern="yyyy-MM-dd HH:mm"/></span>
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
                               placeholder="輸入欲購買價格" required disabled/>
                        <button class="btn mt-2 text-white disabled" id="bidBtn" style="background-color: #e96b56"
                                data-bs-toggle="modal" data-bs-target="#modal-${bidProduct.id}">點我出價
                        </button>
                        <%--          顯示訊息              --%>
                        <div id="messageArea">
                            <c:if test="${dealRecord != null}">
                                <div class="alert alert-success mt-2 fw-bold" role="alert">
                                    恭喜使用者: ${dealRecord.customer.name} 得標!
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="portfolio-description">
                        <div class="container text-center">
                            <c:if test="${bidProduct.expiredAt != null}">
                                <h2 class="">距離截止還有</h2>
                                <div id="countDownArea" class="badge bg-dark text-white fs-6">
                                        <%--顯示倒數計時前先顯示loading--%>
                                    <div class="spinner-border text-white" role="status">
                                        <span class="visually-hidden">Loading...</span>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <div class="card mt-3">
                            <div class="card-header fw-bold">賣家: ${bidProduct.customer.name}</div>
                            <div class="card-body">
                                <h5 class="card-title">關於此商品</h5>
                                <c:choose>
                                    <c:when test="${bidProduct.description != null}">
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

        <div class="container mt-2">
            <h3>所有留言 :</h3>
            <div class="border border-dark border-2 rounded-2">
                <div id="commentArea">
                    <div class="mx-2 p-2">
                        <blockquote class="blockquote">
                            <h4>小名</h4>
                            <p>留言內容</p>
                        </blockquote>
                        <footer class="blockquote-footer">留言時間</footer>
                        <hr/>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-lg-6 mx-auto text-center">
                        <a href="#" class="btn btn-outline-secondary">上一頁</a>
                        第1頁/10頁
                        <a href="#" class="btn btn-outline-secondary">下一頁</a>
                    </div>
                </div>
            </div>
            <div class="mt-3">
                <div class="mb-3">
                    <label for="commentTextArea"></label>
                    <textarea class="form-control" name="comment" id="commentTextArea" cols="20"
                              rows="8">想說點什麼... ?</textarea>
                </div>
                <%-- 留言提示訊息 --%>
                <div id="alertMessageForComment"></div>
                <button class="btn btn-primary" data-bidproduct_id="${bidProduct.id}"
                        data-currentuser_id="${currentCustomerId}" id="createCommentBtn"
                        style="background-color: #e96b56">新增留言
                </button>
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
                        data-bidproduct_id="${bidProduct.id}" data-currentuser_id="${currentCustomerId}"
                        data-seller_id="${bidProduct.customer.customerId}" style="background-color: #e96b56">送出
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
<script src="${contextRoot}/js/bid/dateTimerInDetailPage.js"></script>
<script src="${contextRoot}/js/bid/updateBidPrice.js"></script>
<script src="${contextRoot}/js/bid/commentInDetailPage.js"></script>
</body>

</html>
