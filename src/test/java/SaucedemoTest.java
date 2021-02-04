import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SaucedemoTest {

    @Test
    public void registration() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\IdeaProjects\\untitled2\\src\\main\\resources\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.id("user-name")).sendKeys("problem_user");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        browser.findElement(By.id("login-button")).click();
        boolean entrance = browser.findElement(By.cssSelector(".product_label")).isDisplayed();
        assertTrue(entrance, "Не удалось войти");
        browser.quit();
    }

    @Test
    public void purchase() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\IdeaProjects\\untitled2\\src\\main\\resources\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://www.saucedemo.com/inventory.html");
        browser.findElement(By.xpath("//*[contains(text(),'Sauce Labs" +
                " Fleece Jacket')]/ancestor::div[contains(@class,'inventory_item')]//button")).click();
        browser.findElement(By.xpath("//*[contains(text(),'Sauce Labs " +
                "Bolt T-Shirt')]/ancestor::div[contains(@class,'inventory_item')]//button")).click();
        browser.findElement(By.id("shopping_cart_container")).click();
        int button = browser.findElements(By.xpath("//button[text()='REMOVE']")).size();
        assertEquals(button, 2, "Ошибка в количестве товара");
        browser.quit();
    }
}
