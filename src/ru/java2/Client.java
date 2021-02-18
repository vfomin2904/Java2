package ru.java2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final int PORT = 8189;
    private final String IP = "localhost";
    private Socket socket;

    Client(){
        try {
            socket = new Socket(IP,PORT);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());


            Thread t = new Thread(() ->{
                while(true){
                    String echo = null;
                    try {
                        echo = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(echo);
                }
            });
            t.setDaemon(true);
            t.start();

            while(true){
                String msg = scanner.nextLine();
                if(msg.equals("/end")){
                    System.out.println("Connection close");
                    break;
                }
                out.writeUTF(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
