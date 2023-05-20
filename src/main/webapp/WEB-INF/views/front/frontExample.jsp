<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Example</title>
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

  <style>
    .slider_container {
      margin: 30px auto;
      width: 420px;
      height: 280px;
      overflow: hidden;
      position: relative;
      /*border: 10px solid;*/
      /*border-top-color: #856036;*/
      /*border-left-color: #5d4426;*/
      /*border-bottom-color: #856036;*/
      /*border-right-color: #5d4426;*/
      /*background-color: #f5f5f5;*/
    }
    .slider_container:before {
      content: '';
      display: block;
      position: absolute;
      top: 0;
      left: -100%;
      opacity: 1;
      filter: alpha(opacity=100);
      width: 100%;
      height: 100%;
      /*background-image: url(http://blog.shihshih.com/wp-content/uploads/2018/08/image1.png);*/
      animation: bk 25s linear;
    }
    .slider_container div {
      position: absolute;
      top: 0;
      left: 0;
      opacity: 1;
      filter: alpha(opacity=100);
      left: 100%;
      width: 100%;
      -webkit-animation: round 25s linear infinite;
      animation: round 25s linear infinite;
    }
    .slider_container div img {
      width: 100%;
    }
    @-webkit-keyframes round {
      4% {
        opacity: 1;
        filter: alpha(opacity=100);
        left: 0;
        /* 0 - 1秒 滑入*/
      }
      20% {
        opacity: 1;
        filter: alpha(opacity=100);
        left: 0;
        /* 1- 5秒靜止*/
      }
      24% {
        opacity: 1;
        filter: alpha(opacity=100);
        left: -100%;
        /* 5-6秒滑出*/
      }
      26% {
        opacity: 0;
        filter: alpha(opacity=0);
        left: -100%;
        /* 6-6.5秒變透明*/
      }
      28% {
        opacity: 0;
        filter: alpha(opacity=0);
        left: 100%;
        /* 6.5-7秒回到起始位置*/
      }
    }
    @keyframes bk {
      0% {
        left: 0;
        /* 初始位置*/
      }
      4% {
        left: -100%;
        /* 0 - 1秒 滑出*/
      }
    }

    @keyframes bk {
      0% {
        left: 0;
        /* 初始位置*/
      }
      4% {
        left: -100%;
        /* 0 - 1秒 滑出*/
      }
    }
    .slider_container div:nth-child(5) {
      -webkit-animation-delay: 0s;
      animation-delay: 0s;
    }
    .slider_container div:nth-child(4) {
      -webkit-animation-delay: 5s;
      animation-delay: 5s;
    }
    .slider_container div:nth-child(3) {
      -webkit-animation-delay: 10s;
      animation-delay: 10s;
    }
    .slider_container div:nth-child(2) {
      -webkit-animation-delay: 15s;
      animation-delay: 15s;
    }
    .slider_container div:nth-child(1) {
      -webkit-animation-delay: 20s;
      animation-delay: 20s;
    }
    .rwd_slider_container_wrapper {
      margin: 30px auto !important;
      width: 420px;
    }
    .rwd_slider_container {
      position: relative;
      display: block;
      height: 0;
      padding: 0;
      overflow: hidden;
      padding-bottom: 70%;
      box-sizing: border-box;
    }
    .rwd_slider_container .slider_container {
      position: absolute;
      top: 0;
      bottom: 0;
      left: 0;
      width: 100%;
      height: 100%;
      margin: 0;
      box-sizing: border-box;
    }




  </style>

</head>

<body>

<jsp:include page="layouts/topbar.jsp"/>

<jsp:include page="layouts/header.jsp"/>

<main id="main">

  <!-- ======= Breadcrumbs ======= -->
  <section id="breadcrumbs" class="breadcrumbs">
    <div class="container">

      <ol>
        <li><a href="index.html">Home</a></li>
        <li>About Us</li>
      </ol>
      <h2>About Us</h2>

    </div>
  </section><!-- End Breadcrumbs -->

  <!-- ======= About Section ======= -->
  <section id="about" class="about">
    <div class="container">

      <div class="row">
        <div class="col-lg-6">
          <img src="<c:url value="/styles/front/assets/img/about.jpg"/>" class="img-fluid" alt="">
        </div>
        <div class="col-lg-6 pt-4 pt-lg-0 content">
          <h3>Voluptatem dignissimos provident quasi corporis voluptates sit assumenda.</h3>
          <p class="fst-italic">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
            magna aliqua.
          </p>
          <ul>
            <li><i class="bi bi-check-circle"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat.</li>
            <li><i class="bi bi-check-circle"></i> Duis aute irure dolor in reprehenderit in voluptate velit.</li>
            <li><i class="bi bi-check-circle"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate trideta storacalaperda mastiro dolore eu fugiat nulla pariatur.</li>
          </ul>
          <p>
            Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
            velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
            culpa qui officia deserunt mollit anim id est laborum
          </p>
        </div>
      </div>

    </div>
  </section><!-- End About Section -->

  <!-- ======= Counts Section ======= -->
  <section id="counts" class="counts">
    <div class="container">

      <div class="row no-gutters">

        <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
          <div class="count-box">
            <i class="bi bi-emoji-smile"></i>
            <span data-purecounter-start="0" data-purecounter-end="232" data-purecounter-duration="1" class="purecounter"></span>
            <p><strong>Happy Clients</strong> consequuntur quae qui deca rode</p>
            <a href="#">Find out more &raquo;</a>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
          <div class="count-box">
            <i class="bi bi-journal-richtext"></i>
            <span data-purecounter-start="0" data-purecounter-end="521" data-purecounter-duration="1" class="purecounter"></span>
            <p><strong>Projects</strong> adipisci atque cum quia aut numquam delectus</p>
            <a href="#">Find out more &raquo;</a>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
          <div class="count-box">
            <i class="bi bi-headset"></i>
            <span data-purecounter-start="0" data-purecounter-end="1463" data-purecounter-duration="1" class="purecounter"></span>
            <p><strong>Hours Of Support</strong> aut commodi quaerat. Aliquam ratione</p>
            <a href="#">Find out more &raquo;</a>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
          <div class="count-box">
            <i class="bi bi-people"></i>
            <span data-purecounter-start="0" data-purecounter-end="15" data-purecounter-duration="1" class="purecounter"></span>
            <p><strong>Hard Workers</strong> rerum asperiores dolor molestiae doloribu</p>
            <a href="#">Find out more &raquo;</a>
          </div>
        </div>

      </div>

    </div>
  </section><!-- End Counts Section -->

  <!-- ======= Clients Section ======= -->
  <section id="clients" class="clients">
<%--    <div class="container">--%>

<%--      <div class="section-title">--%>
<%--        <h2>Clients</h2>--%>
<%--        <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>--%>
<%--      </div>--%>

<%--      <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">--%>
<%--        <div class="carousel-inner ">--%>
<%--          <c:forEach items="${productImageIds}" var="productImageIds">--%>
<%--            <div class="carousel-item active" style="width: 500px;" data-bs-interval="3000">--%>
<%--              <a href="${contextRoot}/front/product/details/${productImageIds}">--%>

<%--               <img src="${contextRoot}/product/mainImage/${productImageIds}" class="d-block w-100 "  alt="...">--%>
<%--             </a>--%>
<%--            </div>--%>
<%--          </c:forEach>--%>


<%--        </div>--%>

<%--    #######################    CSS TEST         ##############################--%>
        <div class="rwd_slider_container_wrapper">
          <div class="rwd_slider_container">
            <div class="slider_container" >
              <c:forEach items="${productImageIds}" var="productImageIds">
                <div class="carousel-item active" style="width: 500px;" data-bs-interval="3000">
                  <a href="${contextRoot}/front/product/details/${productImageIds}">

                    <img src="${contextRoot}/product/mainImage/${productImageIds}" class="d-block w-100 "  alt="...">
                  </a>
                </div>
              </c:forEach>

            </div><!-- end of .pure_slider_container -->
          </div><!-- end of .embed-responsive -->
        </div><!-- end of .embed-responsive-box -->











        <%--    #######################    CSS TEST         ##############################--%>









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
  </section><!-- End Clients Section -->

  <!-- ======= Testimonials Section ======= -->
  <section id="testimonials" class="testimonials">
    <div class="container">

      <div class="section-title">
        <h2>Testimonials</h2>
        <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
      </div>

      <div class="row">

        <div class="col-lg-6">
          <div class="testimonial-item">
            <img src="<c:url value="/styles/front/assets/img/testimonials/testimonials-1.jpg"/>" class="testimonial-img" alt="">
            <h3>Saul Goodman</h3>
            <h4>Ceo &amp; Founder</h4>
            <p>
              <i class="bx bxs-quote-alt-left quote-icon-left"></i>
              Proin iaculis purus consequat sem cure digni ssim donec porttitora entum suscipit rhoncus. Accusantium quam, ultricies eget id, aliquam eget nibh et. Maecen aliquam, risus at semper.
              <i class="bx bxs-quote-alt-right quote-icon-right"></i>
            </p>
          </div>
        </div>

        <div class="col-lg-6">
          <div class="testimonial-item mt-4 mt-lg-0">
            <img src="assets/img/testimonials/testimonials-2.jpg" class="testimonial-img" alt="">
            <h3>Sara Wilsson</h3>
            <h4>Designer</h4>
            <p>
              <i class="bx bxs-quote-alt-left quote-icon-left"></i>
              Export tempor illum tamen malis malis eram quae irure esse labore quem cillum quid cillum eram malis quorum velit fore eram velit sunt aliqua noster fugiat irure amet legam anim culpa.
              <i class="bx bxs-quote-alt-right quote-icon-right"></i>
            </p>
          </div>
        </div>

        <div class="col-lg-6">
          <div class="testimonial-item mt-4">
            <img src="assets/img/testimonials/testimonials-3.jpg" class="testimonial-img" alt="">
            <h3>Jena Karlis</h3>
            <h4>Store Owner</h4>
            <p>
              <i class="bx bxs-quote-alt-left quote-icon-left"></i>
              Enim nisi quem export duis labore cillum quae magna enim sint quorum nulla quem veniam duis minim tempor labore quem eram duis noster aute amet eram fore quis sint minim.
              <i class="bx bxs-quote-alt-right quote-icon-right"></i>
            </p>
          </div>
        </div>

        <div class="col-lg-6">
          <div class="testimonial-item mt-4">
            <img src="assets/img/testimonials/testimonials-4.jpg" class="testimonial-img" alt="">
            <h3>Matt Brandon</h3>
            <h4>Freelancer</h4>
            <p>
              <i class="bx bxs-quote-alt-left quote-icon-left"></i>
              Fugiat enim eram quae cillum dolore dolor amet nulla culpa multos export minim fugiat minim velit minim dolor enim duis veniam ipsum anim magna sunt elit fore quem dolore labore illum veniam.
              <i class="bx bxs-quote-alt-right quote-icon-right"></i>
            </p>
          </div>
        </div>

        <div class="col-lg-6">
          <div class="testimonial-item mt-4">
            <img src="assets/img/testimonials/testimonials-5.jpg" class="testimonial-img" alt="">
            <h3>John Larson</h3>
            <h4>Entrepreneur</h4>
            <p>
              <i class="bx bxs-quote-alt-left quote-icon-left"></i>
              Quis quorum aliqua sint quem legam fore sunt eram irure aliqua veniam tempor noster veniam enim culpa labore duis sunt culpa nulla illum cillum fugiat legam esse veniam culpa fore nisi cillum quid.
              <i class="bx bxs-quote-alt-right quote-icon-right"></i>
            </p>
          </div>
        </div>

        <div class="col-lg-6">
          <div class="testimonial-item mt-4">
            <img src="assets/img/testimonials/testimonials-6.jpg" class="testimonial-img" alt="">
            <h3>Emily Harison</h3>
            <h4>Store Owner</h4>
            <p>
              <i class="bx bxs-quote-alt-left quote-icon-left"></i>
              Eius ipsam praesentium dolor quaerat inventore rerum odio. Quos laudantium adipisci eius. Accusamus qui iste cupiditate sed temporibus est aspernatur. Sequi officiis ea et quia quidem.
              <i class="bx bxs-quote-alt-right quote-icon-right"></i>
            </p>
          </div>
        </div>

      </div>

    </div>
  </section><!-- End Testimonials Section -->

</main><!-- End #main -->

<jsp:include page="layouts/footer.jsp"/>


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
