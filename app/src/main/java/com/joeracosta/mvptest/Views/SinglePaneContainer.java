package com.joeracosta.mvptest.Views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.support.design.widget.TabLayout;

import com.joeracosta.mvptest.Persistent.DataAccess;
import com.joeracosta.mvptest.R;

/**
 * Created by Joe on 12/29/2015.
 */
public class SinglePaneContainer extends FrameLayout implements Container{

    private FrameLayout _contentView;
    private Toolbar _toolBar;
    private TabLayout tabs;

    public SinglePaneContainer(Context context) {
        super(context);
        init();
    }

    public SinglePaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SinglePaneContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.single_pane_container, this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        _contentView = (FrameLayout) findViewById(R.id.content_view);
        _toolBar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);

        if (DataAccess.getInstance().isBackStackEmpty()){
            replaceWithNewView(new TextPageView(getContext()));
        }
        else {
            setContent(DataAccess.getInstance().peekAtTopOfStack());
        }
    }

    @Override
    public void showTabs(ViewPager viewPager){
        tabs.setupWithViewPager(viewPager);
        tabs.setVisibility(VISIBLE);
    }

    @Override
    public void hideTabs(){
        tabs.setVisibility(GONE);
    }

    @Override
    public void setContent(View view) {
        _contentView.removeAllViews();
        ViewGroup parent = (ViewGroup)view.getParent();
        if (parent != null){
            parent.removeView(view);
        }
        _contentView.addView(view);
    }

    /**
     * Call when you want to push new view to screen and backstack
     * @param view
     */
    @Override
    public void replaceWithNewView(View view){
        DataAccess.getInstance().pushToStack(view);
        setContent(view);
    }

    public boolean onBackPressed() {

        DataAccess.getInstance().popFromBackStack();

        //if backstack is empty, call super which will finish the activity
        if (DataAccess.getInstance().isBackStackEmpty()){
            return false;
        }
        else{
            setContent(DataAccess.getInstance().peekAtTopOfStack());
            return true;
        }

        /*
        //if VP is showing, go back to textview page
        if (_contentView.getChildAt(0) instanceof PersonViewPager){
            setContent(new TextPageView(getContext(), null));
            return true;
        }

        return false;*/
    }
}
