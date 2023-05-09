package com.ispan.CCCMaster.service;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface ProductImageService {

    ResponseEntity<byte[]> showMainImage(Integer productId);

    List<Integer>getProductImagesList(Integer productId);

    HttpHeaders setImgHttpHeader(byte[] image);

    ResponseEntity<byte[]> showImageByImageId(Integer imageId);


}
