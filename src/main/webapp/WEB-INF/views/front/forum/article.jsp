<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html lang="en">

<head>
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

<main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">

            <ol>
                <li><a href="${contextRoot}/">首頁</a></li>
                <li>文章</li>
            </ol>


        </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= About Section ======= -->
    <section id="about" class="about">
        <div class="container">
            <table class="table table-bordered" style="text-align: center">
                <thead>
                <tr class="fs-10 align-content-center ">
                    <th style="background:#e96b56; text-align: center; color:white" scope="col">Photo</th>
                    <th style="background:#e96b56; text-align: center; color:white" scope="col">Title</th>
                    <th style="background:#e96b56; text-align: center; color:white" scope="col">Created</th>
                    <th style="background:#e96b56; text-align: center; color:white" scope="col">Content</th>
                </tr>
                </thead>
                <tbody>
                        <c:forEach items="${page.content}" var="p">
                <tr>
                    <td class="align-content-center">
                        <img style="width: 300px;" class="img-thumbnail mb-1 "
                             src="${contextRoot}/article/image/${p.articleId}"/>
                    </td>
                    <td class="align-content-center">
                        <a id="articleBtn" href="${contextRoot}/articleDetail/${p.articleId}"
                           title="More Details">${p.title}</a>
                    </td>
                    <td class="align-content-center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${latest.added}"/></td>
                    <td style="text-align: left "; class="align-content-center">${p.content}</td>

                </tr>

                        </c:forEach>


            </table>


        </div>
        <nav aria-label="..." class="d-flex justify-content-center mt-3">
            <ul class="pagination">
                <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
                    <c:choose>
                        <c:when test="${page.number eq pageNumber-1}">
                            <li class="page-item active" aria-current="page">
                                <a class="page-link" href="#">${pageNumber}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link"
                                   href="${contextRoot}/articles?p=${pageNumber}">${pageNumber}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${pageNumber eq page.totalPages}">

                    </c:if>
                </c:forEach>
            </ul>
        </nav>


        <%--  Pagination   --%>
        <nav aria-label="Page navigation example" class="mt-4">
            <ul class="pagination justify-content-center align-items-center my-0">
            </ul>
        </nav>
    </section><!-- End About Section -->


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

</body>

</html>
```