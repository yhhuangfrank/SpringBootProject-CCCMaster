<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>我的資料</title>
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
		.form-signup {
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
					<li>會員中心</li>
				</ol>
				<h2>我的資料</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->


		<section id="contact" class="contact">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6">
					
						<%-- 【暫時用不到】顯示提示訊息 --%>
						<jsp:include page="../../message.jsp"/>
						
						<form:form action="${contextRoot}/center/profile" method="put" modelAttribute="customer" class="form-signup">
							<h2 style="font-family:Cursive;font-size:50px;" class="text-center mb-4">山西達人</h2>
							<h3 class="text-center mb-4">我的資料</h3>
				
							<div class="form-group mb-2">
								<label for="emailInput">電子郵件</label>
								<form:input required="true" path="email" type="email" class="form-control mb-2" id="emailInput" placeholder="輸入email"/>
								<span id="emailSpan"></span>
							</div>
							<div class="form-group mb-2">
								<label for="nameInput">暱稱</label>
								<form:input required="true" path="name" type="text" class="form-control mb-2" id="nameInput" placeholder="輸入暱稱"/>
								<span id="nameSpan"></span>
							</div>
							<div class="form-group mb-2">
								<label for="password">密碼</label>
								<form:input required="true" path="password" type="password" class="form-control" id="password" placeholder="輸入密碼"/>
							</div>
							<div class="form-group mb-2">
								<label for="passwordAgainInput">再次輸入密碼</label>
								<input required type="password" class="form-control mb-2" id="passwordAgainInput" placeholder="再次輸入密碼"/>
								<span id="passwordAgainSpan"></span>
							</div>
							<div class="form-group">
								<label for="phoneNumberInput">手機號碼</label>
								<form:input required="true" path="phoneNumber" type="tel" class="form-control mb-2" id="phoneNumberInput" pattern="[0]{1}[9]{1}[0-9]{8}" placeholder="格式:09XXXXXXXX"/>
								<span id="phoneNumberSpan"></span>
							</div>
							<div class="form-group">
								<label for="point">擁有的點數</label>
								<input disabled="disabled" value="${customer.point}" type="text" class="form-control mb-2" id="point"/>
							</div>
							<div class="text-center">
								<button id="submitButton" type="submit" class="btn-primary mt-4">確認變更</button>
								<a class="btn btn-secondary" href="${contextRoot}/center">取消並返回</a>
							</div>
						</form:form>
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
	<!-- ajax -->
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.3.6/axios.min.js"></script> -->
<%-- 	<script src="${contextRoot}/js/customer/checkSignup.js"></script> --%>
</body>

</html>
