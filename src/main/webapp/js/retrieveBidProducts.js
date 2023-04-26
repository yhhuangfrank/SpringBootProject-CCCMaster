const bidProductArea = document.querySelector("#bidProductArea")
const pagination = document.querySelector(".pagination")
const categoryList = document.querySelector(".categoryList")
const categories = document.querySelectorAll("li.category")
const BASE_URL = "http://localhost:8080/api/bidProducts"
const DEFAULT_SHOWING_PAGES = 5
let currentPage = 1 // 預設在第一頁

// 網頁載入時發起預設請求
window.addEventListener("load", async () => {
    try {
        const response = await axios.get(BASE_URL)
        const {data} = response
        renderBidProducts(data.content)
        paginator(data)
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
        renderBidProducts(data.content)
        paginator(data)

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
        renderBidProducts(data.content)
        paginator(data)
    } catch (error) {
        console.log(error)
    }
})


function renderBidProducts(content) {
    window.document.body.scrollTop = 0 // 將 scroll bar 移至頂端
    let html = ``;

    for (let i = 0; i < content.length; i += 1) {
        const b = content[i]
        html += `
                <a href="#" class="text-black my-2">
                    <div class="card">
                                <img src="${b.image}" class="card-img-top"
                                     style="opacity: 0; transition: opacity 0.5s ease-in-out; height: 18rem;"
                                     onload="this.style.opacity='1';"
                                     alt="BidProduct-image">
                        <div class="card-body">
                            <h5 class="card-title">${b.name}</h5>
                            <div class="card-text">
                                <span class="badge bg-secondary text-white">目前價格</span>
                                <strong class="ms-2">${b.bidPrice}</strong>
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