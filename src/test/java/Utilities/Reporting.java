package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import mainObjectives.mainClass;




public class Reporting extends mainClass  implements ITestListener
{
	 ExtentSparkReporter spark;
	 ExtentReports extent;
	 ExtentTest logger;
	 String repName;
	public  String Webdriver;
	
	public void onStart(ITestContext testContext  )
	{
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName=timeStamp+"_"+testContext.getName()+ "-Test-Report-"+".html";
		
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		
		 String nameOS = "os.name";
		    String versionOS = "os.version";
		    String architectureOS = "os.arch";
		    String architectureOS1 = "browser.name";
		    nameOS = System.getProperty(nameOS);
		    versionOS = System.getProperty(versionOS);
		    architectureOS = System.getProperty(architectureOS);
		    architectureOS1 = System.getProperty(architectureOS1);
		 
		    
		
		extent=new ExtentReports();
		
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Naresh");
		extent.setSystemInfo("OS",System.getProperty("os.name"));
		extent.setSystemInfo("java",System.getProperty("java.version"));
		extent.setSystemInfo("Browser",testContext.getName());
		extent.setSystemInfo("nameOS","os.name");
		extent.setSystemInfo("versionOS",versionOS);
		extent.setSystemInfo("architectureOS",architectureOS);
				
		spark.config().setDocumentTitle("JQURY Testing"); // Tile of report
		spark.config().setReportName("JQURY Test Automation Report"); // name of the report
		spark.config().setCss(".badge-primary { background-color: #87f505 }"); //change particular background color 
		spark.config().setJs("document.getElementsByClassName('logo')[0].style.display='none'"); // hiding some logs in documents
		
		spark.config().setTheme(Theme.DARK);
		
		
		//------------------------------
		
		spark.viewConfigurer()
				    .viewOrder()
				    .as(new ViewName[] { 
					   ViewName.DASHBOARD, 
					   ViewName.TEST, 
					   ViewName.AUTHOR, 
					   ViewName.DEVICE, 
					   ViewName.EXCEPTION, 
					   ViewName.LOG, 
					   
					  					})
				  .apply();
		
		//---------------------------
	
	
	}
	
	public void onTestSuccess(ITestResult tr)
	{

		logger=extent.createTest(tr.getTestContext().getName()+"_"+tr.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		}
	
	public void onTestFailure(ITestResult tr)
	{
		
		try {
			
			String scName =tr.getTestContext().getName()+"_"+tr.getMethod().getMethodName()+".png";
			captureScreen(scName );
			String path =captureScreen(scName);
			String base64 =captureScreen();
			
			logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		 logger.info(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		 logger.info(MediaEntityBuilder.createScreenCaptureFromBase64String(base64,scName).build());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	/*	logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
//	String tcName = tr.getName()+".png";
//		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		String screenshotPath="C:\\Users\\Administrator\\eclipse-workspace\\ParallelTestingFrmawork\\Screenshots\\currentTest.png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.info("Screenshot is below:" + logger.info(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()));
//			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (Exception e) 
				{
				e.printStackTrace();
				} 
		}
		*/
	
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getTestContext().getName()+"_"+tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
		
	
	}
	

}