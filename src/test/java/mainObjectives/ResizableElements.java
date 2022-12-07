package mainObjectives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResizableElements {
	 WebDriver driver;
	@FindBy(xpath="//*[text()='Resizable']")
	WebElement Resizable;
	@FindBy(xpath="//*[@class='demo-frame']")
	WebElement frame;
	@FindBy(xpath="//*[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
	WebElement increseSize;
	

public ResizableElements(WebDriver d) {
	driver=d;
	PageFactory.initElements(d, this);
}
public void clickresize() {
	Resizable.click();
}
public void swichtoframe() {
	driver.switchTo().frame(frame);
}


public void resizePerform(int x, int y) {
	Actions act = new Actions(driver);
	act.dragAndDropBy(increseSize, x, y).release().perform();
}
public void switchtoDefaultContent() {
	driver.switchTo().defaultContent();
}

}
