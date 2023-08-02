package org.example.webComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.example.webComponents.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ParamDropDownMenuTest {
    String parentText;
    String childText;
    MainPage mainPage;
    WebDriver driver;

    public ParamDropDownMenuTest(String parentText, String childText) {
        this.parentText = parentText;
        this.childText = childText;
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa-scooter.praktikum-services.ru/");
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}
        };
    }

    @Test
    @DisplayName("Проверка на совпадение текста в выподающем списке")
    public void checkDropDownMenuForText() {
        mainPage = new MainPage(driver);
        mainPage.clickToDropdownMenuAndSetAppearedText(parentText);
        Assert.assertEquals(childText, mainPage.getChildText());
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }

}