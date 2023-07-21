package ua.avic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AvicPcPage {
    private final WebDriver driver;

    public AvicPcPage() {
        this.driver = new ChromeDriver();
    }

    public AvicPcPage navigateTo() {
        driver.manage().window().maximize();
        driver.get("https://avic.ua/ua/gotovyie-pk");
        return this;
    }

    public AvicPcPage sortDesc() {
        driver.findElement(By.xpath("//div[@class=\"two-column-wrapper \"]//span[@class=\"select2-selection__rendered\"]")).click();
        driver.findElement(By.xpath("//li[@class=\"select2-results__option\"][contains(text(),'Від дорогих до дешевих')]")).click();
        return this;
    }
    public List<Integer> prices() {
        return driver.findElements(By.xpath("//div[@class=\"prod-cart__prise-new\"]")).stream()
                .map(WebElement::getText)
                .map(x-> x.substring(0,x.indexOf(" ")))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public boolean isSortedDesc(List<Integer> ints) {
     return ints.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).equals(ints);
    }



}
