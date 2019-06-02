package com.yuliyao.growthdemo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 全双工socket server demo
 * @author yuliyao
 * @date 2019/6/3
 */
public class DuplexServerDemo {

    public static void main(String[] args) throws IOException {
        //开启服务，监听
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader = null;
        try {
            serverSocket = new ServerSocket(8080);
            Socket accept = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            //从键盘输入
            BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
            String line = inReader.readLine();
            while (!"bye".equals(line)) {

                System.out.println(line);
                line = inReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

    }
}
