package com.example.experiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class infoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //获取信息
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String name=bundle.getString("name");
        String sex=bundle.getString("sex1");
        String site=bundle.getString("site");
        TextView tv_name=(TextView) findViewById(R.id.reg_username);
        TextView tv_sex=(TextView) findViewById(R.id.reg_man);
        TextView tv_site=(TextView) findViewById(R.id.reg_province);
        tv_name.setText(name);
        tv_sex.setText(sex);
        tv_site.setText(site);
    }
}