<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>新增產品</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

    <!-- Favicons -->
    <link href="${contextRoot}/styles/back/assets/img/favicon.png" rel="icon">
    <link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${contextRoot}/styles/back/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="${contextRoot}/styles/back/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/back/assets/css/style.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


    <style>

    </style>
</head>
<body>

<jsp:include page="../layouts/header.jsp"/>

<main id="main" class="main">
    <h1>新增產品</h1>
    <section class="section">
        <div style="max-width: 800px; margin: 0 auto;">
            <form:form method="post" modelAttribute="product" action="${contextRoot}/admin/products/create"
                       enctype="multipart/form-data">
                <div class="row mb-3">
                    <label for="inputName" class="col-sm-2 col-form-label">產品名稱</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="productName" class="form-control" id="inputName"></form:input>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="categoryId" class="col-sm-2 col-form-label fw-bold">種類</label>
                    <div class="col-sm-10">
                        <input name="categoryName" class="form-control" list="categoryList" id="categoryId"
                               placeholder="搜尋或自訂種類"/>
                        <datalist id="categoryList">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.name}"></option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputInventory" class="col-sm-2 col-form-label">庫存量</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="inventory" class="form-control" id="inputInventory"></form:input>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputPrice" class="col-sm-2 col-form-label">價格</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="price" class="form-control" id="inputPrice"></form:input>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">上傳主要圖片</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" type="file" id="formFile" path="mainImageFile"
                                    accept="image/*"></form:input>
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">上傳次要圖片</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" type="file" id="formFile" path="imageFile" multiple="true"
                                    accept="image/*"></form:input>
                    </div>
                </div>
                <div class="form-floating mb-3">
                    <form:textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"
                                   style="height: 100px;" path="description"></form:textarea>
                    <label for="floatingTextarea">產品介紹</label>

                </div>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    使用chatGPT API產生敘述
                </button>


                <fieldset class="row mb-3" style="margin-top: 10px">
                    <legend class="col-form-label col-sm-2 pt-0">上下架狀態</legend>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <form:radiobutton class="form-check-input" path="active" id="gridRadios1" value="true"/>
                            <label class="form-check-label" for="gridRadios1">
                                上架
                            </label>
                        </div>
                        <div class="form-check">
                            <form:radiobutton class="form-check-input" path="active" id="gridRadios2" value="false"/>
                            <label class="form-check-label" for="gridRadios2">
                                下架
                            </label>
                        </div>

                    </div>
                </fieldset>
                <br>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label"></label>
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">送出</button>
                    </div>
                </div>

            </form:form>
            <!-- Modal -->
            <div  class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">輸入關鍵字產生產品敘述</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="mb-3">
                                    <label for="product-features" class="form-label">產品特色：</label>
                                    <input type="text" class="form-control" id="product-features"
                                           name="product-features">
                                </div>
                                <div class="mb-3">
                                    <label for="target-customers" class="form-label">主要客群：</label>
                                    <input type="text" class="form-control" id="target-customers"
                                           name="target-customers">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary" id="generateBtn">產生</button>
                        </div>
                    </div>
                </div>
            </div>
            <%-----------------------------------------------------------------------------%>
        </div>
    </section>
</main>

<jsp:include page="../layouts/aside.jsp"/>

<jsp:include page="../layouts/footer.jsp"/>


<!-- Vendor JS Files -->
<script src="${contextRoot}/styles/back/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/chart.js/chart.umd.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/echarts/echarts.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/quill/quill.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/php-email-form/validate.js"></script>


<!-- Template Main JS File -->
<script src="${contextRoot}/styles/back/assets/js/main.js"></script>

<script>
    const modal = new bootstrap.Modal(document.getElementById('exampleModal'));//js使用Bootstrap提供的Modal物件使用modal.hide()來關閉modal
    const generateBtn = document.getElementById("generateBtn")
    generateBtn.addEventListener('click', function () {
        const feature=getFeatures()
        const target= getTarget()
        const productName=document.getElementById('inputName').value
        generateDescription(productName,feature,target);
    })

    function getFeatures() {
        const features = document.getElementById('product-features').value
        return features;
    }

    function getTarget() {
        const target = document.getElementById('target-customers').value
        return target;
    }

    async function generateDescription(productName,features, target) {
        console.log(productName)
        console.log(features)
        console.log(target)
        try {
            const response = await axios.get('/admin/products/generateDescription', {
                params: {productName,features, target}
            });
            console.log(response.data)
            document.getElementById('floatingTextarea').value=response.data
            modal.hide();
        } catch (error) {
            console.error('Error Generate Description', error);
        }
    }
</script>
</body>
</html>
