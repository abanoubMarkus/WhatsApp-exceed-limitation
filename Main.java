package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class Main {
    public static void main(String[] args)  {

        // allow chrome to run in pre opened session using chrome options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","localhost:9222");
        WebDriver driver = new ChromeDriver(options);

        //declare the waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        //defining actions class
        Actions a = new Actions(driver);

        // u can add the names of every person in this array
        String[] names = {"test2","testb","testm","test1","testa","testreh"};




//some of the webElement we can declare once,
// but other webElement are dynamiclly changing so we had to define them in the for loop
        WebElement searchButton = driver.findElement(By.xpath("//*[@class='_ai04']"));


        // iterate for each name in the array
        for (String name : names) {


            //you can adjust your message as you, like
            String message = "HBD and your name is      " + name + " <3";
            //wait
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            //click with action class
            a.moveToElement(searchButton).click().build().perform();
            //sendKeys using action class
             a.moveToElement(searchButton).sendKeys(name).build().perform();


             //wait
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='_ah_w']")));
            WebElement contact = driver.findElement(By.xpath("//*[@class='_ak8q']"));
            a.moveToElement(contact).click().build().perform();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='_ak1l']")));
            WebElement typo = driver.findElement(By.xpath("//*[@class='_ak1l']"));

            typo.sendKeys(message);
            WebElement sendButton = driver.findElement(By.xpath("//*[@data-icon='send']"));

            sendButton.click();


        }





}



}

