package com.ivy.zheng.upms.rpc.service.impl;

import com.ivy.zheng.commons.base.BaseServiceImpl;
import com.ivy.zheng.upms.dao.mapper.UpmsUserMapper;
import com.ivy.zheng.upms.dao.model.UpmsUser;
import com.ivy.zheng.upms.dao.model.UpmsUserExample;
import com.ivy.zheng.upms.rpc.api.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpmsUserServiceImpl  extends BaseServiceImpl<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService{

    @Autowired
    private UpmsUserMapper upmsUserMapper;

    @Override
    public void createUser(UpmsUser user) {
        upmsUserMapper.insert(user);
    }
}
