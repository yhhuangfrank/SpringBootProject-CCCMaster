<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>職位資料</title>
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
			<h1>職位資料</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item">員工管理</li>
					<li class="breadcrumb-item active">職位資料</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">職位資料</h5>

							<!-- Table with stripped rows -->
							<table class="table datatable table-hover">
								<thead>
									<tr>
										<th scope="col">職位編號</th>
										<th scope="col">職位名稱</th>
										<th scope="col">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="position" items="${positions}">
										<tr>
											<th scope="row">${position.positionId}</th>
											<td>${position.positionName}</td>
											<td>
												<div class="d-flex">
													<form action="${contextRoot}/admin/positions/delete"
														method="post">
														<input type="hidden" name="_method" value="delete" /> <input
															type="hidden" name="id" value="${position.positionId}" />
														<button type="submit" class="btn btn-secondary btn-sm">
														<i class="bi bi-pencil-square"></i>編輯
														</button>
													</form>
													<form action="${contextRoot}/admin/positions/delete"
														method="post">
														<input type="hidden" name="_method" value="delete" /> <input
															type="hidden" name="id" value="${position.positionId}" />
														<button type="submit" class="btn btn-outline-danger btn-sm ms-2">
														<i class="bi bi-exclamation-octagon"></i>刪除
														</button>
														
														
														
														
														
<!-- ===============這裡開始實驗=================== -->
<!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Open modal for @mdo</button> -->

<!-- <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
<!--   <div class="modal-dialog"> -->
<!--     <div class="modal-content"> -->
<!--       <div class="modal-header"> -->
<!--         <h1 class="modal-title fs-5" id="exampleModalLabel">New message</h1> -->
<!--         <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
<!--       </div> -->
<!--       <div class="modal-body"> -->
<%--         <form> --%>
<!--           <div class="mb-3"> -->
<!--             <label for="recipient-name" class="col-form-label">Recipient:</label> -->
<!--             <input type="text" class="form-control" id="recipient-name"> -->
<!--           </div> -->
<!--           <div class="mb-3"> -->
<!--             <label for="message-text" class="col-form-label">Message:</label> -->
<!--             <textarea class="form-control" id="message-text"></textarea> -->
<!--           </div> -->
<%--         </form> --%>
<!--       </div> -->
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button> -->
<!--         <button type="button" class="btn btn-primary">Send message</button> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!-- ===========實驗到這================ -->
													</form>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->

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