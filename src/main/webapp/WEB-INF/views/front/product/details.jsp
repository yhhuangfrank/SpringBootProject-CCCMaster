<%--
  Created by IntelliJ IDEA.
  User: h8803
  Date: 2023/4/23
  Time: 下午 04:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Example</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

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
    <link href="${contextRoot}/styles/back/assets/vendor/remixicon/remixicon.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">

    <%--    自己加的--%>
    <!-- Bootstrap icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <%--axios--%>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <%--    自己加的--%>

    <style>

        .popup {
            width: 350px;
            background-color: #fff;
            border-radius: 10px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%) scale(0.1);
            text-align: center;
            padding: 0, 30px, 30px;
            color: #333;
            visibility: hidden;
            transition: transform 0.4s, top 0.4s;
            z-index: 9998;
            border: 2px rgb(216, 213, 213) solid;
        }

        .open-popup {
            visibility: visible;
            top: 50%;
            transform: translate(-50%, -50%) scale(1);
        }

        .popup h2 {
            font-size: 35px;
            font-weight: 500;
            margin: 30px 0 10px;
            font-family: DFKai-sb
        }

        .popup button {
            width: 100%;
            margin-top: 50px;
            padding: 10px 0;
            background-color: #6fd649;
            color: #fff;
            border: 0;
            outline: none;
            font-size: 18px;
            border-radius: 8px;
            cursor: pointer;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }


        .productDetailImg {

            height: 600px;
        }

        .list-group-item {
            display: flex;
        }

        .list-group-item span {
            margin-right: 10px;
            text-align: center
        }
    </style>
</head>

<body>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/topbar.jsp"/>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/header.jsp"/>

<main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
        <div class="container">

            <ol>
                <li><a href="index.html">Home</a></li>
                <li>Portfolio Details</li>
            </ol>
            <h2>Portfolio Details</h2>

        </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= Portfolio Details Section ======= -->
    <section id="portfolio-details" class="portfolio-details">
        <div class="container">

            <div class="row gy-4">

                <div class="col-lg-6">
                    <div class="portfolio-details-slider swiper">
                        <div class="swiper-wrapper align-items-center" id="idSwiper-Wrapper">
<%--                            <div class="swiper-slide">--%>
<%--                                <img class="productDetailImg"--%>
<%--                                     src="${contextRoot}/products/showImage/${product.productId}" alt="">--%>
<%--                            </div>--%>
                        </div>
                        <div class="swiper-pagination"></div>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="portfolio-info">
                        <h3>產品資訊</h3>
                        <form:form method="post" modelAttribute="sc" action="${contextRoot}/shoppingcarts/create">
                        <ul>
                            <li><strong>產品名稱</strong>: ${product.productName}</li>
                            <li><strong>類別</strong>: ${product.category.name}</li>
                            <li><strong>價格</strong>: ${product.price}</li>
                            <li><strong>庫存量</strong>: ${product.inventory}</li>
                            <li>
                                <strong>購買數量</strong>:
                                <div class="input-group" style="width: 150px;">
                                    <button id="decrement" class="btn btn-outline-secondary" type="button">-
                                    </button>
                                        <%--                                    <input id="quantity" type="number" class="form-control text-center" min="1" value="1" max="${product.inventory}">--%>
                                    <input id="quantity" type="text" class="form-control text-center" value="1"
                                           data-max="${product.inventory}" name="sc.shoppingCartDetailBean.scquantity">
                                    <button id="increment" class="btn btn-outline-secondary" type="button">+
                                    </button>
                                </div>
                            </li>
                            <li>
                            	<input name="productId" value="${product.productId}" type="hidden">
                            	<input value="${sessionScope.customerId}" type="hidden" id="session">
	                                <button type="button" onclick="openPopup()" id="shoppingcart" class="btn btn-danger"><i
	                                        class="bi bi-cart3"></i>&nbsp;加入購物車
	                                </button>
	                                <div class="popup" id="popup">
	                                    <h2>成功加入購物車!</h2>
	                                    <div class="checkimg">
	                                        <i class="bi bi-check-circle text-success" style="font-size: 50px"></i>
	                                    </div>
	                                    <button type="submit" onclick="closePopup()" style="margin-top: 20px">確認</button>
                                	</div>
                            </li>
                        </ul>
                    </div>
                    </form:form>
                </div>
                <div class="portfolio-description">
                    <h2>產品介紹</h2>
                    <p>
                        ${product.description}
                    </p>

                </div>


            </div>
            <!-- 其他電商平台價格列表 -->
            <div class="other-platform-prices">
                <h3>其他電商平台價格</h3>

                <ul class="list-group" id="crawlerProductsUl">

                </ul>
                <br>

                <div class="d-flex justify-content-between mb-3">
                    <button type="button" class="btn btn-outline-secondary" id="prevPageBtn">
                        上一頁
                    </button>
                    <p id="pageInfo"></p>
                    <button type="button" class="btn btn-outline-secondary" id="nextPageBtn">
                        下一頁
                    </button>
                </div>
            </div>
            <!-- 評論區 -->
            <div class="reviews mt-5">
                <h3>評論區</h3>
                <div class="review-item mb-3">
                    <div class="d-flex justify-content-between">
                        <strong>評論者名稱</strong>
                        <small>評論日期</small>
                    </div>
                    <p>評論內容</p>
                </div>
                <div class="review-item mb-3">
                    <div class="d-flex justify-content-between">
                        <strong>評論者名稱</strong>
                        <small>評論日期</small>
                    </div>
                    <p>評論內容</p>
                </div>
                <div class="review-item mb-3">
                    <div class="d-flex justify-content-between">
                        <strong>評論者名稱</strong>
                        <small>評論日期</small>
                    </div>
                    <p>評論內容</p>
                </div>
            </div>
        </div>

        </div>
    </section><!-- End Portfolio Details Section -->

</main><!-- End #main -->


<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp"/>

<a href=" #
        " class="back-to-top d-flex align-items-center justify-content-center"><i
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
<script>
    let page = 1;
    let totalPages;
    // -----------爬蟲----------------
    window.addEventListener('load', () => {
        loadProductImage(${product.productId})
        axios.get('/front/product/crawler/${product.productId}')
            .then((response) => {
                // console.log(response.data);
                console.log('success');
                loadCrawlerProduct(page, ${product.productId})
            })
            .catch((error) => {
                console.log(error);
            });
    });
    // ---------------------------


    //------------爬蟲價格呈現Ajax----------
    async function loadCrawlerProduct(pageNum, productId) {
        try {
            const response = await axios.get('/front/product/details/crawler', {
                params: {pageNum, productId}
            });
            totalPages = response.data.totalPages;
            document.getElementById('pageInfo').innerText = "第" + page + "頁" + "/共" + response.data.totalPages + "頁";
            displayCrawlerInfo(response.data.content);
        } catch (error) {
            console.error('Error loading CrawlerProduct:', error);
        }
    }

    //上一頁
    //-----------------------------
    document.getElementById("prevPageBtn").addEventListener('click', () => {
        if (page > 1) {
            page--;
            loadCrawlerProduct(page, ${product.productId})
        }
    });

    // 切换到下一页
    document.getElementById("nextPageBtn").addEventListener('click', () => {
        if (page < totalPages) {
            page++;
            loadCrawlerProduct(page, ${product.productId})
        }
    });


    //顯示爬蟲紀錄
    //---------------------------------------
    function displayCrawlerInfo(crawlerProducts) {
        const crawlerProductsUl = document.getElementById('crawlerProductsUl')
        crawlerProductsUl.innerHTML = ''
        crawlerProducts.forEach((item) => {
            const crawlerProductLi = document.createElement('li')
            const crawlerProductName = document.createElement('span')
            const crawlerProductDate = document.createElement('span')
            const crawlerProductPrice = document.createElement('span')
            const date = new Date(item[2]).toLocaleString('zh-TW', {
                year: 'numeric',
                month: 'numeric',
                day: 'numeric',
                hour: 'numeric',
                minute: 'numeric'
            });
            crawlerProductLi.className = 'list-group-item d-flex justify-content-between align-items-center'
            crawlerProductName.className = 'rounded-pill col-lg-8';
            crawlerProductName.style = "text-align: left"
            crawlerProductDate.className = 'rounded-pill col-lg-2';
            crawlerProductPrice.className = 'rounded-pill col-lg-2';
            crawlerProductName.innerText = item[0];
            crawlerProductPrice.innerText = item[1];
            crawlerProductDate.innerText = date;
            crawlerProductLi.append(crawlerProductName);
            crawlerProductLi.append(crawlerProductDate);
            crawlerProductLi.append(crawlerProductPrice);
            crawlerProductsUl.append(crawlerProductLi);
        });
    }

    //-----------------------取得產品圖片id--------------------

    async function loadProductImage(productId) {
        try {
            const response = await axios.get('/product/images', {
                params: {productId}
            });
            console.log(response.data)
            displayImages(response.data)
        } catch (error) {
            console.error('loadProductImage:', error);
        }
    }

    //-------------------------------------------------------


    //----------------------圖片跑馬燈生成----------------------

    function displayImages(imagesId) {
        const swiperWrapperDiv = document.getElementById("idSwiper-Wrapper");
        imagesId.forEach((imageId) => {
            const swiperSlideDiv = document.createElement("div");
            const productDetailImg = document.createElement("img");
            swiperSlideDiv.className = "swiper-slide";
            productDetailImg.className = "productDetailImg";
            productDetailImg.src = "${contextRoot}/product/showImage/" + imageId
            swiperSlideDiv.append(productDetailImg);
            swiperWrapperDiv.append(swiperSlideDiv);


        });
    }


    //-------------------------------------------------------


    // -------------- 購買數量 +1 -1 事件-----------
    document.getElementById("increment").addEventListener("click", () => {
        const quantityInput = document.getElementById("quantity");
        const max = parseInt(quantityInput.getAttribute('data-max'), 10);
        let value = parseInt(quantityInput.value, 10);
        console.log(`max=${max}  value=${value}`)
        if (value < max) {
            quantityInput.value = parseInt(quantityInput.value) + 1;
        }
    });

    document.getElementById("decrement").addEventListener("click", () => {
        const quantityInput = document.getElementById("quantity");
        const currentValue = parseInt(quantityInput.value);
        if (currentValue > 1) {
            quantityInput.value = currentValue - 1;
        }
    });
    // ---------------------------------------------


    //-------------------------------購買數量欄位數值檢查------------------
    document.getElementById('quantity').addEventListener('input', (event) => {
        const input = event.target;
        const max = parseInt(input.getAttribute('data-max'), 10);
        let value = parseInt(input.value, 10);

        // 如果輸入的值不是有效的整數，將值設為 1
        if (isNaN(value) || value < 1) {
            value = 1;
        }

        // 如果輸入的值大於最大庫存量，將值設為最大庫存量
        if (value > max) {
            value = max;
        }

        // 更新 input 的值
        input.value = value;
    });
    //-----------------------------------------------------


    //-------------------------------加入購物車訊息-----------------------

	let popup = document.getElementById('popup')
	let session = document.getElementById('session')
        function openPopup() {
            if((session.value)){
                popup.classList.add("open-popup")
            }else{
            	alert("請先登入會員");
            	window.location.href = "http://localhost:8080/login";
            }           
        }
        function closePopup() {
            popup.classList.remove("open-popup")
        }

    //-------------------------------加入購物車訊息-----------------------
</script>


</body>

</html>

