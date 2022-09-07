package com.example.eas_finalproject.services;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.notify.v1.service.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;

public class MessagingService {

    static Logger logger = LoggerFactory.getLogger(MessagingService.class);
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static final String SERVICE_SID = System.getenv("NOTIFY_SERVICE_SID");
    public static void main(String[] args) throws AuthenticationException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        List<String> toBindings = Arrays.asList(
                "{\"binding_type\":\"sms\",\"address\":\"+371...\"}",
                "{\"binding_type\":\"sms\",\"address\":\"+371...\"}");

        Notification notification = Notification
                .creator(SERVICE_SID)
                .setBody("SMS text")
                .setToBinding(toBindings)
                .create();

        System.out.println(notification.getSid());
    }
}

