// 處理表單最大與最小可選擇日期
const endDate = document.querySelector("#endDate")

const currentDate = new Date()
const timestamp = currentDate.getTime()
const DEFAULT_OFFSET_OF_DATE = 7 * 86400 * 1000 // 預設最大可選擇日期為一周後，單位毫秒
const maxDate = new Date(timestamp + DEFAULT_OFFSET_OF_DATE)

endDate.setAttribute("min", dateFormatter(currentDate))
endDate.setAttribute("max", dateFormatter(maxDate))

function dateFormatter(targetDate) {
    const year = targetDate.getFullYear()
    const month = twoUnitFormatter(targetDate.getMonth() + 1)
    const date = twoUnitFormatter(targetDate.getDate() )
    const hour = twoUnitFormatter(targetDate.getHours())
    const minute = twoUnitFormatter(targetDate.getMinutes())
    return `${year}-${month}-${date}T${hour}:${minute}`
}

function twoUnitFormatter(value) {
    return value < 10 // 若小於 10 則補上 0
        ? "0" + value
        : value
}