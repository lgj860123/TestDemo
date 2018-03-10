package com.example.luogj.testdemo;

/**
 * 承诺对象
 * Created by Administrator on 2018/3/10.
 */

public class PromiseBean {

    private String promiseMoney;
    private String promiseDate;
    private String promiseDescription;
    private String promiseRemarks;

    public String getPromiseMoney() {
        return promiseMoney;
    }

    public void setPromiseMoney(String promiseMoney) {
        this.promiseMoney = promiseMoney;
    }

    public String getPromiseDate() {
        return promiseDate;
    }

    public void setPromiseDate(String promiseDate) {
        this.promiseDate = promiseDate;
    }

    public String getPromiseDescription() {
        return promiseDescription;
    }

    public void setPromiseDescription(String promiseDescription) {
        this.promiseDescription = promiseDescription;
    }

    public String getPromiseRemarks() {
        return promiseRemarks;
    }

    public void setPromiseRemarks(String promiseRemarks) {
        this.promiseRemarks = promiseRemarks;
    }

    @Override
    public String toString() {
        return "PromiseBean{" +
                "promiseMoney='" + promiseMoney + '\'' +
                ", promiseDate='" + promiseDate + '\'' +
                ", promiseDescription='" + promiseDescription + '\'' +
                ", promiseRemarks='" + promiseRemarks + '\'' +
                '}';
    }
}
