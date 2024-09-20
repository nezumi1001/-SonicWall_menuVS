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
    public String[] box_JPN() throws IOException {
        List<String> menu_ALL = new ArrayList<>();
        // Import data JPN
        FileInputStream fs_JPN = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_JPN.xls");
        HSSFWorkbook workbook_JPN = new HSSFWorkbook(fs_JPN);
        HSSFSheet sheet = workbook_JPN.getSheet("JPN");
        // Get data JPN
        for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
            HSSFCell data_value = sheet.getRow(data_row).getCell(0);
            // Go on to new column when arriving at the last row
            if (data_value == null) {
                continue;
            }
            String dataValue = data_value.getStringCellValue();
            menu_ALL.add(dataValue);
        }

        // Merge data JPN
        // List<String> >> String[]
        String[] menu_JPN = menu_ALL.toArray(new String[0]);
        // [L]Log
        log_message(this.getClass().getName(), "Got data!");
        workbook_JPN.close();
        return menu_JPN;
    }

    // box_ENG
    public String[] box_ENG() throws IOException {
        List<String> menu_ALL = new ArrayList<>();
        // Import data ENG
        FileInputStream fs_ENG = new FileInputStream(my_path + "\\src\\main\\resources\\Data\\compare\\Box_ENG.xls");
        HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
        HSSFSheet sheet = workbook_ENG.getSheet("ENG");
        // Get data ENG
        for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
            HSSFCell data_value = sheet.getRow(data_row).getCell(0);
            // Go on to new column when arriving at the last row
            if (data_value == null) {
                continue;
            }
            String dataValue = data_value.getStringCellValue();
            menu_ALL.add(dataValue);
        }

        // Merge data JPN
        // List<String> >> String[]
        String[] menu_ENG = menu_ALL.toArray(new String[0]);
        // [L]Log
        log_message(this.getClass().getName(), "Got data!");
        workbook_ENG.close();
        return menu_ENG;
    }

    // Get missing page
    public int missing_page(List<String> MenusJPNs, List<String> MenusENGs) {
        // New menu JPN
        List<String> MenusJPNs_ALL = new ArrayList<>();

        // New menu ENG
        List<String> MenusENGs_ALL = new ArrayList<>();

        // Parent menu for each column
        // ALL ENGJPN
        String[] Menus_ENGJPN = {
                "Dashboard", "Monitor (TOP)", "System", "Diagnostics", "Network", "Switching", "SD-WAN",
                "Cloud Secure Edge", "Switch Network", "Internal Wireless", "Access Points", "WWAN", "Firewall", "Firewall Settings",
                "DPI-SSL", "DPI-SSH", "Capture ATP", "VoIP", "Anti-Spam", "VPN", "SSL VPN",
                "Users", "High Availability", "Security Services", "DNS Security", "AppFlow", "Network Access Control", "Log"
        };

        // ------------------------------------------------------------------------------------------------------------------------------
        // Mark ">" JPN
        List<String> MenusJPNs_temp = new ArrayList<>();
        for (int i = 0; i < MenusJPNs.size(); i++) {
            String[] MenusJPN_box = null;
            String MenusJPN_temp = MenusJPNs.get(i);
            int iTemp = i;
            int iMenu = 0;

            MenusJPN_box = Menus_ENGJPN;

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

            MenusENG_box = Menus_ENGJPN;

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

        MenusJPNs_ALL = MenusJPNs_temp;
        MenusENGs_ALL = MenusENGs_temp;

        // --- Final VS ---
        // Merge data JPN
        String[] Menu_JPNs = MenusJPNs_ALL.toArray(new String[0]);

        // Merge data ENG
        String[] Menu_ENGs = MenusENGs_ALL.toArray(new String[0]);

        // JPN version missing
        List<String> MenuJPNs = Arrays.asList(Menu_JPNs);
        for (String MenuENG : Menu_ENGs) {
            if (!MenuJPNs.contains(MenuENG)) {
                if (MenuENG.contains(" (TOP)")) {
                    MenuENG = MenuENG.replace(" (TOP)", "");
                }
                MenusMiss_JPN.add(MenuENG);
                match++;
            }
        }

        // ENG version missing
        List<String> MenuENGs = Arrays.asList(Menu_ENGs);
        for (String MenuJPN : Menu_JPNs) {
            if (!MenuENGs.contains(MenuJPN)) {
                if (MenuJPN.contains(" (TOP)")) {
                    MenuJPN = MenuJPN.replace(" (TOP)", "");
                }
                MenusMiss_ENG.add(MenuJPN);
                match++;
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
            {"Dashboard", "System", "Access Points", "Capture ATP", "Topology", "Legal Information", "API", ...},
        }*/
        String[] Menus_JPNs = box_JPN();
        String[] Menus_ENGs = box_ENG();

        // [L]Log
        log_message(this.getClass().getName(), "Running 'Classic Mode'...");
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
        List<String> MenusJPNs = Arrays.asList(Menus_JPNs);
        List<String> MenusENGs = Arrays.asList(Menus_ENGs);
        match = missing_page(MenusJPNs, MenusENGs);
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
