import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginTests {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = getDriver();
    }

    //T1: Login with invalid credentials and check error message
    @Test
    public void canNotLoginWithInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("im.valid.user", "no.such.thing");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Sorry, your password was incorrect. Please double-check your password.");

    }

    //T2: Login with empty username and check error message
    @Test
    public void canNotLoginWithEmptyUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login(" ","no_such_thing");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "The username you entered doesn't belong to an account. Please check your username and try again.");
    }

    //T3: Login successfully and check if you are navigated to the homepage
    @Test
    public void SuccessfullyLoggedIn() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("im.valid.user", "no_such_thing");
        assertTrue(new HomePage(driver).isLoaded());
    }


    private WebDriver getDriver()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
        return new ChromeDriver();
    }

    @After
    public  void teardown()
    {
        driver.quit();
    }

}