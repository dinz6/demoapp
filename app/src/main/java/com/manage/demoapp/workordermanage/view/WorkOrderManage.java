package com.manage.demoapp.workordermanage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_manage);
        ButterKnife.bind(this);
        List<String> dataset = new LinkedList<>(Arrays.asList("工单号码", "身份证号", "居民姓名", "手机号码"));
        niceSpinner.attachDataSource(dataset);
        orderAdapter = new OrderAdapter(null, this);
        listView.setAdapter(orderAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AppCompatCheckBox checkBox =view.findViewById(R.id.order_item_checkbox);
                checkBox.setChecked(!checkBox.isChecked());
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkOrderManage.this, SelectOrg.class));
            }
        });
    }

    @Override
    public void onSearchResult(List<Order> result) {
        orderAdapter = new OrderAdapter(result, this);
        listView.setAdapter(orderAdapter);
    }

    private View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }

    }
}
