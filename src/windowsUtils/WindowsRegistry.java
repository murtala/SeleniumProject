package windowsUtils;

import org.openqa.selenium.os.WindowsUtils;

public class WindowsRegistry {

	
	public void readRegValue(){
		
		WindowsUtils.tryToKillByName("firefox.exe");
		String osName =  WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\WindowsNT\\CurrentVersion\\DevicePath");
		//String osName = WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\WindowsNT\\CurrentVersion\\DevicePath");
		System.out.println("OS name: "+osName);
	}
	
	public void WriteRegValue(){
		WindowsUtils.writeStringRegistryValue("HKEY_CURRENT_USER\\SOFTWARE\\Selenium\\SeleniumVersion", "2.24");
				//assertEquals("2.24",WindowsUtils.readStringRegistryValue("HKEY_CURRENT_USER\\SOFTWARE\\Selenium\\SeleniumVersion"));
	}
}
