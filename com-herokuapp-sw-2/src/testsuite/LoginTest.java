package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        //Enter “tomsmith” username
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='username']"));
        userNameField.sendKeys("tomsmith");

        // * Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");

        // * Click on ‘LOGIN’ button
        WebElement loginField = driver.findElement(By.xpath("//button[@type='submit']"));
        loginField.click();

        // * Verify the text “Secure Area”
        WebElement actualText = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        actualText.getText();

        //expected Text
        String expectedText = "Secure Area";
        Assert.assertEquals(expectedText,actualText);


    }

    @Test
    public void verifyTheUsernameErrorMessage(){

        // * Enter “tomsmith1” username
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='username']"));
        userNameField.sendKeys("tomsmith1");

        // * Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");

        // * Click on ‘LOGIN’ button
        WebElement loginField = driver.findElement(By.xpath("//button[@type='submit']"));
        loginField.click();

        // * Verify the error message “Your username is invalid!”
        String expectedText =" Your username is invalid!\n";

        //Find the error message
        String actualText = driver.findElement(By.xpath("//div[@id = 'flash-messages']")).getText();
        Assert.assertEquals(expectedText,actualText); // verify expected and actual text

    }

    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='username']"));
        userNameField.sendKeys("tomsmith");

        // * Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");

        // * Click on ‘LOGIN’ button
        WebElement loginField = driver.findElement(By.xpath("//button[@type='submit']"));
        loginField.click();

        // * Verify the error message “Your username is invalid!”
        String expectedText =" Your username is invalid!\n";

        //Find the error message
        String actualText = driver.findElement(By.xpath("//div[@id = 'flash-messages']")).getText();
        Assert.assertEquals(expectedText,actualText); // verify expected and actual text
    }

    @After
    public void tearTown(){
        closeBrowser(); // close browser method
    }

}
