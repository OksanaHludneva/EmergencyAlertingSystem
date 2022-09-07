package com.example.eas_finalproject.dotenv;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

public class HandleDotenv {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        System.out.printf("Line 1: %s%n ACCOUNT_SID: %s%n",
                System.getenv("TWILIO_ACCOUNT_SID"), dotenv.get("TWILIO_ACCOUNT_SID")
        );

        System.out.printf("Line 2: %s%n AUTH_TOKEN: %s%n",
                System.getenv("TWILIO_AUTH_TOKEN"), dotenv.get("TWILIO_AUTH_TOKEN")
        );

        System.out.printf("Line 3: %s%n SERVICE_SID: %s%n",
                System.getenv("NOTIFY_SERVICE_SID"), dotenv.get("NOTIFY_SERVICE_SID")
        );
    }
}

