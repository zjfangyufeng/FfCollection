package com.ff.demo.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fangyufeng on 2015/10/10.
 */
public class PathMeasureView extends View {

    Paint paint = new Paint();

    public PathMeasureView(Context context) {
        super(context);
        init();
    }

    public PathMeasureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathMeasureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init(){
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20f);
    }

    int radius = 50;
    float[] pos = new float[2];

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Point point = new Point(360,720);
        RectF rectF = new RectF(point.x-radius,point.y-radius,point.x+radius,point.y+radius);
        Path path = new Path();
        path.addArc(rectF, 180, 180);
        PathMeasure pathMeasure = new PathMeasure(path,false);
        float length = pathMeasure.getLength();


        for(int i =0;i<5;i++){
            pathMeasure.getPosTan(length/4*i,pos,null);
            canvas.drawPoint(pos[0], pos[1], paint);
        }
        canvas.drawPoint(360, 720, paint);
//        canvas.drawPath(path,paint);
    }
}
