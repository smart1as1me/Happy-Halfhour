package com.example.experiment;

import static com.lljjcoder.style.cityjd.JDCityConfig.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.cityjd.JDCityConfig;
import com.lljjcoder.style.cityjd.JDCityPicker;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.lljjcoder.style.citypickerview.CityPickerView;

public class regActivity extends AppCompatActivity {
    CityPickerView mpicker = new CityPickerView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);
        showCityPicker();}
        public void showCityPicker(){
            final CityPickerView cityPicker=new CityPickerView();
            cityPicker.init(this);
            CityConfig cityConfig = new CityConfig.Builder()
                    .province("江西省")//默认显示的省份
                    .city("赣州市")//默认显示省份下面的城市
                    .district("南康区")//默认显示省市下面的区县数据
                    .build();
            cityPicker.setConfig(cityConfig);
            final TextView editCity=findViewById(R.id.reg_province);
            //点击监听
            editCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cityPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        //点击确定
                        public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                            Toast.makeText(regActivity.this,province+" - "+city+" - "+district,Toast.LENGTH_LONG).show();
                            editCity.setText(province+" - "+city+" - "+district);
                        }
                        @Override
                        //点击取消
                        public void onCancel() {
                        }
                    });
                    cityPicker.showCityPicker();
                }
            });
        }
}
