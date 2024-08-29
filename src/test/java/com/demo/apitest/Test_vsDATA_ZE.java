package com.demo.apitest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    private final File my_path = new File(System.getProperty("user.dir"));
    //    private final Logger log = LogManager.getLogger(Test_NavData_ENG.class.getName());
//    private final Logger log = LogManager.getLogger(Test_vsDATA_ZE.class.getName());
    private final Logger log = LogManager.getLogger(this.getClass().getName());
    private int match = 0;
    private ExtentReports exReport;
    private ExtentTest exTest;
    private List<String> MenusMiss_ZHT = new ArrayList<>();
    private List<String> MenusMiss_ENG = new ArrayList<>();

    // Import data only (info ZHT)
    public List<String> info_ZHT() throws IOException {
        List<String> data_infos_ZHT = new ArrayList<>();
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
        List<String> data_infos_ENG = new ArrayList<>();
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
        List<String> menu_HOME = new ArrayList<>();
        List<String> menu_MONITOR = new ArrayList<>();
        List<String> menu_DEVICE = new ArrayList<>();
        List<String> menu_NETWORK = new ArrayList<>();
        List<String> menu_OBJECT = new ArrayList<>();
        List<String> menu_POLICY = new ArrayList<>();
        // Import data ZHT
        FileInputStream fs_ZHT = new FileInputStream(my_path + "\\Data\\compare\\Box_ZHT.xls");
        HSSFWorkbook workbook_ZHT = new HSSFWorkbook(fs_ZHT);
        HSSFSheet sheet = workbook_ZHT.getSheet("ZHT");
        // Get data ZHT
        for (int data_column = 0; data_column < sheet.getRow(data_column).getLastCellNum(); data_column++) {
            for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
                HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
                // Go on to new column when arriving at the last row
                if (data_value == null) {
                    continue;
                }
                String dataValue = data_value.getStringCellValue();

                switch (data_column){
                    case 0 -> menu_HOME.add(dataValue);
                    case 1 -> menu_MONITOR.add(dataValue);
                    case 2 -> menu_DEVICE.add(dataValue);
                    case 3 -> menu_NETWORK.add(dataValue);
                    case 4 -> menu_OBJECT.add(dataValue);
                    case 5 -> menu_POLICY.add(dataValue);
                }

            }
        }

        // Merge data ZHT
        // List<String> >> String[]
        String[] menu_HOMEs = menu_HOME.toArray(new String[0]);
        String[] menu_MONITORs = menu_MONITOR.toArray(new String[0]);
        String[] menu_DEVICEs = menu_DEVICE.toArray(new String[0]);
        String[] menu_NETWORKs = menu_NETWORK.toArray(new String[0]);
        String[] menu_OBJECTs = menu_OBJECT.toArray(new String[0]);
        String[] menu_POLICYs = menu_POLICY.toArray(new String[0]);
        String[][] menu_ZHT = {menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs};
        // [L]Log
        log_message(this.getClass().getName(), "Got data!");
        workbook_ZHT.close();
        return menu_ZHT;
    }

    // box_ENG
    public String[][] box_ENG() throws IOException {
        List<String> menu_HOME = new ArrayList<>();
        List<String> menu_MONITOR = new ArrayList<>();
        List<String> menu_DEVICE = new ArrayList<>();
        List<String> menu_NETWORK = new ArrayList<>();
        List<String> menu_OBJECT = new ArrayList<>();
        List<String> menu_POLICY = new ArrayList<>();
        // Import data ENG
        FileInputStream fs_ENG = new FileInputStream(my_path + "\\Data\\compare\\Box_ENG.xls");
        HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
        HSSFSheet sheet = workbook_ENG.getSheet("ENG");
        // Get data ENG
        for (int data_column = 0; data_column < sheet.getRow(data_column).getLastCellNum(); data_column++) {
            for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
                HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
                // Go on to new column when arriving at the last row
                if (data_value == null) {
                    continue;
                }
                String dataValue = data_value.getStringCellValue();

                switch (data_column){
                    case 0 -> menu_HOME.add(dataValue);
                    case 1 -> menu_MONITOR.add(dataValue);
                    case 2 -> menu_DEVICE.add(dataValue);
                    case 3 -> menu_NETWORK.add(dataValue);
                    case 4 -> menu_OBJECT.add(dataValue);
                    case 5 -> menu_POLICY.add(dataValue);
                }

            }
        }

        // Merge data JPN
        // List<String> >> String[]
        String[] menu_HOMEs = menu_HOME.toArray(new String[0]);
        String[] menu_MONITORs = menu_MONITOR.toArray(new String[0]);
        String[] menu_DEVICEs = menu_DEVICE.toArray(new String[0]);
        String[] menu_NETWORKs = menu_NETWORK.toArray(new String[0]);
        String[] menu_OBJECTs = menu_OBJECT.toArray(new String[0]);
        String[] menu_POLICYs = menu_POLICY.toArray(new String[0]);
        String[][] menu_ENG = {menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs};
        // [L]Log
        log_message(this.getClass().getName(), "Got data!");
        workbook_ENG.close();
        return menu_ENG;
    }

    // Get missing page
    public int missing_page(int column_no, List<String> MenusZHTs, List<String> MenusENGs) {
        // Column name
        String[] column_name = {"HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY"};
        // New menu ZHT
        List<String> HOME_MenusZHTs = new ArrayList<>();
        List<String> MONITOR_MenusZHTs = new ArrayList<>();
        List<String> DEVICE_MenusZHTs = new ArrayList<>();
        List<String> NETWORK_MenusZHTs = new ArrayList<>();
        List<String> OBJECT_MenusZHTs = new ArrayList<>();
        List<String> POLICY_MenusZHTs = new ArrayList<>();

        // New menu ENG
        List<String> HOME_MenusENGs = new ArrayList<>();
        List<String> MONITOR_MenusENGs = new ArrayList<>();
        List<String> DEVICE_MenusENGs = new ArrayList<>();
        List<String> NETWORK_MenusENGs = new ArrayList<>();
        List<String> OBJECT_MenusENGs = new ArrayList<>();
        List<String> POLICY_MenusENGs = new ArrayList<>();

        // Parent menu for each column
        // HOME ENGZHT
        String[] HOME_Menus_ENGZHT = {"Dashboard", "Legal Information", "API"};
        // MONITOR ENGZHT
        String[] MONITOR_Menus_ENGZHT = {"Real-Time Charts", "AppFlow", "SDWAN", "Logs", "Tools & Monitors"};
        // DEVICE ENGZHT
        String[] DEVICE_Menus_ENGZHT = {"Settings (TOP)", "Internal Wireless", "High Availability", "Users", "AppFlow",
                "Network Access Control", "Log", "Diagnostics", "Switch Network", "Access Points", "WWAN"};
        // NETWORK ENGZHT
        String[] NETWORK_Menus_ENGZHT = {"System", "Firewall", "VoIP", "DNS", "Switching", "SDWAN", "IPSec VPN",
                "SSL VPN"};
        // OBJECT ENGZHT
        String[] OBJECT_Menus_ENGZHT = {"Match Objects (TOP)", "Profile Objects", "Action Objects", "Signatures"};
        // POLICY ENGZHT
        String[] POLICY_Menus_ENGZHT = {"Rules and Policies", "DPI-SSL", "DPI-SSH", "Security Services", "Anti-Spam",
                "Capture ATP", "DNS Security", "Endpoint Security"};
        // ------------------------------------------------------------------------------------------------------------------------------
        // --- Make new menu ---
        String main_menu = column_name[column_no];

        // Mark ">" ZHT
        List<String> MenusZHTs_temp = new ArrayList<>();
        for (int i = 0; i < MenusZHTs.size(); i++) {
            String[] MenusZHT_box = null;
            String MenusZHT_temp = MenusZHTs.get(i);
            int iTemp = i;
            int iMenu = 0;

            switch (main_menu){
                case "HOME" -> MenusZHT_box = HOME_Menus_ENGZHT;
                case "MONITOR" -> MenusZHT_box = MONITOR_Menus_ENGZHT;
                case "DEVICE" -> MenusZHT_box = DEVICE_Menus_ENGZHT;
                case "NETWORK" -> MenusZHT_box = NETWORK_Menus_ENGZHT;
                case "OBJECT" -> MenusZHT_box = OBJECT_Menus_ENGZHT;
                case "POLICY" -> MenusZHT_box = POLICY_Menus_ENGZHT;
            }

            // Find parent menu, yes >> end loop, no >> sub-menu (index - 1) continue to find parent menu
            while (iMenu == 0) {
                for (String menusZHTBox : Objects.requireNonNull(MenusZHT_box)) {
                    if (MenusZHT_temp.equals(menusZHTBox)) {
                        iMenu = 1;
                        break;
                    }
                }
                if (iMenu == 0)
                    MenusZHT_temp = MenusZHTs.get(iTemp = iTemp - 1);
            }

            // Add mark to parent/sub-menu, parent menu >> parent menu, sub-menu >> parent menu > sub-menu
            for (String menusZHTBox : MenusZHT_box) {
                if (MenusZHT_temp.equals(menusZHTBox)) {
                    if (iTemp == i) {
                        MenusZHTs_temp.add(menusZHTBox);
                    } else {
                        MenusZHTs_temp.add(menusZHTBox + " > " + MenusZHTs.get(i));
                    }
                }
            }

        }

        // Mark ">" ENG
        List<String> MenusENGs_temp = new ArrayList<>();
        for (int i = 0; i < MenusENGs.size(); i++) {
            String[] MenusENG_box = null;
            String MenusENG_temp = MenusENGs.get(i);
            int iTemp = i;
            int iMenu = 0;
            if (main_menu.equals("HOME"))
                MenusENG_box = HOME_Menus_ENGZHT;
            if (main_menu.equals("MONITOR"))
                MenusENG_box = MONITOR_Menus_ENGZHT;
            if (main_menu.equals("DEVICE"))
                MenusENG_box = DEVICE_Menus_ENGZHT;
            if (main_menu.equals("NETWORK"))
                MenusENG_box = NETWORK_Menus_ENGZHT;
            if (main_menu.equals("OBJECT"))
                MenusENG_box = OBJECT_Menus_ENGZHT;
            if (main_menu.equals("POLICY"))
                MenusENG_box = POLICY_Menus_ENGZHT;

            // Find parent menu, yes >> end loop, no >> sub-menu (index - 1) continue to find parent menu
            while (iMenu == 0) {
                for (String menusENGBox : Objects.requireNonNull(MenusENG_box)) {
                    if (MenusENG_temp.equals(menusENGBox)) {
                        iMenu = 1;
                        break;
                    }
                }
                if (iMenu == 0)
                    MenusENG_temp = MenusENGs.get(iTemp = iTemp - 1);
            }

            // Add mark to parent/sub-menu, parent menu >> parent menu, sub-menu >> parent menu > sub-menu
            for (String menusENGBox : MenusENG_box) {
                if (MenusENG_temp.equals(menusENGBox)) {
                    if (iTemp == i) {
                        MenusENGs_temp.add(menusENGBox);
                    } else {
                        MenusENGs_temp.add(menusENGBox + " > " + MenusENGs.get(i));
                    }
                }
            }

        }

        switch (main_menu){
            case "HOME":
                HOME_MenusZHTs = MenusZHTs_temp;
                HOME_MenusENGs = MenusENGs_temp;
                break;
            case "MONITOR":
                MONITOR_MenusZHTs = MenusZHTs_temp;
                MONITOR_MenusENGs = MenusENGs_temp;
                break;
            case "DEVICE":
                DEVICE_MenusZHTs = MenusZHTs_temp;
                DEVICE_MenusENGs = MenusENGs_temp;
                break;
            case "NETWORK":
                NETWORK_MenusZHTs = MenusZHTs_temp;
                NETWORK_MenusENGs = MenusENGs_temp;
                break;
            case "OBJECT":
                OBJECT_MenusZHTs = MenusZHTs_temp;
                OBJECT_MenusENGs = MenusENGs_temp;
                break;
            case "POLICY":
                POLICY_MenusZHTs = MenusZHTs_temp;
                POLICY_MenusENGs = MenusENGs_temp;
                break;
        }

        // --- Final VS ---
        // Merge data ZHT
        String[] HOME_ZHTs = HOME_MenusZHTs.toArray(new String[0]);
        String[] MONITOR_ZHTs = MONITOR_MenusZHTs.toArray(new String[0]);
        String[] DEVICE_ZHTs = DEVICE_MenusZHTs.toArray(new String[0]);
        String[] NETWORK_ZHTs = NETWORK_MenusZHTs.toArray(new String[0]);
        String[] OBJECT_ZHTs = OBJECT_MenusZHTs.toArray(new String[0]);
        String[] POLICY_ZHTs = POLICY_MenusZHTs.toArray(new String[0]);
        String[][] Menu_ZHTs = {HOME_ZHTs, MONITOR_ZHTs, DEVICE_ZHTs, NETWORK_ZHTs, OBJECT_ZHTs, POLICY_ZHTs};

        // Merge data ENG
        String[] HOME_ENGs = HOME_MenusENGs.toArray(new String[0]);
        String[] MONITOR_ENGs = MONITOR_MenusENGs.toArray(new String[0]);
        String[] DEVICE_ENGs = DEVICE_MenusENGs.toArray(new String[0]);
        String[] NETWORK_ENGs = NETWORK_MenusENGs.toArray(new String[0]);
        String[] OBJECT_ENGs = OBJECT_MenusENGs.toArray(new String[0]);
        String[] POLICY_ENGs = POLICY_MenusENGs.toArray(new String[0]);
        String[][] Menu_ENGs = {HOME_ENGs, MONITOR_ENGs, DEVICE_ENGs, NETWORK_ENGs, OBJECT_ENGs, POLICY_ENGs};

        // ZHT version missing
        for (int i = 0; i < 6; i++) {
            List<String> MenuZHTs = Arrays.asList(Menu_ZHTs[i]);
            String[] MenuENGs = Menu_ENGs[i];
            for (String MenuENG : MenuENGs) {
                if (!MenuZHTs.contains(MenuENG)) {
                    if (MenuENG.contains(" (TOP)")) {
                        MenuENG = MenuENG.replace(" (TOP)", "");
                    }
                    MenusMiss_ZHT.add(main_menu + " > " + MenuENG);
                    match++;
                }
            }
        }

        // ENG version missing
        for (int i = 0; i < 6; i++) {
            List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
            String[] MenuZHTs = Menu_ZHTs[i];
            for (String MenuZHT : MenuZHTs) {
                if (!MenuENGs.contains(MenuZHT)) {
                    if (MenuZHT.contains(" (TOP)")) {
                        MenuZHT = MenuZHT.replace(" (TOP)", "");
                    }
                    MenusMiss_ENG.add(main_menu + " > " + MenuZHT);
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
        log.info("{} > {}", test_name, info);
        exTest.log(LogStatus.INFO, test_name + " > " + info);
        Reporter.log("[S]ReportLog >> " + test_name + " > " + info, true);
    }

    @Test
    public void test_dataCompare() throws IOException {
        start_exReport();

        // Get data ZHT & ENG
        /*{
            {"Dashboard", "System", "Access Points", "Capture ATP", "Topology", "Legal Information", "API"},
            {"aa", "bb"...},
            ...
        }*/
        String[][] Menus_ZHTs = Box_ZHT();
        String[][] Menus_ENGs = box_ENG();

        // [L]Log
        log_message(this.getClass().getName(), "Ready to start...");

        // [L]Log
        log_message(this.getClass().getName(), "--------------------------------------------------------------------");

        // [L]Log (info ZHT)
        List<String> InfoZHTs = info_ZHT();
        log_message(this.getClass().getName(), "[ZHT] info: " + "Device Name -----> " + InfoZHTs.get(0));
        log_message(this.getClass().getName(), "[ZHT] info: " + "Serial Number ---> " + InfoZHTs.get(1));
        log_message(this.getClass().getName(), "[ZHT] info: " + "Firmware Version > " + InfoZHTs.get(2));

        // [L]Log
        log_message(this.getClass().getName(), "--------------------------------------------------------------------");

        // [L]Log (info ZHT)
        List<String> InfoENGs = info_ENG();
        log_message(this.getClass().getName(), "[ENG] info: " + "Device Name -----> " + InfoENGs.get(0));
        log_message(this.getClass().getName(), "[ENG] info: " + "Serial Number ---> " + InfoENGs.get(1));
        log_message(this.getClass().getName(), "[ENG] info: " + "Firmware Version > " + InfoENGs.get(2));

        // [L]Log
        log_message(this.getClass().getName(), "--------------------------------------------------------------------");

        // Compare data ZHT & ENG
        // String[] >> List<String>
        for (int i = 0; i < 6; i++) {
            List<String> MenusZHTs = Arrays.asList(Menus_ZHTs[i]);
            List<String> MenusENGs = Arrays.asList(Menus_ENGs[i]);
            match = missing_page(i, MenusZHTs, MenusENGs);
        }
        // All match or not
        if (match == 0) {
            log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log_message(this.getClass().getName(), "^          All Matched!          ^");
            log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }else{
            // [ZHT] version missing
            for (String MenusMissZHT : MenusMiss_ZHT) {
                log_message(this.getClass().getName(), "[ZHT] version missing: " + MenusMissZHT);
            }
            // [ENG] version missing
            for (String MenusMissENG : MenusMiss_ENG) {
                log_message(this.getClass().getName(), "[ENG] version missing: " + MenusMissENG);
            }

            log_message(this.getClass().getName(), "[ENG] & [ZHT] mismatch count: " + match);
        }

        close_exReport();
    }

}
