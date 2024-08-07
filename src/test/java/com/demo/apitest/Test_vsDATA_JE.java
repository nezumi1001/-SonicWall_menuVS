package com.demo.apitest;

import static org.testng.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_vsDATA_JE {
    private File my_path = new File(System.getProperty("user.dir"));
    private Logger log = LogManager.getLogger(Test_NavData_ENG.class.getName());
    private String main_menu;
    private int match = 0;
    private ExtentReports exReport;
    private ExtentTest exTest;

    // Import data only (info JPN)
    public List<String> info_JPN() throws IOException {
        List<String> data_infos_JPN = new ArrayList<String>();
        FileInputStream fs_JPN = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\info\\info_JPN.xls");
        HSSFWorkbook workbook_JPN = new HSSFWorkbook(fs_JPN);
        HSSFSheet sheet = workbook_JPN.getSheet("JPN");
        // Get info JPN
        for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
            HSSFCell data_info = sheet.getRow(data_row).getCell(0);
            if (data_info == null) {
                continue;
            }
            String dataInfo = data_info.getStringCellValue();
            data_infos_JPN.add(dataInfo);
        }
        workbook_JPN.close();
        return data_infos_JPN;
    }

    // Import data only (info ENG)
    public List<String> info_ENG() throws IOException {
        List<String> data_infos_ENG = new ArrayList<String>();
        FileInputStream fs_ENG = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\info\\info_ENG.xls");
        HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
        HSSFSheet sheet = workbook_ENG.getSheet("ENG");
        // Get info ENG
        for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
            HSSFCell data_info = sheet.getRow(data_row).getCell(0);
            if (data_info == null) {
                continue;
            }
            String dataInfo = data_info.getStringCellValue();
            data_infos_ENG.add(dataInfo);
        }
        workbook_ENG.close();
        return data_infos_ENG;
    }

    // box_JPN
    public String[][] box_JPN() throws IOException {
        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        List<String> menu_HOME = new ArrayList<String>();
        List<String> menu_MONITOR = new ArrayList<String>();
        List<String> menu_DEVICE = new ArrayList<String>();
        List<String> menu_NETWORK = new ArrayList<String>();
        List<String> menu_OBJECT = new ArrayList<String>();
        List<String> menu_POLICY = new ArrayList<String>();
        // Import data JPN
        FileInputStream fs_JPN = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_JPN.xls");
        HSSFWorkbook workbook_JPN = new HSSFWorkbook(fs_JPN);
        HSSFSheet sheet = workbook_JPN.getSheet("JPN");
        // Get data JPN
        for (int data_column = 0; data_column < sheet.getRow(data_column).getLastCellNum(); data_column++) {
            for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
                HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
                if (data_value == null) {
                    continue;
                }
                String dataValue = data_value.getStringCellValue();

                // Get data from each column
                if (data_column == 0) {
                    menu_HOME.add(dataValue);
                } else if (data_column == 1) {
                    menu_MONITOR.add(dataValue);
                } else if (data_column == 2) {
                    menu_DEVICE.add(dataValue);
                } else if (data_column == 3) {
                    menu_NETWORK.add(dataValue);
                } else if (data_column == 4) {
                    menu_OBJECT.add(dataValue);
                } else if (data_column == 5) {
                    menu_POLICY.add(dataValue);
                }
            }
        }

        // Merge data JPN
        String[] menu_HOMEs = menu_HOME.toArray(new String[menu_HOME.size()]);
        String[] menu_MONITORs = menu_MONITOR.toArray(new String[menu_MONITOR.size()]);
        String[] menu_DEVICEs = menu_DEVICE.toArray(new String[menu_DEVICE.size()]);
        String[] menu_NETWORKs = menu_NETWORK.toArray(new String[menu_NETWORK.size()]);
        String[] menu_OBJECTs = menu_OBJECT.toArray(new String[menu_OBJECT.size()]);
        String[] menu_POLICYs = menu_POLICY.toArray(new String[menu_POLICY.size()]);
        String[][] menu_JPN = { menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs };
        // [L]Log
        log_message(testName, "Got data!");
        workbook_JPN.close();
        return menu_JPN;
    }

    // box_ENG
    public String[][] box_ENG() throws IOException {
        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        List<String> menu_HOME = new ArrayList<String>();
        List<String> menu_MONITOR = new ArrayList<String>();
        List<String> menu_DEVICE = new ArrayList<String>();
        List<String> menu_NETWORK = new ArrayList<String>();
        List<String> menu_OBJECT = new ArrayList<String>();
        List<String> menu_POLICY = new ArrayList<String>();
        // Import data ENG
        FileInputStream fs_ENG = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_ENG.xls");
        HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
        HSSFSheet sheet = workbook_ENG.getSheet("ENG");
        // Get data ENG
        for (int data_column = 0; data_column < sheet.getRow(data_column).getLastCellNum(); data_column++) {
            for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
                HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
                if (data_value == null) {
                    continue;
                }
                String dataValue = data_value.getStringCellValue();

                // Get data from each column
                if (data_column == 0) {
                    menu_HOME.add(dataValue);
                } else if (data_column == 1) {
                    menu_MONITOR.add(dataValue);
                } else if (data_column == 2) {
                    menu_DEVICE.add(dataValue);
                } else if (data_column == 3) {
                    menu_NETWORK.add(dataValue);
                } else if (data_column == 4) {
                    menu_OBJECT.add(dataValue);
                } else if (data_column == 5) {
                    menu_POLICY.add(dataValue);
                }
            }
        }

        // Merge data ENG
        String[] menu_HOMEs = menu_HOME.toArray(new String[menu_HOME.size()]);
        String[] menu_MONITORs = menu_MONITOR.toArray(new String[menu_MONITOR.size()]);
        String[] menu_DEVICEs = menu_DEVICE.toArray(new String[menu_DEVICE.size()]);
        String[] menu_NETWORKs = menu_NETWORK.toArray(new String[menu_NETWORK.size()]);
        String[] menu_OBJECTs = menu_OBJECT.toArray(new String[menu_OBJECT.size()]);
        String[] menu_POLICYs = menu_POLICY.toArray(new String[menu_POLICY.size()]);
        String[][] menu_ENG = { menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs };
        // [L]Log
        log_message(testName, "Got data!");
        workbook_ENG.close();
        return menu_ENG;
    }

    // Get missing page
    public int missing_page(int column_no, List<String> MenusJPNs, List<String> MenusENGs) {
        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        // Column name
        String[] column_name = { "HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY" };
        // New menu JPN
        List<String> HOME_MenusJPNs = new ArrayList<String>();
        List<String> MONITOR_MenusJPNs = new ArrayList<String>();
        List<String> DEVICE_MenusJPNs = new ArrayList<String>();
        List<String> NETWORK_MenusJPNs = new ArrayList<String>();
        List<String> OBJECT_MenusJPNs = new ArrayList<String>();
        List<String> POLICY_MenusJPNs = new ArrayList<String>();

        // HOME JPN
        String[] HOME_Menus_JPN = { "Dashboard", "Legal Information", "API" };
        // MONITOR JPN
        String[] MONITOR_Menus_JPN = { "Real-Time Charts", "AppFlow", "SDWAN", "Logs", "Tools & Monitors" };
        // DEVICE JPN
        String[] DEVICE_Menus_JPN = { "Settings (TOP)", "Internal Wireless", "High Availability", "Users", "AppFlow",
                "Network Access Control", "Log", "Diagnostics", "Switch Network", "Access Points", "WWAN" };
        // NETWORK JPN
        String[] NETWORK_Menus_JPN = { "System", "Firewall", "VoIP", "DNS", "Switching", "SDWAN", "IPSec VPN",
                "SSL VPN" };
        // OBJECT JPN
        String[] OBJECT_Menus_JPN = { "Match Objects (TOP)", "Profile Objects", "Action Objects", "Signatures" };
        // POLICY JPN
        String[] POLICY_Menus_JPN = { "Rules and Policies", "DPI-SSL", "DPI-SSH", "Security Services", "Anti-Spam",
                "Capture ATP", "DNS Security", "Endpoint Security" };
        // ------------------------------------------------------------------------------------------------------------------------------
        // New menu ENG
        List<String> HOME_MenusENGs = new ArrayList<String>();
        List<String> MONITOR_MenusENGs = new ArrayList<String>();
        List<String> DEVICE_MenusENGs = new ArrayList<String>();
        List<String> NETWORK_MenusENGs = new ArrayList<String>();
        List<String> OBJECT_MenusENGs = new ArrayList<String>();
        List<String> POLICY_MenusENGs = new ArrayList<String>();
        // HOME ENG
        String[] HOME_Menus_ENG = HOME_Menus_JPN;
        // MONITOR ENG
        String[] MONITOR_Menus_ENG = MONITOR_Menus_JPN;
        // DEVICE ENG
        String[] DEVICE_Menus_ENG = DEVICE_Menus_JPN;
        // NETWORK ENG
        String[] NETWORK_Menus_ENG = NETWORK_Menus_JPN;
        // OBJECT ENG
        String[] OBJECT_Menus_ENG = OBJECT_Menus_JPN;
        // POLICY ENG
        String[] POLICY_Menus_ENG = POLICY_Menus_JPN;

        // --- Make new menu ---
        main_menu = column_name[column_no];

        // Mark ">" JPN
        List<String> MenusJPNs_temp = new ArrayList<String>();
        for (int i = 0; i < MenusJPNs.size(); i++) {
            String[] MenusJPN_box = null;
            String MenusJPN_temp = MenusJPNs.get(i);
            int iTemp = i;
            int iMenu = 0;
            if (main_menu.equals("HOME"))
                MenusJPN_box = HOME_Menus_JPN;
            if (main_menu.equals("MONITOR"))
                MenusJPN_box = MONITOR_Menus_JPN;
            if (main_menu.equals("DEVICE"))
                MenusJPN_box = DEVICE_Menus_JPN;
            if (main_menu.equals("NETWORK"))
                MenusJPN_box = NETWORK_Menus_JPN;
            if (main_menu.equals("OBJECT"))
                MenusJPN_box = OBJECT_Menus_JPN;
            if (main_menu.equals("POLICY"))
                MenusJPN_box = POLICY_Menus_JPN;

            while (iMenu == 0) {
                for (int j = 0; j < MenusJPN_box.length; j++) {
                    if (MenusJPN_temp.equals(MenusJPN_box[j]))
                        iMenu = 1;
                }
                if (iMenu == 0)
                    MenusJPN_temp = MenusJPNs.get(iTemp = iTemp - 1);
            }

            for (int k = 0; k < MenusJPN_box.length; k++) {
                if (MenusJPN_temp.equals(MenusJPN_box[k])) {
                    if (iTemp == i) {
                        MenusJPNs_temp.add(MenusJPN_box[k]);
                    } else {
                        MenusJPNs_temp.add(MenusJPN_box[k] + " > " + MenusJPNs.get(i));
                    }
                }
            }

        }

        // Mark ">" ENG
        List<String> MenusENGs_temp = new ArrayList<String>();
        for (int i = 0; i < MenusENGs.size(); i++) {
            String[] MenusENG_box = null;
            String MenusENG_temp = MenusENGs.get(i);
            int iTemp = i;
            int iMenu = 0;
            if (main_menu.equals("HOME"))
                MenusENG_box = HOME_Menus_ENG;
            if (main_menu.equals("MONITOR"))
                MenusENG_box = MONITOR_Menus_ENG;
            if (main_menu.equals("DEVICE"))
                MenusENG_box = DEVICE_Menus_ENG;
            if (main_menu.equals("NETWORK"))
                MenusENG_box = NETWORK_Menus_ENG;
            if (main_menu.equals("OBJECT"))
                MenusENG_box = OBJECT_Menus_ENG;
            if (main_menu.equals("POLICY"))
                MenusENG_box = POLICY_Menus_ENG;

            while (iMenu == 0) {
                for (int j = 0; j < MenusENG_box.length; j++) {
                    if (MenusENG_temp.equals(MenusENG_box[j]))
                        iMenu = 1;
                }
                if (iMenu == 0)
                    MenusENG_temp = MenusENGs.get(iTemp = iTemp - 1);
            }

            for (int k = 0; k < MenusENG_box.length; k++) {
                if (MenusENG_temp.equals(MenusENG_box[k])) {
                    if (iTemp == i) {
                        MenusENGs_temp.add(MenusENG_box[k]);
                    } else {
                        MenusENGs_temp.add(MenusENG_box[k] + " > " + MenusENGs.get(i));
                    }
                }
            }

        }

        if (main_menu.equals("HOME")) {
            HOME_MenusJPNs = MenusJPNs_temp;
            HOME_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("MONITOR")) {
            MONITOR_MenusJPNs = MenusJPNs_temp;
            MONITOR_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("DEVICE")) {
            DEVICE_MenusJPNs = MenusJPNs_temp;
            DEVICE_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("NETWORK")) {
            NETWORK_MenusJPNs = MenusJPNs_temp;
            NETWORK_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("OBJECT")) {
            OBJECT_MenusJPNs = MenusJPNs_temp;
            OBJECT_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("POLICY")) {
            POLICY_MenusJPNs = MenusJPNs_temp;
            POLICY_MenusENGs = MenusENGs_temp;
        }

        // --- Final VS ---
        // Merge data JPN
        String[] HOME_JPNs = HOME_MenusJPNs.toArray(new String[HOME_MenusJPNs.size()]);
        String[] MONITOR_JPNs = MONITOR_MenusJPNs.toArray(new String[MONITOR_MenusJPNs.size()]);
        String[] DEVICE_JPNs = DEVICE_MenusJPNs.toArray(new String[DEVICE_MenusJPNs.size()]);
        String[] NETWORK_JPNs = NETWORK_MenusJPNs.toArray(new String[NETWORK_MenusJPNs.size()]);
        String[] OBJECT_JPNs = OBJECT_MenusJPNs.toArray(new String[OBJECT_MenusJPNs.size()]);
        String[] POLICY_JPNs = POLICY_MenusJPNs.toArray(new String[POLICY_MenusJPNs.size()]);
        String[][] Menu_JPNs = { HOME_JPNs, MONITOR_JPNs, DEVICE_JPNs, NETWORK_JPNs, OBJECT_JPNs, POLICY_JPNs };

        // Merge data ENG
        String[] HOME_ENGs = HOME_MenusENGs.toArray(new String[HOME_MenusENGs.size()]);
        String[] MONITOR_ENGs = MONITOR_MenusENGs.toArray(new String[MONITOR_MenusENGs.size()]);
        String[] DEVICE_ENGs = DEVICE_MenusENGs.toArray(new String[DEVICE_MenusENGs.size()]);
        String[] NETWORK_ENGs = NETWORK_MenusENGs.toArray(new String[NETWORK_MenusENGs.size()]);
        String[] OBJECT_ENGs = OBJECT_MenusENGs.toArray(new String[OBJECT_MenusENGs.size()]);
        String[] POLICY_ENGs = POLICY_MenusENGs.toArray(new String[POLICY_MenusENGs.size()]);
        String[][] Menu_ENGs = { HOME_ENGs, MONITOR_ENGs, DEVICE_ENGs, NETWORK_ENGs, OBJECT_ENGs, POLICY_ENGs };

        // JPN version missing
        for (int i = 0; i < 6; i++) {
            List<String> MenuJPNs = Arrays.asList(Menu_JPNs[i]);
            List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
            for (String MenuENG : MenuENGs) {
                if (!MenuJPNs.contains(MenuENG)) {
                    if (MenuENG.contains(" (TOP)")) {
                        MenuENG = MenuENG.replace(" (TOP)", "");
                    }
                    // [L]Log
                    log_message(testName, "[JPN] version missing: " + main_menu + " > " + MenuENG);
                    match++;
                }
            }
        }

        // ENG version missing
        for (int i = 0; i < 6; i++) {
            List<String> MenuJPNs = Arrays.asList(Menu_JPNs[i]);
            List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
            for (String MenuJPN : MenuJPNs) {
                if (!MenuENGs.contains(MenuJPN)) {
                    if (MenuJPN.contains(" (TOP)")) {
                        MenuJPN = MenuJPN.replace(" (TOP)", "");
                    }
                    // [L]Log
                    log_message(testName, "[ENG] version missing: " + main_menu + " > " + MenuJPN);
                    match++;
                }
            }
        }

        return match;
    }

    // Start > Extent report
    public void start_exReport() {
        exReport = new ExtentReports(my_path + "\\src\\main\\resources\\Log\\report\\ExReport_VS.html");
        exTest = exReport.startTest("Menu Test > [JPN] vs [ENG]");
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

    @Test
    public void test_dataCompare() throws IOException {
        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        start_exReport();

        // Get data JPN & ENG
        String[][] Menus_JPNs = box_JPN();
        String[][] Menus_ENGs = box_ENG();

        // [L]Log
        log_message(testName, "Ready to start...");

        // [L]Log
        log_message(testName, "--------------------------------------------------------------------");

        // [L]Log (info JPN)
        List<String> InfoJPNs = info_JPN();
        log_message(testName, "[JPN] info: " + "Device Name -----> " + InfoJPNs.get(0));
        log_message(testName, "[JPN] info: " + "Serial Number ---> " + InfoJPNs.get(1));
        log_message(testName, "[JPN] info: " + "Firmware Version > " + InfoJPNs.get(2));

        // [L]Log
        log_message(testName, "--------------------------------------------------------------------");

        // [L]Log (info JPN)
        List<String> InfoENGs = info_ENG();
        log_message(testName, "[ENG] info: " + "Device Name -----> " + InfoENGs.get(0));
        log_message(testName, "[ENG] info: " + "Serial Number ---> " + InfoENGs.get(1));
        log_message(testName, "[ENG] info: " + "Firmware Version > " + InfoENGs.get(2));

        // [L]Log
        log_message(testName, "--------------------------------------------------------------------");

        // Compare data JPN & ENG
        for (int i = 0; i < 6; i++) {
            List<String> MenusJPNs = Arrays.asList(Menus_JPNs[i]);
            List<String> MenusENGs = Arrays.asList(Menus_ENGs[i]);
            match = missing_page(i, MenusJPNs, MenusENGs);
        }
        // Completely Match!
        if (match == 0) {
            log_message(testName, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log_message(testName, "^          All Matched!          ^");
            log_message(testName, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//			System.out.println("********** All matched! **********");
        }

        close_exReport();
    }

}
