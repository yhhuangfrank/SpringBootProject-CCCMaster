package com.ispan.CCCMaster.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.product.ProductImg;

public interface ProductImgDao extends JpaRepository<ProductImg, Integer> {
//    @Query("SELECT pi FROM ProductImg pi WHERE pi.product.productId = :productId")
//    List<ProductImg> findProductImgByProductId(@Param("productId") Integer productId);

    @Query ("SELECT pi FROM ProductImg pi WHERE pi.product.productId = :productId and pi.mainImage=true ")
    ProductImg findMainImageByProductId(@Param("productId") Integer productId);

    @Query("select pi.productImgId from ProductImg pi WHERE pi.product.productId=:productId")
    List<Integer>findProductImgIdList(@Param("productId") Integer productId);

    ProductImg findByProductAndMainImage(Product product, Boolean mainImage);

    List<ProductImg> findByProductAndMainImageFalse(Product product);

}
