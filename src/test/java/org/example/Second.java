package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Second {


    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\IdeaProjects\\MavenGitTestNG\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); неявное ожидание, стараться не юзать

    }

    @AfterClass
    public void finish() {
        driver.quit();

    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.by");
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.click();
        searchField.sendKeys("java");
        searchField.sendKeys(Keys.ENTER);

        WebElement resault = waiter(By.xpath("//cite[contains(text(), 'https://www.java.com')]/../../h3[text()='Загрузка Java " +
                "для всех операционных систем']"));

       // WebElement result = new WebDriverWait(driver, Duration.ofSeconds(10))
              //  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//cite[contains(text(), 'https://www.java.com')]/../../h3[text()='Загрузка Java " +
                 //       "для всех операционных систем']")));

        //WebElement resault = driver.findElement(By.xpath("//cite[contains(text(), 'https://www.java.com')]/../../h3[text()='Загрузка Java для всех операционных систем']"));


        Assert.assertTrue(resault.isDisplayed());
    }

    private void getSleap() {


        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("you have exception");
        }

    }

    private WebElement waiter(By by) {
        WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));

        return el;

    }
}
