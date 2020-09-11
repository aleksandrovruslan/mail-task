import org.junit.Before;
import org.junit.Test;
import pages.HomePage;

import static io.qameta.allure.Allure.step;
import static pages.BasePage.USER_EMAIL;
import static pages.BasePage.USER_PASSWORD;

public class LoginAndSendEmailTest extends BaseTest {

    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        homePage = new HomePage(driver);
        homePage.loadHomePage();
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
    }

}
