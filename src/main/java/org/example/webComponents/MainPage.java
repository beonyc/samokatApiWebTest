package org.example.webComponents;

import org.openqa.selenium.*;

public class MainPage {
    private final By droppedTextList = By.className("Home_FAQ__3uVm4");
    private String childText;

    public String getChildText() {
        return childText;
    }

    public void setChildText(String childText) {
        this.childText = childText;
    }

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToDroppedText() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(droppedTextList));

    }

    public void clickToDropdownMenuAndSetAppearedText(String ParentText) {
        scrollToDroppedText();
        driver.findElement(By.xpath(".//*[@data-accordion-component='AccordionItem']/div/div[text()='" + ParentText + "']")).click();
        setChildText(driver.findElement(By.xpath(String.format(".//div[text()='%s']/parent::*/parent::*//child::p", ParentText))).getText());
    }

}
