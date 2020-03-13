package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPage {
    private WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By TXT_SEARCH_PRODUCT = By.xpath("//*[@id='twotabsearchtextbox']");
    By BTN_SEARCH = By.xpath("//*[@id='nav-search']/form/div[2]/div/input");
    By SPN_RESULT = By.xpath("//*[@id='search']/span/span/h1/div/div[1]/div/div/span[3]");
    By LNK_LANG = By.id("icp-nav-flyout");
    By RBT_LANG_ENG;
    By LNK_TODAY = By.xpath("//*[@id='nav-xshop']/a[1]");

    public void gotoUrl(String url) {
        driver.get(url);
    }

    public void clickBtnSearch() {
        driver.findElement(BTN_SEARCH).click();
    }

    public void writeProduct(String product) {
        driver.findElement(TXT_SEARCH_PRODUCT).sendKeys(product);
    }

    public String getTextResult() {
        return driver.findElement(SPN_RESULT).getText();
    }

    public String getTextToday() {
        return driver.findElement(LNK_TODAY).getText();
    }

    public void toSelectListLanguage() {
        WebElement webElement = driver.findElement(LNK_LANG);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
    }

    public void clickRbtnLangEng(String idioma) {
        String lang;
        switch (idioma.toUpperCase()) {
            case "INGLES":
                lang = "//*[@id='nav-flyout-icp']/div[2]/a[1]";
                break;
            case "ESPANIOL":
                lang = "//*[@id='nav-flyout-icp']/div[2]/a[2]";
                break;
            case "PORTUGUES":
                lang = "//*[@id='nav-flyout-icp']/div[2]/a[4]";
                break;
            default:
                lang = "INVALIDO";
        }
        RBT_LANG_ENG = By.xpath(lang);
        driver.findElement(RBT_LANG_ENG).click();
    }
}