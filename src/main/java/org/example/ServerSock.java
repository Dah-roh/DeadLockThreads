package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerSock {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8085);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");
       try {
           BufferedReader bufferedReader = new BufferedReader(
                   new InputStreamReader(socket.getInputStream()));
           OutputStream outputStream = socket.getOutputStream();
           String message;
           String outPutMessage;
           while (true) {
               message = bufferedReader.readLine();
               System.out.println(message);
               String response =   "<!DOCTYPE html>\n" +
                       "<html lang=\"en\">\n" +
                       "<head>\n" +
                       "    <meta charset=\"UTF-8\">\n" +
                       "    <title>HomePage</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "<h1> Hi, How are you doing?</h1>\n" +
                       "</body>\n" +
                       "</html>";


               outPutMessage = "HTTP/1.1 200 OK\r\n" +
                       "Content-type: text/html\r\n" +
                       "Content-length:"+response.length()+"\r\n"+
                       "\r\n"+
                       response;
               outputStream.write(outPutMessage.getBytes(StandardCharsets.UTF_8));
               outputStream.flush();
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }


    public void httpServerUsingSun(){

    }
}
