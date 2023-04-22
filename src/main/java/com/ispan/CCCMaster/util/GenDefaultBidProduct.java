package com.ispan.CCCMaster.util;

import com.github.javafaker.Faker;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class GenDefaultBidProduct {

    @Autowired
    private BidProductDao bidProductDao;

    private List<BidProduct> defaultBidProducts = new ArrayList<>();

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

        Faker faker = new Faker();
        for (int i = 0; i < defaultImageLinks.length; i += 1) {
            BidProduct bidProduct = new BidProduct();
            bidProduct.setName("九成新 " + defaultCategoryNames[i]);
            bidProduct.addCategory(defaultCategoryNames[i]);
            bidProduct.setBasePrice(faker.number().numberBetween(0, 1000));
            bidProduct.setBidPrice(0);
            bidProduct.setDescription(faker.lorem().paragraph(3));
            bidProduct.setImage(defaultImageLinks[i]);
            defaultBidProducts.add(bidProduct);
        }

        bidProductDao.saveAll(defaultBidProducts);
    }
}
