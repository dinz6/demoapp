package com.manage.demoapp.workordermanage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.manage.demoapp.R;
import com.manage.demoapp.workordermanage.model.OrderAdapter;
import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WorkOrderManage extends AppCompatActivity {
    @BindView(R.id.orderManage_searchType)
    NiceSpinner niceSpinner;
    @BindView(R.id.orderManage_list)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_manage);
        ButterKnife.bind(this);
        List<String> dataset = new LinkedList<>(Arrays.asList("工单号码", "身份证号", "居民姓名", "手机号码"));
        niceSpinner.attachDataSource(dataset);
        listView.setAdapter(new OrderAdapter(null, this));
    }
}
