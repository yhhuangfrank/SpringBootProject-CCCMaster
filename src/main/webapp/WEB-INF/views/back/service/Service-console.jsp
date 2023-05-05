<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                color: whitesmoke;
                font-weight: bold;
                background-color: royalblue;
                margin: 0px;
                width: 100%;
              }

              .felx-container {
                margin: 0px;
                width: 100%;
                height: 700px;
                display: flex;
                flex-direction: row;
                background-color: #E0FFFF;

              }

              .felx-container-left {
                width: 18%;
                display: flex;
                flex-direction: column;

              }

              .felx-container-left-top {
                flex-direction: row;
                border: 1px gainsboro solid;
                height: 15%;
                padding-top: 5px;
                padding-left: 5px;
              }

              .felx-container-left-top-left {
                float: left;
                line-height: 15px;
              }

              .felx-container-left-top-right {
                margin-left: 75px;
                float: left;
                line-height: 15px;
              }

              .felx-container-left-center {
                flex-direction: row;
                height: 5%;
                border: 2px blue solid;

              }

              .felx-container-left-center-left {
                height: 100%;
                width: 50%;
                float: left;
                border: 2px blue solid;
                text-align: center;
              }

              .felx-container-left-center-right {
                border: 2px blue solid;
                height: 100%;
                width: 50%;
                float: left;
                text-align: center;
              }

              .felx-container-left-down {
                line-height: 50px;
                border: 2px blue solid;
                height: 80%;
                width: 100%;
                display: flex;
              }

              .felx-container-center {
                width: 50%;
                display: flex;
                flex-direction: column;

              }

              .felx-container-center-top {
                height: 10%;
                display: flex;
                flex-direction: column;
              }

              .felx-container-center-top-top {
                padding-top: 5px;
                border: 2px blue solid;
                height: 50%;
                width: 100%;
                float: left;
                text-align: center;
              }

              .felx-container-center-top-down {
                border: 2px blue solid;
                height: 50%;
                width: 100%;
                display: flex;
                /* 平均分配 */
                justify-content: space-around;
              }

              .felx-container-center-center {
                border: 2px blue solid;
                height: 60%;
                width: 100%;
                display: flex;
                flex-direction: column;

              }


              .felx-container-center-down {
                height: 30%;
                display: flex;
                flex-direction: column;

              }

              .felx-container-center-down-top {

                height: 20%;
                width: 100%;
                display: flex;
              }

              .felx-container-center-down-down {

                border: 2px blue solid;
                height: 80%;
                width: 100%;
                padding:0%;
              }

              .felx-container-right {
                width: 32%;
                display: flex;
                flex-direction: column;
              }

              .felx-container-right-top {
                padding-top: 5px;
                border: 2px blue solid;
                height: 5%;
                width: 100%;
                display: flex;
                /* 平均分配 */
                justify-content: space-around;
              }

              .felx-container-right-center {
                border: 2px blue solid;
                height: 45%;
                width: 100%;
                display: flex;
              }

              .felx-container-right-down {
                border: 2px blue solid;
                height: 50%;
                width: 100%;
                display: flex;
              }


              .job-font {
                font-size: 50%;
                font-size: 15px;
              }


              .job {

                width: 200px;
                line-height: 50px;
                padding: 20px;
                border: 2px green solid;
              }

              .form-control {
                height: 75%;
              }

              .btndiv {
                position: fixed;
                right: 28%;
                top: 84%;
              }

              #btn {
                right: 0%;
              }

              #btn:hover {
                background-color: teal;
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
                  <!-- 工作資料1-1 -->
                  <div class="felx-container-left-top">
                    <div class="felx-container-left-top-left">
                      <p class="job-font">接待數量:<span>#</span></p>
                      <p class="job-font">在線時長:<span>#</span></p>
                      <p class="job-font">服務時長:<span>#</span></p>
                    </div>
                    <div class="felx-container-left-top-right">
                      <p class="job-font">創建服務單:<span>#</span></p>
                      <p class="job-font">創建工單:<span>#</span></p>
                      <p class="job-font">接待客戶:<span>#</span></p>
                    </div>
                  </div>
                  <div class="felx-container-left-center">
                    <!-- 工作資料1-2 -->
                    <div class="felx-container-left-center-left">
                      <p class="job-font">待接入&nbsp;&nbsp;&nbsp;<span>#</span></p>
                    </div>
                    <div class="felx-container-left-center-right">
                      <p class="job-font">正在接入&nbsp;&nbsp;&nbsp;<span>#</span></p>
                    </div>
                  </div>
                  <div class="felx-container-left-down">
                    <!-- 工作資料1-3 -->
                    <p class="job-font">創建服務單:<span>555</span></p>
                    <p class="job-font">創建工單:<span>555</span></p>
                    <p class="job-font">接待客戶:<span>555</span></p>
                  </div>
                </div>
                <!-- 並排div center -->
                <div class="felx-container-center">
                  <!-- 工作資料2-1 -->
                  <div class="felx-container-center-top">
                    <div class="felx-container-center-top-top">
                      <p class="job-font">溝通服務單:<span>#############</span></p>
                    </div>
                    <div class="felx-container-center-top-down">
                      <p class="job-font">等待接入用時:<span>#####</span></p>
                      <p class="job-font">創建對話時間:<span>#####</span></p>
                      <p class="job-font">溝通用時:<span>#####</span></p>
                      <p class="job-font">對話次數:<span>#####</span></p>

                    </div>
                  </div>
                  <!-- 工作資料2-2 -->
                  <div class="felx-container-center-center">
                    <div class="text-center">
                      <p class="">接入成功:<span>######</span></p>
                      <p class="">用戶離線:<span>######</span></p>
                      <p class="">通話結束:<span>######</span></p>
                    </div>
                    <br />
                    <div class="">最新的資料 時間:<span>
                        <fmt:formatDate pattern="EEEE yyyy-MM-dd HH:mm:ss" value="${latest.createtime}" />
                      </span></div>
                    <div class="">
                      ${latest.content}


                    </div>


                  </div>
                  <!-- 工作資料2-3 -->
                  <div class="felx-container-center-down">
                    <div class="felx-container-center-down-top">
                      <p class="job-font">表情/圖片上傳</p>
                    </div>
                    <div class="felx-container-center-down-down">
                      <form:form class="form-control" modelAttribute="messages" method="post"
                        action="${contextRoot}/messages/post">


                        <div class="form-floating mb-3">
                          <form:textarea class="form-control"
                              placeholder="Leave a comment here" id="floatingTextarea"
                              style="height: 100px;" path="content" maxlength="50"></form:textarea>
                          <label for="floatingTextarea"></label>
                      </div>
                        <div class="col-sm-10" style="text-align: right;margin:auto;float:right;">
                          <button type="submit" class="btn btn-primary" id="btn">送出</button>
                        </div>
                      </form:form>
                    </div>
                  </div>
                </div>
                <div class="felx-container-right">
                  <!-- 工作資料3-1 -->
                  <div class="felx-container-right-top">
                    <p class="job-font">客戶資料</p>
                    <p class="job-font">訂單查詢</p>
                    <p class="job-font">溝通歷史</p>
                    <p class="job-font">物流查詢</p>
                    <p class="job-font">溝通節點</p>
                  </div>
                  <!-- 工作資料3-2 -->
                  <div class="felx-container-right-center">
                    <p class="job-font">表格/資料顯示</p>
                  </div>
                  <!-- 工作資料3-3 -->
                  <div class="felx-container-right-down">
                    <p class="job-font">常用語/知識庫/快捷用語</p>
                  </div>
                </div>

              </div>

















            </main>




            <jsp:include page="../layouts/header.jsp" />

            <jsp:include page="../layouts/aside.jsp" />

            <jsp:include page="../layouts/footer.jsp" />

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