package ua.avic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class AvicSingInPage {
    private final WebDriver driver;

    public AvicSingInPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//main[@class=\"main  sign-in-page category--in\"]//input[@class=\"validate\"]")
    private WebElement phoneField;
    @FindBy(xpath = "//main[@class=\"main  sign-in-page category--in\"]//input[@class=\"validate show-password\"]")
    private WebElement passField;
    @FindBy(xpath = "//button[contains(text(), 'Увійти')]")
    private WebElement enterButton;
//    @FindBy(xpath = "//div[contains(text(), 'Невірні')]")
//    private WebElement warning;
    //public By phoneField = By.xpath("//main[@class=\"main  sign-in-page category--in\"]//input[@class=\"validate\"]");
//    public By passField = By.xpath("//main[@class=\"main  sign-in-page category--in\"]//input[@class=\"validate show-password\"]");
//    public By enterButton = By.xpath("//button[contains(text(), 'Увійти')]");
     public By warnings = By.xpath("//div[contains(text(), 'Невірні')]");



    public AvicSingInPage enterPhoneNumber(String number) {
        phoneField.sendKeys(number);
        return this;
    }
    public AvicSingInPage enterPassword(String pass) {
        passField.sendKeys(pass);
        return this;
    }

    public AvicSingInPage clickEnterButton() {
        enterButton.click();
        return this;
    }

    public AvicSingInPage navigateTo() {
        driver.manage().window().maximize();
        driver.get("https://avic.ua/ua/sign-in");
        return this;
    }
    public void close() {
        driver.close();
    }
    public boolean IfWarningIsPresent () {
        return driver.findElements(warnings).size()>0;
    }

}
