package pages;

import base.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AcaEnrollPage {
    @FindBy(css = "[class='Button_button__2cr-Z Button_primary__3JJIb']")
    private WebElement enrollNowButton;
    @FindBy(css = "[data-testid='priceModalName']")
    private WebElement nameLastNameField;
    @FindBy(css = "[id='priceModalEmail']")
    private WebElement emailField;
    @FindBy(css ="[data-testid='countryCode'] li")
    private List<WebElement> drpCountries;
    @FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/div[3]/div[1]")
    private WebElement countries;
    @FindBy(css = "[data-testid='priceModalPhone']")
    private WebElement phoneNumber;
    @FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/label/span")
    private WebElement agreementCheckBox;
    @FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/span/button")
    private WebElement loginButton;
    @FindBy(css = "[class='MainModalForm_wrapper__M_UyW']")
    private WebElement alert;
    @FindBy(css = "[class='MainModalForm_form__1CD2p'] h2")
    private WebElement enrollWindow;


    public Helper helper = new Helper();


    public AcaEnrollPage clickEnrollNow() {
        helper.scrollIntoView(enrollNowButton, false);
        enrollNowButton.click();
        return this;
    }
    public AcaEnrollPage setNameLastName(String nameAndLastName){
        helper.scrollIntoView(nameLastNameField);
        nameLastNameField.click();
        nameLastNameField.clear();
        nameLastNameField.sendKeys(nameAndLastName);
        return this;
    }
    public AcaEnrollPage setEmail(String userEmail){
        helper.scrollIntoView(emailField);
        emailField.click();
        emailField.clear();
        emailField.sendKeys(userEmail);
        return this;
    }
    public AcaEnrollPage selectCountry() throws InterruptedException {
        helper.scrollIntoView(countries);
        countries.click();
        drpCountries.get(11).click();
        Thread.sleep(300);
        return  this;
    }
    public AcaEnrollPage setPhoneNumber(String phoneNumberText){
        helper.scrollIntoView(phoneNumber);
        phoneNumber.click();
        phoneNumber.clear();
        phoneNumber.sendKeys(phoneNumberText);
        return this;
    }

    public boolean isEmailErrorDisplayed(){
        String errorMessage="Input_inputError";
        return emailField.getAttribute("class").contains("Input_inputError");
    }
    public AcaEnrollPage selectCheckBox(){
        helper.scrollIntoView(agreementCheckBox);
        agreementCheckBox.click();
        return this;
    }
    public AcaEnrollPage setLogin(){
        helper.scrollIntoView(loginButton);
        loginButton.click();
        return this;
    }
    public WebElement getEnrollWindow(){
        return enrollWindow;
    }








}
