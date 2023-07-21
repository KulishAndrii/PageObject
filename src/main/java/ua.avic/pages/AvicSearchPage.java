package ua.avic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AvicSearchPage {
    private final WebDriver driver;

    public AvicSearchPage() {
        this.driver = new ChromeDriver();
    }
    public List<WebElement> FindTheSameElems(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public AvicSearchPage navigateTo() {
        driver.manage().window().maximize();
        driver.get("https://avic.ua/ua");
        return this;
    }

    public AvicSearchPage search(String query) {
        WebElement search = driver.findElement(By.id("input_search"));
        search.sendKeys(query);
        return this;
    }

    public AvicSearchPage clickSearchButton() {
        WebElement btn = driver.findElement(By.xpath("//button[@class='button-reset search-btn']"));
        btn.click();
        return this;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
