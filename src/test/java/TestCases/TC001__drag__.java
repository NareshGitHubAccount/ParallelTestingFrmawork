package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainObjectives.dragPageElements;
import mainObjectives.mainClass;

public class TC001__drag__  extends mainClass{
	
	@Test
public void	dragFromOnePlacetoAnotherPlace() throws Exception {
		logger.info("Create Object for dragPageElements Class");
		dragPageElements drag = new dragPageElements(driver);
		drag.clickondraggable();
		
		
		drag.switchtoframe();
		
		drag.dragtodrop(100,50);

		System.out.println("title of webpage" + driver.getTitle());
		
		drag.switchtodefaulcontent();
//		Assert.assertTrue(false);
		
	}
	

}
