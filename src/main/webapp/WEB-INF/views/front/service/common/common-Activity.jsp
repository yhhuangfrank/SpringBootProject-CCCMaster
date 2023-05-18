<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>山西達人-常見問題</title>
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

    <!-- =======================================================
    * Template Name: Eterna
    * Updated: Mar 10 2023 with Bootstrap v5.2.3
    * Template URL: https://bootstrapmade.com/eterna-free-multipurpose-bootstrap-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

 
  <jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/topbar.jsp"/>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/header.jsp"/>

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <ol>
              <li><a href="${contextRoot}/">首頁</a></li>
              <li>聯絡客服</li>
              <li>常見問題</li>
            </ol>
            <h2>常見問題</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container">

        <div class="row">
              <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                <div class="icon-box" onclick="window.open('${contextRoot}/Service/common','_self' )" style="cursor: pointer;">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bxl-dribbble"></i></div>
                  <h4>熱門問題</h4>
                </div>
                <div class="icon-box" onclick="window.open('${contextRoot}/Service/common/order','_self' )" style="cursor: pointer;">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4>訂購付款</h4>
                  <p></p>
                </div>
                <div class="icon-box" onclick="window.open('${contextRoot}/Service/common/delivery','_self' )" style="cursor: pointer;">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4>配送說明</h4>
                  <p></p>
                </div>
                <div class="icon-box" onclick="window.open('${contextRoot}/Service/common/Refund','_self' )" style="cursor: pointer;">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4>售後退款</h4>
                  <p></p>
                </div>
                <div class="icon-box" onclick="window.open('${contextRoot}/Service/common/discount','_self' )" style="cursor: pointer;">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4>購物優惠</h4>
                  <p></p>
                </div>
                <div class="icon-box" onclick="window.open('${contextRoot}/Service/common/Activity','_self' )" style="cursor: pointer;">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4>活動相關</h4>
                  <p></p>
                </div>
                <div class="icon-box" onclick="window.open('${contextRoot}/Service/common/Account','_self' )" style="cursor: pointer;">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4>會員帳號</h4>
                  <p></p>
                </div>
              </div>


        </div>
        </div>

    </section><!-- End Services Section -->

    <!-- ======= Our Skills Section ======= -->
    <section id="skills" class="skills">
      <div class="container">

        <div class="section-title">
          <h2>活動相關</h2> </div>

             
             
            <!-- Accordion without outline borders -->
            <div class="accordion" id="accordionExample">
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                    <strong>Q1、活動總攬</strong>
                  </button>
                </h2>

                <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>目前山西達人暫無活動</strong>
                  </div>
                </div>
              </div>
              <!-- 我是分隔線 -->
                
                </div>
              </div><!-- End Accordion without outline borders -->
    
    </section><!-- End Our Skills Section -->

  </main><!-- End #main -->
  
    
<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp"/>
  

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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
