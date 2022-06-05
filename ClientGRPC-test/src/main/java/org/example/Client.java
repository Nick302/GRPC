package org.example;

import com.example.proto.GreetingServiceGrpc;
import com.example.proto.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {

        ManagedChannel channel =
                ManagedChannelBuilder
                        .forTarget("localhost:8081")
                        .usePlaintext()
                        .build();


        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc
                        .newBlockingStub(channel); // стаб на основе канала(имени домена) для передачи

        GreetingServiceOuterClass.HelloRequest request =
                GreetingServiceOuterClass
                        .HelloRequest
                        .newBuilder()
                        .setName("Nikita")
                        .build(); // создание запроса с установкой поля имени

        GreetingServiceOuterClass.HelloResponse response = // получаем ответ
                stub.greeting(request);

        System.out.println(response);

        channel.shutdownNow(); // конец

    }
}
