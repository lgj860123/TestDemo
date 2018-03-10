package com.example.luogj.testdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    private Context context;
    private RelativeLayout rl_addPromise;
    private RecyclerView rv_promise;
    private Button but_commit;
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

        rl_addPromise.setOnClickListener(this);
        but_commit.setOnClickListener(this);

        promiseBeanList = new ArrayList<>();
        adapter = new PromiseAdapter(context);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_promise.setLayoutManager(manager);
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
        }
    }


    private void addPromise() {
        PromiseBean promiseBean = new PromiseBean();
        promiseBeanList.add(promiseBean);
        adapter.setPromiseBeanList(promiseBeanList);
    }

    private void getPromiseData() {

    }
}
