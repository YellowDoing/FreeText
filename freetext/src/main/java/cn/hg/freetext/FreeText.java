package cn.hg.freetext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;


public class FreeText extends AppCompatTextView {

    private final String TAG = "cn.hg.FreeText";
    protected GradientDrawable drawable;

    protected int stroke_color;
    protected float stroke_width;
    protected float stroke_corner_radius;
    protected int solid;

    public FreeText(@NonNull Context context) {
        super(context);
        init(null);
    }

    public FreeText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FreeText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        drawable = new GradientDrawable();

        if (attrs != null) {

            TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.FreeText, 0, 0);

            stroke_color = typedArray.getColor(R.styleable.FreeText_strokeColor, Color.TRANSPARENT);
            stroke_width = typedArray.getDimension(R.styleable.FreeText_strokeWidth, 0);
            stroke_corner_radius = typedArray.getDimension(R.styleable.FreeText_strokeCornerRadius, 0);
            solid = typedArray.getColor(R.styleable.FreeText_solid, Color.TRANSPARENT);

            setDrawableParams();
        }
    }

    private void setDrawableParams() {

        drawable.setStroke((int) stroke_width, stroke_color);
        drawable.setCornerRadius(stroke_corner_radius);
        drawable.setColor(solid);

        setBackground(drawable);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    /** ----------------setter and getter----------------- **/
    public void setSolid(int solid) {
        this.solid = solid;
        setDrawableParams();
    }

    public void setStrokeColor(int stroke_color) {
        this.stroke_color = stroke_color;
        setDrawableParams();
    }

    public void setStrokeWidth(float stroke_width) {
        this.stroke_width = stroke_width;
        setDrawableParams();
    }

    public void setStrokeCornerRadius(float stroke_corner_radius) {
        this.stroke_corner_radius = stroke_corner_radius;
        setDrawableParams();
    }

}
