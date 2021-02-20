package com.qucheng.rpc03;

import com.qucheng.rpc.common.IUserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Stub {
    public static IUserService getStub() {
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        };

    }
