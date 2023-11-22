package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class HttpServ {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8085),0);
        server.createContext("/", new Handler("/"));
        server.createContext("/about-us", new Handler("/about-us"));
        server.setExecutor(null);
        server.start();

    }

    static class Handler implements HttpHandler {
        private String path;

        public Handler(String path) {
            this.path = path;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response;
            System.out.println("This is the current path "+path);
            if (Objects.equals(path.length(), 1)){
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<img src="+"https://d1whtlypfis84e.cloudfront.net/guides/wp-content/uploads/2021/03/28193129/Electronics.png />"+
                        "<br>"+
                        "<a href = "+"/about-us>About Us</a>\n"+
                        "<a href = "+"/>Home page</a>\n"+
                        "<h1> Home page</h1>\n" +
                        "</body>\n" +
                        "</html>";
            } else if (path.contains("/about-us")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<a href = "+"/about-us>About Us</a>\n"+
                        "<a href = "+"/>Home page</a>\n"+
                        "<h1> About Us Page</h1>\n" +
                        "<br>"+
                        "<img src="+"data:image/jpeg;base64,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 />"+
                        "</body>\n" +
                        "</html>";
            }
            else{
                response =  "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1> 404 Page Not Found</h1>\n" +
                        "<a href = "+"/about-us>About Us</a>\n"+
                        "<a href = "+"/>Home page</a>\n"+
                        "</body>\n" +
                        "</html>";
            }


            exchange.getResponseHeaders().set("Content-type","text/html");
            exchange.sendResponseHeaders(200, response.length());
            try(OutputStream outputStream = exchange.getResponseBody()){
                outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

}
