const alertMessageForComment = document.querySelector("#alertMessageForComment")
const commentTextArea = document.querySelector("#commentTextArea")
const createCommentBtn = document.querySelector("#createCommentBtn")

createCommentBtn.addEventListener("click", async () => {
    try {
        const comment = commentTextArea.value
        const {bidproduct_id, currentuser_id} = createCommentBtn.dataset

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

function showAlertMessageForComment(message) {
    return alertMessageForComment.innerHTML = `
            <div class="alert alert-warning alert-dismissible fade show mt-2" role="alert">
                <code class="fw-bold fs-6">&#11198; ${message}</code>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `
}