<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">

<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link collapsed" href="index.html">--%>
<%--                        <i class="bi bi-grid"></i>--%>
<%--                        <span>總覽</span>--%>
<%--                    </a>--%>
<%--                </li><!-- End Dashboard Nav -->--%>

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-people"></i><span>會員管理</span><i
                            class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/admin/customers">
                                <i class="bi bi-circle"></i><span>會員資料</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/admin/customers/create">
                                <i class="bi bi-circle"></i><span>新增會員資料</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Components Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-journal-text"></i><span>員工管理</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/admin/employees">
                                <i class="bi bi-circle"></i><span>員工資料</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/admin/employees/create">
                                <i class="bi bi-circle"></i><span>新增員工資料</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/admin/positions">
                                <i class="bi bi-circle"></i><span>職位資料</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Forms Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-bag-check"></i><span>商城管理</span><i
                            class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/admin/products/showAllProduct">
                                <i class="bi bi-circle"></i><span>產品列表</span>
                            </a>
                        </li>

                        <li>
                            <a href="${contextRoot}/admin/products/create/form">
                                <i class="bi bi-circle"></i><span>新增產品</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Tables Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-2-circle"></i><i class="bi bi-hand-thumbs-up"></i><span>拍賣管理</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/admin/bidProducts">
                                <i class="bi bi-circle"></i><span>所有商品</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Charts Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-cart3"></i><span>訂單管理</span><i
                            class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="icons-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/admin/orders">
                                <i class="bi bi-circle"></i><span>訂單列表</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Icons Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#forum-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-book"></i><span>論壇管理</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="forum-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/admin/forums/showAllForum">
                                <i class="bi bi-circle"></i><span>所有討論版</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/admin/forums/createform">
                                <i class="bi bi-circle"></i><span>新增討論版</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/admin/articles/showAllArticle">
                                <i class="bi bi-circle"></i><span>所有文章</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/admin/articles/createform">
                                <i class="bi bi-circle"></i><span>新增文章</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/admin/responses">
                                <i class="bi bi-circle"></i><span>所有回覆</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Icons Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#custService-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-person-hearts"></i><span>客服作業</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="custService-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/admin/Service/console">
                                <i class="bi bi-wechat"></i><span>客服操作台</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Icons Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#ads-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-badge-ad"></i><span>廣告管理</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="ads-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/admin/advertises/showAllAdvertise">
                                <i class="bi bi-circle"></i><span>所有廣告</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/admin/advertises/createform">
                                <i class="bi bi-circle"></i><span>新增廣告</span>
                            </a>
                        </li>
<%--                        <li>--%>
<%--                            <a href="icons-boxicons.html">--%>
<%--                                <i class="bi bi-circle"></i><span>Boxicons</span>--%>
<%--                            </a>--%>
<%--                        </li>--%>
                    </ul>
                </li><!-- End Icons Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#coupons-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-ticket-perforated"></i><span>優惠券發放</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="coupons-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="${contextRoot}/coupons">
                                <i class="bi bi-circle"></i><span>優惠券列表</span>
                            </a>
                        </li>
                        <li>
                            <a href="${contextRoot}/coupons/createform">
                                <i class="bi bi-circle"></i><span>新增優惠券</span>
                            </a>
                        </li>
<%--                        <li>--%>
<%--                            <a href="icons-boxicons.html">--%>
<%--                                <i class="bi bi-circle"></i><span>Boxicons</span>--%>
<%--                            </a>--%>
<%--                        </li>--%>
                    </ul>
                </li><!-- End Icons Nav -->

                <li class="nav-heading">Pages</li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#">
                        <i class="bi bi-person"></i>
                        <span>我的資料</span>
                    </a>
                </li><!-- End Profile Page Nav -->

<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link collapsed" href="pages-faq.html">--%>
<%--                        <i class="bi bi-question-circle"></i>--%>
<%--                        <span>F.A.Q</span>--%>
<%--                    </a>--%>
<%--                </li><!-- End F.A.Q Page Nav -->--%>

<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link collapsed" href="pages-contact.html">--%>
<%--                        <i class="bi bi-envelope"></i>--%>
<%--                        <span>Contact</span>--%>
<%--                    </a>--%>
<%--                </li><!-- End Contact Page Nav -->--%>

<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link collapsed" href="pages-register.html">--%>
<%--                        <i class="bi bi-card-list"></i>--%>
<%--                        <span>Register</span>--%>
<%--                    </a>--%>
<%--                </li><!-- End Register Page Nav -->--%>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="${contextRoot}/admin/logout">
                        <i class="bi bi-box-arrow-right"></i>
                        <span>下班去~</span>
                    </a>
                </li><!-- End Login Page Nav -->

<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link collapsed" href="pages-error-404.html">--%>
<%--                        <i class="bi bi-dash-circle"></i>--%>
<%--                        <span>Error 404</span>--%>
<%--                    </a>--%>
<%--                </li><!-- End Error 404 Page Nav -->--%>

<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link collapsed" href="pages-blank.html">--%>
<%--                        <i class="bi bi-file-earmark"></i>--%>
<%--                        <span>Blank</span>--%>
<%--                    </a>--%>
<%--                </li><!-- End Blank Page Nav -->--%>

            </ul>

        </aside>
        <!-- End Sidebar-->
