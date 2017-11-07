package com.springData.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by conglin.liu on 2017/11/6.
 */

@RestController
@Api(description = "测试controller")
public class TestController {

    //http://127.0.0.1:8080/testSwagger  和 http://127.0.0.1:8080/swagger-ui.html
    @ApiOperation(value = "1", notes = "testSwagger")
    @RequestMapping(value = "/testSwagger" ,method = RequestMethod.GET)
    public String testSwagger(
            @ApiParam(name = "name",value = "会话") String content
    ) {

        return "testSwagger";
    }

}
