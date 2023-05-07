<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html lang="en">

    <head>
      <meta charset="utf-8">
      <meta content="width=device-width, initial-scale=1.0" name="viewport">

      <title>山西達人-常見問題</title>
      <meta content="" name="description">
      <meta content="" name="keywords">

      <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

      <!-- Favicons -->
      <link href="${contextRoot}/styles/front/assets/img/favicon.png" rel="icon">
      <link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

      <!-- Google Fonts -->
      <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
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
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bxl-dribbble"></i></div>
                  <h4><a href="${contextRoot}/Service/common">熱門問題</a></h4>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="${contextRoot}/Service/common/order">訂購付款</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="${contextRoot}/Service/common/delivery">配送說明</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="/Service/common/Refund">售後退款</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="/Service/common/discount">購物優惠</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="/Service/common/Activity">活動相關</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="/Service/common/Account">會員帳號</a></h4>
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
              <h2>會員帳號</h2>
            </div>


            <!-- Accordion without outline borders -->
            <div class="accordion" id="accordionExample">
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                    <strong>Q1、聯絡我們</strong>
                  </button>
                </h2>

                <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>1.您可在網頁右上角的客服中心回報表單與客服進行發問</strong>
                  </div>
                  <div class="accordion-body">
                    <strong>2.您可在網頁畫面右下角找到對話聊天室與客服人員線上即時發問。</strong>
                  </div>
                </div>
              </div>
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingTwo">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                    <strong>Q2、若我之前已使用帳號及密碼的註冊過，要怎麼跟我的第三方帳號綁定呢？</strong>
                  </button>
                </h2>

                <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>在首次使用第三方帳號登入時，會詢問您是否已註冊過帳號，確認相符後即可將帳號進行綁定，之後無論使用第三方帳號或Email，皆可查詢購買紀錄</strong>
                  </div>
                </div>
              </div>
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingThree">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    <strong>Q3、尚未註冊過山西達人會員，可以直接選擇第三方帳號登入嗎？</strong>
                  </button>
                </h2>
                <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>可以的，您可直接於「會員登入」，選擇使用山西達人提供的第三方登入方式登入，即完成新會員註冊。若您尚無第三方登入帳號帳號與山西達人平台帳號，也可於「註冊」頁面，輸入帳號、密碼完成會員註冊。</strong>
                  </div>
                </div>
              </div>
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingFour">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                    <strong>Q4、如果忘記第三方帳號登入密碼，可以點忘記密碼嗎?</strong>
                  </button>
                </h2>
                <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>由於第三方帳號密碼是使用您原平台的登入密碼，需請您至原註冊平台(例：Facebook、Google等)尋找登入密碼哦！
                      此外，若您以第三方帳號進行新註冊登入後，有至「顧客中心」的「我的帳戶」 中新增密碼，如忘記密碼可點選「忘記密碼」進行驗證後即可登入囉！</strong>
                  </div>
                </div>
              </div>
              <!-- 我是分隔線 -->

            </div>
          </div><!-- End Accordion without outline borders -->

        </section><!-- End Our Skills Section -->
  </main><!-- End #main -->

    
<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp"/>


      <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
          class="bi bi-arrow-up-short"></i></a>

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