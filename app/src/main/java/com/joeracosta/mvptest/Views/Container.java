package com.joeracosta.mvptest.Views;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Joe on 12/29/2015.
 */
public interface Container {

    void showTabs(ViewPager viewPager);

    void hideTabs();

    void setContent(View view);
    void replaceWithNewView(View view);
    boolean onBackPressed();

}
