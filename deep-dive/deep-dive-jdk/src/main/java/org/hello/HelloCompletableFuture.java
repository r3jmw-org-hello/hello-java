package org.hello;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HelloCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> data = CompletableFuture.supplyAsync(() -> "data");
        CompletableFuture<String> workflow = CompletableFuture.supplyAsync(() -> "workflow");

        CompletableFuture<String> instance = workflow.thenCombine(data, (w, d) -> w + d);

        System.out.println(instance.get());

    }
}
