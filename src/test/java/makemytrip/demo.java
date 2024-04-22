package makemytrip;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {
	WebDriver wd;
	Robot r;
	WebDriverWait wait;
	JavascriptExecutor js;
	ExtentHtmlReporter htmlreporter;
	ExtentReports raama;
	ExtentTest test;
	
	@BeforeTest
	public void tt() {
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("raama.html");
		raama = new ExtentReports();
		raama.attachReporter(htmlreporter);
		WebDriverManager.chromedriver().setup();
		wd= new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		wd.get("https://www.makemytrip.com/");
	
}
	@Test(priority = 0)
	public void test1() throws InterruptedException, AWTException {
		test = raama.createTest("This my first test");
		Thread.sleep(3000);
  	    for(int i=0;i<=8;i++) {
  	    wd.navigate().refresh();
  	  wd.navigate().refresh();
  	}
	}
	@Test(priority = 1)
	public void test2() throws InterruptedException, AWTException {
		test = raama.createTest("This my second test");
		wait = new WebDriverWait(wd,20);
		WebElement we =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='chNavText darkGreyText'])[4]")));
	    we.click();
	    test.pass("clicked on Holiday Packages");
	    wd.findElement(By.xpath("//*[@id='fromCity']")).click(); 
	    test.pass("clicked on From city label");
		wd.findElement(By.xpath("//*[@class='citypicker_list']/ul[1]/li")).click(); 
		test.pass("clicked to select Bangalore");

		 wd.findElement(By.xpath("//*[@id='toCity']")).click();
		 test.pass("clicked on To city label");
		 wd.findElement(By.xpath("//*[@class='dest-search-input']")).sendKeys("Singa");
		 test.pass("clicked to select singapoore");

		 wd.findElement(By.xpath("//*[@class='dest-search-list']/div[1]/div[1]/div[1]/div[1]")).click(); 
		 test.pass("clicked on search button");
		
	
	     Thread.sleep(3000);
	     wd.findElement(By.xpath("(//*[@class='DayPicker-Month'])[1]/div[3]/div[3]/div[3]")).click();
	     test.pass("clicked on 12/09/2023");
	     Thread.sleep(3000);
	     js = (JavascriptExecutor)wd;
	     js.executeScript("window.scrollBy(0,100)");
	     Thread.sleep(5000);
	     wd.findElement(By.xpath("//*[@class='applyBtn']")).click();
	     test.pass("clicked on apply button");
	     Thread.sleep(5000);
	     js.executeScript("window.scrollBy(0,100)");
	     wd.findElement(By.xpath("//*[@class='action']")).click();
	     test.pass("clicked on apply button");
         WebElement we2 =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='search_button']")));
         we2.click();
         test.pass("clicked on searcch button");
}
	 
	 @Test(priority = 2)
	 public void test3() throws InterruptedException, AWTException {
		 test = raama.createTest("This my Third test");
		    wd.findElement(By.xpath("//*[@class='skipBtn']")).click();
		    test.pass("clicked on skip button");
		   
	        Thread.sleep(20000);

    		wd.findElement(By.xpath("//*[@class='close closeIcon']")).click();
    		test.pass("clicked on closing icon");
			wd.navigate().refresh();
	        Thread.sleep(20000);
			Actions act= new Actions(wd);
	        WebElement we=wd.findElement(By.xpath("(//*[@class='rc-slider-handle rc-slider-handle-2'])[2]"));
	        test.pass("selected on  maximum slider");
			WebElement ws=wd.findElement(By.xpath("(//*[@class='rc-slider-handle rc-slider-handle-1'])[2]"));
			test.pass("selected on minimum slider");
			act.dragAndDrop(we, ws).build().perform();

			wd.findElement(By.xpath("//*[@class='sliderCard']")).click();
			test.pass("clicked on Hotel button");
    
	 
			Set<String> wk = wd.getWindowHandles();
			for (String windowHandle : wk) {			    
			wd.switchTo().window(windowHandle);			     
		    wd.navigate().refresh();
}		
}
	 @Test (priority = 4)
	 public void test4() throws InterruptedException {
		 test = raama.createTest("This my fourth test");
		 Thread.sleep(10000);
	  js.executeScript("window.scrollBy(0,500)");
	  test.pass("scrolled the page ");
	  wd.findElement(By.xpath("(//*[@id='change'])[3]")).click();
	  test.pass("clicked on change button");
	  Thread.sleep(10000);
      WebElement we=wd.switchTo().activeElement();
      we.findElement(By.xpath("(//*[@class='boxContainer '])[1]")).click();
      test.pass("clicked on three star hotels");
      WebElement ws=wd.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[5]"));
      test.pass("clicked on select buttont");
      js.executeScript("arguments[0].click();",ws);
      test.pass("scrolled the page upto ws");
      wd.findElement(By.xpath("//*[@class='updatePackageBtnText font10']")).click();
      test.pass("clicked on update package button");
      js.executeScript("window.scrollBy(0,100)");
      test.pass("scrolled tha page");
      wd.findElement(By.xpath("(//*[@id='chooseAndAddBtn'])[1]")).click();
      test.pass("clicked on addactivity button");
      wd.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[2]")).click();
      test.pass("clicked on select button");
      wd.findElement(By.xpath("//*[@class='updatePackageBtnText font10 btn btn-primary btn-sm']")).click();
      test.pass("clicked on update package button");
      wd.findElement(By.xpath("//*[@class='initerary-nav ']/li[2]/b")).click();
      test.pass("clicked on Flights button");
      wd.findElement(By.xpath("//*[@class='initerary-nav ']/li[3]/b")).click();
      test.pass("clicked on Hotels button");
      wd.findElement(By.xpath("//*[@class='initerary-nav ']/li[4]/b")).click();
      test.pass("clicked on Transfers button");
      wd.findElement(By.xpath("//*[@class='initerary-nav ']/li[5]/b")).click();
      test.pass("clicked on Activities button");
      wd.findElement(By.xpath("//*[@class='initerary-nav ']/li[1]/b")).click();
		test.pass("clicked on 4 Days Plan");


	 js.executeScript("window.scrollBy(0,150)");
		test.pass("Scrolled the Page ");

	 Thread.sleep(3000);
	 js.executeScript("window.scrollBy(0,150)");
		test.pass("Scrolled the Page ");
		
		}
	 @AfterTest
	 public void test5() {
		 Set<String> str=wd.getWindowHandles();
		 for (String window:str){
			 wd.switchTo().window(window);
			wd.close();
			 raama.flush();
			 test.pass("closed the browser");
			 
		 }
	 }
}





