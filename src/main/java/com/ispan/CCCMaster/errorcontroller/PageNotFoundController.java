package com.ispan.CCCMaster.errorcontroller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageNotFoundController implements ErrorController {

    @GetMapping("/error")
    public String pageNotFound() {
        return "exception-page";
    }
}
