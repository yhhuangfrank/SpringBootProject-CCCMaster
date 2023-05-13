package com.ispan.CCCMaster.exceptionhandler;

import com.ispan.CCCMaster.model.customexception.ApiErrorException;
import com.ispan.CCCMaster.model.customexception.NotFoundException;
import com.ispan.CCCMaster.model.customexception.UnLoginException;
import com.ispan.CCCMaster.model.customexception.UnpayException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalHandler {


    @ExceptionHandler(Exception.class)
    public String handleException( Model model) {

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
    public ResponseEntity<Object> handleBindException(BindException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    
    // 處理必須登入而未登入的例外處理
    @ExceptionHandler(UnLoginException.class)
    public String handleUnLoginException(RedirectAttributes redirectAttributes) {
    	redirectAttributes.addFlashAttribute("isWarning", true);
		redirectAttributes.addFlashAttribute("warningMsg", "喔喔!您尚未登入哦!請登入以繼續進行操作");
    	return "redirect:/login";
    }
    
    //處理逾期付款的例外處理
    @ExceptionHandler(UnpayException.class)
    public String handleUnpayException() {
    	return "redirect:/front/bidorders/unpay";
    }

}
