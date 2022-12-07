package mainObjectives;

import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectableElements {
	
	public WebDriver driver;
	@FindBy(xpath="//*[text()='Selectable']")
 WebElement Selectable;
	
	@FindBy(xpath="//*[@class='demo-frame']")
	WebElement Swifttoframe;
	
	@FindBy(xpath="(//*[text()='Selectable'])[1]")
	WebElement text;
	
	@FindBy(xpath="//li[text()='Item 1']")
	 WebElement item1;
	@FindBy(xpath="//li[text()='Item 2']")
	 WebElement item2;
	@FindBy(xpath="//li[text()='Item 3']")
	 WebElement item3;
	@FindBy(xpath="//li[text()='Item 4']")
	 WebElement item4;
	@FindBy(xpath="//li[text()='Item 5']")
	 WebElement item5;
	@FindBy(xpath="//li[text()='Item 6']")
	 WebElement item6;
	@FindBy(xpath="//li[text()='Item ']")
	 WebElement item7;
	
	
	
	public  selectableElements(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
		
	}
	public void clickOnselectable() {
		Selectable.click();
	}
	public void switchToFrame() {
		driver.switchTo().frame(Swifttoframe);
	}
	public void idftext() {
		String abcc =text.getText();
		System.out.println(abcc);
	}
	
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
//		js.executeScript("arguments[0].scrollIntoView();", item6);
	}
	
	public void item1() {
		WebElement one=item1;
	}
	public void item2() {
		WebElement two=item2;
	}
	public void item3() {
		WebElement three=item3;
	}
	public void item4() {
		WebElement four=item4;
	}
	
	public void item5() {
		WebElement five=item5;
	}
	public void item6() {
		WebElement six=item6;
	}
	public void item7() {
		WebElement seven=item7;
	}
	
	public void performSelectOperation() {
		WebElement one=item1;
		WebElement three=item3;
		WebElement five=item5;
		
		Actions act = new Actions(driver);
//		act.keyDown(Keys.CONTROL).click(one).click(three).click(five).click(seven).keyUp(Keys.CONTROL).build().perform();
		act.keyDown(Keys.CONTROL).click(one).click(three).click(five).keyUp(Keys.CONTROL).build().perform();

	}
	
	public void switchtodefaulcontent() {
		driver.switchTo().defaultContent();
	}

}
