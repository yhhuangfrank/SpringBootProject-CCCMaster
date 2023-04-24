package com.ispan.CCCMaster.util;

import com.ispan.CCCMaster.model.dto.BidProductRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

    }
}
