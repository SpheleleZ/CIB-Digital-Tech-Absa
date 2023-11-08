package org.cib.digital.tech.absa.web.pages;

import io.cucumber.java.eo.Se;
import org.cib.digital.tech.absa.web.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserListTablePage {
    private final WebDriver driver;

    private final WaitHelper waitHelper;

    @FindBy( xpath = "//span[text()=\"First Name\"]")
    @CacheLookup
    WebElement userListPage;

    @FindBy( xpath = "//button[text()=\" Add User\"]")
    @CacheLookup
    WebElement addUserButton;

    @FindBy( name = "FirstName")
    @CacheLookup
    WebElement firstNameInputField;

    @FindBy( name = "LastName")
    @CacheLookup
    WebElement lastNameInputField;

    @FindBy( name = "UserName")
    @CacheLookup
    WebElement userNameInputField;

    @FindBy( name = "Password")
    @CacheLookup
    WebElement passwordInputField;

    @FindBy( xpath = "(//input[@type=\"radio\"])[1]")
    @CacheLookup
    WebElement customerFieldAAA;
    @FindBy( xpath = "(//input[@type=\"radio\"])[2]")
    @CacheLookup
    WebElement customerFieldBBB;

    @FindBy( xpath = "//select[@name=\"RoleId\"]")
    @CacheLookup
    WebElement selectRole;

    @FindBy( name = "Email")
    @CacheLookup
    WebElement emailInputField;

    @FindBy( name = "Mobilephone")
    @CacheLookup
    WebElement cellPhoneInputField;

    @FindBy( xpath = "//button[text()=\"Save\"]")
    @CacheLookup
    WebElement saveUserButton;

    @FindBy( xpath = "(//td[@class=\"smart-table-data-cell\"])[1]")
    @CacheLookup
    WebElement verifyUserAdded;



    public UserListTablePage(WebDriver driver){
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean setUserListPage(){
        waitHelper.WaitForElement(userListPage,20);
        return userListPage.isDisplayed();
    }

   public void setAddUserButton(){
        waitHelper.WaitForElement(addUserButton,20);
        addUserButton.click();
   }

   public void setFirstNameInputField(String fname){
        waitHelper.WaitForElement(firstNameInputField,20);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(fname);
   }

   public void setLastNameInputField(String lname){
        waitHelper.WaitForElement(lastNameInputField,20);
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lname);
   }

   public void setUserNameInputField(String username){
        waitHelper.WaitForElement(userNameInputField,20);
        userNameInputField.clear();
        userNameInputField.sendKeys(username);
   }

   public void setPasswordInputField(String password){
        waitHelper.WaitForElement(passwordInputField,20);
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
   }

   public void setCustomerField(String customer){
        if(customer.contains("Company AAA")){
            waitHelper.WaitForElement(customerFieldAAA,20);
            customerFieldAAA.click();
        }else if(customer.contains("Company BBB")){
            waitHelper.WaitForElement(customerFieldBBB,20);
            customerFieldBBB.click();
        }
   }

   public void setSelectRole(String role){
        waitHelper.WaitForElement(selectRole,20);
       Select selectRoles = new Select(selectRole);
       selectRoles.selectByVisibleText(role);
   }

   public void setEmailInputField(String email){
        waitHelper.WaitForElement(emailInputField,20);
        emailInputField.clear();
        emailInputField.sendKeys(email);
   }

   public void setCellPhoneInputField(String cell){
        waitHelper.WaitForElement(cellPhoneInputField,20);
        cellPhoneInputField.clear();
        cellPhoneInputField.sendKeys(cell);
   }

   public void setSaveUserButton(){
        waitHelper.WaitForElement(saveUserButton,20);
        saveUserButton.click();
   }

   public boolean setVerifyUserAdded(String firstName){
        String fname;
        waitHelper.WaitForElement(verifyUserAdded,20);
        fname = verifyUserAdded.getText();
       return fname.contentEquals(firstName);
   }
}
