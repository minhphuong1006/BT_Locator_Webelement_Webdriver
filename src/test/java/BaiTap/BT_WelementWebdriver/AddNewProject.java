package Thuchanh;

import common.BaseTest;
import common.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewProject extends BaseTest {

    public void LoginCRM() {
        //driver.get("https://crm.anhtester.com/authentication/login");
        driver.get("https://crm.anhtester.com/admin/authentication");
        //Kiểm tra phải đã vào trang Login chưa ?
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header không tồn tại");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Không đến được trang Dashboard");

    }
    @Test
    public void testAddNewProject() {
        LoginCRM();

        // Menu Projects

        driver.findElement(By.xpath(LocatorCRM.menuProjects)).click();

        // Projects page

        driver.findElement(By.xpath(LocatorCRM.buttonAddNewProject)).click();

        // Add new project page
        // Project tab
        driver.findElement(By.xpath(LocatorCRM.inputProjectName)).sendKeys("Test Project 01");

        driver.findElement(By.xpath(LocatorCRM.dropdownCustomer)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomer)).sendKeys("Customer006");
        sleep(10);
        //driver.findElement(By.xpath(LocatorCRM.inputSearchCustomer)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.optionCustomer)).click();
        sleep(3);
        driver.findElement(By.xpath(LocatorCRM.dropdownBillingType )).click();
        driver.findElement(By.xpath(LocatorCRM.optionBillingType)).click();

        driver.findElement(By.xpath(LocatorCRM.dropdownStatus)).click();
        driver.findElement(By.xpath(LocatorCRM.optionStatus)).click();

        driver.findElement(By.xpath(LocatorCRM.inputTotalRate)).sendKeys("10%");

        driver.findElement(By.xpath(LocatorCRM.inputEstimatedHours)).sendKeys("8");

        driver.findElement(By.xpath(LocatorCRM.dropdownMembers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchMembers)).click();

        driver.findElement(By.xpath(LocatorCRM.inputStartDate)).clear();
        driver.findElement(By.xpath(LocatorCRM.inputStartDate)).sendKeys("25-07-2023");

        driver.findElement(By.xpath(LocatorCRM.inputDeadline)).sendKeys("30-07-2023");

       // driver.findElement(By.xpath(LocatorCRM.inputTag)).sendKeys("Automation Test");
        //driver.findElement(By.xpath(LocatorCRM.optionTags)).click();

        driver.findElement(By.xpath(LocatorCRM.checkboxSendProject)).click();

//        // Project Settings tab
        driver.findElement(By.xpath(LocatorCRM.tabProjectSettings)).click();

        driver.findElement(By.xpath(LocatorCRM.dropdownSendContactsNotifications)).click();
        driver.findElement(By.xpath(LocatorCRM.optionSendContactsNotifications)).click();

        driver.findElement(By.xpath(LocatorCRM.dropdownVisibleTabs)).click();
        driver.findElement(By.xpath(LocatorCRM.buttonDeselectAll)).click();
        driver.findElement(By.xpath(LocatorCRM.buttonSelectAll)).click();

        driver.findElement(By.xpath(LocatorCRM.checkboxHideTasks)).click();

        driver.findElement(By.xpath(LocatorCRM.buttonSaveProject)).click();

        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.labelsuccessful)).getText(), "Project added successfly", "Chưa thấy thông báo tạo thành công");
        sleep(3);

        driver.quit();




    }

}
