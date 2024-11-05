package com.demo.apitest;

import java.io.File;

public class Data_JPN {
    // Check list
    public static int check_list = 1;

    // Box info
    public static String baseUrl = "https://10.103.50.99"; // TZ 270W
//    public static String baseUrl = "https://10.103.50.153"; // TZ 470
//    public static String baseUrl = "https://10.8.162.174"; // NSA 2700

    // ChromeDriver Settings
    public static File my_path = new File(System.getProperty("user.dir"));
    public static String[] chromeDriver_data = {"webdriver.chrome.driver",
            my_path.getParent() + "\\Driver\\chromedriver.exe"};
    public static String Chrome_userData = "--user-data-dir=C:\\Users\\wodem\\AppData\\Local\\Google\\Chrome\\User Data2";

    // Preempt
    public static String preempt_path = "//button[contains(text(),'非構成')]";

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

    // Top menu URL
    public static String[][] Menu_url = {
            {"HOME", baseUrl + "/sonicui/7/m/dashboard/overview/status/device"},
            {"MONITOR", baseUrl + "/sonicui/7/m/mgmt/system/real-time-monitor-ng"}, // 7.1.1
//			{ "MONITOR", baseUrl + "/sonicui/7/m/mgmt/system/real-time-monitor" }, // 7.0.1
            {"DEVICE", baseUrl + "/sonicui/7/m/mgmt/system/license-enhanced"},
            {"NETWORK", baseUrl + "/sonicui/7/m/mgmt/network/interfaces"},
            {"OBJECT", baseUrl + "/sonicui/7/m/mgmt/objects/zones"},
            {"POLICY", baseUrl + "/sonicui/7/m/mgmt/policies/ngpe-access-rules"}};

    // Left
    public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
    // Dark
    public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
    // Nested
    public static String SubMenu_nested = "//ul[@class='sw-nav-group__items sw-nav-group__items--nested-level-0']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

    // ===================================================================================================================================================================================
    // HOME
    public static String[][] leftPane_HOME = {
            {"ダッシュボード", "Dashboard"},
            {"システム", "System"},
            {"アクセス ポイント", "Access Points"},
            {"キャプチャ ATP", "Capture ATP"},
            {"トポロジ", "Topology"},
            {"法的情報", "Legal Information"},
            {"API", "API"}
    };

    // MONITOR
    public static String[][] leftPane_MONITOR = {
            {"リアルタイム グラフ", "Real-Time Charts"},
            {"リアルタイム監視", "System Monitor"},
            {"システム監視", "System Monitor"},
            {"プロトコル監視", "Protocol Monitor"},
            {"ユーザ監視", "User Monitor"},
            {"帯域幅管理監視", "BWM Monitor"},
            {"AppFlow", "AppFlow"},
            {"AppFlow 報告", "AppFlow Report"},
            {"AppFlow 監視", "AppFlow Monitor"},
            {"CTA レポート", "CTA Report"},
            {"SDWAN", "SDWAN"},
            {"SDWAN 監視", "SDWAN Monitor"},
            {"SD-WAN 接続", "SD-WAN Connections"},
            {"ログ", "Logs"},
            {"システム ログ", "System Logs"},
            {"監査ログ", "Auditing Logs"},
            {"脅威ログ", "Threat Logs"},
            {"ツールと監視", "Tools & Monitors"},
            {"パケット監視", "Packet Monitor"},
            {"接続", "Connections"},
            {"コア 0 プロセス", "Core 0 Processes"},
            {"パケット再生", "Packet Replay"}
    };

    // DEVICE
    public static String[][] leftPane_DEVICE = {
            {"設定", "Settings"},
            {"ライセンス", "Licenses"},
            {"管理", "Administration"},
            {"時間", "Time"},
            {"証明書", "Certificates"},
            {"SNMP", "SNMP"},
            {"ファームウェアと設定", "Firmware and Settings"},
            {"記憶装置", "Storage"},
            {"再起動", "Restart"},
            {"内部無線", "Internal Wireless"},
            {"状況", "Status"},
            {"セキュリティ", "Security"},
            {"詳細", "Advanced"},
            {"MAC フィルタ リスト", "MAC Filter List"},
            {"IDS", "IDS"},
            {"仮想アクセス ポイント", "Virtual Access Point"},
            {"高可用性", "High Availability"},
            {"監視", "Monitoring"},
            {"ユーザ", "Users"},
            {"パーティション", "Partitions"},
            {"ローカル ユーザとグループ", "Local Users & Groups"},
            {"ゲスト サービス", "Guest Services"},
            {"ゲスト アカウント", "Guest Accounts"},
            {"ゲスト状況", "Guest Status"},
            {"AppFlow", "AppFlow"},
            {"フロー報告", "Flow Reporting"},
            {"AppFlow エージェント", "AppFlow Agent"},
            {"ネットワーク アクセス制御", "Network Access Control"},
            {"セッション", "Sessions"},
            {"ログ", "Log"},
            {"Syslog", "Syslog"},
            {"自動化", "Automation"},
            {"名前解決", "Name Resolution"},
            {"レポート", "Reports"},
            {"AWS", "AWS"},
            {"診断", "Diagnostics"},
            {"テクニカル サポート レポート", "Tech Support Report"},
            {"ネットワーク設定の確認", "Check Network Settings"},
            {"DNS 名の調査", "DNS Name Lookup"},
            {"ネットワーク パス", "Network Path"},
            {"Ping", "Ping"},
            {"ルート追跡", "Trace Route"},
            {"リアルタイム ブラックリスト", "Real-Time Blacklist"},
            {"逆引き名前調査", "Reverse Name Lookup"},
            {"上位接続", "Connection TopX"},
            {"地域とボットネット", "Geo and Botnet"},
            {"MX とバナー", "MX and Banner"},
            {"グリッド確認", "GRID Check"},
            {"URL 格付け要求", "URL Rating Request"},
            {"PMTU 検出", "PMTU Discovery"},
            {"スイッチ診断", "Switch Diagnostics"},
            {"スイッチ ネットワーク", "Switch Network"},
            {"概要", "Overview"},
            {"スイッチ", "Switches"},
            {"アクセス ポイント", "Access Points"},
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
            {"WWAN", "WWAN"}
    };

    // NETWORK
    public static String[][] leftPane_NETWORK = {
            {"システム", "System"},
            {"インターフェース", "Interfaces"},
            {"フェイルオーバーと負荷分散", "Failover & LB"},
            {"近隣者検出", "Neighbor Discovery"},
            {"ARP", "ARP"},
            {"MAC IP アンチスプーフ", "MAC IP Anti-Spoof"},
            {"ウェブ プロキシ", "Web Proxy"},
            {"PortShield グループ", "PortShield Groups"},
            {"PoE 設定", "PoE Settings"},
            {"VLAN 変換", "VLAN Translation"},
            {"IP ヘルパー", "IP Helper"},
            {"動的ルーティング", "Dynamic Routing"},
            {"DHCP サーバ", "DHCP Server"},
            {"マルチキャスト", "Multicast"},
            {"ネットワーク監視", "Network Monitor"},
            {"AWS 設定", "AWS Configuration"},
            {"ファイアウォール", "Firewall"},
            {"詳細", "Advanced"},
            {"フラッド防御", "Flood Protection"},
            {"SSL 制御", "SSL Control"},
            {"暗号化制御", "Cipher Control"},
            {"RBL フィルタ", "RBL Filter"},
            {"VoIP", "VoIP"},
            {"設定", "Settings"},
            {"通話状況", "Call Status"},
            {"DNS", "DNS"},
            {"動的 DNS", "Dynamic DNS"},
            {"DNS プロキシ", "DNS Proxy"},
            {"DNS セキュリティ", "DNS Security"},
            {"スイッチング", "Switching"},
            {"VLAN トランク", "VLAN Trunking"},
            {"L2 発見", "L2 Discovery"},
            {"リンク統合", "Link Aggregation"},
            {"ポート ミラーリング", "Port Mirroring"},
            {"SDWAN", "SDWAN"},
            {"グループ", "Groups"},
            {"SLA プローブ", "SLA Probes"},
            {"SLA クラス オブジェクト", "SLA Class Objects"},
            {"パス選択プロファイル", "Path Selection Profiles"},
            {"ルール", "Rules"},

            {"Cloud Secure Edge", "Cloud Secure Edge"},
            {"状況", "Status"},
            {"アクセス設定", "Access Settings"},

            {"IPSec VPN", "IPSec VPN"},
            {"ルールと設定", "Rules and Settings"},
            {"VPN を越えた DHCP", "DHCP over VPN"},
            {"L2TP サーバ", "L2TP Server"},
            {"AWS VPN", "AWS VPN"},
            {"SSL VPN", "SSL VPN"},
            {"状況", "Status"},
            {"サーバ設定", "Server Settings"},
            {"クライアント設定", "Client Settings"},
            {"ポータル設定", "Portal Settings"},
            {"仮想オフィス", "Virtual Office"}
    };

    // OBJECT
    public static String[][] leftPane_OBJECT = {
            {"一致オブジェクト", "Match Objects"},
            {"ゾーン", "Zones"},
            {"アドレス", "Addresses"},
            {"サービス", "Services"},
            {"URI リスト", "URI Lists"},
            {"評価", "Reputation"},
            {"一致オブジェクト", "Match Objects"},
            {"スケジュール", "Schedules"},
            {"動的グループ", "Dynamic Group"},
            {"電子メール アドレス", "Email Addresses"},
            {"プロファイル オブジェクト", "Profile Objects"},
            {"エンドポイント セキュリティ", "Endpoint Security"},
            {"帯域幅", "Bandwidth"},
            {"QoS 級割", "QoS Marking"},
            {"コンテンツ フィルタ", "Content Filter"},
            {"DHCP オプション", "DHCP Option"},
            {"AWS", "AWS"},
            {"DNS フィルタ", "DNS Filtering"},
            {"動作オブジェクト", "Action Objects"},
            {"アプリケーション ルールの動作", "App Rule Actions"},
            {"コンテンツ フィルタの動作", "Content Filter Actions"}
    };

    // POLICY
    public static String[][] leftPane_POLICY = {
            {"ルールとポリシー", "Rules and Policies"},
            {"アクセス ルール", "Access Rules"},
            {"NAT ルール", "NAT Rules"},
            {"ルーティング ルール", "Routing Rules"},
            {"DNS ルール", "DNS Rules"},
            {"コンテンツ フィルタ ルール", "Content Filter Rules"},
            {"アプリケーション ルール", "App Rules"},
            {"エンドポイント ルール", "Endpoint Rules"},
            {"DPI-SSL", "DPI-SSL"},
            {"クライアント SSL", "Client SSL"},
            {"サーバ SSL", "Server SSL"},
            {"DPI-SSH", "DPI-SSH"},
            {"設定", "Settings"},
            {"セキュリティ サービス", "Security Services"},
            {"サマリ", "Summary"},
            {"ゲートウェイ アンチウイルス", "Gateway Anti-Virus"},
            {"アンチスパイウェア", "Anti-Spyware"},
            {"侵入防御", "Intrusion Prevention"},
            {"地域 IP フィルタ", "Geo-IP Filter"},
            {"ボットネット フィルタ", "Botnet Filter"},
            {"アプリケーション制御", "App Control"},
            {"コンテンツ フィルタ", "Content Filter"},
            {"アンチスパム", "Anti-Spam"},
            {"状況", "Status"},
            {"リレー ドメイン", "Relay Domains"},
            {"ジャンク ボックス メッセージ", "Junk Box Messages"},
            {"ジャンク ボックス設定", "Junk Box Settings"},
            {"ジャンク ボックス サマリ", "Junk Box Summary"},
            {"ユーザ表示セットアップ", "User View Setup"},
            {"アドレス帳", "Address Books"},
            {"ユーザ管理", "Manage Users"},
            {"LDAP 構成", "LDAP Configuration"},
            {"詳細", "Advanced"},
            {"ダウンロード", "Downloads"},
            {"キャプチャ ATP", "Capture ATP"},
            {"スキャン履歴", "Scanning History"},
            {"DNS セキュリティ", "DNS Security"},
            {"レポート", "Reports"},
            {"エンドポイント セキュリティ", "Endpoint Security"}
    };

}
