package com.example.administrator.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText junzhi1,junzhi2,junzhi3,junzhi4,junzhi5,junzhi6,junzhi7;
    private EditText fangcha;
    private TextView kaishi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        junzhi1  = findViewById(R.id.junzhi1);
        junzhi2  = findViewById(R.id.junzhi2);
        junzhi3  = findViewById(R.id.junzhi3);
        junzhi4  = findViewById(R.id.junzhi4);
        junzhi5  = findViewById(R.id.junzhi5);
        junzhi6  = findViewById(R.id.junzhi6);
        junzhi7  = findViewById(R.id.junzhi7);
        fangcha = findViewById(R.id.fangcha);
        kaishi = findViewById(R.id.start);

        kaishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random();
            }
        });
        Permission.fuckPermission(this);
    }

    private void random() {
        java.util.Random random = new java.util.Random();

        float v = Float.parseFloat(fangcha.getText().toString());
        v = 0.8f;


        float[] us = new float[7];
        us[0] = Float.parseFloat(junzhi1.getText().toString());
        us[1] = Float.parseFloat(junzhi2.getText().toString());
        us[2] = Float.parseFloat(junzhi3.getText().toString());
        us[3] = Float.parseFloat(junzhi4.getText().toString());
        us[4] = Float.parseFloat(junzhi5.getText().toString());
        us[5] = Float.parseFloat(junzhi6.getText().toString());
        us[6] = Float.parseFloat(junzhi7.getText().toString());


        double[][] score = new double[7][30];

        for (int j =0; j < 7; j++) {
            for (int i = 0; i < 30; i++) {
//                double y = (v * random.nextGaussian() + us[j]);
                double y = getRadom(v,us[j]);
                score[j][i] = y;
            }
        }
        try {
            ExcelUtil.writeExcel(this,score,"绩效工时");

        } catch (Exception e) {

        }
    }

    private double getRadom(float v,float score) {
        java.util.Random random = new java.util.Random();
        double x = (v * random.nextGaussian() + score);
        if (x >= 5 && x <= 8) {
            return x;
        } else {
            return getRadom(v,score);
        }
    }


}
