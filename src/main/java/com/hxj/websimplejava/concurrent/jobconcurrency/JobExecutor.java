package com.hxj.websimplejava.concurrent.jobconcurrency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JobExecutor {

    private ExecutorService        executorService;

    @Deprecated
    Map<String, Future<JobResult>> resultMap = new HashMap<String, Future<JobResult>>();

    Set<Job>                       jobSet    = new HashSet<>();

    public JobExecutor(int threadSize){
        if (executorService == null) executorService = Executors.newFixedThreadPool(threadSize);
    }

    public JobExecutor(ExecutorService executorService){
        this.executorService = executorService;
    }

    public void addJob(Job job) {
        jobSet.add(job);
    }

    public Map<String, JobResult> executeJob() {
        Map<String, JobResult> executeResult = new HashMap<>();
        for (Job job : jobSet) {
            Future<JobResult> future = executorService.submit(job);
            JobResult jobResult = new JobResult();
            try {
                if (job.getTimeout() > 0) {
                    jobResult = future.get(job.getTimeout(), TimeUnit.MILLISECONDS);
                } else {
                    jobResult = future.get();
                }
            } catch (TimeoutException e) {
                // 超时处理
                jobResult.setJobStatus(JobStatus.TIMEOUT);
                jobResult.setMessage("timeout");

            } catch (InterruptedException | ExecutionException e1) {
                // 异常补偿
                jobResult.setJobStatus(JobStatus.FAILED);
                jobResult.setMessage(e1.getMessage());
            }
            executeResult.put(job.getName(), jobResult);
        }
        jobSet.clear();
        return executeResult;
    }

    public void destory() {
        if (executorService != null) {
            executorService.shutdown();
            executorService = null;
        }
    }

    @Deprecated
    public void putJob(Job job) {
        resultMap.put(job.getName(), executorService.submit(job));
    }

    @Deprecated
    public Map<String, JobResult> getExecuteResult() {
        Map<String, JobResult> executeResult = new HashMap<>();
        for (Map.Entry<String, Future<JobResult>> entry : resultMap.entrySet()) {
            try {
                executeResult.put(entry.getKey(), entry.getValue().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        resultMap.clear();
        return executeResult;
    }
}
