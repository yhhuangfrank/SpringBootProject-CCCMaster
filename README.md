# SpringBootProject-CCCMaster

山西購物網-3C購物網

![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/adminLogin.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/admin.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/login.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/center.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/home.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/products.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/productDetail.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/bid.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/bidDetail.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/shoppingCart.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/payment.png)
![Previrew](https://github.com/yhhuangfrank/SpringBootProject-CCCMaster/blob/main/src/main/resources/static/previewImages/service.png)

## Features

- 會員系統
- 商品系統
- 二手賣場 (拍賣系統)
- 訂單系統
- 廣告系統
- 客服系統

### Installation

1. 開啟終端機，將專案 clone 至本機電腦

```
git clone https://github.com/yhhuangfrank/SpringBootProject-CCCMaster.git
```

2. 進入專案資料夾

```
cd SpringBootProject-CCCMaster // 進入專案資料夾
```

3. 依照 properties.example 設定 application.properties 進行專案組態設定與資料庫連線設定

4. 使用 IDE 開啟專案後進行 maven reload

5. 運行 CccMasterApplication 檔案若出現下方訊息代表順利執行

```
Started CccMasterApplication in xxx seconds (JVM running for xxx)
```

6. 網址列輸入 http://localhost:8080/ 開始使用帳號密碼登入 (或使用畫面右方開發人員工具快速輸入)

```
預設帳號密碼

前台: 
帳號: CCCMasterUser1@gmail.com
密碼: 123456789
帳號: CCCMasterUser@gmail.com
密碼: 123456789

後台
帳號: 1
密碼: 999999999
```

### Built with

- Java 11 - Environment
- [Spring Boot @4.18.2](https://spring.io/projects/spring-boot) - Web framework
- [Bootstrap 5.2.3](https://getbootstrap.com/docs/5.2/getting-started/introduction/)
- [MS SQL 2019](https://www.microsoft.com/zh-tw/sql-server/sql-server-2019) - Database
- [Hibernate 5.6.15.final](https://hibernate.org/orm/releases/5.6/) - ORM
- And other dependencies
