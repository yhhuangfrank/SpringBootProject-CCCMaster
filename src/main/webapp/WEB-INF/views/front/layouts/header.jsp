<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <!-- ======= Header ======= -->
    <header id="header" class="d-flex align-items-center">
      <div class="container d-flex justify-content-between align-items-center">

        <div class="logo">
          <h1 style="font-family:Cursive;font-size:50px;"><a href="${contextRoot}/">山西達人</a></h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <nav id="navbar" class="navbar">
          <ul>
            <li class="dropdown"><a href="#"><span>下拉式example</span> <i class="bi bi-chevron-down"></i></a>
              <ul>
                <li><a href="#">Drop Down 1</a></li>
                <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                  <ul>
                    <li><a href="#">Deep Drop Down 1</a></li>
                    <li><a href="#">Deep Drop Down 2</a></li>
                    <li><a href="#">Deep Drop Down 3</a></li>
                    <li><a href="#">Deep Drop Down 4</a></li>
                    <li><a href="#">Deep Drop Down 5</a></li>
                  </ul>
                </li>
                <li><a href="#">Drop Down 2</a></li>
                <li><a href="#">Drop Down 3</a></li>
                <li><a href="#">Drop Down 4</a></li>
              </ul>
            </li>
            <li><a href="about.html">通知</a></li>
            <li><a href="${contextRoot}/front/product">商城</a></li>
            <li class="dropdown"><a href="#"><span>二手賣場</span></a>
              <ul>
                <li><a href="${contextRoot}/bidProducts">所有商品</a></li>
                <li><a href="${contextRoot}/bidProducts/create">新增商品</a></li>
              </ul>
            </li>
            <li><a href="${contextRoot}/forums/showAllForum">論壇</a></li>
           <li class="dropdown"><a href="#"><span>聯絡客服</span></a>
              <ul>
                <li><a href="${contextRoot}/Service/common">常見問題</a></li>
                <li><a href="${contextRoot}/service/from/create">表單回報問答中心</a></li>
              </ul>
            </li>
            <li><a href="blog.html">會員中心</a></li>
            <li><input value="${sessionScope.customerId}" type="hidden" id="session" name="customerId"><a href="#" onclick="checklogin()">購物車</a></li>
           	<c:choose>
           		<c:when test="${sessionScope.customerId == null}">
           			<li><a href="index.html">註冊</a></li>
		            <li><a href="${contextRoot}/login">登入</a></li>
           		</c:when>
           		<c:otherwise>
		            <li class="dropdown">
		            	<a href="${contextRoot}/customerCenter"><span>${sessionScope.customerName}，您好</span></a>
		              	<ul>
			                <li><a href="${contextRoot}/customerCenter">會員中心</a></li>
			                <li><a href="#">未來功能預留</a></li>
			                <li><a href="${contextRoot}/logout">登出</a></li>
		              	</ul>
		            </li>
           		</c:otherwise>
           	</c:choose>
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->

      </div>

	  <!-- 以下內容 add By YUYU -->
	  <c:if test="${logoutSuccess}">
	  	<div id="logout-success-msg" class="alert alert-success position-fixed top-50 start-50 translate-middle d-none" role="alert">
 	  		${logoutSuccessMsg}
	  	</div>
	 	  <script>
		  	// 顯示登出成功訊息框
		  	document.querySelector('#logout-success-msg').classList.remove('d-none');
		  	// 設定 2 秒後淡出消失
		  	setTimeout(function() {
		  	document.querySelector('#logout-success-msg').classList.add('fade');
		  	}, 2000);
		  </script>
	  </c:if>
	  
      <!-- 以下內容 add By 麻油 -->
      <script>
      let session = document.getElementById('session')
      function checklogin() {
		if(session.value){
			window.location.href="http://localhost:8080/front/shoppingcart";
		}else{
			window.location.href = "http://localhost:8080/login";
		}
	}
      </script>
      
    </header>
    <!-- End Header -->