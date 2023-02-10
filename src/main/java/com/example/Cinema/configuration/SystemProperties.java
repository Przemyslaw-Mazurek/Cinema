package com.example.Cinema.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

/*
@Configuration
@Getter
public class SystemProperties {
    @Value("${app.langResourceBundle}")
    private String langResourceBundle;

    @Value("${app.lang}")
    private String lang;


    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(langResourceBundle, Locale.forLanguageTag(lang));
}
*/
