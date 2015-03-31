package screenshots;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CapturingShotsTest {

	@Test
	public void testGetScreenShot() throws IOException {
		CapturingShots c = new CapturingShots();
		//c.getScreenShot();
		c.getScreenShot(null);
	}

}
