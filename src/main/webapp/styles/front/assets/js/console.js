
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

function updateCustomerTable(customerData) {
    var customerIdCell = document.getElementById('row1col2');
    customerIdCell.textContent = customerData.customerId;
    
    var nameCell = document.getElementById('row1col4');
    nameCell.textContent = customerData.name;

    var phoneNumberCell = document.getElementById('row2col2'); 
    phoneNumberCell.textContent = customerData.phoneNumber; 
    
    var emailCell = document.getElementById('row2col4');
    emailCell.textContent = customerData.email;

    var pointCell = document.getElementById('row3col2'); 
    pointCell.textContent = customerData.point; 
    
    var abandonCountCell = document.getElementById('row3col4');
    abandonCountCell.textContent = customerData.abandonCount;
    
     var startDate = customerData.startDate;

var formattedDate = new Date(startDate).toLocaleString('zh-CN', {
  year: 'numeric',
  month: 'long',
  day: 'numeric',
  hour: '2-digit',
  minute: '2-digit',
  second: '2-digit',
}) + "時 註冊";

var startDateCountCell = document.getElementById('row4col2' );
startDateCountCell.textContent = formattedDate;
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

        function updateOrderTable(orderData) {
            var orderidCell = document.getElementById('trow1col2');
            orderidCell.textContent = orderData.orderid;

            var cbOrderCell = document.getElementById('trow1col4');
            cbOrderCell.textContent = orderData.cbOrder.customerId;

            var addresseeCell = document.getElementById('trow2col2');
            addresseeCell.textContent = orderData.addressee;

            var totalamountCell = document.getElementById('trow2col4');
            totalamountCell.textContent = orderData.totalamount;

            var paymentCell = document.getElementById('trow3col2');
            paymentCell.textContent = orderData.payment;

            var paymentconditionCell = document.getElementById('trow3col4');
            paymentconditionCell.textContent = orderData.paymentcondition;
            
            var shipperCell = document.getElementById('trow4col2');
            shipperCell.textContent = orderData.shipper;

            var freightCell = document.getElementById('trow4col4');
            freightCell.textContent = orderData.freight;
            
            var telephoneCell = document.getElementById('trow5col2');
            telephoneCell.textContent = orderData.telephone;
            
            var shipperaddressCell = document.getElementById('trow6col2');
            shipperaddressCell.textContent = orderData.shipperaddress;
            
            
            var orderDate = orderData.orderdate;
            
            var formattedDate = new Date(orderDate).toLocaleString('zh-CN', {
            year: 'numeric',
            month: 'long',
            day: 'numeric',
            hour: '2-digit',
            minute: '2-digit',
            second: '2-digit',
               }) + "時 訂購";
            
            var orderdateCell = document.getElementById('trow7col2');
            orderdateCell.textContent = formattedDate;
            
            var arrivaldateCell = document.getElementById('trow8col2');
            arrivaldateCell.textContent = orderData.arrivaldate;
        }