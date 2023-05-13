const url = 'http://localhost:8080';
let stompClient;
let selectedChatroomId;
let newMessages = new Map();

function connectToChat(userName) {
    console.log("connecting to chat...")
    let socket = new SockJS(url + '/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("connected to: " + frame);
        stompClient.subscribe("/topic/chat/" + selectedChatroomId, function (response) {
            let data = JSON.parse(response.body);
            if (selectedChatroomId === data.chatroom.id) {
                render(data.message, data.chatroom.customer.name);
            } else {
                newMessages.set(data.chatroom.customer.id, data.message);
                $('#userNameAppender_' + data.chatroom.customer.id).append('<span id="newMessage_' + data.chatroom.customer.id + '" style="color: red">+1</span>');
            }
        });
        },function (error) {
        console.log("connection failed: " + error);
        // 执行必要的操作，例如提示用户连接失败等
    });
}

function sendMsg(from, text) {
    stompClient.send("/app/chat/" + selectedChatroomId, {}, JSON.stringify({
        fromLogin: from,
        message: text
    }));
}

function registration() {
    let userName = document.getElementById("userName").value;
    $.get(url + "/registration/" + userName, function (response) {
        selectedChatroomId = response.id;
        connectToChat(userName);
    }).fail(function (error) {
        if (error.status === 400) {
            alert("Login is already busy!")
        }
    })
}
function disconnectFromChat() {
  if (stompClient !== null) {
    stompClient.disconnect();
    console.log("Disconnected from chat");
  }
}

function selectChatroom(chatroomId) {
    console.log("selecting chatroom: " + chatroomId);
    selectedChatroomId = chatroomId;
    let isNew = document.getElementById("newMessage_" + chatroomId) !== null;
    if (isNew) {
        let element = document.getElementById("newMessage_" + chatroomId);
        element.parentNode.removeChild(element);
        render(newMessages.get(chatroomId), chatroomId);
    }
    $('#selectedChatroomId').html('');
    $('#selectedChatroomId').append('聊天室: ' + chatroomId);
}

function fetchAll() {
  fetch(url + "/fetchAllUsers")
    .then(response => response.json())
    .then(users => {
      let usersTemplateHTML = "";
      for (let i = 0; i < users.length; i++) {
        const userName = users[i].customer.name;
        usersTemplateHTML += `<a href="#" onclick="selectUser('${userName}')">
          <li class="clearfix">
            <img src="https://secure.gravatar.com/avatar/12122a41f5e1d5f75d7b0aaf67199e7e?s=300&d=mm&r=g" width="55px" height="55px" alt="avatar" />
            <div class="about">
              <div id="userNameAppender_${userName}" class="name">${userName}</div>
              <div class="status">
                <i class="fa fa-circle offline"></i>
              </div>
            </div>
          </li>
        </a>`;
      }
      $('#usersList').html(usersTemplateHTML);
    })
    .catch(error => {
      console.error("Failed to fetch all users: " + error);
      // 执行必要的操作，例如提示用户獲取失敗等
    });
}