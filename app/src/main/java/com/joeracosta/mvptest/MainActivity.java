package com.joeracosta.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.joeracosta.mvptest.Persistent.DataAccess;
import com.joeracosta.mvptest.Persistent.MVPApplication;
import com.joeracosta.mvptest.Views.Container;
import com.joeracosta.mvptest.Views.SinglePaneContainer;

public class MainActivity extends AppCompatActivity {
    private Container container;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (SinglePaneContainer) findViewById(R.id.container);
        DataAccess.setApplication((MVPApplication)getApplication());
    }

    public Container getContainer() {
        return container;
    }

    @Override public void onBackPressed() {
        boolean handled = container.onBackPressed();
        if (!handled) {
            finish();
        }
    }
}
