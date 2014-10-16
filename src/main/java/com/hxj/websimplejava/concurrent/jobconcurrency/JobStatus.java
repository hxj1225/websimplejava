package com.hxj.websimplejava.concurrent.jobconcurrency;

public enum JobStatus {

    SUCCESS("success"), FAILED("failed"), TIMEOUT("timeout");

    String value;

    JobStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
