1. Introduction
   gRPC is a high performance, open source RPC framework initially developed by Google. It helps to eliminate boilerplate code, and connect polyglot services in and across data centers.

2. Overview
   The framework is based on a client-server model of *remote procedure calls*. A client application can directly call methods on a server application as if it was a local object.

In this tutorial, we'll use the following steps to create a typical client-server application using gRPC:

Define a service in a .proto file
Generate server and client code using the protocol buffer compiler
Create the server application, implementing the generated service interfaces and spawning the gRPC server
Create the client application, making RPC calls using generated stubs
Let's define a simple HelloService that returns greetings in exchange for the first and last name.

We can use the following command to generate the code:
```shell
protoc --plugin=protoc-gen-grpc-java=$PATH_TO_PLUGIN -I=$SRC_DIR 
  --java_out=$DST_DIR --grpc-java_out=$DST_DIR $SRC_DIR/HelloService.proto
```

Commands:
```shell
  grpcurl --plaintext localhost:9090 list
  grpcurl --plaintext localhost:9090 list com.techprimers.grpc.GreetingService
  grpcurl --plaintext -d '{"message": "How are you?"}' localhost:9090 com.ipap.springbootgrpcprotocol.HelloServiceGrpc/greeting
```