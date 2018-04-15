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

    Paint mPaint;
    Bitmap mBitmap;
    Canvas mCanvas;
    Path mPath;
    Paint mBitmapPaint;
    Context context;
    Paint circlePaint;
    Path circlePath;

    // joueur
    Bitmap joueur1 = null;
    Bitmap joueur2 = null;
    Bitmap joueur3 = null;
    Bitmap joueur4 = null;
    Bitmap joueur5 = null;
    Bitmap joueur6 = null;
    Bitmap joueur7 = null;
    Bitmap joueur8 = null;
    Bitmap joueur9 = null;
    Bitmap joueur10 = null;
    Bitmap joueur11 = null;


    float  xOri_joueur1=250, yOri_joueur1=260;
    float  xOri_joueur2=350, yOri_joueur2=260;
    float  xOri_joueur3=450, yOri_joueur3=260;
    float  xOri_joueur4=550, yOri_joueur4=260;
    float  xOri_joueur5=650, yOri_joueur5=260;
    float  xOri_joueur6=750, yOri_joueur6=260;

    float  xOri_joueur7=350, yOri_joueur7=350;
    float  xOri_joueur8=450, yOri_joueur8=350;
    float  xOri_joueur9=550, yOri_joueur9=350;
    float  xOri_joueur10=650, yOri_joueur10=350;
    float  xOri_joueur11=750, yOri_joueur11=350;

    float deltaX_joueur1, deltaY_joueur1;
    float deltaX_joueur2, deltaY_joueur2;
    float deltaX_joueur3, deltaY_joueur3;
    float deltaX_joueur4, deltaY_joueur4;
    float deltaX_joueur5, deltaY_joueur5;
    float deltaX_joueur6, deltaY_joueur6;
    float deltaX_joueur7, deltaY_joueur7;
    float deltaX_joueur8, deltaY_joueur8;
    float deltaX_joueur9, deltaY_joueur9;
    float deltaX_joueur10, deltaY_joueur10;
    float deltaX_joueur11, deltaY_joueur11;

    boolean move_joueur1 = false;
    boolean move_joueur2 = false;
    boolean move_joueur3 = false;
    boolean move_joueur4 = false;
    boolean move_joueur5 = false;
    boolean move_joueur6 = false;
    boolean move_joueur7 = false;
    boolean move_joueur8 = false;
    boolean move_joueur9 = false;
    boolean move_joueur10 = false;
    boolean move_joueur11 = false;

    int largImage,hautImage;


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
        mPaint.setStrokeWidth(6);



        BitmapDrawable j1 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur1 = j1.getBitmap();
        largImage=joueur1.getWidth();
        hautImage=joueur1.getHeight();

        BitmapDrawable j2 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur2 = j2.getBitmap();
        largImage=joueur2.getWidth();
        hautImage=joueur2.getHeight();

        BitmapDrawable j3 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur3 = j3.getBitmap();
        largImage=joueur3.getWidth();
        hautImage=joueur3.getHeight();

        BitmapDrawable j4 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur4 = j4.getBitmap();
        largImage=joueur4.getWidth();
        hautImage=joueur4.getHeight();

        BitmapDrawable j5 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur5 = j5.getBitmap();
        largImage=joueur5.getWidth();
        hautImage=joueur5.getHeight();

        BitmapDrawable j6 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur6 = j6.getBitmap();
        largImage=joueur6.getWidth();
        hautImage=joueur6.getHeight();

        BitmapDrawable j7 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur7 = j7.getBitmap();
        largImage=joueur7.getWidth();
        hautImage=joueur7.getHeight();

        BitmapDrawable j8 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur8 = j8.getBitmap();
        largImage=joueur8.getWidth();
        hautImage=joueur8.getHeight();

        BitmapDrawable j9 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur9 = j9.getBitmap();
        largImage=joueur9.getWidth();
        hautImage=joueur9.getHeight();

        BitmapDrawable j10 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur10 = j10.getBitmap();
        largImage=joueur10.getWidth();
        hautImage=joueur10.getHeight();

        BitmapDrawable j11 = (BitmapDrawable) getResources().getDrawable(R.drawable.player, null);
        joueur11 = j11.getBitmap();
        largImage=joueur11.getWidth();
        hautImage=joueur11.getHeight();
    }




    public void onDraw (Canvas canvas)      {

        p.setColor(Color.rgb(6,98,37));
        p.setStyle(Paint.Style.FILL);

        p.setColor(Color.WHITE);
        p.setTextSize(20);
        p.setTextAlign(Paint.Align.CENTER);
        p.setStyle(Paint.Style.STROKE);


        canvas.drawRect(1,0,getWidth(),getHeight(),p);

        canvas.drawLine(0,125, 1100, 125, p);
        canvas.drawLine(0,250, 1100, 250, p);
        canvas.drawLine(0,375, 1100, 375, p);

        //dessin
        canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
        canvas.drawPath( mPath,  mPaint);
        canvas.drawPath( circlePath,  circlePaint);



        //dessin
        canvas.drawBitmap(joueur1, xOri_joueur1, yOri_joueur1, p);
        canvas.drawBitmap(joueur2, xOri_joueur2, yOri_joueur2, p);
        canvas.drawBitmap(joueur3, xOri_joueur3, yOri_joueur3, p);
        canvas.drawBitmap(joueur4, xOri_joueur4, yOri_joueur4, p);
        canvas.drawBitmap(joueur5, xOri_joueur5, yOri_joueur5, p);
        canvas.drawBitmap(joueur6, xOri_joueur6, yOri_joueur6, p);
        canvas.drawBitmap(joueur7, xOri_joueur7, yOri_joueur7, p);
        canvas.drawBitmap(joueur8, xOri_joueur8, yOri_joueur8, p);
        canvas.drawBitmap(joueur9, xOri_joueur9, yOri_joueur9, p);
        canvas.drawBitmap(joueur10, xOri_joueur10, yOri_joueur10, p);
        canvas.drawBitmap(joueur11, xOri_joueur11, yOri_joueur11, p);

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

                // joueur 1
                deltaX_joueur1 = event.getX() - xOri_joueur1;
                deltaY_joueur1 = event.getY() - yOri_joueur1;
                if (deltaX_joueur1>= 0 && deltaX_joueur1 <= largImage && deltaY_joueur1>= 0 && deltaY_joueur1 <= hautImage)
                {
                    move_joueur1 = true;
                }


                // joueur 2
                deltaX_joueur2 = event.getX() - xOri_joueur2;
                deltaY_joueur2 = event.getY() - yOri_joueur2;
                if (deltaX_joueur2>= 0 && deltaX_joueur2 <= largImage && deltaY_joueur2>= 0 && deltaY_joueur2 <= hautImage)
                {
                    move_joueur2 = true;
                }


                // joueur 3
                deltaX_joueur3 = event.getX() - xOri_joueur3;
                deltaY_joueur3 = event.getY() - yOri_joueur3;
                if (deltaX_joueur3>= 0 && deltaX_joueur3 <= largImage && deltaY_joueur3>= 0 && deltaY_joueur3 <= hautImage)
                {
                    move_joueur3 = true;
                }


                // joueur 4
                deltaX_joueur4 = event.getX() - xOri_joueur4;
                deltaY_joueur4 = event.getY() - yOri_joueur4;
                if (deltaX_joueur4>= 0 && deltaX_joueur4 <= largImage && deltaY_joueur4>= 0 && deltaY_joueur4 <= hautImage)
                {
                    move_joueur4 = true;
                }


                // joueur 5
                deltaX_joueur5 = event.getX() - xOri_joueur5;
                deltaY_joueur5 = event.getY() - yOri_joueur5;
                if (deltaX_joueur5>= 0 && deltaX_joueur5 <= largImage && deltaY_joueur5>= 0 && deltaY_joueur5 <= hautImage)
                {
                    move_joueur5 = true;
                }


                // joueur 6
                deltaX_joueur6 = event.getX() - xOri_joueur6;
                deltaY_joueur6 = event.getY() - yOri_joueur6;
                if (deltaX_joueur6>= 0 && deltaX_joueur6 <= largImage && deltaY_joueur6>= 0 && deltaY_joueur6 <= hautImage)
                {
                    move_joueur6 = true;
                }



                // joueur 7
                deltaX_joueur7 = event.getX() - xOri_joueur7;
                deltaY_joueur7 = event.getY() - yOri_joueur7;
                if (deltaX_joueur7>= 0 && deltaX_joueur7 <= largImage && deltaY_joueur7>= 0 && deltaY_joueur7 <= hautImage)
                {
                    move_joueur7 = true;
                }


                // joueur 8
                deltaX_joueur8 = event.getX() - xOri_joueur8;
                deltaY_joueur8 = event.getY() - yOri_joueur8;
                if (deltaX_joueur8>= 0 && deltaX_joueur8 <= largImage && deltaY_joueur8>= 0 && deltaY_joueur8 <= hautImage)
                {
                    move_joueur8 = true;
                }


                // joueur 9
                deltaX_joueur9 = event.getX() - xOri_joueur9;
                deltaY_joueur9 = event.getY() - yOri_joueur9;
                if (deltaX_joueur9>= 0 && deltaX_joueur9 <= largImage && deltaY_joueur9>= 0 && deltaY_joueur9 <= hautImage)
                {
                    move_joueur9 = true;
                }


                // joueur 10
                deltaX_joueur10 = event.getX() - xOri_joueur10;
                deltaY_joueur10 = event.getY() - yOri_joueur10;
                if (deltaX_joueur10>= 0 && deltaX_joueur10 <= largImage && deltaY_joueur10>= 0 && deltaY_joueur10 <= hautImage)
                {
                    move_joueur10 = true;
                }


                // joueur 11
                deltaX_joueur11 = event.getX() - xOri_joueur11;
                deltaY_joueur11 = event.getY() - yOri_joueur11;
                if (deltaX_joueur11>= 0 && deltaX_joueur11 <= largImage && deltaY_joueur11>= 0 && deltaY_joueur11 <= hautImage)
                {
                    move_joueur11 = true;
                }

                touch_start(x, y);
                invalidate();
                //}
                break;
            case MotionEvent.ACTION_MOVE:

                // image 1
                if(move_joueur1) {
                    xOri_joueur1 = event.getX() - deltaX_joueur1;
                    yOri_joueur1 = event.getY() - deltaY_joueur1;
                }

                // image 2
                if(move_joueur2) {
                    xOri_joueur2 = event.getX() - deltaX_joueur2;
                    yOri_joueur2 = event.getY() - deltaY_joueur2;
                }

                // image 3
                if(move_joueur3) {
                    xOri_joueur3 = event.getX() - deltaX_joueur3;
                    yOri_joueur3 = event.getY() - deltaY_joueur3;
                }

                // image 4
                if(move_joueur4) {
                    xOri_joueur4 = event.getX() - deltaX_joueur4;
                    yOri_joueur4 = event.getY() - deltaY_joueur4;
                }

                // image 5
                if(move_joueur5) {
                    xOri_joueur5 = event.getX() - deltaX_joueur5;
                    yOri_joueur5 = event.getY() - deltaY_joueur5;
                }

                // image 6
                if(move_joueur6) {
                    xOri_joueur6 = event.getX() - deltaX_joueur6;
                    yOri_joueur6 = event.getY() - deltaY_joueur6;
                }

                // image 7
                if(move_joueur7) {
                    xOri_joueur7 = event.getX() - deltaX_joueur7;
                    yOri_joueur7 = event.getY() - deltaY_joueur7;
                }

                // image 8
                if(move_joueur8) {
                    xOri_joueur8 = event.getX() - deltaX_joueur8;
                    yOri_joueur8 = event.getY() - deltaY_joueur8;
                }

                // image 9
                if(move_joueur9) {
                    xOri_joueur9 = event.getX() - deltaX_joueur9;
                    yOri_joueur9 = event.getY() - deltaY_joueur9;
                }

                // image 10
                if(move_joueur1) {
                    xOri_joueur10 = event.getX() - deltaX_joueur10;
                    yOri_joueur10 = event.getY() - deltaY_joueur10;
                }

                // image 11
                if(move_joueur11) {
                    xOri_joueur11 = event.getX() - deltaX_joueur11;
                    yOri_joueur11 = event.getY() - deltaY_joueur11;
                }



                // dessin
                if (move_joueur1 == false && move_joueur2 == false && move_joueur3 == false && move_joueur4 == false
                        && move_joueur5 == false && move_joueur6 == false && move_joueur7 == false && move_joueur8 == false
                        && move_joueur9 == false && move_joueur10 == false && move_joueur11 == false) {
                    touch_move(x, y);
                    invalidate();
                }


                break;
            case MotionEvent.ACTION_UP:
                move_joueur1 = false;
                move_joueur2 = false;
                move_joueur3 = false;
                move_joueur4 = false;
                move_joueur5 = false;
                move_joueur6 = false;
                move_joueur7 = false;
                move_joueur8 = false;
                move_joueur9 = false;
                move_joueur10 = false;
                move_joueur11 = false;


                //dessin
                touch_up();
                invalidate();
                break;
        }
        invalidate ();
        return true;
    }


}
