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
                  <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">總覽</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">未付款</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">處理中</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="refund-tab" data-bs-toggle="tab" data-bs-target="#refund" type="button" role="tab" aria-controls="refund" aria-selected="false">退款中</button>
                </li>
              </ul>
              <div class="tab-content pt-2" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
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
                 </tbody>
              </table>
                </div>
                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                  Nesciunt totam et. Consequuntur magnam aliquid eos nulla dolor iure eos quia. Accusantium distinctio omnis et atque fugiat. Itaque doloremque aliquid sint quasi quia distinctio similique. Voluptate nihil recusandae mollitia dolores. Ut laboriosam voluptatum dicta.
                </div>
                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                  Saepe animi et soluta ad odit soluta sunt. Nihil quos omnis animi debitis cumque. Accusantium quibusdam perspiciatis qui qui omnis magnam. Officiis accusamus impedit molestias nostrum veniam. Qui amet ipsum iure. Dignissimos fuga tempore dolor.
                </div>
                <div class="tab-pane fade" id="refund" role="tabpanel" aria-labelledby="refund-tab">
                  Saepe animi et soluta ad odit soluta sunt. Nihil quos omnis animi debitis cumque. Accusantium quibusdam perspiciatis qui qui omnis magnam. Officiis accusamus impedit molestias nostrum veniam. Qui amet ipsum iure. Dignissimos fuga tempore dolor.
                </div>
              </div>
              
              <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
				<c:choose>
					<c:when test="${page.number != pageNumber-1 }">
						<a href="${contextRoot}/admin/orders?p=${pageNumber}">${pageNumber}</a>
					</c:when>
					<c:otherwise>${pageNumber}</c:otherwise>
				</c:choose>
				<c:if test="${pageNumber != page.totalPages }">-</c:if>
			</c:forEach>
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
