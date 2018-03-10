package com.example.luogj.testdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 承诺数据适配器
 * Created by Administrator on 2018/3/10.
 */

public class PromiseAdapter extends RecyclerView.Adapter<PromiseAdapter.PromiseHolder> {

    private Context context;
    private List<PromiseBean> promiseBeanList;

    private OnMoneyFillListener moneyFillListener;
    private OnDateFillListener dateFillListener;
    private OnDescriptionFillListener descriptionFillListener;
    private OnRemarksFillListener remarksFillListener;
    private OnItemClickListener itemClickListener;

    public PromiseAdapter(Context context) {
        this.context = context;
        promiseBeanList = new ArrayList<>();
    }

    public void setPromiseBeanList(int position,List<PromiseBean> data) {
        this.promiseBeanList = data;
        notifyItemInserted(position);//通知演示插入动画
        notifyItemRangeChanged(position,promiseBeanList.size()-position);//通知数据与界面重新绑定
    }

    public void setPromiseBeanList(List<PromiseBean> data) {
        this.promiseBeanList = data;
        notifyDataSetChanged();
    }


    public void setMoneyFillListener(OnMoneyFillListener moneyFillListener) {
        this.moneyFillListener = moneyFillListener;
    }

    public void setDateFillListener(OnDateFillListener dateFillListener) {
        this.dateFillListener = dateFillListener;
    }

    public void setDescriptionFillListener(OnDescriptionFillListener descriptionFillListener) {
        this.descriptionFillListener = descriptionFillListener;
    }

    public void setRemarksFillListener(OnRemarksFillListener remarksFillListener) {
        this.remarksFillListener = remarksFillListener;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public PromiseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_item_view,parent,false);
        return new PromiseHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(final PromiseHolder holder, final int position) {
        holder.et_money.setTag(position);
        holder.et_date.setTag(position);
        holder.et_description.setTag(position);
        holder.et_remarks.setTag(position);


        holder.et_money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if ((int)holder.et_money.getTag() == position) {//设置tag解决错乱问题
                    moneyFillListener.onMoneyFill(position, editable.toString());
                }
            }
        });

        holder.et_date.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if ((int)holder.et_date.getTag() == position) {//设置tag解决错乱问题
                    dateFillListener.onDateFill(position, editable.toString());
                }
            }
        });

        holder.et_description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if ((int)holder.et_description.getTag() == position) {//设置tag解决错乱问题
                    descriptionFillListener.onDescriptionFill(position, editable.toString());
                }
            }
        });

        holder.et_remarks.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if ((int)holder.et_remarks.getTag() == position) {//设置tag解决错乱问题
                    remarksFillListener.onRemarksFill(position, editable.toString());
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return promiseBeanList == null ? 0 : promiseBeanList.size();
    }

    class PromiseHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final EditText et_money;
        private final EditText et_date;
        private final EditText et_description;
        private final EditText et_remarks;
        private OnItemClickListener onItemClickListener;

        public PromiseHolder(View itemView,OnItemClickListener itemClickListener) {
            super(itemView);
            this.onItemClickListener = itemClickListener;
            et_money = itemView.findViewById(R.id.et_money);
            et_date = itemView.findViewById(R.id.et_date);
            et_description = itemView.findViewById(R.id.et_description);
            et_remarks = itemView.findViewById(R.id.et_remarks);
            ImageView iv_next = itemView.findViewById(R.id.iv_next);
            ImageView iv_del = itemView.findViewById(R.id.iv_del);
            iv_next.setOnClickListener(this);
            iv_del.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.iv_del:
                    delPromise(view);
                    break;
                case R.id.iv_next:
                    doNext();
                    break;
            }
        }

        private void delPromise(View view) {
            onItemClickListener.onItemClick(view, getLayoutPosition());
        }


        private void doNext() {

        }
    }
}
