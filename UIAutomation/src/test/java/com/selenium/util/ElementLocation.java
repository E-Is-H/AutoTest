package com.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementLocation {
    // 把八大元素定位封装起来,供Baidosearch类调用使用

    public static WebElement locate(WebDriver webDriver, String locatetype , String loactepath) throws Exception{

        WebElement webElement=null;
        WebDriverWait webDriverWait=new WebDriverWait(webDriver,30);
        if (locatetype.equals("id")){

            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(loactepath)));
            webElement=webDriver.findElement(By.id(loactepath));

        }else  if (locatetype.equals("name")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name(loactepath)));
            webElement=webDriver.findElement(By.name(loactepath));

        }else  if (locatetype.equals("xpath")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(loactepath)));
            webElement=webDriver.findElement(By.xpath(loactepath));

        }else  if (locatetype.equals("className")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className(loactepath)));
            webElement=webDriver.findElement(By.className(loactepath));

        }else  if (locatetype.equals("tagName")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(loactepath)));
            webElement=webDriver.findElement(By.tagName(loactepath));

        }else  if (locatetype.equals("linkText")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.linkText(loactepath)));
            webElement=webDriver.findElement(By.linkText(loactepath));

        }else  if (locatetype.equals("partialLinkText")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(loactepath)));
            webElement=webDriver.findElement(By.partialLinkText(loactepath));

        }else  if (locatetype.equals("cssSelector")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loactepath)));
            webElement=webDriver.findElement(By.cssSelector(loactepath));

        }else{
            System.out.println("元素定位失败......");
        }

        return webElement;
    }
}
