package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;
    //ссылка на сайт
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //кнопка "Заказать" вверху страницы
    private final By orderButtonTop = By.className("Button_Button__ra12g");
    //кнопка "Заказать" внизу страницы
    private final By orderButtonBottom = By.xpath("//div[contains(@class,'Home_FinishButton__1_cWm')]//button[text()='Заказать']");
    //блок FAQ
    private final By faqSection = By.className("Home_FAQ__3uVm4");
    //вопрос в FAQ
    private final String faqQuestionId = "accordion__heading-";
    //ответ в FAQ
    private final String faqAnswer = "accordion__panel-";
    // кнопка принятия cookie
    private final By acceptCookiesButton = By.id("rcc-confirm-button");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //открытие сайта
    public void open() {
        driver.get(url);
    }

    //принятие куки
    public void acceptCookies() {
        driver.findElement(acceptCookiesButton).click();
    }

    //кнопка "заказать" сверху
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    //кнопка "заказать" снизу
    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    //прокрутка до блока с faq
    public void scrollToFaq() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", driver.findElement(faqSection));
    }

    //нажатие на вопрос
    public void clickFaqQuestion(int index) {
        driver.findElement(By.id(faqQuestionId + index)).click();
    }

    //ожидание ответа
    public void waitFaqAnswer(int index) {
        By faqAnswerId = By.id(faqAnswer + index);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(faqAnswerId));
    }

    //получение ответа
    public String getFaqAnswerText(int index) {
        return driver.findElement(By.id(faqAnswer + index)).getText();
    }


}
