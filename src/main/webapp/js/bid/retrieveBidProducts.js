const bidProductArea = document.querySelector("#bidProductArea")
const pagination = document.querySelector(".pagination")
const categoryList = document.querySelector(".categoryList")
const categories = document.querySelectorAll("li.category")
const BASE_URL = "http://localhost:8080/api/bidProducts"
const DEFAULT_SHOWING_PAGES = 5
let currentPage = 1 // 預設在第一頁
let currentContents;
let countDownTimer;

// 網頁載入時發起預設請求
window.addEventListener("load", async () => {
    try {
        const response = await axios.get(BASE_URL)
        const {data} = response
        currentContents = data.content
        renderBidProducts(currentContents)
        paginator(data)
        countDownTimer = setInterval(setCountDownTimer, 1000) // 設定計時
    } catch (error) {
        console.log(error)
    }
})

pagination.addEventListener("click", async (e) => {
    try {
        const {target} = e

        if (target.tagName !== "BUTTON") return

        let goToPage
        if (target.classList.contains("next")) {
            goToPage = currentPage + 1
        } else if (target.classList.contains("prev")) {
            goToPage = currentPage - 1
        } else {
            goToPage = Number(target.textContent)
            if (goToPage === currentPage) return
        }

        // 向 api 請求攜帶的參數
        const params = getCurrentQueryParams()
        params.page = goToPage
        const config = {params}

        const response = await axios.get(BASE_URL, config)
        const {data} = response

        resetCurrentSetting()
        currentContents = data.content // 設定目前頁面資料
        renderBidProducts(currentContents)  // 重新渲染
        paginator(data) // 重新製作分頁
        countDownTimer = setInterval(setCountDownTimer, 1000) // 設定計時
    } catch (error) {
        console.log(error)
    }
})

categoryList.addEventListener("click", async (e) => {
    try {
        const {target} = e
        const isActive = target.classList.contains("filter-active")

        // 若是點擊到非篩選區域或已經是篩選中類別則取消事件
        if (target.tagName !== "LI" || isActive) return

        let categoryName = target.textContent // 取得類別名
        updateCategoryListStyle(categoryName)

        // 向 api 請求攜帶的參數
        const params = getCurrentQueryParams()
        const config = {params}
        const response = await axios(BASE_URL, config)
        const {data} = response

        resetCurrentSetting()
        currentContents = data.content
        renderBidProducts(currentContents)
        paginator(data)
        countDownTimer = setInterval(setCountDownTimer, 1000)
    } catch (error) {
        console.log(error)
    }
})


function renderBidProducts(content) {

    let html = ``;

    for (let i = 0; i < content.length; i += 1) {
        const b = content[i]
        html += `
                <a href="http://localhost:8080/bidProducts/${b.id}" class="text-black my-2">
                    <div class="card">
                        <img src="${b.image}" class="card-img-top"
                             style="opacity: 0; transition: opacity 0.5s ease-in-out; height: 18rem;"
                             onload="this.style.opacity='1';"
                             alt="BidProduct-image">
                        <div class="card-body">
                            <h5 class="card-title">${b.name}</h5>
                            <div class="card-text">
                                <span class="badge bg-secondary text-white" style="font-size: 1rem">目前價格</span>
                                <strong class="ms-2" style="font-size: 1rem">${b.bidPrice} 元</strong>
                                <br>
                                <div class="countDownArea mt-2" style="font-size: 1rem" data-created="${b.createdAt}" data-expired="${b.expiredAt}"></div>
                                <div class="mt-2">${b.description}</div>
                            </div>
                        </div>
                    </div>
                </a>
        `
    }

    bidProductArea.innerHTML = html
}

function paginator(data) {
    const {totalPages, number, empty, first, last} = data

    if (empty) return

    currentPage = number + 1

    let fromPage = currentPage - 1 <= 0 ? 1 : currentPage - 1
    let untilPage = fromPage + DEFAULT_SHOWING_PAGES - 1

    if (untilPage >= totalPages) {
        untilPage = totalPages
        fromPage = untilPage - DEFAULT_SHOWING_PAGES + 1 <= 0
            ? 1
            : untilPage - DEFAULT_SHOWING_PAGES + 1
    }

    let html = ``;

    if (!first) {
        html += `
                <li class="page-item">
                    <button class="page-link prev" href="#" aria-label="Previous">
                         &laquo;
                    </button>
                </li>
        `
    }

    // 當頁數超過設定數時，隱藏多餘分頁
    if (totalPages > DEFAULT_SHOWING_PAGES) {
        // 設定在第三頁後隱藏
        if (currentPage > 2) {
            // 增加第一頁按鈕
            html += `
                <li class="page-item"><button class="page-link">1</button></li>
            `
            if (currentPage > 3) {
                html += `
                    <li class="page-item"><button class="page-link disabled">...</button></li>
                `
            }
        }
    }

    for (let i = fromPage; i <= untilPage; i += 1) {
        if (i === currentPage) {
            html += `
                <li class="page-item active"><button class="page-link" style="cursor: text; background: #e96b56; border: 1px">${i}</button></li>
            `
            continue
        }
        html += `
            <li class="page-item"><button class="page-link">${i}</button></li>
        `
    }

    // 當頁數超過設定數時，隱藏多餘分頁
    if (totalPages > DEFAULT_SHOWING_PAGES) {
        // 設定隱藏頁與新增最後頁按鈕
        if (currentPage <= totalPages - DEFAULT_SHOWING_PAGES + 1) {
            if (currentPage <= totalPages - DEFAULT_SHOWING_PAGES) {
                html += `
                    <li class="page-item"><button class="page-link disabled">...</button></li>
                `
            }
            html += `
                <li class="page-item"><button class="page-link">${totalPages}</button></li>
            `
        }
    }

    if (!last) {
        html += `
                <li class="page-item">
                    <button class="page-link next" aria-label="Next">
                       &raquo;
                    </button>
                </li>
        `
    }

    pagination.innerHTML = html
}

function updateCategoryListStyle(categoryName) {
    // 更新篩選區樣式
    categories.forEach(category => {
        const isActive = category.classList.contains("filter-active")
        const isSelected = category.textContent === categoryName
        if (isActive && !isSelected) {
            category.classList.remove("filter-active")
        }
        if (isSelected) {
            category.classList.add("filter-active")
        }
    })
}

function getCurrentQueryParams() {
    const param = {}

    categories.forEach(category => {
        const isActive = category.classList.contains("filter-active")
        if (category.dataset.category === "all" && isActive) return param
        if (isActive) {
            param.categoryName = category.textContent
        }
    })

    return param
}

function setCountDownTimer() {
    // 遍歷目前頁面的商品，設定倒數
    currentContents.forEach((c, index) => {
        const expiredTime = Date.parse(c.expiredAt)
        if (!expiredTime) return showNotStartYetMessage(index);

        const currentTime = Date.now()
        const offset = Math.floor((expiredTime - currentTime) / 1000) // 以秒為單位
        const seconds = offset % 60      // 秒
        const minutes = Math.floor(offset / 60) % 60 // 分
        const hours = Math.floor(offset / 3600) % 24  // 時
        const days = Math.floor(offset / (3600 * 24)) // 天

        if (offset <= 0) {
            return  showTimer(index, days, hours, minutes, seconds, true)
        }

        return  showTimer(index, days, hours, minutes, seconds, false)
    })
}

function showTimer(index, days, hours, minutes, seconds, isClosed) {
    const countDownArea = document.querySelectorAll(".countDownArea")[index]
    countDownArea.classList.add("badge")
    countDownArea.classList.add("bg-dark")
    countDownArea.classList.add("text-white")
    if (isClosed) {
        return  countDownArea.innerHTML = `
            <span>已截止</span>
        `
    }
    return  countDownArea.innerHTML = `
        <span class="day">${days} 天</span>
        <span class="hour">${hours} 小時</span>
        <span class="minute">${minutes} 分</span>
        <span class="second">${seconds} 秒</span>
    `
}

function showNotStartYetMessage(index) {
    const countDownArea = document.querySelectorAll(".countDownArea")[index]
    countDownArea.classList.add("badge")
    countDownArea.classList.add("bg-dark")
    countDownArea.classList.add("text-white")
    return countDownArea.innerHTML = `
        <span>尚未開始拍賣</span>
    `
}

function resetCurrentSetting() {
    window.document.body.scrollTop = 0 // 將 scroll bar 移至頂端
    // reset 變數
    currentContents = []
    clearInterval(countDownTimer)
}

// 待完成  加上底價顯示在商品總頁