package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //заполнение имени
    public WebElement nameField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Имя']"));
    }
    //заполнение фамилии
    public WebElement surnameField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Фамилия']"));
    }
    //заполнение адреса
    public WebElement addressField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"));
    }
    //нажатие на поле метро
    public WebElement metroDropdown() {
        return driver.findElement(By.className("select-search__input"));
    }
    //выбор станции метро
    public WebElement metroOption(String metro) {
        return driver.findElement(By.xpath("//div[@class='select-search__select']//div[text()='" + metro + "']"));
    }
    //номер телефона
    public WebElement phoneField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"));
    }
    //кнопка для продолжения заказа
    public WebElement nextButton() {
        return driver.findElement(By.className("Button_Middle__1CSJM"));
    }
    //дата доставка
    public WebElement dateField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']"));
    }

    //срок аренды
    public WebElement rentalPeriodDropdown(String dayRent) {
        WebElement dropdown = driver.findElement(By.className("Dropdown-root"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Dropdown-option') and text()='" + dayRent + "']")));
        return option;
    }

    //выбор цвета самоката
    public WebElement scooterColor(String color) {
        return driver.findElement(By.xpath("//label[contains(text(), '" + color + "')]"));
    }
    //поле комментария для курьера
    public WebElement commentField() {
        return driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']"));
    }
    //кнопка Заказать
    public WebElement orderButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and contains(text(), 'Заказать')]"));
    }
    //кнопка подтверждения заказа
    public WebElement confirmButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and contains(text(), 'Да')]"));
    }
    //окно подтверждения заказа
    public WebElement orderConfirm() {
        return driver.findElement(By.className("Order_Modal__YZ-d3"));
    }


}
