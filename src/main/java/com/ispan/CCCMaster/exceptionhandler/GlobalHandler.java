package com.ispan.CCCMaster.exceptionhandler;

import com.ispan.CCCMaster.model.customexception.ApiErrorException;
import com.ispan.CCCMaster.model.customexception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Model model) {

        model.addAttribute("isExistError", true);
        model.addAttribute("error", "執行中產生錯誤，請確認後台 !");

        return "exception-page";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRunTimeException(RuntimeException e, Model model) {

        model.addAttribute("isExistError", true);
        if (e.getMessage() != null) {
            model.addAttribute("error", e.getMessage());
        } else {
            model.addAttribute("error", "執行中產生錯誤，請確認後台 !");
        }

        return "exception-page";
    }

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException e, Model model) {

        model.addAttribute("isExistError", true);
        model.addAttribute("error", e.getMessage());

        return "exception-page";
    }

    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<Object> handleApiException(ApiErrorException e) {

        return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());

    }

    // 處理違反 validation 的 api 請求
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleConstraintViolationException(BindException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
