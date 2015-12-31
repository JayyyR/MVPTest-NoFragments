package com.joeracosta.mvptest.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.joeracosta.mvptest.MainActivity;
import com.joeracosta.mvptest.Presenters.TextPagePresenter;
import com.joeracosta.mvptest.R;

/**
 * Created by Joe on 12/29/2015.
 */
public class TextPageView extends LinearLayout {

    private Container _container;
    private Button _button;
    private TextPagePresenter _presenter;

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
        _button = (Button) findViewById(R.id.jump_button);
        _presenter = new TextPagePresenter(this);
        _button.setOnClickListener(buttonListener);
    }

    public void jumpToContacts(){
        _container = ((MainActivity)(getContext())).getContainer();
        _container.setContent(new PersonViewPager(getContext()));
    }

    private OnClickListener buttonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            _presenter.buttonPressed();
        }
    };
}
