package com.example.luogj.testdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luogj on 2018/3/16.
 */

public class OtherActivity extends Activity implements AddAddressItemListener{

    private RecyclerView rv_one;
    private RecyclerView rv_two;
    private Context context;

    private List<OtherBean> otherBeanList = new ArrayList<>();
    private OneAdapter oneAdapter;

    private List<AddressBean> addressBeanList = new ArrayList<>();
    private TwoAdapter twoAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_other);
        initData();
        initView();
    }

    /**
     * 初始化测试数据
     */
    private void initData() {
        OtherBean otherBeanOne = new OtherBean();
        otherBeanOne.setOtherBeanId(1);
        otherBeanOne.setOtherDesc("请你一安好家就把地址告诉我");

        OtherBean otherBeanTwo = new OtherBean();
        otherBeanTwo.setOtherBeanId(2);
        otherBeanTwo.setOtherDesc("提供即时免费的多语种文本翻译和网页翻译服务");
        otherBeanList.add(otherBeanOne);
        otherBeanList.add(otherBeanTwo);
    }

    /**
     * 初始化界面
     */
    private void initView() {
        rv_one = findViewById(R.id.rv_one);
        rv_two = findViewById(R.id.rv_two);

        oneAdapter = new OneAdapter(context);
        LinearLayoutManager managerOne = new LinearLayoutManager(context);
        managerOne.setOrientation(LinearLayoutManager.VERTICAL);
        rv_one.setLayoutManager(managerOne);
        rv_one.setAdapter(oneAdapter);

        oneAdapter.setOtherBeanList(otherBeanList);
        oneAdapter.setAddressItemListener(this);

        twoAdapter = new TwoAdapter(context);
        LinearLayoutManager managerTwo = new LinearLayoutManager(context);
        managerTwo.setOrientation(LinearLayoutManager.VERTICAL);

        rv_two.setLayoutManager(managerTwo);
        rv_two.setAdapter(twoAdapter);
    }

    @Override
    public void addAddressItem(AddressBean addressBean, int position) {
        addressBeanList.add(addressBean);
        twoAdapter.setAddressBeanList(addressBeanList);
    }
}
