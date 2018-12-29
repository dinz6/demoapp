package com.manage.demoapp.servicemanage.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.LinkagePicker;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.beardedhen.androidbootstrap.BootstrapWell;
import com.manage.demoapp.R;
import com.manage.demoapp.servicemanage.model.PensionService;
import com.manage.demoapp.servicemanage.model.ServiceConstants;

public class NewService extends AppCompatActivity {
    @BindView(R.id.newService_type)
    BootstrapWell type;
    @BindView(R.id.newService_typeText)
    TextView typeText;
    @BindView(R.id.newService_back)
    ImageView back;
    @BindView(R.id.newService_title)
    TextView title;
    private LinkagePicker linkagePicker;
    @BindView(R.id.newService_name)
    BootstrapEditText name;

    @BindView(R.id.newService_content)
    BootstrapEditText content;

    @BindView(R.id.newService_fee)
    BootstrapEditText fee;
    @BindView(R.id.newService_save)
    BootstrapButton save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);
        ButterKnife.bind(this);

        linkagePicker = new LinkagePicker(this, ServiceConstants.dataProvider);
        bindEvents();

        Intent intent = getIntent();
        PensionService service = (PensionService) intent.getSerializableExtra("service");
        if (service != null) {
            title.setText("编辑");
            initData(service);
        } else {
            title.setText("新增");
        }
    }

    private void bindEvents() {
        back.setOnClickListener(v -> finish());
        linkagePicker.setOnStringPickListener(new LinkagePicker.OnStringPickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPicked(String first, String second, String third) {
                typeText.setText(first + "-" + second);
            }
        });
        type.setOnClickListener(v -> linkagePicker.show());
        save.setOnClickListener(v -> {
            Toast.makeText(NewService.this, "保存成功", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private void initData(PensionService service) {
        fee.setText(service.getFee());
        content.setText(service.getDetail());
        name.setText(service.getName());
        typeText.setText(service.getType() + "-" + service.getAktType());
    }
}
