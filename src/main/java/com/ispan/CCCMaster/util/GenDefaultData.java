package com.ispan.CCCMaster.util;

import com.github.javafaker.Faker;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.employee.Employee;
import com.ispan.CCCMaster.model.bean.employee.Position;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.EmployeeDao;
import com.ispan.CCCMaster.model.dao.PositionDao;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GenDefaultData {

    private final BidProductDao bidProductDao;

    private final CategoryDao categoryDao;

    private final CustomerDao customerDao;
    
    private final PositionDao positionDao;
    
    private final EmployeeDao employeeDao;

    private final String[] defaultCategoryNames = new String[]{"手機", "滑鼠", "鍵盤", "電腦", "筆記型電腦"};

    private final List<BidProduct> defaultBidProducts = new ArrayList<>();

    private final Map<String, Category> categoryMap = new HashMap<>();

    public GenDefaultData(BidProductDao bidProductDao,
                          CategoryDao categoryDao,
                          CustomerDao customerDao,
                          PositionDao positionDao,
                          EmployeeDao employeeDao) {
        this.bidProductDao = bidProductDao;
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
        this.positionDao = positionDao;
        this.employeeDao = employeeDao;
    }

    @PostConstruct
    public void genDefaultDataToDB() {

        // 設定預設種類
        createCategories();

        // 設定預設拍賣商品
        createBidProducts();
        
        // 設定預設職位與員工
        createPositionsAndEmployees();
        
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
        int total = defaultImageLinks.length * 10;

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
            int index = i / 11; // 使 index 界於 0 - 4
            int random = (int) Math.floor(Math.random() * defaultPrefixes.length);
            String randomPrefix = defaultPrefixes[random];
            bidProduct.setName(randomPrefix + defaultCategoryNames[index]);
            bidProduct.setCategory(getOrCreateCategory(defaultCategoryNames[index]));
            bidProduct.setBasePrice(faker.number().numberBetween(0, 1000));
            bidProduct.setBidPrice(0);
            bidProduct.setDescription(faker.lorem().paragraph());
            bidProduct.setImage(defaultImageLinks[index]);
            if (i % 5 == 0) {
                bidProduct.setCustomer(customer1); // 給 customer 1
            } else {
                bidProduct.setCustomer(customer2);
            }
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
    
    // 預設職位與員工
    private void createPositionsAndEmployees() {
    	long num = positionDao.count();
    	
    	if(num > 0) return;

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
    	employee1.setPassword("9999");
    	employeeDao.save(employee1);
    }
    
}
