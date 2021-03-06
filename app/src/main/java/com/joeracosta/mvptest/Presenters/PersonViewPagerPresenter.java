package com.joeracosta.mvptest.Presenters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joeracosta.mvptest.Models.Contact;
import com.joeracosta.mvptest.Network.LoadContacts;
import com.joeracosta.mvptest.OttoEvents.LoadContactsFinishedEvent;
import com.joeracosta.mvptest.Persistent.BusProvider;
import com.joeracosta.mvptest.Persistent.DataAccess;
import com.joeracosta.mvptest.Views.PersonViewPager;
import com.squareup.otto.Subscribe;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Joe on 12/30/2015.
 */
public class PersonViewPagerPresenter implements ViewPresenter {

    private PersonViewPager _view;

    public PersonViewPagerPresenter(PersonViewPager view){
        _view = view;
    }


    @Subscribe
    public void onLoadContactsFinishedEvent(LoadContactsFinishedEvent event){
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<Contact>>(){}.getType();
        ArrayList<Contact> contacts = gson.fromJson(event.response, collectionType);

        for (Contact c : contacts){
            DataAccess.getInstance().addContact(c);
        }

        _view.dataLoaded();
    }


    @Override
    public void viewAdded() {
        BusProvider.getInstance().register(this);

        if (DataAccess.getInstance().getContactsByEyeColor().isEmpty()) {
            //make internet call if no data
            LoadContacts.loadContacts();
        }
        else{
            //data already exists
            _view.dataLoaded();
        }
    }

    @Override
    public void viewRemoved() {
        BusProvider.getInstance().unregister(this);
    }
}
