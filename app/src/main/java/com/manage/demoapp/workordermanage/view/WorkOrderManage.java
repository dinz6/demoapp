package com.manage.demoapp.workordermanage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.manage.demoapp.R;
import com.manage.demoapp.staffmanage.view.SelectOrg;
import com.manage.demoapp.workordermanage.model.Order;
import com.manage.demoapp.workordermanage.model.OrderAdapter;
import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WorkOrderManage extends AppCompatActivity implements OrderManageView {
    @BindView(R.id.orderManage_searchType)
    NiceSpinner niceSpinner;
    @BindView(R.id.orderManage_list)
    ListView listView;
    @BindView(R.id.orderManage_back)
    ImageView back;
    private OrderAdapter orderAdapter;
    @BindView(R.id.orderManage_order)
    BootstrapButton button;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_manage);
        ButterKnife.bind(this);
        List<String> dataset = new LinkedList<>(Arrays.asList("工单号码", "身份证号", "居民姓名", "手机号码"));
        niceSpinner.attachDataSource(dataset);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            AppCompatCheckBox checkBox = view.findViewById(R.id.order_item_checkbox);
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    count++;
                } else {
                    count--;
                }
            });
            checkBox.setChecked(!checkBox.isChecked());

        });
        back.setOnClickListener(v -> finish());
        button.setOnClickListener(v -> {
            if (count > 0)
                startActivity(new Intent(WorkOrderManage.this, SelectOrg.class));
            else
                Toast.makeText(WorkOrderManage.this, "请至少选择一个工单", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onSearchResult(List<Order> result) {
        orderAdapter = new OrderAdapter(result, this);
        listView.setAdapter(orderAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        count = 0;
        orderAdapter = new OrderAdapter(null, this);
        listView.setAdapter(orderAdapter);
    }
}
