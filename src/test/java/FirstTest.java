import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;


public class FirstTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/sign_in");

        //1-я проверка(логин)
        driver.findElement(By.id("session_email")).sendKeys("vaflya@mail.ru");
        driver.findElement(By.id("session_password")).sendKeys("888888888");
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);


        //2-я проверка(Добавление адреса)
        driver.findElement(By.cssSelector("[data-test=addresses]")).click();
        driver.findElement(By.cssSelector("[data-test=create]")).click();
        driver.findElement(By.id("address_first_name")).sendKeys("111");
        driver.findElement(By.id("address_last_name")).sendKeys("111");
        driver.findElement(By.id("address_street_address")).sendKeys("111");
        driver.findElement(By.id("address_city")).sendKeys("111");
        driver.findElement(By.id("address_zip_code")).sendKeys("111");
        driver.findElement(By.cssSelector("[name=commit]")).click();
        driver.findElement(By.xpath("//a[contains( text(),'List')]")).click();
        Thread.sleep(2000);


        //3-я проверка(Изменение адреса)
        driver.findElement(By.xpath("//a[contains( text(),'Edit')]")).click();
        driver.findElement(By.id("address_first_name")).clear();
        driver.findElement(By.id("address_first_name")).sendKeys("Василий");
        driver.findElement(By.id("address_last_name")).clear();
        driver.findElement(By.id("address_last_name")).sendKeys("Пупкин");
        driver.findElement(By.id("address_street_address")).clear();
        driver.findElement(By.id("address_street_address")).sendKeys("Магистральная");
        driver.findElement(By.id("address_city")).clear();
        driver.findElement(By.id("address_city")).sendKeys("Москва");
        driver.findElement(By.id("address_zip_code")).clear();
        driver.findElement(By.id("address_zip_code")).sendKeys("222666");
        driver.findElement(By.cssSelector("[name=commit]")).click();
        driver.findElement(By.xpath("//a[contains( text(),'List')]")).click();
        Thread.sleep(2000);

        //4-я проверка(Удаление адерса)
        driver.findElement(By.xpath("//a[contains( text(),'Destroy')]")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //5-я проверка(Выход пользователя)
        driver.findElement(By.xpath("//a[contains( text(),'Sign out')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}




