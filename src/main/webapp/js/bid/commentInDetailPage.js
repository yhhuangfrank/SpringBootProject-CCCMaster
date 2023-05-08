const alertMessageForComment = document.querySelector("#alertMessageForComment")
const commentTextArea = document.querySelector("#commentTextArea")
const createCommentBtn = document.querySelector("#createCommentBtn")
const commentArea = document.querySelector("#commentArea")
const pagination = document.querySelector("#comment-pagination")
const {bidproduct_id, currentuser_id} = createCommentBtn.dataset

let currentPage = 1 // 預設第一頁
window.addEventListener("load", async () => {
    try {
        const {data} = await axios.get(`${BASE_URL}/${bidproduct_id}/comments`)
        const {content} = data
        renderComment(content)
        paginator(data)
    } catch (error) {
        console.log(error)
    }
})

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

    } catch (error) {
        console.log(error)
    }
})

function renderComment(content) {
     let html = ``
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
    const {totalPages, first, last, number} = data
    currentPage = number + 1

    let html = ``

    if (!first) {
        html += `
            <button class="btn btn-outline-secondary prev">上一頁</button>
        `
    }

    html += `第${currentPage}頁/${totalPages}頁`

    if (!last) {
        html += `
            <button class="btn btn-outline-secondary next">下一頁</button>
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