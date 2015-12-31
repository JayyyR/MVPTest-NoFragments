package com.joeracosta.mvptest.Views;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;

import com.joeracosta.mvptest.MainActivity;
import com.joeracosta.mvptest.Views.Adapters.PersonVPAdapter;

/**
 * Created by Joe on 12/30/2015.
 */
public class PersonViewPager extends ViewPager {

    public PersonViewPager(Context context) {
        super(context);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        //make internet call if no data

        //getdata create adapter
        PersonVPAdapter personAdapter = new PersonVPAdapter(getContext());
        setAdapter(personAdapter);

        //show the tabs
        ((MainActivity)getContext()).getContainer().showTabs(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        ((MainActivity)getContext()).getContainer().hideTabs();
    }
}
