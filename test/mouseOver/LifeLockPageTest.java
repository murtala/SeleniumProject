package mouseOver;

import handlePopUps.PogoHome;

import java.io.IOException;

import javaScriptAlerts.HandlingAlerts;
import javasScript.SelJavaScriptExample;

import keyboardKeys.HoldingKeys;
import keyboardKeys.TypeKeys;

import manageWindows.BrowserManagement;
import manageWindows.Windows;
import navigation.navigating;

import org.testng.annotations.Test;

import snippets.FindingLinks;
import tables.FindingElements;
import tables.TableExample;
import userAgent.UserAgent;
import widgets.Widget;
import windowsUtils.WindowsRegistry;

import compareImages.CompareImage;
import doubleClick.DoubleClicking;
import dragAndDrop.DragAndDrop;

public class LifeLockPageTest {
  @Test
  public void f() throws InterruptedException, IOException {
	  
	  Widget.setBrowser("ff");
	  Widget.getBrowser();
	  
	 // Widget.OpenLink("http://www.w3schools.com/html/html_tables.asp");
		 	
	 
	  
	  
	  PogoHome ph = new PogoHome();
	  ph.homePage();
	  ph.openPopUps();
	  ph.handlePopUp();
	  
	  /* 
	  WindowsRegistry wr = new WindowsRegistry();
	  wr.readRegValue();
	 	  
	  
	 
	  DragAndDrop dnd = new DragAndDrop();
	  dnd.DragAndDropAPIexample();
		
		  DoubleClicking dc = new DoubleClicking();
	  dc.doubleClick();

		 HoldingKeys hk = new HoldingKeys();
	  hk.selectMultipleTableRows();
  TableExample te = new TableExample();
	  te.printAllRows();
	  
	  
	  FindingElements fe = new FindingElements();
	  fe.findByCssTxt();

	 FindingLinks fl = new FindingLinks();
fl.findAlllinks();
	
	 LifeLockPage llp = new LifeLockPage();
	  llp.openHome("http://www.google.com");
  HandlingAlerts ha = new HandlingAlerts();
	  ha.handleAlert();
SelJavaScriptExample jse = new SelJavaScriptExample();
//jse.executingAsyncScripts();
jse.executingScripts();
	   
	   TypeKeys tk = new TypeKeys();
tk.keyTyping();
	   
	   Windows win = new Windows();
	 win.switchWindow();
	  BrowserManagement bm = new BrowserManagement();
	 bm.WindowEvents();
	
	 navigating nav = new navigating();
	 nav.navigation();
	  CompareImage ci = new CompareImage();
	  System.out.println(ci.compare());
	  
	  UserAgent ua = new UserAgent();
	  ua.switchTo("Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5355d Safari/8536.25");
	  
	  //llp.getMenusList();
	  //llp.close();
	  //llp.hovernMenu();
	 // llp.getMenusLists();
	  * 
	  */
  }
}
