package com.example.luogj.testdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

/**
 * Created by luogj on 2018/3/16.
 */

public class OtherActivity extends Activity {

    private RecyclerView rv_one;
    private RecyclerView rv_two;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_other);
        initView();
    }

    private void initView() {
        rv_one = findViewById(R.id.rv_one);
        rv_two = findViewById(R.id.rv_two);
    }
}
