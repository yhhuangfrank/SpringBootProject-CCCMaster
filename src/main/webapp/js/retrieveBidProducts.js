const bidProductArea = document.querySelector("#bidProductArea")
const base_url = "http://localhost:8080/api/bidProducts"

// 網頁載入時發起預設請求
window.addEventListener("load", async () => {
    const response = await axios.get(base_url)
    const {data} = response
    renderBidProducts(data)
})


function renderBidProducts(data) {
    const {content} = data
    let html = ``;

    for (let i = 0; i < content.length; i += 1) {
        const b = content[i]
        html += `
                <a href="http://localhost:8080" class="text-black my-2">
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