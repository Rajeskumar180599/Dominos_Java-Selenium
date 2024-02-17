package Dominos;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\Dominos\\domino\\feature\\Domino.feature", glue = "Dominos\\Stepdefinition", dryRun = false, publish = true)

public class DominoRunner {

}
