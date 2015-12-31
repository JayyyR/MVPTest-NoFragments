package com.joeracosta.mvptest.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joeracosta.mvptest.Models.Contact;
import com.joeracosta.mvptest.R;

import java.util.ArrayList;

/**
 * Created by Joe on 12/30/2015.
 */
public class ContactPage extends LinearLayout {

    TextView testNum;
    int testInt;

    public ContactPage(Context context, int test, String eyeColor, ArrayList<Contact> contacts) {
        super(context);
        testInt = test;
        init();
    }

    public ContactPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContactPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.contact_page_view, this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        testNum = (TextView) findViewById(R.id.test_num);
        testNum.setText(String.valueOf(testInt));
    }
}
