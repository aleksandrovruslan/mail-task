package pages;

import utils.ConfigUtil;

public class BasePage {

    public static final String USER_EMAIL = ConfigUtil.getEmail();
    public static final String USER_PASSWORD = ConfigUtil.getPassword();
    public static final String EMAIL_TEXT = ConfigUtil.getEmailText();

}
