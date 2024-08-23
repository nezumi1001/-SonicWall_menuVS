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

public class Test_NavData_ENG {
    private Func_ENG mf;
    private WebDriver driver;
    private int Preempt;

    @BeforeClass
    public void beforeClass() {
        // [S]JJ > JE, ZZ > ZE
        Data_JPN.check_list = 0;
        Data_ZHT.check_list = 0;
        // [S]ChromeDriver Settings
        System.setProperty(Data_ENG.chromeDriver_data[0], Data_ENG.chromeDriver_data[1]);
        ChromeOptions chromOptions = new ChromeOptions();
        chromOptions.addArguments(Data_ENG.Chrome_userData);
        chromOptions.addArguments("--lang=en-US");
        chromOptions.addArguments("--incognito");
        chromOptions.addArguments("--ignore-certificate-errors");
//		chromOptions.addArguments("window-size=1920, 1080");
        chromOptions.addArguments("window-size=1920, 3000");
        chromOptions.addArguments("--headless");
        driver = new ChromeDriver(chromOptions);
        driver.get(Data_ENG.baseUrl);
        mf = new Func_ENG(driver);
        mf.start_exReport();
        mf.log_message(this.getClass().getName(), "Before Navigate To..." + Data_ENG.baseUrl + "[ENG]");
    }

    // Box info
    public void box_info() throws IOException {
        List<String> info_ENGs = new ArrayList<>();
        // [A]Go to DEVICE > Settings
        driver.get(Data_ENG.FirmwareSettings_url);
        // [A]Fix Box & SN shows unknown
        mf.wait_element("xpath", Data_ENG.CurrentFirmwareVersion, "Current Firmware Version");
        // [A]Get info
        String Box_ENG = mf.wait_element("xpath", Data_ENG.Box_name, "Box_ENG").getText();
        String SN_ENG = mf.wait_element("xpath", Data_ENG.SN_name, "SN_ENG").getText();
        String Version_ENG = mf.wait_element("xpath", Data_ENG.FirmwareVersion, "Version_ENG").getText();
        info_ENGs.add(Box_ENG);
        info_ENGs.add(SN_ENG);
        info_ENGs.add(Version_ENG);
        // [D]Create info >> Excel
        mf.create_info();
        mf.log_message(this.getClass().getName(), "Info created for [ENG]!");
        // [D]Update info >> Excel
        mf.update_info(info_ENGs, 0);
        mf.log_message(this.getClass().getName(), "Info updated for [ENG]!");
    }

    // Actual data
    public List<String> actual_data(String top_menu) {
        // [A]Page redirect
        for (int i = 0; i < Data_ENG.Menu_url.length; i++) {
            if (Data_ENG.Menu_url[i][0].equals(top_menu)) {
                driver.get(Data_ENG.Menu_url[i][1]);
            }
        }

        // [A]Expand page
        mf.wait_element("xpath", Data_ENG.DarkMenu_LeftPane_path, "DarkMenu_LeftPane");
        List<WebElement> Menu_darks = mf.find_elements("xpath", Data_ENG.DarkMenu_LeftPane_path, "Dark menu on leftpane");
        for (WebElement Menu_dark : Menu_darks)
            mf.js_click(Menu_dark);
        mf.wait_element("xpath", Data_ENG.SubMenu_nested, "SubMenu_nested");
        List<WebElement> Menu_alls = mf.find_elements("xpath", Data_ENG.LeftPane_path, "All menu on leftpane");
//        actual_data.addAll(mf.expand_menu(Menu_alls, top_menu)); // option 1
//        List<String> actual_data = new ArrayList<>(mf.expand_menu(Menu_alls, top_menu)); // option 2
//        return actual_data;
        return new ArrayList<>(mf.expand_menu(Menu_alls, top_menu));
    }

    @Test
    public void test_Step01_Login_ENG() {
        // [A]Enter Username
        mf.wait_element("xpath", Data_ENG.userName_path, "userName").sendKeys(Data_ENG.login_name);
        // [A]Enter Password
        mf.wait_element("xpath", Data_ENG.password_path, "password").sendKeys(Data_ENG.login_pass);
        // [A]Click LOGIN
        mf.js_click(mf.wait_element("xpath", Data_ENG.login_path, "login"));
        mf.log_message(this.getClass().getName(), "Login to main page...");
        // [A]Preempt > "Non-Config" mode
        if (mf.wait_element("xpath", Data_ENG.preempt_path, "Ready to login...") != null) {
            mf.js_click(mf.wait_element("xpath", Data_ENG.preempt_path, "preempt"));
            mf.log_message(this.getClass().getName(), "Preempt the box...");
            Preempt = 1;
        }
    }

    @Test
    public void test_Step02_MenuTop_ENG() throws Exception {
//        List<String> actualData = new ArrayList<String>();
        List<String> actualData;
        String[] topMenus = {"HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY"};
        // [A]Switch to "Non-Config" mode
        if (Preempt == 0) {
            mf.js_click(mf.wait_element("xpath", Data_ENG.Config_path, "Config"));
            mf.log_message(this.getClass().getName(), "Switch to 'Non-Config' mode...");
        }

        // [D]Create data >> Excel
        mf.create_data();
        mf.log_message(this.getClass().getName(), "Data created for [ENG]!");

        // [A]Access top menu
        for (int i = 0; i < topMenus.length; i++) {
            // [A]Click (e.g. "HOME")
            actualData = actual_data(topMenus[i]);
            // [D]Update data >> Excel
            mf.update_data(actualData, i);
            mf.log_message(this.getClass().getName(), "Data updated for [ENG]!");
            mf.log_message(this.getClass().getName(), "Top menu " + "'" + topMenus[i] + "'" + " is done!");
        }
        // [A]Get Box info
        box_info();
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
