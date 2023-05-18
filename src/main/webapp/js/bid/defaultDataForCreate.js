const nameInput = document.querySelector("#name")
const basePriceInput = document.querySelector("#basePrice")
const categoryNameInput = document.querySelector("#categoryName")
const description = document.querySelector("#description")
const defaultDataBtn = document.querySelector("#defaultDataBtn")

defaultDataBtn.addEventListener("click", () => {
    nameInput.value = "iKeyBoard"
    basePriceInput.value = "1000"
    categoryNameInput.value = "鍵盤"
    description.value = "測試資料"
    const currentDate = new Date();
    const now = currentDate.getTime()
    const offset = 3 * 60 * 1000 // 3 minutes
    endDate.value = dateFormatter(new Date(now + offset))
})