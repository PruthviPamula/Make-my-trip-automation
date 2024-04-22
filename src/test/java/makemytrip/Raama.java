package makemytrip;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Raama {
	WebDriver Sravani;
	Robot r;
	WebDriverWait wait;
	JavascriptExecutor Raama;
	

	@BeforeTest
	public void tt() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	options.addArguments("disable-notifications");
	Sravani= new ChromeDriver(options);
	Sravani.manage().window().maximize();
	Sravani.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	Sravani.get("https://www.facebook.com/login");
	}
	@Test
	public void Facebook() throws InterruptedException, IOException{
		Sravani.findElement(By.xpath("//*[@aria-label='Email address or phone number']")).sendKeys("7702022639");
		Sravani.findElement(By.xpath("//*[@aria-label='Password']")).sendKeys("suguna");
		Sravani.findElement(By.xpath("//*[@name='login']")).click();
		Sravani.findElement(By.xpath("(//*[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6'])[2]")).click();
		System.out.println("Friends button clicked");
		Thread.sleep(5000);
		Sravani.findElement(By.xpath("//*[@aria-label='Video']")).click();
		Raama= (JavascriptExecutor)Sravani;
	    Raama.executeScript("window.scrollBy(0,400)");
	    Thread.sleep(3000);
		Sravani.findElement(By.xpath("(//*[@class='x1b0d499 xaj1gnb'])[6]")).click();
		Thread.sleep(10000);
		TakesScreenshot ss=(TakesScreenshot)Sravani;
		File jpnng = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(jpnng,new File("C:\\Users\\pruth\\Desktop\\New folder"));
		Sravani.findElement(By.xpath("(//*[@class='x1b0d499 xaj1gnb'])[6]")).click();
		Sravani.findElement(By.xpath("//*[@aria-label='Menu']")).click();
		
		Set<String> wk = Sravani.getWindowHandles();
		for (String windowHandles : wk) {			    
		Sravani.switchTo().window(windowHandles);
		System.out.println("entered into new window");
		Raama= (JavascriptExecutor)Sravani;
	    Raama.executeScript("window.scrollBy(0,500)");
		Sravani.findElement(By.xpath("(//*[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6'])[18]")).click();
		
		

	}
}
}