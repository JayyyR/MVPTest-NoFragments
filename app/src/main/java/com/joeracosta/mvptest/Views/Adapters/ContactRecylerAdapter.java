package com.joeracosta.mvptest.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joeracosta.mvptest.Models.Contact;
import com.joeracosta.mvptest.R;

import java.util.ArrayList;

/**
 * Created by Joe on 12/30/2015.
 */
public class ContactRecylerAdapter extends RecyclerView.Adapter<ContactRecylerAdapter.ContactPageViewHolder> {

    ArrayList<Contact> _dataSet;
    Context _context;

    public ContactRecylerAdapter(ArrayList<Contact> data){
        _dataSet = data;
    }

    @Override
    public ContactRecylerAdapter.ContactPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_cell, parent, false);
        _context = parent.getContext();

        return new ContactPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactRecylerAdapter.ContactPageViewHolder holder, int position) {
        Contact contactAtPosition = _dataSet.get(position);
        holder.name.setText(contactAtPosition.getName());
        holder.gender.setText(_context.getString(R.string.gender_label) + contactAtPosition.getGender().substring(0, 1).toUpperCase() + contactAtPosition.getGender().substring(1));
        holder.favoriteFruit.setText(_context.getString(R.string.fruit_label) + contactAtPosition.getFavoriteFruit().substring(0, 1).toUpperCase() + contactAtPosition.getFavoriteFruit().substring(1));
    }

    @Override
    public int getItemCount() {
        return _dataSet.size();
    }

    public static class ContactPageViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView favoriteFruit;
        public TextView gender;

        public ContactPageViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            favoriteFruit = (TextView) itemView.findViewById(R.id.fav_fruit);
            gender = (TextView) itemView.findViewById(R.id.gender);
        }
    }
}
