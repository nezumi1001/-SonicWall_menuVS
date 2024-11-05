package com.demo.apitest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test_NavData_ZHT {
    private Func_ZHT mf;
    private WebDriver driver;
    private int Preempt;
//    private ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(Data_ZHT.chromeDriver_data[1])).usingAnyFreePort().build();

    @BeforeClass
    public void beforeClass() {
        // [S]ChromeDriver Settings
        System.setProperty(Data_ZHT.chromeDriver_data[0], Data_ZHT.chromeDriver_data[1]);
        ChromeOptions chromOptions = new ChromeOptions();
        chromOptions.addArguments(Data_ZHT.Chrome_userData);
        chromOptions.addArguments("--lang=zh-CN");
        chromOptions.addArguments("--incognito");
        chromOptions.addArguments("--ignore-certificate-errors");
//		chromOptions.addArguments("window-size=1920, 1080");
        chromOptions.addArguments("window-size=1920, 3000");
        chromOptions.addArguments("--headless");
        driver = new ChromeDriver(chromOptions);
        driver.get(Data_ZHT.baseUrl);
        mf = new Func_ZHT(driver);
        mf.start_exReport();
        mf.log_message(this.getClass().getName(), "Before Navigate To..." + Data_ZHT.baseUrl + "[ZHT]");
    }

    // Box info
    public void box_info() throws IOException {
        List<String> info_ZHTs = new ArrayList<>();
        // [A]Go to DEVICE > Settings
        driver.get(Data_ZHT.FirmwareSettings_url);
        // [A]Fix Box & SN shows unknown
        mf.wait_element("xpath", Data_ZHT.CurrentFirmwareVersion, "Current Firmware Version");
        // [A]Get info
        String Box_ZHT = mf.wait_element("xpath", Data_ZHT.Box_name, "Box_ZHT").getText();
        String SN_ZHT = mf.wait_element("xpath", Data_ZHT.SN_name, "SN_ZHT").getText();
        String Version_ZHT = mf.wait_element("xpath", Data_ZHT.FirmwareVersion, "Version_ZHT").getText();
        info_ZHTs.add(Box_ZHT);
        info_ZHTs.add(SN_ZHT);
        info_ZHTs.add(Version_ZHT);
        // [D]Create info >> Excel
        mf.create_info();
        mf.log_message(this.getClass().getName(), "Info created for [ZHT]!");
        // [D]Update info >> Excel
        mf.update_info(info_ZHTs, 0);
        mf.log_message(this.getClass().getName(), "Info updated for [ZHT]!");
    }

    // Actual data
    public List<String> actual_data() {
        // [A]Expand page
        mf.wait_element("xpath", Data_ZHT.DarkMenu_LeftPane_path, "DarkMenu_LeftPane");
        List<WebElement> Menu_darks = mf.find_elements("xpath", Data_ZHT.DarkMenu_LeftPane_path, "Dark menu on leftpane");

        for (int i = 1; i <= Menu_darks.size(); i++) {
            WebElement e = Menu_darks.get(Menu_darks.size() - i);
            mf.js_click(e);
        }

        mf.wait_element("xpath", Data_ZHT.SubMenu_nested, "SubMenu_nested");
        List<WebElement> Menu_alls = mf.find_elements("xpath", Data_ZHT.LeftPane_path, "All menu on leftpane");
        return new ArrayList<>(mf.expand_menu(Menu_alls));
    }

    @Test
    public void test_Step01_Login_ZHT() {
        // [A]Enter "使用者名稱"
        mf.wait_element("xpath", Data_ZHT.userName_path, "userName").sendKeys(Data_ZHT.login_name);
        // [A]Enter "密碼"
        mf.wait_element("xpath", Data_ZHT.password_path, "password").sendKeys(Data_ZHT.login_pass);
        // [A]Click "登入"
        mf.js_click(mf.wait_element("xpath", Data_ZHT.login_path, "login"));
        mf.log_message(this.getClass().getName(), "Login to main page...");
        // [A]Preempt
        if (mf.wait_element("xpath", Data_ZHT.preempt_path, "Ready to login...") != null) {
            mf.js_click(mf.wait_element("xpath", Data_ZHT.preempt_path, "Non-Config button"));
            mf.log_message(this.getClass().getName(), "Enter in Non-Config Mode...");
            Preempt = 1;
        }
    }

    @Test
    public void test_Step02_MenuTop_ZHT() throws Exception {
        List<String> actualData;
        // [A]Switch to "Non-Config" mode
        if (Preempt == 0) {
            mf.js_click(mf.wait_element("xpath", Data_ZHT.Config_path, "Config"));
            mf.log_message(this.getClass().getName(), "Switch to 'Non-Config' mode...");
        }

        // [A]Switch to Classic Mode
        mf.js_click(mf.wait_element("xpath", Data_ZHT.AD_path, "AD icon"));
        mf.js_click(mf.wait_element("xpath", Data_ZHT.old_path, "Classic option"));

        // [D]Create data >> Excel
        mf.create_data();
        mf.log_message(this.getClass().getName(), "Data created for [ZHT]!");

        // [A]Access menu
        actualData = actual_data();

        // [D]Update data >> Excel
        mf.update_data(actualData);
        mf.log_message(this.getClass().getName(), "Data updated for [ZHT]!");

        // [A]Get Box info
        box_info();

        // [A]Get self-check (ZZ check) info
//        System.out.println("Data_ZHT.check_list: " + Data_ZHT.check_list);
        if (Data_ZHT.check_list == 1) {
            if (mf.newMenu_ZHT == 0) {
                mf.log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                mf.log_message(this.getClass().getName(), "^          All Matched!          ^");
                mf.log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            } else {
                mf.log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                mf.log_message(this.getClass().getName(), "New data: " + mf.newMenu_ZHT);

                for (int i = 0; i < mf.menuInfo_ZHT.size(); i++) {
                    mf.log_message(this.getClass().getName(), mf.menuInfo_ZHT.get(i));
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
//        service.stop();
        mf.close_exReport();
    }
}