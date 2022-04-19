package pl.sk.photosharingservice.support;

import pl.sk.photosharingservice.support.language.Language;

public enum ResponseUtil {

    WRONG_PASSWORD,
    WRONG_USERNAME,
    PASSWORD_CONTAINS_NAME,
    PROFILE_DESCRIPTION_TOO_LONG,
    IMAGE_DESCRIPTION_TOO_LONG,
    WRONG_CREDENTIALS,
    PASSWORDS_DO_NOT_MATCH,
    PASSWORD_TOO_SHORT,
    PASSWORD_TOO_WEAK,
    WRONG_EMAIL,
    EMAIL_TAKEN,
    USERNAME_TAKEN;

    public String translate(Language language){
        return language.translate(this);
    }

}