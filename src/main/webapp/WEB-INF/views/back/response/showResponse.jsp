<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

  <main id="main" class="main">
    <div class="pagetitle">
      <h1>所有回覆</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="${contextRoot}/">首頁</a></li>
          <li class="breadcrumb-item">論壇管理</li>
          <li class="breadcrumb-item active">所有回覆</li>
        </ol>
      </nav>
    </div>
    <section class="section">
      <div class="row align-items-top">
        <div class="col-lg-10 mx-auto">
          <%-- 顯示訊息 --%>
          <jsp:include page="../../message.jsp"/>
          <%-- 所有回覆 --%>
          <table class="table datatable">
            <thead>
            <tr>
              <th scope="col">回編號</th>
              <th scope="col">回覆時間</th>
              <th scope="col">回覆內容</th>
              <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${responses}" var="r">
              <tr>
                <td>${r.customerId}</td>
                <td>${r.responseContent}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${r.added}"/></td>

                <td>
                  <div class="d-flex">

                    <form action="${contextRoot}/admin/responses/delete" method="post">
                      <input type="hidden" name="_method" value="delete" />
                      <input type="hidden" name="id" value="${r.responseId}" />
                      <button type="submit" class="btn btn-outline-danger btn-sm ms-2">
                        <i class="bi bi-exclamation-octagon"></i>刪除
                      </button>
                    </form>
                  </div>
                </td>

              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%-- 顯示所有回覆end --%>


        </div>
      </div>
    </section>
  </main>



  <jsp:include page="../layouts/aside.jsp"/>

  <jsp:include page="../layouts/footer.jsp"/>


  <c:forEach items="${responses}" var="r">
    <div class="modal fade" id="modal-${r.responseId}" tabindex="-1">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title fw-bold">刪除確認</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            確定刪除 <strong>${r.responseId}</strong> 嗎?
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">返回</button>
            <form:form action="${contextRoot}/admin/responses/${r.responseId}" method="DELETE">
              <button type="submit" class="btn btn-danger">刪除</button>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </c:forEach>


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
