package com.qucheng.rpc03;

import com.qucheng.rpc.common.IUserService;
import com.qucheng.rpc.common.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(id,"Alice");
    }

}