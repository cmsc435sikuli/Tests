import java.awt.*;

import javax.swing.*;

import java.io.*;

import java.util.List;

import junit.framework.TestCase;
import edu.umd.cs.guitar.model.data.AttributesType;
import edu.umd.cs.guitar.model.GWindow;
import edu.umd.cs.guitar.model.JFCXComponent;
import edu.umd.cs.guitar.model.JFCXWindow;
import edu.umd.cs.guitar.model.data.ComponentType;
import edu.umd.cs.guitar.ripper.Ripper;
import edu.umd.cs.guitar.model.data.PropertyType;


public class TestGuitar extends TestCase {
	
	
	public Window CreateWindow(){
		Window wind = new JFrame();
		wind.setLocation(0, 0);
		wind.setSize(40,40);
		return wind;
	}
	
	/** Make sure components that are outside of their window are ignored **/
	public void testJFCXComponent1(){
		
		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");
		
		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}
		ComponentStub component = new ComponentStub(-21, -21, 20, 20);
		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc = new JFCXComponent(component, window);
		String string = "before_click";
		boolean ret1 = jfc.captureImage(string);
		assertFalse(ret1);
		
		component = new ComponentStub(-21, 5, 20, 20);
		wind = CreateWindow();
		window = new JFCXWindow(wind);
		jfc = new JFCXComponent(component, window);
		ret1 = jfc.captureImage(string);
		assertFalse(ret1);
		
		component = new ComponentStub(10, -25, 20, 20);
		wind = CreateWindow();
		window = new JFCXWindow(wind);
		jfc = new JFCXComponent(component, window);
		ret1 = jfc.captureImage(string);
		assertFalse(ret1);
		
		component = new ComponentStub(50, 50, 20, 20);
		wind = CreateWindow();
		window = new JFCXWindow(wind);
		jfc = new JFCXComponent(component, window);
		ret1 = jfc.captureImage(string);
		assertFalse(ret1);
		
		component = new ComponentStub(20, 50, 20, 20);
		wind = CreateWindow();
		window = new JFCXWindow(wind);
		jfc = new JFCXComponent(component, window);
		ret1 = jfc.captureImage(string);
		assertFalse(ret1);
		
		component = new ComponentStub(50, 20, 20, 20);
		wind = CreateWindow();
		window = new JFCXWindow(wind);
		jfc = new JFCXComponent(component, window);
		ret1 = jfc.captureImage(string);
		assertFalse(ret1);
		
		assertTrue(directory.list().length == 0);
	}
	
	/** 
	 * Make sure screenshots of components that are completely inside
	 * of their window are saved 
	 **/
	public void testJFCXComponent2(){

		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");

		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}
		
		ComponentStub component = new ComponentStub(10, 10, 20, 20);
		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc = new JFCXComponent(component, window);
		String string = "before_click";
		boolean ret1 = jfc.captureImage(string);
		assertTrue(ret1);
		string = "after_click";
		ret1 = jfc.captureImage(string);
		
		String[] list = directory.list();
		assertTrue(list.length == 2);
		assertTrue(list[0].contains("after_click") || list[1].contains("after_click"));
		assertTrue(list[0].contains("before_click") || list[1].contains("before_click"));	
	}
	
	/**
	 * Make sure screenshots of components that are partially inside of their
	 * window are saved
	 */
	public void testJFCXComponent3() {

		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");

		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}
		ComponentStub component = new ComponentStub(-15, -15, 20, 20);
		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc = new JFCXComponent(component, window);
		String string = "before_click";
		boolean ret1 = jfc.captureImage(string);
		assertTrue(ret1);

		component = new ComponentStub(35, 35, 20, 20);
		wind = CreateWindow();
		window = new JFCXWindow(wind);
		jfc = new JFCXComponent(component, window);
		ret1 = jfc.captureImage(string);
		assertTrue(ret1);

		component = new ComponentStub(-15, 10, 20, 20);
		wind = CreateWindow();
		window = new JFCXWindow(wind);
		jfc = new JFCXComponent(component, window);
		ret1 = jfc.captureImage(string);
		assertTrue(ret1);

		component = new ComponentStub(10, -15, 20, 20);
		wind = CreateWindow();
		window = new JFCXWindow(wind);
		jfc = new JFCXComponent(component, window);
		ret1 = jfc.captureImage(string);
		assertTrue(ret1);

		assertTrue(directory.list().length == 4);
	}
	
	/** 
	 * Make sure JRadioButtons are handled correctly 
	 **/
	public void testJFCXComponent4(){

		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");

		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}
		
		JRadioButtonStub button1 = new JRadioButtonStub(0, 0, 20, 20);
		JRadioButtonStub button2 = new JRadioButtonStub(0, 20, 20, 20);
		button1.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(button1);
		group.add(button2);
		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc1 = new JFCXComponent(button1, window);
		
		boolean ret1 = jfc1.captureImage("before_click");
		assertTrue(ret1);
		String[] list = directory.list();
		assertTrue(list.length == 0);
		
		ret1 = jfc1.captureImage("after_click");
		assertTrue(ret1);
		list = directory.list();
		assertTrue(list.length == 0);
		
		
		JFCXComponent jfc2 = new JFCXComponent(button2, window);
		ret1 = jfc2.captureImage("before_click");
		assertTrue(ret1);
		list = directory.list();
		assertTrue(list.length == 2);
		
		ret1 = jfc2.captureImage("after_click");
		assertTrue(ret1);
		list = directory.list();
		assertTrue(list.length == 4);
	}	
	
	/** 
	 * Make sure JRadioButtonMenuItems are handled correctly 
	 **/
	public void testJFCXComponent5(){

		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");

		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}
		
		JRadioButtonMenuItemStub button1 = new JRadioButtonMenuItemStub(0, 0, 20, 20);
		JRadioButtonMenuItemStub button2 = new JRadioButtonMenuItemStub(0, 20, 20, 20);
		button1.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(button1);
		group.add(button2);
		
		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc1 = new JFCXComponent(button1, window);
		
		boolean ret1 = jfc1.captureImage("before_click");
		assertTrue(ret1);
		String[] list = directory.list();
		assertTrue(list.length == 0);
		
		ret1 = jfc1.captureImage("after_click");
		assertTrue(ret1);
		list = directory.list();
		assertTrue(list.length == 0);
		
		JFCXComponent jfc2 = new JFCXComponent(button2, window);
		ret1 = jfc2.captureImage("before_click");
		assertTrue(ret1);
		list = directory.list();
		assertTrue(list.length == 2);
		
		ret1 = jfc2.captureImage("after_click");
		assertTrue(ret1);
		list = directory.list();
		assertTrue(list.length == 4);

	}	
	
	/** 
	 * Make sure the correct image paths are added to the XML
	 * if the component is unexpandable.
	 */
	public void testGComponent1(){
		
		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");

		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}
		
		ComponentStub component = new ComponentStub(-21, -21, 20, 20);
		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc = new JFCXComponent(component, window);
		
		ComponentType retComp = jfc.extractProperties("unexpandable");
		AttributesType attributes = retComp.getAttributes();
	
		List<PropertyType> lProperty = attributes.getProperty();

		boolean found = false;
		
		for (PropertyType p : lProperty) {
			if(p.getValue().toString().equals("[" + jfc.IMG_PATH + jfc.ID + "unexpandable.png" + "]")){
				found = true;
			}
		}
		assertTrue(found);
	}
	
	/** 
	 * Make sure the correct image paths are added to the XML
	 * if the component is expandable.
	 */
	public void testGComponent2(){
		
		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");

		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}
		
		ComponentStub component = new ComponentStub(-21, -21, 20, 20);
		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc = new JFCXComponent(component, window);
		
		ComponentType retComp = jfc.extractProperties("expandable");
		AttributesType attributes = retComp.getAttributes();
	
		List<PropertyType> lProperty = attributes.getProperty();

		boolean before = false;
		boolean after = false;
		
		for (PropertyType p : lProperty) {
			if(p.getValue().toString().equals("[" + jfc.IMG_PATH + jfc.ID + "before_click.png" + "]")){
				before = true;
			}
			if(p.getValue().toString().equals("[" + jfc.IMG_PATH + jfc.ID + "after_click.png" + "]")){
				after = true;
			}
		}
		assertTrue(before);
		assertTrue(after);
	}
	
	/**
	 * If a component is expandable, then two pictures should
	 * be taken. One before picture and one after picture. 
	 */
	public void testRipper1() {

		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");

		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}

		JRadioButtonStub button1 = new JRadioButtonStub(0, 0, 20, 20);
		button1.getAccessibleContext().setAccessibleName("Stuff");

		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc = new JFCXComponent(button1, window);

		Ripper rip = new Ripper();
		rip.setMonitor(new JFCRipperMonitorStub());

		assertEquals(rip.takePictures(jfc, window), "expandable");
		String[] list = directory.list();
		assertTrue(list.length == 2);
	}


	/**
	 * If a component is unexpandable, then only one picture should be taken.
	 */
	public void testRipper2() {

		File directory = null;
		if (System.getProperty("os.name").contains("Windows"))
			directory = new File(".\\images");
		else
			directory = new File("./images");

		File[] files = directory.listFiles();
		for (File file : files) {

			assertTrue(file.delete());
		}

		JRadioButtonStub button1 = new JRadioButtonStub(0, 0, 20, 20);

		Window wind = CreateWindow();
		GWindow window = new JFCXWindow(wind);
		JFCXComponent jfc = new JFCXComponent(button1, window);

		Ripper rip = new Ripper();
		rip.setMonitor(new JFCRipperMonitorStub());

		assertEquals(rip.takePictures(jfc, window), "unexpandable");
		String[] list = directory.list();
		assertTrue(list.length == 1);
	}
}
