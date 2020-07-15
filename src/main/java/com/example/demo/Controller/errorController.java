package com.example.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class errorController implements ErrorController{

    Logger logger = LoggerFactory.getLogger(errorController.class);

    @RequestMapping("/error")
    private String handleError(HttpServletRequest request, Model model, Authentication authentication){

        String errorPage="error";

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status!=null){
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode==HttpStatus.NOT_FOUND.value()) {
                errorPage = "error/404";
                logger.warn("User: " + authentication.getName() + " get NOT FOUND 404 error");
            }
            if(statusCode==HttpStatus.FORBIDDEN.value()){
                errorPage = "error/403";
                logger.warn("User: " + authentication.getName() + " get ACCESS DENIED 403 error");
            }

        }
        return errorPage;
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
