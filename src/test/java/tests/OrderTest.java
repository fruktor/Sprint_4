package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.OrderPage;
import page.MainPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderTest {

    private MainPage mainPage;
    private WebDriver driver;
    private OrderPage orderPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String dayRent;
    private final String color;
    private final String comment;


    public OrderTest(String name, String surname, String address, String metro, String phone, String date, String dayRent, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.dayRent = dayRent;
        this.color = color;
        this.comment = comment;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "Пушкина", "Фрунзенская", "+79261112233", "01.02.2025", "сутки", "чёрный жемчуг", "Без звонка"},
                {"Петр", "Петров", "Ленина", "Тверская", "+79263334455", "02.05.2025",  "четверо суток", "серая безысходность", "Позвонить перед приездом"}
        });
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage", "window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderPage = new OrderPage(driver);
        mainPage = new MainPage(driver);
        mainPage.acceptCookies().click();
    }

    @Test //верхняя кнопка "Заказать"
    public void orderTest() {
        //первая форма
        mainPage.orderButtonTop().click();
        orderPage.nameField().sendKeys(name);
        orderPage.surnameField().sendKeys(surname);
        orderPage.addressField().sendKeys(address);
        orderPage.metroDropdown().click();
        orderPage.metroDropdown().sendKeys(metro);
        orderPage.metroOption(metro).click();
        orderPage.phoneField().sendKeys(phone);
        orderPage.nextButton().click();
        //вторая форма
        orderPage.dateField().sendKeys(date);
        orderPage.dateField().sendKeys(Keys.ENTER);
        orderPage.rentalPeriodDropdown(dayRent).click();
        orderPage.scooterColor(color).click();
        orderPage.commentField().sendKeys(comment);
        orderPage.orderButton().click();
        //окно подтверждения заказа
        orderPage.confirmButton().click();
        assertTrue(orderPage.orderConfirm().isDisplayed());
    }

    @Test //нижняя кнопка заказать

    public void orderTest_2() {
        //первая форма
        mainPage.orderButtonBottom().click();
        orderPage.nameField().sendKeys(name);
        orderPage.surnameField().sendKeys(surname);
        orderPage.addressField().sendKeys(address);
        orderPage.metroDropdown().click();
        orderPage.metroDropdown().sendKeys(metro);
        orderPage.metroOption(metro).click();
        orderPage.phoneField().sendKeys(phone);
        orderPage.nextButton().click();
        //вторая форма
        orderPage.dateField().sendKeys(date);
        orderPage.dateField().sendKeys(Keys.ENTER);
        orderPage.rentalPeriodDropdown(dayRent).click();
        orderPage.scooterColor(color).click();
        orderPage.commentField().sendKeys(comment);
        orderPage.orderButton().click();
        //окно подтверждения заказа
        orderPage.confirmButton().click();
        assertTrue(orderPage.orderConfirm().isDisplayed());
    }


    @After
    public void quit() {
        driver.quit();
    }
}



