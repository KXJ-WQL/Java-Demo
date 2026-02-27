package com.wql.service.serviceimpl;

import com.wql.bean.User;
import com.wql.service.UserService;
import org.apache.thrift.TException;

/*
 * @Author WQL-KXJ
 * @ProjectName Thrift-Demo
 * @PackageName com.wql.service.serviceimpl
 * @Date 2024/2/25 21:12
 * @Version 1.0
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public User getById(int id) throws TException {
        User user = new User();
        user.setId(id);
        user.setName("晴天");
        user.setAge(18);
        return user;
    }

    @Override
    public boolean isExist(String name) throws TException {
        return false;
    }
}
