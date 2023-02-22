package runners;
//this runner class is responsible for running only failed test cases

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "@target/failed.txt",
        glue = "steps",
        //when you set dry run to true, it stops actual execution
        //it will quickly scan all the gherkin steps whether they are implemented or not
        //when we set dry run to false, it starts execution again
       // dryRun = false,
        //tags = "@tc1101",
        //to remove irrelevant information from console, you need to set monochrome to true
        monochrome = true,
        //pretty keywords prints the steps in the console to increase readability
        //to generate the reports we need plugin of runner class
        plugin = {"pretty" }
)//this failed.txt file calls all scenarios that failed during execution
//pretty is kept bec it'll give us details in the console.

public class FailedRunner {
}
