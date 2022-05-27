package pages;

import base.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoursesPage {
    @FindBy(css = "[class='Card_card__2wiJw']")
    private List<WebElement>acaCourses;
    @FindBy(xpath = "//*[@id='__next']/main/div[5]/div/div/div[1]/span/button")
    private WebElement discoverCoursesButton;
    @FindBy(css = "[class='CourseHero_submitBtn__3SrYl Button_button__2cr-Z Button_primary-outlined__1DJzR']")
    private WebElement enrollButton;
    @FindBy(css = "[class='Button_button__2cr-Z Button_primary-fancy-outlined__3LXE3']")
    private WebElement introductionSection;
    @FindBy(css = "[class='Paragraph_paragraph__zRK-x Paragraph_sm__1Dvep Header_lang__Cx5ud']")
    private WebElement language;
    @FindBy(css = "[class='CourseModalForm_wrapper__2rO6G']")
    private WebElement successMessage;
    @FindBy(css = "[data-testid='priceFormSubmitButton']")
    private WebElement login;



    public Helper helper=new Helper();


    public String getSuccessMessage(){
        return successMessage.getText().toUpperCase();
    }
    public CoursesPage discoverCoursesButtonClick(){
       helper.scrollIntoView(discoverCoursesButton);
       discoverCoursesButton.click();
       return this;
    }
    public List<WebElement> getAcaCourses(){
        return acaCourses;
    }

    public CoursesPage selectIntroductionSection(){
        helper.scrollIntoView(introductionSection);
        introductionSection.click();
        return this;
    }
    public CoursesPage setLanguage(){
    helper.scrollIntoView(language);
    language.click();
    return this;
    }
    public CoursesPage setLogin(){
        helper.scrollIntoView(login);
        login.click();
        return this;
    }

}