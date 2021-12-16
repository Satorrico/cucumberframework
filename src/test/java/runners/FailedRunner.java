package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        //glue is where we can find the implementation for gherkin steps
        //here we provide the path of our steps package
        glue = "steps",
        //dryRun = false,
        // stops implemented methods execution and runs only unimplemented steps
        // if we set dryRun to true , then no actual execution happens
        // it will quickly scan all gherkin steps whether they have implementation or not
        monochrome = true,
        // it will re/move all the unreadable character
        //tags =  "@error",
        plugin = {"pretty"}
        //plugin - we use it to generate report for the execution
        // pretty - it takes care of printing the steps in console
        // strict = true, it checks all the steps definition
)

public class FailedRunner {

}
