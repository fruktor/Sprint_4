package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка "Заказать" вверху страницы
    public WebElement orderButtonTop() {
        return driver.findElement(By.className("Button_Button__ra12g"));
    }

    // кнопка "Заказать" внизу страницы
    public WebElement orderButtonBottom() {
        return driver.findElement(By.xpath("//div[contains(@class,'Home_FinishButton__1_cWm')]//button[text()='Заказать']"));
    }


    // вопросы о важном
    public WebElement getFaqQuestion(int index) {
        WebElement question = driver.findElement(By.id("accordion__heading-" + index));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(question));
        question.click();
        WebElement answer = driver.findElement(By.id("accordion__panel-" + index));
        wait.until(ExpectedConditions.visibilityOf(answer));
        return answer;
    }

    // принятие куки
    public WebElement acceptCookies() {
        return driver.findElement(By.id("rcc-confirm-button"));
    }
}
