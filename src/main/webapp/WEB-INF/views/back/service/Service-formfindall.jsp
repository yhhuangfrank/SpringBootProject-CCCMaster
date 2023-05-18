<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
          <!DOCTYPE html>
          <html>

          <head>
            <title>客服表單區</title>
            <meta charset="utf-8">
            <meta content="width=device-width, initial-scale=1.0" name="viewport">

            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js"></script>
            <!--    libs for stomp and sockjs-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
            <!--    end libs for stomp and sockjs-->
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet"
              type="text/css">
            <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
            <link href="${contextRoot}/styles/front/assets/vendor/swiper/style.css" rel="stylesheet">

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



            <main id="main" class="main">
            
                                                    <div class="col-lg-12">
                                                        <br>
                                                        <h1 style="text-align:center;margin-right:80px;">答覆中心</h1><br>
                                                        <div class="card">
                                                            <div class="card-body">
                                                                <!-- Table with stripped rows -->
                                                                <table id="tabs" class="table">
                                                                    <thead>
                                                                        <tr>
                                                                            <th scope="col">編號</th>
                                                                            <th scope="col">回報主旨</th>
                                                                            <th scope="col">回報內容</th>
                                                                            <th scope="col">回報時間</th>
                                                                            <th scope="col">操作區</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <c:forEach items="${page.content}" var="ReportForm">
                                                                            <tr>
                                                                                <td>${ReportForm.id}</td>
                                                                                <td>${ReportForm.question}</td>
                                                                                <td id="ellipsis" title="${ReportForm.narrative}">${ReportForm.narrative}</td>
                                                                                <td><fmt:formatDate pattern="EEEE yyyy-MM-dd HH:mm:ss" value="${ReportForm.createtime}" /></td>
                                                                                <td>
						                                                        <div style="display:flex">
                                                                                <form action="${contextRoot}/admin/Service/findform/Reply">
						                                                        <input type="hidden" name="id" value="${ReportForm.id}" />
					                                                       	   <input type="submit" class="btn btn-outline-success" value="回覆" />
					                                                          	</form>
				                                                         		<form action="${contextRoot}/admin/Service/findform/delete" method="post">
		                                                       				   <input type="hidden" name="_method" value="delete" />
						                                      				   <input type="hidden" name="id" value="${ReportForm.id}" />
						                                      				   <input type="submit" class="btn btn-danger" value="刪除" />
						                                   				   </form>
						                                   				   </div>
                                                                                </td>
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                                <!-- End Table with stripped rows -->
                                                                <!-- 分頁開始 -->
                                                                <div style="display: flex;justify-content: center;">
                                                                    <ul class="pagination">
                                                                        <li style="padding-top: 7px;margin-right: 30px;">
                                                                            共${page.totalPages}頁
                                                                        </li>
                                                                        <!-- 分頁上下頁開始 -->
                                                                        <c:choose>
                                                                             <c:when test="${page.number != 0 }">
                                                                            <li class="page-item">
                                                                              <a class="page-link" href="${contextRoot}/admin/Service/findform?p=${page.number}" aria-label="Previous">
                                                                                <span aria-hidden="true">&laquo;</span>
                                                                              </a>
                                                                            </li>
                                                                            </c:when>
                                                                           <c:otherwise>
                                                                            <li class="page-item">
                                                                              <a class="page-link" href="${contextRoot}/admin/Service/findform?p=${page.number+1}" aria-label="Previous">
                                                                                <span aria-hidden="true">&laquo;</span>
                                                                              </a>
                                                                            </c:otherwise>
                                                                         </c:choose>
                                                                <jstl:forEach var="pageNumber" begin="1" end="${page.totalPages}">
                                                                <jstl:choose>
                                                                <jstl:when test="${page.number != pageNumber-1 }">
                                                                </jstl:when>
                                                                <jstl:otherwise>
                                                                
                                                                <li class="page-item">
                                                                    <span class="page-link" style="color: black;">第${pageNumber}頁</span>
                                                            </li>
                                                                </jstl:otherwise>
                                                                </jstl:choose>
                                                                </jstl:forEach>
                                                                
                                                                    <c:choose>
                                                                       <c:when test="${page.number != page.totalPages -1}">
                                                                 <li class="page-item">
                                                                    <a class="page-link" href="${contextRoot}/admin/Service/findform?p=${page.number+2}" aria-label="Next">
                                                                      <span aria-hidden="true">&raquo;</span>
                                                                    </a>
                                                                  </li>
                                                                        </c:when>
                                                                           <c:otherwise>
                                                                            <li class="page-item">
                                                                               <a class="page-link" href="${contextRoot}/admin/Service/findform?p=${page.number+1}" aria-label="Next">
                                                                                 <span aria-hidden="true">&raquo;</span>
                                                                               </a>
                                                                             </li>
                                                                            </c:otherwise>
                                                                         </c:choose>   
                                                                         <!-- 分頁上下頁結束 -->
                                                                         <!-- 跳頁開始 -->
                                                                         <li style="margin-left: 7px;padding-top:7px"><span>跳至</span></li>
                                                                         <li style="margin-left: 7px;">
                                                                            <select  class="form-control" id="inputQuestion" onchange="javascript:location.href=this.value;">
                                                                                    <option value="" selected>${page.number+1}
                                                                                    <jstl:forEach var="pageNumber" begin="1" end="${page.totalPages}"><option value="${contextRoot}/admin/Service/findform?p=${pageNumber}" >${pageNumber}
                                                                                    </jstl:forEach>
                                                                            </select>
                                                                            <li style="margin-left: 7px;padding-top:7px"><span>頁</span>
                                                                        </li>

                                                                         <!-- 跳頁結束 -->
                                                                </ul>
                                                                <!-- 分頁結束 -->
                                                            </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                            
                                        <!-- 分隔 -->

            
            
            
            </main>




            <jsp:include page="../layouts/header.jsp" />

            <jsp:include page="../layouts/aside.jsp" />

            <jsp:include page="../layouts/footer.jsp" />

            <!-- Vendor JS Files -->
            <script src="${contextRoot}/styles/back/assets/vendor/apexcharts/apexcharts.min.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/chart.js/chart.umd.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/echarts/echarts.min.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/quill/quill.min.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/simple-datatables/datatables.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/tinymce/tinymce.min.js"></script>
            <script src="${contextRoot}/styles/back/assets/vendor/php-email-form/validate.js"></script>

            <!-- Template Main JS File -->
            <script src="${contextRoot}/styles/back/assets/js/main.js"></script>



          </body>

          </html>