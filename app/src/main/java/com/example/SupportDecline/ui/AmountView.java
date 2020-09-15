package com.example.SupportDecline.ui;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.example.SupportDecline.APPData;
import com.example.SupportDecline.R;

/*
 *
 *     Copyright (c) 2020 czq <16602629614@163.com>
 *     Github：https://github.com/1120118968
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *     @author czq
 * 作者：czq
 * 创建时间：2020/9/11 17:25 <p>
 * 描述：
 * @name TranSportClient
 * @class name：com.example.SupportDecline.ui
 * @class describe self define fragment
 * @author Administrator QQ:1150118968
 * @time 2020/9/11 17:25
 * @change bug update
 * @chang time 2020 09 15
 * @class describe
 */
public class AmountView extends LinearLayout implements View.OnClickListener, TextWatcher {

    private static final String TAG = "AmountView";

    public int amount; //数量
    APPData appData = (APPData) getContext().getApplicationContext();
    int count;
    private int goods_storage = 999999999; //数 count top
    private OnAmountChangeListener mListener; //数量变化的回调接口
    private EditText etAmount;//数量
    private Button btnDecrease;//-按钮
    private Button btnIncrease;//+按钮
    ///APPData appData;


    public AmountView(Context context) {

        this(context, null);
        //  appData = (APPData) getContext().getApplicationContext();

        amount = appData.amount;
    }
//构造方法

    public AmountView(Context context, AttributeSet attrs) {

        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_amount, this);

        etAmount = findViewById(R.id.stepper);

        btnDecrease = findViewById(R.id.btnDecrease);

        btnIncrease = findViewById(R.id.btnIncrease);

        btnDecrease.setOnClickListener(this);

        btnIncrease.setOnClickListener(this);

        etAmount.addTextChangedListener(this);

        amount = appData.amount;

        // etAmount.setText(appData.aount);

        //, AmountView_btnWidth, AmountView_tvWidth, AmountView_tvTextSize, AmountView_btnTextSize  ，是res/Values下的定义的  attrs.xml 内容，分别代表左右2边+-按钮的宽度 ，中间TextView的宽度，字体大小，btnTextSize

        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.AmountView);

        int btnWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnWidth, LayoutParams.WRAP_CONTENT);

        int tvWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvWidth, LayoutParams.WRAP_CONTENT);

        int tvTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvTextSize, 0);

        int btnTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnTextSize, 0);

        obtainStyledAttributes.recycle();

        LayoutParams btnParams = new LayoutParams(btnWidth, LayoutParams.MATCH_PARENT);

        btnDecrease.setLayoutParams(btnParams);

        btnIncrease.setLayoutParams(btnParams);

        if (btnTextSize != 0) {

            btnDecrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);

            btnIncrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);

        }

        LayoutParams textParams = new LayoutParams(tvWidth, LayoutParams.MATCH_PARENT);

        etAmount.setLayoutParams(textParams);

        if (tvTextSize != 0) {

            etAmount.setTextSize(tvTextSize);

        }

        // amount = appData.aount;

    }

    //数量变化的回调接口

    public void setOnAmountChangeListener(@NonNull OnAmountChangeListener onAmountChangeListener) {

        this.mListener = onAmountChangeListener;

    }

    //设置数量

    public void setGoods_storage(int goods_storage) {

        this.goods_storage = goods_storage;

    }

//加减按钮的点击事件，当数值改变时，调用OnAmountChangeListener回调接口

    @SuppressLint("SetTextI18n")
    @Override

    public void onClick(@NonNull View v) {

        int i = v.getId();
        //  amount = appData.aount;

        if (i == R.id.btnDecrease) {

            if (amount > 1) {

                amount--;

                count++;

                etAmount.setText(amount + "");


            }

        } else if (i == R.id.btnIncrease) {

            if (amount < goods_storage) {

                amount++;

                count++;

                etAmount.setText(amount + "");

            }

        }

        etAmount.clearFocus();


        if (mListener != null) {

            mListener.onAmountChange(this, amount);

        }

    }

    @Override

    public void beforeTextChanged(@NonNull CharSequence s, int start, int count, int after) {

    }


    @Override

    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }


    @SuppressLint("SetTextI18n")
    @Override

    public void afterTextChanged(@NonNull Editable s) {

//        if (s.toString().isEmpty())
//
//            return ;

        if (count == 0) {
            amount = appData.amount + Integer.parseInt(s.toString());
        } else {
            amount = Integer.parseInt(s.toString());
        }
//        a = appData.amount;// Integer.parseInt(s.toString());
        Log.e(" init value", s.toString());
        if (amount > goods_storage) {

            etAmount.setText(goods_storage + "");

            return;

        }

        if (mListener != null) {

            mListener.onAmountChange(this, amount);

        }

    }

    public interface OnAmountChangeListener {

        void onAmountChange(@NonNull View view, int amount);

    }

}