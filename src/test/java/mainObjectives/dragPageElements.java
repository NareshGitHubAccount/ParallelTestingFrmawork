package mainObjectives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class dragPageElements {
	
	public WebDriver driver;
	@FindBy(xpath="//*[text()='Draggable']")
	WebElement draggble;

	@FindBy(xpath="//*[@src=\"/resources/demos/draggable/default.html\"]")
	WebElement switchFrame;
	@FindBy(id="draggable")
	WebElement dragmearround;
	
	
	public dragPageElements(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickondraggable() {
		draggble.click();
	}
	public void switchtoframe() {
		driver.switchTo().frame(switchFrame);
	}
	public void dragtodrop( int a, int b) {
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(dragmearround, a, b).perform();
	}
	public void switchtodefaulcontent() {
		driver.switchTo().defaultContent();
	}
	
	

}
