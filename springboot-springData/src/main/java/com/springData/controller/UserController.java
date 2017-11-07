package com.springData.controller;

import com.springData.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by conglin.lin on 2017/6/2.
 */
@RestController
@Api(description = "用户controller")
public class UserController {
    @Autowired
    private UserService userService;

    //http://127.0.0.1:8080/findUid
    @ApiOperation(value = "", notes = "redis缓存session")
    @RequestMapping(value = "/findUid" ,method = RequestMethod.GET)
    public String fingUid(
                @ApiParam(name = "session",value = "会话") HttpSession session
    ) {
        UUID uid =(UUID) session.getAttribute("uid");
        if(uid == null) {
             uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }


}
