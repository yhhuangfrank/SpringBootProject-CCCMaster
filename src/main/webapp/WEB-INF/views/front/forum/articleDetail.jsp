<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>論壇</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

    <!-- Favicons -->
    <link href="${contextRoot}/styles/front/assets/img/favicon.png" rel="icon">
    <link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${contextRoot}/styles/front/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</head>

<body>

<jsp:include page="../layouts/topbar.jsp"/>

<jsp:include page="../layouts/header.jsp"/>

<main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">

            <ol>
                <li><a href="${contextRoot}/">首頁</a></li>
                <li>文章</li>
            </ol>



        </div>
    </section><!-- End Breadcrumbs -->
    <button class="btn btn-primary m-3">
        <a href="${contextRoot}/front/articles/createform" style="color: white;">新增文章</a>
    </button>

    <button class="btn btn-primary m-3">
        <a href="${contextRoot}/front/articles/editPage?id=${article.articleId}" style="color: white;">修改文章</a>

    </button>




    <!-- ======= About Section ======= -->
    <section id="about" class="about">



        <div class="card">


            <div class="card-header">
                <h5 class="card-title">${article.title}</h5>


            </div>
            <div class="card-body ">
                <img style="width: 300px;margin-right: 15px;;" class="img-thumbnail mb-1 "
                     src="${contextRoot}/article/image/${article.articleId}"/>
                ${article.content}
            </div>
            <div class="card-footer">
                發文時間:${article.added}
            </div>


        </div><!-- End Card with header and footer -->


        <div class="container">



        <div class="container mt-2">
            <h3>所有留言</h3>
            <div class="border border-dark border-2 rounded-2">
                <div id="commentArea">
                    <%-- api 串接顯示留言 --%>
                </div>
                <div class="row mb-2">
                    <div class="col-lg-6 mx-auto text-center" id="comment-pagination">
                        <%-- api 串接顯示頁數 --%>
                    </div>
                </div>
            </div>
            <div class="mt-3">
                <div class="mb-3">
                    <label for="commentTextArea"></label>
                    <textarea class="form-control" name="comment" id="commentTextArea" cols="20" placeholder="想說點什麼... ?"
                              rows="8" ></textarea>
                </div>
                 留言提示訊息
                <div id="alertMessageForComment"></div>
                <button class="btn btn-primary" data-bidproduct_id="${article.articleId}"
                        data-currentuser_id="${sessionScope.customerId}" id="createCommentBtn"
                        style="background-color: #e96b56">新增留言
                </button>
            </div>
        </div>

        <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3" id="bidProductArea">
            <%--使用 api 替換此區資料--%>
        </div>

        </div>




        <nav aria-label="Page navigation example" class="mt-4">
            <ul class="pagination justify-content-center align-items-center my-0">
            </ul>
        </nav>
    </section><!-- End About Section -->


</main><!-- End #main -->

<jsp:include page="../layouts/footer.jsp"/>


<!-- Vendor JS Files -->
<script src="${contextRoot}/styles/front/assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/waypoints/noframework.waypoints.js"></script>
<script src="${contextRoot}/styles/front/assets/vendor/php-email-form/validate.js"></script>
<!-- Template Main JS File -->
<script src="${contextRoot}/styles/front/assets/js/main.js"></script>

</body>

</html>

<script src="${contextRoot}/js/response/response.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.3.6/axios.min.js"></script>

<%--<script src="${contextRoot}/js/bid/commentInDetailPage.js"></script>--%>

<script>
    const alertMessageForComment = document.querySelector("#alertMessageForComment")
    const commentTextArea = document.querySelector("#commentTextArea")
    const createCommentBtn = document.querySelector("#createCommentBtn")
    const commentArea = document.querySelector("#commentArea")
    const pagination = document.querySelector("#comment-pagination")
    const articleBtn = document.querySelector("#articleBtn")

    const currentuser_id = createCommentBtn.dataset.currentuser_id

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
            await axios.post(`http://localhost:8080/article/${article.articleId}/response`, data)

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
            html +=
            '<div class="mx-2 p-2">'+
                '<blockquote class="blockquote">'+
                    '<h4>'+ item.customer.name +'</h4>'+
                    '<p>'+ item.responseContent + '</p>'+
                '</blockquote>'+
                '<footer class="blockquote-footer">'+ item.added +'</footer>'+
                '<hr/>'+
            '</div>'

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

        html += '第' + currentPage + '頁 / 共' + totalPages + '頁'

        if (!last) {
            html += `
            <button class="btn btn-outline-secondary btn-sm next">下一頁</button>
        `
        }

        return  pagination.innerHTML = html
    }

    function showAlertMessageForComment(message) {
        return alertMessageForComment.innerHTML =
            '<div class="alert alert-warning alert-dismissible fade show mt-2" role="alert">'+
                '<code class="fw-bold fs-6">'+'&#11198;'+ message +'</code>'+
                '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+'</button>'+
            '</div>'

    }

    async function getCommentByPage() {
        try {
            const params = {page: currentPage}
            const {data} = await axios.get(`http://localhost:8080/article/${article.articleId}/response`, {params})
            const {content} = data

            renderComment(content)
            paginator(data)
        } catch (error) {
            console.log(error)
        }
    }









</script>