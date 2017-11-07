package com.springData.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by liqing on 2017/3/24 0024.
 */
@Component
@Aspect
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class ControllerAspect {

    @Pointcut("execution(* com.springData.controller.*.*(..))")
    private void userController(){};


    @Around(value = "userController()")
    public Object handleLiebaoControllerException(ProceedingJoinPoint pjp){
        try {
            System.out.println("切面功能");
            return pjp.proceed();
        }  catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

}
