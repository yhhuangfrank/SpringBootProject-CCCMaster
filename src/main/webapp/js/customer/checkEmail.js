const emailInput = document.querySelector("#emailInput")
const emailSpan = document.querySelector("#emailSpan")
const nameInput = document.querySelector("#nameInput")
const nameSpan = document.querySelector("#nameSpan")
const phoneNumberInput = document.querySelector("#phoneNumberInput")
const phoneNumberSpan = document.querySelector("#phoneNumberSpan")

const password = document.querySelector("#password")
const passwordAgain = document.querySelector("#passwordAgain")
const submitButton = document.querySelector("#submitButton")
const passwordAgainSpan = document.querySelector("#passwordAgainSpan")

emailInput.addEventListener("blur", async function(){
    const email = emailInput.value
    const data = {email}
    response = await axios.post(`http://localhost:8080/api/checkEmail`, data)
    if(email !== "")  return checkEmailResult(response.data)
})

nameInput.addEventListener("blur", async function(){
    const name = nameInput.value
    const data = {name}
    response = await axios.post(`http://localhost:8080/api/checkName`, data)
    if(name !== "")  return checkNameResult(response.data)
})

phoneNumberInput.addEventListener("blur", async function(){
    const phoneNumber = phoneNumberInput.value
    const data = {phoneNumber}
    response = await axios.post(`http://localhost:8080/api/checkPhoneNumber`, data)
    if(phoneNumber !== "")  return checkPhoneNumberResult(response.data)
})

function checkEmailResult(result){
    if(result){
        emailSpan.innerHTML = 
        `<div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>如果是這個 email 的話 沒...沒人用哦<br>o(*////▽////*)q</strong>
        </div>`
    } else{
        emailSpan.innerHTML = 
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">這個 email 已經被用過啦~!<br>(╯°□°）╯︵ ┻━┻</strong>
        </div>`
    }
}

function checkNameResult(result){
    if(result){
        nameSpan.innerHTML = 
        `<div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>如果是這個暱稱的話 沒...沒人用哦<br>~(￣▽￣)~*</strong>
        </div>`
    } else{
        nameSpan.innerHTML = 
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">這個暱稱已經被用過啦~!<br>┗( T﹏T )┛</strong>
        </div>`
    }
}

function checkPhoneNumberResult(result){
    if(result){
        phoneNumberSpan.innerHTML = 
        `<div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>如果是這個手機號碼的話 沒...沒人用哦<br>( •̀ ω •́ )✧</strong>
        </div>`
    } else{
        phoneNumberSpan.innerHTML = 
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">這個手機號碼已經被用過啦~!<br>w(ﾟДﾟ)w</strong>
        </div>`
    }
}



submitButton.addEventListener("click", function(e){
    if(password.value !== passwordAgain.value){
        passwordAgainSpan.innerHTML = 
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">兩個密碼不一樣啦幹!</strong>
        </div>`
        e.preventDefault();
    }
})