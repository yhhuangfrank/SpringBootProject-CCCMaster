// 當頁面加載完成後調用 fetchAll() 函數
document.addEventListener('DOMContentLoaded', function() {
    fetchAll();
});

document.addEventListener('DOMContentLoaded', function() {
    var searchBtn = document.getElementById('searchBtn');
    searchBtn.addEventListener('click', searchCustomer);
});

function searchCustomer(event) {
    event.preventDefault();

    var customerId = document.getElementById('customerId').value;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/search?customerId=' + customerId);
    xhr.onload = function() {
        if (xhr.status === 200) {
            var customerData = JSON.parse(xhr.responseText);
            updateCustomerTable(customerData);
        }
    };
    xhr.send();
}

// 更新客戶資料表格的函數
function updateCustomerTable(customerData) {
    var customerTable = document.getElementById('customerTable');
    var tableBody = customerTable.getElementsByTagName('tbody')[0];

    // 清空表格
    while (tableBody.firstChild) {
        tableBody.removeChild(tableBody.firstChild);
    }

    // 創建新的表格行並填充資料
    var newRow = document.createElement('tr');
    var customerIdCell = document.createElement('td');
    customerIdCell.textContent = customerData.customerId;
    newRow.appendChild(customerIdCell);
    var nameCell = document.createElement('td');
    nameCell.textContent = customerData.name;
    newRow.appendChild(nameCell);
    var emailCell = document.createElement('td');
    emailCell.textContent = customerData.email;
    newRow.appendChild(emailCell);

    // 將新行添加到表格中
    tableBody.appendChild(newRow);
}

document.addEventListener('DOMContentLoaded', function() {
    var searchOrderBtn = document.getElementById('searchOrderBtn');
    searchOrderBtn.addEventListener('click', searchOrder);
});

function searchOrder(event) {
    event.preventDefault();

    var orderid = document.getElementById('orderid').value;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/searchOrder?orderid=' + orderid);
    xhr.onload = function() {
        if (xhr.status === 200) {
            var orderData = JSON.parse(xhr.responseText);
            updateOrderTable(orderData);
        }
    };
    xhr.send();
}

// 更新订单表格的函数
function updateOrderTable(orderData) {
    var orderTable = document.getElementById('orderTable');
    var tableBody = orderTable.getElementsByTagName('tbody')[0];

    // 清空表格
    while (tableBody.firstChild) {
        tableBody.removeChild(tableBody.firstChild);
    }

    // 创建新的表格行并填充数据
    var newRow = document.createElement('tr');
    var orderIdCell = document.createElement('td');
    orderIdCell.textContent = orderData.orderid;
    newRow.appendChild(orderIdCell);
    var freightCell = document.createElement('td');
    freightCell.textContent = orderData.freight;
    newRow.appendChild(freightCell);
    var shipperCell = document.createElement('td');
    shipperCell.textContent = orderData.shipper;
    newRow.appendChild(shipperCell);

    // 将新行添加到表格中
    tableBody.appendChild(newRow);
}