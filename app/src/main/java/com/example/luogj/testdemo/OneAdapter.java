package com.example.luogj.testdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * otherActivity界面中的第一个recyclerView的数据适配器
 * Created by luogj on 2018/3/16.
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.OtherHolder>{
    private Context context;
    private List<OtherBean> otherBeanList;
    private AddAddressItemListener addressItemListener;
    private int position;

    public OneAdapter(Context context) {
        this.context = context;
        otherBeanList = new ArrayList<>();
    }

    public void setOtherBeanList(List<OtherBean> data){
        if (otherBeanList != null){
            otherBeanList.clear();
            otherBeanList.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void setAddressItemListener(AddAddressItemListener listener){
        this.addressItemListener = listener;
    }

    @Override
    public OtherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_other_item_view,parent,false);
        return new OtherHolder(view,position);
    }

    @Override
    public void onBindViewHolder(OtherHolder holder, int position) {
        this.position = position;
        OtherHolder otherHolder = holder;
        OtherBean otherBean = otherBeanList.get(position);
        otherHolder.tv_desc.setText(otherBean.getOtherDesc());
    }

    @Override
    public int getItemCount() {
        return otherBeanList == null ? 0 : otherBeanList.size();
    }


    class OtherHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView tv_desc;
        private final Button but_location;
        private int position;

        public OtherHolder(View itemView, int position) {
            super(itemView);
            this.position = position;
            tv_desc = itemView.findViewById(R.id.tv_desc);
            but_location = itemView.findViewById(R.id.but_location);
            but_location.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.but_location:
                    addAddressBean();
                    break;
            }
        }

        private void addAddressBean() {
            AddressBean addressBean = new AddressBean();
            OtherBean otherBean = otherBeanList.get(position);
            String otherDesc = otherBean.getOtherDesc() + "==" + position;
            addressBean.setAddress(otherDesc);
            addressBean.setId(position);
            if (addressItemListener != null){
                addressItemListener.addAddressItem(addressBean,position);
            }
        }
    }
}
