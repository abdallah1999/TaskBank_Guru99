import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class first {
    WebDriver driver;

    public static void main(String[] args){

    }
    @BeforeTest
    public void openURL(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.demo.guru99.com/V4/");
    }
    @Test
    public void userCanLoginTestCase1(){
        WebElement lgn_username = driver.findElement(By.name("uid"));
        WebElement lgn_password = driver.findElement(By.name("password"));
        lgn_username.sendKeys("mngr466753");
        lgn_password.sendKeys("hyvaqyx"); // Wrong password

        WebElement btntocheckAlert = driver.findElement(By.name("btnLogin"));
        btntocheckAlert.click();
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("User or Password is not valid",alerttxt);
        alert.accept();
    }

    @Test
    public void userCanLoginTestCase2() {
        WebElement lgn_username = driver.findElement(By.name("uid"));
        WebElement lgn_password = driver.findElement(By.name("password"));
        lgn_username.sendKeys("mngr466752"); // wrong UserId
        lgn_password.sendKeys("hyvaqyz");

        WebElement btntocheckAlert = driver.findElement(By.name("btnLogin"));
        btntocheckAlert.click();
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("User or Password is not valid", alerttxt);
        alert.accept();
    }

    @Test
    public void userCanLoginTestCase3() {
        WebElement lgn_username = driver.findElement(By.name("uid"));
        WebElement lgn_password = driver.findElement(By.name("password"));
        lgn_username.sendKeys("mngr466752"); // wrong UserId
        lgn_password.sendKeys("hyvaqy11");   // Wrong Password

        WebElement btntocheckAlert = driver.findElement(By.name("btnLogin"));
        btntocheckAlert.click();
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("User or Password is not valid", alerttxt);

        alert.accept();
    }
    @Test
    public void userCanLoginTestCase4() {
        WebElement lgn_username = driver.findElement(By.name("uid"));
        WebElement lgn_password = driver.findElement(By.name("password"));
        lgn_username.sendKeys(""); // Empty username
        lgn_password.sendKeys(""); // Empty password

        WebElement btntocheckAlert = driver.findElement(By.name("btnLogin"));
        btntocheckAlert.click();
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("User or Password is not valid", alerttxt);
        alert.accept();
    }
    @Test
    public void userCanLoginTestCase5() {
        WebElement lgn_username = driver.findElement(By.name("uid"));
        WebElement lgn_password = driver.findElement(By.name("password"));
        lgn_username.sendKeys("mngr466753");
        lgn_password.sendKeys(" ");

        WebElement btntocheckAlert = driver.findElement(By.name("btnLogin"));
        btntocheckAlert.click();
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("User or Password is not valid", alerttxt);
        alert.accept();
    }
    @Test
    public void userCanLoginTestCase6() {
        WebElement lgn_username = driver.findElement(By.name("uid"));
        WebElement lgn_password = driver.findElement(By.name("password"));
        lgn_username.sendKeys(""); //empty username
        lgn_password.sendKeys("68585");

        WebElement btntocheckAlert = driver.findElement(By.name("btnLogin"));
        btntocheckAlert.click();
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("User or Password is not valid", alerttxt);
        alert.accept();
    }

    @Test
    public void userCanLoginTestCase7() {
        WebElement lgn_username = driver.findElement(By.name("uid"));
        WebElement lgn_password = driver.findElement(By.name("password"));
        lgn_username.sendKeys("mngr466753");
        lgn_password.sendKeys("hyvaqyz");
        WebElement btnTologn = driver.findElement(By.name("btnLogin"));
        btnTologn.click();

        WebElement logo = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
        Assert.assertTrue(logo.isDisplayed());

    }

        @AfterTest
    public void closeWebBros(){
        driver.quit();
    }
}
