package com.joeracosta.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.joeracosta.mvptest.Persistent.DataAccess;
import com.joeracosta.mvptest.Persistent.MVPApplication;
import com.joeracosta.mvptest.Views.Container;
import com.joeracosta.mvptest.Views.PersonViewPager;
import com.joeracosta.mvptest.Views.SinglePaneContainer;
import com.joeracosta.mvptest.Views.TextPageView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Container container;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataAccess.setApplication((MVPApplication) getApplication());
        //when activity is recreated on configuration change, we need to recreate views to make sure contexts update
        resetBackStackContexts();

        setContentView(R.layout.activity_main);
        container = (SinglePaneContainer) findViewById(R.id.container);


    }

    public Container getContainer() {
        return container;
    }

    private void resetBackStackContexts(){
        Stack<View> tempViewStack = new Stack<>();
        while (!DataAccess.getInstance().isBackStackEmpty()){
            View view = DataAccess.getInstance().popFromBackStack();

            if (view instanceof TextPageView){
                tempViewStack.push(new TextPageView(this));
            }
            else if (view instanceof PersonViewPager){
                tempViewStack.push(new PersonViewPager(this));
            }
        }

        while (!tempViewStack.isEmpty()){
            DataAccess.getInstance().pushToStack(tempViewStack.pop());
        }
    }

    @Override public void onBackPressed() {
        boolean handled = container.onBackPressed();
        if (!handled) {
            finish();
        }
    }
}
