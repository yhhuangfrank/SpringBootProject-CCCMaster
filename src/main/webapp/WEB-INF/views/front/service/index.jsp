<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
  <meta charset="UTF-8">
  <title>websocket-demo</title>
  
  <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.2.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container py-3">
    
    <div class="row">
      
      <div class="col-6">
        <div>
          <label for="messageArea">聊天信息:</label>
        </div>
        <div>
          <textarea id="messageArea" readonly class="w-100" style="height: 75vh;"></textarea>
        </div>
      </div>
      
      <div class="col">
        
        <div class="my-1">
          <label for="messageArea">用 户 名:</label>
        </div>
        
        <div class="my-1">
          <input type="text" id="username" autocomplete="off">
        </div>
        
        <div class="my-1">
          <button class="btn-info" id="joinRoomBtn">进入聊天室</button>
          <button class="btn-warning" id="leaveRoomBtn">离开聊天室</button>
        </div>
        
        <hr/>
        
        <div class="my-1">
          <label for="sendMessage">输入消息:</label>
        </div>
        <div>
          <textarea id="sendMessage" rows="5" class="w-100" style="max-height: 50vh"></textarea>
        </div>
        
        <div class="my-1">
          <button class="btn-primary" id="sendBtn">发送消息</button>
        </div>
      
      </div>
    
    </div>
  
  </div>
  
  <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
  
  <script>
    let webSocket;
    //ip和端口号用自己项目的
    //{websocket}: 其实是刚刚那个@ServerEndpoint("/websocket")中定义的
    let url = 'ws://127.0.0.1:8080/websocket';
    
    $('#username').keyup(function (e) {
      let keycode = e.which;
      if (keycode == 13) {
        $('#joinRoomBtn').click();
      }
    });
    
    //进入聊天室
    $('#joinRoomBtn').click(function () {
      let username = $('#username').val();
      webSocket = new WebSocket(url);
      webSocket.onopen = function () {
        console.log('webSocket连接创建。。。');
      }
      webSocket.onclose = function () {
        console.log('webSocket已断开。。。');
        $('#messageArea').append('websocket已断开\n');
      }
      webSocket.onmessage = function (event) {
        $('#messageArea').append(event.data + '\n');
      }
      webSocket.onerror = function (event) {
        console.log(event)
        console.log('webSocket连接异常。。。');
      }
    });
    
    //退出聊天室
    $('#leaveRoomBtn').click(function () {
      if (webSocket) {
        //关闭连接
        webSocket.close();
      }
    });
    
    //发送消息
    $('#sendBtn').click(function () {
      var msg = $('#sendMessage').val();
      if (msg.trim().length === 0) {
        alert('请输入内容');
        return;
      }
      webSocket.send($('#sendMessage').val());
      
      $('#sendMessage').val('');
    });
  
  </script>

</body>
</html>