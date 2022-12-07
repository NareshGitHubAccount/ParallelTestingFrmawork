package mainObjectives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPageElements {
	
	public WebDriver driver;
	@FindBy(xpath="//*[text()='Droppable']")
	WebElement draganddrop;
	
	@FindBy(xpath="//*[@class='demo-frame']")
	WebElement Swifttoframe;
	
	@FindBy(id="draggable")
	WebElement draggable;
	
	@FindBy(id="droppable")
	WebElement droppable;
	
	public  DragAndDropPageElements(WebDriver d) {
		driver =d;
		PageFactory.initElements(d,this);
	}
	
	public void clickonDrggable() {
		draganddrop.click();
	}
	
	public void switchToframe() {
		driver.switchTo().frame(Swifttoframe);
	}
	
	public void draganddropperform() {
	
		Actions act = new Actions(driver);
		act.dragAndDrop(draggable, droppable).perform();
		
	}
	public void switchtodefaulcontent() {
		driver.switchTo().defaultContent();
	}
	

}
