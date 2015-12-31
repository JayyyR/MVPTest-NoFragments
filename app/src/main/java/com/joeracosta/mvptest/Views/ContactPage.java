package com.joeracosta.mvptest.Views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joeracosta.mvptest.Models.Contact;
import com.joeracosta.mvptest.R;
import com.joeracosta.mvptest.Views.Adapters.ContactRecylerAdapter;

import java.util.ArrayList;

/**
 * Created by Joe on 12/30/2015.
 */
public class ContactPage extends LinearLayout {

    RecyclerView _recyclerView;
    ArrayList<Contact> contacts;


    public ContactPage(Context context, ArrayList<Contact> contacts) {
        super(context);
        init(contacts);
    }

    public ContactPage(Context context, AttributeSet attrs, ArrayList<Contact> contacts) {
        super(context, attrs);
        init(contacts);
    }

    public ContactPage(Context context, AttributeSet attrs, int defStyleAttr, ArrayList<Contact> contacts) {
        super(context, attrs, defStyleAttr);
        init(contacts);
    }

    private void init(ArrayList<Contact> contacts) {
        inflate(getContext(), R.layout.contact_page_view, this);
        this.contacts = contacts;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        _recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        _recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        _recyclerView.setAdapter(new ContactRecylerAdapter(contacts));
    }
}
