const BASE_URL = "http://localhost:8080/api/bidProducts"
const messageArea = document.querySelector("#messageArea")
const updateBidPriceBtn = document.querySelector("#updateBidPriceBtn")
const currentBidPrice = document.querySelector("#currentBidPrice")
const basePrice = document.querySelector("#basePrice").textContent

updateBidPriceBtn.addEventListener("click", async () => {

    const bidPriceInputValue = Number(bidPriceInput.value)
    if (!bidPriceInputValue) {
        bidPriceInput.value = ""
        return showMessage("不可輸入非數字!", true)
    } else if (bidPriceInputValue < Number(basePrice)) {
        return showMessage("不可比底價小!", true)
    } else if (bidPriceInputValue < Number(currentBidPrice.textContent)) {
        return showMessage("不可比目前價格小!", true)
    }

    bidPriceInput.value = "" // 清空 input
    currentBidPrice.textContent = "" + bidPriceInputValue // 更新頁面顯示

    const config = {
        method: "PUT",
        url: BASE_URL + `/${updateBidPriceBtn.dataset.id}`,
        params: {bidPrice: bidPriceInputValue}
    }
    // 送出 api 請求
    try {
        const response = await axios(config)
        if (response.status === 200) {
            showMessage("出價成功!", false)
        }
    } catch (error) {
        console.log(error)
        showMessage("發生錯誤，出價失敗!", false)
    }

})

function showMessage(message, isFailed) {
    if (isFailed) {
        return messageArea.innerHTML = `
            <div class="alert alert-warning alert-dismissible fade show mt-2" role="alert">
                <code class="fw-bold fs-6">&#11198; ${message}</code>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `
    }
    messageArea.innerHTML = `
            <div class="alert alert-success alert-dismissible fade show mt-2" role="alert">
                &#10004; ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `
}