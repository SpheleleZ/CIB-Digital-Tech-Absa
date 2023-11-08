package org.cib.digital.tech.absa.web.steps;
import io.cucumber.java.en.*;
import org.cib.digital.tech.absa.web.base.BaseTest;
import org.cib.digital.tech.absa.web.pages.UserListTablePage;

import static org.junit.jupiter.api.Assertions.*;

public class UserListTableSteps extends BaseTest {

    UserListTablePage userListTablePage;

    @Given("^browser is launched$")
    public void browser_is_launched() {
     setUpMethod();
    }

    @And("User List table {string} page is open")
    public void user_list_table_page_is_open(String url) {
        openPage(url);
    }

    @Then("^Validate user list table$")
    public void validate_user_list_table() {
        userListTablePage = new UserListTablePage(driver);
        assertTrue(userListTablePage.setUserListPage(),"User list page not open");
    }

    @And("^click on add user$")
    public void click_on_add_user() {
       userListTablePage.setAddUserButton();
    }


    @When("^enters  (.*) and (.*) and (.*) then (.*)$")
    public void enters_and_and_then(String fname,String lname,String username,String password) {
        userListTablePage.setFirstNameInputField(fname);
        userListTablePage.setLastNameInputField(lname);
        userListTablePage.setUserNameInputField(username);
        userListTablePage.setPasswordInputField(password);
    }
    @And("^select (.*) and (.*) and (.*) also (.*)$")
    public void select_and_and_also(String customer,String role,String email,Integer cell) {
        userListTablePage.setCustomerField(customer);
        userListTablePage.setSelectRole(role);
        userListTablePage.setEmailInputField(email);
        userListTablePage.setCellPhoneInputField(cell);
    }

    @Then("^click on save$")
    public void click_on_save() {
      userListTablePage.setSaveUserButton();
    }
}
