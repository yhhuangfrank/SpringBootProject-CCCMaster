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
          <div class="col-lg-8 entries">
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
                    <th scope="row"></th>
                    <td>
                    	${sc.productBean.productName}
                    </td>
                    <td>
                    	${sc.quantity}
                    </td>
                    <td>${sc.productBean.price}</td>
                    <td>
                      ${sc.quantity*sc.productBean.price}
                    </td>       
                  </tr>
                  	</c:forEach>                  
                </tbody>
              </table>
            </div>
          </div>
          <div class="col-lg-8 entries">
            <div class="entry entry-single">
              <h5>優惠方式</h5>
              	<ul>
              		<div class="form-check">
              			<input class="form-check-input" type="checkbox">
              			<label class="form-check-label" for="gridCheck1">
              				使用點數              	
            			</label>
            			<input type="number">
            		</div>
              		<div class="form-check">
              			<input class="form-check-input" type="checkbox">
              			<label class="form-check-label" for="gridCheck1">
              				使用優惠券              	
            			</label>
            		</div>
              	</ul>
            	
            </div>
          </div>
          <div class="col-lg-8 entries">
            <div class="entry entry-single">
				<h5>運送方式</h5>
            </div>
          </div>
          <div class="col-lg-8 entries">
            <div class="entry entry-single">
				<h5>付款方式</h5>
            </div>
          </div>
        </div>
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
  let totalamount = 0;
  let counttotal = document.getElementsByClassName("countstotal");
  for(let i=0;i<counttotal.length;i++){
    totalamount += parseInt(counttotal[i].value,10)
  }
  document.getElementById('totalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
  if(totalamount<1000 && totalamount>0){
      document.getElementById('freight').innerHTML = "30";
      totalamount = totalamount + 30;
      document.getElementById('finalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    }else{
      document.getElementById('freight').innerHTML = 0;
      document.getElementById('finalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    }
    
  //數量-1
  function dec(count){
    let valueInput = document.getElementById('quantity'+count);
    let qua = document.getElementById('price'+count);
    var totde = document.getElementById('total'+count)
    let values = parseInt(valueInput.value)
    if(values>1){
      valueInput.value=values - 1;
      totde.value=qua.value*valueInput.value;
      totde.innerText='totde.value'
      let totalamount = 0;
     let counttotal = document.getElementsByClassName("countstotal");
     for(let i=0;i<counttotal.length;i++){
    totalamount += parseInt(counttotal[i].value,10)
   }
    document.getElementById('totalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    if(totalamount<1000 && totalamount>0){
      document.getElementById('freight').innerHTML = "30";
      totalamount += 30;
      document.getElementById('finalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    }else{
      document.getElementById('freight').innerHTML = 0;
      document.getElementById('finalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    }
    }
  }
  
  //數量+1
  function inc(count){
    let valueInput = document.getElementById('quantity'+count);
    let qua = document.getElementById('price'+count);
    var totinc = document.getElementById('total'+count)
    let max = parseInt(valueInput.getAttribute('data-max'),10)
    let values = parseInt(valueInput.value)
    if(values<max){
      valueInput.value=values + 1;
      totinc.value=qua.value*valueInput.value;
      document.getElementById("")
      let totalamount = 0;
    let counttotal = document.getElementsByClassName("countstotal");
    for(let i=0;i<counttotal.length;i++){
      totalamount += parseInt(counttotal[i].value,10)
    }
  document.getElementById('totalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
  if(totalamount<1000 && totalamount>0){
      document.getElementById('freight').innerHTML = "30";
      totalamount += 30;
      document.getElementById('finalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    }else{
      document.getElementById('freight').innerHTML = 0;
      document.getElementById('finalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    }    
    }  
  } 
  //數量欄位檢查
  function check(event){
    const max = parseInt(input.getAttribute('data-max'),10)
    let values = parseInt(input.value,10);
    if(isNaN(values) || values < 1){
      values = 1;
    }
    if(values > max){
      values = max;
    }
    input.value=values;
  }
  
</script>

</body>

</html>
