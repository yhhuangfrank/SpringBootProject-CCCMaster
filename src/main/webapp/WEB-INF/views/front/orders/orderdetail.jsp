<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>訂單明細</title>
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

    <%--    axios cdn--%>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

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
                <li>會員中心</li>
                <li>我的訂單</li>
                <li>明細</li>
            </ol>
            <h2>訂單明細</h2>

        </div>
    </section><!-- End Breadcrumbs -->

    <section id="portfolio" class="portfolio">
        <div class="container">
            <div class="row">
                <table class="table table-bordered" style="text-align: center;">
                    <thead class="table-light">
                    <tr>
                        <th scope="col">商品名稱</th>
                        <th scope="col">購買數量</th>
                        <th scope="col">商品金額</th>
                        <th scope="col">評價</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="detail" items="${orderdetails}">
                        <tr>
                            <td>${detail.pOrderDetail.productName}</td>
                            <td>${detail.quantity}</td>
                            <td>${detail.unitprice}</td>
                            <c:choose>
                                <c:when test="${paymentCompleted}">
                                    <td>
                                        <button class="btn btn-outline-success commentBtn"
                                                data-orderDetailId="${detail.id}"  id="commentModalBtn">新增/修改評論
                                        </button>
                                    </td>

                                </c:when>
                                <c:otherwise>
                                    <td>
                                        <button class="btn btn-outline-dark"
                                                data-orderDetailId="${detail.id}" disabled>尚未完成訂單
                                        </button>
                                    </td>
                                </c:otherwise>
                            </c:choose>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>

    <!-- Modal -->
    <div class="modal fade" id="reviewModal" tabindex="-1" aria-labelledby="reviewModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="reviewModalLabel">寫下評論</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <!-- Spring form -->
                    <form action="/submitReview" method="post">
                        <div class="mb-3">
                            <label for="reviewContent" class="form-label">評論內容</label>
                            <textarea class="form-control" id="reviewContent" name="reviewContent"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="reviewScore" class="form-label">評價分數</label>
                            <select class="form-select" id="reviewScore" name="reviewScore">
                                <option value="1">1分</option>
                                <option value="2">2分</option>
                                <option value="3">3分</option>
                                <option value="4">4分</option>
                                <option value="5">5分</option>
                            </select>
                        </div>
                        <button id="submitBtn" type="button" class="btn btn-primary">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
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

<%-- 新增評論 by 暐翔--%>
<script>
    let commentExist;
    let odId;
    const modal = new bootstrap.Modal(document.getElementById('reviewModal'));
    const rating=document.getElementById('reviewScore');
    const content=document.getElementById('reviewContent');
    const commentModalBtn = document.querySelectorAll('.commentBtn')
    commentModalBtn.forEach((btn) => {
        btn.addEventListener('click', function () {
            checkCommentExist(btn.getAttribute('data-orderDetailId'))
        })
    })
    const submitBtn = document.getElementById('submitBtn');
    submitBtn.addEventListener('click', function () {//
        if(commentExist==false){
            createComment(odId,rating.value,content.value);
        }else{
            updateComment(odId,rating.value,content.value);
        }

    })

    async function updateComment(orderDetailId, rating, content){
        const data = new URLSearchParams();
        data.append("orderDetailId", orderDetailId);
        data.append("rating", rating);
        data.append("content", content);
        try {
            const response = await axios.put('/comment/update', data);
            modal.hide()
            console.log(response.data);
        } catch (error) {
            console.error('Error loading products:', error);
        }
    }

    async function createComment(orderDetailId, rating, content) {
        const data = new URLSearchParams();
        data.append("orderDetailId", orderDetailId);
        data.append("rating", rating);
        data.append("content", content);
        try {
            const response = await axios.post('/comment/create', data);
            console.log(response.data);
            modal.hide()
        } catch (error) {
            console.error('Error loading products:', error);
        }
    }

    async function checkCommentExist(orderDetailId) {
        console.log(orderDetailId)
        try {
            const response = await axios.get('/comment/check', {
                params: {orderDetailId}
            });
            console.log(response.data)
            commentExist = response.data
            console.log(commentExist)

            //如果評論已存在 詢問是否要重新評論
            if (commentExist) {
                confirmAction()
            }else {
                modal.show()
            }
            odId = orderDetailId;
        } catch (error) {
            console.error('Error loading products:', error);
        }
    }

    function confirmAction() {
        let result = confirm("此訂單已存在評論，是否重新評論");

        if (result) {
            // 如果使用者點擊了 "OK"，執行這裡的程式碼
           modal.show()
            console.log("使用者確認操作");
        } else {
            // 如果使用者點擊了 "Cancel"，執行這裡的程式碼
            modal.hide()
            console.log("使用者取消操作");
        }
    }
</script>
</body>

</html>
