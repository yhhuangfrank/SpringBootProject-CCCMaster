package com.ispan.CCCMaster.util;

import com.ispan.CCCMaster.model.dto.BidProductRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BidProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BidProductRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        BidProductRequest request = (BidProductRequest) target;

        String inValidString = "<script>";
        String message = "不可輸入非法字元";

        // 驗證欄位是否有包含非法字元
        if (request.getName().contains(inValidString)) {
            errors.rejectValue("name", "BidProductRequest.name.invalidInput", "欄位:名稱 " + message);
        }

        if (request.getName().length() > 20) {
            errors.rejectValue("name", "BidProductRequest.name.invalidInput", "欄位:名稱 不可超過20個字");
        }

        if (request.getCategoryName().contains(inValidString)) {
            errors.rejectValue("categoryName", "BidProductRequest.categoryName.invalidInput", "欄位:種類 " + message);
        }

        if (request.getDescription().contains(inValidString)) {
            errors.rejectValue("description", "BidProductRequest.description.invalidInput", "欄位:描述 " + message);
        }

        if (!isValidEndDate(request.getEndDate())) {
            errors.rejectValue("endDate", "BidProductRequest.endDate.invalidInput", "欄位: 日期 輸入值有誤");
        }

    }

    private boolean isValidEndDate(String dateString) {
        // 處理日期
        Date date;

        if (dateString == null || dateString.length() == 0) {
            return true; // 截止日期可為空值
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            date = dateFormat.parse(dateString);
            long now = System.currentTimeMillis();
            long offset = (7 * 24 * 60 * 60 * 1000); // offset 為一周
            // 判斷是否於一周以內 且 大於現在
            return (date.getTime() <= now + offset) && date.getTime() > now;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期轉換過程發生錯誤!");
        }
    }
}
