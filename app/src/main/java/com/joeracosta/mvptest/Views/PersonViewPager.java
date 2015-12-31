package com.joeracosta.mvptest.Views;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;

import com.joeracosta.mvptest.MainActivity;
import com.joeracosta.mvptest.Network.LoadContacts;
import com.joeracosta.mvptest.OttoEvents.LoadContactsFinishedEvent;
import com.joeracosta.mvptest.Persistent.BusProvider;
import com.joeracosta.mvptest.Views.Adapters.PersonVPAdapter;
import com.squareup.otto.Subscribe;

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

        BusProvider.getInstance().register(this);

        //make internet call if no data
        LoadContacts.loadContacts();

    }

    @Subscribe
    public void onLoadContactsFinishedEvent(LoadContactsFinishedEvent event){

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

        BusProvider.getInstance().unregister(this);
    }
}
