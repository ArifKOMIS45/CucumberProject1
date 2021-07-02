package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import Utilities.BaseDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class _02_Specials {
    DialogContent dc = new DialogContent();

    @And("^Open the Specials$")
    public void openTheSpecials() {
        dc.findAndClick(DialogContent.PageElemenets.SPECIALS);
    }

    @Then("^Add a product to chart$")
    public void addAProductToChart() {
        Actions aksiyonlar = new Actions(BaseDriver.getDriver());
        Action aksiyon = aksiyonlar.moveToElement(dc.itemTouch).click().build();
        aksiyon.perform();
        dc.findAndClick(DialogContent.PageElemenets.ADDTOCHART);
        dc.findAndClick(DialogContent.PageElemenets.CHECKOUT);

    }

    @Then("^Chart should contain the selected product$")
    public void chartShouldContainTheSelectedProduct() {
        Assert.assertFalse(dc.chart.getText().contains("empty"));

    }

    @When("^Product added then delete it$")
    public void productAddedThenDeleteIt() {
        dc.findAndClick(DialogContent.PageElemenets.DELETEBTN);

    }

    @Then("^Chart should not contain the selected product$")
    public void chartShouldNotContainTheSelectedProduct() {

        Parent.waitUntilVisible(dc.chart);
        dc.findAndContainsText(DialogContent.PageElemenets.CHART, "empty");
    }

    @When("^The product order steps confirmed$")
    public void theProductOrderStepsConfirmed() {
        dc.findAndClick(DialogContent.PageElemenets.CHECKOUT2);
        dc.findAndClick(DialogContent.PageElemenets.CHECKOUT2);
        dc.findAndClick(DialogContent.PageElemenets.AGREE);
        dc.findAndClick(DialogContent.PageElemenets.CHECKOUT3);
        dc.findAndClick(DialogContent.PageElemenets.PAYMENT);
        dc.findAndClick(DialogContent.PageElemenets.CONFIRM);

    }

    @Then("^Order confirmation should be seen$")
    public void orderConfirmationShouldBeSeen() {
        dc.findAndContainsText(DialogContent.PageElemenets.ORDERCOMPLETETEXT,"complete");
    }
}
