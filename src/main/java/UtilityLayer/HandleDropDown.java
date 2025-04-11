package UtilityLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class HandleDropDown extends BaseClass {

	public static void selectByVisibleText(WebElement wb, String value) {
		WebElement selwb = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));

		new Select(selwb).selectByVisibleText(value);
	}

	public static void selectByValue(WebElement wb, String value) {
		WebElement selwb = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));

		new Select(selwb).selectByValue(value);
	}

	public static void slectByIndex(WebElement wb, int index) {
		WebElement selwb = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));
		new Select(selwb).selectByIndex(index);
	}

	// to print all the options
	public static void getOptions(WebElement wb) {
		WebElement selwb = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));
		List<WebElement> ls = new Select(selwb).getOptions();

		// iterate and capture all values

		for (WebElement wb1 : ls) {
			System.out.println(wb1.getText());
		}

	}

	// to count the size of all options
	// create static size method by passing WebElement argument and int return type

	public static int size(WebElement wb) {
		WebElement selwb = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));

		List<WebElement> ls = new Select(selwb).getOptions();

		return ls.size();

	}

	public static String checkSpecificValue(WebElement wb, String value) {
		WebElement selwb = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));

		List<WebElement> ls = new Select(selwb).getOptions();

		// iterate all values
		for (WebElement wb1 : ls) {
			if (wb1.getText().equalsIgnoreCase(value)) {
				return wb1.getText();

			}

		}
		return null;

	}

	public static String getFirstSelectedOption(WebElement wb) {
		WebElement selwb = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));

		return new Select(selwb).getFirstSelectedOption().getText();

	}

}
