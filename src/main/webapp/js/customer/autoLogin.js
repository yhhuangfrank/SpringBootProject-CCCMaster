const accountNumber = document.querySelector("#accountNumber")
const password = document.querySelector("#password")

const user1LoginBtn = document.querySelector("#user1LoginBtn")
const user2LoginBtn = document.querySelector("#user2LoginBtn")


user1LoginBtn.addEventListener("click", function(){
    accountNumber.value = "CCCMasterUser1@gmail.com"
    password.value = "123456789"
})
user2LoginBtn.addEventListener("click", function(){
    accountNumber.value = "CCCMasterUser2@gmail.com"
    password.value = "123456789"
})