package Thuchanh;

import common.BaseTest;
import common.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddNewCustomer extends BaseTest {

    String COMPANY_NAME = "Minh Phương1";
    String CONTACTS_NAME = "Phương";

    public void LoginCRM() {
        //driver.get("https://crm.anhtester.com/authentication/login");
        driver.get("https://crm.anhtester.com/admin/authentication");
        //Kiểm tra phải đã vào trang Login chưa ?
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header không tồn tại");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Không đến được trang Dashboard");

    }

    @Test
    public void testAddNewCustomer() {
        LoginCRM();

        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Không đến được trang Customer");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Tên header Customer page không đúng");
        sleep(1);

        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();
        //Add New Customer
        driver.findElement(By.xpath(LocatorCRM.inputCompany)).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).sendKeys("10");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("0336727019");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://crm.anhtester.com/");
        sleep(1);
        //Dropdown List
        driver.findElement(By.xpath(LocatorCRM.dropdownlsitGroup)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys("COMPANY-AA");
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.dropdownlsitGroup)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.dropdownCurrency)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCurrency)).sendKeys("USD");
        driver.findElement(By.xpath(LocatorCRM.inputSearchCurrency)).sendKeys(Keys.ENTER);
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).click();
        driver.findElement(By.xpath(LocatorCRM.optionVietnamese)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Thủ Đức");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("HCM");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Độc Thân");
        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("Zip Code");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.dropdownCountry)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("Vietnam");
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        //Save form Add New Customer
        driver.findElement(By.xpath(LocatorCRM.buttonSaveCustomer)).click();
        sleep(2);

        //Search lại Customer vừa Add
        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        //Verify xem customer vừa add đã tồn tại chưa
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Không tìm thấy phần tử");

        sleep(1);

        //Kiểm tra giá trị sau khi add New Customer
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompany)).getAttribute("value"), COMPANY_NAME, "Giá trị company vừa add không khớp");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"), "https://crm.anhtester.com/", "Giá trị phone vừa add không khớp");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"), "https://crm.anhtester.com/", "Giá trị Website vừa add không khớp");

        softAssert.assertAll();
    }

    @Test
    public void AddNewContactForCustomer() {
        LoginCRM();
        //Click menu
        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Không đến được trang Customer");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Tên header Customer page không đúng");
        sleep(1);

        //Search lại Customer vừa Add
        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        //Verify xem customer vừa add đã tồn tại chưa
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Không tìm thấy phần tử");
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        sleep(2);
        driver.findElement(By.xpath(LocatorCRM.menuContact)).click();
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).getText(), "Contacts", "Tên header Customer page không đúng");
        driver.findElement(By.xpath(LocatorCRM.buttonAddNewContact)).click();
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).isDisplayed(), "Không tìm thấy title dialog Contact");

        //Upload file:
        // để dùng được cái hàm sendkey của selenium để update file thì đó phải là 1 thẻ input và có type = file thì mới upload lên được
        //System.getProperty("user.dir") : đoạn code lấy thư mục ngời dùng hiện tại tính từ ổ đĩa trong máy tính tới thư mục
        sleep(2);
        //driver.findElement(By.xpath(LocatorCRM.inputProfileImage)).sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\DataTest\\profile_contact.jpg");
        setText(LocatorCRM.inputProfileImage, System.getProperty("user.dir") + "\\src\\test\\resources\\DataTest\\profile_contact.jpg");
        sleep(2);
        setText(LocatorCRM.inputFirstname, CONTACTS_NAME);
        setText(LocatorCRM.inputLastname, "Trần");
        setText(LocatorCRM.inputPositon, "test");
        setText(LocatorCRM.inputEmailContact, "qc@gmail.com");
        setText(LocatorCRM.inputPhoneContact, "123456789");
        setText(LocatorCRM.inputPasswordContact, "123456");
        clickElement(LocatorCRM.checkboxDoNotSendEmail);
        clickElement(LocatorCRM.buttonSaveContact);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).isDisplayed(), "Failed. Không phải header của contacts.");
        clickElement(LocatorCRM.inputSearchContact);
        setText(LocatorCRM.inputSearchContact, CONTACTS_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Failed. Không tìm thấy Contacts đã nhập.");
        clickElement(LocatorCRM.firstItemCustomerOnTable);
        //Click vào dữ liệu và check lại thông tin sau khi add new contacts success
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputFirstname)).getAttribute("value"), CONTACTS_NAME, "Failes. FistName name not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputLastname)).getAttribute("value"), "Pham", "Failes. LastName not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputEmailContact)).getAttribute("value"), "qctest1995@gmail.com", "Failes. Email not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPasswordContact)).getAttribute("value"), "123456", "Failes.Password not match.");

        softAssert.assertAll();
    }
}
