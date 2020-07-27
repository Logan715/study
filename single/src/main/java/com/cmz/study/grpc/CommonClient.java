package com.cmz.study.grpc;

import com.apex.ams.common.CommRequest;
import com.apex.ams.common.CommResponse;
import com.apex.ams.common.CommonGrpc;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class CommonClient {
    private static CommonGrpc.CommonBlockingStub blockingStub;
    public static void main(String args[]) throws Exception{
        String target = "localhost:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();

        try {
            blockingStub = new CommonGrpc.CommonBlockingStub(channel);
            CommResponse handle = blockingStub.handle(CommRequest.newBuilder().build());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(handle));
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
