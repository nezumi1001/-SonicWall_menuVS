package com.demo.apitest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.demo.apitest.Test_NavData_ENG;

public class Func_ENG {
    private WebDriver driver;
    private WebElement we;
    private List<WebElement> ges;
    private String main_handle;
    private Actions ac;
    //    private String class_name = Test_NavData_ENG.class.getName();
    private String class_name = "TEST";
    private Logger log = LogManager.getLogger(class_name);
    private File my_path = new File(System.getProperty("user.dir"));
    private ExtentReports exReport;
    private ExtentTest exTest;

    private String start_exReport = "\\src\\main\\resources\\Log\\report\\ExReport_ENG.html";
    private String take_screenshot = "\\src\\main\\resources\\Screenshot\\Image\\";

    private String create_info_path = "\\src\\main\\resources\\Data\\info";
    private String create_info_Stream = "\\src\\main\\resources\\Data\\info\\info_ENG.xls";

    private String create_data_path = "\\src\\main\\resources\\Data\\compare";
    private String create_data_Stream = "\\src\\main\\resources\\Data\\compare\\Box_ENG.xls";


    public Func_ENG(WebDriver driver) {
        this.driver = driver;
    }

    // Page source
    public void page_source() {
        String pageSrc = driver.getPageSource();
        log_message(class_name, pageSrc);
        driver.quit();
    }

    // Start > Extent report
    public void start_exReport() {
        exReport = new ExtentReports(my_path + start_exReport);
        exTest = exReport.startTest("Menu Test > [ENG]");
    }

    // End > Extent report
    public void close_exReport() {
        exReport.endTest(exTest);
        exReport.flush();
    }

    // Log message[S]
    public void log_message(String test_name, String info) {
        log.info(test_name + " > " + info);
        exTest.log(LogStatus.INFO, test_name + " > " + info);
        Reporter.log("[S]ReportLog >> " + test_name + " > " + info, true);
    }

    // Date time
    public String date_time() {
        DateFormat dateformat = new SimpleDateFormat("yyMMdd_HHmm");
        Date my_date = new Date();
        String my_date2 = dateformat.format(my_date);
        return my_date2;
    }

    // Take screenshot
    public String take_screenshot(String file_name, String pass_fail) throws Exception {
        file_name = pass_fail + file_name + "_" + date_time() + ".png";
        String file_path = my_path + take_screenshot;
        File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src_file, new File(file_path + file_name));
        String file_all = file_path + file_name;
        return file_all;
    }

    // Add screenshot > extent report
    public void extent_screenshot(String path) {
        String img_path = exTest.addScreenCapture(path);
        exTest.log(LogStatus.FAIL, "[Failed]", img_path);
    }

    // Mouse action
    public void mouse_action(WebElement item, int option) {
        if (option == 1) {
            ac = new Actions(driver);
            ac.moveToElement(item).perform();
        } else if (option == 2) {
            ac.moveToElement(item).click().perform();
        }
    }

    // Switch iframe
    public void switch_iframe(int option, String type) {
        if (option == 1) {
            if (type.equals("0")) {
                driver.switchTo().frame(0);
            } else if (type.equals("id")) {
                driver.switchTo().frame("id");
            } else if (type.equals("name")) {
                driver.switchTo().frame("name");
            }
        } else if (option == 0) {
            driver.switchTo().defaultContent();
        }
    }

    // Switch windows
    public void switch_window(int option) {
        // Get main window
        if (option == 1) {
            main_handle = driver.getWindowHandle();
        } else if (option == 2) {
            Set<String> all_handles = driver.getWindowHandles();
            for (String handle : all_handles) {
                if (!handle.equals(main_handle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        } else if (option == 0) {
            driver.switchTo().window(main_handle);
        }

    }

    // Wait element
    public WebElement wait_element(String type, String path, String msg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            if (type.equals("id")) {
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
            } else if (type.equals("name")) {
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(path)));
            } else if (type.equals("class")) {
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(path)));
            } else if (type.equals("xpath")) {
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
            }
        } catch (Exception e) {
            log_message(class_name, "Element Not Found!" + " >> " + msg);
            return null; // keep running
        }
        return we;
    }

    // Find elements
    public List<WebElement> find_elements(String type, String path) {
        try {
            if (type.equals("id")) {
                ges = driver.findElements(By.id(path));
            } else if (type.equals("name")) {
                ges = driver.findElements(By.name(path));
            } else if (type.equals("class")) {
                ges = driver.findElements(By.className(path));
            } else if (type.equals("xpath")) {
                ges = driver.findElements(By.xpath(path));
            }
        } catch (Exception e) {
            log_message(class_name, "Elements Not Found!" + " >> " + "All missing");
        }
        return ges;
    }

    // JS click
    public void js_click(WebElement parent_menu) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", parent_menu);
    }

    // Expand menu
    public List<String> expand_menu(List<WebElement> expand_Menus, String top_menu) throws InterruptedException {
        List<String> actual_data = new ArrayList<String>();

        // Add menu ENG
        for (WebElement expand_Menu_text : expand_Menus) {
            actual_data.add(expand_Menu_text.getText());
            log_message(class_name, "'" + top_menu + "'" + " Menu: " + expand_Menu_text.getText());
        }

        // --- Change duplicated menu >> xx (TOP) ---
        log_message(class_name, "========================================================================");
        if (top_menu.equals("DEVICE") || top_menu.equals("OBJECT")) {
            for (int j = 0; j < actual_data.size(); j++) {
                // "DEVICE > Settings" >> "DEVICE > Settings (TOP)"
                if (actual_data.get(j).equals("Settings") && actual_data.get(j + 1).equals("Licenses")) {
                    actual_data.set(j, "Settings (TOP)");
                    log_message(class_name, "'" + top_menu + "'" + " Menu: " + "Settings >> Settings (TOP)");
                }
                // "Object > Match Objects" >> "Object > Match Objects (TOP)"
                if (actual_data.get(j).equals("Match Objects") && actual_data.get(j + 1).equals("Zones")) {
                    actual_data.set(j, "Match Objects (TOP)");
                    log_message(class_name, "'" + top_menu + "'" + " Menu: " + "Match Objects >> Match Objects (TOP)");
                }
            }
        } else {
            log_message(class_name, "'" + top_menu + "'" + " Menu: " + "No duplicated data to the TOP");
        }

        // [T] Sub menu text
        log_message(class_name, "========================================================================");
        log_message(class_name, "ALL MENU: " + actual_data.size());

        return actual_data;
    }

    // Create data (info)
    public void create_info() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ENG");
        // Create 100 row
        for (int new_row = 0; new_row < 3; new_row++) {
            sheet.createRow(new_row);
        }
        // Create .\\Data\\info folder if not exists
//        File file_compare = new File(my_path + "\\src\\main\\resources\\Data\\info");
        File file_compare = new File(my_path + create_info_path);

        if (!file_compare.exists()) {
            file_compare.mkdir();
        }
        // Write data
//        FileOutputStream out = new FileOutputStream(my_path + "\\src\\main\\resources\\Data\\info\\info_ENG.xls");
        FileOutputStream out = new FileOutputStream(my_path + create_info_Stream);

        workbook.write(out);
        out.close();
        workbook.close();
    }

    // Update data (info)
    public void update_info(List<String> info_list, int menu_column) throws IOException {
//        FileInputStream fs = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\info\\info_ENG.xls");
        FileInputStream fs = new FileInputStream(my_path + create_info_Stream);

        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheet("ENG");
        HSSFRow row = null;
        // Input data
        for (int i = 0; i < info_list.size(); i++) {
            row = sheet.getRow(i);
            row.createCell(menu_column).setCellValue(info_list.get(i));
        }
        // Auto column
        for (int auto_column = 0; auto_column < row.getLastCellNum(); auto_column++) {
            sheet.autoSizeColumn(auto_column);
        }
        // Write data
//        FileOutputStream out = new FileOutputStream(my_path + "\\src\\main\\resources\\Data\\info\\info_ENG.xls");
        FileOutputStream out = new FileOutputStream(my_path + create_info_Stream);

        workbook.write(out);
        out.close();
        workbook.close();
    }

    // Create data (menu)
    public void create_data() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ENG");
        // Create 100 row
        for (int new_row = 0; new_row < 100; new_row++) {
            sheet.createRow(new_row);
        }
        // Create .\\Data\\compare folder if not exists
//        File file_compare = new File(my_path + "\\src\\main\\resources\\Data\\compare");
        File file_compare = new File(my_path + create_data_path);

        if (!file_compare.exists()) {
            file_compare.mkdir();
        }
        // Write data
//        FileOutputStream out = new FileOutputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_ENG.xls");
        FileOutputStream out = new FileOutputStream(my_path + create_data_Stream);

        workbook.write(out);
        out.close();
        workbook.close();
    }

    // Update data (menu)
    public void update_data(List<String> MENU_list, int menu_column) throws IOException {
//        FileInputStream fs = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_ENG.xls");
        FileInputStream fs = new FileInputStream(my_path + create_data_Stream);

        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheet("ENG");
        HSSFRow row = null;
        // Input data
        for (int i = 0; i < MENU_list.size(); i++) {
            row = sheet.getRow(i);
            row.createCell(menu_column).setCellValue(MENU_list.get(i));
        }
        // Auto column
        for (int auto_column = 0; auto_column < row.getLastCellNum(); auto_column++) {
            sheet.autoSizeColumn(auto_column);
        }
        // Write data
//        FileOutputStream out = new FileOutputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_ENG.xls");
        FileOutputStream out = new FileOutputStream(my_path + create_data_Stream);

        workbook.write(out);
        out.close();
        workbook.close();
    }

}
