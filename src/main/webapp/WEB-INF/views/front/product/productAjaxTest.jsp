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

    <title>產品列表</title>
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

         .productImg {
             width: 400px;
             height: 600px;
             object-fit: cover;
         }

        .product-info {
            width: 400px;
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
                <li><a href="${contextRoot}/">首頁</a></li>
                <li>產品列表</li>
            </ol>
            <h2>產品列表</h2>
            <div class="input-group mb-3">
                <input type="text" name="productName" id="search" class="form-control" placeholder="搜尋產品">
                <button id="searchBtn" type="submit" class="btn btn-primary"><i class="bi bi-search"></i></button>
            </div>

            <!-- Sort Dropdown -->
            <div class="dropdown mb-3">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="sortDropdown"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    排序方式
                </button>
                <ul class="dropdown-menu" aria-labelledby="sortDropdown" id="sortDropUl">
                    <li><a class="dropdown-item" href="#" data-sort="productId_asc">預設</a></li>
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
                    <ul id="portfolio-flters">
                        <li data-filter="全部" class="filter-active">全部</li>
                        <li data-filter="手機">手機</li>
                        <li data-filter="滑鼠">滑鼠</li>
                        <li data-filter="鍵盤">鍵盤</li>
                        <li data-filter="電腦">電腦</li>
                        <li data-filter="筆記型電腦">筆記型電腦</li>
                    </ul>
                </div>
                <div id="productContainer" class="row gy-4">

                </div>

                <div id="divPagination" class="d-flex justify-content-center mt-4">
                </div>
            </div>
        </div>
    </section><!-- End Portfolio Section -->
</main><!-- End #main -->

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp"/>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<script>


    async function loadProducts(page, keyword, sort, category) {
        try {
            const response = await axios.get('/front/product/list', {
                params: {page, keyword, sort, category}
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
        loadProducts(1, searchInput.value, getSortValue(), getCategoryValue());
    })

    window.onload = () => {
        Promise.all(Array.from(document.getElementsByTagName('jsp:include')).map((include) => {
            return new Promise((resolve, reject) => {
                include.addEventListener('load', resolve);
            });
        })).then(() => {
            loadProducts(1, '', getSortValue(), getCategoryValue());
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
            pageButton.onclick = () => loadProducts(i, pageData.keyword, getSortValue(),getCategoryValue());
            paginationDiv.appendChild(pageButton);
        }
    }

    function getCategoryValue() {
        const sortDropdownItems = document.querySelectorAll('#portfolio-flters li');
        let categoryValue = "全部";
        sortDropdownItems.forEach((item) => {
            if (item.getAttribute('aria-current') === 'true') {
                categoryValue = item.getAttribute('data-filter');
            }
        });
        return categoryValue
    }

    function getSortValue() {
        const sortDropdownItems = document.querySelectorAll('#sortDropUl a');
        let sortValue = 'productId_asc';
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
            productPrice.innerText = `價格：$` + product.price;
            productPrice.className = "product-price mb-2";

            const productViews = document.createElement('p');
            productViews.innerText = `瀏覽人次：` + product.productViews;
            productViews.className = "product-views";


            const productA = document.createElement('a');
            productA.href = "${contextRoot}/front/product/details/" + product.productId;

            const productImage = document.createElement('img');
            productImage.src = "${contextRoot}/product/mainImage/" + product.productId;
            productImage.className = "img-fluid productImg";
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
        const sortDropdownItems = document.querySelectorAll('#sortDropUl a');
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

    function setCategory(value) {
        const categoryItems = document.querySelectorAll('#portfolio-flters li')
        categoryItems.forEach((item)=>{
            if (item.getAttribute('data-filter') === value) {
                item.setAttribute('aria-current', 'true');
                item.className+="filter-active"
            } else {
                item.removeAttribute('aria-current');
                item.className="";
            }
        })
    }


    const sortDropdownItems = document.querySelectorAll('#sortDropUl a');
    sortDropdownItems.forEach((item) => {
        item.addEventListener('click', (event) => {
            event.preventDefault();
            setSortValue(item.getAttribute('data-sort'));
            loadProducts(1, document.getElementById('search').value, getSortValue(), getCategoryValue());
        });
    });
    const categoryItems = document.querySelectorAll('#portfolio-flters li')
    categoryItems.forEach((item) => {
        item.addEventListener('click', (event) => {
            event.preventDefault()
            setCategory(item.getAttribute('data-filter'));
            loadProducts(1, document.getElementById('search').value, getSortValue(), getCategoryValue());
        })
    })


    // async function loadProducts(page, keyword, sort) {
    //     try {
    //         const response = await axios.get('/front/product/list', {
    //             params: {page, keyword, sort}
    //         });
    //         console.log(response.data)
    //         displayProducts(response.data.products.content);
    //         setupPagination(response.data);
    //     } catch (error) {
    //         console.error('Error loading products:', error);
    //     }
    // }

    // function getCategoryValue() {
    //     const categoryDropdownItems = document.querySelectorAll('#categoryDropUl a');
    //     let categoryValue = '';
    //     categoryDropdownItems.forEach((item) => {
    //         if (item.getAttribute('aria-current') === 'true') {
    //             categoryValue = item.getAttribute('data-category');
    //         }
    //     });
    //     return categoryValue;
    // }

    // function setCategoryValue(value) {
    //     const categoryDropdownItems = document.querySelectorAll('#categoryDropUl a');
    //     const categoryDropdownButton = document.querySelector('#categoryDropdown');
    //
    //     categoryDropdownItems.forEach((item) => {
    //         if (item.getAttribute('data-category') === value) {
    //             item.setAttribute('aria-current', 'true');
    //             if(item.getAttribute('data-category') == ''){
    //                 categoryDropdownButton.innerText ='全部'
    //             }else {
    //             categoryDropdownButton.innerText = item.innerText; // 更新按鈕上的文字
    //             }
    //         } else {
    //             item.removeAttribute('aria-current');
    //         }
    //     });
    // }

    // const categoryDropdownItems = document.querySelectorAll('#categoryDropUl a');
    // categoryDropdownItems.forEach((item) => {
    //     item.addEventListener('click', (event) => {
    //         event.preventDefault();
    //         setCategoryValue(item.getAttribute('data-category'));
    //         loadProducts(1, document.getElementById('search').value, getSortValue(), getCategoryValue());
    //     });
    // });


    //function displayCategoryList(categoryList) {
    //     const categoryDropdownUl=document.getElementById('categoryDropUl')
    //     categoryDropdownUl.innerHTML=` <li><a class="dropdown-item" href="#" data-category="">全部</a></li>`;
    //     categoryList.forEach((category) => {
    //     const categoryDropItem=document.createElement("li")
    //     const categoryDropItemA=document.createElement("a")
    //         categoryDropItemA.className="dropdown-item";
    //         categoryDropItemA.setAttribute("data-category",category.name);
    //         categoryDropItemA.innerText=category.name
    //         categoryDropItem.append(categoryDropItemA);
    //         categoryDropdownUl.append(categoryDropItem);
    //     }
    //     )
    //     const categoryDropdownItems = document.querySelectorAll('#categoryDropUl a');
    //     categoryDropdownItems.forEach((item) => {
    //         item.addEventListener('click', (event) => {
    //             event.preventDefault();
    //             setCategoryValue(item.getAttribute('data-category'));
    //             loadProducts(1, document.getElementById('search').value, getSortValue(), getCategoryValue());
    //         });
    //     });
    // }
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

