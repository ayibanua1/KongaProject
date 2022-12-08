import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebTest {

    //import the selenium WebDriver
    private WebDriver driver;

    //We want to automate the ordering flow of Konga as an existing customer

    @BeforeTest
    public void startWebPage() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        //2. Input your selected app URL (https://konga.com).
        driver.get("https://konga.com");
        //Test1. Verify user input the right url and is on the  page
        if(driver.getCurrentUrl().contains("https://konga.com"))
        //Pass
        System.out.println("correctwebpage");
        else
        //Fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);

        //3. Maximise the window
        driver.manage().window().maximize();
        //4. Get the page title
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/a/img"));
        //5. Click on Sign-in/Login button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void positivelogin1() throws InterruptedException {
        //Test2. verify that user is unable to login with valid username and password
        //6. Input valid email address
        driver.findElement(By.id("username")).sendKeys("cyndysworld2000@yahoo.co.uk");
        //7. Input valid password
        driver.findElement(By.id("password")).sendKeys("cinderella");
        //8. Click on the Sign in/login/Continue button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    //Test3. Verify that user is able to logout successfully when logout button is clicked
    // Click on logout
    public void pageLogout() throws InterruptedException {
        //Click on account name
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();

        //Logout from the account
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();

        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("User is properly logged out");
        else
            System.out.println("User is not properly logged out");
        Thread.sleep(5000);
    }


    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}