package com.puan.looptestdev.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by kiros on 2019/2/11.
 */

    public class MarkerShowCmpt extends View {

        private Canvas myCanvas;
        private Paint myPaint=new Paint();
        private Paint mPaint=new Paint();
        private int centerX, centerY;
        private String text = "";
        private float value = 100f;

        public MarkerShowCmpt(Context context) {
            super(context);
            setPaintDefaultStyle();
        }

        public MarkerShowCmpt(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            setPaintDefaultStyle();
        }

        public MarkerShowCmpt(Context context, AttributeSet attrs) {
            super(context, attrs);
            setPaintDefaultStyle();
        }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeigt = MeasureSpec.getSize(heightMeasureSpec);
        //获取屏幕中心点
        centerX = measureWidth/2;
        centerY = measureHeigt/2;
    }

    @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            super.onDraw(canvas);
            canvas.translate(centerX, centerY);
            this.myCanvas=canvas;
            if (value < 100) {
//                drawAL(centerX, centerY, centerX, (int) (centerY - lenght * 10));
                drawAL(0, 0, 0, (- value * 10));
            } else {
                drawAL(0, 0, 0, - value);
            }
        }

        /**
         * 设置画笔默认样式
         */
        public void setPaintDefaultStyle(){
            myPaint.setAntiAlias(true);
            myPaint.setColor(Color.RED);
            myPaint.setStyle(Paint.Style.STROKE);
            myPaint.setStrokeWidth(10);

            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.RED);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setStrokeWidth(3);
            mPaint.setTextSize(30);
        }


        /**
         * 画圆
         * @param x x坐标
         * @param y	y坐标
         * @param radius	圆的半径
         */
        public void drawCircle(float x,float y,float radius){
            myCanvas.drawCircle(x, y, radius, myPaint);
            invalidate();
        }

        /**
         * 画一条直线
         * @param fromX 起点x坐标
         * @param fromY	起点Y坐标
         * @param toX	终点X坐标
         * @param toY	终点Y坐标
         */
        public void drawLine(float fromX,float fromY,float toX,float toY){
            Path linePath=new Path();
            linePath.moveTo(fromX, fromY);
            linePath.lineTo(toX, toY);
            linePath.close();
            myCanvas.drawPath(linePath, myPaint);
            invalidate();
        }


        /**
         * 画箭头
         * @param sx
         * @param sy
         * @param ex
         * @param ey
         */
        public void drawAL(int sx, int sy, int ex, float ey)
        {
            double H = 16; // 箭头高度
            double L = 7; // 底边的一半
            int x3 = 0;
            int y3 = 0;
            int x4 = 0;
            int y4 = 0;
            double awrad = Math.atan(L / H); // 箭头角度
            Log.d("角度", awrad + "");
            double arraow_len = Math.sqrt(L * L + H * H); // 箭头的长度
            double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
            double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
            double x_3 = ex - arrXY_1[0]; // (x3,y3)是第一端点
            double y_3 = ey - arrXY_1[1];
            double x_4 = ex - arrXY_2[0]; // (x4,y4)是第二端点
            double y_4 = ey - arrXY_2[1];
            Double X3 = new Double(x_3);
            x3 = X3.intValue();
            Double Y3 = new Double(y_3);
            y3 = Y3.intValue();
            Double X4 = new Double(x_4);
            x4 = X4.intValue();
            Double Y4 = new Double(y_4);
            y4 = Y4.intValue();
            // 画线
            myCanvas.drawLine(sx, sy, ex, ey,myPaint);
            Path triangle = new Path();
            triangle.moveTo(ex, ey);
            triangle.lineTo(x3, y3);
            triangle.lineTo(x4, y4);
            triangle.close();
            myCanvas.drawPath(triangle,myPaint);
            if (value < 100) {
                if (!TextUtils.isEmpty(text)) {
                    myCanvas.drawText(text,20, (-value * 10), mPaint);
                }
            } else {
                if (!TextUtils.isEmpty(text)) {
                    myCanvas.drawText(text,20, -value, mPaint);
                }
            }

//            myCanvas.translate(centerX,centerY);
//            myCanvas.rotate(120);
//            myCanvas.drawLine(0, 0, 0, 200, mPaint);
//
//            //绘制五角星图案
//            myCanvas.drawLine(100, 500, 700, 500, mPaint);
//            myCanvas.translate(100,500);
//            myCanvas.rotate(36);
//            myCanvas.drawLine(0, 0, 600, 0, mPaint);
//            myCanvas.translate(600,0);
//            myCanvas.rotate(36);
//            myCanvas.drawLine(0, 0, -600, 0, mPaint);
//            myCanvas.translate(-600, 0);
//            myCanvas.rotate(36);
//            myCanvas.drawLine(0, 0, 600, 0, mPaint);
//            myCanvas.translate(600, 0);
//            myCanvas.rotate(36);
//            myCanvas.drawLine(0, 0, -600, 0, mPaint);

//            Matrix matrix = new Matrix();
//
//            matrix.setTranslate(centerX, centerY); //设置图片的旋转中心，即绕（X,Y）这点进行中心旋转
//            matrix.preRotate(120); //要旋转的角度
//            myCanvas.concat(matrix);
//            myCanvas.setMatrix(matrix);

        }
        // 计算
        public double[] rotateVec(int px, float py, double ang, boolean isChLen, double newLen)
        {
            double mathstr[] = new double[2];
            // 矢量旋转函数，参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度
            double vx = px * Math.cos(ang) - py * Math.sin(ang);
            double vy = px * Math.sin(ang) + py * Math.cos(ang);
            if (isChLen) {
                double d = Math.sqrt(vx * vx + vy * vy);
                vx = vx / d * newLen;
                vy = vy / d * newLen;
                mathstr[0] = vx;
                mathstr[1] = vy;
            }
            return mathstr;
        }

        public void setText(String text) {
            if (!TextUtils.isEmpty(text)) {
                this.text = text;
            }
        }

    public void setValue(float value) {
        if (value > 0) {
            this.value = value;
        }
    }
    }

