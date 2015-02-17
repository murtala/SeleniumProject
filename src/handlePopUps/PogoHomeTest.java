package handlePopUps;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class PogoHomeTest {

	PogoHome p = new PogoHome();

	@Test
	public void testHomePage() throws InterruptedException {
		p.homePage();
		//p.openPopUps();
		p.handlePopUp();
	}

	@Ignore
	@Test
	public void testOpenPopUps() throws InterruptedException {

	}

}
