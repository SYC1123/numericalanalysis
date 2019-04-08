
package com.example.numericalanalysis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=findViewById(R.id.textView);
        final EditText editText=findViewById(R.id.editText);
        Button button=findViewById(R.id.button);
        Button button1=findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] x= {0,10,20,30,40,50,60,70,80,90,100,110,120};
                double[] y= {5,1,7.5,3,4.5,8.8,15.5,6.5,-5,-10,-2,4.5,7};
                //double[] x = { -1, 1, 2 };
                //double[] y = { 3, 1, -1 };
                double[][] a = new double[x.length][x.length];
                for (int m = 0; m < x.length; m++) {
                    a[m][0] = y[m];
                }
                for (int j = 1; j < x.length; j++) {
                    for (int i = j; i < x.length; i++) {
                        a[i][j] = (a[i - 1][j - 1] - a[i][j - 1]) / (x[i - j] - x[i]);
                    }
                }
                double p=Double.parseDouble(editText.getText().toString());
                double real_result=0;
                for(int i=1;i<x.length;i++) {//次数
                    double sum=1;
                    for(int j=0;j<i;j++) {
                        sum=sum*(p-x[j]);
                    }
                    sum=sum*a[i][i];
                    real_result=real_result+sum;
                }
                real_result=real_result+a[0][0];
                textView.setText(real_result+"");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

}
