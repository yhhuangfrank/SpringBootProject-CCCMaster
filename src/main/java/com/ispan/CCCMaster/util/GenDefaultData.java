package com.ispan.CCCMaster.util;

import com.github.javafaker.Faker;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.BidProductComment;
import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.employee.Employee;
import com.ispan.CCCMaster.model.bean.employee.Position;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.product.ProductImg;
import com.ispan.CCCMaster.model.dao.*;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public class GenDefaultData {

    private final BidProductDao bidProductDao;

    private final CategoryDao categoryDao;

    private final CustomerDao customerDao;

    private final PositionDao positionDao;

    private final EmployeeDao employeeDao;

    private final BidProductCommentDao bidProductCommentDao;

    private final String[] defaultCategoryNames = new String[]{"手機", "滑鼠", "鍵盤", "電腦", "筆記型電腦"};

    private final Map<String, Category> categoryMap = new HashMap<>();

    private final ProductDao productDao;


    public GenDefaultData(BidProductDao bidProductDao,
                          CategoryDao categoryDao,
                          CustomerDao customerDao,
                          PositionDao positionDao,
                          EmployeeDao employeeDao,
                          ProductDao productDao,
                          BidProductCommentDao bidProductCommentDao) {
        this.bidProductDao = bidProductDao;
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
        this.positionDao = positionDao;
        this.employeeDao = employeeDao;
        this.productDao = productDao;
        this.bidProductCommentDao = bidProductCommentDao;
    }

    @PostConstruct
    public void genDefaultDataToDB() {

        // 設定預設種類
        createCategories();

        // 設定預設拍賣商品
        createBidProducts();

        // 設定預設職位與員工
        createPositionsAndEmployees();

        //設定預設商品
        genDefaultProduct();

        // 設定預設拍賣商品評論
        createBidProductComments();

    }

    // 預設種類
    private void createCategories() {
        long num = categoryDao.count();

        if (num > 0) return;

        // 新增種類
        for (String name : defaultCategoryNames) {
            Category category = new Category();
            category.setName(name);
            Category newCategory = categoryDao.save(category);
            categoryMap.put(name, newCategory);
        }
    }

    // 預設拍賣商品資料
    private void createBidProducts() {
        long num = bidProductDao.count();

        if (num > 0) return;

        // 新增預設值
        String cellphone = "https://images.unsplash.com/photo-1598327105666-5b89351aff97?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80";
        String mouse = "https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=765&q=80";
        String keyboard = "https://images.unsplash.com/photo-1561112078-7d24e04c3407?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1965&q=80";
        String computer = "https://images.unsplash.com/photo-1494173853739-c21f58b16055?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=765&q=80";
        String notebook = "https://images.unsplash.com/photo-1542393545-10f5cde2c810?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=765&q=80";
        String[] defaultImageLinks = new String[]{cellphone, mouse, keyboard, computer, notebook};
        String[] defaultPrefixes = new String[]{"九成新 ", "全新未拆 ", "限量 ", "贈品轉賣 ", "二手 "};

        Faker faker = new Faker();
        Faker zhTWFaker = new Faker(new Locale("zh-TW"));
        int NUM_OF_BIDPRODUCT_PER_CATEGORY = 10;
        int total = defaultImageLinks.length * NUM_OF_BIDPRODUCT_PER_CATEGORY;

        // 設定預設 customer
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setName(zhTWFaker.name().lastName() + zhTWFaker.name().firstName());
        customer1.setEmail("user1@gmail.com");
        customer1.setPhoneNumber("0911111111");
        String hashedPw = BCrypt.hashpw("123", BCrypt.gensalt());
        customer1.setPassword(hashedPw);
        customer2.setName(zhTWFaker.name().lastName() + zhTWFaker.name().firstName());
        customer2.setEmail("user2@gmail.com");
        customer2.setPhoneNumber("0922222222");
        hashedPw = BCrypt.hashpw("123", BCrypt.gensalt());
        customer2.setPassword(hashedPw);
        customerDao.save(customer1);
        customerDao.save(customer2);

        // 建立預設商品
        List<BidProduct> defaultBidProducts = new ArrayList<>();

        for (int i = 0; i < total; i += 1) {
            BidProduct bidProduct = new BidProduct();
            int index = i / NUM_OF_BIDPRODUCT_PER_CATEGORY; // 使 index 介於 0 - 4
            int random = (int) Math.floor(Math.random() * defaultPrefixes.length);
            String randomPrefix = defaultPrefixes[random];
            bidProduct.setName(randomPrefix + defaultCategoryNames[index]);
            bidProduct.setCategory(getOrCreateCategory(defaultCategoryNames[index]));
            bidProduct.setBasePrice(faker.number().numberBetween(0, 1000));
            bidProduct.setBidPrice(0);
            bidProduct.setDescription(faker.lorem().paragraph());
            bidProduct.setImage(defaultImageLinks[index]);
            bidProduct.setViewCount(faker.number().numberBetween(0, 50));

            // 判斷給予哪位Customer
            Customer customer = i % 5 == 0 ? customer1 : customer2;
            bidProduct.setCustomer(customer);

            defaultBidProducts.add(bidProduct);
        }

        bidProductDao.saveAll(defaultBidProducts);
    }

    private Category getOrCreateCategory(String categoryName) {
        // 先到 map 裡查詢
        Category category = categoryMap.get(categoryName);

        if (category == null) {
            // 查詢種類，若無則新增種類
            Category foundCategory = categoryDao.findCategoryByName(categoryName);
            if (foundCategory == null) {
                // 創建新種類
                Category newCategory = new Category();
                newCategory.setName(categoryName);
                category = categoryDao.save(newCategory);
                categoryMap.put(categoryName, category);
                return category;
            }

            categoryMap.put(categoryName, foundCategory);
            return foundCategory;
        }

        return category;
    }

    private void genDefaultProduct() {
        if (productDao.count() > 0) {
            return;
        }
        System.out.println("enter genDefaultProduct");
        String productName[][] = {{"CORSAIR 海盜船 K70 RGB MK.2 Cherry MX茶軸機械式鍵盤",
                "HyperX Elite 2 RGB機械式鍵盤",
                "MSI 微星 Vigor GK50 Elite LL TC 機械式電競鍵盤",
                "CoolerMaster CK350 機械式 RGB 電競鍵盤 青軸",
                "i-Rocks K71M RGB背光 白色機械式鍵盤 Gateron軸"}, {"logitech羅技 LGHTSPEED 無線遊戲滑鼠 G903",
                "ASUS華碩 ROG Gladius II Origin",
                "FANTECH 超輕量極限電競滑鼠 UX3 HELIOS",
                "FANTECH RGB 2.4G 無線電競滑鼠 WGC1",
                "i rock M31R 滑鼠"}, {"MSI 微星 Infinite S3 13 662TW",
                "Dell 戴爾 3020S i5 SSD Win11電腦",
                "華碩G10CE i7 GTX1660Ti電腦",
                "Acer XC-840 電腦",
                "Acer XC-1760 電腦"
        }, {"ASUS TUF Gaming F15 FX507VV4筆電",
                "MSI微星 Cyborg 15 A12VE 015TW",
                "Lenovo IdeaPad Slim 3i 灰 17.3吋筆電",
                "MSI微星 Sword 15 A12VE 093TW ",
                "ACER Swift GO SFG14 71 54EW"
        }, {"OPPO Reno7 5G ",
                "ASUS 華碩 ROG Phone 5 ZS673KS",
                "SAMSUNG Galaxy S22 Ultra",
                "Samsung Galaxy S21",
                "SAMSUNG Galaxy Note 9"
        }
        };

        String imgName[] = {"keyboard", "mouse", "NB", "PC", "Phone"};
        String categoryName[] = {"鍵盤", "滑鼠", "筆記型電腦", "電腦", "手機"
        };

        Faker faker = new Faker();
        String resourcePath = GenDefaultData.class.getClassLoader().getResource("").getPath();

        String staticFolderPath = resourcePath + "static/";

        String productImgFolderPath = staticFolderPath + "ProductImg/";
        String imagePath;
        Product product = new Product();
        List<ProductImg> productImgs = new ArrayList<>();
        ProductImg productImg = new ProductImg();
        for (int i = 0; i < imgName.length; i++) { //i表示類別
            for (int j = 0; j < 5; j++) {
                product = new Product();
                productImg = new ProductImg();
                productImgs = new ArrayList<>();
                product.setProductImgs(productImgs);
                Category category = getOrCreateCategory(categoryName[i]);
                product.setCategory(category);
                product.setProductName(productName[i][j]);
                product.setActive(true);
                product.setDescription(faker.lorem().paragraph());
                product.setInventory(faker.number().numberBetween(0, 20));
                product.setPrice(faker.number().numberBetween(100, 10000));
                imagePath = productImgFolderPath + imgName[i] + (j + 1) + ".jpg";
                byte[] productImageByte = getProductImageByte(imagePath);
                productImg.setMainImage(true);
                productImg.setImage(productImageByte);
                productImg.setProduct(product);
                productImgs.add(productImg);
                productDao.save(product);
            }
        }
    }

    private byte[] getProductImageByte(String imagePath) {
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.out.println("圖片不存在：" + imagePath);
            return null;
        } else {
            System.out.println("圖片存在：" + imagePath);
        }
        try (FileInputStream fileInputStream = new FileInputStream(imageFile);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            // 讀取圖片
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            //獲得圖片陣列
            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            return imageBytes;
        } catch (IOException e) {
            System.out.println("讀取圖片出現錯誤：" + e.getMessage());
        }
        return null;
    }


    // 預設職位與員工
    private void createPositionsAndEmployees() {
        long num = positionDao.count();

        if (num > 0) return;

        // 預設職位
        Position superManager = new Position();
        superManager.setPositionId(9999);
        superManager.setPositionName("Super Manager");
        positionDao.save(superManager);

        // 預設員工
        Employee employee1 = new Employee();
        employee1.setEmployeeName("山西布政司");
        employee1.setPosition(superManager);
        employee1.setPhoneNumber("0999999999");
        employee1.setIdNumber("A123456789");
        String hashedPw = BCrypt.hashpw("9999", BCrypt.gensalt());
        employee1.setPassword(hashedPw);
        employeeDao.save(employee1);
    }

    // 預設拍賣商品評論資料
    private void createBidProductComments() {

        long num = bidProductCommentDao.count();

        if (num > 0) return;

        List<BidProduct> bidProducts = bidProductDao.findAll();
        List<Customer> customers = customerDao.findAll();

        // every bidProduct have four comments
        int NUM_OF_COMMENT_PER_BIDPRODUCT = 4;
        int total = bidProducts.size() * NUM_OF_COMMENT_PER_BIDPRODUCT;
        Faker faker = new Faker();
        List<BidProductComment> defaultBidProductComments = new ArrayList<>();

        for (int i = 0; i < total; i += 1) {
            BidProductComment bidProductComment = new BidProductComment();
            bidProductComment.setBidProduct(bidProducts.get(i / NUM_OF_COMMENT_PER_BIDPRODUCT));
            int random = (int) Math.floor(Math.random() * customers.size());
            bidProductComment.setCustomer(customers.get(random));
            bidProductComment.setContent(faker.lorem().sentence());
            defaultBidProductComments.add(bidProductComment);
        }

        bidProductCommentDao.saveAll(defaultBidProductComments);
    }
}
