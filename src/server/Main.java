package server;

import server.httpserver.MyHttpServer;
import server.httpserver.MyHttpServerImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        MyHttpServer server1 = createServer("server1");
        MyHttpServer server2 = createServer("server2");

        server1.start();
        server2.start();
    }

    public static MyHttpServer createServer(String servername) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("[" + servername + "]");
        System.out.print("address : ");
        String address = sc.nextLine();

        System.out.print("port : ");
        int port = Integer.parseInt(sc.nextLine());

        System.out.print("path : ");
        String path =  sc.nextLine();

        System.out.print("responseData : ");
        String responseData =  sc.nextLine();
        System.out.println();

        MyHttpServer server = new MyHttpServerImpl(servername, address, port);
        server.setContext(path, responseData);

        return server;
    }

}
