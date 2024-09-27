package com.demo.apitest;

import java.io.File;

public class Data_JPN {
    // Check list
    public static int check_list = 1;

    // Box info
//    public static String baseUrl = "https://10.103.50.65"; // TZ 270W
    public static String baseUrl = "https://10.8.162.154"; // NSA 2700

    // ChromeDriver Settings
    public static File my_path = new File(System.getProperty("user.dir"));
    public static String[] chromeDriver_data = {"webdriver.chrome.driver",
            my_path.getParent() + "\\SonicWall_menuVS\\src\\main\\resources\\Driver\\chromedriver.exe"};
    public static String Chrome_userData = "--user-data-dir=C:\\Users\\wodem\\AppData\\Local\\Google\\Chrome\\User Data2";

    // Preempt
    public static String preempt_path = "//button[contains(text(),'非構成')]";

    // Classic Mode
    public static String AD_path = "//span[@class='sw-avatar__initials']";
    public static String old_path = "//div[@class='sw-toggle sw-toggle--left sw-toggle--compact sw-toggle--light fw-app-header__view-toggle sw-flexbox__flex-none']";

    // Username field
    public static String userName_path = "//input[contains(@placeholder,'ユーザ名を入力')]";
    public static String login_name = "admin";
    // Password field
    public static String password_path = "//input[contains(@placeholder,'パスワードを入力')]";
    public static String login_pass = "sonicwall";

    // LOGIN button
    public static String login_path = "//div[@class='sw-login__trigger-cont sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items sw-flexbox--center-justify']/div[contains(text(),'ログイン')]";
//	public static String login_path = "//div[@class='sw-login sw-login--desktop sw-typo-default sw-flexbox']//div[contains(text(),'ログイン')]"; // 7.0.1

    // Config mode
    public static String Config_path = "//div[@class='sw-toggle sw-toggle--left sw-toggle--regular sw-toggle--light']";

    // Firmware and Settings URL
    public static String FirmwareSettings_url = baseUrl + "/sonicui/7/m/mgmt/system/settings/firmware";
    // Box name
    public static String Box_name = "//div[@class='fw-app-header__head__app-name sw-flexbox__flex-none']/span";
    public static String SN_name = "//span[@class='fw-app-header__breadcrumb-device-name']";
    public static String CurrentFirmwareVersion = "//div[@class='sw-table-row__cell__wrapper sw-flexbox__flex sw-flexbox sw-flexbox--center-items']/div/div/div/span[1]";
    public static String FirmwareVersion = "//div[@class='sw-table-row__cell__wrapper sw-flexbox__flex sw-flexbox sw-flexbox--center-items']/div/div/div[2]";

    // Left
    public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
    // Dark
    public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
    // Nested
    public static String SubMenu_nested = "//ul[@class='sw-nav-group__items sw-nav-group__items--nested-level-0']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

    // ===================================================================================================================================================================================
    // leftPane_ALL
    public static String[][] leftPane_ALL = {
            // ==============================================
            {"ダッシュボード", "Dashboard"},
            {"概要", "Overview"},
            {"トポロジ", "Topology"},
            {"アクセス ポイント", "Access Points"},
            // ==============================================
            {"監視", "Monitor"}, // Fix Top-menu
            {"リアルタイム監視", "Real-Time Monitor"},
            {"AppFlow 監視", "AppFlow Monitor"},
            {"AppFlow 報告", "AppFlow Reports"},
            {"脅威ログ", "Threat Logs"},
            {"ユーザ監視", "User Monitor"},
            {"帯域幅管理監視", "BWM Monitor"},
            {"プロトコル監視", "Protocol Monitor"},
            {"接続監視", "Connection Monitor"},
            {"パケット監視", "Packet Monitor"},
            {"ログ監視", "Log Monitor"},
            {"コア 0 プロセス", "Core 0 Processes"},
            {"SD-WAN 監視", "SD-WAN Monitor"},
            {"SD-WAN 接続ログ", "SD-WAN Connection Logs"},
            // ==============================================
            {"システム", "System"},
            {"ライセンス", "Licenses"},
            {"管理", "Administration"},
            {"SNMP", "SNMP"},
            {"証明書", "Certificates"},
            {"時間", "Time"},
            {"スケジュール", "Schedules"},
            {"ファームウェアとバックアップ", "Firmware & Backups"},
            {"記憶装置", "Storage"},
            {"再起動", "Restart"},
            {"法的情報", "Legal Information"},
            {"API", "API"},
            // ==============================================
            {"診断", "Diagnostics"},
            {"テクニカル サポート レポート", "Tech Support Report"},
            {"ネットワーク設定の確認", "Check Network Settings"},
            {"DNS 名の調査", "DNS Name Lookup"},
            {"ネットワーク パス", "Network Path"},
            {"Ping", "Ping"},
            {"ルート追跡", "Trace Route"},
            {"パケット再生", "Packet Replay"},
            {"リアルタイム ブラックリスト", "Real-Time Blacklist"},
            {"逆引き名前調査", "Reverse Name Lookup"},
            {"上位接続", "Connection TopX"},
            {"地域とボットネット", "Geo and Botnet"},
            {"MX とバナー", "MX and Banner"},
            {"グリッド確認", "GRID Check"},
            {"URL 格付け要求", "URL Rating Request"},
            {"PMTU 検出", "PMTU Discovery"},
            {"スイッチ診断", "Switch Diagnostics"},
            // ==============================================
            {"ネットワーク", "Network"},
            {"インターフェース", "Interfaces"},
            {"PortShield グループ", "PortShield Groups"},
            {"VLAN 変換", "VLAN Translation"},
            {"フェイルオーバーと負荷分散", "Failover & LB"},
            {"ゾーン", "Zones"},
            {"DNS", "DNS"},
            {"DNS ルール", "DNS Rules"},
            {"DNS プロキシ", "DNS Proxy"},
            {"アドレス オブジェクト", "Address Objects"},
            {"サービス", "Services"},
            {"ルーティング", "Routing"},
            {"ルーティング ポリシー", "Routing Policy"},
            {"NAT ポリシー", "NAT Policy"},
            {"ARP", "ARP"},
            {"近隣者検出", "Neighbor Discovery"},
            {"MAC IP アンチスプーフ", "MAC IP Anti-Spoof"},
            {"DHCP サーバ", "DHCP Server"},
            {"IP ヘルパー", "IP Helper"},
            {"ウェブ プロキシ", "Web Proxy"},
            {"PoE 設定", "PoE Settings"},
            {"動的 DNS", "Dynamic DNS"},
            {"ネットワーク監視", "Network Monitor"},
            {"AWS 設定", "AWS Configuration"},
            // ==============================================
            {"スイッチング", "Switching"},
            {"VLAN トランク", "VLAN Trunking"},
            {"L2 発見", "L2 Discovery"},
            {"リンク統合", "Link Aggregation"},
            {"ポート ミラーリング", "Port Mirroring"},
            // ==============================================
            {"SDWAN", "SD-WAN"},
            {"グループ", "Groups"},
            {"SLA プローブ", "SLA Probes"},
            {"SLA クラス オブジェクト", "SLA Class Objects"},
            {"パス選択プロファイル", "Path Selection Profiles"},
            {"ポリシー監視", "Policies"},
            // ==============================================
            {"Cloud Secure Edge", "Cloud Secure Edge"},
            {"Status", "Status"},
            {"Access Settings", "Access Settings"},
            // ==============================================
            {"スイッチ ネットワーク", "Switch Network"},
            {"概要", "Overview"},
            {"スイッチ", "Switches"},
            // ==============================================
            {"内部無線", "Internal Wireless"},
            {"状況", "Status"},
            {"設定", "Settings"},
            {"セキュリティ", "Security"},
            {"詳細", "Advanced"},
            {"MAC フィルタ リスト", "MAC Filter List"},
            {"IDS", "IDS"},
            {"仮想アクセス ポイント", "Virtual Access Point"},
            // ==============================================
            {"アクセス ポイント", "Access Points"},
            {"設定", "Settings"},
            {"ファームウェア管理", "Firmware Management"},
            {"フロア プランの表示", "Floor Plan View"},
            {"ステーション状況", "Station Status"},
            {"IDS", "IDS"},
            {"高度な IDP", "Advanced IDP"},
            {"パケット キャプチャ", "Packet Capture"},
            {"仮想アクセス ポイント", "Virtual Access Point"},
            {"RF 監視", "RF Monitoring"},
            {"RF 解析", "RF Analysis"},
            {"RF スペクトラム", "RF Spectrum"},
            {"FairNet", "FairNet"},
            {"Wi-Fi マルチメディア", "Wi-Fi Multimedia"},
            {"3G/4G/LTE WWAN", "3G/4G/LTE WWAN"},
            {"Bluetooth LE", "Bluetooth LE"},
            {"無線管理", "Radio Management"},
            // ==============================================
            {"WWAN", "WWAN"},
            // ==============================================
            {"ファイアウォール", "Firewall"},
            {"アクセス ルール", "Access Rules"},
            {"アプリケーション ルール", "App Rules"},
            {"アプリケーション制御", "App Control"},
            {"コンテンツ フィルタ ルール", "Content Filter Rules"},
            {"ユーザ定義一致", "Custom Match"},
            {"ユーザ定義動作", "Custom Actions"},
            {"アドレス オブジェクト", "Address Objects"},
            {"サービス", "Services"},
            {"帯域幅オブジェクト", "Bandwidth Objects"},
            {"電子メール アドレス オブジェクト", "Email Address Objects"},
            {"コンテンツ フィルタ/URL", "Content Filter/URL"},
            {"外部オブジェクト", "External Objects"},
            {"DHCP オプション", "DHCP Options"},
            {"AWS", "AWS"},
            {"DNS フィルタ", "DNS Filtering"},
            {"エンドポイント セキュリティ オブジェクト", "Endpoint Security Objects"},
            {"エンドポイント セキュリティ ルール", "Endpoint Security Rules"},
            {"デバイス プロファイル", "Device Profiles"},
            // ==============================================
            {"ファイアウォール設定", "Firewall Settings"},
            {"詳細", "Advanced"},
            {"フラッド防御", "Flood Protection"},
            {"マルチキャスト", "Multicast"},
            {"QoS 割付", "QoS Mapping"},
            {"SSL 制御", "SSL Control"},
            {"暗号化制御", "Cipher Control"},
            // ==============================================
            {"DPI-SSL", "DPI-SSL"},
            {"クライアント SSL", "Client SSL"},
            {"サーバ SSL", "Server SSL"},
            // ==============================================
            {"DPI-SSH", "DPI-SSH"},
            {"設定", "Settings"},
            // ==============================================
            {"キャプチャ ATP", "Capture ATP"},
            {"状況", "Status"},
            {"設定", "Settings"},
            {"スキャン履歴", "Scanning History"},
            // ==============================================
            {"VoIP", "VoIP"},
            {"設定", "Settings"},
            {"通話状況", "Call Status"},
            // ==============================================
            {"アンチスパム", "Anti-Spam"},
            {"状況", "Status"},
            {"設定", "Settings"},
            // ==============================================
            {"VPN", "VPN"},
            {"ポリシー/設定", "Policies/Settings"},
            {"詳細", "Advanced"},
            {"VPN を越えた DHCP", "DHCP over VPN"},
            {"L2TP サーバ", "L2TP Server"},
            {"AWS VPN", "AWS VPN"},
            // ==============================================
            {"SSL VPN", "SSL VPN"},
            {"状況", "Status"},
            {"サーバ設定", "Server Settings"},
            {"クライアント設定", "Client Settings"},
            {"ポータル設定", "Portal Settings"},
            {"仮想オフィス", "Virtual Office"},
            // ==============================================
            {"ユーザ", "Users"},
            {"状況", "Status"},
            {"設定", "Settings"},
            {"パーティション", "Partitions"},
            {"ローカル ユーザとグループ", "Local Users & Groups"},
            {"ゲスト サービス", "Guest Services"},
            {"ゲスト アカウント", "Guest Accounts"},
            {"ゲスト状況", "Guest Status"},
            // ==============================================
            {"高可用性", "High Availability"},
            {"状況", "Status"},
            {"状況", "Status"},
            {"詳細", "Advanced"},
            {"監視", "Monitoring"},
            {"高可用性_監視", "Monitoring"}, // Fix sub-menu
            // ==============================================
            {"セキュリティ サービス", "Security Services"},
            {"サマリ", "Summary"},
            {"コンテンツ フィルタ", "Content Filter"},
            {"ゲートウェイ アンチウイルス", "Gateway Anti-Virus"},
            {"エンドポイント セキュリティ", "Endpoint Security"},
            {"侵入防御", "Intrusion Prevention"},
            {"アンチスパイウェア", "Anti-Spyware"},
            {"RBL フィルタ", "RBL Filter"},
            {"地域 IP フィルタ", "Geo-IP Filter"},
            {"ボットネット フィルタ", "Botnet Filter"},
            // ==============================================
            {"DNS セキュリティ", "DNS Security"},
            {"設定", "Settings"},
            {"レポート", "Reports"},
            // ==============================================
            {"AppFlow", "AppFlow"},
            {"フロー報告", "Flow Reporting"},
            {"AppFlow エージェント", "AppFlow Agent"},
            {"リアルタイム監視", "Real-Time Monitor"},
            {"AppFlow 監視", "AppFlow Monitor"},
            {"AppFlow 報告", "AppFlow Reports"},
            {"キャプチャ脅威評価", "Capture Threat Assessment"},
            // ==============================================
            {"ネットワーク アクセス制御", "Network Access Control"},
            {"設定", "Settings"},
            {"AppFlow セッション", "Sessions"},
            // ==============================================
            {"ログ", "Log"},
            {"監視", "Monitor"},
            {"設定", "Settings"},
            {"Syslog", "Syslog"},
            {"自動化", "Automation"},
            {"名前解決", "Name Resolution"},
            {"レポート", "Reports"},
            {"監査ログ", "Auditing Records"},
            {"AWS ログ", "AWS Logs"},

    };



}
