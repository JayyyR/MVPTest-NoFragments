package com.joeracosta.mvptest.Persistent;

import android.app.Application;
import android.view.View;

import com.joeracosta.mvptest.Models.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Joe on 12/30/2015.
 */
public class MVPApplication extends Application {

    private Stack<View> _backStack = new Stack<>();

    private HashMap<String, ArrayList<Contact>> _contactsByEyeColor = new HashMap<>();

    private ArrayList<String> colorKeys = new ArrayList<>();

    public void pushToStack(View view){
        _backStack.push(view);
    }

    public boolean isBackStackEmpty(){
        return _backStack.isEmpty();
    }

    public View peekAtTopOfStack(){
        return _backStack.peek();
    }

    public View popFromBackStack(){
       return _backStack.pop();
    }

    public ArrayList<String> getColorKeys(){
        return colorKeys;
    }


    public HashMap<String, ArrayList<Contact>> getContactsByEyeColor() {
        return _contactsByEyeColor;
    }

    public void addContact(Contact contact){

        String eyeColor = contact.getEyeColor();
        if (_contactsByEyeColor.containsKey(eyeColor)){
            _contactsByEyeColor.get(eyeColor).add(contact);
        }
        else{
            ArrayList<Contact> newContactArray = new ArrayList<>();
            newContactArray.add(contact);
            _contactsByEyeColor.put(eyeColor, newContactArray);

            colorKeys.add(eyeColor);
        }
    }
}
