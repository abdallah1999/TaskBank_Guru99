import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;



public class testAddNewCustomer {
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
    public void WaitForAdc(){

        System.out.println("hmmmmmmmm");

        driver.switchTo().activeElement();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card")))).isDisplayed())
        {

            System.out.println("here we Go");
            try {
                WebElement Exitbtn = driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]/div/svg"));
                WebElement Closebtn = driver.findElement(By.id("dismiss-button"));
                Exitbtn.submit();
                Closebtn.submit();
            }
            catch (Exception e){

            }

        }
        System.out.println("Oooooops");


    }

    @Test (priority = 0)
    public void login() {
        WebElement lgn_username = driver.findElement(By.name("uid"));
        WebElement lgn_password = driver.findElement(By.name("password"));
        lgn_username.sendKeys("mngr466753");
        lgn_password.sendKeys("hyvaqyz");
        WebElement btnTologn = driver.findElement(By.name("btnLogin"));
        btnTologn.click();

        WebElement logo1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
        Assert.assertTrue(logo1.isDisplayed());

        WebElement add = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));
        add.click();

    }



    @Test (priority = 1 )
    public void addCustomer_TC0(){
        // input all field with wrong date

        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();



        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("Arwa");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderF.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("0102"); //wrong date


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("Single");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("01125487963");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("abdallah35@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
        //Thread.sleep(5000);
        btnCstSubmit.click();
        //Thread.sleep(3000);

        WebElement wrongDateMess = driver.findElement(By.id("message24"));
        Assert.assertTrue(wrongDateMess.isDisplayed());

    }

    @Test (priority = 2 )
    public void addCustomer_TC1() {
        //Wronge pin number
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("Nada");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderF.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012004");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("Single");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("12345"); //wrong pin number
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("Nada1@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
        //Thread.sleep(5000);
        btnCstSubmit.click();
       // Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();

    }
    @Test (priority = 3 )
    public void addCustomer_TC2()  {
        //empty state
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("Aya");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderF.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012013");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("Aya1@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
       // Thread.sleep(5000);
        btnCstSubmit.click();
        //Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();


    }

    @Test (priority = 4 )
    public void addCustomer_TC3()  {
        //empty name
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderM.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012004");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("Single");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456"); //wrong pin number
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("Ahmed1@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
        //Thread.sleep(5000);
        btnCstSubmit.click();
        //Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();
    }

    @Test (priority = 5 )
    public void addCustomer_TC4()  {
        //empty address
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("Ali");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderM.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012004");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("Single");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456"); //wrong pin number
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("Ali1@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
       // Thread.sleep(5000);
        btnCstSubmit.click();
        //Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();
    }

    @Test (priority = 6 )
    public void addCustomer_TC5()  {
        //Wronge state
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("Joe");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderM.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012004");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("123"); // wrong state
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("Joe1@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
        //Thread.sleep(5000);
        btnCstSubmit.click();
        //Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();

    }

    @Test (priority = 7 )
    public void addCustomer_TC6()  {
        //Wronge Email
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("othman");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderF.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012004");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("married");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("othman@gmail");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
       // Thread.sleep(5000);
        btnCstSubmit.click();
        //Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();




    }
    @Test (priority = 8)
    public void addCustomer_TC7()  {
        //Wronge phone
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("hassan");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderF.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012004");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("married");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("asd");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("hassan@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
       // Thread.sleep(5000);
        btnCstSubmit.click();
        //Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();

    }
    @Test (priority = 9)
    public void addCustomer_TC8()  {
        //Wronge Email
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("othman");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderF.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012004");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("married");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("othman@gmail");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
        // Thread.sleep(5000);
        btnCstSubmit.click();
        //Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();




    }
    @Test (priority = 10)
    public void addCustomer_TC10()  {
        //password
        // to reset all fields before writing
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("hossam");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderF.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("09012004");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 metro Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("married");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0115698634");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("hossam88@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("1");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
       // Thread.sleep(5000);
        btnCstSubmit.click();

        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();
        //here the wrong on is the password
        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();

    }

    @Test (priority = 20 )
    public void addCustomer_TC11()  {
        //Email Address Already Exist

        //to reset all fields data
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("Abdallah");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderM.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("08111999");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("Single");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("abdallah40@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
        btnCstSubmit.click();

        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("Email Address Already Exist !!",alerttxt);
        alert.accept();

    }

    @Test (priority = 20 )
    public void addCustomer_TC12() {
        //valid testCAs

        //to reset all fields data
        WebElement resetbtn = driver.findElement(By.name("res"));
        resetbtn.click();


        WebElement cstname = driver.findElement(By.name("name"));
        cstname.sendKeys("Abdallah");

        WebElement cstGenderM = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement cstGenderF = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        cstGenderM.click();
        WebElement cstdate = driver.findElement(By.name("dob"));
        cstdate.sendKeys("08111999");


        WebElement cstaddress = driver.findElement(By.name("addr"));
        cstaddress.sendKeys("16 Hellwan");
        WebElement cstCity = driver.findElement(By.name("city"));
        cstCity.sendKeys("cairo");
        WebElement cststate = driver.findElement(By.name("state"));
        cststate.sendKeys("Single");
        WebElement cstPin = driver.findElement(By.name("pinno"));
        cstPin.sendKeys("123456");
        WebElement cstPhone = driver.findElement(By.name("telephoneno"));
        cstPhone.sendKeys("0102652478");
        WebElement cstEmail = driver.findElement(By.name("emailid"));
        cstEmail.sendKeys("abdallah50@gmail.com");
        WebElement cstPassword = driver.findElement(By.name("password"));
        cstPassword.sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
        btnCstSubmit.click();

        WebElement customerRegisterSuccessfully = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p"));
        Assert.assertTrue(customerRegisterSuccessfully.isDisplayed());

    }


    @AfterTest
    public void closeWebBros(){
        driver.quit();}

}

     /*

     @FindBy(name ="name")
    WebElement cstname;

    @FindBy(name= "dob")


    @FindBy(name = "city")
    WebElement cstCity;

    @FindBy(name = "state")
    WebElement cstStarte;

    @FindBy(name ="pinno")
    WebElement cstPin;

    @FindBy(name = "telephoneno")
    WebElement cstPhone;

    @FindBy(name = "emailid")
    WebElement cstEmail;

    @FindBy(name = "password")
    WebElement cstPassword;

    @FindBy(name = "sub")
    WebElement btnCstSubmit;


    @FindBy(name = "city")
    WebElement cstCity;

    @FindBy(name = "state")
    WebElement cstStarte;

    @FindBy(name ="pinno")
    WebElement cstPin;

    @FindBy(name = "telephoneno")
    WebElement cstPhone;

    @FindBy(name = "emailid")
    WebElement cstEmail;

    @FindBy(name = "password")
    WebElement cstPassword;

    @FindBy(name = "sub")
    WebElement btnCstSubmit;*/
