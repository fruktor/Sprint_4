package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //ЛОКАТОРЫ

    //поле имени
    public final By nameForm = By.xpath("//input[@placeholder='* Имя']");
    //поле фамилии
    public final By surnameForm = By.xpath("//input[@placeholder='* Фамилия']");
    //поле адреса
    public final By addressForm = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле метро
    public final By metroDrop = By.className("select-search__input");
    //поле телефона
    public final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка "Далее"
    public final By nextButton = By.className("Button_Middle__1CSJM");
    //поле дата доставки
    public final By dateForm  = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //поле комментария
    public final By searchComment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать"
    public final By orderButton = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and contains(text(), 'Заказать')]");
    //кнопка "Да"
    public final By confirmButton = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and contains(text(), 'Да')]");
    //окно "Заказ оформлен" (не совсем
    public final By orderConfirm = By.xpath("//div[contains(@class,'Order_ModalHeader__3FDaJ') and contains(text(),'Заказ оформлен')]");

    //чекбокс черного самоката
    private final By blackCheckbox = By.cssSelector("label[for='black'] input");
    //чекбокс серого самоката
    private final By greyCheckbox  = By.cssSelector("label[for='grey'] input");


    //МЕТОДЫ

    //заполнение имени
    public void nameField(String name) {
         driver.findElement(nameForm).sendKeys(name);
    }

    //заполнение фамилии
    public void surnameField(String surname) {
        driver.findElement(surnameForm).sendKeys(surname);
    }

    //заполнение адреса
    public void addressField(String address) {
        driver.findElement(addressForm).sendKeys(address);
    }

    //заполнение метро
    public void metroDropdown(String metro) {
        driver.findElement(metroDrop).sendKeys(metro);
    }
    //выбор станции метро
    public WebElement metroOption(String metro) {
        return driver.findElement(By.xpath("//div[@class='select-search__select']//div[text()='" + metro + "']"));
    }

    //номер телефона
    public void phoneField(String phoneNumber) {
        driver.findElement(phone).sendKeys(phoneNumber);
    }

    //кнопка для продолжения заказа
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    //заполнение 1 формы
    public void fieldForm1(String name, String surname, String address, String metro, String phoneNumber) {
        nameField(name);
        surnameField(surname);
        addressField(address);
        metroDropdown(metro);
        metroOption(metro).click();
        phoneField(phoneNumber);
    }


    //дата доставка
    public void dateField(String date) {
         driver.findElement(dateForm).sendKeys(date, Keys.ENTER);
    }

    //срок аренды
    public void rentalPeriodDropdown(String dayRent) {
        WebElement dropdown = driver.findElement(By.className("Dropdown-root"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Dropdown-option') and text()='" + dayRent + "']")));
        option.click();
    }

    //выбор черного цвета
    public void clickCheckBoxBlack(){
        driver.findElement(blackCheckbox).click();
    }
    //выбор серого цвета
    public void clickCheckBoxGrey(){
        driver.findElement(greyCheckbox).click();
    }

    //заполнение поля комменатрия
    public void commentField(String comment) {
        driver.findElement(searchComment).sendKeys(comment);
    }

    //заполнение 2-ой формы
    public void fieldForm2(String date, String dayRent, String color, String comment) {
        dateField(date);
        rentalPeriodDropdown(dayRent);
        if ("black".equals(color)) {
            clickCheckBoxBlack();
        } else {
            clickCheckBoxGrey();
        }

        commentField(comment);
    }

    //кнопка Заказать
    public void сlickOrderButton() {
       driver.findElement(orderButton).click();
    }

    //кнопка подтверждения заказа
    public void clickConfirmButton() {
       driver.findElement(confirmButton).click();
    }

    //проверка окна подтверждения заказа
    public void checkOrderConfirm() {
        assertTrue(driver.findElement(orderConfirm).isDisplayed());
    }

}
