package com.example.luogj.testdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener,
        OnMoneyFillListener, OnDateFillListener,OnDescriptionFillListener,OnRemarksFillListener,DelObjectItemListener {

    private Context context;
    private RelativeLayout rl_addPromise;
    private RecyclerView rv_promise;
    private Button but_commit,but_other;
    private PromiseAdapter adapter;
    private List<PromiseBean> promiseBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        rl_addPromise = findViewById(R.id.rl_addPromise);
        rv_promise = findViewById(R.id.rv_promise);
        but_commit = findViewById(R.id.but_commit);

        but_other = findViewById(R.id.but_other);

        rl_addPromise.setOnClickListener(this);
        but_commit.setOnClickListener(this);
        but_other.setOnClickListener(this);

        promiseBeanList = new ArrayList<>();
        adapter = new PromiseAdapter(context);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_promise.setLayoutManager(manager);
        adapter.setMoneyFillListener(this);
        adapter.setDateFillListener(this);
        adapter.setDescriptionFillListener(this);
        adapter.setRemarksFillListener(this);
        adapter.setDelPromiseItemListener(this);
        rv_promise.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_addPromise:
                addPromise();
                break;
            case R.id.but_commit:
                getPromiseData();
                break;
            case R.id.but_other:
                gotoOtherView();
                break;
        }
    }


    private void addPromise() {
        PromiseBean promiseBean = new PromiseBean();
        promiseBeanList.add(promiseBean);
        adapter.setPromiseBeanList(promiseBeanList);
    }

    private void getPromiseData() {
        if (promiseBeanList != null && promiseBeanList.size() != 0){
            for (PromiseBean promiseBean : promiseBeanList){
                Log.i("getPromiseData", "getPromiseData: " + promiseBean.toString() + "\n");
            }
        }
    }

    @Override
    public void onMoneyFill(int position, String money) {
        if (position < promiseBeanList.size()){
            promiseBeanList.get(position).setPromiseMoney(money);
        }
    }

    @Override
    public void onDateFill(int position, String date) {
        if (position < promiseBeanList.size()){
            promiseBeanList.get(position).setPromiseDate(date);
        }
    }

    @Override
    public void onDescriptionFill(int position, String description) {
        if (position < promiseBeanList.size()){
            promiseBeanList.get(position).setPromiseDescription(description);
        }
    }

    @Override
    public void onRemarksFill(int position, String remarks) {
        if (position < promiseBeanList.size()){
            promiseBeanList.get(position).setPromiseRemarks(remarks);
        }
    }

    @Override
    public void delObjectItem(Object promiseBean, int position) {
        Log.i("getPromiseData", "##### delObjectItem: " + position);
        if (promiseBeanList.size() == 1){
            promiseBeanList.remove(promiseBean);
            adapter.setPromiseBeanList(promiseBeanList);
        }else {
            promiseBeanList.remove(promiseBean);
        }
    }

    /**
     * 跳转到其他界面
     */
    private void gotoOtherView() {
        Intent intent = new Intent(context,OtherActivity.class);
        startActivity(intent);
    }


}
