<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>廣告</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

  <!-- Favicons -->
  <link href="${contextRoot}/styles/front/assets/img/favicon.png" rel="icon">
  <link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

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
        <li>廣告</li>
      </ol>

    </div>
  </section><!-- End Breadcrumbs -->

  <!-- ======= About Section ======= -->
  <section id="about" class="about">
    <div class="container">

        <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner ">
                <c:forEach items="${productImageIds}" var="productImageIds">
                <div class="carousel-item active" data-bs-interval="3000">
                    <img src="${contextRoot}/product/mainImage/${productImageIds}" class="d-block w-100" alt="...">
                </div>
                </c:forEach>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>




    </div>
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
