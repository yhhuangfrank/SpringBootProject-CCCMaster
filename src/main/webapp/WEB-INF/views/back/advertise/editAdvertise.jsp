<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html lang="en">
<head>



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


        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item">Forms</li>
                <li class="breadcrumb-item active">Editors</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->


    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">更新廣告</h5>
                        <div class="row mb-3">

                            <form:form method="put" modelAttribute="advertise"
                                       action="${contextRoot}/admin/advertises/edit" enctype="multipart/form-data">

                                <div class="row mb-3">
                                    <label for="startDate" class="col-sm-2 col-form-label fw-bold">廣告上架時間</label>
                                    <div class="col-sm-10">
                                        <form:input path="startTime" id="startDate" type="datetime-local" class="form-control"/>
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label for="endDate" class="col-sm-2 col-form-label fw-bold">廣告下架時間</label>
                                    <div class="col-sm-10">
                                        <form:input path="endTime" id="endDate" type="datetime-local" class="form-control"/>
                                    </div>
                                </div>


                        </div>


                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"></label>
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">Submit Form</button>
                        </form:form>

                    </div>


                </div>
            </div>
        </div>


    </section>


</main><!-- End #main -->


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
