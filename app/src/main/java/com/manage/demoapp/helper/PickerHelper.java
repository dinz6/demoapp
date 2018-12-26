package com.manage.demoapp.helper;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import cn.qqtheme.framework.picker.OptionPicker;

/**
 * Create by peter
 * Date 2018-12-26  21:36
 * Description: 弹窗选择器
 */
public class PickerHelper {
    /**
     * 显示picker
     * @param activity
     * @param options
     * @param callBack
     */
    public static void showPicker(@NonNull Activity activity,String title, String[] options,final CallBack callBack) {
        OptionPicker picker = new OptionPicker(activity, options);
        picker.setTitleText(title);
        picker.setOffset(3);
        picker.setSelectedIndex(0); //默认选中项
        picker.setTextSize(16);
        picker.setCycleDisable(true); //选项不循环滚动
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int position, String option) {
                callBack.onPicked(position,option);
            }
        });
        picker.show();
    }

    public  interface CallBack{
        void onPicked(int position, String option);
    }
}
