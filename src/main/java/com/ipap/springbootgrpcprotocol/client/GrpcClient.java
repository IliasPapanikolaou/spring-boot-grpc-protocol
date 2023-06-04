package com.ipap.springbootgrpcprotocol.client;

import com.ipap.springbootgrpcprotocol.HelloRequest;
import com.ipap.springbootgrpcprotocol.HelloResponse;
import com.ipap.springbootgrpcprotocol.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClient {

    private static final Logger log = LoggerFactory.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("John")
                .setLastName("Travolta")
                .build()
        );

        log.info("Response received from server:\n {}", helloResponse);

        channel.shutdown();
    }
}
