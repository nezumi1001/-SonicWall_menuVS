package com.demo.apitest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

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
import java.util.Objects;

public class Func_ZHT {
    public int newMenu_ZHT = 0;
    public List<String> menuInfo_ZHT = new ArrayList<>();
    private final WebDriver driver;
    private WebElement we;
    private List<WebElement> ges;
    private final Logger log = LogManager.getLogger("");
    private final File my_path = new File(System.getProperty("user.dir"));
    private ExtentReports exReport;
    private ExtentTest exTest;
    private final String START_EXREPORT = "\\src\\main\\resources\\Log\\report\\ExReport_ZHT.html";
    private final String TAKE_SCREENSHOT = "\\src\\main\\resources\\Screenshot\\Image\\";
    private final String CREATE_INFO_PATH = "\\src\\main\\resources\\Data\\info";
    private final String CREATE_INFO_STREAM = "\\src\\main\\resources\\Data\\info\\info_ZHT.xls";
    private final String CREATE_DATA_PATH = "\\src\\main\\resources\\Data\\compare";
    private final String CREATE_DATA_STREAM = "\\src\\main\\resources\\Data\\compare\\Box_ZHT.xls";

    public Func_ZHT(WebDriver driver) {
        this.driver = driver;
    }

    // Start > Extent report
    public void start_exReport() {
        exReport = new ExtentReports(my_path + START_EXREPORT);
        exTest = exReport.startTest("Menu Test > [ZHT]");
    }

    // End > Extent report
    public void close_exReport() {
        exReport.endTest(exTest);
        exReport.flush();
    }

    // Log message[S]
    public void log_message(String class_name, String info) {
        // log4j
        log.info("{} > {}", class_name, info);
        // extentreports
        exTest.log(LogStatus.INFO, class_name + " > " + info);
        // TestNG output
        Reporter.log("[S]ReportLog >> " + class_name + " > " + info, true);
    }

    // Date time
    public String date_time() {
        DateFormat dateformat = new SimpleDateFormat("yyMMdd_HHmm");
        Date my_date = new Date();
        return dateformat.format(my_date);
    }

    // Take screenshot
    public String take_screenshot(String file_name, String pass_fail) throws Exception {
        file_name = pass_fail + file_name + "_" + date_time() + ".png";
        String file_path = my_path + TAKE_SCREENSHOT;
        File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src_file, new File(file_path + file_name));
        return file_path + file_name;
    }

    // Add screenshot > extent report
    public void extent_screenshot(String path) {
        String img_path = exTest.addScreenCapture(path);
        exTest.log(LogStatus.FAIL, "[Failed]", img_path);
    }

    // Wait element
    public WebElement wait_element(String type, String path, String msg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            switch (type) {
                case "id" -> we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
                case "name" -> we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(path)));
                case "class" -> we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(path)));
                case "xpath" -> we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
            }
        } catch (Exception e) {
            log_message(this.getClass().getName(), "Element Not Found!" + " >> " + msg);
            return null; // keep running
        }
        return we;
    }

    // Find elements
    public List<WebElement> find_elements(String type, String path, String msg) {
        try {
            switch (type) {
                case "id" -> ges = driver.findElements(By.id(path));
                case "name" -> ges = driver.findElements(By.name(path));
                case "class" -> ges = driver.findElements(By.className(path));
                case "xpath" -> ges = driver.findElements(By.xpath(path));
            }
        } catch (Exception e) {
            log_message(this.getClass().getName(), "Element Groups Not Found!" + " >> " + msg);
        }
        return ges;
    }

    // JS click
    public void js_click(WebElement parent_menu) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", parent_menu);
    }

    // Expand menu
    public List<String> expand_menu(List<WebElement> expand_Menus) {
        List<String> actual_data = new ArrayList<>();

        // Switch menu ZHT > ENG
        for (WebElement expand_Menu_text : expand_Menus) {
            actual_data.add(switch_menu(expand_Menu_text.getText()));
        }

        // [T] Sub menu text
        log_message(this.getClass().getName(), "========================================================================");
        log_message(this.getClass().getName(), "ALL MENU: " + actual_data.size());

        return actual_data;
    }

    // Create data (info)
    public void create_info() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ZHT");
        // Create 3 row
        for (int new_row = 0; new_row < 3; new_row++) {
            sheet.createRow(new_row);
        }
        // Create .\\Data\\info folder if not exists
        File file_compare = new File(my_path + CREATE_INFO_PATH);
        if (!file_compare.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file_compare.mkdirs();
        }
        // Write data
        FileOutputStream out = new FileOutputStream(my_path + CREATE_INFO_STREAM);
        workbook.write(out);
        out.close();
        workbook.close();
    }

    // Update data (info)
    public void update_info(List<String> info_list, int menu_column) throws IOException {
        FileInputStream fs = new FileInputStream(my_path + CREATE_INFO_STREAM);
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheet("ZHT");
        HSSFRow row = null;
        // Input data
        for (int i = 0; i < info_list.size(); i++) {
            row = sheet.getRow(i);
            row.createCell(menu_column).setCellValue(info_list.get(i));
        }
        // Auto column
        for (int auto_column = 0; auto_column < Objects.requireNonNull(row).getLastCellNum(); auto_column++) {
            sheet.autoSizeColumn(auto_column);
        }
        // Write data
        FileOutputStream out = new FileOutputStream(my_path + CREATE_INFO_STREAM);
        workbook.write(out);
        out.close();
        workbook.close();
    }

    // Create data (menu)
    public void create_data() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ZHT");
        // Create 100 row
        for (int new_row = 0; new_row < 300; new_row++) {
            sheet.createRow(new_row);
        }
        // Create .\\Data\\compare folder if not exists
        File file_compare = new File(my_path + CREATE_DATA_PATH);
        if (!file_compare.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file_compare.mkdirs();
        }
        // Write data
        FileOutputStream out = new FileOutputStream(my_path + CREATE_DATA_STREAM);
        workbook.write(out);
        out.close();
        workbook.close();
    }

    // Update data (menu)
    public void update_data(List<String> MENU_list) throws IOException {
        FileInputStream fs = new FileInputStream(my_path + CREATE_DATA_STREAM);
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheet("ZHT");
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        HSSFRow row = null;
        HSSFCell cell;

        // Input data
        for (int i = 0; i < MENU_list.size(); i++) {
            row = sheet.getRow(i);
            cell = row.createCell(0);

            // Set (NEW) menus in RED color
            if (MENU_list.get(i).contains("NEW")) {
                font.setColor((short) 2);
                titleStyle.setFont(font);
                cell.setCellStyle(titleStyle);
            }
            cell.setCellValue(MENU_list.get(i));
        }

        // Auto column
        for (int auto_column = 0; auto_column < Objects.requireNonNull(row).getLastCellNum(); auto_column++) {
            sheet.autoSizeColumn(auto_column);
        }
        // Write data
        FileOutputStream out = new FileOutputStream(my_path + CREATE_DATA_STREAM);
        workbook.write(out);
        out.close();
        workbook.close();
    }

    // VS menu
    public String switch_menu(String text_ZHT) {
        String text_update = null;
        String[][] leftPane = null;

        leftPane = Data_JPN.leftPane_ALL;

        // Check list for ZHT > ZHT
        if (Data_ZHT.check_list == 1) {
            int i;
            for (i = 0; i < Objects.requireNonNull(leftPane).length; i++) {
                if (leftPane[i][0].equals(text_ZHT)) {
                    text_update = text_ZHT;
                    break;
                }
            }

            // Found new menu
            if (i >= leftPane.length) {
                text_update = "(NEW) " + text_ZHT;
                newMenu_ZHT += 1;
                menuInfo_ZHT.add(" Menu: " + text_update);
            }
            log_message(this.getClass().getName(), " Menu: " + text_update);
        }

        // Check list for ZHT > ENG
        if (Data_ZHT.check_list == 0) {
            for (String[] strings : Objects.requireNonNull(leftPane)) {
                if (strings[0].equals(text_ZHT)) {
                    text_update = strings[1];
                    break;
                }
            }
            log_message(this.getClass().getName(), " Menu: " + text_ZHT + " >> " + text_update);
        }

        return text_update;
    }

}
