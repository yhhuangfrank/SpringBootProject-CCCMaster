<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>

    <head>
      <title>新增員工資料</title>
      <meta charset="utf-8">
      <meta content="width=device-width, initial-scale=1.0" name="viewport">

      <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

      <!-- Favicons -->
      <link href="${contextRoot}/styles/back/assets/img/favicon.png" rel="icon">
      <link href="${contextRoot}/styles/back/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

      <!-- Google Fonts -->
      <link href="https://fonts.gstatic.com" rel="preconnect">
      <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
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

      <jsp:include page="../layouts/header.jsp" />

      <main id="main" class="main">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">General Form Elements</h5>

            <!-- General Form Elements -->
            <form>
              <div class="row mb-3">
                <label for="inputText" class="col-sm-2 col-form-label">Text</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control">
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                  <input type="email" class="form-control">
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                  <input type="password" class="form-control">
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputNumber" class="col-sm-2 col-form-label">Number</label>
                <div class="col-sm-10">
                  <input type="number" class="form-control">
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputNumber" class="col-sm-2 col-form-label">File Upload</label>
                <div class="col-sm-10">
                  <input class="form-control" type="file" id="formFile">
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputDate" class="col-sm-2 col-form-label">Date</label>
                <div class="col-sm-10">
                  <input type="date" class="form-control">
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputTime" class="col-sm-2 col-form-label">Time</label>
                <div class="col-sm-10">
                  <input type="time" class="form-control">
                </div>
              </div>

              <div class="row mb-3">
                <label for="inputColor" class="col-sm-2 col-form-label">Color Picker</label>
                <div class="col-sm-10">
                  <input type="color" class="form-control form-control-color" id="exampleColorInput" value="#4154f1"
                    title="Choose your color">
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputPassword" class="col-sm-2 col-form-label">Textarea</label>
                <div class="col-sm-10">
                  <textarea class="form-control" style="height: 100px"></textarea>
                </div>
              </div>
              <fieldset class="row mb-3">
                <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
                <div class="col-sm-10">
                  <div class="form-check">
                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1"
                      checked>
                    <label class="form-check-label" for="gridRadios1">
                      First radio
                    </label>
                  </div>
                  <div class="form-check">
                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
                    <label class="form-check-label" for="gridRadios2">
                      Second radio
                    </label>
                  </div>
                  <div class="form-check disabled">
                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios" value="option"
                      disabled>
                    <label class="form-check-label" for="gridRadios3">
                      Third disabled radio
                    </label>
                  </div>
                </div>
              </fieldset>
              <div class="row mb-3">
                <legend class="col-form-label col-sm-2 pt-0">Checkboxes</legend>
                <div class="col-sm-10">

                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck1">
                    <label class="form-check-label" for="gridCheck1">
                      Example checkbox
                    </label>
                  </div>

                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck2" checked>
                    <label class="form-check-label" for="gridCheck2">
                      Example checkbox 2
                    </label>
                  </div>

                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Disabled</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" value="Read only / Disabled" disabled>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Select</label>
                <div class="col-sm-10">
                  <select class="form-select" aria-label="Default select example">
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                  </select>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Multi Select</label>
                <div class="col-sm-10">
                  <select class="form-select" multiple aria-label="multiple select example">
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                  </select>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Submit Button</label>
                <div class="col-sm-10">
                  <button type="submit" class="btn btn-primary">Submit Form</button>
                </div>
              </div>

            </form><!-- End General Form Elements -->

          </div>
        </div>
      </main>

      <jsp:include page="../layouts/aside.jsp" />

      <jsp:include page="../layouts/footer.jsp" />

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