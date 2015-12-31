package com.joeracosta.mvptest.Views;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.joeracosta.mvptest.MainActivity;
import com.joeracosta.mvptest.Models.Contact;
import com.joeracosta.mvptest.Presenters.PersonViewPagerPresenter;
import com.joeracosta.mvptest.R;
import com.joeracosta.mvptest.Views.Adapters.PersonVPAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Joe on 12/30/2015.
 */
public class PersonViewPager extends ViewPager {

    private PersonViewPagerPresenter _presenter;
    private ProgressDialog _loadingDialog;

    public PersonViewPager(Context context) {
        super(context);
        init();
    }
    public PersonViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        _presenter = new PersonViewPagerPresenter(this);
    }

    public void dataLoaded(){
        _loadingDialog.dismiss();
        //getdata create adapter
        PersonVPAdapter personAdapter = new PersonVPAdapter(getContext());
        setAdapter(personAdapter);

        //show the tabs
        ((MainActivity)getContext()).getContainer().showTabs(this);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        _presenter.viewAdded();
        _loadingDialog = ProgressDialog.show(getContext(), getContext().getString(R.string.loading), "");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((MainActivity)getContext()).getContainer().hideTabs();
        _presenter.viewRemoved();
    }
}
