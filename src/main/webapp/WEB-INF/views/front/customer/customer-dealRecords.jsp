<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>得標紀錄</title>
<meta content="" name="description">
<meta content="" name="keywords">

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- Favicons -->
<link href="${contextRoot}/styles/front/assets/img/favicon.png"
	rel="icon">
<link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="${contextRoot}/styles/front/assets/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/front/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/front/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/front/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${contextRoot}/styles/front/assets/css/style.css"
	rel="stylesheet">
<%--  bootstrap icon	--%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>

<body>

	<jsp:include page="../layouts/topbar.jsp" />

	<jsp:include page="../layouts/header.jsp" />

	<main id="main">

		<!-- ======= Breadcrumbs ======= -->
		<section id="breadcrumbs" class="breadcrumbs">
			<div class="container">

				<ol>
					<li><a href="${contextRoot}/">首頁</a></li>
					<li>會員中心</li>
				</ol>
				<h2>二手賣場-得標紀錄</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->
		

		<div class="container mx-auto">
			<%-- 顯示提示訊息 --%>
			<jsp:include page="../../message.jsp"/>

			<section class="row mt-3">
				<div class="col-12">
					<c:choose>
						<c:when test="${dealRecords.size() != 0}">
							<table class="table table-bordered table-striped align-middle text-center">
								<thead>
									<tr>
									<th>商品圖片</th>
									<th>商品名稱</th>
									<th>商品種類</th>
									<th>商品底價</th>
									<th>得標價格</th>
									<th>建立日期</th>
									<th>是否已付款</th>
									<th>結帳</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach items="${dealRecords}" var="d">
										<c:set var="bidProduct" value="${d.bidProduct}"/>
										<tr>
											<td>
												<a href="${contextRoot}/bidProducts/${bidProduct.id}">
													<c:choose>
														<c:when test="${bidProduct.image.contains('http')}">
															<img src="${bidProduct.image}"
																 style="opacity: 0; transition: opacity 0.5s ease-in-out; width: 3rem"
																 onload="this.style.opacity='1';"
																 alt="BidProduct-image">
														</c:when>
														<c:otherwise>
															<img src="${contextRoot}/${bidProduct.image}"
																 style="opacity: 0; transition: opacity 0.5s ease-in-out; width: 3rem"
																 onload="this.style.opacity='1';"
																 alt="BidProduct-image">
														</c:otherwise>
													</c:choose>
												</a>
											</td>
											<td>${bidProduct.name}</td>
											<td>${bidProduct.category.name}</td>
											<td>${bidProduct.basePrice}</td>
											<td>${d.dealPrice}</td>
											<td>
												<fmt:formatDate value="${d.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
											</td>
											<td>
												<c:choose>
													<c:when test="${d.isPaid}">Y</c:when>
													<c:otherwise>N</c:otherwise>
												</c:choose>
											</td>
											<td>
												<c:choose>
													<c:when test="${d.isPaid}">
														<a href="#" class="btn btn-outline-dark disabled"><i class="bi bi-cash-coin"></i></a>
													</c:when>
													<c:otherwise>
														<form action="${contextRoot}/front/shoppingcart/bid" style="margin: auto;">
							                        		<input type="hidden" name="productId" value="${bidProduct.id}">
							                            	<button class="btn btn-outline-success"><i class="bi bi-cash-coin"></i></button>
						                            	</form>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:when>
						<c:otherwise>
							<h1 class="text-center">查無資料</h1>
						</c:otherwise>
					</c:choose>
				</div>
			</section>
		</div>
	</main>

	<jsp:include page="../layouts/footer.jsp" />


	<!-- Vendor JS Files -->
	<script
		src="${contextRoot}/styles/front/assets/vendor/purecounter/purecounter_vanilla.js"></script>
	<script
		src="${contextRoot}/styles/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${contextRoot}/styles/front/assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script
		src="${contextRoot}/styles/front/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script
		src="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script
		src="${contextRoot}/styles/front/assets/vendor/waypoints/noframework.waypoints.js"></script>
	<script
		src="${contextRoot}/styles/front/assets/vendor/php-email-form/validate.js"></script>
	<!-- Template Main JS File -->
	<script src="${contextRoot}/styles/front/assets/js/main.js"></script>
</body>

</html>
