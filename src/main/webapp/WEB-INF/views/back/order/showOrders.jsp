<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>訂單列表</title>
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
</head>
<body>

  <jsp:include page="../layouts/header.jsp"/>

  <main id="main" class="main">
    <div class="pagetitle">
      <h1>訂單列表</h1>
      <nav>
          <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="${contextRoot}/">首頁</a></li>
              <li class="breadcrumb-item">訂單管理</li>
              <li class="breadcrumb-item active">訂單列表</li>
          </ol>
      </nav>
  </div>
  <section class="section">
  	<ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
          <button class="nav-link active" id="all-tab" data-bs-toggle="tab" data-bs-target="#all" type="button" role="tab" aria-controls="all" aria-selected="true">總覽</button>
        </li>
        <li class="nav-item" role="presentation">
          <button class="nav-link" id="handling-tab" data-bs-toggle="tab" data-bs-target="#handling" type="button" role="tab" aria-controls="handling" aria-selected="false">處理中</button>
        </li>
        <li class="nav-item" role="presentation">
          <button class="nav-link" id="unpay-tab" data-bs-toggle="tab" data-bs-target="#unpay" type="button" role="tab" aria-controls="unpay" aria-selected="false">未付款</button>
        </li>
        <li class="nav-item" role="presentation">
          <button class="nav-link" id="refund-tab" data-bs-toggle="tab" data-bs-target="#refund" type="button" role="tab" aria-controls="refund" aria-selected="false">退款中</button>
        </li>
        <li class="nav-item" role="presentation">
          <button class="nav-link" id="cancel-tab" data-bs-toggle="tab" data-bs-target="#cancel" type="button" role="tab" aria-controls="cancel" aria-selected="false">已取消</button>
        </li>
      </ul>     
      <div class="tab-content pt-2" id="myTabContent">
      <form class="row" action="${contextRoot}/admin/orders/search" method="get">
      <div class="col-2">
       	<select name="type" class="col-10 form-select" style="height: 35px">
       		<option value="orderid">訂單編號</option>
       		<option value="time">訂購時間</option>
       	</select>
       </div>
      <div class="col-8">
         <div class="col-6 input-group" style="float: right;">
             <input type="text" class="form-control" id="searchInput" placeholder="請輸入訂單編號或訂購時間" name="keyword">
             <button type="submit" class="btn btn-outline-light border-secondary" id="searchBtn"
                     style="display: inline; background-color: #e96b56"><i class="bx bx-search-alt"></i>
             </button>
         </div>
        </div>
       </form>
        <div class="tab-pane fade show active" id="all" role="tabpanel" aria-labelledby="all-tab">
         <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">訂單編號</th>
              <th scope="col">訂購人</th>
              <th scope="col">訂單日期</th>
              <th scope="col">訂單狀態</th>
              <th scope="col">繳款狀態</th>
              <th scope="col">合計</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
	        <c:if test="${not empty results}">
	        	<c:forEach var="result" items="${results}">
	             <tr>
	               <td style="vertical-align:middle">${result.orderid}</td>
	               <td style="vertical-align:middle">${result.cbOrder.name}</td>
	               <td style="vertical-align:middle">${result.orderdate}</td>
	               <td style="vertical-align:middle">${result.ordercondition}</td>
	               <td style="vertical-align:middle">${result.paymentcondition}</td>
	               <td style="vertical-align:middle">${result.totalamount}</td>
	               <td >
	                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
	                   	 <input type="hidden" name="id" value="${result.orderid}"/>
	                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
	                 </form>
	               </td>
	             </tr>
	             </c:forEach>
	        </c:if>
            <c:if test="${empty results}">
	            <c:forEach var="order" items="${page.content}">
	             <tr>
	               <td style="vertical-align:middle">${order.orderid}</td>
	               <td style="vertical-align:middle">${order.cbOrder.name}</td>
	               <td style="vertical-align:middle">${order.orderdate}</td>
	               <td style="vertical-align:middle">${order.ordercondition}</td>
	               <td style="vertical-align:middle">${order.paymentcondition}</td>
	               <td style="vertical-align:middle">${order.totalamount}</td>
	               <td >
	                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
	                   	 <input type="hidden" name="id" value="${order.orderid}"/>
	                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
	                 </form>
	               </td>
	             </tr>
	             </c:forEach>
             </c:if>
           </tbody>
        </table>
        <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
			<c:choose>
				<c:when test="${page.number != pageNumber-1 }">
					<a href="${contextRoot}/admin/orders?p=${pageNumber}">${pageNumber}</a>
				</c:when>
				<c:otherwise>${pageNumber}</c:otherwise>
			</c:choose>
			<c:if test="${pageNumber != page.totalPages }">-</c:if>
		</c:forEach>
       </div>
       <div class="tab-pane fade" id="handling" role="tabpanel" aria-labelledby="handling-tab">
        <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">訂單編號</th>
              <th scope="col">訂購人</th>
              <th scope="col">訂單日期</th>
              <th scope="col">訂單狀態</th>
              <th scope="col">繳款狀態</th>
              <th scope="col">合計</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
          <c:if test="${not empty handlingpages}">
        	<c:forEach var="handling" items="${handlingpages}">
             <tr>
               <td style="vertical-align:middle">${handling.orderid}</td>
               <td style="vertical-align:middle">${handling.cbOrder.name}</td>
               <td style="vertical-align:middle">${handling.orderdate}</td>
               <td style="vertical-align:middle">${handling.ordercondition}</td>
               <td style="vertical-align:middle">${handling.paymentcondition}</td>
               <td style="vertical-align:middle">${handling.totalamount}</td>
               <td >
                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
                   	 <input type="hidden" name="id" value="${handling.orderid}"/>
                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
                 </form>
               </td>
             </tr>
             </c:forEach>
	        </c:if>
	        <c:if test="${empty handlingpages}">
            <c:forEach var="handlingorder" items="${handlingpage.content}">
             <tr>
               <td style="vertical-align:middle">${handlingorder.orderid}</td>
               <td style="vertical-align:middle">${handlingorder.cbOrder.name}</td>
               <td style="vertical-align:middle">${handlingorder.orderdate}</td>
               <td style="vertical-align:middle">${handlingorder.ordercondition}</td>
               <td style="vertical-align:middle">${handlingorder.paymentcondition}</td>
               <td style="vertical-align:middle">${handlingorder.totalamount}</td>
               <td >
                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
                   	 <input type="hidden" name="id" value="${handlingorder.orderid}"/>
                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
                 </form>
               </td>
             </tr>
             </c:forEach>
             </c:if>
           </tbody>
        </table>
	        <c:forEach var="handlingpageNumber" begin="1" end="${handlingpage.totalPages}">
				<c:choose>
					<c:when test="${handlingpage.number != handlingpageNumber-1 }">
						<a href="${contextRoot}/admin/orders?p=${handlingpageNumber}">${handlingpageNumber}</a>
					</c:when>
					<c:otherwise>${handlingpageNumber}</c:otherwise>
				</c:choose>
				<c:if test="${handlingpageNumber != handlingpage.totalPages }">-</c:if>
			</c:forEach>
      	 </div>
        <div class="tab-pane fade" id="unpay" role="tabpanel" aria-labelledby="unpay-tab">
          <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">訂單編號</th>
              <th scope="col">訂購人</th>
              <th scope="col">訂單日期</th>
              <th scope="col">訂單狀態</th>
              <th scope="col">繳款狀態</th>
              <th scope="col">合計</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
          <c:if test="${not empty unpaypages}">
        	<c:forEach var="unpay" items="${unpaypages}">
             <tr>
               <td style="vertical-align:middle">${unpay.orderid}</td>
               <td style="vertical-align:middle">${unpay.cbOrder.name}</td>
               <td style="vertical-align:middle">${unpay.orderdate}</td>
               <td style="vertical-align:middle">${unpay.ordercondition}</td>
               <td style="vertical-align:middle">${unpay.paymentcondition}</td>
               <td style="vertical-align:middle">${unpay.totalamount}</td>
               <td >
                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
                   	 <input type="hidden" name="id" value="${unpay.orderid}"/>
                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
                 </form>
               </td>
             </tr>
             </c:forEach>
	        </c:if>
	        <c:if test="${empty unpaypages}">
	            <c:forEach var="unpayorder" items="${unpaypage.content}">
	             <tr>
	               <td style="vertical-align:middle">${unpayorder.orderid}</td>
	               <td style="vertical-align:middle">${unpayorder.cbOrder.name}</td>
	               <td style="vertical-align:middle">${unpayorder.orderdate}</td>
	               <td style="vertical-align:middle">${unpayorder.ordercondition}</td>
	               <td style="vertical-align:middle">${unpayorder.paymentcondition}</td>
	               <td style="vertical-align:middle">${unpayorder.totalamount}</td>
	               <td >
	                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
	                   	 <input type="hidden" name="id" value="${unpayorder.orderid}"/>
	                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
	                 </form>
	               </td>
	             </tr>
	             </c:forEach>
             </c:if>
           </tbody>
         </table>
	        <c:forEach var="unpaypageNumber" begin="1" end="${unpaypage.totalPages}">
				<c:choose>
					<c:when test="${unpaypage.number != unpaypageNumber-1 }">
						<a href="${contextRoot}/admin/orders?p=${unpaypageNumber}">${unpaypageNumber}</a>
					</c:when>
					<c:otherwise>${unpaypageNumber}</c:otherwise>
				</c:choose>
				<c:if test="${unpaypageNumber != unpaypage.totalPages }">-</c:if>
			</c:forEach>
          </div>
       <div class="tab-pane fade" id="refund" role="tabpanel" aria-labelledby="refund-tab">
         <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">訂單編號</th>
              <th scope="col">訂購人</th>
              <th scope="col">訂單日期</th>
              <th scope="col">訂單狀態</th>
              <th scope="col">繳款狀態</th>
              <th scope="col">合計</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
          <c:if test="${not empty cancelpages}">
        	<c:forEach var="cancel" items="${cancelpages}">
             <tr>
               <td style="vertical-align:middle">${cancel.orderid}</td>
               <td style="vertical-align:middle">${cancel.cbOrder.name}</td>
               <td style="vertical-align:middle">${cancel.orderdate}</td>
               <td style="vertical-align:middle">${cancel.ordercondition}</td>
               <td style="vertical-align:middle">${cancel.paymentcondition}</td>
               <td style="vertical-align:middle">${cancel.totalamount}</td>
               <td >
                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
                   	 <input type="hidden" name="id" value="${cancel.orderid}"/>
                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
                 </form>
               </td>
             </tr>
             </c:forEach>
	        </c:if>
	        <c:if test="${empty cancelpages}">
	            <c:forEach var="refundorder" items="${refundpage.content}">
	             <tr>
	               <td style="vertical-align:middle">${refundorder.orderid}</td>
	               <td style="vertical-align:middle">${refundorder.cbOrder.name}</td>
	               <td style="vertical-align:middle">${refundorder.orderdate}</td>
	               <td style="vertical-align:middle">${refundorder.ordercondition}</td>
	               <td style="vertical-align:middle">${refundorder.paymentcondition}</td>
	               <td style="vertical-align:middle">${refundorder.totalamount}</td>
	               <td >
	                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
	                   	 <input type="hidden" name="id" value="${refundorder.orderid}"/>
	                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
	                 </form>
	               </td>
	             </tr>
	             </c:forEach>
             </c:if>
           </tbody>
         </table>
	        <c:forEach var="refundpageNumber" begin="1" end="${refundpage.totalPages}">
				<c:choose>
					<c:when test="${refundpage.number != refundpageNumber-1 }">
						<a href="${contextRoot}/admin/orders?p=${refundpageNumber}">${refundpageNumber}</a>
					</c:when>
					<c:otherwise>${refundpageNumber}</c:otherwise>
				</c:choose>
				<c:if test="${refundpageNumber != refundpage.totalPages }">-</c:if>
			</c:forEach>
           </div>
        <div class="tab-pane fade" id="cancel" role="tabpanel" aria-labelledby="cancel-tab">
         <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">訂單編號</th>
              <th scope="col">訂購人</th>
              <th scope="col">訂單日期</th>
              <th scope="col">訂單狀態</th>
              <th scope="col">繳款狀態</th>
              <th scope="col">合計</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
          <c:if test="${not empty refundpages}">
        	<c:forEach var="refund" items="${refundpages}">
             <tr>
               <td style="vertical-align:middle">${refund.orderid}</td>
               <td style="vertical-align:middle">${refund.cbOrder.name}</td>
               <td style="vertical-align:middle">${refund.orderdate}</td>
               <td style="vertical-align:middle">${refund.ordercondition}</td>
               <td style="vertical-align:middle">${refund.paymentcondition}</td>
               <td style="vertical-align:middle">${refund.totalamount}</td>
               <td >
                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
                   	 <input type="hidden" name="id" value="${refund.orderid}"/>
                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
                 </form>
               </td>
             </tr>
             </c:forEach>
	        </c:if>
	        <c:if test="${empty refundpages}">
	            <c:forEach var="cancelorder" items="${cancelpage.content}">
	             <tr>
	               <td style="vertical-align:middle">${cancelorder.orderid}</td>
	               <td style="vertical-align:middle">${cancelorder.cbOrder.name}</td>
	               <td style="vertical-align:middle">${cancelorder.orderdate}</td>
	               <td style="vertical-align:middle">${cancelorder.ordercondition}</td>
	               <td style="vertical-align:middle">${cancelorder.paymentcondition}</td>
	               <td style="vertical-align:middle">${cancelorder.totalamount}</td>
	               <td >
	                 <form action="${contextRoot}/admin/orders/editorder" style="margin:auto 0px">
	                   	 <input type="hidden" name="id" value="${cancelorder.orderid}"/>
	                     <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
	                 </form>
	               </td>
	             </tr>
	             </c:forEach>
             </c:if>
           </tbody>
         </table>
	        <c:forEach var="cancelpageNumber" begin="1" end="${cancelpage.totalPages}">
				<c:choose>
					<c:when test="${cancelpage.number != cancelpageNumber-1 }">
						<a href="${contextRoot}/admin/orders?p=${cancelpageNumber}">${cancelpageNumber}</a>
					</c:when>
					<c:otherwise>${cancelpageNumber}</c:otherwise>
				</c:choose>
				<c:if test="${cancelpageNumber != cancelpage.totalPages }">-</c:if>
			</c:forEach>
           </div>
          </div>
              
              
  </section>
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
