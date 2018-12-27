package com.manage.demoapp.servicemanage.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.LinkagePicker;
import com.beardedhen.androidbootstrap.BootstrapWell;
import com.manage.demoapp.R;
import com.manage.demoapp.servicemanage.model.ServiceConstants;

public class NewService extends AppCompatActivity {
    @BindView(R.id.newService_type)
    BootstrapWell type;
    @BindView(R.id.newService_typeText)
    TextView typeText;
    @BindView(R.id.newService_back)
    ImageView back;

    private LinkagePicker linkagePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);
        ButterKnife.bind(this);

        linkagePicker = new LinkagePicker(this, ServiceConstants.dataProvider);
        bindEvents();
    }

    private void bindEvents() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        linkagePicker.setOnStringPickListener(new LinkagePicker.OnStringPickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPicked(String first, String second, String third) {
                typeText.setText(first + "-" + second);
            }
        });
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkagePicker.show();
            }
        });
    }
}
