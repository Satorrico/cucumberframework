package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(dash.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, "Noor13");
        sendText(addEmployeePage.midName, "007breakmanager12");
        sendText(addEmployeePage.lastName, "khan11");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.saveBtn);

    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeID.clear();
    }

    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.createLoginCheckbox);
    }

    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.createUsername, "hello123");
        sendText(addEmployeePage.createPassword, "Hum@nhrm123");
        sendText(addEmployeePage.reEnterPassword, "Hum@nhrm123");
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.midName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @And("user enters {string} {string} and {string} for an employee")
    public void userEntersAndForAnEmployee(String firstName, String middleName, String lastName) {
        AddEmployeePage aep = new AddEmployeePage();
        sendText(aep.firstName, firstName);
        sendText(aep.midName, middleName);
        sendText(aep.lastName, lastName);
    }

    @When("I add multiple employees and verify them user has been added successfully")
    public void i_add_multiple_employees_and_verify_them_user_has_been_added_successfully(DataTable employees) throws InterruptedException {

        List<Map<String, String>> employeesNames = employees.asMaps();

        for(Map<String, String> employeeName: employeesNames){
            String valueFirstName = employeeName.get("firstName");
            String valueMiddleName = employeeName.get("middleName");
            String valueLastName = employeeName.get("lastName");


            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firstName, valueFirstName);
            sendText(addEmployeePage.midName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);

            click(addEmployeePage.saveBtn);



            DashBoardPage dash = new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);

        }
    }

    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        DashBoardPage dash = new DashBoardPage();
        AddEmployeePage add = new AddEmployeePage();

        Iterator<Map<String, String>> it = newEmployees.iterator();
        while (it.hasNext()){
            Map<String,String> mapNewEmp = it.next();
            sendText(add.firstName, mapNewEmp.get("FirstName"));
            sendText(add.midName, mapNewEmp.get("MiddleName"));
            sendText(add.lastName, mapNewEmp.get("LastName"));
            click(add.saveBtn);

            //asssertion in HW
        }
    }
}