package testVig_Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovieInformationValidation {
	
	@Test
	public void imdbTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.imdb.com/title/tt9389998/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int y = driver.findElement(By.xpath("//span[.='Details']")).getLocation().getY();
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,"+y+")");
		
		String text = driver.findElement(By.xpath("//a[.='Release date']/following-sibling::div")).getText();
		System.out.println("Release Date:-"+text);
		
		String imdbCountryText = driver.findElement(By.xpath("//button[.='Country of origin']/following-sibling::div")).getText();
		System.out.println("Country of origin:-"+imdbCountryText);
		
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		int y1 = driver.findElement(By.xpath("//span[@id='Plot']")).getLocation().getY();
		JavascriptExecutor j1 = (JavascriptExecutor)driver;
		j1.executeScript("window.scrollBy(0,"+y1+")");
		
		String Text = driver.findElement(By.xpath("//tbody//div[.='Release date']/following::div[@class='plainlist']/descendant::li")).getText();
		System.out.println("Release Date:-"+Text);
		
		String wikiCountryText = driver.findElement(By.xpath("//tbody//td[.='India']")).getText();
		System.out.println("Country:-"+wikiCountryText);
		
		

		if (imdbCountryText.equals(wikiCountryText)) {
			System.out.println("Successfully----> TC is Pass");
		} else {
			System.out.println(" ----> TC is fail");
		}
		
		
		
		
		
		
	}

}
