package com.qucheng.rpc02;

import com.qucheng.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Stub {
    public User findUserById(Integer id) throws Exception{

        Socket s = new Socket("127.0.0.1",8989);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        int receivedId = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id,name);

        dos.close();
        s.close();
        return user;

    }
}
