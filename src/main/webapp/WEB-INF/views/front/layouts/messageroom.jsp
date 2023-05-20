<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>


            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js"></script>
            
    <!--    libs for stomp and sockjs-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <!--    end libs for stomp and sockjs-->
    
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet"
          type="text/css">
    <link href="${contextRoot}/styles/front/assets/css/messagestyle.css" rel="stylesheet">
  <style>
    /* CSS樣式 */
    #robot-button {
      position: fixed;
      bottom: 50px;
      right: 20px;
      width: 100px; /* 調整按鈕的寬度 */
      height: 100px; /* 調整按鈕的高度 */
      background: url('${contextRoot}/styles/front/assets/img/service/servicego.png') center/contain no-repeat; /* 按鈕的初始圖案，將'button1.jpg'替換為你的圖片URL */
      border-radius: 50%;
      cursor: pointer;
    }

    #robot-container {
      position: fixed;
      bottom: 180px; /* 調整容器的垂直位置 */
      right: 30px;
      width: 400px;
      height: 600px;
      background-color: #f1f1f1; /* 容器背景顏色，這裡使用了淺灰色 */
      padding: 10px;
      display: none;
      padding: 0%;
    }

  /* //聊天室模板 */
.cardchat{
	width: 100%;
  height: 100%;
	border: none;
	border-radius: 15px;
}
.adiv{
	background: #04CB28;
	border-radius: 15px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
	font-size: 12px;
	height: 46px;
}
.chat{
	border: none;
	background: #E2FFE8;
	font-size: 10px;
	border-radius: 20px;
}
  </style>
</head>
<body>
  <!-- 機器人按鈕 -->
  <div id="robot-button"></div>

  <!-- 機器人容器 -->
  <div id="robot-container">
    <div class="card">
      <div class="d-flex flex-row justify-content-between p-3 adiv text-white">
        <i class="fas fa-chevron-left"></i>
        <span class="pb-3">24小時即時客服</span>
        <i class="fas fa-times"></i>
      </div>
      
        <div class="search">
        <c:choose>
        <c:when test="${not empty sessionScope.customerId}">
         <input type="hidden" id="userName" placeholder="search" type="text" value="${sessionScope.customerId}" />
         </c:when>
          <c:otherwise>
         <input type="hidden" id="userName" placeholder="search" type="text" value="遊客" />
          </c:otherwise>
        </c:choose>
        </div>
        
     <div id="box" class="felx-container-center-center" style="overflow:auto;height:500px;weight:100%;">
                    <div class="chat-history">
                      <ul>

                      </ul>

                    </div> <!-- end chat-history -->

                  </div>
        <div class="form-group px-3">
        </div>
            <textarea id="message-to-send" name="message-to-send" placeholder="輸入訊息" rows="3" maxlength="200"></textarea>

            <button id="sendBtn">Send</button>
    </div>
  </div>

<script src="${contextRoot}/styles/front/assets/js/custom.js"></script>
<script src="${contextRoot}/styles/front/assets/js/chat.js"></script>
  <script>

  // JavaScript代碼
  var robotButton = document.getElementById('robot-button');
  robotButton.addEventListener("click", registration);  


  var robotContainer = document.getElementById('robot-container');
  var submitButton = document.getElementById('submit-button');
  var isButtonClicked = false; // 追蹤按鈕的狀態

  // 頁面載入時，將按鈕的初始狀態設置為未點擊
  robotButton.style.background = "url('${contextRoot}/styles/front/assets/img/service/servicego.png') center/contain no-repeat"; // 修改此行

  robotButton.addEventListener('click', function() {
    if (isButtonClicked) {
      // 將按鈕的背景圖案還原回原始圖案
      robotButton.style.background = "url('${contextRoot}/styles/front/assets/img/service/servicego.png') center/contain no-repeat"; // 修改此行
      robotContainer.style.display = 'none'; // 隱藏文字框
    } else {
      // 更換按鈕的背景圖案
      robotButton.style.background = "url('${contextRoot}/styles/front/assets/img/service/messagebtn.png') center/contain no-repeat"; // 修改此行
      robotContainer.style.display = 'block'; // 添加此行
    }

    isButtonClicked = !isButtonClicked; // 切換按鈕的狀態
  });

  submitButton.addEventListener('click', function() {
    var textInput = document.getElementById('text-input');
    var text = textInput.value;
    console.log(text);
    textInput.value = '';
  });
  </script>

            <script id="message-template" type="text/x-handlebars-template">
    <li class="message-row">
        <div class="message-data align-right">
            <span class="message-data-time">{{time}}</span> &nbsp; &nbsp;
            <span class="message-data-name">你</span> 
        </div>
        <div class="sendmessage"  >
            {{messageOutput}}
        </div>
    </li>
</script>
            <script id="message-response-template" type="text/x-handlebars-template">
    <li>
      <div class="message-row">
            <span class="message-data-name" style="font-size:5px;"><i class="fa fa-circle online"></i> 用戶:{{userName}}</span>
            <span class="message-data-time">{{time}}</span>
        </div>
        <div class="chat" id="userfontbackcolor">
            {{response}}
        </div>
    </li>
</script>
  
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
<!-- <a href='https://.pngtree.com/so/方形q版按鈕'>方形q版按鈕 png來自 .pngtree.com/</a> -->

