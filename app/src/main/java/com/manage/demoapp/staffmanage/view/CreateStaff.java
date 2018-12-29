package com.manage.demoapp.staffmanage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.manage.demoapp.R;
import com.manage.demoapp.staffmanage.model.StaffDetail;

public class CreateStaff extends AppCompatActivity {

    @BindView(R.id.createStaff_title)
    TextView title;
    @BindView(R.id.createStaff_name)
    EditText name;
    @BindView(R.id.createStaff_remark)
    EditText remark;
    @BindView(R.id.createStaff_phone)
    EditText phone;
    @BindView(R.id.createStaff_gender_male)
    RadioButton male;
    @BindView(R.id.createStaff_gender_female)
    RadioButton female;
    @BindView(R.id.createStaff_save)
    BootstrapButton save;
    @BindView(R.id.createStaff_back)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_staff);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent.getSerializableExtra("staff") != null) {
            title.setText("编辑人员");
            StaffDetail staffDetail = (StaffDetail) intent.getSerializableExtra("staff");
            initData(staffDetail);
        } else {
            title.setText("新增人员");
        }

        save.setOnClickListener(v -> {
            Toast.makeText(CreateStaff.this, "保存成功!", Toast.LENGTH_LONG).show();
            finish();
        });

        back.setOnClickListener(v -> finish());
    }

    private void initData(StaffDetail staffDetail) {
        name.setText(staffDetail.getName());
        phone.setText(staffDetail.getPhone());
        remark.setText(staffDetail.getRemark());
        if (staffDetail.getGender().equals("男")) {
            male.setChecked(true);
        } else {
            female.setChecked(true);
        }
    }
}
