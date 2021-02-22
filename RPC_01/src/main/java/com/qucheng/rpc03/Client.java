package com.qucheng.rpc03;

import com.qucheng.rpc.common.IUserService;

public class Client {
    public static void main(String[] args) {
        System.out.println("Xiao AI Student ~")
        IUserService service = Stub.getStub();
        System.out.println(service.findUserById(123));
        System.out.println(service.findUserById(456));
        System.out.println("Xiao AI Student ~");
    }
}
