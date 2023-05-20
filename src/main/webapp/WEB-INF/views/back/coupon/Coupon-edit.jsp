<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>編輯優惠券</title>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

  <!-- Favicons -->
  <link href="${contextRoot}/styles/back/assets/img/favicon.png" rel="icon">
  <link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

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

  <jsp:include page="../layouts/header.jsp"/>

  <main id="main" class="main">
              <h1 class="card-title fs-1">編輯優惠券</h1>

              <form:form method="put" modelAttribute="coupon" action="${contextRoot}/coupons/edit">
                <div class="row mb-3">
                  <label for="inputcouponid" class="col-sm-2 col-form-label">優惠券代碼</label>
                  <div class="col-sm-10 fs-5">
                    <form:input type="text" path="couponid" class="form-control" value="${coupon.couponid}"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputcouponname" class="col-sm-2 col-form-label">優惠券名稱</label>
                  <div class="col-sm-10 fs-5">
					<form:input type="text" path="couponname" class="form-control" value="${coupon.couponname}" id="inputcouponname"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputconvertid" class="col-sm-2 col-form-label">兌換代碼名稱</label>
                  <div class="col-sm-10 fs-5">
                    <form:input type="text" path="convertid" class="form-control" value="${coupon.convertid}" id="inputconvertid"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputstartdate" class="col-sm-2 col-form-label">使用起始時間</label>
                  <div class="col-sm-10 fs-5">
                    <form:input type="text" path="startdate" class="form-control" value="${coupon.startdate}" id="inputstartdate"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputenddate" class="col-sm-2 col-form-label">使用結束時間</label>
                  <div class="col-sm-10">
                  <form:input type="text" path="enddate" class="form-control" value="${coupon.enddate}" id="inputenddate"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputcouponamount" class="col-sm-2 col-form-label">優惠券金額</label>
                  <div class="col-sm-10">
                   <form:input type="text" path="couponamount" class="form-control" value="${coupon.couponamount}" id="inputcouponamount"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputinstructions" class="col-sm-2 col-form-label">使用說明</label>
                  <div class="col-sm-10 fs-5">
                    <form:textarea path="instructions" class="form-control" style="height: 100px" value="${coupon.instructions}" id="inputinstructions"></form:textarea>
                  </div>
                </div>
                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label"></label>
                  <div class="col-sm-10">
                  	<button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#cencel">取消</button>
                    	<div class="modal fade" id="cencel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
								<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">優惠券資料</h5>
									<button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
									</button>
									</div>
									<div class="modal-body">
									<h3>是否取消更新?</h3>
									</div>
									<div class="modal-footer">
									<input type="reset" class="btn btn-secondary" data-bs-dismiss="modal" value="否">
									<input type="submit" class="btn btn-primary" value="確定">
								</div>
								</div>
							</div>
						</div>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#update">送出</button>
                    	<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
								<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">訂單詳細資料</h5>
									<button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
									</button>
									</div>
									<div class="modal-body">
									<h3>是否確定更新?</h3>
									</div>
									<div class="modal-footer">
									<input type="reset" class="btn btn-secondary" data-bs-dismiss="modal" value="否">
									<input type="submit" class="btn btn-primary" value="確定">
								</div>
								</div>
							</div>
						</div>                    	
                  </div>
                </div>

              </form:form>

  </main>

  <jsp:include page="../layouts/aside.jsp"/>

  <jsp:include page="../layouts/footer.jsp"/>

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
</body>
</html>
