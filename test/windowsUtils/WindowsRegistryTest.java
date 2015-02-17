package windowsUtils;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;


public class WindowsRegistryTest {

  @Test
  public void WriteRegValue() {
	  WindowsRegistry wr = new WindowsRegistry();
	  wr.WriteRegValue();
	  //assertTrue
   // throw new RuntimeException("Test not implemented");
  }

  @Test
  public void readRegValue() {
	  WindowsRegistry wr = new WindowsRegistry();
	  wr.readRegValue();
    //throw new RuntimeException("Test not implemented");
  }
}
