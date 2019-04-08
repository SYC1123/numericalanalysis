package com.example.numericalanalysis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setStrokeWidth(10);
        p.setAntiAlias(true);
        //画贝塞尔曲线
        p.reset();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);
        Path path2 = new Path();
        int[] x= {0,10,20,30,40,50,60,70,80,90,100,110,120};
        float[] y= {5,1,7.5f,3,4.5f,8.8f,15.5f,6.5f,-5,-10,-2,4.5f,7};
        float x1=0,y1=0;
        //double[] x = { -1, 1, 2 };
        //double[] y = { 3, 1, -1 };
        float[][] a = new float[x.length][x.length];
        for (int m = 0; m < x.length; m++) {
            a[m][0] = y[m];
        }
        for (int j = 1; j < x.length; j++) {
            for (int i = j; i < x.length; i++) {
                a[i][j] = (a[i - 1][j - 1] - a[i][j - 1]) / (x[i - j] - x[i]);
            }
        }

        for(int p1=1;p1<100;p1++) {
            float real_result = 0;
            for (int i = 1; i < x.length; i++) {//次数
                float sum = 1;
                for (int j = 0; j < i; j++) {
                    sum = sum * (p1 - x[j]);
                }
                sum = sum * a[i][i];
                real_result = real_result + sum;
            }
            real_result = real_result + a[0][0];
            path2.quadTo(x1*10, (int)y1*10+900, p1*10, (int)real_result*10+900); //设置贝塞尔曲线的控制点坐标和终点坐标
            x1=p1;
            y1=real_result;
        }
        canvas.drawPath(path2, p);//画出贝塞尔曲线
    }

}
