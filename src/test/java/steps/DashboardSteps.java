package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
    }

    @Then("user verify the dashboard options available on the page")
    public void user_verify_the_dashboard_options_available_on_the_page(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();

        DashBoardPage dash = new DashBoardPage();
        List<String> actualList = new ArrayList<>();

        for (WebElement ele : dash.dashboardTabs){
            actualList.add(ele.getText());
        }
        System.out.println(actualList);
        System.out.println(expectedTabs);

        Assert.assertTrue(expectedTabs.equals(actualList));
    }

}
