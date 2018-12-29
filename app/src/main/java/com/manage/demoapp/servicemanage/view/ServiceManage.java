package com.manage.demoapp.servicemanage.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.LinkagePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.manage.demoapp.R;
import com.manage.demoapp.helper.PickerHelper;
import com.manage.demoapp.servicemanage.model.PensionService;
import com.manage.demoapp.servicemanage.model.ServiceAdapter;
import com.manage.demoapp.servicemanage.model.ServiceConstants;

public class ServiceManage extends AppCompatActivity {
    @BindView(R.id.serviceManage_back)
    ImageView back;
    @BindView(R.id.serviceManage_list)
    ListView listView;
    @BindView(R.id.serviceManage_type)
    ImageView category;
    private ServiceAdapter serviceAdapter;
    @BindView(R.id.serviceManage_new)
    BootstrapButton add;
    private String[] itemOptions = {"编辑", "删除"};


    private Activity mContext = ServiceManage.this;
    private OptionPicker picker;
    private LinkagePicker linkagePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_manage);
        ButterKnife.bind(this);
        picker = new OptionPicker(mContext, itemOptions);
        linkagePicker = new LinkagePicker(mContext, ServiceConstants.dataProvider);
        serviceAdapter = new ServiceAdapter(ServiceConstants.rescue(), mContext);

        listView.setAdapter(serviceAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> PickerHelper.show(picker, (position1, option) -> {
            switch (option) {
                case "编辑":
                    PensionService service = serviceAdapter.getItem(position);
                    Intent intent = new Intent(ServiceManage.this, NewService.class);
                    intent.putExtra("service", service);
                    startActivity(intent);
                    break;
                case "删除":
                    Toast.makeText(ServiceManage.this, "删除成功", Toast.LENGTH_LONG).show();
                    break;
            }


        }));

        bindEvents();
    }

    private void bindEvents() {
        back.setOnClickListener(v -> finish());
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
        add.setOnClickListener(v -> startActivity(new Intent(mContext, NewService.class)));
        category.setOnClickListener(v -> linkagePicker.show());
    }
}
