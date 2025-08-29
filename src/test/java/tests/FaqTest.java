package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.MainPage;
import static org.junit.Assert.*;


public class FaqTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage", "window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        mainPage.acceptCookies().click();
    }

    @Test
    public void checkFaqAnswers() {
        for (int i = 0; i < 8; i++) {
            assertTrue(mainPage.getFaqQuestion(i).isDisplayed());
        }
    }

    @After
    public void quit() {
        driver.quit();
    }
}
