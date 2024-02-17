package Dominos.pom;

import org.openqa.selenium.By;

public class Vegpizza_Page {
    public By veg_Pizza = By.xpath("//div[@data-label='Veg Pizza']//child::span[text()='VEG PIZZA']");
    public By noThanks = By.xpath("//span[text()='NO THANKS']");
    public By productprices = By.xpath("//span//ancestor::div[@class='crt-cnt']//following-sibling::div[@class='crt-cnt-qty-prc']//descendant::span[@class='rupee']");
    public By subtotal = By.xpath("//span[@data-label='total-minicart']");

    public By addCartProduct(String productName) {
        By locator = By.xpath("(//div[contains(@data-label,'" + productName + "')]//button)[2]");
        return locator;
    }

    public By productqty(String productName, String count) {
        By pqlocator = By.xpath("//span[.='" + productName + "']//ancestor::div[@class='crt-cnt']//following-sibling::div[@class='crt-cnt-qty-prc']//child::div//descendant::div//child::div[@data-label='" + count + "']");
        return pqlocator;
    }
}
