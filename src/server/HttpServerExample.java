package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class HttpServerExample {

    public static void main(String[] args) throws IOException {

        String rootContext = "/example";

        // -----------------------------
        // ------------------- server 1
        // -----------------------------
        Scanner sc = new Scanner(System.in);

        System.out.println("[Server1]");
        System.out.print("address : ");
        String address = sc.nextLine();

        System.out.print("port : ");
        int port = Integer.parseInt(sc.nextLine());

        System.out.print("path : ");
        String path =  sc.nextLine();

        HttpServer server = HttpServer.create(new InetSocketAddress(address, port), 0);
        server.createContext(rootContext + path, new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                System.out.println(String.format("[server1] request info\naddress: %s\nmethod: %s\nbody: %s",
                        exchange.getRemoteAddress().toString(),
                        exchange.getRequestMethod(),
                        new String(exchange.getRequestBody().readAllBytes())));

                byte[] response = "server1 response !!!!!!!!!!!!!!!!!!!".getBytes();

                OutputStream out = exchange.getResponseBody();
                exchange.sendResponseHeaders(200, response.length);
                out.write(response);
                out.flush();
                out.close();

                server.stop(0);
            }
        });



        // -----------------------------
        // ------------------- server 2
        // -----------------------------

        System.out.println("[Server2]");
        System.out.print("address : ");
        String address2 = sc.nextLine();

        System.out.println();

        System.out.print("port : ");
        int port2 = Integer.parseInt(sc.nextLine());

        System.out.println();

        System.out.print("path : ");
        String path2 =  sc.nextLine();

        HttpServer server2 = HttpServer.create(new InetSocketAddress(address2, port2), 0);
        server2.createContext(rootContext + path2, new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                System.out.println(String.format("[server2] request info\naddress: %s\nmethod: %s\nbody: %s",
                        exchange.getRemoteAddress().toString(),
                        exchange.getRequestMethod(),
                        new String(exchange.getRequestBody().readAllBytes())));

                byte[] response = "server2 response !!!!!!!!!!!!!!!!!!!".getBytes();

                OutputStream out = exchange.getResponseBody();
                exchange.sendResponseHeaders(200, response.length);
                out.write(response);
                out.flush();
                out.close();

                server2.stop(0);
            }
        });


        server.start();

        System.out.println(String.format("Server started http://%s:%s%s\n", address, port, rootContext + path));

        server2.start();

        System.out.println(String.format("Server started http://%s:%s%s\n", address2, port2, rootContext + path2));

    }
}
