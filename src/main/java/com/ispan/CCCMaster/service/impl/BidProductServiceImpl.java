package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.customexception.NotFoundException;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.util.ImgurUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BidProductServiceImpl implements BidProductService {

    private final BidProductDao bidProductDao;

    private final CategoryDao categoryDao;

    private final ImgurUploader imgurUploader;

    @Value("${default.image}")
    private String DEFAULT_IMAGE;

    @Autowired
    public BidProductServiceImpl(BidProductDao bidProductDao,
                                 CategoryDao categoryDao,
                                 ImgurUploader imgurUploader) {
        this.bidProductDao = bidProductDao;
        this.categoryDao = categoryDao;
        this.imgurUploader = imgurUploader;
    }

    @Override
    public BidProduct createBidProduct(BidProductRequest bidProductRequest) {

        BidProduct bidProduct = new BidProduct();
        bidProduct.setName(bidProductRequest.getName());
        bidProduct.setBasePrice(bidProductRequest.getBasePrice());
        bidProduct.setBidPrice(0); // 初始出價為 0
        bidProduct.setCategory(getOrCreateCategory(bidProductRequest.getCategoryName()));
        bidProduct.setDescription(bidProductRequest.getDescription());

        String imageLink = DEFAULT_IMAGE; // 預設圖片

        if (!bidProductRequest.getImage().isEmpty()) {
            // 呼叫 imgur api 上傳圖片，取得 link
            imageLink = imgurUploader.uploadImage(bidProductRequest.getImage());
        }
        bidProduct.setImage(imageLink);

        return bidProductDao.save(bidProduct);
    }

    @Override
    public List<BidProduct> findAllBidProducts() {
        return bidProductDao.findAll();
    }

    @Override
    public BidProduct findBidProductById(Integer id) {
        BidProduct foundBidProduct = bidProductDao.findById(id).orElse(null);

        if (foundBidProduct == null) throw new NotFoundException("查無對應商品，參數有誤!");

        return foundBidProduct;
    }

    @Override
    @Transactional
    public void updateBidProduct(Integer id, BidProductRequest bidProductRequest) {

        BidProduct foundBidProduct = bidProductDao.findById(id).orElse(null);

        if (foundBidProduct == null) throw new NotFoundException("查無對應商品，參數有誤!");

        // 設定新值
        foundBidProduct.setName(bidProductRequest.getName());
        foundBidProduct.setBasePrice(bidProductRequest.getBasePrice());
        foundBidProduct.setCategory(getOrCreateCategory(bidProductRequest.getCategoryName()));
        foundBidProduct.setDescription(bidProductRequest.getDescription());

        if (!bidProductRequest.getImage().isEmpty()) {
            String imageLink = imgurUploader.uploadImage(bidProductRequest.getImage());
            foundBidProduct.setImage(imageLink);
        }

        bidProductDao.save(foundBidProduct);
    }


    private Category getOrCreateCategory(String categoryName) {

        // 查詢種類，若無則新增種類
        Category foundCategory = categoryDao.findCategoryByName(categoryName);
        Category category;
        if (foundCategory == null) {
            // 創建新種類
            category = new Category();
            category.setName(categoryName);
            category = categoryDao.save(category);
        } else {
            category = foundCategory;
        }

        return category;
    }
}
