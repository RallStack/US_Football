package net.cs2i.us_football.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import net.cs2i.us_football.R;

/**
 * Created by thomas on 15/04/2018.
 */

public class VueTerrainStrategie extends View {
    Paint p = new Paint();
    Bitmap planet =null;
    Bitmap test =null;

    float xOri=10,yOri=10;
    float xOri2=100,yOri2=100;
    int largImage,hautImage;

    private float deltaX;
    private float deltaY;
    private float deltaX2;
    private float deltaY2;
    boolean move = false;
    boolean move2 = false;

    Paint mPaint;
    Bitmap mBitmap;
    Canvas mCanvas;
    Path mPath;
    Paint mBitmapPaint;
    Context context;
    Paint circlePaint;
    Path circlePath;


    public VueTerrainStrategie(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        mPath = new Path();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
        circlePaint = new Paint();
        circlePath = new Path();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.WHITE);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeJoin(Paint.Join.MITER);
        circlePaint.setStrokeWidth(4f);



        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);



        BitmapDrawable d = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        planet = d.getBitmap();
        largImage=planet.getWidth();
        hautImage=planet.getHeight();

        BitmapDrawable f = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        test = f.getBitmap();
        largImage=test.getWidth();
        hautImage=test.getHeight();
    }




    public void onDraw (Canvas canvas)      {

        p.setColor(Color.rgb(6,98,37));
        p.setStyle(Paint.Style.FILL);

        p.setColor(Color.WHITE);
        p.setTextSize(20);
        p.setTextAlign(Paint.Align.CENTER);
        p.setStyle(Paint.Style.STROKE);


        canvas.drawRect(1,0,getWidth(),getHeight(),p);

        canvas.drawLine(275,0, 275, 500, p);
        canvas.drawLine(550,0, 550, 500, p);
        canvas.drawLine(825,0, 825, 500, p);

        canvas.drawBitmap(planet, xOri, yOri, p);
        canvas.drawBitmap(test, xOri2, yOri2, p);


        //dessin
        canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
        canvas.drawPath( mPath,  mPaint);
        canvas.drawPath( circlePath,  circlePaint);

    }





    // dessin
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }


    private float mX, mY;
    private static final float TOUCH_TOLERANCE = 4;

    private void touch_start(float x, float y) {
        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touch_move(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
            mX = x;
            mY = y;

            circlePath.reset();
            circlePath.addCircle(mX, mY, 30, Path.Direction.CW);
        }
    }

    private void touch_up() {
        mPath.lineTo(mX, mY);
        circlePath.reset();
        // commit the path to our offscreen
        mCanvas.drawPath(mPath,  mPaint);
        // kill this so we don't double draw
        mPath.reset();
    }







    public boolean onTouchEvent (MotionEvent event){
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                // image 1
                deltaX = event.getX() - xOri;
                deltaY = event.getY() - yOri;
                if (deltaX>= 0 && deltaX <= largImage && deltaY>= 0 && deltaY <= hautImage)
                {
                    move = true;
                }


                // image 2
                deltaX2 = event.getX() - xOri2;
                deltaY2 = event.getY() - yOri2;
                if (deltaX2>= 0 && deltaX2 <= largImage && deltaY2>= 0 && deltaY2 <= hautImage)
                {
                    move2 = true;
                }


                //dessin
                //if (move == false && move2 == false) {
                touch_start(x, y);
                invalidate();
                //}
                break;
            case MotionEvent.ACTION_MOVE:

                // image 1
                if(move) {
                    xOri = event.getX() - deltaX;
                    yOri = event.getY() - deltaY;
                }

                // image 2
                if (move2)
                {
                    xOri2 = event.getX() - deltaX2;
                    yOri2 = event.getY()- deltaY2;
                }






                // dessin
                if (move == false && move2 == false) {
                    touch_move(x, y);
                    invalidate();
                }


                break;
            case MotionEvent.ACTION_UP:
                move = false;
                move2 = false;





                //dessin
                //if (move == false && move2 == false) {
                touch_up();
                invalidate();
                break;
            //}
        }
        invalidate ();
        return true;
    }


}
