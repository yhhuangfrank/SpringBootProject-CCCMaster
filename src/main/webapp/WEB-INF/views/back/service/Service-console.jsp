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
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js"></script>
            <!--    libs for stomp and sockjs-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
            <!--    end libs for stomp and sockjs-->
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet"
              type="text/css">
            <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
            <link href="${contextRoot}/styles/front/assets/vendor/swiper/style.css" rel="stylesheet">

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
                border: 1px gray solid;
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

              }

              .felx-container-left-center-left {
                height: 100%;
                width: 50%;
                float: left;
                text-align: center;
              }

              .felx-container-left-center-right {
                height: 100%;
                width: 50%;
                float: left;
                text-align: center;
              }

              .felx-container-left-down {
                line-height: 50px;
                border: 1px gray solid;
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
                border: 1px gray solid;
                height: 50%;
                width: 100%;
                float: left;
                text-align: center;
              }

              .felx-container-center-top-down {
                border: 1px gray solid;
                height: 50%;
                width: 100%;
                display: flex;
                /* 平均分配 */
                justify-content: space-around;
              }

              .felx-container-center-center {
                border: 1px gray solid;
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

                border: 1px gray solid;
                height: 80%;
                width: 100%;
                padding: 0%;
              }

              .felx-container-right {
                width: 32%;
                display: flex;
                flex-direction: column;
              }

              .felx-container-right-top {
                padding-top: 5px;
                border: 1px gray solid;
                height: 5%;
                width: 100%;
                display: flex;
                /* 平均分配 */
                justify-content: space-around;
              }

              .felx-container-right-center {
                border: 1px gray solid;
                height: 95%;
                width: 100%;
                display: flex;
              }

              .felx-container-right-down {
                border: 1px gray solid;
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
                border: 1px green solid;
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
              #fontbackcolor{
                right: 50px;
                height:35px; 
                border:1px solid; 
                border-color:#eceae9;
                background-color: rgb(74, 212, 31);
                text-align: center;
                font-size: 24px;
              }
              #userfontbackcolor{
                font-size: 24px;
              }
            </style>
          </head>

          <body>



            <main id="main" class="main">
              <!-- 操作台title -->
              <div>
                <h1 class="service-title">客服聊天操作平台</h1>
              </div>
              <!-- 橫向並排div -->
              <div class="felx-container">
                <!-- 並排div left -->
                <div class="felx-container-left">
                  <!-- 工作資料1-1 -->
                  <div class="felx-container-left-top">
                    <div class="felx-container-left-top-left">

                      <img src="${contextRoot}/styles/front/assets/js/LOGO.jpg" width="270px" height="120px"
                        alt="avatar" />
                    </div>
                    <div class="felx-container-left-top-right">
                    </div>
                  </div>
                  <div class="felx-container-left-center">
                    <!-- 工作資料1-2 -->
                    <div class="felx-container-left-center-left" style="line-height:5px;">
                      <button class="btn btn-primary" onclick="registration()"
                        style="width:100%;height:100%;">加入連線</button>
                    </div>
                    <div class="felx-container-left-center-right">
                      <button class="btn btn-danger" onclick="disconnectFromChat()"
                        style="width:100%;height:100%;">中斷連線</button>
                    </div>
                  </div>
                  <div class="felx-container-left-down">
                    <div style="width:100%;">
                      <div class="search" style="width:100%;text-align:center;">
                        <input id="userName" placeholder="search" type="text" value="" />
                      </div>
                      <br>
                      <ul class="list" id="usersList" style="overflow:auto;height:435px;text-align:center;">


                      </ul>


                    </div> <!-- end container -->
                  </div>
                </div>
                <!-- 並排div center -->
                <div class="felx-container-center">
                  <!-- 工作資料2-1 -->
                  <div class="felx-container-center-top">
                    <div class="felx-container-center-top-top">
                      <p style="color:blue;font-weight:bold;">聊天視窗</p>
                    </div>

                    <div class="chat-header clearfix" style="text-align:center;">

                      <div class="chat-about">
                        <div class="chat-with" id="selectedUserId" style="color:blue;font-weight:bold;"></div>
                        <div class="chat-num-messages"></div>
                      </div>
                    </div> <!-- end chat-header -->
                  </div>
                  <!-- 工作資料2-2 -->
                  <div id="box" class="felx-container-center-center" style="overflow:auto;height:500px;">
                    <div class="text-center">
                    </div>
                    <br />


                    <div class="chat-history">
                      <ul>

                      </ul>

                    </div> <!-- end chat-history -->

                  </div>
                  <!-- 工作資料2-3 -->
                  <div class="felx-container-center-down">
                    <div class="felx-container-center-down-top">
                      <i class="fa fa-file-o"></i> &nbsp;&nbsp;&nbsp;
                      <i class="fa fa-file-image-o"></i>
                    </div>
                    <div class="felx-container-center-down-down">

                      <div class="chat">

                        <textarea class="form-control" id="message-to-send" name="message-to-send" placeholder="輸入訊息"
                          rows="6" maxlength="200" style="width:765px;"></textarea>
                      </div>

                      <div style="text-align:right;line-height:270px;">

                        <button id="sendBtn" class="btn btn-primary" style="right:5px;bottom:5px;
                border-radius: 10px;
                cursor: pointer;">送出</button>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="felx-container-right">
                  <!-- 工作資料3-1 -->
                  <div class="felx-container-right-top">
                    <ul class="nav nav-tabs nav-tabs-bordered">

                      <li class="nav-item">
                        <button class="" data-bs-toggle="tab" data-bs-target="#customer-go" id="item1">客戶資料</button>
                      </li>

                      <li class="nav-item">
                        <button class="" data-bs-toggle="tab" data-bs-target="#order-go" id="item2">訂單查詢</button>
                      </li>
                    </ul>
                  </div>
                  <!-- 工作資料3-2 -->
                  <div class="felx-container-right-center">
                    <div class="tab-content pt-0">
                      <div class="tab-pane fade profile-edit pt-3" id="customer-go">
                        <form id="customerForm" action="/search" method="get">
                          <input id="customerId" name="customerId" placeholder="輸入會員ID" type="text"
                            style="width: 400px;height: 40px;">
                          <button id="searchBtn" class="btn btn-primary" type="submit" style="width: 80px;">查詢</button>
                        </form>

                        <table id="customerTable" class="bordered-table">
                          <thead>
                            <tr>
                              <th style="width: 90px;">顧客編號</th>
                              <th id="row1col2" style="width: 120px;"></th>
                              <th style="width: 100px;">名稱</th>
                              <th id="row1col4" style="width: 195px;"></th>
                            </tr>
                          </thead>
                          <tbody id="customerTableBody">
                            <tr>
                              <td>連絡電話</td>
                              <td id="row2col2"></td>
                              <td>電子郵件</td>
                              <td id="row2col4"></td>
                            </tr>
                            <tr>
                              <td>點數</td>
                              <td id="row3col2"></td>
                              <td>棄標次數</td>
                              <td id="row3col4"></td>
                            </tr>
                            <tr>
                              <td>會員註冊日期</td>
                              <td id="row4col2" colspan="3"></td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                      <div class="tab-pane fade profile-edit pt-1" id="order-go"
                        style="margin-top: 0px; padding-top: 0px; left: 0px;">
                        <form id="orderForm" action="/searchOrder" method="get">
                          <input id="orderid" name="orderid" placeholder="輸入訂單ID" type="text"
                            style="width: 400px; height: 40px;">
                          <button id="searchOrderBtn" class="btn btn-primary" type="submit"
                            style="width: 80px;">查詢</button>
                        </form>

                        <table id="orderTable" class="bordered-table">
                          <thead>
                            <tr>
                              <th style="width: 90px;">訂單編號</th>
                              <th id="trow1col2" style="width: 120px;"></th>
                              <th style="width: 100px;">顧客編號</th>
                              <th id="trow1col4" style="width: 195px;"></th>
                            </tr>
                          </thead>
                          <tbody id="orderTableBody">
                            <tr>
                              <td>訂購人</td>
                              <td id="trow2col2"></td>
                              <td>訂單金額</td>
                              <td id="trow2col4"></td>
                            </tr>
                            <tr>
                              <td>付款方式</td>
                              <td id="trow3col2"></td>
                              <td>付款狀態</td>
                              <td id="trow3col4"></td>
                            </tr>
                            <tr>
                              <td>配送方式</td>
                              <td id="trow4col2"></td>
                              <td>貨運公司</td>
                              <td id="trow4col4"></td>
                            </tr>
                            <tr>
                              <td>連絡電話</td>
                              <td id="trow5col2" colspan="3"></td>
                            </tr>
                            <tr>
                              <td>寄送地址</td>
                              <td id="trow6col2" colspan="3"></td>
                            </tr>
                            <tr>
                              <td>訂單成立日期</td>
                              <td id="trow7col2" colspan="3"></td>
                            </tr>
                            <tr>
                              <td>寄達日期</td>
                              <td id="trow8col2" colspan="3"></td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <!-- 工作資料3-3 -->

                </div>

              </div>



            </main>

            <script id="message-template" type="text/x-handlebars-template">
    <li class="clearfix">
        <div class="message-data align-right">
            <span class="message-data-time">{{time}}, Today</span> &nbsp; &nbsp;
            <span class="message-data-name">You</span> <i class="fa fa-circle me"></i>
        </div>
        <div class="message other-message float-right" id="fontbackcolor">
            {{messageOutput}}
        </div>
    </li>
</script>

            <script id="message-response-template" type="text/x-handlebars-template">
    <li>
        <div class="message-data">
            <span class="message-data-name"><i class="fa fa-circle online"></i> {{userName}}</span>
            <span class="message-data-time">{{time}}, Today</span>
        </div>
        <div class="message my-message" id="userfontbackcolor">
            {{response}}
        </div>
    </li>
</script>



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


            <script src="${contextRoot}/styles/front/assets/js/socustom.js"></script>
            <script src="${contextRoot}/styles/front/assets/js/chat.js"></script>>
            <script src="${contextRoot}/styles/front/assets/js/console.js"></script>

          </body>

          </html>