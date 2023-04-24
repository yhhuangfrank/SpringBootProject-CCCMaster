package com.ispan.CCCMaster.util;

import com.ispan.CCCMaster.model.dto.ImgurResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ImgurUploader {

    @Value("${imgur.client.id}")
    private String clientId;

    public String uploadImage(MultipartFile imageFile) {

        try {
            InputStream inputStream = imageFile.getInputStream();
            byte[] inputBytes = new byte[4096];
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            int byteRead;
            while ((byteRead = inputStream.read(inputBytes)) != -1) {
                outputStream.write(inputBytes, 0, byteRead);
            }
            byte[] imageData = outputStream.toByteArray();

            outputStream.close();
            inputStream.close();

            // 設定 http header
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.set("Authorization", "Client-ID " + clientId);

            // Spring 框架中使用 MultiValueMap 將 map 轉為對應 http 請求內容
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            ByteArrayResource resource = new ByteArrayResource(imageData);
            map.add("image", resource);

            // 設定 http request
            HttpEntity<Object> httpReqEntity = new HttpEntity<>(map, headers);

            // 使用 restTemplate 送 POST 請求並接收
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<ImgurResponse> responseEntity = restTemplate.exchange(
                    "https://api.imgur.com/3/image",
                    HttpMethod.POST,
                    httpReqEntity,
                    ImgurResponse.class
            );

            ImgurResponse imgurResponse = responseEntity.getBody();
            String imageLink = "";

            if (imgurResponse != null) {
                Object link = imgurResponse.getData().get("link").orElse(null);
                if (link != null) {
                    imageLink = (String) link;
                }
            }

            return imageLink;

        } catch (IOException  e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            throw new RuntimeException("上傳圖片發生錯誤!");
        }
    }
}
