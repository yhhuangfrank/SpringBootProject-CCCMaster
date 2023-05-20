<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
  <title>優惠券</title>
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
        <h1>優惠券列表</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/">首頁</a></li>
                <li class="breadcrumb-item">優惠券發放</li>
                <li class="breadcrumb-item active">優惠券列表</li>
            </ol>
        </nav>
    </div>
 <section class="section">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-center fw-bold"></h5>
              <table class="table" style="text-align: center;border:1px,solid,black">
                <thead>
                  <tr>
                    <th scope="col">名稱</th>
                    <th scope="col">兌換代碼</th>
                    <th scope="col">金額</th>
                    <th scope="col">使用起始日期</th>
                    <th scope="col">使用結束日期</th>
                    <th scope="col">說明</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="cp" items="${page.content}">
                  <tr>
                    <td style="vertical-align:middle">${cp.couponname}</td>
                    <td style="vertical-align:middle">${cp.convertid}</td>
                    <td style="vertical-align:middle">${cp.couponamount}</td>
                    <td style="vertical-align:middle">${cp.startdate}</td>
                    <td style="vertical-align:middle">${cp.enddate}</td>
                    <td style="vertical-align:middle">${cp.instructions}</td>
                    <td>
                    	<form action="${contextRoot}/coupons/editcoupon" style="margin:auto 0px">
	                    	<input type="hidden" name="id" value="${cp.couponid}"/>
	                        <button type="submit" class="btn btn-outline-dark"><i class="bi bi-pencil"></i></button>
                    	</form>
                    </td>
                    <td>                    	
                   		<button type="button" data-bs-toggle="modal" data-bs-target="#delete" class="btn btn-outline-danger" ><i class="bi bi-trash"></i></button>	                    		            
						<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel"></h5>
										<button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<h3>是否確定刪除?</h3>
									</div>
									<div class="modal-footer">
									<form action="${contextRoot}/coupons/delete" style="margin:auto" method="post">
										<input type="reset" class="btn btn-secondary" data-bs-dismiss="modal" value="否">         		
                  						<input type="hidden" name="_method" value="delete"/>
                   						<input type="hidden" name="id" value="${cp.couponid}"/>	            
										<input type="submit" class="btn btn-primary" value="確定">
										</form>
									</div>
								</div>
							</div>
						</div>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
</div>
                </div>

            </div>
        </div>
    </section>
          <br>
          <div style="text-align: center;">
          <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
				  <c:choose>
				     <c:when test="${page.number != pageNumber-1 }">
				          <a href="${contextRoot}/Coupons?p=${pageNumber}">${pageNumber}</a>
				     </c:when>
				     <c:otherwise>
				            ${pageNumber}
				     </c:otherwise>				  
				  </c:choose>		
				  <c:if test="${pageNumber != page.totalPages }">
				    -
				  </c:if>
			</c:forEach>
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
