import java.lang.*;
import java.util.concurrent.TimeUnit;

import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class YandexMarketTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.ie.driver",
                "C:\\AutomatedTesting\\Selenium\\IEDriverServer_Win32_3.7.0\\IEDriverServer.exe");

        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();

        baseUrl = "https://yandex.ru";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Yandex Market - Search test - Valid Value")
    public void testSearchForTabletAcer() throws Exception {
        driver.get(baseUrl + "/");

        driver.findElement(By.linkText("Маркет")).click();
        driver.findElement(By.linkText("Компьютеры")).click();
        driver.findElement(By.linkText("Планшеты")).click();
        driver.findElement(By.linkText("Перейти ко всем фильтрам")).click();

        driver.findElement(By.id("glf-pricefrom-var")).clear();
        driver.findElement(By.id("glf-pricefrom-var")).sendKeys("20000");
        driver.findElement(By.id("glf-priceto-var")).clear();
        driver.findElement(By.id("glf-priceto-var")).sendKeys("25000");
        if (!driver.findElement(By.id("glf-7893318-267101")).isSelected()) {
            driver.findElement(By.id("glf-7893318-267101")).click();
        }
        driver.findElement(By.linkText("Показать подходящие")).click();

        String search_result_title_second_item
                = driver.findElement(By.xpath("//div[2]/div[4]/div/div/a")).getText();

        driver.findElement(By.id("header-search")).clear();
        driver.findElement(By.id("header-search")).sendKeys(search_result_title_second_item);
        driver.findElement(By.className("search2__button")).click();
        Thread.sleep(2000);  // To slow down the webdriver's next step until the page loaded

        String search_result_title_top_item
                = driver.findElement(By.xpath("//div[1]/div[4]/div/div/a")).getText();

        assertEquals(search_result_title_second_item, search_result_title_top_item);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
