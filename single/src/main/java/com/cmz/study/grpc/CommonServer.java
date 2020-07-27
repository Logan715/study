package com.cmz.study.grpc;

import com.apex.ams.common.CommRequest;
import com.apex.ams.common.CommResponse;
import com.apex.ams.common.CommonGrpc;
import com.google.protobuf.Any;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.FloatValue;
import com.google.protobuf.Int32Value;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import io.grpc.BindableService;
public class CommonServer {
    private int port  =50051;
    private Server server;
    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new CommonImpl()).build().start();
//        log.info("Server started, listening on " + port);
        System.out.println("Server started, listening on " + port);
    }
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final CommonServer server = new CommonServer();
        server.start();
        server.blockUntilShutdown();
    }
}
class CommonImpl extends CommonGrpc.CommonImplBase {

    @Override
    public void handle(CommRequest request, StreamObserver<CommResponse> responseObserver) {
        Map<String, Any> map = new HashMap<>();
        map.put("a", Any.pack(Int32Value.newBuilder().setValue((short) 1).build()));
        map.put("b", Any.pack(Any.pack(FloatValue.newBuilder().setValue((float) 2).build())));
        map.put("b", Any.pack(Any.pack(DoubleValue.newBuilder().setValue((double) 2).build())));
        CommResponse response = CommResponse.newBuilder().setCode(1).setNote("hehe").putAllData(map).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}


