const employeeId = document.querySelector("#employeeId")
const password = document.querySelector("#password")

const managerLoginBtn = document.querySelector("#managerLoginBtn")


managerLoginBtn.addEventListener("click", function(){
    employeeId.value = "1"
    password.value = "999999999"
})