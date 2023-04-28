<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>新增優惠券</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

    <!-- Favicons -->
    <link href="${contextRoot}/styles/back/assets/img/favicon.png" rel="icon">
    <link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
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

<jsp:include page="../layouts/header.jsp"/>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>新增優惠券</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/">首頁</a></li>
                <li class="breadcrumb-item">優惠券發放</li>
                <li class="breadcrumb-item active">新增優惠券</li>
            </ol>
        </nav>
    </div>
    <section class="section">
        <div class="row">
            <div class="col-lg-6 mx-auto">

                <div class="card" style="width: 35rem;">
                    <div class="card-body">
                        <h5 class="card-title text-center fw-bold">新增優惠券</h5>
                        
              <form:form method="post" modelAttribute="coupon" action="${contextRoot}/coupons/create">
                <div class="row mb-3">
                  <label for="inputName" class="col-sm-2 col-form-label fw-bold" style="text-align: right;">名稱</label>
                  <div class="col-sm-10">
                    <form:input type="text" path="couponname" class="form-control" id="inputName"
                    required="true"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputconvertid" class="col-sm-2 col-form-label fw-bold" style="text-align: right;">兌換代碼</label>
                  <div class="col-sm-10">
                    <form:input type="text" path="convertid" class="form-control" id="inputconvertid"
                    required="true"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputcouponamount" class="col-sm-2 col-form-label fw-bold" style="text-align: right;">金額</label>
                  <div class="col-sm-10">
                    <form:input type="text" path="couponamount" class="form-control" id="inputcouponamount"
                    required="true"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="floatingInput" class="col-sm-2 col-form-label fw-bold" style="text-align: right;">使用起始時間</label>
                  <div class="form-floating col-sm-10">
                    <form:input type="text" path="startdate" class="form-control" id="floatingInputValue" 
                    placeholder="格式:2023-01-01 12:00:00" required="true"></form:input>
                    <label for="floatingInputValue" style="margin-left: 5px">範例:2023-01-01 12:00:00</label>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputenddate" class="col-sm-2 col-form-label fw-bold" style="text-align: right;">使用結束時間</label>
                  	<div class="form-floating col-sm-10">
	                    <form:input type="text" path="enddate" class="form-control" id="floatingInputValue" 
	                    placeholder="格式:2023-01-01 12:00:00" required="true"></form:input>
	                    <label for="floatingInputValue" style="margin-left: 5px">範例:2023-01-01 12:00:00</label>
                 	 </div>                 
                </div>
                <div class="row mb-3">
                  <label for="inputinstructions" class="col-sm-2 col-form-label fw-bold" style="text-align: right;">說明</label>
                  <div class="col-sm-10">
                    <form:textarea class="form-control" path="instructions" style="height: 100px" id="inputinstructions"></form:textarea>
                  </div>
                </div>

                <div >
                  <label class="col-sm-2 col-form-label"></label>
                  <div style="text-align: center;">
                    <button type="submit" class="btn btn-primary">送出</button>
                  </div>
                </div>

              </form:form>
              </div>
                </div>

            </div>
        </div>
    </section>
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
