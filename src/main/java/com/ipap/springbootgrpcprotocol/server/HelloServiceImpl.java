package com.ipap.springbootgrpcprotocol.server;

import com.ipap.springbootgrpcprotocol.HelloRequest;
import com.ipap.springbootgrpcprotocol.HelloResponse;
import com.ipap.springbootgrpcprotocol.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    Logger log = LoggerFactory.getLogger(HelloServiceImpl.class.getName());

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        log.info("Request received from client:\n" + request);

        String greeting = "Hello, " + request.getFirstName() + " "  + request.getLastName();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
