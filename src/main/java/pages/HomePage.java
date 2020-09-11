package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private static String HOME_URL = "https://mail.ru/";

    @FindBy(id = "mailbox:login-input")
    private WebElement loginField;

    @FindBy(id = "mailbox:submit-button")
    private WebElement enterLoginButton;

    @FindBy(id = "mailbox:password-input")
    private WebElement passwordField;

    @FindBy(id = "mailbox:submit-button")
    private WebElement enterButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loadHomePage() {
        driver.get(HOME_URL);
    }

    public void fillLogin(String login) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginField)).sendKeys(login);

    }

    public void clickEnterLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enterLoginButton)).click();
    }

    public void fillPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }

    public void clickEnter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enterButton)).click();
    }

}
