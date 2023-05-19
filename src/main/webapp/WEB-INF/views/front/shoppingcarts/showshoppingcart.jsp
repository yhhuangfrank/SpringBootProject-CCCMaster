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
  
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

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
                    <th scope="col" style="text-align: center;">小計</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                   <c:forEach var="sc" items="${shoppingcart}" varStatus="status">
                  <tr valign="middle" id="row${status.count}" data-id="${sc.shoppoingCartId}">
                    <th scope="row"></th>
                    <td>
                    	<img src="${contextRoot}/product/mainImage/${sc.productBean.productId}" alt="" width="60px" height="60px">
                    	${sc.productBean.productName}
                    </td>
	                    <td>
	                    	<div class="input-group" style="width: 150px;">
	                    	  <button id="dec${status.count}" class="btn btn-outline-secondary" type="button" onclick="dec(${status.count})" >-</button>             	  
	                    	    <input id="quantity${status.count}" type="text" value="${sc.scquantity}" class="form-control text-center" min="1" data-max="${sc.productBean.inventory}" onchange="check(event)" name="scquantity">
	                    	  <button id="inc${status.count}" class="btn btn-outline-secondary" type="button" onclick="inc(${status.count})">+</button>
	                    	</div>                 	
	                    </td>
                    <td><input id="price${status.count}" type="hidden" value="${sc.productBean.price}">${sc.productBean.price}</td>
                    <td>
                      <input id="total${status.count}" type="text" value="${sc.scquantity*sc.productBean.price}" 
                      readonly="readonly" style="outline: none;text-align: right;width: 50px;border: 0px;" class="countstotal">
                    </td>
                    <td>
                    	<form:form action="${contextRoot}/front/shoppingcart/delete" method="post" style="margin-top: 15px">
                    		<input type="hidden" name="_method" value="delete"/>
	                    	<input type="hidden" name="id" value="${sc.shoppoingCartId}"/>
                    		<button type="submit"><i class="ri-delete-bin-6-line"></i></button>
                    	</form:form>
                    </td>             
                  </tr>
                 </c:forEach>   	               
                </tbody>
              </table>
            </div>
          </div>
          <div class="col-lg-4">
          <div class="sidebar">
              <h5>優惠方式</h5>
              	<div class="form-check">
              			<input class="form-check-input" type="checkbox" id="pointcheckbox" onclick="calculateFinalAmount()">
              			<label class="form-check-label" for="gridCheck1" for="points">
              				使用點數              	
            			</label>
            			<div >
            				<input type="number" id="points" class="form-control col-sm-4" onchange="calculateFinalAmount()"></input>
            				(現有${customer.point}點)<input value="${customer.point}" type="hidden" id="cupoint">
            				<div id="canusepoint"></div>
            			</div>
            		</div>
              			<div class="form-check">
	              			<input class="form-check-input" type="checkbox" onclick="calculateFinalAmount(),appearcoupon()" id="couponcheckbox">
	              			<label class="form-check-label" for="gridCheck1">
	              				使用優惠券              	
	            			</label>
	            			<div id="coupons" style="display: none">
	            				<c:forEach items="${coupon}" var="cp" varStatus="status">
                        <div>
                          <input type="radio" class="form-check-input" name="usecoupon" id="usecoupons${status.count}" value="${cp.couponBean.couponamount}" onclick="calculateFinalAmount();storeCouponId('${cp.couponBean.couponid}')">
                          <label>${cp.couponBean.couponamount},${cp.couponBean.couponname}(${cp.couponBean.enddate})</label>
                        </div>
	            				</c:forEach>
	            			</div>
            			</div>          	
            </div>
            <div class="sidebar">
            <div class="row">
				<div class="col-lg-4">總金額&nbsp;:</div>
				<div class="col-lg-8" style="text-align: right">
					<span id="totalamount"></span>
				</div>
				<div class="col-lg-4" style="margin-top: 5px">運&nbsp;&nbsp;&nbsp;&nbsp;費&nbsp;:</div>
				<div class="col-lg-8" style="text-align: right;margin-top: 5px">
					<span id="freight"></span>
				</div>
				<div class="col-lg-4" style="margin-top: 5px">優惠折抵:</div>
        			<div class="col-lg-8" style="text-align: right;margin-top: 5px">
					<span id="discount"></span>
				</div>
				<br>
				<br>
				<hr>
				<div class="col-lg-4">實付總額:</div>
				<div class="col-lg-8" style="text-align:right">
					<span id="finalamount"></span>
				</div>										
						<div class="d-grid gap-2 mt-3">
							<a href="${contextRoot}/front/shoppingcart/shoppingcartdetail" style="color: white;text-align: center;">
								<div class="d-grid gap-2 mt-3">
									<botton type="button" class="btn btn-danger">
				                        結帳去
			                    	</botton>
		                    	</div>
	                    	</a>											
						</div>					
				</div>
            </div><!-- End sidebar -->
          </div><!-- End blog sidebar -->
        </div>
      </div>   
    </section>
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
  let canusepoint = document.getElementById('canusepoint')  //可使用點數的div
  let cupoints = document.getElementById('cupoint').value   //會員點數
  var usepoint = Math.floor(cupoints/300);                  //計算可用的點數
  canusepoint.innerHTML = "(最多可折抵"+usepoint+"點)"
  var totalamount = 0;
  let counttotal = document.getElementsByClassName("countstotal");
  for(let i=0;i<counttotal.length;i++){
    totalamount += parseInt(counttotal[i].value,10)
  }
    document.getElementById('totalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    let freight=30
    document.getElementById('freight').textContent = freight.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});;
    document.getElementById('finalamount').innerHTML = (totalamount+freight).toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    if(totalamount>1000){
      freight=0
      document.getElementById('freight').textContent = freight.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});;
      document.getElementById('finalamount').textContent = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
  }
  function calculateFinalAmount(){
    //計算總金額
    let pointCheckbox = document.getElementById('pointcheckbox') 
    let couponCheckbox = document.getElementById('couponcheckbox')
    let pointsInput = document.getElementById('points')
      pointsInput.addEventListener('input',function(){
        pointcheckbox.checked=true; 
        //使用點數限制
        if(isNaN(pointsInput.value) || pointsInput.value < 1){
          pointsInput.value=0;
        }
        if(pointsInput.value>usepoint){
          pointsInput.value=usepoint
        };
        pointsInput.value=pointsInput.value
      })
    let selectCoupon = document.querySelector('input[name="usecoupon"]:checked')
    let discount=0
    if(pointCheckbox.checked && !couponCheckbox.checked){
      discount=parseInt(pointsInput.value) || 0;
    }else if(pointCheckbox.checked && couponCheckbox.checked && selectCoupon){
      discount=(parseInt(pointsInput.value)|| 0)+parseInt(selectCoupon.value)
    }else if(!pointCheckbox.checked && couponCheckbox.checked && selectCoupon){
      discount=parseInt(selectCoupon.value)
    }else if(!pointCheckbox.checked && !couponCheckbox.checked && !selectCoupon){
      discount=0
    }
    document.cookie = "point="+parseInt(pointsInput.value)+";path=/";
    document.cookie = "discount="+discount+";path=/";
    let finalAmount = totalamount+freight-discount

    document.getElementById('freight').textContent=freight.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    document.getElementById('discount').textContent=discount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
    document.getElementById('finalamount').textContent=finalAmount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
}
  function storeCouponId(couponId){
    document.cookie = "couponId="+couponId;
  }
  //數量-1
  function dec(count){
    let valueInput = document.getElementById('quantity'+count); //數量
    let qua = document.getElementById('price'+count);           //價格
    let values = parseInt(valueInput.value)
    let scid = document.getElementById('row'+count).getAttribute('data-id')  //取得shoppingcartid
    if(values>1){
      valueInput.value=values - 1;
      $.ajax({
        type:"PUT",
        url:"http://localhost:8080/front/shoppingcart",
        data:{
          shoppoingCartId:scid,
          scquantity:valueInput.value
        }
      })
      document.getElementById('total'+count).value=qua.value*valueInput.value;  //小計
      //累加小計
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
	    let max = parseInt(valueInput.getAttribute('data-max'),10)
      let scid = document.getElementById('row'+count).getAttribute('data-id')  //scid
	    let values = parseInt(valueInput.value)
	    if(values<max){
	      valueInput.value=values + 1;
        $.ajax({
        type:"PUT",
        url:"http://localhost:8080/front/shoppingcart",
        data:{
          shoppoingCartId:scid,
          scquantity:valueInput.value
        }
      })
	      document.getElementById('total'+count).value=qua.value*valueInput.value;
	      let totalamount = 0;
      //累加小計
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
  //顯示優惠券
  function appearcoupon(){
    let couponcheckbox = document.getElementById('couponcheckbox')
    if(couponcheckbox.checked){
      let coupons = document.getElementById('coupons')
      coupons.style.display="block"
    }else{
      coupons.style.display="none"
    }
  }
  
  
  
</script>

</body>

</html>
