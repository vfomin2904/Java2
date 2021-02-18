package ru.java2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    private final int PORT = 8189;
//    private ServerSocket server;
//    private Socket socket;

    Server() {
        try (ServerSocket server = new ServerSocket(PORT);){


            System.out.println("Server started");
            try(Socket socket = server.accept();){
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in);

                Thread t = new Thread(() ->{
                    while(true){
                        String msg = scanner.nextLine();
                        try {
                            out.writeUTF("Server: "+msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.setDaemon(true);
                t.start();

                while(true){
                    String msg = in.readUTF();
                    if(msg.equals("/end")){
                        System.out.println("Client disconnected");
                        break;
                    }
                    System.out.println("Client: "+msg);
                    out.writeUTF("Echo: "+msg);
                }
            }

        } catch (IOException e) {
            System.out.println("Сервер завершил работу");
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
