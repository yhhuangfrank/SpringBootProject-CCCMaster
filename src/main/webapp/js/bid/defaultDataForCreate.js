const nameInput = document.querySelector("#name")
const basePriceInput = document.querySelector("#basePrice")
const categoryNameInput = document.querySelector("#categoryName")
const description = document.querySelector("#description")
const defaultDataBtn = document.querySelector("#defaultDataBtn")

defaultDataBtn.addEventListener("click", () => {
    nameInput.value = "鑼伎 無線鍵盤 - 時尚白"
    basePriceInput.value = "1000"
    categoryNameInput.value = "鍵盤"
    description.value = `
    ● 微凹鍵帽，完美敲擊：
    採 Perfect Stroke 技術，及球型碟狀的按鍵設計，讓指尖敲擊鍵更精準。

    ● 精簡尺寸，節省空間，好攜帶：
    緊湊的鍵盤尺寸能有效節省桌面空間，同時提供更符合人體工學的舒適輸入體驗。
    
    ● 智能照明，自動偵測：
    在任何光源條件下，創作者皆能順暢完成工作。
    
    ● 多工操作，效率提升：
    鍵盤適用任何主流系統，同時加入智能快捷鍵
    (包含：EMOJI、麥克風靜音、聽寫)，工作更加有效率。
`
    const now = Date.now()
    const offset = 3 * 60 * 1000 // 3 minutes
    endDate.value = dateFormatter(new Date(now + offset))
})