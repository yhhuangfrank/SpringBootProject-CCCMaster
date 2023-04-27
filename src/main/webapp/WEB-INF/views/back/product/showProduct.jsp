<%--
  Created by IntelliJ IDEA.
  User: h8803
  Date: 2023/4/21
  Time: 上午 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>test</title>
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

    <div class="pagetitle">
        <h1>產品列表</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item">Tables</li>
                <li class="breadcrumb-item active">產品</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-12">

                <div class="card">
                    <div class="card-body">
                        <table class="table datatable">
                            <thead>
                            <tr>
                                <th scope="col">產品名稱</th>
                                <th scope="col">產品類別</th>
                                <th scope="col">價格</th>
                                <th scope="col">庫存量</th>
                                <th scope="col">產品介紹</th>
                                <th scope="col">圖片</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="product" items="${page.content}">
                                <tr>

                                    <td>
                                            ${product.productName}
                                    </td>
                                    <td>
                                        ${product.category.name}
                                    </td>
                                    <td>
                                            ${product.price}
                                    </td>
                                    <td>
                                            ${product.inventory}
                                    </td>
                                    <td>
                                            ${product.description}
                                    </td>

                                    <td><img style="width: 300px; height: 300px;"
                                             src="${contextRoot}/products/showImage/${product.productId}"/></td>
                                    <td>
                                        <form action="${contextRoot}/admin/products/editForm">
                                            <input type="hidden" name="id" value="${product.productId}"/>
                                            <input type="submit" class="btn btn-outline-info btn-sm" value="編輯"/>
                                        </form>
                                        <form:form method="put">

                                        </form:form>
                                    </td>
                                    <td>
                                        <div class="justify-content: center;">
                                            <form action="${contextRoot}/admin/products/delete" method="post">
                                                <input type="hidden" name="_method" value="delete"/>
                                                <input type="hidden" name="id" value="${product.productId}"/>
                                                <input type="submit" class="btn btn-outline-danger btn-sm"
                                                       value="刪除"/>
                                            </form>
                                        </div>
                                    </td>
<%--                                    <td><a href="${contextRoot}/admin/crawler/${product.productId}"><span>指定商品爬蟲(測試)</span></a></td>--%>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                        <!-- End Table with stripped rows -->
                        <br/>
                        <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
                            <c:choose>
                                <c:when test="${page.number != pageNumber-1 }">
                                    <a href="${contextRoot}/admin/products/showAllProduct?p=${pageNumber}">${pageNumber}</a>
                                </c:when>
                                <c:otherwise>
                                    ${pageNumber}
                                </c:otherwise>

                            </c:choose>

                            <c:if test="${pageNumber != page.totalPages }">
                                -
                            </c:if>


                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
    </section>

</main><!-- End #main -->


<jsp:include page="../layouts/aside.jsp"/>

<jsp:include page="../layouts/footer.jsp"/>

<!-- Vendor JS Files -->
<script src="${contextRoot}/styles/back/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/chart.js/chart.umd.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/echarts/echarts.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/quill/quill.min.js"></script>
<%--<script src="${contextRoot}/styles/back/assets/vendor/simple-datatables/simple-datatables.js"></script>--%>
<script src="${contextRoot}/styles/back/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="${contextRoot}/styles/back/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${contextRoot}/styles/back/assets/js/main.js"></script>
</body>
</html>
