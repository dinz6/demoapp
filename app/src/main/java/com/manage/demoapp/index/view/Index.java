package com.manage.demoapp.index.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.manage.demoapp.R;
import com.manage.demoapp.organizationmanage.ui.OrganizationActivity;
import com.manage.demoapp.servicemanage.view.ServiceManage;
import com.manage.demoapp.staffmanage.view.StaffManage;
import com.manage.demoapp.workordermanage.view.WorkOrderManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Index extends AppCompatActivity {
    @BindView(R.id.index_order)
    LinearLayout order;
    @BindView(R.id.index_org)
    LinearLayout org;
    @BindView(R.id.index_staff)
    LinearLayout staff;
    @BindView(R.id.index_service)
    LinearLayout service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this);

        order.setOnClickListener(v -> startActivity(new Intent(Index.this, WorkOrderManage.class)));
        service.setOnClickListener(v -> startActivity(new Intent(Index.this, ServiceManage.class)));

        staff.setOnClickListener(v -> startActivity(new Intent(Index.this, StaffManage.class)));
    }
    @OnClick(R.id.index_org)
    public void orgClick(){
        startActivity(new Intent(this,OrganizationActivity.class));
    }

}
