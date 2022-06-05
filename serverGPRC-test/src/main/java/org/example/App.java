package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8081)
                .addService(new GreetingServiceImpl()) // скок сервисов сток и addService
                .build();
        server.start();
        System.out.println("Сервер запущен!");

        server.awaitTermination(); // когда в консоли завершим программу - сервер тоже погасится
    }
}
