package cucumber;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Base {
	//base 1 - webdriver
	static WebDriver driver;
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Testng\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	//base 2 - loadurl
	public static void loadurl(String url) {
		driver.get(url);
	}
	//base 3 - type
	public static void type(WebElement element, String name) {
		element.sendKeys(name);
	}
	//base 4 - click
	public static void btnclick(WebElement element) {
		element.click();
	}
	//base 5 - clear
	public static void txtclear(WebElement element) {
		element.clear();
	}
	//base 6 - close
	public static void CloseWindow() {
		driver.close();
	}
	//base 7 - Quit
	public static void quitbrowser() {
		driver.quit();
	}
	//base 8 - Defaultcontent
	public static void defaultcontent() {
		driver.switchTo().defaultContent();
	}
	//base 9 - Select
//	static Select s;
//	public static Select select(WebElement element) {
//		Select s=new Select(element);
//		return s;	
	//}
	//base 10- selectbyvalue
	public static void selectbyvalue(WebElement element,String name) {
		Select s=new Select(element);
		s.selectByValue(name);	
	}
	//base 11 - selectbyvisibletext
	public static void selectbyvisibletext(WebElement element,String name) {
		Select s=new Select(element);
		s.selectByVisibleText(name);
	}
	//base 12 - selectbyindex
	public static void selectbyindex(WebElement element,int name) {
		Select s=new Select(element);
		s.selectByIndex(name);
	}
	//base 13 - Get Options
	public static void getoptions(WebElement element) {
		Select s=new Select(element);
		s.getOptions();
	}
	//base 14 - getAllSelectedOptions
	public static void getAllSelectedOptions(WebElement element) {
		Select s=new Select(element);
		s.getAllSelectedOptions();
	}
	//base 15 - getFirstSelectedOption
	public static void getFirstSelectedOption(WebElement element) {
		Select s=new Select(element);
	s.getFirstSelectedOption();
	}
	//base 16 - isMultiple
	public static void isMultiple(WebElement element) {
		Select s=new Select(element);
	s.isMultiple();
	}
	//base 17 - deselectAll
	public static void deselectAll(WebElement element) {
		Select s=new Select(element);
		s.deselectAll();
	}
	//base 18 - deselectByIndex	
	public static void deselectByIndex(WebElement element,int value) {
		Select s=new Select(element);
	s.deselectByIndex(value);
	}
	//base 19 - deselectByValue
	public static void deselectByValue(WebElement element,String value) {
		Select s=new Select(element);
		s.deselectByValue(value);
	}
	//base 20 - deselectByVisibleText
	public static void deselectByVisibleText(WebElement element,String name) {
		Select s=new Select(element);
		s.deselectByVisibleText(name);
	}
	//base 21 - Actions
	static Actions a;
	public static Actions actions(WebElement element) {
		Actions a=new Actions(driver);
		return a;
	}
	//base 22 - movetoelement
	public static void movetoelement(WebElement element) {
		a.moveToElement(element).perform();
	}
	//base 23 - dragAndDrop
	public static void dragAndDrop(WebElement source,WebElement target) {
		a.dragAndDrop(source, target).perform();;
	}
	//base 24 - Contextclick
	public static void contextclick() {
		a.contextClick().perform();;
	}
	//base 25 - doubleclick
	public static void doubleclick() {
		a.doubleClick().perform();
	}
//	//base 26 alert
//	//static Alert driver1;
//	public static Alert getalert() {
//		Alert al= driver.switchTo().alert();
//		return al;
//	}
	//base 27 accept
	public static void accept() {
		Alert al= driver.switchTo().alert();
		al.accept();
	}
	//base 28 dismiss
	public static void dismiss() {
		Alert al= driver.switchTo().alert();
		al.dismiss();
	}
	//base 29 get text
	public static void gettext(String name) {
		Alert al= driver.switchTo().alert();
		String name1 = al.getText();
		System.out.println(name1);
	}
	//base 30 alert sendkeys
	public static void sendkeys(String name) {
		Alert al= driver.switchTo().alert();
		al.sendKeys(name);
	}
	//base 31 screenshot
	public static void screenshot(String destination) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File d=new File(destination);
		File s=tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, d);
	}
	//base 32 javascript setattribute
	public static void setattribute(WebElement element,String name) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0],setattribute('value',name)",element);
	}
	//base 33 Thread.sleep
	public static void threadsleep(long millisec) throws InterruptedException {
		Thread.sleep(millisec);
	}
	//base 34 Implicit wait
	public static void Implicitwait(long milliseconds) {
		driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.SECONDS);
	}
	//base 35 frame index
	public static void Frameindex(int index) {
		driver.switchTo().frame(index);
	}
	//base 35 Parent frame
	public static void Parentframeindex() {
			driver.switchTo().parentFrame();
	}
	//base 35 parent window id
		public static void ParentWindow() {
			String parent=driver.getWindowHandle();
			System.out.println(parent);
		}
	//base 36 excel
//		public static String getdata(String sheetname,int rowNo,int cellNo) throws IOException {
//			File loc=new File("D:\\Selenium\\facebookinfo\\Excel\\Test.xlsx");
//			FileInputStream stream=new FileInputStream(loc);
//			Workbook w=new XSSFWorkbook(stream);
//			Sheet s=w.getSheet(sheetname);
//			Row r=s.getRow(rowNo);
//			Cell c=r.getCell(cellNo);
//			int type=c.getCellType();
//			String name=null;
//			if (type==1) {
//				name=c.getStringCellValue();
//			}
//			if (type==0) {
//				if(DateUtil.isCellDateFormatted(c)) {
//					name= new SimpleDateFormat("dd-mmm-yy").format(c.getDateCellValue());
//				}
//				else {
//					name=String.valueOf((long)c.getNumericCellValue());
//				}
//			}
//			return name;
//		}
//		//base 37 - get attribute
		public static String getattri(WebElement element) {
			return element.getAttribute("Value");
		}
		//base 38 - update excel
//		public static String updatedata(String sheetname,int rowNo,int cellNo,String name) throws IOException {
//			File loc=new File("D:\\Selenium\\facebookinfo\\Excel\\Test.xlsx");
//			FileInputStream stream=new FileInputStream(loc);
//			Workbook w=new XSSFWorkbook(stream);
//			Sheet s=w.getSheet(sheetname);
//			Row r=s.getRow(rowNo);
//			Cell c=r.createCell(cellNo);
//			c.setCellValue(name);
//			FileOutputStream o=new FileOutputStream(loc);
//			w.write(o);
//			System.out.println("Done....");
//			return null;			
//}
}


