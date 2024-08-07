package com.demo.apitest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_NavData_JPN {
    private Func_JPN mf;
    private WebDriver driver;
    private int Preempt;

    @BeforeClass
    public void beforeClass() throws InterruptedException, IOException {
        // [S]ChromeDriver Settings
        System.setProperty(Data_JPN.chromeDriver_data[0], Data_JPN.chromeDriver_data[1]);
        ChromeOptions chromOptions = new ChromeOptions();
        chromOptions.addArguments(Data_JPN.Chrome_userData);
        chromOptions.addArguments("--lang=ja-JP");
        chromOptions.addArguments("--incognito");
        chromOptions.addArguments("--ignore-certificate-errors");
//		chromOptions.addArguments("window-size=1920, 1080");
        chromOptions.addArguments("window-size=1920, 3000");
        chromOptions.addArguments("--headless");
        driver = new ChromeDriver(chromOptions);
        driver.get(Data_JPN.baseUrl);
        mf = new Func_JPN(driver);
        mf.start_exReport();
        mf.log_message(this.getClass().getName(), "Before Navigate To..." + Data_JPN.baseUrl + "[JPN]");
    }

    // Box info
    public void box_info() throws IOException {
        List<String> info_JPNs = new ArrayList<String>();
        // [A]Go to DEVICE > Settings
        driver.get(Data_JPN.FirmwareSettings_url);
        // [A]Fix Box & SN shows unknown
        mf.wait_element("xpath", Data_JPN.Version_path_01, "Version_path_01");
        // [A]Get info
        String Box_JPN = mf.wait_element("xpath", Data_JPN.Box_path, "Box_JPN").getText();
        String SN_JPN = mf.wait_element("xpath", Data_JPN.SN_path, "SN_JPN").getText();
        String Version_JPN = mf.wait_element("xpath", Data_JPN.Version_path_02, "Version_JPN").getText();
        info_JPNs.add(Box_JPN);
        info_JPNs.add(SN_JPN);
        info_JPNs.add(Version_JPN);
        // [D]Create info >> Excel
        mf.create_info();
        mf.log_message(this.getClass().getName(), "Info created for [JPN]!");
        // [D]Update info >> Excel
        mf.update_info(info_JPNs, 0);
        mf.log_message(this.getClass().getName(), "Info updated for [JPN]!");
    }

    // Actual data
    public List<String> actual_data(String top_menu) throws InterruptedException, IOException {
        List<String> actual_data = new ArrayList<String>();
        // [A]Page redirect
        for (int i = 0; i < Data_JPN.Menu_url.length; i++) {
            if (Data_JPN.Menu_url[i][0].equals(top_menu)) {
                driver.get(Data_JPN.Menu_url[i][1]);
            }
        }

        // [A]Expand page
        mf.wait_element("xpath", Data_JPN.DarkMenu_LeftPane_path, "DarkMenu_LeftPane");
        List<WebElement> Menu_darks = mf.find_elements("xpath", Data_JPN.DarkMenu_LeftPane_path);
        for (WebElement Menu_dark : Menu_darks) {
            mf.js_click(Menu_dark);
        }

        mf.wait_element("xpath", Data_JPN.SubMenu_nested, "SubMenu_nested");
        List<WebElement> Menu_alls = mf.find_elements("xpath", Data_JPN.LeftPane_path);
        actual_data.addAll(mf.expand_menu(Menu_alls, top_menu));
        return actual_data;
    }

    @Test
    public void test_Step01_Login_JPN() throws Exception {
        // [A]Enter "ユーザ名"
        mf.wait_element("xpath", Data_JPN.userName_path, "userName").sendKeys(Data_JPN.login_name);
        // [A]Enter "パスワード"
        mf.wait_element("xpath", Data_JPN.password_path, "password").sendKeys(Data_JPN.login_pass);
        // [A]Click "ログイン"
        mf.js_click(mf.wait_element("xpath", Data_JPN.login_path, "login"));
        mf.log_message(this.getClass().getName(), "Login to main page...");
        // [A]Preempt > "Non-Config" mode
        if (mf.wait_element("xpath", Data_JPN.preempt_path, "Ready to login...") != null) {
            mf.js_click(mf.wait_element("xpath", Data_JPN.preempt_path, "preempt"));
            mf.log_message(this.getClass().getName(), "Preempt the box...");
            Preempt = 1;
        }
    }

    @Test
    public void test_Step02_MenuTop_JPN() throws Exception {
        List<String> actualData = new ArrayList<String>();
        String[] topMenus = { "HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY" };
        // [A]Switch to "Non-Config" mode
        if (Preempt == 0) {
            mf.js_click(mf.wait_element("xpath", Data_JPN.Config_path, "Config"));
            mf.log_message(this.getClass().getName(), "Switch to 'Non-Config' mode...");
        }

        // [D]Create data >> Excel
        mf.create_data();
        mf.log_message(this.getClass().getName(), "Data created for [JPN]!");

        // [A]Access top menu
        for (int i = 0; i < topMenus.length; i++) {
            // [A]Click (e.g. "HOME")
            actualData = actual_data(topMenus[i]);
            // [D]Update data >> Excel
            mf.update_data(actualData, i);
            mf.log_message(this.getClass().getName(), "Data updated for [JPN]!");
            mf.log_message(this.getClass().getName(), "Top menu " + "'" + topMenus[i] + "'" + " is done!");
        }
        // [A]Get Box info
        box_info();

        // [A]Get self-check (JJ check) info
//        System.out.println("Data_JPN.check_list: " + Data_JPN.check_list);
        if (Data_JPN.check_list == 1) {
            if (mf.newMenu_JPN == 0) {
                mf.log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                mf.log_message(this.getClass().getName(), "^          All Matched!          ^");
                mf.log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            } else {
                mf.log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                mf.log_message(this.getClass().getName(), "New data: " + mf.newMenu_JPN);

                for (int i = 0; i < mf.menuInfo_JPN.size(); i++) {
                    mf.log_message(this.getClass().getName(), mf.menuInfo_JPN.get(i));
                }
                mf.log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            }
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        // Take screenshot [Pass] or [Fail]
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            mf.take_screenshot(testResult.getName(), "[PASS]");
            mf.log_message(testResult.getName(), "[Pass]Take screenshot...");
        } else if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = mf.take_screenshot(testResult.getName(), "[FAIL]");
            mf.extent_screenshot(path);
            mf.log_message(testResult.getName(), "[Fail]Take screenshot...");
        }
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        mf.close_exReport();
    }
}