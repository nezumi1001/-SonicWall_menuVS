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

public class Test_vsDATA_ZE {
    private File my_path = new File(System.getProperty("user.dir"));
    private Logger log = LogManager.getLogger(Test_NavData_ENG.class.getName());
    private String main_menu;
    private int match = 0;
    private ExtentReports exReport;
    private ExtentTest exTest;

    // Import data only (info ZHT)
    public List<String> info_ZHT() throws IOException {
        List<String> data_infos_ZHT = new ArrayList<String>();
        FileInputStream fs_ZHT = new FileInputStream(my_path + "\\Data\\info\\info_ZHT.xls");
        HSSFWorkbook workbook_ZHT = new HSSFWorkbook(fs_ZHT);
        HSSFSheet sheet = workbook_ZHT.getSheet("ZHT");
        // Get info ZHT
        for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
            HSSFCell data_info = sheet.getRow(data_row).getCell(0);
            if (data_info == null) {
                continue;
            }
            String dataInfo = data_info.getStringCellValue();
            data_infos_ZHT.add(dataInfo);
        }
        workbook_ZHT.close();
        return data_infos_ZHT;
    }

    // Import data only (info ENG)
    public List<String> info_ENG() throws IOException {
        List<String> data_infos_ENG = new ArrayList<String>();
        FileInputStream fs_ENG = new FileInputStream(my_path + "\\Data\\info\\info_ENG.xls");
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

    // Box_ZHT
    public String[][] Box_ZHT() throws IOException {
        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        List<String> menu_HOME = new ArrayList<String>();
        List<String> menu_MONITOR = new ArrayList<String>();
        List<String> menu_DEVICE = new ArrayList<String>();
        List<String> menu_NETWORK = new ArrayList<String>();
        List<String> menu_OBJECT = new ArrayList<String>();
        List<String> menu_POLICY = new ArrayList<String>();
        // Import data ZHT
        FileInputStream fs_ZHT = new FileInputStream(my_path + "\\Data\\compare\\Box_ZHT.xls");
        HSSFWorkbook workbook_ZHT = new HSSFWorkbook(fs_ZHT);
        HSSFSheet sheet = workbook_ZHT.getSheet("ZHT");
        // Get data ZHT
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

        // Merge data ZHT
        String[] menu_HOMEs = menu_HOME.toArray(new String[menu_HOME.size()]);
        String[] menu_MONITORs = menu_MONITOR.toArray(new String[menu_MONITOR.size()]);
        String[] menu_DEVICEs = menu_DEVICE.toArray(new String[menu_DEVICE.size()]);
        String[] menu_NETWORKs = menu_NETWORK.toArray(new String[menu_NETWORK.size()]);
        String[] menu_OBJECTs = menu_OBJECT.toArray(new String[menu_OBJECT.size()]);
        String[] menu_POLICYs = menu_POLICY.toArray(new String[menu_POLICY.size()]);
        String[][] menu_ZHT = { menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs };
        // [L]Log
        log_message(testName, "Got data!");
        workbook_ZHT.close();
        return menu_ZHT;
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
        FileInputStream fs_ENG = new FileInputStream(my_path + "\\Data\\compare\\Box_ENG.xls");
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
    public int missing_page(int column_no, List<String> MenusZHTs, List<String> MenusENGs) {
        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        // Column name
        String[] column_name = { "HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY" };
        // New menu ZHT
        List<String> HOME_MenusZHTs = new ArrayList<String>();
        List<String> MONITOR_MenusZHTs = new ArrayList<String>();
        List<String> DEVICE_MenusZHTs = new ArrayList<String>();
        List<String> NETWORK_MenusZHTs = new ArrayList<String>();
        List<String> OBJECT_MenusZHTs = new ArrayList<String>();
        List<String> POLICY_MenusZHTs = new ArrayList<String>();

        // HOME ZHT
        String[] HOME_Menus_ZHT = { "Dashboard", "Legal Information", "API" };
        // MONITOR ZHT
        String[] MONITOR_Menus_ZHT = { "Real-Time Charts", "AppFlow", "SDWAN", "Logs", "Tools & Monitors" };
        // DEVICE ZHT
        String[] DEVICE_Menus_ZHT = { "Settings (TOP)", "Internal Wireless", "High Availability", "Users", "AppFlow",
                "Network Access Control", "Log", "Diagnostics", "Switch Network", "Access Points", "WWAN" };
        // NETWORK ZHT
        String[] NETWORK_Menus_ZHT = { "System", "Firewall", "VoIP", "DNS", "Switching", "SDWAN", "IPSec VPN",
                "SSL VPN" };
        // OBJECT ZHT
        String[] OBJECT_Menus_ZHT = { "Match Objects (TOP)", "Profile Objects", "Action Objects", "Signatures" };
        // POLICY ZHT
        String[] POLICY_Menus_ZHT = { "Rules and Policies", "DPI-SSL", "DPI-SSH", "Security Services", "Anti-Spam",
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
        String[] HOME_Menus_ENG = HOME_Menus_ZHT;
        // MONITOR ENG
        String[] MONITOR_Menus_ENG = MONITOR_Menus_ZHT;
        // DEVICE ENG
        String[] DEVICE_Menus_ENG = DEVICE_Menus_ZHT;
        // NETWORK ENG
        String[] NETWORK_Menus_ENG = NETWORK_Menus_ZHT;
        // OBJECT ENG
        String[] OBJECT_Menus_ENG = OBJECT_Menus_ZHT;
        // POLICY ENG
        String[] POLICY_Menus_ENG = POLICY_Menus_ZHT;

        // --- Make new menu ---
        main_menu = column_name[column_no];

        // Mark ">" ZHT
        List<String> MenusZHTs_temp = new ArrayList<String>();
        for (int i = 0; i < MenusZHTs.size(); i++) {
            String[] MenusZHT_box = null;
            String MenusZHT_temp = MenusZHTs.get(i);
            int iTemp = i;
            int iMenu = 0;
            if (main_menu.equals("HOME"))
                MenusZHT_box = HOME_Menus_ZHT;
            if (main_menu.equals("MONITOR"))
                MenusZHT_box = MONITOR_Menus_ZHT;
            if (main_menu.equals("DEVICE"))
                MenusZHT_box = DEVICE_Menus_ZHT;
            if (main_menu.equals("NETWORK"))
                MenusZHT_box = NETWORK_Menus_ZHT;
            if (main_menu.equals("OBJECT"))
                MenusZHT_box = OBJECT_Menus_ZHT;
            if (main_menu.equals("POLICY"))
                MenusZHT_box = POLICY_Menus_ZHT;

            while (iMenu == 0) {
                for (int j = 0; j < MenusZHT_box.length; j++) {
                    if (MenusZHT_temp.equals(MenusZHT_box[j]))
                        iMenu = 1;
                }
                if (iMenu == 0)
                    MenusZHT_temp = MenusZHTs.get(iTemp = iTemp - 1);
            }

            for (int k = 0; k < MenusZHT_box.length; k++) {
                if (MenusZHT_temp.equals(MenusZHT_box[k])) {
                    if (iTemp == i) {
                        MenusZHTs_temp.add(MenusZHT_box[k]);
                    } else {
                        MenusZHTs_temp.add(MenusZHT_box[k] + " > " + MenusZHTs.get(i));
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
            HOME_MenusZHTs = MenusZHTs_temp;
            HOME_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("MONITOR")) {
            MONITOR_MenusZHTs = MenusZHTs_temp;
            MONITOR_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("DEVICE")) {
            DEVICE_MenusZHTs = MenusZHTs_temp;
            DEVICE_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("NETWORK")) {
            NETWORK_MenusZHTs = MenusZHTs_temp;
            NETWORK_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("OBJECT")) {
            OBJECT_MenusZHTs = MenusZHTs_temp;
            OBJECT_MenusENGs = MenusENGs_temp;
        }
        if (main_menu.equals("POLICY")) {
            POLICY_MenusZHTs = MenusZHTs_temp;
            POLICY_MenusENGs = MenusENGs_temp;
        }

        // --- Final VS ---
        // Merge data ZHT & ENG
        String[] HOME_ZHTs = HOME_MenusZHTs.toArray(new String[HOME_MenusZHTs.size()]);
        String[] MONITOR_ZHTs = MONITOR_MenusZHTs.toArray(new String[MONITOR_MenusZHTs.size()]);
        String[] DEVICE_ZHTs = DEVICE_MenusZHTs.toArray(new String[DEVICE_MenusZHTs.size()]);
        String[] NETWORK_ZHTs = NETWORK_MenusZHTs.toArray(new String[NETWORK_MenusZHTs.size()]);
        String[] OBJECT_ZHTs = OBJECT_MenusZHTs.toArray(new String[OBJECT_MenusZHTs.size()]);
        String[] POLICY_ZHTs = POLICY_MenusZHTs.toArray(new String[POLICY_MenusZHTs.size()]);
        String[][] Menu_ZHTs = { HOME_ZHTs, MONITOR_ZHTs, DEVICE_ZHTs, NETWORK_ZHTs, OBJECT_ZHTs, POLICY_ZHTs };

        // Merge data ENG
        String[] HOME_ENGs = HOME_MenusENGs.toArray(new String[HOME_MenusENGs.size()]);
        String[] MONITOR_ENGs = MONITOR_MenusENGs.toArray(new String[MONITOR_MenusENGs.size()]);
        String[] DEVICE_ENGs = DEVICE_MenusENGs.toArray(new String[DEVICE_MenusENGs.size()]);
        String[] NETWORK_ENGs = NETWORK_MenusENGs.toArray(new String[NETWORK_MenusENGs.size()]);
        String[] OBJECT_ENGs = OBJECT_MenusENGs.toArray(new String[OBJECT_MenusENGs.size()]);
        String[] POLICY_ENGs = POLICY_MenusENGs.toArray(new String[POLICY_MenusENGs.size()]);
        String[][] Menu_ENGs = { HOME_ENGs, MONITOR_ENGs, DEVICE_ENGs, NETWORK_ENGs, OBJECT_ENGs, POLICY_ENGs };

        // ZHT version missing
        for (int i = 0; i < 6; i++) {
            List<String> MenuZHTs = Arrays.asList(Menu_ZHTs[i]);
            List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
            for (String MenuENG : MenuENGs) {
                if (!MenuZHTs.contains(MenuENG)) {
                    if (MenuENG.contains(" (TOP)")) {
                        MenuENG = MenuENG.replace(" (TOP)", "");
                    }
                    // [L]Log
                    log_message(testName, "[ZHT] version missing: " + main_menu + " > " + MenuENG);
                    match++;
                }
            }
        }

        // ENG version missing
        for (int i = 0; i < 6; i++) {
            List<String> MenuZHTs = Arrays.asList(Menu_ZHTs[i]);
            List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
            for (String MenuZHT : MenuZHTs) {
                if (!MenuENGs.contains(MenuZHT)) {
                    if (MenuZHT.contains(" (TOP)")) {
                        MenuZHT = MenuZHT.replace(" (TOP)", "");
                    }
                    // [L]Log
                    log_message(testName, "[ENG] version missing: " + main_menu + " > " + MenuZHT);
                    match++;
                }
            }
        }

        return match;
    }

    // Start > Extent report
    public void start_exReport() {
        exReport = new ExtentReports(my_path + "\\Log\\report\\ExReport_VS.html");
        exTest = exReport.startTest("Menu Test > [ZHT] vs [ENG]");
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

        // Get data ZHT & ENG
        String[][] Menus_ZHTs = Box_ZHT();
        String[][] Menus_ENGs = box_ENG();

        // [L]Log
        log_message(testName, "Ready to start...");

        // [L]Log
        log_message(testName, "--------------------------------------------------------------------");

        // [L]Log (info ZHT)
        List<String> InfoZHTs = info_ZHT();
        log_message(testName, "[ZHT] info: " + "Device Name -----> " + InfoZHTs.get(0));
        log_message(testName, "[ZHT] info: " + "Serial Number ---> " + InfoZHTs.get(1));
        log_message(testName, "[ZHT] info: " + "Firmware Version > " + InfoZHTs.get(2));

        // [L]Log
        log_message(testName, "--------------------------------------------------------------------");

        // [L]Log (info ZHT)
        List<String> InfoENGs = info_ENG();
        log_message(testName, "[ENG] info: " + "Device Name -----> " + InfoENGs.get(0));
        log_message(testName, "[ENG] info: " + "Serial Number ---> " + InfoENGs.get(1));
        log_message(testName, "[ENG] info: " + "Firmware Version > " + InfoENGs.get(2));

        // [L]Log
        log_message(testName, "--------------------------------------------------------------------");

        // Compare data ZHT & ENG
        for (int i = 0; i < 6; i++) {
            List<String> MenusZHTs = Arrays.asList(Menus_ZHTs[i]);
            List<String> MenusENGs = Arrays.asList(Menus_ENGs[i]);
            match = missing_page(i, MenusZHTs, MenusENGs);
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
