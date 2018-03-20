package com.example.luogj.testdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
    private DelObjectItemListener delPromiseItemListener;

    public PromiseAdapter(Context context) {
        this.context = context;
        promiseBeanList = new ArrayList<>();
    }

    /**
     * 设置适配器数据
     * @param data
     */
    public void setPromiseBeanList(List<PromiseBean> data) {
        this.promiseBeanList = data;
        if (promiseBeanList.size() == 1){
            notifyDataSetChanged();
        }else {
            notifyItemInserted(promiseBeanList.size() - 1);
        }
    }

    /**
     * 设置金额编辑框监听器
     * @param moneyFillListener
     */
    public void setMoneyFillListener(OnMoneyFillListener moneyFillListener) {
        this.moneyFillListener = moneyFillListener;
    }

    /**
     * 设置日期编辑框监听器
     * @param dateFillListener
     */
    public void setDateFillListener(OnDateFillListener dateFillListener) {
        this.dateFillListener = dateFillListener;
    }

    /**
     * 设置描述编辑框监听器
     * @param descriptionFillListener
     */
    public void setDescriptionFillListener(OnDescriptionFillListener descriptionFillListener) {
        this.descriptionFillListener = descriptionFillListener;
    }

    /**
     * 设置备注编辑框监听器
     * @param remarksFillListener
     */
    public void setRemarksFillListener(OnRemarksFillListener remarksFillListener) {
        this.remarksFillListener = remarksFillListener;
    }

    /**
     * 设置删除按钮监听器
     * @param listener
     */
    public void setDelPromiseItemListener(DelObjectItemListener listener){
        this.delPromiseItemListener = listener;
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public PromiseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_item_view,parent,false);
        return new PromiseHolder(view);
    }

    @Override
    public void onBindViewHolder(final PromiseHolder holder, final int position) {
        holder.et_money.setTag(position);
        holder.et_date.setTag(position);
        holder.et_description.setTag(position);
        holder.et_remarks.setTag(position);

        final PromiseBean promiseBean = promiseBeanList.get(position);

        holder.et_money.setText("");
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

        holder.et_date.setText("");
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

        holder.et_description.setText("");
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

        holder.et_remarks.setText("");
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

        //viewHolder中的删除控件
        holder.iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delPromiseItemListener != null){
                    promiseBeanList.remove(promiseBean);
                    delPromiseItemListener.delObjectItem(promiseBean,position);
                    notifyItemRemoved(position);
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
        private final ImageView iv_del;

        public PromiseHolder(View itemView) {
            super(itemView);
            et_money = itemView.findViewById(R.id.et_money);
            et_date = itemView.findViewById(R.id.et_date);
            et_description = itemView.findViewById(R.id.et_description);
            et_remarks = itemView.findViewById(R.id.et_remarks);
            ImageView iv_next = itemView.findViewById(R.id.iv_next);
            iv_del = itemView.findViewById(R.id.iv_del);
            iv_next.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.iv_next:
                    doNext();
                    break;
            }
        }

        private void doNext() {

        }
    }
}
