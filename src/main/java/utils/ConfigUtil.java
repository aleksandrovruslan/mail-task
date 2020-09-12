package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    private static String email;
    private static String password;
    private static String text;
    private static String browser;

    static {
        String userEmail = null;
        String userPassword = null;
        String emailText = null;
        String userBrowser = null;
        try (InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties prop = new Properties();
            prop.load(is);
            userEmail = prop.getProperty("user.email");
            userPassword = prop.getProperty("user.password");
            emailText = prop.getProperty("email.text");
            userBrowser = prop.getProperty("user.browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        email = userEmail == null ? "user@mail.ru" : userEmail;
        password = userPassword == null ? "password" : userPassword;
        text = emailText == null ? "text" : emailText;
        browser = userBrowser == null ? "browser" : userBrowser;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getEmailText() {
        return text;
    }

    public static String getBrowser() {
        return browser;
    }

}
