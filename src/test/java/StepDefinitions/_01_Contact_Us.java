package StepDefinitions;

import Pages.DialogContent;
import Utilities.BaseDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class _01_Contact_Us {
    DialogContent dc = new DialogContent();

    @Given("^Navigate to Webpage$")
    public void navigateToWebpage() {
        WebDriver driver = BaseDriver.getDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @When("^Enter username and password and click login button$")
    public void login() {
        dc.findAndClick(DialogContent.PageElemenets.SIGNIN);
        dc.findAndSend(DialogContent.PageElemenets.EMAIL, "arifkom@gmail.com");
        dc.findAndSend(DialogContent.PageElemenets.PASSWORD, "123456");
        dc.findAndClick(DialogContent.PageElemenets.LOGINBUTTON);
    }

    @Then("^User should login successfully$")
    public void loginSuccessfully() {
        dc.findAndContainsText(DialogContent.PageElemenets.PAGEHEADING, "My account");
    }

    @And("^Open the ContactUs$")
    public void openTheContactUs() {

        dc.findAndClick(DialogContent.PageElemenets.CONTACTUS);
    }

    @When("^Selecting Customer service from Subject Head$")
    public void selectingCustomerServiceFromSubjectHead() {

        dc.findAndClick(DialogContent.PageElemenets.SELECTBOX);
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),10);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.id("uniform-id_contact"),2));
        dc.SelectOption(DialogContent.PageElemenets.SUBJECTHEADING, "2");
    }

    @And("^Adding email$")
    public void addingEmail() {
        dc.findAndSend(DialogContent.PageElemenets.EMAIL, "arifkomisaas@gmail.com");
    }

    @Then("^Send Message$")
    public void sendMessage() {
        dc.findAndClick(DialogContent.PageElemenets.SENDMSGBTN);
    }

    @Then("^Add mesage to box$")
    public void addMesageToBox() {
        dc.findAndSend(DialogContent.PageElemenets.MSGBOX, "Karadir kaslarin");

    }

    @Then("^Message should be send successfully$")
    public void mesaggeShouldBeSendSuccessfully() {
        dc.findAndContainsText(DialogContent.PageElemenets.ALERTTEXT, "success");


    }

    @Then("^Message should be send Cannot be blank$")
    public void messageShouldBeSendCannotBeBlank() {
        dc.findAndContainsText(DialogContent.PageElemenets.ALERTTEXT, "blank");

    }

    @And("^Add file$")
    public void addFile() throws AWTException {
        dc.findAndClick(DialogContent.PageElemenets.FILEUPLOAD);

        StringSelection stringSelection = new StringSelection("C:\\Users\\chem\\Desktop\\formulabalance.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot rbt = new Robot();

        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_V);

        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_V);

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);


    }


}
