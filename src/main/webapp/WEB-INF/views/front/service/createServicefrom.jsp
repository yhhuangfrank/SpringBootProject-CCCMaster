<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta content="width=device-width, initial-scale=1.0" name="viewport">

                <title>山西達人-表單回報</title>
                <meta content="" name="description">
                <meta content="" name="keywords">

                <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

                <!-- Favicons -->
                <link href="${contextRoot}/styles/front/assets/img/favicon.png" rel="icon">
                <link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

                <!-- Google Fonts -->
                <link
                    href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
                    rel="stylesheet">

                <!-- Vendor CSS Files -->
                <link href="${contextRoot}/styles/front/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
                <link href="${contextRoot}/styles/front/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
                <link href="${contextRoot}/styles/front/assets/vendor/bootstrap-icons/bootstrap-icons.css"
                    rel="stylesheet">
                <link href="${contextRoot}/styles/front/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
                <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
                <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

                <!-- Template Main CSS File -->
                <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">

                <!-- =======================================================
    * Template Name: Eterna
    * Updated: Mar 10 2023 with Bootstrap v5.2.3
    * Template URL: https://bootstrapmade.com/eterna-free-multipurpose-bootstrap-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
                <style>
                    #btn {
                        background-color: red;
                    }

                    #btn:hover {

                        background-color: crimson;
                        color: white;
                    }

                    #center {
                        width: 100%
                    }

                    #wrap {
                        float: left;

                        left: 42%;

                        position: relative;
                    }

                    #item1:focus {
                        background-color: #A9A9A9;
                    }

                    #item2:focus {
                        background-color: #A9A9A9;
                    }

                    #item1:active {

                        background-color: #A9A9A9;
                    }

                    #item2:active {

                        background-color: #A9A9A9;
                    }
                </style>
            </head>

            <body>


                <jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/topbar.jsp" />

                <jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/header.jsp" />


                <main id="main" class="main">

                    <section class="section profile">

                        <div class="col-xl-8" id="center">

                            <div class="card">
                                <div class="card-body pt-3">
                                    <!-- Bordered Tabs -->
                                    <ul class="nav nav-tabs nav-tabs-bordered" id="wrap">

                                        <li class="nav-item">
                                            <button class="nav-link active" data-bs-toggle="tab"
                                                data-bs-target="#profile-overview" id="item1">表單回報</button>
                                        </li>

                                        <li class="nav-item">
                                            <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit"
                                                id="item2">答覆中心</button>
                                        </li>
                                    </ul>
                                    <div class="tab-content pt-2">

                                        <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                            <!-- 分隔 -->

                                            <br>
                                            <br>
                                            <br>
                                            <h1 style="text-align:center;margin-right:80px;">表單回報</h1><br>
                                            <section class="section">
                                                <div style="max-width: 800px; margin: 0 auto;">
                                                    <form:form method="post" modelAttribute="ReportForm"
                                                        action="${contextRoot}/service/from/create/post"
                                                        enctype="multipart/form-data">
                                                        <div class="row mb-3">
                                                            <label for="inputName"
                                                                class="col-sm-2 col-form-label">訂單ID:</label>
                                                            <div class="col-sm-10">
                                                                <form:input type="text" path="orderid"
                                                                    class="form-control" id="inputName"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="row mb-3">
                                                            <label for="inputQuestion"
                                                                class="col-sm-2 col-form-label">問題主旨</label>
                                                            <div class="col-sm-10">
                                                                <form:select path="narrative" class="form-control"
                                                                    id="inputQuestion">
                                                                    <option value="購物問題" selected>購物問題
                                                                    <option value="訂單問題">訂單問題
                                                                    <option value="出貨問題">出貨問題
                                                                    <option value="取消訂單">取消訂單
                                                                    <option value="退換貨問題">退換貨問題
                                                                    <option value="系統網頁問題">系統網頁問題
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                        <label for="floatingTextarea">問題與建議</label>
                                                        <div class="form-floating mb-3">
                                                            <form:textarea class="form-control"
                                                                placeholder="Leave a comment here" id="floatingTextarea"
                                                                style="height: 100px;" path="narrative"></form:textarea>
                                                            <label for="floatingTextarea">可輸入200個字</label>
                                                        </div>
                                                        <div class="row mb-3">
                                                            <label for="inputPhone"
                                                                class="col-sm-2 col-form-label">聯絡電話:</label>
                                                            <div class="col-sm-10">
                                                                <form:input type="text" path="phone"
                                                                    class="form-control" id="inputPhone"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="row mb-3">
                                                            <label for="inputEemail"
                                                                class="col-sm-2 col-form-label">電子信箱:</label>
                                                            <div class="col-sm-10">
                                                                <form:input type="text" path="email"
                                                                    class="form-control" id="inputEemail"></form:input>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="col-sm-10" style="text-align:center;">
                                                            <button type="submit" class="btn btn-primary">送出</button>
                                                            <a href="${contextRoot}/service/from/create" id="btn"
                                                                Class="btn btn-primary;">取消</a>
                                                        </div>

                                                    </form:form>
                                                </div>
                                            </section>
                                        </div>
                                        <!-- 分隔 -->

                                        <div class="tab-pane fade profile-edit pt-3" id="profile-edit">
                                            <!-- 分隔 -->

                                            <section class="section">
                                                <div class="row" style="width:100%;">
                                                    <div class="col-lg-12">
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <h1 style="text-align:center;margin-right:80px;">答覆中心</h1><br>
                                                        <div class="card">
                                                            <div class="card-body">
                                                                <!-- Table with stripped rows -->
                                                                <table class="table datatable">
                                                                    <thead>
                                                                        <tr>
                                                                            <th scope="col">編號</th>
                                                                            <th scope="col">主旨</th>
                                                                            <th scope="col">回報時間</th>
                                                                            <th scope="col">回覆</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <c:forEach items="${ReportForm2Model}" var="s">
                                                                            <tr>
                                                                                <td>${s.id}</td>
                                                                                <td>${s.question}</td>
                                                                                <td>${b.createtime}</td>
                                                                                <td>
                                                                                    <button
                                                                                        class="btn btn-outline-danger"
                                                                                        style="display: inline;background-color: limegreen;"
                                                                                        data-bs-toggle="modal"
                                                                                        data-bs-target="#modal-${s.id}">
                                                                                        查看回覆
                                                                                    </button>
                                                                                </td>
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                                <!-- End Table with stripped rows -->

                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </section>

                                            <!-- 分隔 -->
                                        </div>

                                    </div><!-- End Bordered Tabs -->

                                </div>
                            </div>

                        </div>
                    </section>
                </main>

                <jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp" />

                <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
                        class="bi bi-arrow-up-short"></i></a>

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