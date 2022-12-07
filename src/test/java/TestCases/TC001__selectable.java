package TestCases;

import org.testng.annotations.Test;

import mainObjectives.mainClass;
import mainObjectives.selectableElements;

public class TC001__selectable extends mainClass {
	@Test(priority=1)
	public void selectablePerformance() throws Exception {
		selectableElements selectable = new selectableElements(driver);
		selectable.clickOnselectable();
		selectable.idftext();
		selectable.scroll();
		selectable.switchToFrame();
	    selectable.performSelectOperation();
		selectable.switchtodefaulcontent();
	}

}
