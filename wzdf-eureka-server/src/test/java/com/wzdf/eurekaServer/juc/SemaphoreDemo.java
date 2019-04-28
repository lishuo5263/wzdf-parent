package com.wzdf.eurekaServer.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    //表示老师只有10支笔
    private static Semaphore semaphore = new Semaphore(1);


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            executorService.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "  同学准备获取笔......");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "  同学获取到笔");
                    System.out.println(Thread.currentThread().getName() + "  填写表格ing.....");
                    TimeUnit.SECONDS.sleep(3);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "  填写完表格，归还了笔！！！！！！");
                }catch (Exception e){
                    e.printStackTrace();
                }

            });
        }
        executorService.shutdown();
    }
}
