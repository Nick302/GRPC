package org.example;

import com.example.proto.GreetingServiceGrpc;
import com.example.proto.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override // описание из прото метод , в оутере то что мы сгенерировали кст
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver){
     // в респонсе вызываем метод и он передает на клиента , асинхроный подход и не ждем ответа
        System.out.println(request); // вывод что пришло от клиента , тостринг оопределен уже

        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass
                .HelloResponse
                .newBuilder()
                .setGreeting("Hello from server, " + request.getName()) // ответ 1 поле greeting - текстовое
                .build();

        responseObserver.onNext(response); // отправляем ответ , один
        responseObserver.onCompleted(); // что мы больше не будем пересылать данные

    }

}
