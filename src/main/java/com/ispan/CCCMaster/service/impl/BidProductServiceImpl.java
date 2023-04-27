package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.customexception.NotFoundException;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dto.BidProductQueryParams;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.util.ImgurUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public void createBidProduct(BidProductRequest bidProductRequest) {

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

        bidProductDao.save(bidProduct);
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
    public Page<BidProduct> findBidProducts(BidProductQueryParams queryParams) {

        String categoryName = queryParams.getCategoryName();
        String orderBy = queryParams.getOrderBy();
        String sort = queryParams.getSort();
        Integer page = queryParams.getPage();
        Integer limit = queryParams.getLimit();

        // 使用 Specification interface 建立自訂搜尋條件
        Specification<BidProduct> spec =  (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            // 判定輸入值是否為空
            if (Objects.nonNull(categoryName)) {
                Category category = categoryDao.findCategoryByName(queryParams.getCategoryName());
                // 查詢相對應種類
                Predicate p = criteriaBuilder.equal(root.get("category"),category);
                predicates.add(p);
            }

            // 將搜尋條件從 list 複製到一空 array
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // 判定搜尋方向
        Sort.Direction direction = checkSearchDirection(sort);

        // 建立 Pageable 物件帶入傳遞參數
        Pageable pgb = PageRequest.of(page - 1, limit, direction, orderBy);

        return bidProductDao.findAll(spec, pgb);
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

    @Override
    @Transactional
    public void deleteBidProduct(Integer id) {

        BidProduct foundBidProduct = bidProductDao.findById(id).orElse(null);

        if (foundBidProduct == null) throw new NotFoundException("查無對應商品，參數有誤!");

        bidProductDao.delete(foundBidProduct);
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

    private Sort.Direction checkSearchDirection(String sort) {
        Sort.Direction sorting;
        if (sort.toLowerCase().equals("asc")) {
            sorting = Sort.Direction.ASC;
        } else {
            // 若非 asc 則使用 desc
            sorting = Sort.Direction.DESC;
        }
        return sorting;
    }
}
