package com.manage.demoapp.staffmanage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.manage.demoapp.R;
import com.manage.demoapp.staffmanage.model.OrgAdapter;
import com.manage.demoapp.staffmanage.model.OrgConstants;
import com.manage.demoapp.staffmanage.model.SimpleStaffAdapter;
import com.manage.demoapp.staffmanage.model.StaffConstants;
import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SelectOrg extends AppCompatActivity {
    @BindView(R.id.selectOrg_type)
    NiceSpinner niceSpinner;

    private OrgAdapter orgAdapter;
    private SimpleStaffAdapter simpleStaffAdapter;
    @BindView(R.id.selectOrg_list)
    ListView listView;
    @BindView(R.id.selectOrder_back)
    ImageView back;

    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_org);
        ButterKnife.bind(this);


        orgAdapter = new OrgAdapter(OrgConstants.orgs(), this);

        listView.setAdapter(orgAdapter);
        rebind(listView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    finish();
                } else {
                    listView.setAdapter(orgAdapter);
                    flag = true;
                    rebind(listView);
                    List<String> dataset = new LinkedList<>(Arrays.asList("机构名称", "机构编码"));
                    niceSpinner.attachDataSource(dataset);
                }
            }
        });
    }

    private void rebind(final ListView listView) {
        if (flag) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    simpleStaffAdapter = new SimpleStaffAdapter(StaffConstants.simpleStaff(), SelectOrg.this);
                    flag = false;
                    listView.setAdapter(simpleStaffAdapter);
                    rebind(listView);
                    List<String> dataset = new LinkedList<>(Arrays.asList("姓名", "工号"));
                    niceSpinner.attachDataSource(dataset);
                }
            });

        } else {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
        }
    }
}
