package com.early.duoxiancheng;




import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author gwh
 */
public class TaskCallable implements Callable<String>{
    private int id;
    public TaskCallable(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "result of taskWithResult "+id;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();//工头
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();//
        for(int i = 0 ; i < 10 ;i++){
            results.add(exec.submit(new TaskCallable(i)));//submit返回一个Future，代表了即将要返回的结果
        }

        System.out.println("size1: "+results.size());
        int count1 = 0;
        int count2 = 0;
        for(Future<String> future: results){
            System.out.println("isDone: "+future.isDone());
            if(future.isDone())count2 ++;
            try {
                System.out.println("get: "+future.get());
                count1 ++;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("count1: "+count1);
        System.out.println("count2: "+count2);

        exec.shutdown();
    }
}
