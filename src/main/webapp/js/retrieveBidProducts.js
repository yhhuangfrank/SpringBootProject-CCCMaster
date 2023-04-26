const bidProductArea = document.querySelector("#bidProductArea")
const pagination = document.querySelector(".pagination")
const BASE_URL = "http://localhost:8080/api/bidProducts"
let currentPage

// 網頁載入時發起預設請求
window.addEventListener("load", async () => {
    try {
        const response = await axios.get(BASE_URL)
        const {data} = response
        currentPage = data.number + 1
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
        }

        const config = {
            params : {
                page: goToPage
            }
        }

        const response = await axios.get(BASE_URL, config)
        paginator(response.data)

    } catch (error) {
        console.log(error)
    }
})


function renderBidProducts(content) {
    let html = ``;

    for (let i = 0; i < content.length; i += 1) {
        const b = content[i]
        html += `
                <a href="#" class="text-black my-2">
                    <div class="card">
                                <img src="${b.image}" class="card-img-top"
                                     style="opacity: 0; transition: opacity 0.5s ease-in-out; height: 500px;"
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
    currentPage = number + 1

    if (empty) return

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
                <li class="page-item active"><button class="page-link" style="cursor: text">${i}</button></li>
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