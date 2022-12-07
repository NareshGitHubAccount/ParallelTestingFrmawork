package mainObjectives;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mainClass {
	
public static WebDriver driver;
public String screenshotsSubFolderName ;
public  Logger logger ; 
public String brow;
public String version;
public Platform plat;
public String browser;



    @Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
	logger = Logger.getLogger(mainClass.class);
	PropertyConfigurator.configure("Log4j.properties");
	switch (browser.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;

	default:
		driver=null;
		break;
		
	}

	
	Capabilities  cpabilities =((RemoteWebDriver)driver).getCapabilities();
	brow=cpabilities.getBrowserName();
	version =cpabilities.getBrowserVersion();
	plat=cpabilities.getPlatformName();
	
	
	System.out.println("Current Browser Name::" +brow);
	System.out.println("Current Browser version::" +version);
	System.out.println("Current Browser platformName::" +plat);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://jqueryui.com/");
		}
	
	@AfterClass
	
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();;
	}
	
	public String captureScreen(String tname) throws IOException {
		if (screenshotsSubFolderName == null) {
			 screenshotsSubFolderName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshots/"+screenshotsSubFolderName +"/"+ tname );
//		File target = new File("D:\\Testing Projects\\ParallelTestingFrmawork\\Screenshots\\"+tname+".png");
		try {
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return target.getAbsolutePath();
	
	}
	public static String captureScreen() {
		TakesScreenshot tsb = (TakesScreenshot)driver;
		String base64 = tsb.getScreenshotAs(OutputType.BASE64);
		
		return base64;
		
	}
//	public String randomestring()
//	{
//		String generatedstring=RandomStringUtils.randomAlphabetic(8);
//		return(generatedstring);
//	}
//	
//	public static String randomeNum() {
//		String generatedString2 = RandomStringUtils.randomNumeric(4);
//		return (generatedString2);
//	}

	
}
