package com.qucheng.rpc03;

import com.qucheng.rpc.common.User;
import com.qucheng.rpc01.UserServiceImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running = true;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8999);
        while (running) {
            Socket ss = serverSocket.accept();
            process(ss);
            ss.close();

        }
        serverSocket.close();

    }

    private static void process(Socket s) throws IOException {
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        int id = dis.readInt();
        com.qucheng.rpc01.UserServiceImpl service = new UserServiceImpl();
        User user = service.findUserById(id);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }

}