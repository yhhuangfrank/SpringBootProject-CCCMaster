package com.ispan.CCCMaster.exceptionhandler;

import com.ispan.CCCMaster.model.customexception.ApiErrorException;
import com.ispan.CCCMaster.model.customexception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalHandler.class);
    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, Model model) {
        log.error(exception.getMessage(), exception);


        model.addAttribute("isExistError", true);
        model.addAttribute("error", "執行中產生錯誤，請確認後台 !");

        return "exception-page";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRunTimeException(RuntimeException e, Model model) {
        log.error(e.getMessage(), e);

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
        log.error(e.getMessage(), e);

        model.addAttribute("isExistError", true);
        model.addAttribute("error", e.getMessage());

        return "exception-page";
    }

    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<Object> handleApiException(ApiErrorException e) {
        log.error(e.getMessage(), e);

        return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());

    }
}
