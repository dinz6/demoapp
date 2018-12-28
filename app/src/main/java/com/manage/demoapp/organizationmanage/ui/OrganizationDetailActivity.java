package com.manage.demoapp.organizationmanage.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.luck.picture.lib.entity.LocalMedia;
import com.manage.demoapp.R;
import com.manage.demoapp.organizationmanage.model.Organization;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrganizationDetailActivity extends AppCompatActivity {
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.org_id)
    TextView org_id;
    @BindView(R.id.org_description)
    TextView org_description;
    @BindView(R.id.organization_type)
    TextView organization_type;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.organization_beds)
    TextView organization_beds;
    @BindView(R.id.organization_occupancies)
    TextView organization_occupancies;
    @BindView(R.id.organization_idle)
    TextView organization_idle;
    @BindView(R.id.organization_manager)
    TextView organization_manager;
    @BindView(R.id.organization_phone)
    TextView organization_phone;
    @BindView(R.id.org_address)
    TextView org_address;
    @BindView(R.id.org_stars)
    RatingBar org_stars;
    @BindView(R.id.grade_result)
    TextView grade_result;
    @BindView(R.id.org_pic)
    RecyclerView recyclerView;
    List<LocalMedia> mediaList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_detail);
        ButterKnife.bind(this);

        Organization org = getIntent().getParcelableExtra(OrganizationActivity.ORG);
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setTitle(org.getName());

        org_id.setText(org.getId());
        org_description.setText(org.getDescription());
        organization_type.setText(org.getType() == null ? "" : org.getType().getValue());
        price.setText(String.valueOf(org.getPrice()));

        organization_beds.setText(String.valueOf(org.getNumBeds()));
        organization_occupancies.setText(String.valueOf(org.getNumOccupancies()));
        organization_idle.setText(String.valueOf(org.getIdleBeds()));
        organization_manager.setText(org.getManager());
        organization_phone.setText(org.getContactNumber());
        org_address.setText(org.getAddress());
        org_stars.setRating(org.getAssessmentStars());
        grade_result.setText(org.getAssessmentResult());

        FullyGridLayoutManager layoutManager = new FullyGridLayoutManager(this, 1, FullyGridLayoutManager.HORIZONTAL, false);
        mediaList.addAll(org.getPicList());
        PictureAdapter adapter = new PictureAdapter(mediaList, this, R.drawable.ic_no_pic, null, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
