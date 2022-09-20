package com.example.eas_finalproject.services;

import com.example.eas_finalproject.repository.ContactsRepository;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.notify.v1.service.Notification;
import javafx.scene.control.Alert;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MessagingService {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static final String SERVICE_SID = System.getenv("TWILIO_SERVICE_SID");

    public void messagingRequest(String alertType, String region, String message) throws AuthenticationException {

        ArrayList<String> phoneNr = new ArrayList();

        ContactsRepository contactsRepository = new ContactsRepository();
        phoneNr = contactsRepository.getAllPhoneNr(region);

        int size = phoneNr.size();
        byte[] warningByteCode = new byte[]{(byte)0xE2, (byte)0x9A, (byte)0xA0};
        String emoji = new String(warningByteCode, Charset.forName("UTF-8"));

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            List<String> toBindings = new ArrayList();

            for (int counter = 0; counter < phoneNr.size(); counter++) {
                String phoneBinding = "{\"binding_type\":\"sms\",\"address\":\"" + phoneNr.get(counter) + "\"}";
                toBindings.add(phoneBinding);
            }

            Notification notification = Notification
                    .creator(SERVICE_SID)
                    .setBody(emoji + " " + alertType + "\n" + message)
                    .setToBinding(toBindings)
                    .create();

            System.out.println(notification.getSid());

            SceneService.showAlert(
                    "Notification Status",
                    "Your request number " + notification.getSid() + " is processed",
                    Alert.AlertType.INFORMATION
            );

        } catch(final ApiException e){
            System.err.println(e);
        }
    }
}