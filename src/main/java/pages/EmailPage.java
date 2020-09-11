package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailPage extends BasePage {

    private WebDriver driver;

    @FindBy(css = "a[title='Написать письмо']")
    private WebElement sendEmailButton;

    @FindBy(css = ".container--ItIg4 > div > .container--H9L5q")
    private WebElement addressInput;

    @FindBy(css = ".container--2Rl8H > div > div:nth-child(2) > div > div:nth-child(2)")
    private WebElement emailBody;

    @FindBy(xpath = "//span[@class='button2__txt' and text()='Отправить']")
    WebElement sendButton;

    @FindBy(linkText = "Письмо отправлено")
    WebElement successMessageSendEmail;

    @FindBy(css = "span[data-id='contact-to-0']")
    WebElement successAddress;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSendEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
    }

    public void enterAddress(String sendAddress) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addressInput)).sendKeys(sendAddress);
        addressInput.sendKeys(Keys.ENTER);
    }

    public void enterEmailBody(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(emailBody));
        Actions actions = new Actions(driver);
        actions.click(emailBody).sendKeys(message).build().perform();
    }

    public void sendEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    public void checkSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(successMessageSendEmail));
    }

    public String getSuccessAddress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(successAddress)).getText();
    }

}
