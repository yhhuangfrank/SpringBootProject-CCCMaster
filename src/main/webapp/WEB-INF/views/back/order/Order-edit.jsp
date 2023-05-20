<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>訂單詳細資料</title>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

  <!-- Favicons -->
  <link href="${contextRoot}/styles/back/assets/img/favicon.png" rel="icon">
  <link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

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
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>

  <jsp:include page="../layouts/header.jsp"/>

  <main id="main" class="main">
       <h1 class="card-title fs-1">訂單詳細資料</h1>

              <form:form method="put" modelAttribute="singleorder" action="${contextRoot}/admin/orders/edit">
                <div class="row mb-3">
                  <label for="inputorderid" class="col-sm-2 col-form-label">訂單編號</label>
                  <div class="col-sm-10 fs-5">
                    <form:input type="text" path="orderid" class="form-control" value="${singleorder.orderid}" id="oid"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputcbOrderid" class="col-sm-2 col-form-label">會員編號</label>
                  <div class="col-sm-10 fs-5">
					<input type="text" class="form-control" value="${singleorder.cbOrder.customerId}" disabled id="cid">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputcbOrdername" class="col-sm-2 col-form-label">會員姓名</label>
                  <div class="col-sm-10 fs-5">
                    <input type="text" class="form-control" value="${singleorder.cbOrder.name}" disabled>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputorderdate" class="col-sm-2 col-form-label">訂購日期</label>
                  <div class="col-sm-10 fs-5">
                    <input type="text" class="form-control" value="${singleorder.orderdate}" disabled>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputarrivaldate" class="col-sm-2 col-form-label">送達日期</label>
                  <div class="col-sm-10">
                  <form:input type="text" path="arrivaldate" class="form-control" value="${singleorder.arrivaldate}" id="inputarrivaldate"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputNumber" class="col-sm-2 col-form-label">送達地址</label>
                  <div class="col-sm-10">
                   <form:input type="text" path="shipperaddress" class="form-control" value="${singleorder.shipperaddress}" id="inputshipperaddress"></form:input>
                  </div>
                </div>
                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">訂單狀態</label>
                  <div class="col-sm-10">
                    <form:select class="form-select" path="ordercondition" aria-label="Default select example" value="${singleorder.ordercondition}" id="inputordercondition">
                      <option selected value="${singleorder.ordercondition}"></option>
                      <option value="處理中">處理中</option>
                      <option value="已確認(出貨完畢)">已確認(出貨完畢)</option>
                      <option value="已完成(交易成功)">已完成(交易成功)</option>
                      <option value="已取消">已取消</option>
                    </form:select>
                  </div>
                </div>
                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">繳款狀態</label>
                  <div class="col-sm-10 fs-5">
                  	<form:select class="form-select" path="paymentcondition" aria-label="Default select example" value="${singleorder.paymentcondition}" id="inputpaymentcondition">
                      <option selected value="${singleorder.paymentcondition}"></option>
                      <option value="未付款">未付款</option>
                      <option value="已付款">已付款</option>
                      <option value="退款中">退款中</option>
                      <option value="已退款">已退款</option>
                    </form:select>
                  </div>
                </div>

                <div class="row mb-3">
                  <label for="inputColor" class="col-sm-2 col-form-label">商品明細</label>
                  <div class="col-sm-10">
                    <table class="table">
		                <thead>
		                  <tr>
		                    <th scope="col"></th>
		                    <th scope="col">商品編號</th>
		                    <th scope="col">商品名稱</th>
		                    <th scope="col">數量</th>
		                    <th scope="col">金額</th>
		                  </tr>
		                </thead>
		                <tbody>
		                <c:forEach var="od" items="${orderdetails}">
		                  <tr>		                  
		                    <th scope="row">1</th>
		                    <td>${od.pOrderDetail.productId}</td>
		                    <td>${od.pOrderDetail.productName}</td>
		                    <td>${od.quantity}</td>
		                    <td>${od.unitprice}</td>
		                  </tr>
		                  </c:forEach>
		                </tbody>
		              </table>
                  </div>
                </div>
								
                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label"></label>
                  <div class="col-sm-10">
                  	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#cencel">取消</button>
                    	<div class="modal fade" id="cencel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
								<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">訂單詳細資料</h5>
									<button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
									</button>
									</div>
									<div class="modal-body">
									<h3>是否取消更新?</h3>
									</div>
									<div class="modal-footer">
									<input type="reset" class="btn btn-secondary" data-bs-dismiss="modal" value="否">
									<input type="submit" class="btn btn-primary" value="確定">
								</div>
								</div>
							</div>
						</div>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#update">送出</button>
                    	<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
								<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">訂單詳細資料</h5>
									<button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
									</button>
									</div>
									<div class="modal-body">
									<h3>是否確定更新?</h3>
									</div>
									<div class="modal-footer">
									<input type="reset" class="btn btn-secondary" data-bs-dismiss="modal" value="否">
									<input type="submit" class="btn btn-primary" value="確定">
								</div>
								</div>
							</div>
						</div>			                   	
                  </div>
                </div>
              </form:form>
              <div style="margin-left: 180px">
              </div>

  </main>

  <jsp:include page="../layouts/aside.jsp"/>

  <jsp:include page="../layouts/footer.jsp"/>

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
