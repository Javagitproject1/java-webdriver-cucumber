// Created by Viacheslav (Slava) Skryabin 04/01/2011
package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static WebDriver driver;
    private static String timestamp;
    private static String currentDate;
    private static Map<String, Object> testData = new HashMap<>();

    public static String getTimestamp() {
        return timestamp;
    }

    public static void setTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd-h-mm-sss");
        timestamp = dateFormat.format(new Date());
    }

    public static String getCurrentDate() {
        return currentDate;
    }

    public static void setCurrentDate() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = date.format(new Date());
    }

    public static Map<String, Object> getTestDataMap(String key) {
        return (Map<String, Object>) testData.get(key);
    }

    public static Integer getTestDataInteger(String key) {
        return (Integer) testData.get(key);
    }

    public static String getTestDataString(String key) {
        return (String) testData.get(key);
    }

    public static void setTestData(String key, Object value) {
        testData.put(key, value);
    }

    public static Map<String, String> getPosition(String title) {
        Map<String, String> position = getData(title);
        String updatedTitle = position.get("title");
        if (updatedTitle != null) {
            position.put("title", updatedTitle + getTimestamp());
        }

        String actualDate = position.get("dateOpen");
        if (actualDate.isEmpty() && actualDate.isBlank()) {
            position.put("dateOpen", getCurrentDate());
        } else if (actualDate != null) {
            String isoDateOpen = new SimpleDateFormat("yyyy-MM-dd").format(new Date(actualDate));
            position.put("dateOpen", isoDateOpen);
        }
        return position;
    }

    public static Map<String, String> getCandidate(String email) {
        Map<String, String> candidate = getData(email);
        String currentEmail = candidate.get("email");
        if (currentEmail != null) {
            String[] newEmail = currentEmail.split("@");
            candidate.put("email", newEmail[0] + getTimestamp() + "@" + newEmail[1]);
        }
        return candidate;
    }


    public static WebDriver getDriver() {
        return driver;
    }

    //Extracted WebDriverWait function
    public static WebDriverWait getWait() {
        return getWait(getConfig().explicitTimeOut);
    }

    public static WebDriverWait getWait(int timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }

    //Extracted Actions function
    public static Actions getActions() {
        return new Actions(driver);
    }

    //Extracted JavaScriptExecutor function
    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static Map<String, String> getData(String fileName) {

        try {
            String myPath = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + ".yml";
            File myFile = new File(myPath);
            InputStream stream = new FileInputStream(myFile);
            Yaml myYaml = new Yaml();
            return myYaml.load(stream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, String> getCandidates(String type){
        try {
            String candidate = System.getProperty("user.dir") + "/src/test/resources/data/candidates.yml";
            Candidates list = new Yaml().load(new FileInputStream(new File(candidate)));
            switch (type){
                case "sdet":
                    String currentEmail = list.sdet.get("email");
                    if (currentEmail != null) {
                        String[] newEmail = currentEmail.split("@");
                        list.sdet.put("email", newEmail[0] + getTimestamp() + "@" + newEmail[1]);
                    }
                    return list.sdet;
                case "qa":
                    String currentEmail1 = list.qa.get("email");
                    if (currentEmail1 != null) {
                        String[] newEmail = currentEmail1.split("@");
                        list.qa.put("email", newEmail[0] + getTimestamp() + "@" + newEmail[1]);
                    }
                    return list.qa;
            }
            throw new RuntimeException("Candidate" + type + "not found");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static File getFile (String filename, String extension){
    String path = System.getProperty("user.dir") + "/src/test/resources/data/" + filename + "." + extension;
    return new File(path);
    }

    public static Configuration getConfig(){
        try {
            String configPath = System.getProperty("user.dir") + "/src/test/resources/data/configuration.yml";
            File file = new File(configPath);
            InputStream stream = new FileInputStream(file);
            return new Yaml ().load(stream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Users getUsers(){
        try {
            String configPath = System.getProperty("user.dir") + "/src/test/resources/data/users.yml";
            File file = new File(configPath);
            InputStream stream = new FileInputStream(file);
            return new Yaml ().load(stream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map <String, String> getUsers (String type) {
        switch (type){
            case "user": return getUsers().user;
            case "admin": return getUsers().admin;
        }
        throw new RuntimeException("User is not found:" + type);
    }

    public static void initialize() {
        initialize(getConfig().browser, getConfig().testEnvironment, getConfig().isHeadless);
    }

    public static void teardown() {
        driver.quit();
    }

    public static void initialize(String browser, String testEnv, boolean isHeadless) {
        Dimension size = new Dimension(1920, 1080);
        Point position = new Point(0, 0);
        if (testEnv.equals("local")) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    Map<String, Object> chromePreferences = new HashMap<>();
                    chromePreferences.put("profile.default_content_settings.geolocation", 2);
                    chromePreferences.put("profile.default_content_settings.popups", 0);
                    chromePreferences.put("download.prompt_for_download", false);
                    chromePreferences.put("download.directory_upgrade", true);
                    chromePreferences.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/downloads");
                    chromePreferences.put("safebrowsing.enabled", false);
                    chromePreferences.put("plugins.always_open_pdf_externally", true);
                    chromePreferences.put("plugins.plugins_disabled", new ArrayList<String>() {{
                        add("Chrome PDF Viewer");
                    }});
                    chromePreferences.put("credentials_enable_service", false);
                    chromePreferences.put("password_manager_enabled", false);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.setExperimentalOption("prefs", chromePreferences);
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    if (isHeadless) {
                        chromeOptions.setHeadless(true);
                        chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().window().setPosition(position);
                    driver.manage().window().setSize(size);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Driver is not implemented for: " + browser);
            }
        } else if (testEnv.equals("grid")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.ANY);
            try {
                URL hubUrl = new URL("http://localhost:4444/wd/hub");
                driver = new RemoteWebDriver(hubUrl, capabilities);
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException("Unsupported test environment: " + testEnv);
        }
    }


}
