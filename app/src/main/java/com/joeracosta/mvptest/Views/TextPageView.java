package com.joeracosta.mvptest.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.joeracosta.mvptest.R;

/**
 * Created by Joe on 12/29/2015.
 */
public class TextPageView extends LinearLayout {
    public TextPageView(Context context) {
        super(context);
        init();
    }

    public TextPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextPageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.text_page_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
}
