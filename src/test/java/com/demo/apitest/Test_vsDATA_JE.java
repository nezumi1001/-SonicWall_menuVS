package com.demo.apitest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Test_vsDATA_JE {
    private final File my_path = new File(System.getProperty("user.dir"));
    private final Logger log = LogManager.getLogger(this.getClass().getName());
    private int match = 0;
    private ExtentReports exReport;
    private ExtentTest exTest;
    private List<String> MenusMiss_JPN = new ArrayList<>();
    private List<String> MenusMiss_ENG = new ArrayList<>();

    // Import data only (info JPN)
    public List<String> info_JPN() throws IOException {
        List<String> data_infos_JPN = new ArrayList<>();
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
        List<String> data_infos_ENG = new ArrayList<>();
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
        List<String> menu_HOME = new ArrayList<>();
        List<String> menu_MONITOR = new ArrayList<>();
        List<String> menu_DEVICE = new ArrayList<>();
        List<String> menu_NETWORK = new ArrayList<>();
        List<String> menu_OBJECT = new ArrayList<>();
        List<String> menu_POLICY = new ArrayList<>();
        // Import data JPN
        FileInputStream fs_JPN = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_JPN.xls");
        HSSFWorkbook workbook_JPN = new HSSFWorkbook(fs_JPN);
        HSSFSheet sheet = workbook_JPN.getSheet("JPN");
        // Get data JPN
        for (int data_column = 0; data_column < sheet.getRow(data_column).getLastCellNum(); data_column++) {
            for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
                HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
                // Go on to new column when arriving at the last row
                if (data_value == null) {
                    continue;
                }
                String dataValue = data_value.getStringCellValue();

                switch (data_column) {
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
        String[][] menu_JPN = {menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs};
        // [L]Log
        log_message(this.getClass().getName(), "Got data!");
        workbook_JPN.close();
        return menu_JPN;
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
        FileInputStream fs_ENG = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_ENG.xls");
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

                switch (data_column) {
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
    public int missing_page(int column_no, List<String> MenusJPNs, List<String> MenusENGs) {
        // Column name
        String[] column_name = {"HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY"};
        // New menu JPN
        List<String> HOME_MenusJPNs = new ArrayList<>();
        List<String> MONITOR_MenusJPNs = new ArrayList<>();
        List<String> DEVICE_MenusJPNs = new ArrayList<>();
        List<String> NETWORK_MenusJPNs = new ArrayList<>();
        List<String> OBJECT_MenusJPNs = new ArrayList<>();
        List<String> POLICY_MenusJPNs = new ArrayList<>();

        // New menu ENG
        List<String> HOME_MenusENGs = new ArrayList<>();
        List<String> MONITOR_MenusENGs = new ArrayList<>();
        List<String> DEVICE_MenusENGs = new ArrayList<>();
        List<String> NETWORK_MenusENGs = new ArrayList<>();
        List<String> OBJECT_MenusENGs = new ArrayList<>();
        List<String> POLICY_MenusENGs = new ArrayList<>();

        // Parent menu for each column
        // HOME ENGJPN
        String[] HOME_Menus_ENGJPN = {"Dashboard", "Legal Information", "API"};
        // MONITOR ENGJPN
        String[] MONITOR_Menus_ENGJPN = {"Real-Time Charts", "AppFlow", "SDWAN", "Logs", "Tools & Monitors"};
        // DEVICE ENGJPN
        String[] DEVICE_Menus_ENGJPN = {"Settings (TOP)", "Internal Wireless", "High Availability", "Users", "AppFlow",
                "Network Access Control", "Log", "Diagnostics", "Switch Network", "Access Points", "WWAN"};
        // NETWORK ENGJPN
        String[] NETWORK_Menus_ENGJPN = {"System", "Firewall", "VoIP", "DNS", "Switching", "SDWAN", "Cloud Secure Edge", "IPSec VPN",
                "SSL VPN"};
        // OBJECT ENGJPN
        String[] OBJECT_Menus_ENGJPN = {"Match Objects (TOP)", "Profile Objects", "Action Objects", "Signatures"};
        // POLICY ENGJPN
        String[] POLICY_Menus_ENGJPN = {"Rules and Policies", "DPI-SSL", "DPI-SSH", "Security Services", "Anti-Spam",
                "Capture ATP", "DNS Security", "Endpoint Security"};
        // ------------------------------------------------------------------------------------------------------------------------------
        // --- Make new menu ---
        String main_menu = column_name[column_no];

        // Mark ">" JPN
        List<String> MenusJPNs_temp = new ArrayList<>();
        for (int i = 0; i < MenusJPNs.size(); i++) {
            String[] MenusJPN_box = null;
            String MenusJPN_temp = MenusJPNs.get(i);
            int iTemp = i;
            int iMenu = 0;

            switch (main_menu) {
                case "HOME" -> MenusJPN_box = HOME_Menus_ENGJPN;
                case "MONITOR" -> MenusJPN_box = MONITOR_Menus_ENGJPN;
                case "DEVICE" -> MenusJPN_box = DEVICE_Menus_ENGJPN;
                case "NETWORK" -> MenusJPN_box = NETWORK_Menus_ENGJPN;
                case "OBJECT" -> MenusJPN_box = OBJECT_Menus_ENGJPN;
                case "POLICY" -> MenusJPN_box = POLICY_Menus_ENGJPN;
            }

            // Find parent menu, yes >> end loop, no >> sub-menu (index - 1) continue to find parent menu
            while (iMenu == 0) {
                for (String menusJPNBox : Objects.requireNonNull(MenusJPN_box)) {
                    if (MenusJPN_temp.equals(menusJPNBox)) {
                        iMenu = 1;
                        break;
                    }
                }
                if (iMenu == 0)
                    MenusJPN_temp = MenusJPNs.get(iTemp = iTemp - 1);
            }

            // Add mark to parent/sub-menu, parent menu >> parent menu, sub-menu >> parent menu > sub-menu
            for (String menusJPNBox : MenusJPN_box) {
                if (MenusJPN_temp.equals(menusJPNBox)) {
                    if (iTemp == i) {
                        MenusJPNs_temp.add(menusJPNBox);
                    } else {
                        MenusJPNs_temp.add(menusJPNBox + " > " + MenusJPNs.get(i));
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
                MenusENG_box = HOME_Menus_ENGJPN;
            if (main_menu.equals("MONITOR"))
                MenusENG_box = MONITOR_Menus_ENGJPN;
            if (main_menu.equals("DEVICE"))
                MenusENG_box = DEVICE_Menus_ENGJPN;
            if (main_menu.equals("NETWORK"))
                MenusENG_box = NETWORK_Menus_ENGJPN;
            if (main_menu.equals("OBJECT"))
                MenusENG_box = OBJECT_Menus_ENGJPN;
            if (main_menu.equals("POLICY"))
                MenusENG_box = POLICY_Menus_ENGJPN;

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

        switch (main_menu) {
            case "HOME":
                HOME_MenusJPNs = MenusJPNs_temp;
                HOME_MenusENGs = MenusENGs_temp;
                break;
            case "MONITOR":
                MONITOR_MenusJPNs = MenusJPNs_temp;
                MONITOR_MenusENGs = MenusENGs_temp;
                break;
            case "DEVICE":
                DEVICE_MenusJPNs = MenusJPNs_temp;
                DEVICE_MenusENGs = MenusENGs_temp;
                break;
            case "NETWORK":
                NETWORK_MenusJPNs = MenusJPNs_temp;
                NETWORK_MenusENGs = MenusENGs_temp;
                break;
            case "OBJECT":
                OBJECT_MenusJPNs = MenusJPNs_temp;
                OBJECT_MenusENGs = MenusENGs_temp;
                break;
            case "POLICY":
                POLICY_MenusJPNs = MenusJPNs_temp;
                POLICY_MenusENGs = MenusENGs_temp;
                break;
        }

        // --- Final VS ---
        // Merge data JPN
        String[] HOME_JPNs = HOME_MenusJPNs.toArray(new String[0]);
        String[] MONITOR_JPNs = MONITOR_MenusJPNs.toArray(new String[0]);
        String[] DEVICE_JPNs = DEVICE_MenusJPNs.toArray(new String[0]);
        String[] NETWORK_JPNs = NETWORK_MenusJPNs.toArray(new String[0]);
        String[] OBJECT_JPNs = OBJECT_MenusJPNs.toArray(new String[0]);
        String[] POLICY_JPNs = POLICY_MenusJPNs.toArray(new String[0]);
        String[][] Menu_JPNs = {HOME_JPNs, MONITOR_JPNs, DEVICE_JPNs, NETWORK_JPNs, OBJECT_JPNs, POLICY_JPNs};

        // Merge data ENG
        String[] HOME_ENGs = HOME_MenusENGs.toArray(new String[0]);
        String[] MONITOR_ENGs = MONITOR_MenusENGs.toArray(new String[0]);
        String[] DEVICE_ENGs = DEVICE_MenusENGs.toArray(new String[0]);
        String[] NETWORK_ENGs = NETWORK_MenusENGs.toArray(new String[0]);
        String[] OBJECT_ENGs = OBJECT_MenusENGs.toArray(new String[0]);
        String[] POLICY_ENGs = POLICY_MenusENGs.toArray(new String[0]);
        String[][] Menu_ENGs = {HOME_ENGs, MONITOR_ENGs, DEVICE_ENGs, NETWORK_ENGs, OBJECT_ENGs, POLICY_ENGs};

        // JPN version missing
        for (int i = 0; i < 6; i++) {
            List<String> MenuJPNs = Arrays.asList(Menu_JPNs[i]);
            String[] MenuENGs = Menu_ENGs[i];
            for (String MenuENG : MenuENGs) {
                if (!MenuJPNs.contains(MenuENG)) {
                    if (MenuENG.contains(" (TOP)")) {
                        MenuENG = MenuENG.replace(" (TOP)", "");
                    }
                    MenusMiss_JPN.add(main_menu + " > " + MenuENG);
                    match++;
                }
            }
        }

        // ENG version missing
        for (int i = 0; i < 6; i++) {
            List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
            String[] MenuJPNs = Menu_JPNs[i];
            for (String MenuJPN : MenuJPNs) {
                if (!MenuENGs.contains(MenuJPN)) {
                    if (MenuJPN.contains(" (TOP)")) {
                        MenuJPN = MenuJPN.replace(" (TOP)", "");
                    }
                    MenusMiss_ENG.add(main_menu + " > " + MenuJPN);
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
//        log.info(test_name + " > " + info);
        log.info("{} > {}", test_name, info);
        exTest.log(LogStatus.INFO, test_name + " > " + info);
        Reporter.log("[S]ReportLog >> " + test_name + " > " + info, true);
    }

    @Test
    public void test_dataCompare() throws IOException {
        start_exReport();

        // Get data JPN & ENG
        /*{
            {"Dashboard", "System", "Access Points", "Capture ATP", "Topology", "Legal Information", "API"},
            {"aa", "bb"...},
            ...
        }*/
        String[][] Menus_JPNs = box_JPN();
        String[][] Menus_ENGs = box_ENG();

        // [L]Log
        log_message(this.getClass().getName(), "Running 'Contemporary Mode'...");
        log_message(this.getClass().getName(), "--------------------------------------------------------------------");

        // [L]Log (info JPN)
        List<String> InfoJPNs = info_JPN();
        log_message(this.getClass().getName(), "[JPN] info: " + "Device Name -----> " + InfoJPNs.get(0));
        log_message(this.getClass().getName(), "[JPN] info: " + "Serial Number ---> " + InfoJPNs.get(1));
        log_message(this.getClass().getName(), "[JPN] info: " + "Firmware Version > " + InfoJPNs.get(2));

        // [L]Log
        log_message(this.getClass().getName(), "--------------------------------------------------------------------");

        // [L]Log (info JPN)
        List<String> InfoENGs = info_ENG();
        log_message(this.getClass().getName(), "[ENG] info: " + "Device Name -----> " + InfoENGs.get(0));
        log_message(this.getClass().getName(), "[ENG] info: " + "Serial Number ---> " + InfoENGs.get(1));
        log_message(this.getClass().getName(), "[ENG] info: " + "Firmware Version > " + InfoENGs.get(2));

        // [L]Log
        log_message(this.getClass().getName(), "--------------------------------------------------------------------");

        // Compare data JPN & ENG
        // String[] >> List<String>
        for (int i = 0; i < 6; i++) {
            List<String> MenusJPNs = Arrays.asList(Menus_JPNs[i]);
            List<String> MenusENGs = Arrays.asList(Menus_ENGs[i]);
            match = missing_page(i, MenusJPNs, MenusENGs);
        }
        // All match or not
        if (match == 0) {
            log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log_message(this.getClass().getName(), "^          All Matched!          ^");
            log_message(this.getClass().getName(), "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        } else {
            // [JPN] version missing
            for (String MenusMissJPN : MenusMiss_JPN) {
                log_message(this.getClass().getName(), "[JPN] version missing: " + MenusMissJPN);
            }
            // [ENG] version missing
            for (String MenusMissENG : MenusMiss_ENG) {
                log_message(this.getClass().getName(), "[ENG] version missing: " + MenusMissENG);
            }

            log_message(this.getClass().getName(), "[ENG] & [JPN] mismatch count: " + match);
        }

        close_exReport();
    }

}
