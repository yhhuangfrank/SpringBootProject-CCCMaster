<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html lang="en">

<head>
    <script src="https://<hostname.tld>/tinymce.min.js" referrerpolicy="origin"></script>
    <script src="https://cdn.tiny.cloud/1/rhx9ul0mmewwi6kmsk26ne06bj1vj10ceyrs1tviq0jqepq3/tinymce/6/plugins.min.js" referrerpolicy="origin"></script>

    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>論壇</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

    <!-- Favicons -->
    <link href="${contextRoot}/styles/front/assets/img/favicon.png" rel="icon">
    <link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${contextRoot}/styles/front/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">

</head>

<body>

<jsp:include page="../layouts/topbar.jsp"/>

<jsp:include page="../layouts/header.jsp"/>

<main id="main" class="main">

    <div class="pagetitle">



        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/">首頁</a></li>
                <li class="breadcrumb-item">文章管理</li>
                <li class="breadcrumb-item active">新增文章</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->


    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">新增文章</h5>
                        <div class="row mb-3">

                            <form:form method="post" modelAttribute="article"
                                       action="${contextRoot}/admin/articles/create" enctype="multipart/form-data">

                            <div class="col-sm-10 d-flex mb-3">
                                <label for="inputTitle" class="col-sm-2 col-form-label">文章名稱</label>
                                <form:input type="text" path="title" class="form-control" id="inputTitle"></form:input>
                                    <%--                                <form:input type="checkbox" path="productList" class="form-control" id="inputTitle"></form:input>--%>
                                <br>
                                    <%--                <form:textarea cssStyle="width: 610px;height: 300px"  type="text" path="content"  id="content"></form:textarea>--%>
                            </div>
                            <div class="col-sm-10">
                                新增圖片<form:input class="form-control" type="file" id="formFile" path="imageFile"></form:input>
                            </div>


                        </div>
                        <form:textarea type="text" path="content" id="contentFront"></form:textarea>

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

<jsp:include page="../layouts/footer.jsp"/>


<!-- Vendor JS Files -->
<script src="${contextRoot}/styles/front/assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/waypoints/noframework.waypoints.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${contextRoot}/styles/front/assets/js/main.js"></script>

<script>
    tinymce.init({
        selector: 'textarea#contentFront',
        plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tinycomments tableofcontents footnotes mergetags autocorrect typography inlinecss',
        toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | addcomment showcomments | spellcheckdialog a11ycheck typography | align lineheight | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
        tinycomments_mode: 'embedded',
        tinycomments_author: 'Author name',
        mergetags_list: [
            { value: 'First.Name', title: 'First Name' },
            { value: 'Email', title: 'Email' },
        ]
    });
</script>

</body>

</html>
