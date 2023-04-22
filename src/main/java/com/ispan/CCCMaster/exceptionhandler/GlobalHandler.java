package com.ispan.CCCMaster.exceptionhandler;

import org.springframework.ui.Model;
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
    public String handleRunTimeException(Model model) {

        model.addAttribute("isExistError", true);
        model.addAttribute("error", "執行中產生錯誤，請確認後台 !");

        return "exception-page";
    }

}
