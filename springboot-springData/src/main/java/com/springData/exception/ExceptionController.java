package com.springData.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
@RestController
public class ExceptionController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK , reason = "参数错误")
    public String exceptionOccurs(Exception e) {
        System.out.println(httpServletRequest.getRequestURL());
        System.out.println(e);
        return "捕获全局异常";
    }


    @ExceptionHandler(AppLoginException.class)
    public String handleAppLoginException(AppLoginException e){
        System.out.println(httpServletRequest.getRequestURL());
        System.out.println(e);
        return "捕获自定义异常 ";
    }




}
