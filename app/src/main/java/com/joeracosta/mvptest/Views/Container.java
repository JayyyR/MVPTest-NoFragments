package com.joeracosta.mvptest.Views;

import android.view.View;

/**
 * Created by Joe on 12/29/2015.
 */
public interface Container {

    void setContent(View view);
    boolean onBackPressed();

}
