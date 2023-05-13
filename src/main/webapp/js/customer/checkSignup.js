const emailInput = document.querySelector("#emailInput")
const emailSpan = document.querySelector("#emailSpan")
const nameInput = document.querySelector("#nameInput")
const nameSpan = document.querySelector("#nameSpan")
const phoneNumberInput = document.querySelector("#phoneNumberInput")
const phoneNumberSpan = document.querySelector("#phoneNumberSpan")
const password = document.querySelector("#password")
const passwordAgainInput = document.querySelector("#passwordAgainInput")
const passwordAgainSpan = document.querySelector("#passwordAgainSpan")
const submitButton = document.querySelector("#submitButton")

let emailFlag = true;
let nameFlag = true;
let phoneNumberFlag = true;
let passwordFlag = true;


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

passwordAgainInput.addEventListener("blur", function(){
    if(password.value !== ""){
        if(password.value !== passwordAgainInput.value){
            passwordAgainSpan.innerHTML = 
            `<div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong style="color: #bb2d3b">喔喔!兩次密碼不一樣喔!  凸^_^凸</strong>
            </div>`
            passwordFlag = true;
        } else{
            passwordAgainSpan.innerHTML = 
            `<div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>兩次密碼一...一樣哦  (●'◡'●)</strong>
            </div>`
            passwordFlag = false
        }
    }
})



function checkEmailResult(result){
    if(result){
        emailSpan.innerHTML = 
        `<div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>如果是這個 email 的話 沒...沒人用哦  o(*////▽////*)q</strong>
        </div>`
        emailFlag = false;
    } else{
        emailSpan.innerHTML = 
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">這個 email 已經被用過啦~!  (╯°□°）╯︵ ┻━┻</strong>
        </div>`
        emailFlag = true;
    }
}

function checkNameResult(result){
    if(result){
        nameSpan.innerHTML = 
        `<div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>如果是這個暱稱的話 沒...沒人用哦  ~(￣▽￣)~*</strong>
        </div>`
        nameFlag = false;
    } else{
        nameSpan.innerHTML = 
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">這個暱稱已經被用過啦~!  ┗( T﹏T )┛</strong>
        </div>`
        nameFlag = true;
    }
}

function checkPhoneNumberResult(result){
    if(result){
        phoneNumberSpan.innerHTML = 
        `<div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>如果是這個手機號碼的話 沒...沒人用哦  ( •̀ ω •́ )✧</strong>
        </div>`
        phoneNumberFlag = false;
    } else{
        phoneNumberSpan.innerHTML = 
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong style="color: #bb2d3b">這個手機號碼已經被用過啦~!  w(ﾟДﾟ)w</strong>
        </div>`
        phoneNumberFlag = true;
    }
}



submitButton.addEventListener("click", function(e){
    if(emailFlag || nameFlag || phoneNumberFlag || passwordFlag){
        e.preventDefault();
    }
})