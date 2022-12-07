package TestCases;

import org.testng.annotations.Test;

import mainObjectives.dragPageElements;
import mainObjectives.mainClass;

public class TC002__drag__  extends mainClass    {
	dragPageElements drag;
	@Test(priority=1)
public void	dragFromOnePlacetoAnotherPlace() {
		
		drag.clickondraggable();
	}
@Test(priority=2)
public void shiftfrm() {
	drag.switchtoframe();
	
}
@Test(priority=3)
public void dgranddrp() {
	drag.dragtodrop(100,50);
}

@Test(priority=4)
public void shiftdflt() {
	drag.switchtodefaulcontent();
	System.out.println("Test  execution sucessfully");
}
		
		


}
