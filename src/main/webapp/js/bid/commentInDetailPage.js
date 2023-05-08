const commentTextArea = document.querySelector("#commentTextArea")
const createCommentBtn = document.querySelector("#createCommentBtn")

createCommentBtn.addEventListener("click", async () => {
    try {
        const comment = commentTextArea.textContent
        console.log(comment)
        const {bidproduct_id, currentuser_id} = createCommentBtn.dataset
        const data = {
            comment,
            customerId: currentuser_id
        }
        const response = await axios.post(`${BASE_URL}/${bidproduct_id}/comments`, data)
        console.log(response.data)
    } catch (error) {
        console.log(error)
    }
})