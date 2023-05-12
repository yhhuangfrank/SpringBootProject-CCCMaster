<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>test</title>
    <script src="https://cdn.tiny.cloud/1/eietea4ay3bbc7u6eb00o3821yablr9864z3qbin2vszwiq3/tinymce/6/tinymce.min.js"
            referrerpolicy="origin"></script>


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


        <h1>論壇管理系統</h1>


        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/">首頁</a></li>
                <li class="breadcrumb-item">文章管理</li>
                <li class="breadcrumb-item active">編輯文章</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->


    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">修改文章</h5>
                        <div class="row mb-3">

                            <form:form class="form-control" modelAttribute="article"
                            method="put" action="${contextRoot}/admin/articles/edit" enctype="multipart/form-data">
                            <form:input type="hidden" path="articleId"/>



                            <div class="col-sm-10 d-flex mb-3">
                                <label for="inputTitle" class="col-sm-2 col-form-label">文章名稱</label>
                                <form:input type="text" path="title" class="form-control" id="inputTitle"></form:input>

                                <br>
                                    <%--                <form:textarea cssStyle="width: 610px;height: 300px"  type="text" path="content"  id="content"></form:textarea>--%>
                            </div>
                                <div class="col-sm-10">
                                    新增圖片<form:input class="form-control" type="file" id="formFile" path="imageFile"></form:input>
                                </div>


                        </div>
                        <form:textarea type="text" path="content" id="content"></form:textarea>

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
<%--<script src="${contextRoot}/styles/back/assets/vendor/tinymce/tinymce.min.js"></script>--%>
<script src="${contextRoot}/styles/back/assets/vendor/php-email-form/validate.js"></script>


<!-- Template Main JS File -->
<script src="${contextRoot}/styles/back/assets/js/main.js"></script>

<script>
    tinymce.init({
        selector: 'textarea#content',
        plugins: 'anchor autolink charmap codesample emoticons  link lists  searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode  tinycomments tableofcontents footnotes mergetags autocorrect typography inlinecss',
        // plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tinycomments tableofcontents footnotes mergetags autocorrect typography inlinecss',
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
