// const emailInput = document.querySelector("#emailInput")
// const nameInput = document.querySelector("#nameInput")
// const password = document.querySelector("#password")
// const passwordAgainInput = document.querySelector("#passwordAgainInput")
// const phoneNumberInput = document.querySelector("#phoneNumberInput")

const duplicateDataBtn = document.querySelector("#duplicateData")
const firstDataBtn = document.querySelector("#firstData")


duplicateDataBtn.addEventListener("click", function(){
    emailInput.value = "kkboxforus@gmail.com"
    nameInput.value = "宋世傑"
    password.value = "123456789"
    passwordAgainInput.value = "1234567890"
    phoneNumberInput.value = "0987654321"
})
firstDataBtn.addEventListener("click", function(){
    emailInput.value = "funging090032@gmail.com"
    nameInput.value = "王瑀"
    password.value = "123456789"
    passwordAgainInput.value = "123456789"
    phoneNumberInput.value = "0975470119"
})