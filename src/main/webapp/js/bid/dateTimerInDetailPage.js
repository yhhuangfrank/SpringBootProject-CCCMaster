const expiredText = document.querySelector("#expiredAt").textContent
const countDownArea = document.querySelector("#countDownArea")
const bidPriceInput = document.querySelector("#bidPrice")
const bidBtn = document.querySelector("#bidBtn")

let expiredTime = Date.parse(expiredText)

// 每秒刷新倒數計時
const timer = setInterval(setCountDownTimer, 1000)

function setCountDownTimer() {
    const currentTime = Date.now()
    const offset = Math.floor((expiredTime - currentTime) / 1000) // 以秒為單位

    // 若倒數結束，送出新增成交請求紀錄
    if (offset === 0) {
        bidPriceInput.setAttribute("disabled", true)
        bidBtn.classList.add("disabled")
        return createDealRecord()
    }

    if (offset < 0) {
        clearInterval(timer)
        return showBidCloseMessage("已截止")
    }

    // 尚未截止才可輸入出價金額
    bidPriceInput.removeAttribute("disabled")
    bidBtn.classList.remove("disabled")

    // 取得還有多少 天、小時、分鐘、秒
    const seconds = offset % 60      // 秒
    const minutes = Math.floor(offset / 60) % 60 // 分
    const hours = Math.floor(offset / 3600) % 24  // 時
    const days = Math.floor(offset / (3600 * 24)) // 天

    showTimer(days, hours, minutes, seconds)
}

function showTimer(days, hours, minutes, seconds) {
    countDownArea.innerHTML = `
        <span class="day">${days} 天</span>
        <span class="hour">${hours} 小時</span>
        <span class="minute">${minutes} 分</span>
        <span class="second">${seconds} 秒</span>
    `
}

function showBidCloseMessage(message) {
    countDownArea.innerHTML = `
        <span>${message}</span>
    `
}

function showDealMessage(message) {
    messageArea.innerHTML = `
        <div class="alert alert-success mt-2 fw-bold" role="alert">
            ${message}
        </div>
    `
}

async function createDealRecord() {
    // create deal record by axios
    const {bidproduct_id} = updateBidPriceBtn.dataset

    try {
        const response = await axios.post(`${BASE_URL}/${bidproduct_id}/dealRecords`)
        const {data} = response
        const message = `恭喜使用者: ${data.customer.name} 得標!`
        showDealMessage(message)
    } catch (error) {
        console.log(error)
    }
}
