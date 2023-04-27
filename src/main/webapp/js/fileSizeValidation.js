const imageInput = document.querySelector("input#image")

imageInput.addEventListener("change", ()=> {
    const MAX_SIZE = 2097152
    if (imageInput.files[0].size > MAX_SIZE) {
        alert("檔案過大，請重新上傳!")
        imageInput.value = ""
    }
})