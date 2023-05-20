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

<script>
document.cookie = "add=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
document.cookie = "addee=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
document.cookie = "tel=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
document.cookie = "shi=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
document.cookie = "pay=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";

</script>
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
            <div class="row">
				<div class="col-lg-11" style="text-align: right">總金額&nbsp;:</div>
				<div class="col-lg-1" style="text-align: right">
					<span id="totalamount"></span>
				</div>
				<div class="col-lg-11" style="text-align: right">運&nbsp;&nbsp;&nbsp;&nbsp;費&nbsp;:</div>
				<div class="col-lg-1" style="text-align: right;margin-top: 5px">
					<span id="freight"></span>
				</div>
				<div class="col-lg-11" style="text-align: right">優惠折抵:</div>
				<div class="col-lg-1" style="text-align: right;margin-top: 5px">
					<input id="point" type="hidden" value="${cookie.discount.value}">${cookie.discount.value}
				</div>
				<br>
				<br>
				<div class="col-lg-10"></div>
				<div class="col-lg-2">
					<hr>
				</div>
				<div class="col-lg-11" style="text-align: right">實付總額:</div>
				<div class="col-lg-1" style="text-align:right">
					<span id="finalamount" name="cookietotal"></span>
				</div>														
				</div>              
	         </div>
            </div>

            <form action="${contextRoot}/front/shoppingcart/shoppingcartdetail/check" method="get">
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
            	<a href="javascript:history.back()" class="btn btn-dark">上一頁</a>
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
	let counttotal = document.getElementsByClassName("countstotal");
	for(let i=0;i<counttotal.length;i++){
	  totalamount += parseInt(counttotal[i].value,10)
	}
	let point = document.getElementById("point").value;
	document.getElementById('totalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
	if(totalamount<1000 && totalamount>0){
	    document.getElementById('freight').innerHTML = "30";
	    totalamount = totalamount + 30 - point;
	    document.getElementById('finalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
	    document.cookie = "tol="+totalamount;  
	}else{
	    document.getElementById('freight').innerHTML = 0;
	    totalamount = totalamount - point;
	    document.getElementById('finalamount').innerHTML = totalamount.toLocaleString('zh-TW', {style: 'currency', currency: 'TWD', minimumFractionDigits: 0});
	    document.cookie = "tol="+totalamount;  
	}
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
