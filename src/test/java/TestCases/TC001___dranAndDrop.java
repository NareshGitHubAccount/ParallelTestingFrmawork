package TestCases;

import org.testng.annotations.Test;

import mainObjectives.DragAndDropPageElements;
import mainObjectives.mainClass;

public class TC001___dranAndDrop extends mainClass {

	@Test(priority = 1)
	public void draggingPerformance() {
		DragAndDropPageElements drganddrp = new DragAndDropPageElements(driver);
		drganddrp.clickonDrggable();
		drganddrp.switchToframe();
		drganddrp.draganddropperform();
		drganddrp.switchtodefaulcontent();
	}
}
