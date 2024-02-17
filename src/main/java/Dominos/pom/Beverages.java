package Dominos.pom;

import org.openqa.selenium.By;

public class Beverages {

    public By bev = By.xpath("//span[.='BEVERAGES']");

    public By addBeverages(String beverageName) {
        By bvlocator = By.xpath("//div[@data-label='" + beverageName + "']//descendant::button[@data-label='addTocart']");
        return bvlocator;
    }
}
