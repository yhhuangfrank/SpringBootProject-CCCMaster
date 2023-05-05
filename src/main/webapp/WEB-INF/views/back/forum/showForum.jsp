<%--
  Created by IntelliJ IDEA.
  User: volum
  Date: 2023/4/22
  Time: 下午 03:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
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
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

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

<main id="main" class="main pagetitle">
    <h1>論壇列表</h1>
    <nav>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
            <li class="breadcrumb-item">Tables</li>
            <li class="breadcrumb-item active">論壇</li>
        </ol>
    </nav>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-8">


                <jstl:forEach var="forum" items="${page.content}">
                    <div class="card border-2 m-auto">

                        <div class="d-flex justify-content-around">

                        <img style="width: 300px;" class="img-thumbnail m-3 "
                             src="${contextRoot}/forums/showAllForum/${forum.forumId}"/>

                            <div class="d-flex align-items-lg-center ">
                            <div>
                            <div style=" color:#117e96" class=" "><h4 style="font-weight: bold; font-family: 巴哈正黑體 , 思源黑體 , 微軟正黑體 , 蘋方黑體 , 華康麗黑體 , Helvetica , Arial , sans-serif , serif;">${forum.forumName}</h4>
                            </div>
                                <div style="font-size: small; color:#ADADAD;" class="" >
                                開版時間:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${forum.added}"/>
                                </div>
                            </div>
                            </div>



                            <div class="d-flex align-items-center">

                                <div style="display:flex">
                                    <form class="m-3" action="${contextRoot}/forum/editPage">
                                        <input type="hidden" name="id" value="${forum.forumId}" />
                                        <input type="submit" class="btn btn-primary" value="編輯" />
                                    </form>

                                    <form class="m-3" action="${contextRoot}/forums/delete" method="post">
                                        <input type="hidden" name="_method" value="delete" />
                                        <input type="hidden" name="id" value="${forum.forumId}" />
                                        <input type="submit" class="btn btn-danger" value="刪除" />
                                    </form>
                                </div>

                            </div>
                        </div>
                        </div>


<%--                        <div class="card-body">--%>

<%--                            <div style="display:flex">--%>
<%--                                <form action="${contextRoot}/forum/editPage">--%>
<%--                                    <input type="hidden" name="id" value="${forum.forumId}" />--%>
<%--                                    <input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />--%>
<%--                                </form>--%>

<%--                                <form action="${contextRoot}/forums/delete" method="post">--%>
<%--                                    <input type="hidden" name="_method" value="delete" />--%>
<%--                                    <input type="hidden" name="id" value="${forum.forumId}" />--%>
<%--                                    <input type="submit" class="btn btn-outline-danger btn-sm" value="刪除" />--%>
<%--                                </form>--%>
<%--                            </div>--%>

<%--                        </div>--%>
<%--                    </div>--%>

                </jstl:forEach>


<%--                <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${page.number != pageNumber-1 }">--%>
<%--                            <a href="${contextRoot}/forums/showAllForum?p=${pageNumber}">${pageNumber}</a>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            ${pageNumber}--%>
<%--                        </c:otherwise>--%>

<%--                    </c:choose>--%>

<%--                    <c:if test="${pageNumber != page.totalPages }">--%>
<%--                        ---%>
<%--                    </c:if>--%>

<%--                </c:forEach>--%>


                <nav aria-label="...">
                    <ul class="pagination">

                        </li>
                        <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
                            <c:choose>
                                <c:when test="${page.number eq pageNumber-1}">
                                    <li class="page-item active" aria-current="page">
                                        <a class="page-link" href="#">${pageNumber}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item">
                                        <a class="page-link" href="${contextRoot}/forums/showAllForum?p=${pageNumber}">${pageNumber}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                            <c:if test="${pageNumber eq page.totalPages}">

                            </c:if>
                        </c:forEach>
                    </ul>
                </nav>


            </div>
        </div>
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

