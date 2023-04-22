package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.util.ImgurUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidProductServiceImpl implements BidProductService {

    @Autowired
    private BidProductDao bidProductDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ImgurUploader imgurUploader;

    @Override
    public BidProduct createBidProduct(BidProductRequest bidProductRequest) {

        BidProduct bidProduct = new BidProduct();
        bidProduct.setName(bidProductRequest.getName());
        bidProduct.setBasePrice(bidProductRequest.getBasePrice());
        bidProduct.setBidPrice(0); // 初始出價為 0

        // 查詢種類，若無則新增種類
        List<Category> list = categoryDao.findCategoryByName(bidProductRequest.getCategoryName());
        Category category = null;
        if (list.isEmpty()) {
            // 創建新種類
            category = new Category();
            category.setName(bidProductRequest.getCategoryName());
            category = categoryDao.save(category);
        } else {
            category = list.get(0);
        }
        bidProduct.setCategory(category);
        bidProduct.setDescription(bidProductRequest.getDescription());

        String imageLink = "";
        if (bidProductRequest.getImage() != null || !bidProductRequest.getImage().isEmpty()) {
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
}
