<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Example</title>
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

<script>


</script>

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
      <div class="container" data-aos="fade-up">
        <div class="row">
            <div class="entry entry-single">
				<table class="table">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">商品名稱</th>
                    <th scope="col">數量</th>
                    <th scope="col">單價</th>
                    <th scope="col">小計</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="sc" items="${shoppingcart}" varStatus="status"> 
                  <tr valign="middle">
                    <th scope="row">
                    </th>
                    <td>
                    	${sc.productBean.productName}	                  	
                    </td>
                    <td>
                    	${sc.quantity} 
                    </td>
                    <td>
                    	${sc.productBean.price}           
                    </td>
                    <td>
                    	${sc.quantity*sc.productBean.price}                   
                    </td>       
                  </tr>
                  	</c:forEach>                  
                </tbody>
              </table>          
	            </div>
            </div>
            <form:form method="PUT" modelAttribute="sc" action="${contextRoot}/front/shoppingcart/shoppingcartdetail">
            <div class="entry entry-single">
              <h5>優惠方式</h5>
              	<div class="form-check">
              			<input class="form-check-input" type="checkbox">
              			<label class="form-check-label" for="gridCheck1" for="points">
              				使用點數              	
            			</label>
            			<div class="col col-lg-2">
            				<input type="text" id="points" class="form-control col-sm-4"></input>
            			</div>
            		</div>
              			<div class="form-check">
	              			<input class="form-check-input" type="checkbox">
	              			<label class="form-check-label" for="gridCheck1">
	              				使用優惠券              	
	            			</label>
            			</div>          	
            </div>
            <div class="entry entry-single">
				<h5>運送方式</h5>
					<div class="form-check">
					 <form:radiobutton class="form-check-input" path="scpayment" id="store" value="超商取貨" required="required" onclick="hiddenInput(event),okcash()"/>
                      <label class="form-check-label" for="store">
                        超商取貨
                      </label>
                    </div>
                    <div class="form-check">
                      <form:radiobutton class="form-check-input" path="scpayment" id="home" value="宅配到家" onclick="showInput(event),nocash()" />
                      <label class="form-check-label" for="home">
                        宅配到家
                      </label>
                      <div id="address" style="display: none;width: 400px">   
                      	<div style="width: 300px">
	                  		<label style="text-align:ceneter;float: left;width: 60px">收件人:</label>
	                  		<form:input path="addressee" type="text" class="form-control"/>
	                     </div>
	                     <div style="width: 300px">
	                  		<label style="text-align: ceneter;float: left;">地&nbsp;&nbsp;&nbsp;址:</label>
	                  		<form:input path="shipperaddress" type="text" class="form-control"/>
	                     </div>
	                     <div style="width: 300px">
	                  		<label style="text-align: ceneter;float: left;">電&nbsp;&nbsp;&nbsp;話:</label>
	                  		<form:input path="telephone" type="text" class="form-control"/>
	                     </div> 	
                      </div>
                    </div>
            </div>
            <div class="entry entry-single">
				<h5>付款方式</h5>
					<div class="form-check">
					 <form:radiobutton class="form-check-input" path="shipper" id="cash" required="required" value="貨到付款"/>
                      <label class="form-check-label" for="cash">
                        貨到付款
                      </label>
                    </div>
                    <div class="form-check">
                     <form:radiobutton class="form-check-input" path="shipper" id="credit" value="信用卡"/>
                      <label class="form-check-label" for="credit">
                        信用卡
                      </label>
                    </div>
            </div>
         		<button type="submit" class="btn btn-primary" >確認資料</button>
 		</form:form>
        </div> 
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
	function showInput(event){
	  let address = document.getElementById("address");
	  address.style.display="block"
	}
	function hiddenInput(event){
		let address = document.getElementById("address");
		address.style.display="none"
	}
	function nocash() {
		document.getElementById("cash").disabled = true;
	}
	function okcash() {
		document.getElementById("cash").disabled = false;
	}

  
</script>

</body>

</html>
