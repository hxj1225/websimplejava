package com.hxj.websimplejava.concurrent.jobconcurrency;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hxj.websimplejava.pojo.User;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long s = System.currentTimeMillis();
        JobExecutor jobExecutor = new JobExecutor(executorService);

        jobExecutor.addJob(new Job("task1") {

            @Override
            public Object execute() {
                User user = new User();
                user.setAge(200);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return user;
            }
        });
        jobExecutor.addJob(new Job("task2", 3500) {

            @Override
            public Object execute() {
                User user = new User();
                user.setAge(100);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return user;

            }

        });
        Map<String, JobResult> map = jobExecutor.executeJob();

        for (Map.Entry<String, JobResult> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getMessage() + "---" + entry.getValue().getCostTime());
        }
        System.out.println(System.currentTimeMillis() - s);

        JobExecutor jobExecutor2 = new JobExecutor(executorService);

        jobExecutor2.addJob(new Job("task3") {

            @Override
            public Object execute() {
                User user = new User();
                user.setAge(100);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return user;

            }

        });
        Map<String, JobResult> map1 = jobExecutor2.getExecuteResult();

        for (Map.Entry<String, JobResult> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getResult() + "---" + entry.getValue().getCostTime());
        }

        jobExecutor.destory();
        jobExecutor2.destory();
    }
}
