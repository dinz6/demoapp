package com.manage.demoapp.organizationmanage.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.manage.demoapp.App;
import com.manage.demoapp.R;
import com.manage.demoapp.organizationmanage.model.Organization;
import com.manage.demoapp.organizationmanage.model.OrganizationBuilder;
import com.manage.demoapp.organizationmanage.model.enums.OrganizationType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrganizationAddActivity extends AppCompatActivity implements PictureAdapter.onAddPicClickListener{
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.org_id)
    TextView org_id;
    @BindView(R.id.org_name)
    EditText org_name;
    @BindView(R.id.org_description)
    EditText org_description;
    @BindView(R.id.organization_type)
    TextView organization_type;
    @BindView(R.id.price)
    EditText price;
    @BindView(R.id.organization_beds)
    EditText organization_beds;
    @BindView(R.id.organization_occupancies)
    EditText organization_occupancies;

    @BindView(R.id.organization_manager)
    EditText organization_manager;
    @BindView(R.id.organization_phone)
    EditText organization_phone;
    @BindView(R.id.org_address)
    EditText org_address;
    @BindView(R.id.org_stars)
    RatingBar org_stars;
    @BindView(R.id.grade_result)
    EditText grade_result;
    @BindView(R.id.org_pic)
    RecyclerView recyclerView;
    @BindView(R.id.btn_save)
    BootstrapButton add;
    List<LocalMedia> mediaList = new ArrayList<>();
    PictureAdapter adapter;

    int stars;
    private Organization org;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_edit);
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setTitle("新增组织机构");
        add.setText("保存");
        org = OrganizationBuilder.builder().setType(OrganizationType.WORK).build();
        org_id.setText(org.getId());
        organization_type.setText(org.getType() == null ? "" : org.getType().getValue());
        FullyGridLayoutManager layoutManager = new FullyGridLayoutManager(this, 1, FullyGridLayoutManager.HORIZONTAL, false);
        adapter = new PictureAdapter(mediaList, this, R.drawable.addimg_1x, this, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        org_stars.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> stars = (int) rating);
    }

    @OnClick(R.id.btn_save)
    public void save(){
        org.setName(org_name.getText().toString());
        org.setDescription(org_description.getText().toString());
        org.setPrice(Double.parseDouble(price.getText().toString()));
        org.setNumBeds(Integer.parseInt(organization_beds.getText().toString()));
        org.setNumOccupancies(Integer.parseInt(organization_occupancies.getText().toString()));
        org.setManager(organization_manager.getText().toString());
        org.setContactNumber(organization_phone.getText().toString());
        org.setAddress(org_address.getText().toString());
        org.setAssessmentStars(stars);
        org.setAssessmentResult(grade_result.getText().toString());
        org.setPicList(mediaList);

        App.dataMode.save(org);
        finish();
    }
    @Override
    public void onAddPicClick() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(OrganizationActivity.MAX_SELECT_NUM)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewVideo(false)// 是否可预览视频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    mediaList.addAll(selectList);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
