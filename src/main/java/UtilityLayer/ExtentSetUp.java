package UtilityLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentSetUp extends BaseClass {

	// create static setUp method with ExtentReports return type and 1 String
	// argument
	private static ExtentReports extentreports;
	private static ExtentSparkReporter extentsparkreporter;

	public static ExtentReports setUp(String suitename) {
		extentreports = new ExtentReports();
		extentsparkreporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\ExtentHTMLReport\\" + suitename + date() + ".html");
		extentreports.attachReporter(extentsparkreporter);
		return extentreports;

	}

	// create static screenshot code with 2 String arguments and String return type

	public static String screenshot(String foldername, String methodname) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\" + foldername + "\\" + methodname + date() + ".png";

		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest;
	}

	// create simple date object
	public static String date() {
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

	}

}
