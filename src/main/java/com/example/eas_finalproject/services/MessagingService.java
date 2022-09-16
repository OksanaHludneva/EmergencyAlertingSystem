package com.example.eas_finalproject.services;

import com.example.eas_finalproject.repository.ContactsRepository;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.notify.v1.service.Notification;

import java.util.ArrayList;
import java.util.List;

public class MessagingService {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static final String SERVICE_SID = System.getenv("TWILIO_SERVICE_SID");

    public void messagingRequest(String region, String alertType, String message) throws AuthenticationException {

        ArrayList<String> phoneNr = new ArrayList();

        ContactsRepository contactsRepository = new ContactsRepository();
        phoneNr = contactsRepository.getAllPhoneNr(region);

        int size = phoneNr.size();

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            List<String> toBindings = new ArrayList();

            for (int counter = 0; counter < phoneNr.size(); counter++) {
                String phoneBinding = "{\"binding_type\":\"sms\",\"address\":\"" + phoneNr.get(counter) + "\"}";
                toBindings.add(phoneBinding);
            }

            Notification notification = Notification
                    .creator(SERVICE_SID)
                    .setBody(alertType + ": \n" + message)
                    .setToBinding(toBindings)
                    .create();

            System.out.println(notification.getSid());

        } catch(final ApiException e){
            System.err.println(e);
        }
    }
}