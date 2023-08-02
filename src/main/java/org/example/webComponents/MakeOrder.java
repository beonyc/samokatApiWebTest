package org.example.webComponents;

import org.openqa.selenium.*;

import java.util.List;

public class MakeOrder {
    WebDriver driver;
    private final By orderButtonFirst = By.xpath(".//div[@class='Header_Nav__AGCXC']//*[text()='Заказать']");
    private final By orderButtonSecond = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//*[text()='Заказать']");
    private final By firstName = By.xpath(".//*[@placeholder='* Имя']");
    private final By lastName = By.xpath(".//*[@placeholder='* Фамилия']");
    private final By adres = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStation = By.xpath(".//*[@placeholder='* Станция метро']");
    private final By phoneNumber = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    private final By timeToDelivery = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    private final By rentDate = By.xpath(".//*[text()='* Срок аренды']");
    private final By color = By.id("black");
    private final By comment = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    private final By finalOrderButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");


    public MakeOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonSecond() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonSecond));
        driver.findElement(orderButtonSecond).click();
    }

    public void clickOrderButtonFirst() {
        driver.findElement(orderButtonFirst).click();
    }

    public void setfirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String name) {
        driver.findElement(lastName).sendKeys(name);
    }

    public void setAdres(String adress) {
        driver.findElement(adres).sendKeys(adress);
    }

    public void setMetroStation(String metro) {
        driver.findElement(metroStation).click();
        driver.findElement(metroStation).sendKeys(metro, Keys.DOWN, Keys.ENTER);
    }

    public void setPhone(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setTimeToDelivery(String time) {
        driver.findElement(timeToDelivery).click();
        driver.findElement(timeToDelivery).sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public void setRentDate(int day) {
        driver.findElement(rentDate).click();
        driver.findElement(By.xpath(String.format(".//*[@class='Dropdown-option'][%d]", day))).click();
    }

    public void setColorBlack() {
        driver.findElement(color).click();
    }

    public void setComment(String commentt) {
        driver.findElement(comment).sendKeys(commentt);
    }

    private void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
    }

    public void makeFullOrder(int orderNumber, String firstName, String lastName, String adress, String metro, String phone, String time, int day, String comment) {
        if (orderNumber == 1)
            clickOrderButtonSecond();
        else
            clickOrderButtonFirst();

        setfirstName(firstName);
        setLastName(lastName);
        setAdres(adress);
        setMetroStation(metro);
        setPhone(phone);
        clickNextButton();
        setTimeToDelivery(time);
        setRentDate(day);
        setColorBlack();
        setComment(comment);
        clickFinalOrderButton();

    }
}
