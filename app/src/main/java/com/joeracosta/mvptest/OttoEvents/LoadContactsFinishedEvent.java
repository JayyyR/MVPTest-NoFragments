package com.joeracosta.mvptest.OttoEvents;

/**
 * Created by Joe on 12/30/2015.
 */
public class LoadContactsFinishedEvent {

    public String response;

    public LoadContactsFinishedEvent(String response){
        this.response = response;
    }
}
