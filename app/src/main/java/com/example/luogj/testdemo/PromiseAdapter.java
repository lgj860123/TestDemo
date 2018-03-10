package com.example.luogj.testdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 承诺数据适配器
 * Created by Administrator on 2018/3/10.
 */

public class PromiseAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<PromiseBean> promiseBeanList;

    public PromiseAdapter(Context context) {
        this.context = context;
        promiseBeanList = new ArrayList<>();
    }

    public void setPromiseBeanList(List<PromiseBean> data) {
        if (promiseBeanList != null){
            promiseBeanList.clear();
            promiseBeanList.addAll(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_item_view,parent,false);
        return new PromiseHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return promiseBeanList == null ? 0 : promiseBeanList.size();
    }

    class PromiseHolder extends RecyclerView.ViewHolder{

        public PromiseHolder(View itemView) {
            super(itemView);
        }
    }
}
