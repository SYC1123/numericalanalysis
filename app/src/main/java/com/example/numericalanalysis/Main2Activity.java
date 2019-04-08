package com.example.numericalanalysis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    private void init() {
        LinearLayout layout=(LinearLayout) findViewById(R.id.root);
        final DrawView view=new DrawView(this);
        view.setMinimumHeight(layout.getLayoutParams().width);
        view.setMinimumWidth(layout.getLayoutParams().height/2);
        //通知view组件重绘
        view.invalidate();
        layout.addView(view);
    }
}
