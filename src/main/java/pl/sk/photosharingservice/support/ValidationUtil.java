package pl.sk.photosharingservice.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record ValidationUtil() {

    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PROFILE_DESCRIPTION_MAX_LENGTH = 150;
    public static final int IMAGE_DESCRIPTION_MAX_LENGTH = 2200;
    public static final int IMAGE_MAX_SIZE = 10485760;
    private static final String EMAIL_PATTERN = ".+@.+\\..+";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}$";

    public static boolean checkUsername(String username) {
        return username != null && username.length() != 0;
    }

    public static boolean checkPassword(String password) {
        if (password == null)
            return false;

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches() && email.length() != 0;
    }

    public static ObjectNode getErrorResponse(Integer status, String message) {

        return new ObjectMapper().createObjectNode()
                .put("status", status)
                .put("message", message);
    }

}
