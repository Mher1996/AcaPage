package realTest;

import base.BaseTest;
import base.Helper;
import dataProvider.DatesDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AcaEnrollPage;
import pages.CoursesPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class EnrollCourses extends BaseTest {
    private List<WebElement> coursesList;
    private AcaEnrollPage acaEnrollPage;
    private CoursesPage coursesPage;
    private Helper helper;


    @BeforeMethod
    public void setUp() {
        getWebDriver().get("https://www.aca.am/");
        getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getWebDriver().manage().window().maximize();
        coursesPage = PageFactory.initElements(getWebDriver(), CoursesPage.class);
        coursesList = coursesPage.getAcaCourses();
        helper = new Helper();
    }

    @Test(testName = "Enroll to Courses", dataProvider = "Indexes", dataProviderClass = DatesDataProvider.class)
    public void enrollCourses(int index) throws InterruptedException {
        final String name = "Mher";
        final String lastName = "Gevorgyan";
        final String phoneNumber = "077121212";
        final String email = "mharyan@gmail.com";
        final String expectedSuccessResponse = "Please check your email" ;
        coursesPage.setLanguage()
                .discoverCoursesButtonClick();
        helper.scrollIntoView(coursesList.get(index));
        coursesList.get(index).click();
        List<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
        acaEnrollPage = PageFactory.initElements(getWebDriver(), AcaEnrollPage.class);
        acaEnrollPage.clickEnrollNow()
                .setNameLastName(name + " " + lastName)
                .setEmail(email)
                .selectCountry()
                .setPhoneNumber(phoneNumber)
                .selectCheckBox()
                .setLogin();
        getWebDriver().close();
        getWebDriver().switchTo().window(tabs.get(0));


        assertTrue(coursesPage.getSuccessMessage().contains(expectedSuccessResponse.toUpperCase()));
    }
}












