package server.httpserver;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class MyHttpServerImpl implements MyHttpServer {

    private String serverName;
    private HttpServer server ;
    private String address;
    private int port;
    private String path;

    public MyHttpServerImpl(String serverName, String address, int port) throws IOException {
        this.serverName =  serverName;
        this.address = address;
        this.port = port;

        this.server = HttpServer.create(new InetSocketAddress(address, port), 0);
    }

    @Override
    public void setContext(String path, String responseData) {
        this.path = path;

        this.server.createContext(path, (exchange)->{
            System.out.println(String.format("[%s] request info\naddress: %s\nmethod: %s\nbody: %s\n",
                    serverName,
                    exchange.getRemoteAddress().toString(),
                    exchange.getRequestMethod(),
                    new String(exchange.getRequestBody().readAllBytes())));

            byte[] response = responseData.getBytes();

            OutputStream out = exchange.getResponseBody();
            exchange.sendResponseHeaders(200, response.length);
            out.write(response);
            out.flush();
            out.close();

            server.stop(0);
        });
    }

    @Override
    public void start() {
        this.server.start();
        System.out.println(String.format("Server started http://%s:%s%s\n", address, port, path));
    }
}
