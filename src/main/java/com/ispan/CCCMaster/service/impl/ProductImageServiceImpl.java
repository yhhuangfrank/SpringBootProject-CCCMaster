package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.product.ProductImg;
import com.ispan.CCCMaster.model.dao.ProductImgDao;
import com.ispan.CCCMaster.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImgDao productImgDao;


    @Override
    public ResponseEntity<byte[]> showMainImage(Integer productId){
        byte[] image = productImgDao.findMainImageByProductId(productId).getImage();
        return new ResponseEntity<>(image, setImgHttpHeader(image), HttpStatus.OK);
    }

    @Override
    public List<Integer>getProductImagesList(Integer productId){
        return productImgDao.findProductImgIdList(productId);
    }

    @Override
    public HttpHeaders setImgHttpHeader(byte[] image){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return headers;
    }

    @Override
    public ResponseEntity<byte[]> showImageByImageId(Integer imageId){
        Optional<ProductImg> optional = productImgDao.findById(imageId);
        byte[] image=null;
        if(optional.isPresent()){
            System.out.println("optional.isPresent");
            image=optional.get().getImage();
        }
        return new ResponseEntity<>(image, setImgHttpHeader(image), HttpStatus.OK);
    }
}
