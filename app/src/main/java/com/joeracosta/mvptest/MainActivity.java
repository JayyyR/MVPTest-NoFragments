package com.joeracosta.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.joeracosta.mvptest.Views.Container;

public class MainActivity extends AppCompatActivity {
    private Container container;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (Container) findViewById(R.id.container);
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
