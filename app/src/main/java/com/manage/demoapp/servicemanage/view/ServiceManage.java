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
import com.manage.demoapp.servicemanage.model.ServiceConstants;

import java.util.ArrayList;
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
                    return Arrays.asList("救护", "精神慰藉", "第三方转介服务", "老年人健康管理");
                case 1:
                    return Arrays.asList("助洁", "助医", "助餐", "助浴", "助行", "助乐", "助急", "代办");
                default:
                    return new ArrayList<>();
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
    private LinkagePicker linkagePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_manage);
        ButterKnife.bind(this);
        picker = new OptionPicker(mContext, itemOptions);
        linkagePicker = new LinkagePicker(mContext, dataProvider);
        serviceAdapter = new ServiceAdapter(ServiceConstants.rescue(), mContext);
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

                linkagePicker.setOnStringPickListener(new LinkagePicker.OnStringPickListener() {
                    @Override
                    public void onPicked(String first, String second, String third) {
                        switch (second) {
                            case "救护":
                                serviceAdapter.setList(ServiceConstants.rescue());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "精神慰藉":
                                serviceAdapter.setList(ServiceConstants.spiritualConsolation());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "第三方转介服务":
                                serviceAdapter.setList(ServiceConstants.thirdPartyService());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "老年人健康管理":
                                serviceAdapter.setList(ServiceConstants.healthManage());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "助洁":
                                serviceAdapter.setList(ServiceConstants.clean());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "助医":
                                serviceAdapter.setList(ServiceConstants.medical());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "助餐":
                                serviceAdapter.setList(ServiceConstants.food());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "助浴":
                                serviceAdapter.setList(ServiceConstants.shower());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "助行":
                                serviceAdapter.setList(ServiceConstants.walk());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "助乐":
                                serviceAdapter.setList(ServiceConstants.entertainment());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "助急":
                                serviceAdapter.setList(ServiceConstants.emergency());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                            case "代办":
                                serviceAdapter.setList(ServiceConstants.agent());
                                serviceAdapter.notifyDataSetChanged();
                                break;
                        }
                    }
                });
                linkagePicker.show();
            }
        });
    }
}
