package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainObjectives.ResizableElements;
import mainObjectives.mainClass;

public class TC001__Resize__ extends mainClass  {
	@Test
	public void performResizePreformance() {
		ResizableElements resize = new ResizableElements(driver);
		resize.clickresize();
		resize.swichtoframe();
		resize.resizePerform(90, 20);
		resize.switchtoDefaultContent();
//		Assert.assertTrue(false);
	}

}
