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


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.js"></script>



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
				<table class="table" style="border-color: white;">
                <thead class="table">
                  <tr>
                  	<th scope="col"></th>
                    <th scope="col">商品名稱</th>
                    <th scope="col">數量</th>
                    <th scope="col">金額</th>
                  </tr>
                </thead>
                <tbody>
                  <tr valign="middle">
                  	<td></td>
                    <td>${realrecord.bidProduct.name}</td>
                    <td>1</td>
                    <td>
                  		<input id="price" type="hidden" value="${realrecord.dealPrice}">
                  		<span id="bidprice"></span>               
                    </td>    
                  </tr> 
                  <tr class="table">
                  	<td>運&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;費:</td>
                  	<td></td>
                  	<td ></td>
                  	<td><span id="freight"></span></td>
                  </tr>
                  <tr>
                  	<td>實付總額:</td>
                  	<td></td>
                  	<td></td>
                  	<td><span id="totalamount"></span></td>
                  </tr>              
                </tbody>
              </table>              
	        </div>
	        <div>
	        </div>
            </div>
            <div class="entry entry-single">
				<h5>運送方式</h5>
					<div class="form-check">
					 <input type="radio" class="form-check-input" id="stores" value="超商取貨" required onclick="hiddenInput(event),okcash()" name="shipper"/>
                <label class="form-check-label" for="gridRadios1">
                  7-11超商取貨
                </label>
                <div id="store" style="display: none;width: 400px">
                  <div style="width: 400px">
                  <div style="margin-right10px;float: left;">縣&nbsp;&nbsp;&nbsp;市:</div>
                  	<select id="city"></select>
                  <div style="text-align: ceneter">門市&地址:</div>
                  	<select id="storeaddress"></select>
                  </div>
                  <div style="width: 300px">
	                  <label style="text-align:ceneter;float: left;width: 60px">收件人:</label>
	                  <input type="text" class="form-control" id="cookiesstoreaddressee"/>
                  </div>
                  <div style="width: 300px">
	                  <label style="text-align: ceneter;float: left;">電&nbsp;&nbsp;&nbsp;話:</label>
	                  <input type="tel" class="form-control" id="cookiesstoretele" pattern="[0]{1}[9]{1}[0-9]{8}" placeholder="格式:09XXXXXXXX"/>
                  </div>
                  <button type="button" class="btn btn-secondary" id="defaultDataBtnStore" style="margin-top: 10px">一鍵輸入</button>
                </div>
              </div>
              <div class="form-check">
                <input type="radio" class="form-check-input" id="home" value="宅配到家" onclick="showInput(event),nocash()" name="shipper"/>
                <label class="form-check-label" for="gridRadios2">
                  宅配到家
                </label>
                <div id="address" style="display: none;width: 400px">   
                  <div style="width: 300px">
                  <label style="text-align:ceneter;float: left;width: 60px">收件人:</label>
                  	<input type="text" class="form-control" id="cookiesaddressee"/>
                  </div>
                  <div style="width: 300px">
	                  <label style="text-align: ceneter;float: left;">地&nbsp;&nbsp;&nbsp;址:</label>
	                  <input type="text" class="form-control" id="cookiesaddress"/>
                  </div>
                  <div style="width: 300px">
	                  <label style="text-align: ceneter;float: left;">電&nbsp;&nbsp;&nbsp;話:</label>
	                  <input type="tel" class="form-control" id="cookiestele" pattern="[0]{1}[9]{1}[0-9]{8}" placeholder="格式:09XXXXXXXX"/>
                  </div>
                  <button type="button" class="btn btn-secondary" id="defaultDataBtnHome" style="margin-top: 10px">一鍵輸入</button> 	
                </div>
              </div>
            </div>
            <div class="entry entry-single">
				<h5>付款方式</h5>
					<div class="form-check">
            
					 <input type="radio" class="form-check-input" id="cash" value="貨到付款" required  name="pay"/>
		              <label class="form-check-label" for="gridRadios3">
		                貨到付款
		              </label>
				    </div>
		            <div class="form-check">
		              <input type="radio" class="form-check-input" id="credit" value="信用卡"  name="pay"/>
		              <label class="form-check-label" for="gridRadios4">
		                線上刷卡
		              </label>
		            </div>
            	</div>
            	<form action="${contextRoot}/front/shoppingcart/bid/check">
	            	<input value="${realrecord.bidProduct.id}" type="hidden" name="productId">
	         		<button type="submit" class="btn btn-primary" id="saveButton">
         			資料確認
         		</button>
         		</form>
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
// ----------------顯示宅配到家的資訊----------------------------
	function showInput(event){
		let address = document.getElementById("address");
		address.style.display="block"
		let store = document.getElementById("store");
		store.style.display="none"
	    let cookie1 = document.getElementById("cookiesaddressee");
		let cookie2 = document.getElementById("cookiesaddress");
		let cookie3 = document.getElementById("cookiestele");
	    cookie1.required="required";
	    cookie2.required="required";
	    cookie3.required="required";
    let storecookie2 = document.getElementById('cookiesstoreaddressee');
    let storecookie3 = document.getElementById('cookiesstoretele');

      storecookie2.removeAttribute('required');
      storecookie3.removeAttribute('required');
	}
// ----------------顯示超商取貨的資訊----------------------------
	function hiddenInput(event){
		let address = document.getElementById("address");
		address.style.display="none"
		let store = document.getElementById("store");
		store.style.display="block"
		let cookie1 = document.getElementById("cookiesaddressee");
		let cookie2 = document.getElementById("cookiesaddress");
		let cookie3 = document.getElementById("cookiestele");
	    cookie1.removeAttribute('required');
	    cookie2.removeAttribute('required');
	    cookie3.removeAttribute('required');
    let storecookie2 = document.getElementById('cookiesstoreaddressee');
    let storecookie3 = document.getElementById('cookiesstoretele');

      storecookie2.required="required"
      storecookie3.required="required"
	}
//------------點選宅配到家的選項後不可以點選貨到付款的----------------------------
	function nocash() {
	let cash = document.getElementById("cash")
    let stores = document.getElementById('stores')
		cash.disabled = true;
		if(cash.checked){
			cash.checked=false
		}
    if(stores.checked){
      stores.checked=false
    }
	}
	function okcash() {
	document.getElementById("cash").disabled = false;
    let home = document.getElementById("home")
    if(home.checked){
      home.checked=false;
    }
	}
  
//------------計算實付總額並存入cookies中----------------------------
  let totalamount = 0;
  let price = parseInt(document.getElementById('price').value)
  let freight = 30
  document.getElementById('bidprice').innerHTML = price.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
  document.getElementById('freight').innerHTML = freight.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
  totalamount = price+freight;
  document.getElementById('totalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
  document.cookie = "tol="+totalamount;  
  
	//超商資料一鍵輸入
	let defaultDataBtnStore = document.getElementById('defaultDataBtnStore')
	let inputName = document.getElementById('cookiesstoreaddressee')
	let inputtel = document.getElementById('cookiesstoretele')	
	defaultDataBtnStore.addEventListener("click",function(){
	   inputName.value = "瑪麗鷗"
	   inputtel.value="0988344712"
	 })
	 //宅配到家一鍵輸入
	let defaultDataBtnHome = document.getElementById('defaultDataBtnHome')
	let inputHomeAddre = document.getElementById('cookiesaddress')
	let inputHomeTel = document.getElementById('cookiestele')
	let inputHomeName = document.getElementById('cookiesaddressee')
	defaultDataBtnHome.addEventListener("click",function(){
		inputHomeName.value = "瑪麗鷗"
		inputHomeTel.value="0988344712"
		inputHomeAddre.value="台南市大學路1號(國立成功大學唯農大樓)"
	 })
  
</script>
<script src="${contextRoot}/js/shoppingcart/storeInfo.js"></script>
</body>

</html>
