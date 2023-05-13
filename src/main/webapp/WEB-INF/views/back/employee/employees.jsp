<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>員工資料</title>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- Favicons -->
<link href="${contextRoot}/styles/back/assets/img/favicon.png"
	rel="icon">
<link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="${contextRoot}/styles/back/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/back/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/back/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/back/assets/vendor/quill/quill.snow.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/back/assets/vendor/quill/quill.bubble.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/back/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link
	href="${contextRoot}/styles/back/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${contextRoot}/styles/back/assets/css/style.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="../layouts/header.jsp" />

	<main id="main" class="main">
		<div class="pagetitle">
			<h1>員工資料</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item">員工管理</li>
					<li class="breadcrumb-item active">員工資料</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<a class="float-end mt-2 btn btn-primary" href="${contextRoot}/admin/employees/create">
		                        新增員工資料
		                    </a>
							<h5 class="card-title">員工資料</h5>

							<!-- Table with stripped rows -->
							<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col">員工編號</th>
										<th scope="col">姓名</th>
										<th scope="col">職位</th>
										<th scope="col">手機號碼</th>
										<th scope="col">身分證字號</th>
										<th scope="col">登入密碼</th>
										<th scope="col">到職日期</th>
										<th scope="col">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="employee" items="${page.content}">
										<tr>
											<th scope="row">${employee.employeeId}</th>
											<td>${employee.employeeName}</td>
											<td>${employee.positionId.positionName}</td>
											<td>${employee.phoneNumber}</td>
											<td>${employee.idNumber}</td>
											<td>${employee.password}</td>
											<td>${employee.hireDate}</td>
											<td>
												<div class="d-flex">
													<form action="${contextRoot}/admin/employees/edit">
														<input type="hidden" name="id" value="${employee.employeeId}" />
														<button type="submit" class="btn btn-secondary btn-sm">
														<i class="bi bi-pencil-square"></i>編輯
														</button>
													</form>
													<form action="${contextRoot}/admin/employees/delete" method="post">
														<input type="hidden" name="_method" value="delete" />
														<input type="hidden" name="id" value="${employee.employeeId}" />
														<button type="submit" class="btn btn-outline-danger btn-sm ms-2">
														<i class="bi bi-exclamation-octagon"></i>刪除
														</button>
													</form>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->
							<!-- 以下為分頁按紐 -->
							<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
								<c:choose>
									<c:when test="${page.number != pageNumber-1 }">
										<a href="${contextRoot}/admin/employees?p=${pageNumber}">${pageNumber}</a>
									</c:when>
									<c:otherwise>${pageNumber}</c:otherwise>
								</c:choose>
							<c:if test="${pageNumber != page.totalPages }">-</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="../layouts/aside.jsp" />

	<jsp:include page="../layouts/footer.jsp" />

	<!-- Vendor JS Files -->
	<script
		src="${contextRoot}/styles/back/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script
		src="${contextRoot}/styles/back/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${contextRoot}/styles/back/assets/vendor/chart.js/chart.umd.js"></script>
	<script
		src="${contextRoot}/styles/back/assets/vendor/echarts/echarts.min.js"></script>
	<script
		src="${contextRoot}/styles/back/assets/vendor/quill/quill.min.js"></script>
	<script
		src="${contextRoot}/styles/back/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script
		src="${contextRoot}/styles/back/assets/vendor/tinymce/tinymce.min.js"></script>
	<script
		src="${contextRoot}/styles/back/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="${contextRoot}/styles/back/assets/js/main.js"></script>
</body>

</html>