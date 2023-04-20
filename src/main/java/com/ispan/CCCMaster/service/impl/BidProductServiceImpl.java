package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BidProductServiceImpl implements BidProductService {

    @Autowired
    private BidProductDao bidProductDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public BidProduct createBidProduct(BidProductRequest bidProductRequest) {

        if (bidProductRequest.getImage() != null) {
            // 呼叫 imgur api 上傳圖片，取得 link
        }

        BidProduct bidProduct = new BidProduct();
        bidProduct.setName(bidProductRequest.getName());
        bidProduct.setBasePrice(bidProductRequest.getBasePrice());

        // 查詢種類，若無則新增種類
        Category foundCategory = categoryDao.findCategoryByName(bidProductRequest.getCategoryName());


        bidProduct.setDescription(bidProductRequest.getDescription());

        return bidProductDao.save(bidProduct);
    }
}
