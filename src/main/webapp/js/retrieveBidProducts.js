const bidProductArea = document.querySelector("#bidProductArea")
const pagination = document.querySelector(".pagination")
const categoryList = document.querySelector(".categoryList")
const BASE_URL = "http://localhost:8080/api/bidProducts"
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
        const config = {
            params: {
                page: goToPage
            }
        }

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

        if (target.tagName !== "LI" ||
            target.classList.contains("filter-active")) return

        let categoryName = target.textContent // 取得類別名
        updateCategoryListStyle(categoryName)

        // 選擇全部類別
        if(target.dataset.category === "all") {
            categoryName = null
        }

        // 送出請求
        const config = {
            params: {categoryName}
        }
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

    for (let i = 1; i <= totalPages; i += 1) {
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
    const categories = categoryList.children

    for (let i = 0; i < categories.length; i += 1) {
        const element = categories[i]
        if (element.classList.contains("filter-active") &&
            element.textContent !== categoryName) {
            element.classList.remove("filter-active")
        }
        if (element.textContent === categoryName) {
            element.classList.add("filter-active")
        }
    }
}