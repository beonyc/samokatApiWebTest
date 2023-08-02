package org.example.webComponents;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

@RunWith(Parameterized.class)
public class ParamMakeOrderTest {
    static Faker faker = new Faker(Locale.forLanguageTag("ru"));

    WebDriver driver;
    MakeOrder makeOrder;
    private final Integer orderButtonNumber;
    private final String firstName;
    private final String lastName;
    private final String adress;
    private final String metroStation;
    private final String phoneNumber;
    private final String timeToDelivery;
    private final int day;
    private final String comment;

    public ParamMakeOrderTest(Integer orderButtonNumber, String firstName, String lastName, String adress, String metroStation, String phoneNumber, String timeToDelivery, int day, String comment) {
        this.orderButtonNumber = orderButtonNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.timeToDelivery = timeToDelivery;
        this.day = day;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {faker.number().numberBetween(1, 2),
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.address().city(),
                        "Автозаводская",
                        faker.number().digits(11),
                        faker.date().birthday().toString(),
                        faker.number().numberBetween(1, 6),
                        faker.lorem().fixedString(20)
                },
                {faker.number().numberBetween(1, 2),
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.address().city(),
                        "Автозаводская",
                        faker.number().digits(11),
                        faker.date().birthday().toString(),
                        faker.number().numberBetween(1, 6),
                        faker.lorem().fixedString(20)
                }
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa-scooter.praktikum-services.ru/");
        makeOrder = new MakeOrder(driver);

    }

    @Test
    @DisplayName("Создание заказа")
    public void makeOrderTest() {
        makeOrder.makeFullOrder(orderButtonNumber, firstName, lastName, adress, metroStation, phoneNumber, timeToDelivery, day, comment);
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }

}