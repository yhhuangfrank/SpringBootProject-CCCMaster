<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <!DOCTYPE html>
      <html>

      <head>
        <title>客服操作台</title>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

        <!-- Favicons -->
        <link href="${contextRoot}/styles/back/assets/img/favicon.png" rel="icon">
        <link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link
          href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
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

        <style>
          .service-title {
            text-align: center;
            color: blue;
            font-weight: bold;
            background-color: lightgrey;
          }

          .felx-container {
            line-height: 50px; 
            padding: 20px; 
            border: 2px blue solid; 
            margin-right: 10px; 
            display: flex;
            flex-direction: row;
            
          }
          .felx-container-left {
            line-height: 50px; 
            padding: 20px; 
            border: 2px blue solid; 
            margin-right: 10px; 
            display: flex;
            flex-direction: row;
            
          }
          .felx-container-center {
            line-height: 50px; 
            padding: 20px; 
            border: 2px blue solid; 
            margin-right: 10px; 
            left: 50%;
            display: flex;
            flex-direction: row;
            
          }
          .felx-container-right{
            line-height: 50px; 
            padding: 20px; 
            border: 2px blue solid; 
            margin-right: 10px; 
            left: 50%;
            display: flex;
            flex-direction: row;
          }

          .job-data {
            background-color: antiquewhite;
          }

          .job-font {
            font-size: 50%;
            font-size: 15px;
          }

          .job-data2 {}

          .job {

            width: 200px;
            line-height: 50px;
            padding: 20px;
            border: 2px green solid;
          }
        </style>
      </head>

      <body>



        <main id="main" class="main">
          <!-- 操作台title -->
          <div>
            <h1 class="service-title">客服操作平台</h1>
          </div>
          <!-- 橫向並排div -->
          <div class="felx-container">
            <!-- 並排div left -->
            <div class="felx-container-left">
            <!-- 工作資料1 -->
            <div class="job-data">
              <p class="job-font">接待數量:<span>555</span></p>
              <p class="job-font">在線時長:<span>555</span></p>
              <p class="job-font">服務時長:<span>555</span></p>
            </div>
            <!-- 工作資料2 -->
            <div class="job-data2">
              <p class="job-font">創建服務單:<span>555</span></p>
              <p class="job-font">創建工單:<span>555</span></p>
              <p class="job-font">接待客戶:<span>555</span></p>
            </div>
           </div>
           <!-- 並排div center -->
           <div class="felx-container-center">
            <!-- 工作資料1 -->
            <div class="job-data">
              <p class="job-font">接待數量:<span>555</span></p>
              <p class="job-font">在線時長:<span>555</span></p>
              <p class="job-font">服務時長:<span>555</span></p>
            </div>
           </div>
           <div class="felx-container-right">

           </div>

          </div>

















        </main>




        <jsp:include page="layouts/header.jsp" />

        <jsp:include page="layouts/aside.jsp" />

        <jsp:include page="layouts/footer.jsp" />

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