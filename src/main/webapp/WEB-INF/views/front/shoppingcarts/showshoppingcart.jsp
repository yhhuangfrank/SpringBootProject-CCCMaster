<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${contextRoot}/styles/front/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/back/assets/vendor/remixicon/remixicon.css" rel="stylesheet">

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
        <li><a href="index.html">首頁</a></li>
        <li>購物車</li>
      </ol>
      <h2>購物車</h2>

    </div>
  </section><!-- End Breadcrumbs -->
	    <section id="blog" class="blog">
      <div class="container" data-aos="fade-up">
        <div class="row">
          <div class="col-lg-8 entries">
            <div class="entry entry-single">
				<table class="table">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">商品名稱</th>
                    <th scope="col">數量</th>
                    <th scope="col">單價</th>
                    <th scope="col">小計</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                <c:set var="total" value="0" />
                <c:forEach var="sc" items="${shoppingcart}">
                  <tr>
                    <th scope="row"></th>
                    <td>${sc.productBean.productName}</td>
                    <td>${sc.quantity}</td>
                    <td>${sc.productBean.price}</td>
                    <td><c:set var="subtotal" value="${sc.quantity*sc.productBean.price}" />${sc.quantity*sc.productBean.price}</td>
                    <td><i class="ri-delete-bin-6-line"></i></td>
                    <c:set var="total" value="${total + subtotal}" />
                    
                  </tr>
                  </c:forEach>
                   
                  
                </tbody>
              </table>
            </div>
          </div>

          <div class="col-lg-4">

            <div class="sidebar">
            <div class="row">
				<div class="col-lg-3">總金額&nbsp;:</div>
				<div class="col-lg-9" style="text-align: right">
					<fmt:formatNumber value="${total}" pattern="$#,###" />
				</div>
					<div class="col-lg-3" style="margin-top: 5px">運&nbsp;&nbsp;&nbsp;&nbsp;費&nbsp;:</div>
					<div class="col-lg-9" style="text-align: right;margin-top: 5px">
						<fmt:formatNumber value="30" pattern="#,###" />
					</div>
				<br>
				<br>
				<hr>
				<div class="col-lg-3">總&nbsp;&nbsp;&nbsp;&nbsp;計:</div>
				<div class="col-lg-9" style="text-align:right">
					<fmt:formatNumber value="${total+30}" pattern="$#,###" />
				</div>
				<form:form method="post" modelAttribute="" action="${contextRoot}">
					<div class="d-grid gap-2 mt-3">					
						<button class="btn btn-danger">結帳去</button>					
					</div>
				</form:form>	
			</div>
            </div><!-- End sidebar -->

          </div><!-- End blog sidebar -->

        </div>

      </div>
    </section><!-- End Blog Single Section -->
  

</main><!-- End #main -->

<jsp:include page="../layouts/footer.jsp"/>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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
