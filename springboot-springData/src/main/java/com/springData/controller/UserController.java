package com.springData.controller;

import com.springData.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by conglin.lin on 2017/6/2.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //http://127.0.0.1:8080/findUid
    @RequestMapping("/findUid")
    public String fingUid(HttpSession session) {
        UUID uid =(UUID) session.getAttribute("uid");
        if(uid == null) {
             uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
