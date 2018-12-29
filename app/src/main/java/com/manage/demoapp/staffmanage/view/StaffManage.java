package com.manage.demoapp.staffmanage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.OptionPicker;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.manage.demoapp.R;
import com.manage.demoapp.helper.PickerHelper;
import com.manage.demoapp.staffmanage.model.OrgAdapter;
import com.manage.demoapp.staffmanage.model.OrgConstants;
import com.manage.demoapp.staffmanage.model.StaffConstants;
import com.manage.demoapp.staffmanage.model.StaffDetailAdapter;
import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StaffManage extends AppCompatActivity {
    @BindView(R.id.staffManage_back)
    ImageView back;
    @BindView(R.id.staffManage_list)
    ListView listView;
    @BindView(R.id.staffManage_type)
    NiceSpinner niceSpinner;
    @BindView(R.id.staffManage_new)
    BootstrapButton add;

    private boolean flag = true;

    private OrgAdapter orgAdapter;
    private StaffDetailAdapter staffDetailAdapter;
    private OptionPicker picker;
    private String[] itemOptions = {"编辑", "删除"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_manage);
        ButterKnife.bind(this);

        orgAdapter = new OrgAdapter(OrgConstants.orgs(), this);
        listView.setAdapter(orgAdapter);
        List<String> dataset = new LinkedList<>(Arrays.asList("机构名称", "机构编码"));
        niceSpinner.attachDataSource(dataset);
        picker = new OptionPicker(this, itemOptions);

        back.setOnClickListener(v -> onBackPressed());

        add.setOnClickListener(v -> {
            Intent intent = new Intent(StaffManage.this, CreateStaff.class);
            startActivity(intent);
        });

        rebind(listView);
    }

    @Override
    public void onBackPressed() {
        if (flag) {
            finish();
        } else {
            listView.setAdapter(orgAdapter);
            add.setVisibility(View.INVISIBLE);
            flag = true;
            rebind(listView);
            List<String> dataset = new LinkedList<>(Arrays.asList("机构名称", "机构编码"));
            niceSpinner.attachDataSource(dataset);
            add.setVisibility(View.INVISIBLE);
        }
    }

    private void rebind(final ListView listView) {
        if (flag) {
            add.setVisibility(View.INVISIBLE);
            listView.setOnItemClickListener((parent, view, position, id) -> {
                staffDetailAdapter = new StaffDetailAdapter(StaffConstants.staffDetails(), StaffManage.this);
                flag = false;
                listView.setAdapter(staffDetailAdapter);
                rebind(listView);
                List<String> dataset = new LinkedList<>(Arrays.asList("姓名", "工号"));
                niceSpinner.attachDataSource(dataset);

            });

        } else {
            add.setVisibility(View.VISIBLE);
            listView.setOnItemClickListener((parent, view, position, id) -> PickerHelper.show(picker, (position1, option) -> {
                switch (option) {
                    case "编辑":
                        Intent intent = new Intent(StaffManage.this, CreateStaff.class);
                        intent.putExtra("staff",staffDetailAdapter.getItem(position));
                        startActivity(intent);
                        break;
                    case "删除":
                        Toast.makeText(StaffManage.this,"删除成功",Toast.LENGTH_LONG).show();
                }
            }));
        }
    }
}
