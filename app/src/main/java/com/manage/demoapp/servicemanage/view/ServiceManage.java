package com.manage.demoapp.servicemanage.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.LinkagePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import com.manage.demoapp.R;
import com.manage.demoapp.helper.PickerHelper;
import com.manage.demoapp.servicemanage.model.ServiceAdapter;

import java.util.Arrays;
import java.util.List;

public class ServiceManage extends AppCompatActivity {
    @BindView(R.id.serviceManage_back)
    ImageView back;
    @BindView(R.id.serviceManage_list)
    ListView listView;
    @BindView(R.id.serviceManage_type)
    ImageView category;
    ServiceAdapter serviceAdapter;
    private String[] itemOptions = {"编辑"};


    final LinkagePicker.DataProvider dataProvider = new LinkagePicker.DataProvider() {
        @NonNull
        @Override
        public List<String> provideFirstData() {
            return Arrays.asList("线上", "线下");
        }

        @NonNull
        @Override
        public List<String> provideSecondData(int firstIndex) {
            switch (firstIndex) {
                case 0:
                    return Arrays.asList("1", "2");
                case 1:
                    return Arrays.asList("3", "4");
                default:
                    return Arrays.asList("5", "6");
            }
        }

        @Nullable
        @Override
        public List<String> provideThirdData(int firstIndex, int secondIndex) {
            return null;
        }

        @Override
        public boolean isOnlyTwo() {
            return true;
        }
    };
    private Activity mContext = ServiceManage.this;
    private OptionPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_manage);
        ButterKnife.bind(this);
        picker = new OptionPicker(mContext, itemOptions);
        serviceAdapter = new ServiceAdapter(mContext);
        listView.setAdapter(serviceAdapter);
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

        bindEvents();
    }

    private void bindEvents() {

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkagePicker linkagePicker = new LinkagePicker(mContext, dataProvider);
                linkagePicker.show();
            }
        });
    }
}
