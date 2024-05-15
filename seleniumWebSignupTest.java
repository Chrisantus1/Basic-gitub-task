import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class seleniumWebSignupTest {
    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //.1 Open your chrome browser
        this.driver = new ChromeDriver();
        //.2 Maximize the browser
        this.driver.manage().window().maximize();
        // Test1. Verify the user input the right url and his on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))

        //Pass
        System.out.println("Correct Webpage");
        else
        //Fail
        System.out.println("Wrong Webpage");
        Thread.sleep(5000);

            //.3 Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        this.driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //4. Click on the Signup button to open the Signp page
        this.driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 0 )
    public void negativeSignup() throws InterruptedException {
    //Test3. Verify that user cannot signup with username less than 3 characters
        //5. Input your username on the username field
        this.driver.findElement(By.id("user_username")).sendKeys("Sm");
        Thread.sleep(5000);
        //6.Input your email on the email field
        this.driver.findElement(By.id("user_email")).sendKeys("ronke55@mailinator.com");
        Thread.sleep(5000);
        //7.Locate your password field and input your password on the password field
        this.driver.findElement(By.id("user_password")).sendKeys("Smokeyhot!");
        Thread.sleep(5000);
        //8.Click on the signup button
        this.driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

    }

    @Test ( priority = 3)
    public void InvalidEmailSignup() throws InterruptedException {
    //Test4. Verif that user cannot signup with an invalid email address
    //Input your username on the username field
        this.driver.findElement(By.id("user_username")).sendKeys("Santus");
        // Locate the email address field and Input an email address on the email field
        this.driver.findElement(By.id("user_email")).sendKeys("chrisanctusdagr8@gmail.c");
        Thread.sleep(5000);
        // Locate the password field and Input your password on the username field
        this.driver.findElement(By.id("user_password")).sendKeys("Uchman");
        Thread.sleep(500);
    }

    @Test (priority = 1)
    public void positiveSignup() throws InterruptedException {
      //Test7  Verify that user is successfully signed up when valid details are inputted.
      //Input your username on the username field
       this.driver.findElement(By.id("user_username")).sendKeys("Santus");
        // Locate the email address field and Input an email address on the email field
        this.driver.findElement(By.id("user_email")).sendKeys("chrisanctusdagr8@gmail.com");
        Thread.sleep(5000);
       // Locate the password field and Input your password on the username field
        this.driver.findElement(By.id("user_password")).sendKeys("Uchman");
        Thread.sleep(500);
    }

    @Test (priority = 2)
    public void user1Item() throws InterruptedException {
        //9. Click on User1 item on the listpage
        this.driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
          if(actualUrl.contains(expectedUrl))
          //Pass
          System.out.println("Correct Webpage");
          else
          //Fail
          System.out.println("Wrong Webpage");
          Thread.sleep(5000);
    }
    @Test
    public void verifyItem() throws InterruptedException {
        //10.Test9. Search for an item (Using Python with Selenium) and confirm it is present
        this.driver.findElement(By.xpath("/html/body/div[2]/div[2]")).click();
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct User1Page");
        else
            //Fail
            System.out.println("Wrong User1Page");
        Thread.sleep(5000);
    }
     @Test (priority = 4)
     public void logoutSucessfully() throws InterruptedException {
            //11.Click on logout
            this.driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]")).click();
            Thread.sleep(5000);
            //Test10: Verify that when the user logout, he/she is directed back to the homepage
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            if (expectedTitle.contains(actualTitle))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");
            Thread.sleep(500);
    }

        @AfterTest
        public void closeBrowser(){
        //quit the browser
        driver.quit();
    }
}
