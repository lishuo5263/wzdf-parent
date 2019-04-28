package com.wzdf.eurekaServer.juc;

import java.util.concurrent.*;

public class TestCallable implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("this is override method !!!");
        return "this is override method !!!";
    }

    public static void main(String[] args) {
        TestCallable testCallable = new TestCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            //方法一 ： 使用Future 接收异步执行结果
            //  Future<Object> futureResult = executorService.submit(testCallable);
            //  System.out.println("thread executed result is ---->" + futureResult.get());

            //方法二： 使用FutureTask 接收异步执行结果
            FutureTask<Object> futureTask = new FutureTask<Object>(testCallable);
            executorService.submit(futureTask);
            System.out.println("thread executed result is ---->" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
            executorService.shutdown();
        } finally {
            executorService.shutdown();
        }


    }
}
