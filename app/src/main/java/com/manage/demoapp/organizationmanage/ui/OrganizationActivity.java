package com.manage.demoapp.organizationmanage.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.manage.demoapp.App;
import com.manage.demoapp.R;
import com.manage.demoapp.organizationmanage.model.DataMode;
import com.manage.demoapp.organizationmanage.model.Organization;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrganizationActivity extends AppCompatActivity implements OrganizationAdapter.PickPictureListener {
    public static final int MAX_SELECT_NUM = 5;
    public static final String ORG_NAME = "orgName";
    public static final int REQUEST_CODE = 100;
    public static final String INDEX = "index";
    public static final String ORG = "org";
    SearchView searchView;
    @BindView(R.id.organization_content)
    RecyclerView listView;

    List<Organization> orgs = new ArrayList<>();
    OrganizationAdapter adapter;
    private int pickPicIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_organization);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
        initData();
    }

    private void initData() {
        adapter = new OrganizationAdapter(orgs,this,this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);
        listView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_view, menu);
        //找到searchView
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getString(R.string.organization_hint));
        ImageView searchIcon = searchView.findViewById(android.support.v7.appcompat.R.id.search_button);
        searchIcon.setImageResource(R.drawable.ic_search_white);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<Organization> byOrgNameLike = App.dataMode.findByOrgNameLike(s);
                orgs.clear();
                orgs.addAll(byOrgNameLike);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        orgs.clear();
        orgs.addAll(App.dataMode.findAll());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == pickPicIndex){
            // 图片、视频、音频选择结果回调
            List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
            Organization organization = orgs.get(pickPicIndex);
            organization.setPicList(selectList);
            Toast.makeText(this,"上传成功",Toast.LENGTH_SHORT).show();
        }else {
            if (data == null) return;
            String grade = data.getStringExtra(OrganizationGradeActivity.GRADE_RESULT);
            int stars = data.getIntExtra(OrganizationGradeActivity.STARS,0);
            int index = data.getIntExtra(INDEX,0);
            Organization organization = orgs.get(index);
            organization.setAssessmentResult(grade);
            organization.setAssessmentStars(stars);
            Toast.makeText(this,"评分成功",Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }


    }

    @Override
    public void doPicker(int index) {
        pickPicIndex = index;
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(MAX_SELECT_NUM)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewVideo(false)// 是否可预览视频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .forResult(index);//结果回调onActivityResult code
    }

    @Override
    public void doDelete(int index) {
        new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("确认要删除该机构吗？")
                .setNegativeButton("取消",null)
                .setPositiveButton("删除", (dialog, which) -> {
                    orgs.remove(index);
                    adapter.notifyDataSetChanged();
                }).show();
    }

    @Override
    public void doEdit(int index) {
        Intent intent = new Intent(this, OrganizationEditActivity.class);
        intent.putExtra(ORG,orgs.get(index));
        startActivity(intent);
    }

    @Override
    public void doGrade(int index) {
        Intent intent = new Intent(this, OrganizationGradeActivity.class);
        intent.putExtra(ORG_NAME,orgs.get(index).getName());
        intent.putExtra(INDEX,index);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void doItemViewClick(int position) {
        Intent intent = new Intent(this, OrganizationDetailActivity.class);
        intent.putExtra(ORG,orgs.get(position));
        startActivity(intent);
    }
    @OnClick(R.id.add)
    public void add(){
        Intent intent = new Intent(this, OrganizationAddActivity.class);
        startActivity(intent);
    }
}
