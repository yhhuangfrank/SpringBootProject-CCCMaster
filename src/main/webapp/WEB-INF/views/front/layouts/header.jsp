<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <!-- ======= Header ======= -->
    <header id="header" class="d-flex align-items-center">
      <div class="container d-flex justify-content-between align-items-center">

        <div class="logo">
          <h1><a href="${contextRoot}/">Eterna</a></h1>
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
            <li><a class="active" href="about.html">通知</a></li>
            <li><a href="${contextRoot}/front/product">商城</a></li>
            <li class="dropdown"><a href="#"><span>二手賣場</span></a>
              <ul>
                <li><a href="${contextRoot}/bidProducts">所有商品</a></li>
                <li><a href="${contextRoot}/bidProducts/create">新增商品</a></li>
              </ul>
            </li>
            <li><a href="team.html">論壇</a></li>
            <li><a href="pricing.html">聯絡客服</a></li>
            <li><a href="blog.html">會員中心</a></li>
            <li><a href="${contextRoot}/front/shoppingcart">購物車</a></li>
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
      <c:if test="${logoutSuccessful}">
	      <div id="logout-success-msg" class="alert alert-success position-fixed top-50 start-50 translate-middle d-none" role="alert">
			  您已成功登出！欲使用進階功能請重新登入!
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
      
      
    </header>
    <!-- End Header -->