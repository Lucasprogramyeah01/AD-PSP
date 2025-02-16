package com.example.ejemploSecurity2.security.baeldung;

import com.example.ejemploSecurity2.user.model.User;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@Getter
@Setter
//BAELDUNG 3.2.1
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private String appUrl;
    private Locale locale;
    private User user;

    public OnRegistrationCompleteEvent(
            User user, Locale locale, String appUrl) {
        super(user);

        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

}
