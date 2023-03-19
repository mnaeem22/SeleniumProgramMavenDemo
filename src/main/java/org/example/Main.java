package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args){

        ChromeOptions co =new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");

        //Login Page
        WebElement userNameTextField = driver.findElement(By.name("userName"));
        userNameTextField.sendKeys("test");
        WebElement passwordTextField = driver.findElement(By.name("password"));
        passwordTextField.sendKeys("test");
        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();
        //Dashboard
        WebElement successMessageHeading = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3"));
        String actualSuccessMessageHeadingText = successMessageHeading.getText();
        String expectedSuccessMessageHeadingText = "Login Successfully";
        if (actualSuccessMessageHeadingText.contains(expectedSuccessMessageHeadingText)){
            System.out.println("Test is pass");
        }
        else {
            System.out.println("Test is fail");
        }
        driver.quit();
    }
}