package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.app.Activity;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;


import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewStrategieAttaqueActivity extends Activity{

    //private ListView playerStratListView;
    //private Player player;

    private ImageView img_player1;
    private ImageView img_player2;
    private ImageView img_player3;
    private ImageView img_player4;
    private ImageView img_player5;
    private ImageView img_player6;
    private ImageView img_player7;
    private ImageView img_player8;
    private ImageView img_player9;
    private ImageView img_player10;
    private ImageView img_player11;
    private ViewGroup rootLayout;
    private int _xDelta;
    private int _yDelta;

    DrawingView dv ;
    private Paint mPaint;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_strategies);

        //super.onCreate(savedInstanceState);
        dv = new DrawingView(this);
        setContentView(dv);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);


    //    rootLayout = (ViewGroup) findViewById(R.id.view_root);
//
//
    //    img_player1 = (ImageView) rootLayout.findViewById(R.id.joueur1);
    //    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(80,80);
    //    img_player1.setLayoutParams(layoutParams1);
    //    layoutParams1.setMargins(0, 0, 0, 0);
    //    img_player1.setOnTouchListener(new ChoiceTouchListener());
//
    //    img_player2 = (ImageView) rootLayout.findViewById(R.id.joueur2);
    //    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player2.setLayoutParams(layoutParams2);
    //    layoutParams2.setMargins(100, 0, 0, 0);
    //    img_player2.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player3 = (ImageView) rootLayout.findViewById(R.id.joueur3);
    //    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player3.setLayoutParams(layoutParams3);
    //    layoutParams3.setMargins(200, 0, 0, 0);
    //    img_player3.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player4 = (ImageView) rootLayout.findViewById(R.id.joueur4);
    //    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player4.setLayoutParams(layoutParams4);
    //    layoutParams4.setMargins(300, 0, 0, 0);
    //    img_player4.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player5 = (ImageView) rootLayout.findViewById(R.id.joueur5);
    //    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player5.setLayoutParams(layoutParams5);
    //    layoutParams5.setMargins(400, 0, 0, 0);
    //    img_player5.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player6 = (ImageView) rootLayout.findViewById(R.id.joueur6);
    //    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player6.setLayoutParams(layoutParams6);
    //    layoutParams6.setMargins(500, 0, 0, 0);
    //    img_player6.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player7 = (ImageView) rootLayout.findViewById(R.id.joueur7);
    //    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player7.setLayoutParams(layoutParams7);
    //    layoutParams7.setMargins(0, 100, 0, 0);
    //    img_player7.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player8 = (ImageView) rootLayout.findViewById(R.id.joueur8);
    //    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player8.setLayoutParams(layoutParams8);
    //    layoutParams8.setMargins(100, 100, 0, 0);
    //    img_player8.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player9 = (ImageView) rootLayout.findViewById(R.id.joueur9);
    //    RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player9.setLayoutParams(layoutParams9);
    //    layoutParams9.setMargins(200, 100, 0, 0);
    //    img_player9.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player10 = (ImageView) rootLayout.findViewById(R.id.joueur10);
    //    RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player10.setLayoutParams(layoutParams10);
    //    layoutParams10.setMargins(300, 100, 0, 0);
    //    img_player10.setOnTouchListener(new ChoiceTouchListener());
//
//
    //    img_player11 = (ImageView) rootLayout.findViewById(R.id.joueur11);
    //    RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(80, 80);
    //    img_player11.setLayoutParams(layoutParams11);
    //    layoutParams11.setMargins(400, 100, 0, 0);
    //    img_player11.setOnTouchListener(new ChoiceTouchListener());

    //    playerStratListView = (ListView) findViewById(R.id.player_strat_list_view);
    //    player = new Player();

    //    player.createPlayerFile(this);

    //    diplayPlayer();
    }


 /*   private void diplayPlayer(){
        List<ElementList> elementLists = null;

        try {
            elementLists = player.generateList(this);
            ListAdapter adapter = new ListAdapter(this, elementLists);
            playerStratListView.setAdapter(adapter);
        }
        catch (XmlPullParserException e) { }
        catch (IOException e) { }
    }*/

    private final class ChoiceTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = X - _xDelta;
                    layoutParams.topMargin = Y - _yDelta;
                    layoutParams.rightMargin = -250;
                    layoutParams.bottomMargin = -250;
                    view.setLayoutParams(layoutParams);
                    break;
            }
            rootLayout.invalidate();
            return true;
        }
    }

    public class DrawingView extends View {

        public int width;
        public  int height;
        private Bitmap mBitmap;
        private Canvas mCanvas;
        private Path mPath;
        private Paint mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;


        public DrawingView(Context c) {
            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.BLUE);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);


        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath( mPath,  mPaint);
            canvas.drawPath( circlePath,  circlePaint);
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

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }
    }
}
