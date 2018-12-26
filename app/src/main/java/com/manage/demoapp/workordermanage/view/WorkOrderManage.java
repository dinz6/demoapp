package com.manage.demoapp.workordermanage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.manage.myapplication.R;

public class WorkOrderManage extends AppCompatActivity {
    @BindView(R.id.orderManage_list)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_manage);
        ButterKnife.bind(this);
        String[] strArr = new String[]{"yuhongxing", "sunshengling",
                "chenyanzhang", "huangchao", "liupengfei", "sunshengling",
                "chenyanzhang", "huangchao", "liupengfei", "sunshengling",
                "chenyanzhang", "huangchao", "liupengfei", "sunshengling",
                "chenyanzhang", "huangchao", "liupengfei"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, strArr);
        listView.setAdapter(adapter);
    }
}
