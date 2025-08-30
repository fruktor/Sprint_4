package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import page.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqTest {

    private MainPage mainPage;
    private WebDriver driver;

    @Parameterized.Parameters
    public static Object[][] faqIndexes() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    private final int index;
    private final String answer;

    public FaqTest(int index, String answer) {
        this.index = index;
        this.answer = answer;
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.acceptCookies();

    }

    @Test
    public void faqAnswerAppearsOnClick() {
        mainPage.scrollToFaq();
        mainPage.clickFaqQuestion(index);
        mainPage.waitFaqAnswer(index);

        String actualAnswer = mainPage.getFaqAnswerText(index);
        assertEquals("Текст ответа не соответствует ожидаемому для вопроса с индексом " + index,
                answer, actualAnswer);

    }



    @After
    public void quit() {
            driver.quit();
    }
}



