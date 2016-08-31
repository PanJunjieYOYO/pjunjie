package com.jj.demo.springmvc.controller;

import com.jj.demo.springmvc.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panjunjie on 2016/07/31.
 */
public class BaseController {

    @ExceptionHandler(MyException.class)
    public String handleException(Exception ex, HttpServletRequest request){
        request.setAttribute("error",ex.getMessage());
        return "/WEB-INF/jsp/exception.jsp";
    }
}
