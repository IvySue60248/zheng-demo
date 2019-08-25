package com.ivy.zheng.upms.rpc.api;


import com.ivy.zheng.commons.base.BaseService;
import com.ivy.zheng.upms.dao.model.UpmsUser;
import com.ivy.zheng.upms.dao.model.UpmsUserExample;

public interface UpmsUserService extends BaseService<UpmsUser, UpmsUserExample> {

    void createUser(UpmsUser user);
}
