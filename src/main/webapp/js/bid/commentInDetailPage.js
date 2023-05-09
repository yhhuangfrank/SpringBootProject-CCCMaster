const alertMessageForComment = document.querySelector("#alertMessageForComment")
const commentTextArea = document.querySelector("#commentTextArea")
const createCommentBtn = document.querySelector("#createCommentBtn")
const commentArea = document.querySelector("#commentArea")
const pagination = document.querySelector("#comment-pagination")

let currentPage = 1 // 預設第一頁

window.addEventListener("load", () => getCommentByPage())

createCommentBtn.addEventListener("click", async () => {
    try {
        const comment = commentTextArea.value

        if (!currentuser_id) {
            return showAlertMessageForComment("需先登入才能留言")
        }

        const data = {
            comment,
            customerId: currentuser_id
        }

        commentTextArea.value = "" // 清空留言區內容
        await axios.post(`${BASE_URL}/${bidproduct_id}/comments`, data)

        return getCommentByPage()

    } catch (error) {
        console.log(error)
    }
})

pagination.addEventListener("click",  (e) => {
    const {target} = e

    if (target.tagName !== "BUTTON") return

    if (target.classList.contains("prev")) {
        currentPage -= 1
    } else if (target.classList.contains("next")) {
        currentPage += 1
    }

    return  getCommentByPage()
})

function renderComment(content) {
    let html = ``

    if (!content.length) {
        html += `<p class="m-0 text-center">目前暫無留言</p>`
        return commentArea.innerHTML = html
    }

    content.forEach(item => {
        html += `
            <div class="mx-2 p-2">
                <blockquote class="blockquote">
                    <h4>${item.customer.name}</h4>
                    <p>${item.content}</p>
                </blockquote>
                <footer class="blockquote-footer">${item.createdAt}</footer>
                <hr/>
            </div>
        `
    })
    return commentArea.innerHTML = html
}

function paginator(data) {
    const {totalPages, first, last, number, empty} = data

    if (empty) return

    currentPage = number + 1

    let html = ``

    if (!first) {
        html += `
            <button class="btn btn-outline-secondary btn-sm prev">上一頁</button>
        `
    }

    html += `第 ${currentPage} 頁 / 共 ${totalPages} 頁`

    if (!last) {
        html += `
            <button class="btn btn-outline-secondary btn-sm next">下一頁</button>
        `
    }

    return  pagination.innerHTML = html
}

function showAlertMessageForComment(message) {
    return alertMessageForComment.innerHTML = `
            <div class="alert alert-warning alert-dismissible fade show mt-2" role="alert">
                <code class="fw-bold fs-6">&#11198; ${message}</code>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `
}

async function getCommentByPage() {
    try {
        const params = {page: currentPage}
        const {data} = await axios.get(`${BASE_URL}/${bidproduct_id}/comments`, {params})
        const {content} = data
        renderComment(content)
        paginator(data)
    } catch (error) {
        console.log(error)
    }
}