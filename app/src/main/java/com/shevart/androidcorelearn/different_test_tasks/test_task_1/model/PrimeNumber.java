package com.shevart.androidcorelearn.different_test_tasks.test_task_1.model;

public class PrimeNumber {
    private int threadId;
    private int primeNumber;

    public PrimeNumber() {

    }

    public PrimeNumber(int threadId, int primeNumber) {
        this.threadId = threadId;
        this.primeNumber = primeNumber;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public int getPrimeNumber() {
        return primeNumber;
    }

    public void setPrimeNumber(int primeNumber) {
        this.primeNumber = primeNumber;
    }
}
