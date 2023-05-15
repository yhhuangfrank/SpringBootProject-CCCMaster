<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>會員中心</title>
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
				<h2>首頁</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->


		<section id="services" class="services">
	      	<div class="container">
	
		        <div class="row">
			        <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
				        <div class="icon-box">
				        	<div class="icon"><i class="bi bi-person-vcard"></i></div>
				        	<h4><a href="">我的資料</a></h4>
				        	<p>Voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi</p>
				        </div>
			        </div>
		
			        <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-md-0">
				        <div class="icon-box">
				        	<div class="icon"><i class="bx bx-file"></i></div>
				        	<h4><a href="">我的優惠券</a></h4>
				        	<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore</p>
				   	    </div>
			        </div>
		
			        <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-lg-0">
				        <div class="icon-box">
				        	<div class="icon"><i class="bx bx-tachometer"></i></div>
				        	<h4><a href="">商城購買紀錄</a></h4>
				        <p>	Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia</p>
				        </div>
			        </div>
		
			        <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
				        <div class="icon-box">
				        	<div class="icon"><i class="bx bx-world"></i></div>
					        <h4><a href="">二手賣場得標紀錄</a></h4>
				        	<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis</p>
				        </div>
			        </div>
		
			        <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
				        <div class="icon-box">
				        	<div class="icon"><i class="bx bx-slideshow"></i></div>
				        	<h4><a href="">我的最愛</a></h4>
				        	<p>Quis consequatur saepe eligendi voluptatem consequatur dolor consequuntur</p>
				        </div>
			        </div>
		
			        <div class="col-lg-4 col-md-6 d-flex align-items-stretch mt-4">
				        <div class="icon-box">
				        	<div class="icon"><i class="bx bx-arch"></i></div>
				        	<h4><a href="">瀏覽紀錄</a></h4>
				        	<p>Modi nostrum vel laborum. Porro fugit error sit minus sapiente sit aspernatur</p>
				        </div>
			        </div>
		
		        </div>
	
	      	</div>
    	</section><!-- End Services Section -->
		
			
			
			
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.3.6/axios.min.js"></script>
	<script src="${contextRoot}/js/customer/checkSignup.js"></script>
</body>

</html>
