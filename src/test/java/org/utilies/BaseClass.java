package org.utilies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.StackManipulation.Size;

public class BaseClass {
	public static WebDriver driver;
	public static Actions mouse;
	public static File file;
	public static Date date;

	public static void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	public static void launchEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();

	}
	
	
	public static void loadUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		
	}

	public static WebElement locateElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);

	}

	public static void scrollup(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);

	}

	public static void scrollDown(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);

	}

	public static void mouseHover(WebElement ele) {
		mouse = new Actions(driver);
		mouse.moveToElement(ele).perform();
	}

	public static void mouseclick(WebElement ele) {
		mouse = new Actions(driver);
		mouse.click(ele).perform();
	}

	public static void mouseRightClick(WebElement ele) {
		mouse = new Actions(driver);
		mouse.contextClick(ele).perform();
	}

	public static void switchToFrames(String tagName, String frameId) {
		driver.findElement(By.tagName(tagName));
		driver.switchTo().frame(frameId);

	}
public static void pause(int till) {
	driver.manage().timeouts().implicitlyWait(till, TimeUnit.SECONDS);

}
	public static void toCreateFileObject(String filePath) {
		file = new File(filePath);
	}

	public static String dataDrivenFromExcel( File file,String sheetName, int rowIndexNumber, int cellIndexNumber)
			throws IOException {
		FileInputStream fis = new FileInputStream(file);

		Workbook w = new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowIndexNumber);
		Cell cell = row.getCell(cellIndexNumber);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();

		} else if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				value = sim.format(d);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				value = String.valueOf(l);
			}
		}

		return value;
	}

	public static void loadDataInExcel(String fileLocation, int rowNumber, int cellNumber, String cellValue)
			throws IOException {

		file.createNewFile();

		Workbook w = new XSSFWorkbook();
		Sheet sheet = w.createSheet();
		Row row0 = sheet.createRow(rowNumber);
		Cell cell00 = row0.createCell(cellNumber);
		cell00.setCellValue(cellValue);
		FileOutputStream fout = new FileOutputStream(file);
		w.write(fout);
	}

	
	
	public static void TestStartTime() {
		date=new Date();
		System.out.println(date);
		
	}
	public static void TestEndTime() {
		date=new Date();
		System.out.println(date);
		
	}
	public static void toScreenShot(String picName) throws IOException {
		TakesScreenshot ss=(TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
	File des=new File("C:\\Users\\Star\\eclipse-workspace\\CucumberProjects\\target\\ScreenShots\\"+picName+".png");
	FileUtils.copyFile(src, des);
	}
	
}
