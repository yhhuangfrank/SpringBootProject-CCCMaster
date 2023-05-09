const BASE_URL = "http://localhost:8080/api/bidProducts"
const messageArea = document.querySelector("#messageArea")
const updateBidPriceBtn = document.querySelector("#updateBidPriceBtn")
const currentBidPrice = document.querySelector("#currentBidPrice")
const basePrice = document.querySelector("#basePrice").textContent
// 統一取得各 id 值
const {bidproduct_id, currentuser_id, seller_id} = updateBidPriceBtn.dataset

updateBidPriceBtn.addEventListener("click", async () => {

    const bidPriceInputValue = Number(bidPriceInput.value)

    if (!bidPriceInputValue) {
        bidPriceInput.value = ""
        return showMessage("不可輸入非數字!", true)
    } else if (!currentuser_id) {
        return showMessage("請先登入!", true)
    } else if (currentuser_id === seller_id) {
        return showMessage("不可對自己的商品出價!", true)
    } else if (bidPriceInputValue < Number(basePrice)) {
        return showMessage("不可比底價小!", true)
    } else if (bidPriceInputValue < Number(currentBidPrice.textContent)) {
        return showMessage("不可比目前價格小!", true)
    }

    bidPriceInput.value = "" // 清空 input

    const data = {
        bidPrice: bidPriceInputValue,
        customerId: currentuser_id
    }

    // 送出 api 請求
    try {
        const response = await axios.put(`${BASE_URL}/${bidproduct_id}`, data)
        if (response.status !== 200) {
            return  showMessage("出價失敗!", true)
        }
        showMessage("出價成功!", false)
        currentBidPrice.textContent = "" + bidPriceInputValue // 更新頁面顯示
    } catch (error) {
        console.log(error)
        showMessage("發生錯誤，出價失敗!", true)
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