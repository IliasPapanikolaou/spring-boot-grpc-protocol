package com.ipap.springbootgrpcprotocol.service;

import com.ipap.springbootgrpcprotocol.GreetingRequest;
import com.ipap.springbootgrpcprotocol.GreetingResponse;
import com.ipap.springbootgrpcprotocol.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class GreetingsServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    Logger log = LoggerFactory.getLogger(GreetingsServiceImpl.class.getName());

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        log.info("Received message: {}", message);

        GreetingResponse response = GreetingResponse.newBuilder()
                .setMessage("Received your " + message + ". Hello from server")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted(); // close connection
    }
}
