import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigUtil;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        switch (ConfigUtil.getBrowser()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                break;
            default:
                throw new IllegalArgumentException(
                        ConfigUtil.getBrowser() + " browser not found.");
        }
    }

    @Before
    public void setUp() throws Exception {
        switch (ConfigUtil.getBrowser()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "ff":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;
            case "ie":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("ignoreZoomSetting", true);
                driver = new InternetExplorerDriver(caps);
                break;
            default:
                throw new IllegalArgumentException(
                        ConfigUtil.getBrowser() + " browser not found.");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

}
