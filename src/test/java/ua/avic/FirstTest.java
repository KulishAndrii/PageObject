package ua.avic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import ua.avic.pages.AvicPcPage;
import ua.avic.pages.AvicSearchPage;
import ua.avic.pages.AvicSingInPage;

import java.util.concurrent.TimeUnit;


public class FirstTest {
    static WebDriver driver;
    @BeforeClass
    public void precondition() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void TestSingInNegative() {
        driver = new ChromeDriver();
//        AvicSingInPage avicSingInPage = new AvicSingInPage();
        AvicSingInPage avicSingInPage = PageFactory.initElements(driver, AvicSingInPage.class);

        Assert.assertTrue(avicSingInPage
                .navigateTo()
                .enterPhoneNumber("0999999999")
                .enterPassword("999999")
                .clickEnterButton()
                .IfWarningIsPresent());
        avicSingInPage.close();
    }

    @Test
    public void TestSearchForIphones() {
        AvicSearchPage avicSearchPage = new AvicSearchPage();
        Assert.assertEquals(avicSearchPage
                .navigateTo()
                .search("IPhone")
                .clickSearchButton()
                .getCurrentUrl(), "https://avic.ua/ua/search-results?query=IPhone");
        Assert.assertTrue(avicSearchPage.FindTheSameElems("//div[@class='item-prod col-lg-3']").size() > 0);
    }

    @Test
    public void TestFilterDescOrder() {
        AvicPcPage avicPcPage = new AvicPcPage();
        avicPcPage.navigateTo().sortDesc();
        Assert.assertTrue(avicPcPage.isSortedDesc(avicPcPage.prices()));


//        ChromeDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://avic.ua/ua");
//        driver.findElement(By.xpath("//span[contains(text(), \"Комп'ютери\")]")).click();
//        driver.findElement(By.xpath("//div[@class='height brand-box']//a[contains(text(), \"Системні блоки\")]")).click();
//        driver.findElement(By.xpath("//div[@class=\"two-column-wrapper \"]//span[@class=\"select2-selection__rendered\"]")).click();
//        driver.findElement(By.xpath("//li[@class=\"select2-results__option\"][contains(text(),'Від дорогих до дешевих')]")).click();
//        List<WebElement> PCes = driver.findElements(By.xpath("//div[@class=\"prod-cart__prise-new\"]"));
//        List<Integer> prices = PCes.stream().map(WebElement::getText).map(x-> x.substring(0,x.indexOf(" "))).map(Integer::parseInt).collect(Collectors.toList());
//        Assert.assertTrue(prices.size()>0);
//        List<Integer> expected = prices.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        Assert.assertEquals(expected, prices);
//        driver.quit();
    }


}
