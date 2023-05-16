<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>我的賣場</title>
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
				<h2>我的賣場</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->
		

		<div class="container mx-auto">
			<%-- 顯示提示訊息 --%>
			<jsp:include page="../../message.jsp"/>

			<a href="${contextRoot}/bidProducts/create" class="btn btn-primary" style="background-color: #e96b56">新增商品</a>
			<section class="row mt-3">
				<div class="col-12">
					<c:choose>
						<c:when test="${bidProducts != null}">
							<table class="table table-bordered table-striped align-middle text-center">
								<thead>
									<tr>
									<th>商品圖片</th>
									<th>商品名稱</th>
									<th>商品種類</th>
									<th>商品底價</th>
									<th>目前價格</th>
									<th>建立日期</th>
									<th>操作</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach items="${bidProducts}" var="b">
										<tr>
											<td>
												<a href="${contextRoot}/bidProducts/${b.id}">
													<c:choose>
														<c:when test="${b.image.contains('http')}">
															<img src="${b.image}"
																 style="opacity: 0; transition: opacity 0.5s ease-in-out; width: 3rem"
																 onload="this.style.opacity='1';"
																 alt="BidProduct-image">
														</c:when>
														<c:otherwise>
															<img src="${contextRoot}/${b.image}"
																 style="opacity: 0; transition: opacity 0.5s ease-in-out; width: 3rem"
																 onload="this.style.opacity='1';"
																 alt="BidProduct-image">
														</c:otherwise>
													</c:choose>
												</a>
											</td>
											<td>${b.name}</td>
											<td>${b.category.name}</td>
											<td>${b.basePrice}</td>
											<td>${b.bidPrice}</td>
											<td>
												<fmt:formatDate value="${b.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
											</td>
											<td>
												<a href="${contextRoot}/bidProducts/${b.id}/edit" class="btn btn-outline-dark"><i class="bi bi-pencil"></i></a>
												<button class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#modal-${b.id}"><i class="bi bi-trash"></i></button>
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

	<%-- Modals	--%>
	<c:forEach items="${bidProducts}" var="b">
		<div class="modal fade" id="modal-${b.id}" tabindex="-1">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title fw-bold">刪除確認</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						確定刪除 <strong>${b.name}</strong> 嗎?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">返回</button>
						<form:form action="${contextRoot}/bidProducts/${b.id}" method="DELETE">
							<button type="submit" class="btn btn-danger">刪除</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

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
