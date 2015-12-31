package com.joeracosta.mvptest.Persistent;

import android.app.Application;

import com.joeracosta.mvptest.Models.Contact;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Joe on 12/30/2015.
 */
public class MVPApplication extends Application {

    private HashMap<String, ArrayList<Contact>> _contactsByEyeColor;

    private ArrayList<String> colorKeys;

    public ArrayList<String> getColorKeys(){
        return colorKeys;
    }


    public HashMap<String, ArrayList<Contact>> getContactsByEyeColor() {
        return _contactsByEyeColor;
    }


    public void addContact(Contact contact){
        if (_contactsByEyeColor == null){
            _contactsByEyeColor = new HashMap<>();
        }

        String eyeColor = contact.getEyeColor();
        if (_contactsByEyeColor.containsKey(eyeColor)){
            _contactsByEyeColor.get(eyeColor).add(contact);
        }
        else{
            ArrayList<Contact> newContactArray = new ArrayList<>();
            newContactArray.add(contact);
            _contactsByEyeColor.put(eyeColor, newContactArray);

            if (colorKeys == null){
                colorKeys = new ArrayList<>();
            }
            colorKeys.add(eyeColor);
        }

    }
}
