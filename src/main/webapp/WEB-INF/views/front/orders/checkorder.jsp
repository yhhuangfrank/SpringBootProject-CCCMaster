<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>購物車</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

  <!-- Favicons -->
  <link href="${contextRoot}/styles/front/assets/img/favicon.png" rel="icon">
  <link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${contextRoot}/styles/front/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link href="${contextRoot}/styles/back/assets/vendor/remixicon/remixicon.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">

<style>
.mb-3{
font-size: 20px
}
</style>

</head>

<body>

<jsp:include page="../layouts/topbar.jsp"/>

<jsp:include page="../layouts/header.jsp"/>
<main id="main">

  <!-- ======= Breadcrumbs ======= -->
  <section id="breadcrumbs" class="breadcrumbs">
    <div class="container">

      <ol>
        <li><a href="index.html">首頁</a></li>
        <li>購物車</li>
      </ol>
      <h2>購物車</h2>

    </div>
  </section><!-- End Breadcrumbs -->
   
<section id="blog" class="blog">
<form:form method="post" modelAttribute="orderBean" action="${contextRoot}/front/orders/create">
    <div class="container" data-aos="fade-up">
      <div class="row">
        <div class="entries">
          <div class="entry entry-single">
	          <div class="row mb-3">
                 <label for="inputText" class="col-sm-2 col-form-label" style="text-align: right;">取貨人:</label>
                 <div class="col-sm-10" style="height: 45px;line-height: 45px">
                 	<input type="hidden" name="addressee" value="${cookie.addee.value}">
                 	${cookie.addee.value}
                 </div>
	           </div>
	            <div class="row mb-3">
                 <label for="inputText" class="col-sm-2 col-form-label" style="text-align: right;">取貨人電話:</label>
                 <div class="col-sm-10" style="height: 45px;line-height: 45px">
                 	<input type="hidden" name="telephone" value="${cookie.tel.value}">
                 	${cookie.tel.value}
                 </div>
	           </div>
	            <div class="row mb-3">
                 <label for="inputText" class="col-sm-2 col-form-label" style="text-align: right;">取貨地址:</label>
                 <div class="col-sm-10" style="height: 45px;line-height: 45px">
                 	<input type="hidden" name="shipperaddress" value="${cookie.add.value}">
                 	${cookie.add.value}
                 </div>
	           </div>
          	   <div class="row mb-3">
                 <label for="inputText" class="col-sm-2 col-form-label" style="text-align: right;">付款方式:</label>
                 <div class="col-sm-10" style="height: 45px;line-height: 45px">
                 	<input type="hidden" name="payment" value="${cookie.pay.value}">
                   ${cookie.pay.value}
                 </div>
               </div>
           	   <div class="row mb-3">
                 <label for="inputText" class="col-sm-2 col-form-label" style="text-align: right;">取貨方式:</label>
                 <div class="col-sm-10" style="height: 45px;line-height: 45px">
                 	<input type="hidden" name="shipper" value="${cookie.shi.value}">
                   ${cookie.shi.value}
                 </div>
               </div>
               <div class="row mb-3">
                 <label for="inputText" class="col-sm-2 col-form-label" style="text-align: right;">實付總額:</label>
                 <div class="col-sm-10" style="height: 45px;line-height: 45px">
                   ${cookie.tol.value}
                 </div>
               </div>
               <div class="row mb-3">
                 <label for="inputText" class="col-sm-2 col-form-label" style="text-align: right;">商品明細:</label>
                 <div class="col-sm-10">
                   <table class="table">
	                <thead>
	                  <tr>
	                    <th scope="col">#</th>
	                    <th scope="col">商品名稱</th>
	                    <th scope="col">數量</th>
	                    <th scope="col">單價</th>
	                  </tr>
	                </thead>
	                <tbody>
	                <c:forEach var="sc" items="${shoppingcart}" varStatus="status"> 
	                  <tr valign="middle">
	                    <th scope="row">
			                <div style="display: none;">
			            		<input value="${sc.shoppoingCartId}" type="text"/>
			         		</div>
			         		${status.count}
	                    </th>
	                    <td>
	                    	${sc.productBean.productName}                   	                  	
	                    </td>
	                    <td>
	                    	<input id="quantity${status.count}" type="hidden" value="${sc.scquantity}" >
	                    	${sc.scquantity} 
	                    </td>
	                    <td>
	                    	<input id="price${status.count}" type="hidden" value="${sc.productBean.price}">
	                    	${sc.productBean.price}
	                    	<input id="total${status.count}" type="hidden" value="${sc.scquantity*sc.productBean.price}" class="countstotal">           
	                    </td>       
	                  </tr>
	                  </c:forEach>                  
	                </tbody>
	              </table>
                 </div>
               </div>
              <div style="text-align: center;">
              	<a href="javascript:history.back()" class="btn btn-dark">上一頁</a>
              	<input value="${sessionScope.customerId}" type="hidden" id="session" name="customerId">
   				<button type="submit" class="btn btn-primary">確認</button>
   		      </div>
          </div>
        </div>      
      </div>	
    </div>
   </form:form>
  </section><!-- End Blog Single Section -->
</main><!-- End #main -->



<jsp:include page="../layouts/footer.jsp"/>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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
<script>


  
</script>

</body>

</html>
