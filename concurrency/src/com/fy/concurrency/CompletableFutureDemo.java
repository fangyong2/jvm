package com.fy.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class CompletableFutureDemo {
    public static void main(String[] args) {

        List l = Arrays.asList("1", "2", "3", "5", "4");

        Long start1 = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - start1);
        Long start2 = System.currentTimeMillis();
        test2(l);
        System.out.println(System.currentTimeMillis() - start2);
        Long start3 = System.currentTimeMillis();
        test3(l);
        System.out.println(System.currentTimeMillis() - start3);
        Long start4 = System.currentTimeMillis();
        test4(l);
        System.out.println(System.currentTimeMillis() - start4);
    }

    //普通的顺序处理
    public static List<String> test1(List<String> list){
        return list.stream().map(l -> {
            l = l+l;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return l;
        }).collect(Collectors.toList());
    }

    //并行流方式处理
    public static List<String> test2(List<String> list){
        return list.parallelStream().map(l -> {
            l = l+l;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return l;
        }).collect(Collectors.toList());
    }

    //CompletableFuture异步请求方式处理
    public static List<String> test3(List<String> list){
        List<CompletableFuture<String>> lists = list.stream().map(l -> CompletableFuture.supplyAsync(()->{try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }return l+l;})
        ).collect(Collectors.toList());

        return lists.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    //CompletableFuture异步请求方式处理with Executor
    public static List<String> test4(List<String> list){

        Executor executor = Executors.newFixedThreadPool(8, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        List<CompletableFuture<String>> lists = list.stream().map(l -> CompletableFuture.supplyAsync(()->{try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }return l+l;},executor)
        ).collect(Collectors.toList());

        return lists.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
}
