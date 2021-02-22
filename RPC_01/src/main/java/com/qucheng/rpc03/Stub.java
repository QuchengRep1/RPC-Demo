package com.qucheng.rpc03;

import com.qucheng.rpc.common.IUserService;
import com.qucheng.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    public static IUserService getStub() {
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method  method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8999);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                dos.writeInt(123);

                s.getOutputStream().write(baos.toByteArray());
                s.getOutputStream().flush();

                DataInputStream dis = new DataInputStream(s.getInputStream());
                int id = dis.readInt();
                String name = dis.readUTF();
                User user = new User(id, name);

                dos.close();
                s.close();
                return user;

            }
        };

        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[]{IUserService.class}, h);
        System.out.println(o.getClass().getName());
        System.out.println("Interfaces 1 = " + o.getClass().getInterfaces()[0]);

        System.out.println("Interfaces all = " + o.getClass().getInterfaces());
        System.out.println("Interfaces all = " + o.getClass().getInterfaces());


        return (IUserService) o;

    }
}
