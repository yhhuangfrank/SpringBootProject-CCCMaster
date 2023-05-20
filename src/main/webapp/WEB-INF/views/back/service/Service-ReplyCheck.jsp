<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
          <!DOCTYPE html>
          <html>

          <head>
            <title>回覆客戶表單</title>
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
            
		<div class="row justify-content-center">
			<div class="col-5">
				<h1>客服表單回覆區</h1>
				<div class="card">
					<div class="card-header">表單</div>
					<div class="card-body" >
						<form:form class="form-control" modelAttribute="ReportForm"
							method="put">

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
                                <a href="${contextRoot}/admin/Service/findformFinish" id="btn"
                                                                Class="btn btn-secondary" style="">返回</a>
					</div>
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
            <script src="${contextRoot}/styles/back/assets/vendor/simple-datatables/datatables.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/tinymce/tinymce.min.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/php-email-form/validate.js"></script>

            <!-- Template Main JS File -->
            <script src="${contextRoot}/styles/back/assets/js/main.js"></script>



          </body>

          </html>