package realTest;

import base.BaseTest;
import base.Helper;
import dataProvider.DatesDataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AcaEnrollPage;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class AcaEnrollTest extends BaseTest {
    private AcaEnrollPage acaEnrollPage;
    private Helper helper;

    @BeforeMethod
    public void setUp() {
        getWebDriver().get("https://www.aca.am/");
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        getWebDriver().manage().window().maximize();
        acaEnrollPage = PageFactory.initElements(getWebDriver(), AcaEnrollPage.class);
        helper = new Helper();
    }

    @Test(testName = "Enroll test")
    public void setAcaEnrollTest() throws InterruptedException {
        final String name = "Mher";
        final String lastName = "Gevorgyan";
        final String phoneNumber = "077121212";
        final String email = "mharyan@gmail.com";
        final String successResponse="Շնորհակալություն: Խնդրում ենք ստուգել Ձեր էլ. փոստը։";
        acaEnrollPage.clickEnrollNow()
                .setNameLastName(name + " " + lastName)
                .setEmail(email)
                .selectCountry()
                .setPhoneNumber(phoneNumber)
                .selectCheckBox()
                .setLogin();
        assertTrue(acaEnrollPage.getEnrollWindow().getText().contains(successResponse), "Grancumy hajoxvel e");
    }

    @Test(testName = "Invalid Emails", dataProvider = "InvalidEmails", dataProviderClass = DatesDataProvider.class)
    public void emailValidation(String invalidEmail) {
        final String name = "Mher";
        final String lastName = "Gevorgyan";
        final String phoneNumber = "077121212";
        acaEnrollPage.clickEnrollNow()
                .setNameLastName(name + " " + lastName)
                .setEmail(invalidEmail)
                .setPhoneNumber(phoneNumber);

        assertTrue(acaEnrollPage.isEmailErrorDisplayed());

    }



}
