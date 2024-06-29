package e_commerce_project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Steps {
	static WebDriver driver=new FirefoxDriver();
	public static void setup() throws InterruptedException{
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		
	}
     public static void search_for_product() throws InterruptedException{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
	    driver.findElement(By.xpath("//li[@id='p_n_feature_twenty-nine_browse-bin/81332994031']//i[@class='a-icon a-icon-checkbox']")).click();
	    Thread.sleep(1500);
	    
	    driver.findElement(By.linkText("Apple iPhone 13 (128GB) - Green")).click();
	    Thread.sleep(5000);
	    
	    Set<String> s=driver.getWindowHandles();
	    ArrayList ar=new ArrayList(s);
	    System.out.println(ar.get(0));
	    System.out.println(ar.get(1));
	    driver.switchTo().window((String)ar.get(1));
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
        
	    Thread.sleep(5000);
	    
	    

	}
	
	
	
	
	public static void stop() {
		driver.quit();
	}
	

	public static void main(String[] args) throws InterruptedException {
		setup();
		search_for_product();
		stop();
	}

}
