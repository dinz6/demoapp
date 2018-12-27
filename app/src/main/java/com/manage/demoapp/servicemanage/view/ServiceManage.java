package com.manage.demoapp.servicemanage.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.OptionPicker;
import com.manage.demoapp.R;
import com.manage.demoapp.helper.PickerHelper;
import com.manage.demoapp.workordermanage.model.OrderAdapter;

public class ServiceManage extends AppCompatActivity {
    @BindView(R.id.serviceManage_back)
    ImageView back;
    @BindView(R.id.serviceManage_list)
    ListView listView;
    OrderAdapter orderAdapter;
    private String[] options = {"编辑"};
    private Activity mContext = ServiceManage.this;
    private OptionPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_manage);
        ButterKnife.bind(this);
        picker = new OptionPicker(mContext, options);
        orderAdapter = new OrderAdapter(null, mContext);
        listView.setAdapter(orderAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PickerHelper.show(picker, new PickerHelper.CallBack() {
                    @Override
                    public void onPicked(int position, String option) {

                    }
                });
            }
        });
    }
}
