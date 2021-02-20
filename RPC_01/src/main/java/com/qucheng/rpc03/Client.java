package com.qucheng.rpc03;

import com.qucheng.rpc.common.IUserService;

public class Client {
    public static void main(String[] args) {
        IUserService service = Stub.getStub();
        System.out.println(service.findUserById(123));
    }
}
