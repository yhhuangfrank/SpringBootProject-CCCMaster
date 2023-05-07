<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>會員登入</title>
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
	
	
	
	
	<style>
		.form-login {
	      background-color: #ffffff;
	      border-radius: 10px;
	      padding: 40px;
	      box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
	    }
	    
	    .form-control:focus {
	      border-color: #e96b56;
	      box-shadow: 0 0 0 0.2rem rgba(233, 107, 86, 0.25);
	    }
	    
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

	<jsp:include page="../layouts/topbar.jsp" />

	<jsp:include page="../layouts/header.jsp" />

	<main id="main">

		<!-- ======= Breadcrumbs ======= -->
		<section id="breadcrumbs" class="breadcrumbs">
			<div class="container">

				<ol>
					<li><a href="${contextRoot}/">首頁</a></li>
					<li>會員登入</li>
				</ol>
				<h2>登入</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->


		<section id="contact" class="contact">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-4">
					
						<c:if test="${loginFailed}">
							<div class="alert alert-danger alert-dismissible fade show" role="alert">
							  登入失敗！請檢查您的帳號和密碼是否正確。
							  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
							</div>
						</c:if>
						
						<form action="${contextRoot}/login" method="post" class="form-login">
							<input name="referer" type="hidden" value="${referer}"/>	<!-- 這個標籤為程式內部傳遞參數用，不顯示在前端畫面上 -->
							<h3 class="text-center mb-4">歡迎登入山西達人</h3>
				
							<div class="form-group">
								<label for="accountNumber">帳號</label>
								<input required name="accountNumber" type="text" class="form-control" id="accountNumber" placeholder="輸入email"/>
							</div>
							<div class="form-group">
								<label for="password">密碼</label>
								<input required name="password" type="password" class="form-control" id="password" placeholder="輸入密碼"/>
							</div>
							<div class="text-center">
								<button type="submit" class="btn-primary mt-4">登入</button>
							</div>
						</form>
						<div class="text-center mt-4">
							<a href="#">忘記密碼</a> <span class="mx-2">|</span> <a href="#">註冊帳號</a>
						</div>
					</div>
				</div>
			</div>
		</section>
			
			
			
			
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
