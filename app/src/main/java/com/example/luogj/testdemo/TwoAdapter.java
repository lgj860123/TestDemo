package com.example.luogj.testdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * 其他界面中的具体位置数据适配器
 * Created by luogj on 2018/3/16.
 */

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.AddressHolder> {
    private Context context;
    private List<AddressBean> addressBeanList;

    private DelObjectItemListener delObjectItemListener;

    public TwoAdapter(Context context){
        this.context = context;
    }

    public void setAddressBeanList(List<AddressBean> data){
        this.addressBeanList = data;
        notifyDataSetChanged();
    }

    public void setDelObjectItemListener(DelObjectItemListener listener){
        this.delObjectItemListener = listener;
    }

    @Override
    public AddressHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_item_address_view,parent,false);
        return new AddressHolder(view);
    }

    @Override
    public void onBindViewHolder(AddressHolder holder, final int position) {
        final AddressBean addressBean = addressBeanList.get(position);
        String address = addressBean.getAddress();
        if (!TextUtils.isEmpty(address)){
            holder.tv_address.setText(addressBean.getAddress());
        }

        holder.but_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delObjectItemListener != null){
                    delObjectItemListener.delObjectItem(addressBean,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return addressBeanList == null ? 0 :addressBeanList.size();
    }

    class AddressHolder extends RecyclerView.ViewHolder{

        private final EditText tv_address;
        private final Button but_del;

        public AddressHolder(View itemView) {
            super(itemView);
            tv_address = itemView.findViewById(R.id.tv_address);
            but_del = itemView.findViewById(R.id.but_del);
        }
    }
}
