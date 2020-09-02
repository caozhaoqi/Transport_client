package com.example.transportclient;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@SuppressLint("AppCompatCustomView")
public class CustomFAB extends ImageButton {
    private static final int RAD = 56;
    private Context ctx;
    private int bgColor;
    private int bgColorPressed;


    public CustomFAB(@NonNull Context context) {
        super(context);
        this.ctx = context;
        init(null);
    }

    public CustomFAB(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init(attrs);
    }

    public CustomFAB(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ctx = context;
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomFAB(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.ctx = context;
        init(attrs);
    }

    private Drawable createButton(int color) {
        OvalShape oShape = new OvalShape();
        ShapeDrawable sd = new ShapeDrawable(oShape);
        setWillNotDraw(false);
        sd.getPaint().setColor(color);

        OvalShape oShape1 = new OvalShape();
        ShapeDrawable sd1 = new ShapeDrawable(oShape);

        sd1.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {

                return new LinearGradient(0, 0, 0, height,
                        new int[]{
                                Color.WHITE,
                                Color.GRAY,
                                Color.DKGRAY,
                                Color.BLACK
                        }, null, Shader.TileMode.REPEAT);
            }
        });

        LayerDrawable ld = new LayerDrawable(new Drawable[]{sd1, sd});
        ld.setLayerInset(0, 5, 5, 0, 0);
        ld.setLayerInset(1, 0, 0, 5, 5);

        return ld;
    }


    private void init(AttributeSet attrSet) {
        Resources.Theme theme = ctx.getTheme();
        TypedArray arr = theme.obtainStyledAttributes(attrSet, R.styleable.FAB, 0, 0);
        try {
            setBgColor(arr.getColor(R.styleable.FAB_bg_color, Color.BLUE));
            setBgColorPressed(arr.getColor(R.styleable.FAB_bg_color_pressed, Color.GRAY));
            StateListDrawable sld = new StateListDrawable();

            sld.addState(new int[]{android.R.attr.state_pressed}, createButton(bgColorPressed));
            sld.addState(new int[]{}, createButton(bgColor));
            setBackground(sld);
        } catch (Throwable ignored) {
        } finally {
            arr.recycle();
        }

    }

    /**
     * Setter for property 'bgColor'.
     *
     * @param color Value to set for property 'bgColor'.
     */
    public void setBgColor(int color) {
        this.bgColor = color;
    }

    /**
     * Setter for property 'bgColorPressed'.
     *
     * @param color Value to set for property 'bgColorPressed'.
     */
    public void setBgColorPressed(int color) {
        this.bgColorPressed = color;
    }
}
