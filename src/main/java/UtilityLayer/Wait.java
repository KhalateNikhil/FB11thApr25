package UtilityLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Wait extends BaseClass {

	public static void sendKeys(WebElement wb, String value) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb)).sendKeys(value);

	}

	public static void click(WebElement wb) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb)).click();
	}

	public static String getText(WebElement wb) {
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb)).getText();
	}

	public static String getAttribute(WebElement wb, String keyname) {
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb))
				.getAttribute(keyname);
	}

	public static void selectAnyOption(List<WebElement> ls, String value)

	{
		List<WebElement> allwb = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfAllElements(ls));
		// iterate all values

		for (WebElement wb1 : allwb) {
			if (wb1.getText().equalsIgnoreCase(value)) {
				wb1.click();
				break;

			}
		}
	}

}
