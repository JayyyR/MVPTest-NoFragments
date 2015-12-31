package com.joeracosta.mvptest.Network;

import com.joeracosta.mvptest.OttoEvents.LoadContactsFinishedEvent;
import com.joeracosta.mvptest.Persistent.BusProvider;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Joe on 12/30/2015.
 */
public class LoadContacts {

    private static final String URL = "http://www.json-generator.com/api/json/get/bZOxhbfoya?indent=2";

    public static void loadContacts() {

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.doGetRequest(URL, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //something failed
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseStr = response.body().string();
                    BusProvider.getInstance().post(new LoadContactsFinishedEvent(responseStr));
                } else {
                    // Request not successful
                }
            }
        });

    }
}
