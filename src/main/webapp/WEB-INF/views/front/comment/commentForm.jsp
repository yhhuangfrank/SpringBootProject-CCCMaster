<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品評論</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 Bootstrap 5 CSS 檔案 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/css/bootstrap.min.css">

</head>
<body>
<div class="container py-5">
    <h1 class="mb-5">商品評論</h1>
    <form:form method="post" action="" modelAttribute="comment">
        <div class="mb-3">
<%--            <label for="product-name" class="form-label">訂單編號</label>--%>
<%--            <form:input type="text" class="form-control" id="product-name" name="product-name" required value="${comment.orderDetail.id}" path="">--%>
        </div>
        <div class="mb-3">
            <label for="comment" class="form-label">評論</label>
            <textarea class="form-control" id="comment" name="comment" rows="5" required></textarea>
        </div>
        <div class="mb-3">
            <label for="rating" class="form-label">評分</label>
            <select class="form-select" id="rating" name="rating" required>
                <option value="" selected disabled hidden>請選擇評分</option>
                <option value="1">1分</option>
                <option value="2">2分</option>
                <option value="3">3分</option>
                <option value="4">4分</option>
                <option value="5">5分</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">提交評論</button>
    </form:form>
</div>
<!-- 引入 Bootstrap 5 JavaScript 檔案 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/js/bootstrap.min.js"></script>

</body>
</html>
