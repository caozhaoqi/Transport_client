package com.example.transportclient;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;

/**
 * Created by oyyj on 2015/8/6.
 */
public class HorizontalSlideLayout extends LinearLayout {
    private static final int SLIDE_TO_LEFT = -1;
    private static final int SLIDE_TO_RIGHT = 1;
    private static String TAG = "VerticalSlideLayout";
    private final int ANIM_DURATION = 300;
    int downX, downY;
    boolean isNeedToGoBack;
    private int DRAG_X_THROD = 0;
    private int SCROLL_X = 0;
    private int mSlideDirection = 0;
    private ObjectAnimator mAnimator;
    Animator.AnimatorListener listener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {

        }

        @Override
        public void onAnimationEnd(Animator animator) {
            mAnimator = null;
        }

        @Override
        public void onAnimationCancel(Animator animator) {
            mAnimator = null;
        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }
    };

    public HorizontalSlideLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //判断横划的阈值,为了兼容不同尺寸的设备，以dp为单位
        DRAG_X_THROD = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, context.getResources().getDisplayMetrics());
        SCROLL_X = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, context.getResources().getDisplayMetrics());
    }

    public HorizontalSlideLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalSlideLayout(Context context) {
        this(context, null, 0);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        boolean isInterceptHere = false;
        try {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downX = (int) ev.getX();
                    downY = (int) ev.getY();
                    isInterceptHere = true;
                    if (mAnimator != null) {
                        mAnimator.cancel();
                    }
                    break;

                case MotionEvent.ACTION_MOVE:

                    int dx = (int) Math.abs(ev.getX() - downX);
                    int dy = (int) Math.abs(ev.getY() - downY);
                    if (dx > dy && dx > DRAG_X_THROD) {
                        Log.i(TAG, "横划！拦截它");
                        setParentInterceptTouchEvent(true);
                        isInterceptHere = true;
                        mSlideDirection = (ev.getX() - downX) > 0 ? SLIDE_TO_RIGHT : SLIDE_TO_LEFT;
                        if (mSlideDirection == SLIDE_TO_LEFT) {
                            isNeedToGoBack = true;
                            playAnimation(SCROLL_X, ANIM_DURATION);
                        } else if (mSlideDirection == SLIDE_TO_RIGHT && isNeedToGoBack) {
                            playAnimation(0, ANIM_DURATION);
                        }
                    } else if (dy > dx) {
                        Log.i(TAG, "竖划！不拦截");
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    setParentInterceptTouchEvent(false);
                    isInterceptHere = false;
                    downX = 0;
                    downY = 0;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isInterceptHere;
    }

    private void playAnimation(int translationX, int duration) {
        if (mAnimator != null) {
            mAnimator.cancel();
        }

        mAnimator = ObjectAnimator.ofInt(this, "scrollX", translationX);
        mAnimator.setDuration(duration);
        mAnimator.start();

        mAnimator.addListener(listener);
    }

    /*    这个函数很重要，请求禁止父容器拦截触摸事件  */
    public void setParentInterceptTouchEvent(boolean disallow) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallow);
        }
    }
}