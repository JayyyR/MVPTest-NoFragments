package com.joeracosta.mvptest.Presenters;

import com.joeracosta.mvptest.Views.TextPageView;

/**
 * Created by Joe on 12/30/2015.
 */
public class TextPagePresenter implements ViewPresenter{


    private TextPageView _view;

    public TextPagePresenter(TextPageView view){
        _view = view;
    }

    public void buttonPressed(){
        _view.jumpToContacts();
    }

    @Override
    public void viewAdded() {

    }

    @Override
    public void viewRemoved() {

    }
}
