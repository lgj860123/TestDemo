package com.example.luogj.testdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 其他界面中的具体位置数据适配器
 * Created by luogj on 2018/3/16.
 */

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.AddressHolder> {
    private Context context;
    private List<AddressBean> addressBeanList;

    public TwoAdapter(Context context){
        this.context = context;
    }

    public void setAddressBeanList(List<AddressBean> data){
        this.addressBeanList = data;
        notifyDataSetChanged();
    }

    @Override
    public AddressHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_item_address_view,parent,false);
        return new AddressHolder(view);
    }

    @Override
    public void onBindViewHolder(AddressHolder holder, int position) {
        AddressBean addressBean = addressBeanList.get(position);
        holder.tv_address.setText(addressBean.getAddress());
    }

    @Override
    public int getItemCount() {
        return addressBeanList == null ? 0 :addressBeanList.size();
    }

    class AddressHolder extends RecyclerView.ViewHolder{

        private final TextView tv_address;

        public AddressHolder(View itemView) {
            super(itemView);
            tv_address = itemView.findViewById(R.id.tv_address);
        }
    }
}
