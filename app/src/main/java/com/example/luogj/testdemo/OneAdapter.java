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
        return new OtherHolder(view);
    }

    @Override
    public void onBindViewHolder(final OtherHolder holder, final int position) {
        OtherHolder otherHolder = holder;
        holder.but_location.setTag(position);
        final OtherBean otherBean = otherBeanList.get(position);
        otherHolder.tv_desc.setText(otherBean.getOtherDesc());
        holder.but_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addressItemListener != null){
                    if ((int)holder.but_location.getTag() == position){
                        AddressBean addressBean = new AddressBean();
                        String otherDesc = otherBean.getOtherDesc() + "==" + position;
                        addressBean.setAddress(otherDesc);
                        addressBean.setId(position);
                        addressItemListener.addAddressItem(addressBean,position);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return otherBeanList == null ? 0 : otherBeanList.size();
    }


    class OtherHolder extends RecyclerView.ViewHolder{

        private final TextView tv_desc;
        private final Button but_location;

        public OtherHolder(View itemView) {
            super(itemView);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            but_location = itemView.findViewById(R.id.but_location);
        }
    }
}
