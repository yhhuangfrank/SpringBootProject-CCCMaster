<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <html>

      <head>
        <title>新增職位資料</title>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

        <!-- Favicons -->
        <link href="${contextRoot}/styles/back/assets/img/favicon.png" rel="icon">
        <link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link
          href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="${contextRoot}/styles/back/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextRoot}/styles/back/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="${contextRoot}/styles/back/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="${contextRoot}/styles/back/assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="${contextRoot}/styles/back/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="${contextRoot}/styles/back/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="${contextRoot}/styles/back/assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="${contextRoot}/styles/back/assets/css/style.css" rel="stylesheet">
      </head>

      <body>


        <main>
		    <div class="container">
		
		      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
		        <div class="container">
		          <div class="row justify-content-center">
		            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
		
		              <div class="d-flex justify-content-center py-4">
		                <a href="#" class="logo d-flex align-items-center w-auto">
		                  <img src="assets/img/logo.png" alt="">
		                  <span class="d-none d-lg-block">山西達人</span>
		                </a>
		              </div><!-- End Logo -->
		
		                <%-- 顯示登入相關提示訊息 --%>
		                <jsp:include page="../../message.jsp"/>

		              <div class="card mb-3">
		
		                <div class="card-body">
		
		                  <div class="pt-4 pb-2">
		                    <h4 class="card-title text-center pb-0 fs-4">員工登入系統</h4>
		                    <p class="text-center small">早安~歡迎上班~</p>
		                    <p class="text-center small">努力工作，努力吃飯；不工作的人沒有飯吃</p>
		                  </div>
		
		                  <form method="post" action="${contextRoot}/admin/login" class="row g-3 needs-validation" novalidate>
		
		                    <div class="col-12">
		                      <label for="employeeId" class="form-label">員工編號</label>
		                      <div class="input-group has-validation">
		                        <input type="number" name="employeeId" class="form-control" id="employeeId" required>
		                        <div class="invalid-feedback">你尚未輸入員工編號</div>
		                      </div>
		                    </div>
		
		                    <div class="col-12">
		                      <label for="password" class="form-label">密碼</label>
		                      <input type="password" name="password" class="form-control" id="password" required>
		                      <div class="invalid-feedback">你尚未輸入密碼</div>
		                    </div>
		
		                    <div class="col-12">
		                      <button class="btn btn-primary w-100" type="submit">上班去~</button>
		                    </div>
		                    <div class="col-12">
		                      	<a style="color: white" href="${contextRoot}/admin/cancelLogin" class="btn btn-secondary w-100">不要好了，我想請假</a>
		                    </div>
		                  </form>
		
		                </div>
		              </div>
		
		              <div class="credits">
		                <!-- All the links in the footer should remain intact. -->
		                <!-- You can delete the links only if you purchased the pro version. -->
		                <!-- Licensing information: https://bootstrapmade.com/license/ -->
		                <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
		                Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
		              </div>
		
		            </div>
		          </div>
		        </div>
		
		      </section>
		
		    </div>
		  </main><!-- End #main -->



        <!-- Vendor JS Files -->
        <script src="${contextRoot}/styles/back/assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="${contextRoot}/styles/back/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="${contextRoot}/styles/back/assets/vendor/chart.js/chart.umd.js"></script>
        <script src="${contextRoot}/styles/back/assets/vendor/echarts/echarts.min.js"></script>
        <script src="${contextRoot}/styles/back/assets/vendor/quill/quill.min.js"></script>
        <script src="${contextRoot}/styles/back/assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="${contextRoot}/styles/back/assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="${contextRoot}/styles/back/assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="${contextRoot}/styles/back/assets/js/main.js"></script>
        
        <c:if test="${lazy_float}">
			<div id="failed-msg-float" class="alert alert-danger position-fixed top-50 start-50 translate-middle d-none" role="alert">
		 		${lazyMsg_float}
			</div>
		 	<script>
				// 顯示成功訊息框-浮動
				document.querySelector('#failed-msg-float').classList.remove('d-none');
				// 設定 2 秒後淡出消失
				setTimeout(function() {
				document.querySelector('#failed-msg-float').classList.add('fade');
				}, 2000);
			</script>
		</c:if>
      </body>

      </html>