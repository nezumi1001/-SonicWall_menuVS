package com.demo.apitest;

import java.io.File;

public class Data_ZHT {
    // Box info
//	public static String baseUrl = "https://10.103.50.77"; // TZ 270W
    public static String baseUrl = "https://10.8.162.204"; // NSa 5700

    // Check list
    public static int check_list = 1;

    // ChromeDriver Settings
    public static File my_path = new File(System.getProperty("user.dir"));
    public static String[] chromeDriver_data = { "webdriver.chrome.driver",
            my_path.getParent() + "\\SonicWall_menuVS\\src\\main\\resources\\Driver\\chromedriver.exe" };
    public static String Chrome_userData = "--user-data-dir=C:\\Users\\admin\\AppData\\Local\\Google\\Chrome\\User Data2";

    // Preempt
    public static String preempt_path = "//button[contains(text(),'非設定')]";
    // Username field
    public static String userName_path = "//input[contains(@placeholder,'輸入您的使用者名稱')]";
    public static String login_name = "admin";
    // Password field
    public static String password_path = "//input[contains(@placeholder,'輸入您的密碼')]";

    //	public static String login_pass = "password";
    public static String login_pass = "sonicwall";
//	public static String login_pass = "laotouzi";

    // LOGIN button
    public static String login_path = "//div[@class='sw-login__trigger-cont sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items sw-flexbox--center-justify']/div[contains(text(),'登入')]";

    // Config mode
    public static String Config_path = "//div[@class='sw-toggle sw-toggle--left sw-toggle--regular sw-toggle--light']";

    // Firmware and Settings URL
    public static String FirmwareSettings_url = baseUrl + "/sonicui/7/m/mgmt/system/settings/firmware";
    // Box name
    public static String Box_path = "//div[@class='fw-app-header__head__app-name sw-flexbox__flex-none']/span";
    public static String SN_path = "//span[@class='fw-app-header__breadcrumb-device-name']";
    public static String Version_path_01 = "//div[@class='sw-table-row__cell__wrapper sw-flexbox__flex sw-flexbox sw-flexbox--center-items']/div/div/div/span[1]";
    public static String Version_path_02 = "//div[@class='sw-table-row__cell__wrapper sw-flexbox__flex sw-flexbox sw-flexbox--center-items']/div/div/div[2]";

    // Top menu URL
    public static String[][] Menu_url = { { "HOME", baseUrl + "/sonicui/7/m/dashboard/overview/status/device" },
            { "MONITOR", baseUrl + "/sonicui/7/m/mgmt/system/real-time-monitor-ng" }, // 7.1.1
            { "DEVICE", baseUrl + "/sonicui/7/m/mgmt/system/license-enhanced" },
            { "NETWORK", baseUrl + "/sonicui/7/m/mgmt/network/interfaces" },
            { "OBJECT", baseUrl + "/sonicui/7/m/mgmt/objects/zones" },
            { "POLICY", baseUrl + "/sonicui/7/m/mgmt/policies/ngpe-access-rules" } };

    // Left
    public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
    // Dark
    public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
    // Nested
    public static String SubMenu_nested = "//ul[@class='sw-nav-group__items sw-nav-group__items--nested-level-0']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

    // ===================================================================================================================================================================================
    // HOME
    public static String[][] leftPane_HOME = { { "儀表板", "Dashboard" }, { "系統", "System" }, { "存取點", "Access Points" },
            { "擷取 ATP", "Capture ATP" }, { "拓撲", "Topology" }, { "法律資訊", "Legal Information" }, { "API", "API" } };

    // MONITOR
    public static String[][] leftPane_MONITOR = { { "即時圖表", "Real-Time Charts" }, { "系統監視器", "System Monitor" },
            { "通訊協定監視", "Protocol Monitor" }, { "使用者監視器", "User Monitor" }, { "BWM 監視器", "BWM Monitor" },
            { "AppFlow", "AppFlow" }, { "AppFlow 報告", "AppFlow Report" }, { "AppFlow 監視器", "AppFlow Monitor" },
            { "CTA 報告", "CTA Report" }, { "SDWAN", "SDWAN" }, { "SDWAN 監視器", "SDWAN Monitor" },
            { "SD-WAN 連線", "SD-WAN Connections" }, { "記錄", "Logs" }, { "系統記錄", "System Logs" },
            { "稽核記錄", "Auditing Logs" }, { "威脅記錄", "Threat Logs" }, { "工具與監視器", "Tools & Monitors" },
            { "封包監視", "Packet Monitor" }, { "連線", "Connections" }, { "核心 0 處理序", "Core 0 Processes" },
            { "封包重放", "Packet Replay" } };

    // DEVICE
    public static String[][] leftPane_DEVICE = { { "設定", "Settings" }, { "授權", "Licenses" }, { "管理", "Administration" },
            { "時間", "Time" }, { "憑證", "Certificates" }, { "SNMP", "SNMP" }, { "韌體與設定", "Firmware and Settings" },
            { "儲存空間", "Storage" }, { "重新啟動", "Restart" }, { "內部無線", "Internal Wireless" }, { "狀態", "Status" },
            { "安全性", "Security" }, { "進階", "Advanced" }, { "MAC 篩選器清單", "MAC Filter List" }, { "IDS", "IDS" },
            { "虛擬存取點", "Virtual Access Point" }, { "高可用性", "High Availability" }, { "監視", "Monitoring" },
            { "使用者", "Users" }, { "分割區", "Partitions" }, { "本機使用者與群組", "Local Users & Groups" },
            { "來賓服務", "Guest Services" }, { "來賓帳戶", "Guest Accounts" }, { "來賓狀態", "Guest Status" },
            { "AppFlow", "AppFlow" }, { "流量報告", "Flow Reporting" }, { "AppFlow 代理程式", "AppFlow Agent" },
            { "網路存取控制", "Network Access Control" }, { "工作階段", "Sessions" }, { "記錄", "Log" }, { "Syslog", "Syslog" },
            { "自動化", "Automation" }, { "名稱解析", "Name Resolution" }, { "報告", "Reports" }, { "AWS", "AWS" },
            { "診斷", "Diagnostics" }, { "技術支援報告", "Tech Support Report" }, { "檢查網路設定", "Check Network Settings" },
            { "DNS 名稱查詢", "DNS Name Lookup" }, { "網路路徑", "Network Path" }, { "偵測", "Ping" }, { "追蹤路由", "Trace Route" },
            { "即時封鎖清單", "Real-Time Blacklist" }, { "反向名稱查詢", "Reverse Name Lookup" }, { "連線 TopX", "Connection TopX" },
            { "Geo 和 Botnet", "Geo and Botnet" }, { "MX 和橫幅", "MX and Banner" }, { "GRID 檢查", "GRID Check" },
            { "URL 評等要求", "URL Rating Request" }, { "PMTU 探索", "PMTU Discovery" }, { "交換器診斷", "Switch Diagnostics" },
            { "交換器網路", "Switch Network" }, { "概觀", "Overview" }, { "交換器", "Switches" }, { "存取點", "Access Points" },
            { "韌體管理", "Firmware Management" }, { "平面設計圖檢視", "Floor Plan View" }, { "站台狀態", "Station Status" },
            { "IDS", "IDS" }, { "進階 IDP", "Advanced IDP" }, { "封包擷取", "Packet Capture" },
            { "虛擬存取點", "Virtual Access Point" }, { "RF 監視", "RF Monitoring" }, { "RF 分析", "RF Analysis" },
            { "RF 頻譜", "RF Spectrum" }, { "FairNet", "FairNet" }, { "Wi-Fi 多媒體", "Wi-Fi Multimedia" },
            { "3G/4G/LTE WWAN", "3G/4G/LTE WWAN" }, { "藍牙 LE", "Bluetooth LE" }, { "無線電管理", "Radio Management" },
            { "WWAN", "WWAN" } };

    // NETWORK
    public static String[][] leftPane_NETWORK = { { "系統", "System" }, { "介面", "Interfaces" },
            { "容錯移轉和負載平衡", "Failover & LB" }, { "探索芳鄰", "Neighbor Discovery" }, { "ARP", "ARP" },
            { "MAC-IP 反詐騙", "MAC IP Anti-Spoof" }, { "Web 代理", "Web Proxy" }, { "PortShield 群組", "PortShield Groups" },
            { "xxx", "PoE Settings" }, { "VLAN 轉譯", "VLAN Translation" }, { "IP 協助程式", "IP Helper" },
            { "動態路由", "Dynamic Routing" }, { "DHCP 伺服器", "DHCP Server" }, { "多點傳送", "Multicast" },
            { "網路監視器", "Network Monitor" }, { "AWS 設定", "AWS Configuration" }, { "防火牆", "Firewall" },
            { "進階", "Advanced" }, { "洪水攻擊防護", "Flood Protection" }, { "SSL 控制", "SSL Control" },
            { "加密控制", "Cipher Control" }, { "RBL 篩選條件", "RBL Filter" }, { "VoIP", "VoIP" }, { "設定", "Settings" },
            { "呼叫狀態", "Call Status" }, { "DNS", "DNS" }, { "動態 DNS", "Dynamic DNS" }, { "DNS 代理", "DNS Proxy" },
            { "DNS 安全性", "DNS Security" }, { "交換器", "Switching" }, { "VLAN 主幹", "VLAN Trunking" },
            { "L2 探索", "L2 Discovery" }, { "連結彙總", "Link Aggregation" }, { "連接埠鏡像", "Port Mirroring" },
            { "SDWAN", "SDWAN" }, { "群組", "Groups" }, { "SLA 探查", "SLA Probes" }, { "SLA 類別物件", "SLA Class Objects" },
            { "路徑選取設定檔", "Path Selection Profiles" }, { "規則", "Rules" }, { "IPsec VPN", "IPSec VPN" },
            { "規則與設定", "Rules and Settings" }, { "透過 VPN 的 DHCP", "DHCP over VPN" }, { "L2TP 伺服器", "L2TP Server" },
            { "AWS VPN", "AWS VPN" }, { "SSL VPN", "SSL VPN" }, { "狀態", "Status" }, { "伺服器設定", "Server Settings" },
            { "用戶端設定", "Client Settings" }, { "入口網站設定", "Portal Settings" }, { "虛擬辦公室", "Virtual Office" } };

    // OBJECT
    public static String[][] leftPane_OBJECT = { { "比對物件", "Match Objects" }, { "區域", "Zones" }, { "位址", "Addresses" },
            { "服務", "Services" }, { "URI 清單", "URI Lists" }, { "信譽", "Reputation" }, { "比對物件", "Match Objects" },
            { "排程", "Schedules" }, { "動態群組", "Dynamic Group" }, { "電子郵件地址", "Email Addresses" },
            { "設定檔物件", "Profile Objects" }, { "端點安全性", "Endpoint Security" }, { "頻寬", "Bandwidth" },
            { "QoS 標記", "QoS Marking" }, { "內容篩選", "Content Filter" }, { "DHCP 選項", "DHCP Option" }, { "AWS", "AWS" },
            { "DNS 篩選", "DNS Filtering" }, { "動作物件", "Action Objects" }, { "應用程式規則執行", "App Rule Actions" },
            { "內容篩選器執行", "Content Filter Actions" } };

    // POLICY
    public static String[][] leftPane_POLICY = { { "規則與原則", "Rules and Policies" }, { "存取規則", "Access Rules" },
            { "NAT 規則", "NAT Rules" }, { "路由規則", "Routing Rules" }, { "DNS 規則", "DNS Rules" },
            { "內容篩選規則", "Content Filter Rules" }, { "應用程式規則", "App Rules" }, { "端點規則", "Endpoint Rules" },
            { "DPI-SSL", "DPI-SSL" }, { "用戶端 SSL", "Client SSL" }, { "伺服器 SSL", "Server SSL" },
            { "DPI-SSH", "DPI-SSH" }, { "設定", "Settings" }, { "安全性服務", "Security Services" }, { "摘要", "Summary" },
            { "閘道防病毒", "Gateway Anti-Virus" }, { "防間諜軟體", "Anti-Spyware" }, { "入侵防護", "Intrusion Prevention" },
            { "Geo-IP 篩選條件", "Geo-IP Filter" }, { "Botnet 篩選器", "Botnet Filter" }, { "應用程式控制", "App Control" },
            { "內容篩選", "Content Filter" }, { "反垃圾郵件", "Anti-Spam" }, { "狀態", "Status" }, { "轉送網域", "Relay Domains" },
            { "垃圾郵件箱訊息", "Junk Box Messages" }, { "垃圾儲存區設定", "Junk Box Settings" }, { "垃圾儲存區摘要", "Junk Box Summary" },
            { "使用者檢視設定", "User View Setup" }, { "通訊錄", "Address Books" }, { "管理使用者", "Manage Users" },
            { "LDAP 設定", "LDAP Configuration" }, { "進階", "Advanced" }, { "下載", "Downloads" },
            { "擷取 ATP", "Capture ATP" }, { "掃描歷程記錄", "Scanning History" }, { "DNS 安全性", "DNS Security" },
            { "報告", "Reports" }, { "端點安全性", "Endpoint Security" } };

}

