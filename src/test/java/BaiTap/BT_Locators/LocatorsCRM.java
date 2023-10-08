package BaiTap.BT_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorsCRM {

    //Login CRM
    public static String headerLoginPage = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";

    //Menu
    public static String menuDashboard = "//span[normalize-space()='Dashboard']";
    public static String menuCustomer = "//span[normalize-space()='Customers']";
    public static String menuProjects = "//span[normalize-space()='Projects']";
    public static String menuTasks = "//span[normalize-space()='Tasks']";

    //Customer List
    public static String buttonAddNewCustomer = "//a[normalize-space()='New Customer']";
    public static String buttonImportCustomer = "//a[normalize-space()='Import Customers']";
    public static String buttonContacts = "//a[contains(@href,'all_contacts')]"; ////a[normalize-space()='Import Customers']/following-sibling::a[normalize-space()='Contacts']
    public static String headerCustomersPage = "//span[normalize-space()='Customers Summary']";
    public static String inputSearchCustomers = "//div[@id='DataTables_Table_0_filter']//input[@type='search']";

    //Add new Customer
    public static String inputCompany = "//input[@id='company']";
    public static String inputVatNumber = "//input[@id='vat']";
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputWebsite = " //input[@id='vat']";
    //public static String dropdownlsitGroup  ="(//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected'])[1]";
    public static String dropdownlsitGroup = "//button[@data-id='groups_in[]']";
    public static String inputSearchGroup = "//div[@app-field-wrapper='groups_in[]']//input[@type='search']";
    public static String dropdownCurrency = "//button[@data-id='default_currency']";
    public static String inputSearchCurrency = "//div[@app-field-wrapper='default_currency']//input[@type='search']";
    public static String dropdownLanguage = "//button[@data-id='default_language']";
    public static String optionVietnamese = "//div[contains(text(),'Vietnamese')]";
    public static String inputAddress = "//textarea[@id='address']";
    public static String inputCity = "//input[@id='city']";
    public static String inputState = "//input[@id='state']";
    public static String inputZipCode = "//input[@id='zip']";
    public static String dropdownCountry = " //button[@data-id='country']";
    public static String inputSearchCountry = "(//div[@app-field-wrapper='country'])//input[@type='search']";
    public static String buttonSaveandCreateContact = "//button[normalize-space()='Save and create contact']";
    public static String buttonSavea = "//div[@id='profile-save-section']//button[normalize-space()='Save']";
    //Project List
    public static String buttonAddNewProject = "//a[normalize-space()='New Project']";
    public static String inputSearchProject ="//div[@id='DataTables_Table_0_filter']//input[@type='search']";

    //Project Add New
    public static String headerAddnewProject="//form[@id='project_form']/descendant::h4[normalize-space()='Add new project']";
    public static String inputProjectName ="//label[@for='name']/following-sibling::input"; //label[normalize-space()='* Project Name']/following-sibling::input
    public static String dropdownCustomer ="//label[@for='clientid']/following-sibling::div//button";
    public static String inputSearchCustomer ="//label[@for='clientid']/following-sibling::div//input";
    public static String inputCustomer ="//label[@for='clientid']/following-sibling::div//input";
    public static String checkboxCalculateProgress = "//input[@id='progress_from_tasks']";
    public static String silderProgress = "//label[contains(text(),'Progress')]/following-sibling::input";
    public static String dropdownBillingType = "//label[@for='billing_type']/following-sibling::div[contains(@class,'dropdown')]";
    public static String optionBillingType = "//span[normalize-space()='Project Hours']";
    public static String dropdownStatus = "//label[normalize-space()='Status']";
    public static String optionStatus = "//span[normalize-space()='On Hold']";
    public static String inputEstimatedHours ="//label[normalize-space()='Estimated Hours']/following-sibling::input";
    public static String dropdownMembers =" //label[normalize-space()='Members']/following-sibling::div/button";
    public static String inputSearchMembers ="//label[normalize-space()='Members']/following-sibling::div//input[@aria-label='Search']";
    public static String inputStartDate ="//label[@for='start_date']/following-sibling::div/input";
    public static String inputDeadline ="//label[@for='deadline']/following-sibling::div/input";
    public static String inputTag ="//label[normalize-space()='Tags']/following-sibling::input";
    public static String inputDescription ="//body[@data-id='description']"; // Cần phải switch sang iframe (học bài 13)
    public static String checkboxSendProject ="//label[normalize-space()='Send project created email']/preceding-sibling::input";
    public static String buttonSaveProject ="//div[@class='panel-footer text-right']/child::button";
    public void selectoptionStatus(String value){
        WebDriver driver = null;
        driver.findElement(By.xpath("//span[normalize-space()='"+value+"']")).click();
    }

}


//- Xpath tương đối (cách 1-5):
//        + Tạo class mới "LocatorsCRM" lưu các xpath sau vào biến String và đặt tên có nghĩa theo UI
//        + Vào website: https://crm.anhtester.com/admin/authentication
//        admin@example.com/123456
//        + Bắt xpath của trang Login
//        + Bắt xpath menu Customer
//        + Bắt xpath hết Form của trang New Customer

//- Xpath tương đối (cách 6-10):
//        + Bắt xpath menu Projects
//        + Bắt xpath hết Form của trang New Project
