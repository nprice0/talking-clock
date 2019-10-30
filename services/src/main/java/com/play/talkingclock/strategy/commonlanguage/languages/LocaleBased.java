package com.play.talkingclock.strategy.commonlanguage.languages;

import com.play.talkingclock.strategy.commonlanguage.Language;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleBased implements Language {

    private static final String BUNDLE_BASENAME = "Language";
    private static final String DELIMITER = ",";

    private final Locale locale;
    private final ResourceBundle resourceBundle;

    public LocaleBased(String language) {
        this(language, null);
    }

    public LocaleBased(String language, String country) {
        if (language == null || language.isEmpty()) {
            locale = Locale.getDefault();
        } else if (country == null || country.isEmpty())
            locale = new Locale(language);
        else
            locale = new Locale(language, country);

        resourceBundle = ResourceBundle.getBundle(BUNDLE_BASENAME, locale);
    }

    @Override
    public String[] getUnits() {
        return resourceBundle.getString("units").split(DELIMITER);
    }

    @Override
    public String[] getTens() {
        return resourceBundle.getString("tens").split(DELIMITER);
    }

    @Override
    public String[] getHours() {
        return resourceBundle.getString("hours").split(DELIMITER);
    }

    @Override
    public String getBeforeThirty() {
        return resourceBundle.getString("beforeThirty");
    }

    @Override
    public String getAfterThirty() {
        return resourceBundle.getString("afterThirty");
    }

    @Override
    public String getOClock() {
        return resourceBundle.getString("oclock");
    }

    @Override
    public String getMidnight() {
        return resourceBundle.getString("midnight");
    }

    @Override
    public String getMidday() {
        return resourceBundle.getString("midday");
    }
}
