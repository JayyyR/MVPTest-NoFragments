package com.joeracosta.mvptest.Persistent;

/**
 * Created by Joe on 12/30/2015.
 */
public class DataAccess {

    public static MVPApplication _application;

    public static void setApplication(MVPApplication application){
        if (application != null){
            _application = application;
        }
    }

    public static MVPApplication getInstance(){
        return _application;
    }
}
