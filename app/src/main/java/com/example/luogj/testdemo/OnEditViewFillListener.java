package com.example.luogj.testdemo;

/**
 * 这个接口是用于recyclerView中的条目中有编辑框控件，获取编辑框中输入的内容监听
 * Created by luogj on 2018/3/20.
 */

public interface OnEditViewFillListener {
    /**
     * 编辑框监听器
     * @param position recyclerView中对应的位置
     * @param string 编辑框中输入的内容
     * @param flag  如果条目中有多个编辑框，以此来区别是哪个编辑框的标识
     */
    void onEditViewFill(int position,String string,String flag);
}
