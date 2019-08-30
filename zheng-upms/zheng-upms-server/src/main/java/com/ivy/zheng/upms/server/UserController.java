package com.ivy.zheng.upms.server;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ivy.zheng.upms.dao.model.UpmsUser;
import com.ivy.zheng.upms.rpc.api.UpmsUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    private UpmsUserService upmsUserService;

    @GetMapping("/index")
    public String index() {
        return "hello world";
    }

    @GetMapping("/getUser")
    public String getUser() {
        UpmsUser user = upmsUserService.selectByPrimaryKey(1);
        return user.getAvatar();
    }
}
