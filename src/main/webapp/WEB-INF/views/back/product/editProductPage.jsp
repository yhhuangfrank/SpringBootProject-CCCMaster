<%--
  Created by IntelliJ IDEA.
  User: h8803
  Date: 2023/4/21
  Time: 下午 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>編輯產品</title>
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
</head>
<body>

<jsp:include page="../layouts/header.jsp"/>

<main id="main" class="main">
    <h1>編輯產品</h1>
    <div style="max-width: 800px; margin: 0 auto;">
    <form:form method="put" modelAttribute="product" action="${contextRoot}/admin/products/edit"
               enctype="multipart/form-data">
    <form:input type="hidden" path="productId" class="form-control" id="inputId"></form:input>
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
        <fieldset class="row mb-3">
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

        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"></label>
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Submit Form</button>
            </div>
        </div>

        </form:form>
    </div>
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
</body>
</html>

