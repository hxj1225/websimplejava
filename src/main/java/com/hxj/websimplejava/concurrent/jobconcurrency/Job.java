package com.hxj.websimplejava.concurrent.jobconcurrency;

import java.util.concurrent.Callable;

public abstract class Job implements Callable<JobResult> {

    private String name;
    /**
     * ³¬Ê±Ê±¼ä
     */
    private long   timeout;

    public Job(String name){
        this.name = name;
    }

    public Job(String name, long timeout){
        this.name = name;
        this.timeout = timeout;
    }

    @Override
    public JobResult call() throws Exception {
        long startTime = System.currentTimeMillis();
        JobResult jobResult = new JobResult();
        try {
            Object result = this.execute();
            jobResult.setResult(result);
            jobResult.setJobStatus(JobStatus.SUCCESS);
            jobResult.setMessage(name + " execute success");
        } catch (Exception e) {
            jobResult.setJobStatus(JobStatus.FAILED);
            jobResult.setMessage(e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        long cost = endTime - startTime;
        jobResult.setCostTime(cost);
        return jobResult;
    }

    public abstract Object execute();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

}
