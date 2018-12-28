package com.manage.demoapp.organizationmanage.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.manage.demoapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrganizationGradeActivity extends AppCompatActivity {
    public static final String GRADE_RESULT = "grade_result";
    public static final String STARS = "stars";
    @BindView(R.id.org_name)
    TextView org_name;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.grade_result)
    EditText editText;
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    int stars = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_grade);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
        String orgName = getIntent().getStringExtra(OrganizationActivity.ORG_NAME);
        org_name.setText(orgName);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            stars = (int) rating;
        });
    }

    @OnClick(R.id.btn_submit)
    public void submit() {
        Intent intent = new Intent();
        intent.putExtra(GRADE_RESULT, editText.getText().toString());
        intent.putExtra(STARS, stars);
        intent.putExtra(OrganizationActivity.INDEX, getIntent().getIntExtra(OrganizationActivity.INDEX, 0));
        setResult(RESULT_OK, intent);
        finish();
    }
}
