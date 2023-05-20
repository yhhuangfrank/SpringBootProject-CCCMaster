<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
          <jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
          <html lang="en">

          <head>
            <meta charset="utf-8">
            <meta content="width=device-width, initial-scale=1.0" name="viewport">

            <title>山西達人-表單回報</title>
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

            <style>
              .bordered-table {
                border-collapse: collapse;
              }

              .bordered-table th,
              .bordered-table td {
                border: 1px solid black;
                padding: 8px;
              }

              .bordered-table th:nth-child(1),
              .bordered-table td:nth-child(1),
              .bordered-table th:nth-child(3),
              .bordered-table td:nth-child(3) {
                background-color: lightgray;
              }

              th,
              td {
                text-align: center;
              }

              #fontbackcolor {
                right: 50px;
                height: 35px;
                border: 1px solid;
                border-color: #eceae9;
                background-color: rgb(74, 212, 31);
                text-align: center;
                font-size: 24px;
              }

              #userfontbackcolor {
                font-size: 24px;
              }
            </style>





          </head>

          <body>


            <jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/topbar.jsp" />

            <jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/header.jsp" />


            <!-- ======= Breadcrumbs ======= -->
            <section id="breadcrumbs" class="breadcrumbs">
              <div class="container">

                <ol>
                  <li><a href="${contextRoot}/">首頁</a></li>
                  <li>聯絡客服</li>
                  <li>表單回報問答中心</li>
                  <li>表達回覆查看</li>
                </ol>
                <h2>表達回覆查看</h2>

              </div>
            </section><!-- End Breadcrumbs -->
            <main id="main" class="main">

              <div class="row justify-content-center">
                <div class="col-5">
                  <div class="card">
                    <div class="card-body">
                      <form:form class="form-control" modelAttribute="ReportForm" method="put">

                        <table id="orderTable" class="bordered-table" style="width:100%;height:90%;">
                          <thead>
                            <tr>
                              <th style="width: 110px;">回報編號</th>
                              <th id="trow1col2" style="width: 180px;">${ReportForm.id}</th>
                              <th style="width: 110px;">訂單編號</th>
                              <th id="trow1col4" style="width: 180px;">${ReportForm.orderid}</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>顧客編號</td>
                              <td>${ReportForm.customerid}</td>
                              <td>顧客名稱</td>
                              <td>${ReportForm.customername}</td>
                            </tr>
                            <tr>
                              <td>連絡電話</td>
                              <td>${ReportForm.phone}</td>
                              <td>電子郵件</td>
                              <td>${ReportForm.email}</td>
                            </tr>
                            <tr>
                              <td>問題主旨</td>
                              <td colspan="3">${ReportForm.question}</td>
                            </tr>
                            <tr>
                              <td>問題與建議</td>
                              <td colspan="3" style="height:200px;">${ReportForm.narrative}</td>
                            </tr>
                            <tr>
                              <td>客服回覆</td>
                              <td colspan="3" style="height:200px;">${ReportForm.reply}</td>
                            </tr>
                          </tbody>
                        </table>
                      </form:form>
                      <div style="width:100%;text-align:center;"></div>
                      <a href="${contextRoot}/service/from/create/${sessionScope.customerId}" id="btn"
                        Class="btn btn-secondary" style="">返回</a>
                    </div>
                  </div>
                </div>
              </div>



            </main>

            <jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp" />

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