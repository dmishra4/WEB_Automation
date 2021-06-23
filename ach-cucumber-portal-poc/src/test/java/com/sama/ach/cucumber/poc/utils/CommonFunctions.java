package com.sama.ach.cucumber.poc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sama.ach.cucumber.poc.page.ref.POC_PageRef;
import com.sama.ach.cucumber.poc.stepdefs.POC_StepDefinitions;

import cucumber.api.Scenario;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CommonFunctions implements POC_PageRef {

	public static String glbpath = null;

	public static WebDriver driver;

	public static String screenshotfilename;

	public static byte[] snapshot;

	// Get Browser name and version.

	/**
	 * Function to take the snapshot
	 * 
	 * @param driver
	 * @param snapshotName
	 * @return
	 */

	public static String getSnapshotBase64(WebDriver driver, String snapshotName) {
		String timeStamp = null;
		FileInputStream fileInputStreamReader = null;
		String encodedBase64 = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			String dir = System.getProperty("user.dir");
			glbpath = dir + "\\Screenshots\\";
			File dst = new File(glbpath + snapshotName + "_" + timeStamp + ".png");
			FileUtils.copyFile(src, dst);
			fileInputStreamReader = new FileInputStream(dst);
			byte[] bytes = new byte[(int) dst.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (Exception e) {

			e.getMessage();
		}
		// return (snapshotName + "_" + timeStamp + ".png");
		return "data:image/png;base64," + encodedBase64;
	}

	/**
	 * Function for open new browser.
	 * 
	 * @param browserName
	 */
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"./src/test/resources/com/sama/ach/cucumber/drivers/geckodriverv0.26.0-win64.exe");
			// FirefoxProfile firefoxProfile = new FirefoxProfile();
			FirefoxOptions options = new FirefoxOptions();
			// Set Location to store files after downloading

			String dir = System.getProperty("user.dir");
			String download_path = dir + "\\src\\test\\resources\\com\\sama\\ach\\cucumber\\downloads\\firefox";

			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.helperApps.alwaysAsk.force", false);
			options.addPreference("browser.download.dir", download_path);
			options.addPreference("browser.download.defaultFolder", download_path);
			options.addPreference("browser.download.manager.showWhenStarting", false);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "csv");
			options.addPreference("browser.helperApps.neverAsk.openFile", "csv");

			// neverAsk - saveToDisk - CSV
			options.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/pdf,application/csv,text/csv,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/x-pdf,application/octet-stream");

			// neverAsk - openFile - CSV
			options.addPreference("browser.helperApps.neverAsk.openFile",
					"application/csv,application/excel,application/vnd.ms-excel,application/vnd.msexcel,text/anytext,text/comma-separated-values,text/csv,text/plain,text/x-csv,application/x-csv,text/x-comma-separated-values,text/tab-separated-values");
			options.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			// Configuring the system properties of chrome driver
			System.setProperty("webdriver.chrome.driver",
					"./src/test/resources/com/sama/ach/cucumber/drivers/chromedriver80.0.3987.106.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true"); // To avoid unwanted message on console
			// Download at specific location with Chrome
			String downloadFilepath = System.getProperty("user.dir")
					+ "\\src\\test\\resources\\com\\sama\\ach\\cucumber\\downloads\\chrome";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			options.addArguments("--disable-features=NetworkService");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("--disable-extensions");
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

			options.setExperimentalOption("prefs", chromePrefs);
			options.setExperimentalOption("useAutomationExtension", false);  // Loading of unpacked extension 
			// Initializing the browser driver
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("IE")) {
			// System.setProperty("webdriver.ie.driver",
			// "drivers\\IEDriverServer_v3.4.0_win32.exe");
			System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer_Win32_3.11.1.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize(); // Maximize window
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	/**
	 * Function to navigate to the URL
	 * 
	 * @param Environment - environment name e.g. dev/SIT
	 */
	public static void openSAMAPortalURL(Scenario scenario, String environment, String portal) {
		try {
			if (environment.equalsIgnoreCase("dev") && portal.equalsIgnoreCase("External")) {
				driver.get("http://localhost:10039/wps/portal");
			} else if (environment.equalsIgnoreCase("dev") && portal.equalsIgnoreCase("Internal")) {
				driver.get("http://localhost:10039/wps/portal");
			} else if (environment.equalsIgnoreCase("SIT") && portal.equalsIgnoreCase("External")) {
				// driver.get("http://10.158.218.10:10039/wps/portal");
				driver.get("https://10.158.244.131:444/wps/myportal/sp");
				scenario.write("External URL :: https://10.158.244.131:444/wps/myportal/sp ");

				// Thread.sleep(5000);

			} else if (environment.equalsIgnoreCase("SIT") && portal.equalsIgnoreCase("Internal")) {
				driver.get("http://10.158.219.10:10039/wps/portal");
				scenario.write("Internal URL :: http://10.158.219.10:10039/wps/portal ");
				// Thread.sleep(5000);
			} else if (environment.equalsIgnoreCase("PPRD") && portal.equalsIgnoreCase("External")) {
				// driver.get("http://10.158.218.10:10039/wps/portal");
				driver.get("https://10.158.213.193:10042/wps/portal");
				scenario.write("External URL :: https://10.158.213.193:10042/wps/portal");

			} else if (environment.equalsIgnoreCase("PPRD") && portal.equalsIgnoreCase("Internal")) {
				driver.get("https://10.158.214.1:10042/wps/portal");
				scenario.write("Internal URL :: https://10.158.214.1:10042/wps/portal");
			}

			else {
				System.out.println("Mentioned enviroment is not yet defined");
			}
		} catch (Exception e) {
			System.out.println("Mentioned environment is not yet defined");
			e.getMessage();
		}
	}

	/**
	 * Gets the system environment value for Environment name
	 * 
	 * @param env
	 * @return
	 */

	public static String EnvironmentUtility(String env) {
		String ENV_KEY = "Environment_Name";
		String ENV_NAME = System.getenv(ENV_KEY);
		System.out.println("The value of ENV_Name is " + ENV_NAME);
		String ENV_KEY_REPLACEMENT_WORD = "%ENV%";
		return env.replace(ENV_KEY_REPLACEMENT_WORD, ENV_NAME);

	}

	/**
	 * Function to login to the Portal
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public static void portalLogin(Scenario scenario, String portal, String environment, String username,
			String password) throws Exception

	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(a_LogIn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(input_UserID));
		Thread.sleep(3000);
		driver.findElement(input_UserID).sendKeys(username);
		if (environment.equalsIgnoreCase("SIT") || environment.equalsIgnoreCase("PPRD")) {
			password = password.replaceAll(".+", "Welcome@123");
		}
		driver.findElement(input_Password).sendKeys(password);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		// System.out.println("The value of sceanio is :: " +
		// POC_StepDefinitions.scenario);
		scenario.embed(CommonFunctions.snapshot, "image/png");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Login));
		driver.findElement(btn_Login).click();
		WebDriverWait loginwait = new WebDriverWait(driver, 2);
		try {
			loginwait.until(ExpectedConditions.invisibilityOfElementLocated(text_LoginError));
			scenario.write("Successfully Login to " + portal + " Portal in " + environment + " Environment");
			Thread.sleep(1000);

		} catch (TimeoutException e) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			scenario.embed(CommonFunctions.snapshot, "image/png");
			scenario.write(portal + " Portal Login has been failed in " + environment
					+ " Environment. Please enter a valid user ID and password.");
			Assert.fail(portal + " Portal Login has been failed in " + environment
					+ " Environment. Please enter a valid user ID and password.");
		}

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(a_Portal_Selection));
		WebElement obj = driver.findElement(a_Portal_Selection);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", obj);
		Thread.sleep(1000);
		try {
			if (environment.equalsIgnoreCase("dev") && portal.equalsIgnoreCase("External")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(span_SaudiPayments_Ext));
				driver.findElement(span_SaudiPayments_Ext).click();
			} else if (environment.equalsIgnoreCase("dev") && portal.equalsIgnoreCase("Internal")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(span_SaudiPayments_Int));
				driver.findElement(span_SaudiPayments_Int).click();
			} else {
				System.out.println("Either Environment or Portal is not yet defined");
			}
		} catch (Exception e) {
			System.out.println("Mentioned environment is not yet defined");
			e.getMessage();
		}
		 

	}

	/**
	 * Function to login to the Internal Portal
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public static void internalPortalLogin(Scenario scenario, String portal, String environment, String username,
			String password) throws Exception {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(input_UserName));
		Thread.sleep(3000);
		CommonFunctions.driver.findElement(input_UserName).sendKeys(username);
		CommonFunctions.driver.findElement(input_Password).sendKeys(password);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_InternalLogin));
		CommonFunctions.driver.findElement(btn_InternalLogin).click();
		WebDriverWait loginwait = new WebDriverWait(CommonFunctions.driver, 4);
		try {
			loginwait.until(ExpectedConditions.invisibilityOfElementLocated(text_LoginErrorInternal));
			scenario.write("Successfully Login to " + portal + " Portal in " + environment + " Environment");
			Thread.sleep(2000);

		} catch (TimeoutException e) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			scenario.embed(CommonFunctions.snapshot, "image/png");
			scenario.write(portal + " Portal Login has been failed in " + environment
					+ " Environment. Please enter a valid user ID and password.");
			Assert.fail(portal + " Portal Login has been failed in " + environment
					+ " Environment. Please enter a valid user ID and password.");
		}
	}

	/**
	 * Function to login to the external Portal
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public static void externalPortalLogin(Scenario scenario, String portal, String environment, String username,
			String password) throws Exception {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(input_UserName));
		Thread.sleep(3000);
		CommonFunctions.driver.findElement(input_UserName).sendKeys(username);
		password = password.replaceAll(".+", "Welcome@123");
		CommonFunctions.driver.findElement(input_Password).sendKeys(password);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ExternalLogin));
		CommonFunctions.driver.findElement(btn_ExternalLogin).click();
		WebDriverWait loginwait = new WebDriverWait(CommonFunctions.driver, 4);
		try {
			loginwait.until(ExpectedConditions.invisibilityOfElementLocated(text_LoginErrorExternal));
			scenario.write(
					"Entered correct credential to Login " + portal + " Portal in " + environment + " Environment");
			Thread.sleep(2000);

		} catch (TimeoutException e) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			scenario.embed(CommonFunctions.snapshot, "image/png");
			scenario.write(portal + " Portal Login has been failed in " + environment
					+ " Environment. Please enter a valid user ID and password.");
			Assert.fail(portal + " Portal Login has been failed in " + environment
					+ " Environment. Please enter a valid user ID and password.");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(text_otp_external));
		String otptext = CommonFunctions.driver.findElement(text_otp_external).getText();
		String otp = otptext.split("-")[1];
		System.out.println("The value of required OTP to login is :: " + otp);
		CommonFunctions.driver.findElement(input_otp_password_ext).sendKeys(otp);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
		CommonFunctions.driver.findElement(input_otp_submit_ext).click();
		try {
			loginwait.until(ExpectedConditions.invisibilityOfElementLocated(text_LoginErrorExternal));
			scenario.write("Entered a valid OTP to " + portal + " Portal in " + environment + " Environment");
			Thread.sleep(2000);

		} catch (TimeoutException e) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			scenario.embed(CommonFunctions.snapshot, "image/png");
			scenario.write("Incorrect OTP, please enter a valid OTP to " + portal + " Portal in " + environment
					+ " Environment.");
			Assert.fail("Incorrect OTP, please enter a valid OTP to " + portal + " Portal in " + environment
					+ " Environment");
		}
	}

	/**
	 * 
	 * @param Title
	 */
	public static void PortalPageValidation(String Title) {

		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hCtrlCentralTitle));
		String PageTitle = driver.findElement(hCtrlCentralTitle).getText();
		System.out.println("Page Title is :: " + PageTitle);
		Assert.assertEquals("Page Title did not match ", Title, PageTitle);

	}

	/**
	 * Functions to delete old screenshots.
	 */

	public static void cleanup_screenshots() {
		String path = System.getProperty("user.dir") + "\\Screenshots\\";
		File deleteOldScreenshots = new File(path);
		try {
			FileUtils.cleanDirectory(deleteOldScreenshots);
		} catch (Exception e) {
			System.out.println("Ensure scrrenshot path is correctly mentioned");
			e.getMessage();
		}
	}

	/**
	 * Functions to delete old downloads.
	 */

	public static void cleanup_downloads(String browser) {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\sama\\ach\\cucumber\\downloads\\"
				+ browser + "\\";
		File deleteOlddownloads = new File(path);
		try {
			FileUtils.cleanDirectory(deleteOlddownloads);
		} catch (Exception e) {
			System.out.println("Ensure download path is correctly mentioned");
			e.getMessage();
		}
	}

	/**
	 * Function to take the snapshot
	 * 
	 * @param driver
	 * @param snapshotName
	 * @return
	 */

	public static byte[] getSnapshot(WebDriver driver, String snapshotName) {
		String timeStamp = null;
		FileInputStream fileInputStreamReader = null;
		byte[] bytes = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			String dir = System.getProperty("user.dir");
			glbpath = dir + "\\Screenshots\\";
			File dst = new File(glbpath + snapshotName + "_" + timeStamp + ".png");
			FileUtils.copyFile(src, dst);
			fileInputStreamReader = new FileInputStream(dst);
			bytes = new byte[(int) dst.length()];
			fileInputStreamReader.read(bytes);
		} catch (Exception e) {
			e.getMessage();
		}

		return bytes;
	}

	/**
	 * Function to get current calendar date
	 * 
	 * @param dateformat
	 * @return
	 */
	public static String currentDate(String dateformat) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
		String todayDate = dateFormat.format(date);
		System.out.println("Today's date is  :: " + todayDate);
		return todayDate;
	}

	/**
	 * Function to retrieve future date
	 * 
	 * @param dateformat
	 * @param days
	 * @return
	 */
	public static String futureDate(String dateformat, int days) {
		Date date = Calendar.getInstance().getTime();
		// System.out.println(date);
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
		String todayDate = dateFormat.format(date);
		// System.out.println("Current Date :: " + todayDate);
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dateFormat.parse(todayDate));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		c.add(Calendar.DAY_OF_MONTH, days);
		String futureDate = dateFormat.format(c.getTime());
		System.out.println("The value of future date is :: " + futureDate);
		return futureDate;
	}

	/**
	 * Function to retrieve past date
	 * 
	 * @param dateformat
	 * @param days
	 * @return
	 */

	public static String pastDate(String dateformat, int days) {
		Date date = Calendar.getInstance().getTime();
		// System.out.println(date);
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
		String todayDate = dateFormat.format(date);
		// System.out.println("Current Date :: " + todayDate);
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dateFormat.parse(todayDate));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		c.add(Calendar.DAY_OF_MONTH, days);
		String pastDate = dateFormat.format(c.getTime());
		System.out.println("The value of past date is :: " + pastDate);
		return pastDate;
	}

	/**
	 * Function to change available date format.
	 * 
	 * @param dateformat
	 * @return
	 */
	public static String changedateformat(String date, String dateformat) {
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
		String formatedDate = dateFormat.format(date);
		System.out.println("Today's date is  :: " + formatedDate);
		return formatedDate;
	}

	/**
	 * Function to generate the custom report.
	 * 
	 * @throws InterruptedException
	 */
	public static void generateCustomReport() throws InterruptedException {
		System.out.println("Start generating HTML report folder");
		File reportOutputDirectory = new File("target");
		String dir = System.getProperty("user.dir");
		List<String> jsonFiles = new ArrayList<>();
		String jsonpath = dir + "\\target\\Cucumber-Report\\cucumber.json";
		System.out.println("Path of json file is :: " + jsonpath);
		jsonFiles.add(jsonpath);
		// jsonFiles.add(
		// "C:\\SAMA-ACH\\achworkspace\\sama-ach-portal-tests-automation\\ach-cucumber-portal-poc\\target\\Cucumber-Report\\cucumber.json");

		String buildNumber = "1";
		String projectName = "SAMA ACH PORTAL";
		// boolean runWithJenkins = true;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc
		// configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);

		// additional metadata presented on main page
		configuration.addClassifications("Operating System", System.getProperty("os.name"));
		configuration.addClassifications("Browser", POC_StepDefinitions.browser);
		configuration.addClassifications("Java", System.getProperty("java.version"));
		configuration.addClassifications("Selenium", "3.141.59");
		configuration.addClassifications("Cucumber", "4.2.0");

		// optionally add metadata presented on main page via properties file
		// List<String> classificationFiles = new ArrayList<>();
		// classificationFiles.add("properties-1.properties");
		// classificationFiles.add("properties-2.properties");
		// configuration.addClassificationFiles(classificationFiles);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Thread.sleep(1000);
		try {
			reportBuilder.generateReports();
		} catch (Exception e) {
			Assert.fail("Report generation failed as Json file under target folder is not created successfully");
		}

	}

	/**
	 * Function to encrypt password
	 * 
	 * @param password
	 * @return
	 */
	public static String encodedPassword(String password) {

		byte[] encodedstring = Base64.encodeBase64(password.getBytes());
		System.out.println("Encoded Password ::  " + encodedstring);
		return (new String(encodedstring));

	}

	/**
	 * Function to decrypt password
	 * 
	 * @param encodedpassword
	 * @return
	 */

	public static String decodedPassword(byte[] encodedpassword) {

		byte[] decodedstring = Base64.decodeBase64(encodedpassword);
		System.out.println("Decoded Password ::  " + decodedstring);
		return (new String(decodedstring));

	}

	/**
	 * Returns the latest file
	 * 
	 * @param _filepath_
	 * @return File
	 */
	public static File getLatestFile(String _filepath_, String filePrefix) {

		File dir = new File(_filepath_);
		File max = null;
		for (File file : dir.listFiles()) {
			if (file.getName().startsWith(filePrefix) && (max == null || max.lastModified() < file.lastModified())) {
				// System.out.println("Debug");
				max = file;
			}
		}
		System.out.println("The latest file is :: " + max.getPath());
		return max;
	}

	/**
	 * Function to convert date format
	 * 
	 * @param dataStr
	 * @param sourceDateformat
	 * @param targetDateFormat
	 * @return
	 * @throws ParseException
	 */
	public static String convertDateFormat(String dataStr, String sourceDateformat, String targetDateFormat)
			throws ParseException

	{
		System.out.println("The value of dataStr :: " + dataStr);
		if (dataStr != null && !dataStr.equals("")) {
			SimpleDateFormat sdfSource = new SimpleDateFormat(sourceDateformat);
			Date date = sdfSource.parse(dataStr);

			SimpleDateFormat sdfTarget = new SimpleDateFormat(targetDateFormat);
			dataStr = sdfTarget.format(date);
		}

		return dataStr;
	}

	/***
	 * Function to select the date from the date picker in dd/MM/yyyy format.
	 * 
	 * @param dateStr
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	public static void datepicker(String dateStr) throws ParseException, InterruptedException {
		String date_value = convertDateFormat(dateStr, "dd/MM/yyyy", "dd/MMMM/yyyy");
		System.out.println("The datevalue is :: " + date_value);
		String date = date_value.split("/")[0];
		System.out.println("The value of required date selection is :: " + date);
		String month = date_value.split("/")[1];
		// System.out.println("The value of month is :: " + month);
		String year = date_value.split("/")[2];
		// System.out.println("The value of year is :: " + year);
		String datepicker_month = CommonFunctions.driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"))
				.getText();
		String datepicker_year = CommonFunctions.driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"))
				.getText();
		// Get the today date
		LocalDate today = LocalDate.now();
		int todaymonth = today.getMonthValue();
		System.out.println("The value of todaymonth is in integer is " + todaymonth);
		int requiredmonth = Integer.parseInt(dateStr.split("/")[1]);
		System.out.println("The value of requiredmonth is in integer is " + requiredmonth);
		if (Integer.parseInt(year) <= Integer.parseInt(datepicker_year) && requiredmonth <= todaymonth) {
			while (!(datepicker_month.equals(month)) || !(datepicker_year.equals(year))) {
				CommonFunctions.driver.findElement(By.xpath("//a[@title='Prev']")).click();
				datepicker_month = CommonFunctions.driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"))
						.getText();
				datepicker_year = CommonFunctions.driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"))
						.getText();
			}
			CommonFunctions.driver.findElement(By.xpath("//a[text()='" + Integer.parseInt(date) + "']")).click();

		} else {
			while (!(datepicker_month.equals(month)) || !(datepicker_year.equals(year))) {
				CommonFunctions.driver.findElement(By.xpath("//a[@title='Next']")).click();
				datepicker_month = CommonFunctions.driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"))
						.getText();
				datepicker_year = CommonFunctions.driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"))
						.getText();
			}
			CommonFunctions.driver.findElement(By.xpath("//a[text()='" + Integer.parseInt(date) + "']")).click();

		}

	}

	public static void logout() {

		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(a_Logout));
		CommonFunctions.driver.findElement(a_Logout).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Logout_Yes));
		CommonFunctions.driver.findElement(btn_Logout_Yes).click();

	}

	/**
	 * Function to close the browser.
	 */
	public static void teardown() {

		driver.manage().deleteAllCookies();
		driver.close(); // current active browser
		// driver.quit();
		driver = null;
	}

}
