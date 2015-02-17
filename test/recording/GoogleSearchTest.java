package recording;

import org.testng.annotations.Test;

public class GoogleSearchTest {

  @Test
  public void testGoogleSearch() {
    GoogleSearch gs = new GoogleSearch();
    try {
		gs.testGoogleSearch();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
