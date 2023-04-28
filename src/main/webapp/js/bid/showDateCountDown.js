const expiredAt = document.querySelector("#expiredAt")
const createdAt = document.querySelector("#createdAt")
const timerValueContainers = document.querySelectorAll("#countDownArea span")
const expiredText = expiredAt.textContent
let expiredTime = Date.parse(expiredText)

// 每秒刷新倒數計時
setInterval(setCountDownTimer, 1000)

window.addEventListener("load", () => {
    const startDate = new Date(Date.parse(createdAt.textContent))
    const endDate = new Date(Date.parse(expiredAt.textContent))
    createdAt.textContent = handleDateShowingFormat(startDate)
    expiredAt.textContent = handleDateShowingFormat(endDate)
})


function setCountDownTimer() {
    const currentTime = Date.now()
    const offset = Math.floor((expiredTime - currentTime) / 1000) // 以秒為單位

    // 取得還有多少 天、小時、分鐘、秒
    const seconds = offset % 60      // 秒
    const minutes = Math.floor(offset / 60) % 60 // 分
    const hours = Math.floor(offset / 3600) % 24  // 時
    const days = Math.floor(offset / (3600 * 24)) // 天

    showTimer(days, hours, minutes, seconds)
}

function showTimer(days, hours, minutes, seconds) {
    timerValueContainers[0].textContent = `${days} 天`
    timerValueContainers[1].textContent = `${hours} 小時`
    timerValueContainers[2].textContent = `${minutes} 分`
    timerValueContainers[3].textContent = `${seconds} 秒`
}

function handleDateShowingFormat(date) {
    return `
    ${date.getFullYear()} 年 ${date.getMonth() + 1} 月 ${date.getDate()}日
    ${date.getHours()}:${date.getMinutes()}
    `
}
