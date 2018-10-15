package ml.ainlpstudy.dev.petfinder.heart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class HeartView extends View {
    int bgColor;
    Paint paint;

    public HeartView(Context context) {
        super(context);
        init();
    }

    public HeartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        this.setBgColor(0);
        paint = new Paint();
        paint.setStrokeWidth(10);
        this.setPaintColor(255);
        this.setBackgroundColor(0);
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public void setPaintColor(int paintColor){
        this.paint.setColor(paintColor);
    }

    @Override
    protected  void onDraw(Canvas canvas){
        float maxX = this.getScaleX();
        float maxY = this.getScaleY();

        canvas.drawPoint(maxX/2, maxY/2, this.paint);
    }
}
