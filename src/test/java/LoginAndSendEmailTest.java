import org.junit.Before;
import org.junit.Test;
import pages.EmailPage;
import pages.HomePage;

import static io.qameta.allure.Allure.step;
import static org.junit.Assert.assertTrue;
import static pages.BasePage.*;

public class LoginAndSendEmailTest extends BaseTest {

    private HomePage homePage;
    private EmailPage emailPage;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        homePage = new HomePage(driver);
        homePage.loadHomePage();
        emailPage = new EmailPage(driver);
    }

    @Test
    public void loginAndSendEmail() {
        step("Загружаем главную страницу.",
                () -> homePage.loadHomePage());
        step("Вводим логин и нажимаем кнопку \"ввести пароль\".", () -> {
            homePage.fillLogin(USER_EMAIL);
            homePage.clickEnterLogin();
        });
        step("Вводим пароль и нажимаем кнопку.", () -> {
            homePage.fillPassword(USER_PASSWORD);
            homePage.clickEnter();
        });
        step("Нажимаем кнопку отправить письмо.",
                () -> emailPage.clickSendEmail());
        step("Ввод адреса.", () -> emailPage.enterAddress(USER_EMAIL));
        step("Ввод текста.", () -> emailPage.enterEmailBody(EMAIL_TEXT));
        step("Отправка письма.", () -> emailPage.sendEmail());
        step("Проверка сообщения успешной отправки.",
                () -> emailPage.checkSuccessMessage());
        step("Проверка адресата отправки.", () -> {
            String sendAddressMessage = emailPage.getSuccessAddress();
            assertTrue(sendAddressMessage.contains(USER_EMAIL));
        });
    }

}
