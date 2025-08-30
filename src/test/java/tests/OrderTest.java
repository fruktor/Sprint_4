package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.OrderPage;
import page.MainPage;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class OrderTest {

    private MainPage mainPage;
    private WebDriver driver;
    private OrderPage orderPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String date;
    private final String dayRent;
    private final String color;
    private final String comment;


    public OrderTest(String name, String surname, String address, String metro, String phoneNumber, String date, String dayRent, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.dayRent = dayRent;
        this.color = color;
        this.comment = comment;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "Пушкина", "Фрунзенская", "+79261112233", "01.02.2025", "сутки", "black", "Без звонка"},
                {"Петр", "Петров", "Ленина", "Тверская", "+79263334455", "02.05.2025",  "четверо суток", "grey", "Позвонить перед приездом"}
        });
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        orderPage = new OrderPage(driver);
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.acceptCookies();
    }

    @Test //верхняя кнопка "Заказать"
    public void orderTest() {
        mainPage.clickOrderButtonTop();
        //первая форма
        orderPage.fieldForm1(name, surname, address, metro, phoneNumber);
        orderPage.clickNextButton();

        //вторая форма
        orderPage.fieldForm2(date, dayRent, color, comment);
        orderPage.сlickOrderButton();
        orderPage.clickConfirmButton();

        //окно подтверждения заказа
        orderPage.checkOrderConfirm();
    }

    @Test //нижняя кнопка заказать

    public void orderTest_2() {
        mainPage.clickOrderButtonBottom();
        //первая форма
        orderPage.fieldForm1(name, surname, address, metro, phoneNumber);
        orderPage.clickNextButton();

        //вторая форма
        orderPage.fieldForm2(date, dayRent, color, comment);
        orderPage.сlickOrderButton();
        orderPage.clickConfirmButton();

        //окно подтверждения заказа
        orderPage.checkOrderConfirm();
    }


    @After
    public void quit() {
        driver.quit();
    }
}



