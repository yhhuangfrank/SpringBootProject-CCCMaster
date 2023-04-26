<%--
  Created by IntelliJ IDEA.
  User: h8803
  Date: 2023/4/22
  Time: 下午 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Example</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

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

    <%--    自己加的--%>
    <!-- Bootstrap icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <%--axios--%>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <%--    chatgpt添加--%>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--%>
    <%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>--%>
    <%--    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>--%>
    <%--    自己加的--%>

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">
    <style>
        .button-group button {
            margin-right: 10px;
        }

        .product-info {
            background-color: #f9f9f9;
            border-radius: 5px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .product-name {
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }

        .product-price {
            font-size: 16px;
            color: #555;
        }

        .product-views {
            font-size: 14px;
            color: #777;
        }
    </style>
</head>

<body>
<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/topbar.jsp"/>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/header.jsp"/>

<main id="main" class="mt-5">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">
            <ol>
                <li><a href="index.html">首頁</a></li>
                <li>產品列表</li>
            </ol>
            <h2>產品列表</h2>
            <div class="input-group mb-3">
                <input type="text" name="productName" id="search" class="form-control" placeholder="搜尋產品">
                <button id="searchBtn" type="submit" class="btn btn-primary"><i class="bi bi-search"></i></button>
            </div>
            <!-- Sort Dropdown -->
            <div class="dropdown mb-3">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="sortDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    排序方式
                </button>
                <ul class="dropdown-menu" aria-labelledby="sortDropdown">
                    <li><a class="dropdown-item" href="#" data-sort="default">預設</a></li>
                    <li><a class="dropdown-item" href="#" data-sort="price_asc">價格由低到高</a></li>
                    <li><a class="dropdown-item" href="#" data-sort="price_desc">價格由高到低</a></li>
                    <li><a class="dropdown-item" href="#" data-sort="productViews_asc">瀏覽人次由低到高</a></li>
                    <li><a class="dropdown-item" href="#" data-sort="productViews_desc">瀏覽人次由高到低</a></li>
                </ul>
            </div>
            <!-- End Sort Dropdown -->
        </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= Portfolio Section ======= -->
    <section id="portfolio" class="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 d-flex justify-content-center">
                    <ul id="portfolio-flters" class="nav nav-pills mb-3">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" data-filter="*">All</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" data-filter=".filter-app">App</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" data-filter=".filter-card">Card</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" data-filter=".filter-web">Web</button>
                        </li>
                    </ul>
                </div>
            </div>

            <div id="productContainer" class="row gy-4">

            </div>

            <div id="divPagination" class="d-flex justify-content-center mt-4">
            </div>
        </div>
    </section><!-- End Portfolio Section -->
</main><!-- End #main -->

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp"/>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<script>
    async function loadProducts(page, keyword, sort) {
        try {
            const response = await axios.get('/front/product/list', {
                params: {page, keyword, sort}
            });
            console.log(response.data)
            displayProducts(response.data.products.content);
            setupPagination(response.data);
        } catch (error) {
            console.error('Error loading products:', error);
        }
    }

    document.getElementById('searchBtn').addEventListener(('click'), () => {
        const searchInput = document.getElementById('search');
        loadProducts(1, searchInput.value,getSortValue());
    })

    window.onload = () => {
        Promise.all(Array.from(document.getElementsByTagName('jsp:include')).map((include) => {
            return new Promise((resolve, reject) => {
                include.addEventListener('load', resolve);
            });
        })).then(() => {
            loadProducts(1, '', getSortValue());
        });
    };
    function setupPagination(pageData) {
        const paginationDiv = document.getElementById('divPagination');
        paginationDiv.innerHTML = '';
        for (let i = 1; i <= pageData.products.totalPages; i++) {
            const pageButton = document.createElement('button');
            pageButton.className = "btn btn-secondary mx-1"
            if (i == pageData.pageNum) {
                pageButton.disabled = true;
                pageButton.className += " active";
            }
            pageButton.innerText = i;
            pageButton.onclick = () => loadProducts(i, pageData.keyword,getSortValue());
            paginationDiv.appendChild(pageButton);
        }
    }
    function getSortValue() {
        const sortDropdownItems = document.querySelectorAll('.dropdown-menu a');
        let sortValue = 'default';
        sortDropdownItems.forEach((item) => {
            if (item.getAttribute('aria-current') === 'true') {
                sortValue = item.getAttribute('data-sort');
            }
        });
        return sortValue;
    }
    function displayProducts(products) {
        const productsDiv = document.getElementById('productContainer');
        productsDiv.innerHTML = '';

        products.forEach(product => {
            const productDiv = document.createElement('div');
            productDiv.className = "col-lg-4 col-md-6";

            const productWrap = document.createElement('div');
            productWrap.className = "portfolio-item filter-app";

            const productInfo = document.createElement('div');
            productInfo.className = "product-info p-3 text-center";

            const productName = document.createElement('h4');
            productName.innerText = product.productName;
            productName.className = "product-name mb-2";

            const productPrice = document.createElement('p');
            productPrice.innerText = `價格：$`+product.price;
            productPrice.className = "product-price mb-2";

            const productViews = document.createElement('p');
            productViews.innerText = `瀏覽人次：`+product.productViews;
            productViews.className = "product-views";


            const productA = document.createElement('a');
            productA.href = "${contextRoot}/front/product/details/" + product.productId;

            const productImage = document.createElement('img');
            productImage.src = "${contextRoot}/products/showImage/" + product.productId;
            productImage.className = "img-fluid";
            productImage.alt = "";

            productImage.addEventListener("click", () => {
                window.location.href = productA.href;
            });

            productA.appendChild(productImage);
            productWrap.appendChild(productA);
            productDiv.appendChild(productWrap);
            productInfo.appendChild(productName);
            productInfo.appendChild(productPrice);
            productInfo.appendChild(productViews);
            productDiv.appendChild(productInfo);
            productsDiv.appendChild(productDiv);
        });
    }

    function setSortValue(value) {
        const sortDropdownItems = document.querySelectorAll('.dropdown-menu a');
        const sortDropdownButton = document.querySelector('#sortDropdown');

        sortDropdownItems.forEach((item) => {
            if (item.getAttribute('data-sort') === value) {
                item.setAttribute('aria-current', 'true');
                sortDropdownButton.innerText = item.innerText; // 更新按鈕上的文字
            } else {
                item.removeAttribute('aria-current');
            }
        });
    }
    const sortDropdownItems = document.querySelectorAll('.dropdown-menu a');
    sortDropdownItems.forEach((item) => {
        item.addEventListener('click', (event) => {
            event.preventDefault();
            setSortValue(item.getAttribute('data-sort'));
            loadProducts(1, document.getElementById('search').value, getSortValue());
        });
    });
</script>
</body>

</html>

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

