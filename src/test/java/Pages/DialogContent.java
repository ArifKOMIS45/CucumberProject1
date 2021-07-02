package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {
    @FindBy(css = ".alert")
    public WebElement chart;
    @FindBy(xpath = "//ul[@class='product_list grid row']/li")
    public WebElement itemTouch;
    WebElement myElement;
    @FindBy(css = ".header_user_info")
    private WebElement signIn;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(xpath = "//span[contains(.,'Sign in')]")
    private WebElement loginButton;
    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageHeading;
    @FindBy(css = "[title='Contact us']")
    private WebElement contactUs;
    @FindBy(id = "id_contact")
    private WebElement subjectHeading;
    @FindBy(xpath = "//span[.='Send']")
    private WebElement sendMsgBtn;
    @FindBy(id = "message")
    private WebElement msgBox;
    @FindBy(css = ".alert")
    private WebElement alertText;
    @FindBy(id = "uniform-id_contact")
    private WebElement selectBox;
    @FindBy(id = "uniform-fileUpload")
    private WebElement fileUpload;
    @FindBy(xpath = "//a[contains(.,'Specials')]")
    private WebElement specials;
    @FindBy(xpath = "//span[.='Add to cart']")
    private WebElement addToChart;
    @FindBy(css = "[title='Proceed to checkout'] > span")
    private WebElement checkOut;
    @FindBy(xpath = "//i[@class='icon-trash']")
    private WebElement deleteBTN;

    @FindBy(xpath = "//span[.='Proceed to checkout']")
    private WebElement checkOut2;

    @FindBy(name = "processCarrier")
    private WebElement checkOut3;

    @FindBy(id = "cgv")
    private WebElement agree;

    @FindBy(css = ".bankwire")
    private WebElement payment;

    @FindBy(xpath = "//span[.='I confirm my order']")
    private WebElement confirm;

    @FindBy(css = "p[class='cheque-indent']>strong[class='dark']")
    private WebElement orderCompleteText;



    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    public void findAndSend(PageElemenets pageElemenets, String value) {
        switch (pageElemenets) {
            case EMAIL:
                myElement = email;
                break;

            case PASSWORD:
                myElement = password;
                break;

            case MSGBOX:
                myElement = msgBox;
                break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(PageElemenets pageElemenets) {
        switch (pageElemenets) {
            case SIGNIN:
                myElement = signIn;
                break;

            case LOGINBUTTON:
                myElement = loginButton;
                break;

            case CONTACTUS:
                myElement = contactUs;
                break;

            case SUBJECTHEADING:
                myElement = subjectHeading;
                break;

            case SENDMSGBTN:
                myElement = sendMsgBtn;
                break;
            case SELECTBOX:
                myElement = selectBox;
                break;
            case FILEUPLOAD:
                myElement = fileUpload;
                break;
            case SPECIALS:
                myElement = specials;
                break;
            case ADDTOCHART:
                myElement = addToChart;
                break;
            case CHECKOUT:
                myElement = checkOut;
                break;
            case ITEMTOUCH:
                myElement = itemTouch;
                break;
            case DELETEBTN:
                myElement = deleteBTN;
                break;

            case CHECKOUT2:
                myElement = checkOut2;
                break;
            case CHECKOUT3:
                myElement = checkOut3;
                break;
            case AGREE:
                myElement = agree;
                break;
            case PAYMENT:
                myElement = payment;
                break;
            case CONFIRM:
                myElement = confirm;
                break;
            case ORDERCOMPLETETEXT:
                myElement = orderCompleteText;
                break;

        }
        clickFunction(myElement);
    }

    public void findAndContainsText(PageElemenets pageElemenets, String msg) {
        switch (pageElemenets) {
            case PAGEHEADING:
                myElement = pageHeading;
                break;

            case ALERTTEXT:
                myElement = alertText;
                break;
            case CHART:
                myElement = chart;
                break;


        }

        verifyContainsText(myElement, msg);
    }


    public void SelectOption(PageElemenets pageElemenets, String value) {
        switch (pageElemenets) {
            case SUBJECTHEADING:
                myElement = subjectHeading;
                break;


        }

        SelectValue(myElement, value);
    }


    public static enum PageElemenets {
        SIGNIN, EMAIL, PASSWORD, LOGINBUTTON, PAGEHEADING, CONTACTUS, SUBJECTHEADING,
        ORDERCOMPLETETEXT,CONFIRM,PAYMENT,AGREE, CHECKOUT3, CHECKOUT2, DELETEBTN, ITEMTOUCH, CHART, CHECKOUT, SENDMSGBTN, MSGBOX, ALERTTEXT, SELECTBOX, FILEUPLOAD, SPECIALS, ADDTOCHART
    }

//    public void findAndDelete(String deleteString){
//        findAndSend("searchInput", deleteString);
//        findAndClick("searchBtn");
//
//        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),10);
//        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"),5));
//        findAndClick("deleteBtn");
//        findAndClick("deleteDialog");
//    }


}
