package com.ispan.CCCMaster.util;

import com.github.javafaker.Faker;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.product.ProductImg;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.ProductDao;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Component
public class GenDefaultBidProduct {

    private final BidProductDao bidProductDao;

    private final CategoryDao categoryDao;

    private final CustomerDao customerDao;

    private final List<BidProduct> defaultBidProducts = new ArrayList<>();

    private final Map<String, Category> categoryMap = new HashMap<>();

    private final ProductDao productDao;


    public GenDefaultBidProduct(BidProductDao bidProductDao, CategoryDao categoryDao, CustomerDao customerDao, ProductDao productDao) {
        this.bidProductDao = bidProductDao;
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
        this.productDao = productDao;
    }

    @PostConstruct
    public void genDefaultBidProducts() {

        long num = bidProductDao.count();

        if (num > 0) return;

        // 新增預設值
        String cellphone = "https://images.unsplash.com/photo-1598327105666-5b89351aff97?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80";
        String mouse = "https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=765&q=80";
        String keyboard = "https://images.unsplash.com/photo-1561112078-7d24e04c3407?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1965&q=80";
        String computer = "https://images.unsplash.com/photo-1494173853739-c21f58b16055?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=765&q=80";
        String notebook = "https://images.unsplash.com/photo-1542393545-10f5cde2c810?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=765&q=80";
        String[] defaultImageLinks = new String[]{cellphone, mouse, keyboard, computer, notebook};
        String[] defaultCategoryNames = new String[]{"手機", "滑鼠", "鍵盤", "電腦", "筆記型電腦"};
        String[] defaultPrefixes = new String[]{"九成新 ", "全新未拆 ", "限量 ", "贈品轉賣 ", "二手 "};

        Faker faker = new Faker();
        int total = defaultImageLinks.length * 5;

        // 設定預設 customer
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setName("小明");
        customer1.setEmail("user1@gmail.com");
        customer1.setPhoneNumber("0911111111");
        customer1.setPassword("123");
        customer2.setName("小華");
        customer2.setEmail("user2@gmail.com");
        customer2.setPhoneNumber("0922222222");
        customer2.setPassword("123");
        customerDao.save(customer1);
        customerDao.save(customer2);

        for (int i = 0; i < total; i += 1) {
            BidProduct bidProduct = new BidProduct();
            int index = i / 5;
            int random = (int) Math.floor(Math.random() * defaultPrefixes.length);
            String randomPrefix = defaultPrefixes[random];
            bidProduct.setName(randomPrefix + defaultCategoryNames[index]);
            bidProduct.setCategory(getOrCreateCategory(defaultCategoryNames[index]));
            bidProduct.setBasePrice(faker.number().numberBetween(0, 1000));
            bidProduct.setBidPrice(0);
            bidProduct.setDescription(faker.lorem().paragraph());
            bidProduct.setImage(defaultImageLinks[index]);
            if (i % 5 == 0) {
                bidProduct.setCustomer(customer1);
            } else {
                bidProduct.setCustomer(customer2);
            }
            defaultBidProducts.add(bidProduct);
        }
        bidProductDao.saveAll(defaultBidProducts);
        genDefaultProduct();
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
        String resourcePath = GenDefaultBidProduct.class.getClassLoader().getResource("").getPath();

        String staticFolderPath = resourcePath + "static/";

        String productImgFolderPath = staticFolderPath + "ProductImg/";
        String imagePath;
        Product product = new Product();
        List<ProductImg>productImgs = new ArrayList<>();
        ProductImg productImg = new ProductImg();
        for (int i = 0; i < imgName.length; i++) { //i表示類別
            for (int j = 0; j < 5; j++) {
                product = new Product();
                productImg = new ProductImg();
                productImgs = new ArrayList<>();
                product.setProductImgs(productImgs);
                Category category=getOrCreateCategory(categoryName[i]);
                product.setCategory(category);
                product.setProductName(productName[i][j]);
                product.setActive(true);
                product.setDescription(faker.lorem().paragraph());
                product.setInventory(faker.number().numberBetween(0, 20));
                product.setPrice(faker.number().numberBetween(100, 10000));
                imagePath = productImgFolderPath + imgName[i] + (j+1)+".jpg";
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
            System.out.println("图片文件不存在：" + imagePath);
            return null;
        }
        try (FileInputStream fileInputStream = new FileInputStream(imageFile);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            // 读取文件数据并写入字节数组输出流
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            // 获取字节数组
            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            System.out.println("图片字节数组长度：" + imageBytes.length);
            return imageBytes;
            // 打印字节数组长度
        } catch (IOException e) {
            System.out.println("读取图片文件时出现错误：" + e.getMessage());
        }
        return null;
    }

}

