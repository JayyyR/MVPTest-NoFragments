package com.joeracosta.mvptest.Views.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.joeracosta.mvptest.Views.ContactPage;

/**
 * Created by Joe on 12/30/2015.
 */
public class PersonVPAdapter extends PagerAdapter {

    Context _context;

    public PersonVPAdapter(Context context){
        _context = context;
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ContactPage contactPage = new ContactPage(_context, position + 1);
        container.addView(contactPage);
        return contactPage;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position + 1);
    }
}
