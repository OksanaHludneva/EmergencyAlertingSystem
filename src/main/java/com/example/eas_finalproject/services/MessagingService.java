package com.example.eas_finalproject.services;

import com.example.eas_finalproject.repository.ContactsRepository;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.notify.v1.service.Notification;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessagingService {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static final String SERVICE_SID = "IScc36336d04e99e9c8709e21c8ecfccf0";

    public void messagingRequest(String region, String alertType, String message) throws AuthenticationException {

        ArrayList<String> phoneNr = new ArrayList();

        ContactsRepository contactsRepository = new ContactsRepository();
        phoneNr = contactsRepository.getAllPhoneNr(region);
        System.out.println(phoneNr);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            List<String> toBindings = Arrays.asList(
                    "{\"binding_type\":\"sms\",\"address\":\"+371\"}",
                    "{\"binding_type\":\"sms\",\"address\":\"+371\"}");

            Notification notification = Notification
                    .creator(SERVICE_SID)
                    .setBody(alertType + ": " + message)
                    .setToBinding(toBindings)
                    .create();

            System.out.println(notification.getSid());

        } catch (final ApiException e) {
            System.err.println(e);
        }
    }
}