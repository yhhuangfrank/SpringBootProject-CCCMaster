package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.product.ProductImg;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductImageService {

    ResponseEntity<byte[]> showMainImage(Integer productId);

    List<Integer>getProductImagesList(Integer productId);

    HttpHeaders setImgHttpHeader(byte[] image);

    ResponseEntity<byte[]> showImageByImageId(Integer imageId);
}
