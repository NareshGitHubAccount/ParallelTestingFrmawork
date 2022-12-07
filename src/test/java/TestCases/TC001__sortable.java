package TestCases;

import org.testng.annotations.Test;

import mainObjectives.mainClass;
import mainObjectives.selectableElements;
import mainObjectives.sortableElements;

public class TC001__sortable extends mainClass {
	@Test(priority=1)
	public void sortblePerformance() throws Exception {
		sortableElements sortable = new sortableElements(driver);
		sortable.clickOnsortable();
		sortable.idftext();
		sortable.scroll();
		sortable.switchToFrame();
		sortable.performSortOperation();
	
		sortable.switchtodefaulcontent();
	
	}

}
