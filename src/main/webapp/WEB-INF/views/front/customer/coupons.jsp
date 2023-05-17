<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>我的優惠券</title>
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
    
    <style>
    	button[type=submit] {
		  background: #e96b56;
		  border: 0;
		  border-radius: 50px;
		  padding: 10px 24px;
		  color: #fff;
		  transition: 0.4s;
		}
		
		button[type=submit]:hover {
		  background: #e6573f;
		}
    </style>
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
                <li>我的優惠券</li>
            </ol>
            <h2>我的優惠券</h2>

        </div>
    </section><!-- End Breadcrumbs -->

    <section id="portfolio" class="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-12 mx-auto">
                
                    <%-- 顯示提示訊息 --%>
                    <jsp:include page="../../message.jsp"/>

                    <form class="row" action="${contextRoot}/customers/${sessionScope.customerId}/coupons" method="post">
                    <div class="col-3">
                        <div class="col-6 input-group">
                            <input type="text" class="form-control" id="convertid" placeholder="請輸入優惠券兌換代碼" name="convertid">
                            <button type="submit" class="btn btn-secondary border-secondary" id="submitBtn"><i class="bi bi-cursor"></i></button>
                        </div>
                    </div>
                    </form>
                </div>
              	<table class="table table-striped table-bordered" style="text-align: center;">
                <thead>
                  <tr>
                    <th scope="col">訂單編號</th>
                    <th scope="col">購買時間</th>
                    <th scope="col">訂單狀態</th>
                    <th scope="col">付款狀態</th>
                    <th scope="col">總價</th>
                    <th scope="col">退貨</th>
                    <th scope="col">客戶服務</th>
                  </tr>
                </thead>
                <tbody>                                
                  <c:if test="${not empty results}">
                  	<c:forEach items="${results}" var="result">
	                  <tr>
						<td>
							<a href="${contextRoot}/front/orders/details/${result.orderid}">
							${result.orderid}
							</a>
						</td>
	                    <td>
	                    	<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.orderdate}"/>
	                    
	                    </td>
	                    <td>${result.ordercondition}</td>
	                    <td>${result.paymentcondition}</td>
	                    <td>${result.totalamount}</td>
	                    <td>我要退貨</td>
	                    <td>聯絡客服</td>
	                  </tr>
	                  </c:forEach>
	                 </c:if>
	                 <c:if test="${empty results}">
	                 	<c:forEach var="order" items="${orders}">
	                 	<tr>
						<td>
							<a href="${contextRoot}/front/orders/details/${order.orderid}">
							${order.orderid}
							</a>
						</td>
	                    <td>
	                    	<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${order.orderdate}"/>	                    
	                    </td>
	                    <td>${order.ordercondition}</td>
	                    <td>${order.paymentcondition}</td>
	                    <td>${order.totalamount}</td>
	                    <td>我要退貨</td>
	                    <td>聯絡客服</td>
	                  </tr>
	                  </c:forEach>
	                 </c:if> 
                </tbody>
              </table>
            </div>
        </div>
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

</body>

</html>
