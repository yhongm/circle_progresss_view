package com.yhongm.circle_progress_core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressView extends View {
    Paint mProgreessPaint;//当前进度条画笔
    Paint mBgPaint;//背景画笔
    private int mWidth;
    private int mHeight;
    private int mPadding = 10;
    float currentAngle = 0;
    RectF rectF;
    private int total = 100;
    private int paintWidth = 9;
    int normalProgressColor;
    int normalBgColor;
    float percentage = 1;
    Context mContext;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
        initAttributeSet(attrs);

    }

    private void initAttributeSet(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);

        normalProgressColor = typedArray.getColor(R.styleable.CircleProgressView_progressColor, normalProgressColor);
        normalBgColor = typedArray.getColor(R.styleable.CircleProgressView_bgColor, normalBgColor);
        total = typedArray.getInt(R.styleable.CircleProgressView_total, 100);
        int current = typedArray.getInt(R.styleable.CircleProgressView_current, 0);
        setCurrentProgress(current);
    }

    private void initPaint() {

        normalProgressColor = Color.parseColor("#00e6cb");
        normalBgColor = Color.parseColor("#2b524f");
        mProgreessPaint = new Paint();
        mProgreessPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mProgreessPaint.setAntiAlias(true);
        mProgreessPaint.setColor(normalProgressColor);
        mProgreessPaint.setStyle(Paint.Style.STROKE);
        mProgreessPaint.setStrokeWidth(paintWidth);
        mBgPaint = new Paint();
        mBgPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mBgPaint.setAntiAlias(true);
        mBgPaint.setColor(normalBgColor);
        mBgPaint.setStyle(Paint.Style.STROKE);
        mBgPaint.setStrokeWidth(paintWidth);
        rectF = new RectF();

    }

    /**
     * 设置当前进度
     *
     * @param currentProgress
     */
    public void setCurrentProgress(int currentProgress) {
        currentAngle = ((currentProgress + 0f) / total) * 360;
        percentage = (currentProgress + 0f) / total;
        invalidate();
    }

    /**
     * 设置总进度
     *
     * @param total
     */
    public void setTotalProgress(int total) {
        this.total = total;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidth();
        mHeight = getHeight();
        rectF.left = mPadding;
        rectF.right = mWidth - mPadding;
        rectF.top = mPadding;
        rectF.bottom = mHeight - mPadding;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBgPaint.setColor(normalBgColor);
        mProgreessPaint.setColor(normalProgressColor);

        canvas.drawArc(rectF, 0f, 360, false, mBgPaint);
        canvas.drawArc(rectF, 0f - 90, currentAngle, false, mProgreessPaint);
    }
}
