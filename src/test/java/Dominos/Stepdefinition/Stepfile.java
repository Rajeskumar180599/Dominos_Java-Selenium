package Dominos.Stepdefinition;

import Dominos.base.Base_Class;
import Dominos.pom.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class Stepfile extends Base_Class {

    public static Home_Page home_page = new Home_Page();
    public static Location_Page location_page = new Location_Page();
    public static Vegpizza_Page vegpizza_page = new Vegpizza_Page();
    public static Beverages beverages = new Beverages();
    public static Cart cart = new Cart();


    @Given("user opens the {string} and Login to the Dominos website")
    public void user_opens_the_and_Login_to_the_Dominos_website(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromoptions = new ChromeOptions();
            chromoptions.addArguments("incognito");
            driver = new ChromeDriver(chromoptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions fo = new FirefoxOptions();
            // fo.addArguments("private");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions edgeoptions = new EdgeOptions();
            edgeoptions.addArguments("InPrivate");
            driver = new EdgeDriver(edgeoptions);

        }

        driver.get("https://www.dominos.co.in/");
        log("Dominos page launched");
        Maximize(driver);
    }

    @When("user enter the address and select the first suggestion")
    public void user_enter_the_address_and_select_the_first_suggestion() throws InterruptedException {
        driver.findElement(home_page.order_Online).click();
        log("order online button clicked");
        explicitWait(driver.findElement(location_page.delivery_Address), driver);
        driver.findElement(location_page.delivery_Address).click();
//        explicitWait(driver.findElement(location_page.pincode), driver);
        Thread.sleep(5000);
        driver.findElement(location_page.pincode).sendKeys(("600044"));
//        explicitWait(driver.findElement(location_page.suggestion),driver);
        Thread.sleep(5000);
        driver.findElement(location_page.suggestion).click();
        log("Address entered");
    }

    @When("user add the Farmhouse {string} and count {string} in the cartitems")
    public void user_add_the_farmhouse_and_count_in_the_cartitems(String productname, String count) throws InterruptedException {
//        explicitWait(driver.findElement(vegpizza_page.veg_Pizza),driver);
        Thread.sleep(5000);
        jsClick(driver.findElement(vegpizza_page.veg_Pizza), driver);
        log("Choosing the vegpizza menu");
        By addcart = vegpizza_page.addCartProduct(productname);
        jsClick(driver.findElement(addcart), driver);
        driver.findElement(vegpizza_page.noThanks).click();
        for (int i = 1; i <= Integer.parseInt(count); i++) {
            By qty = vegpizza_page.productqty(productname, "increase");
            jsClick(driver.findElement(qty), driver);
        }
        log(productname + " adding the minicart");
    }

    @When("user add the Margherita {string} and count {string} in the cartitems")
    public void user_add_the_margherita_and_count_in_the_cartitems(String productname, String count) {

        By addcart = vegpizza_page.addCartProduct(productname);
        jsClick(driver.findElement(addcart), driver);
        jsClick(driver.findElement(vegpizza_page.addCartProduct(productname)), driver);
        for (int i = 1; i <= Integer.parseInt(count); i++) {
            By productqty = vegpizza_page.productqty(productname, "increase");
            jsClick(driver.findElement(productqty), driver);
        }
        log(productname + " adding the minicart");
    }

    @When("user add the Peppy Paneer {string} and count {string} in the cartitems")
    public void user_add_the_peppy_paneer_and_count_in_the_cartitems(String productname, String count) {
        jsClick(driver.findElement(vegpizza_page.addCartProduct(productname)), driver);
        for (int i = 1; i <= Integer.parseInt(count); i++) {
            By productqty = vegpizza_page.productqty(productname, "increase");
            jsClick(driver.findElement(productqty), driver);
        }
        log(productname + " adding the minicart");
    }

    @Then("user check the cart subtotal")
    public void user_check_the_cart_subtotal() {
        int totalprice = 0;
        List<WebElement> productprices = driver.findElements(vegpizza_page.productprices);
        for (WebElement element : productprices) {
            String text = element.getText();
            double doublevalue = Double.parseDouble(text);
            int intvalue = (int) doublevalue;
            totalprice = totalprice + intvalue;
        }

        String texttotal = driver.findElement(vegpizza_page.subtotal).getText();
        double doublevalue = Double.parseDouble(texttotal);
        int subtotal = (int) doublevalue;
        Assert.assertEquals(totalprice, subtotal);
        log("Subtotal amount is = " + subtotal + " verifed succesfully");

    }

    @Then("user add the beverage {string} and count {string} in the cartitems")
    public void user_add_the_beverage_and_count_in_the_cartitems(String productname, String count) {
        jsClick(driver.findElement(beverages.bev), driver);
        log("Choosing the beverages menu");
        By addbve = beverages.addBeverages(productname);
        jsClick(driver.findElement(addbve), driver);
        for (int i = 1; i <= Integer.parseInt(count); i++) {
            By productqty = vegpizza_page.productqty(productname, "increase");
            jsClick(driver.findElement(productqty), driver);
        }
        log(productname + " adding the minicart");
    }

    @Then("user remove {string} the qty of Margherita {string}")
    public void user_remove_the_qty_of_margherita(String count, String productname) {
        jsClick(driver.findElement(vegpizza_page.veg_Pizza), driver);
        By productqty = vegpizza_page.productqty(productname, "decrease");
        jsClick(driver.findElement(productqty), driver);
        log(productname + " removed ");

    }

    @Then("user remove {string} the qty of beverage {string}")
    public void user_remove_the_qty_of_beverage(String count, String productname) {
        jsClick(driver.findElement(beverages.bev), driver);
        for (int i = 1; i <= Integer.parseInt(count); i++) {
            jsClick(driver.findElement(vegpizza_page.veg_Pizza), driver);
            By productqty = vegpizza_page.productqty(productname, "decrease");
            jsClick(driver.findElement(productqty), driver);

        }
        log(productname + " removing " + count + " times");

    }

    @Then("user get the subtotal and click checkout")
    public void user_get_the_subtotal_and_click_checkout() {
        int totalprice = 0;
        List<WebElement> productprices = driver.findElements(vegpizza_page.productprices);
        for (WebElement element : productprices) {
            String text = element.getText();
            double doublevalue = Double.parseDouble(text);
            int intvalue = (int) doublevalue;
            totalprice = totalprice + intvalue;
        }
        log("Ordered price is = " + totalprice);
        String text = driver.findElement(vegpizza_page.subtotal).getText();
        double doublevalue = Double.parseDouble(text);
        int subtotal = (int) doublevalue;
        log("Subtotal price is = " + subtotal);
        Assert.assertEquals(totalprice, subtotal);
        log("Ordered price and subtotal price are equal");
        driver.findElement(cart.checkoutbtn).click();
        log("Checkout successfully");
        quit();
        log("Driver closed successfully");
    }

}
