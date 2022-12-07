package mainObjectives;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sortableElements {
	
	public WebDriver driver;
	@FindBy(xpath="//*[text()='Sortable']")
 WebElement Sortable;
	
	@FindBy(xpath="//*[@class='demo-frame']")
	WebElement Swifttoframe;
	
	@FindBy(xpath="(//*[text()='Sortable'])[1]")
	WebElement text;
	
	@FindBy(xpath="(//*[@class='ui-state-default ui-sortable-handle'])[1]")
	 WebElement item1;
	@FindBy(xpath="(//*[@class='ui-state-default ui-sortable-handle'])[2]")
	 WebElement item2;
	@FindBy(xpath="(//*[@class='ui-state-default ui-sortable-handle'])[3]")
	 WebElement item3;
	@FindBy(xpath="(//*[@class='ui-state-default ui-sortable-handle'])[4]")
	 WebElement item4;
	@FindBy(xpath="(//*[@class='ui-state-default ui-sortable-handle'])[5]")
	 WebElement item5;
	@FindBy(xpath="(//*[@class='ui-state-default ui-sortable-handle'])[6]")
	 WebElement item6;
	@FindBy(xpath="(//*[@class='ui-state-default ui-sortable-handle'])[7]")
	 WebElement item7;
	
	
	
	public  sortableElements(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
		
	}
	public void clickOnsortable() {
		Sortable.click();
	}
	public void switchToFrame() {
		driver.switchTo().frame(Swifttoframe);
	}
	public void idftext() {
		String abcc =text.getText();
		System.out.println(abcc);
	}
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)"," ");
	}
		
	public void performSortOperation() throws Exception {
		
		
		WebElement one=item1;
		Thread.sleep(1000);
		WebElement two=item2;
		Thread.sleep(1000);
		WebElement three=item3;
		Thread.sleep(1000);
		WebElement four=item4;
		Thread.sleep(1000);
		WebElement five=item5;
		Thread.sleep(1000);
		WebElement six=item6;
		Thread.sleep(1000);
		WebElement seven=item7;
		

		
		Actions act = new Actions(driver);
		Thread.sleep(1000);			
		act.clickAndHold(one).moveToElement(seven).release().perform();
		Thread.sleep(1000);	
		act.clickAndHold(three).moveToElement(one).release().perform();
		Thread.sleep(1000);	
		act.clickAndHold(five).moveToElement(three).release().perform();
		Thread.sleep(1000);	
		act.clickAndHold(seven).moveToElement(five).release().perform();
		
	}
	
	public void switchtodefaulcontent() {
		driver.switchTo().defaultContent();
	}

}
