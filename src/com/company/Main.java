package com.company;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Thread.sleep(2000);

        //implicit wait
        browser.navigate().to("https://www.alza.cz/");

        browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement smart = browser.findElement(By.id("nonExistingId"));


        //explicit wait
        WebDriverWait wait = new WebDriverWait(browser, 5);

        wait.until(ExpectedConditions.attributeContains(By.id("id"), "areaExpanded", "true"));

        Function func = x -> browser.findElement(By.id("id")).getAttribute("areaExpanded").equals("true");
        wait.until(func);
    }
}
