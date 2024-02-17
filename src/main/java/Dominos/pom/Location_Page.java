package Dominos.pom;

import org.openqa.selenium.By;

public class Location_Page {

    public By delivery_Address = By.xpath("//input[@placeholder='Enter your delivery address']");
    public By pincode = By.xpath("//input[contains(@placeholder,'Enter Area')]");
    public By suggestion = By.xpath("//p[text()='Suggestions']/..//ul/li");


}
